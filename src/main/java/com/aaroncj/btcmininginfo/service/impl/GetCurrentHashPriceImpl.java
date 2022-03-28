package com.aaroncj.btcmininginfo.service.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinHashrateProxy;
import com.aaroncj.btcmininginfo.proxy.BitcoinPriceProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinHashrateException;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinPriceException;
import com.aaroncj.btcmininginfo.service.GetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.dto.builder.BitcoinHashPriceDtoBuilder;
import com.aaroncj.btcmininginfo.service.dto.builder.impl.BitcoinHashPriceDtoBuilderImpl;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Component;

@Component
public class GetCurrentHashPriceImpl implements GetCurrentHashPrice {

  private final BitcoinHashrateProxy bitcoinHashrateProxy;
  private final BitcoinPriceProxy bitcoinPriceProxy;

  public GetCurrentHashPriceImpl(
      BitcoinHashrateProxy bitcoinHashrateProxy, BitcoinPriceProxy bitcoinPriceProxy) {
    this.bitcoinHashrateProxy = bitcoinHashrateProxy;
    this.bitcoinPriceProxy = bitcoinPriceProxy;
  }

  @Override
  public BitcoinHashPriceDto execute() throws UnableToGetCurrentHashPrice {
    try {
      String hashrate = bitcoinHashrateProxy.execute();
      String price = bitcoinPriceProxy.execute();
      String hashPrice =
          calculateHashPriceDollars(Double.parseDouble(hashrate), Double.parseDouble(price));
      String hashPriceSats = calculateHashPriceSats(Double.parseDouble(hashrate));
      BitcoinHashPriceDtoBuilder bitcoinHashPriceDtoBuilder = new BitcoinHashPriceDtoBuilderImpl();
      return bitcoinHashPriceDtoBuilder
          .setHashrate(hashrate)
          .setHashPriceDollars(hashPrice)
          .setHashPriceSats(hashPriceSats)
          .setPrice(price)
          .build();
    } catch (UnableToRetrieveBitcoinHashrateException | UnableToRetrieveBitcoinPriceException e) {
      System.out.println("Unable to get the current hash price data : " + e);
      throw new UnableToGetCurrentHashPrice(e);
    }
  }

  private String calculateHashPriceDollars(
      double hashrate, double price) { // TODO put into BiFunctiom
    double blockReward = 6.31; // TODO get average fees instead of hardcoding
    double blocksPerDay = 144; // constant
    double terahashHashrate = hashrate / 1000;
    double hashPrice = (price / terahashHashrate) * blockReward * blocksPerDay;
    double hashPriceTruncated =
        BigDecimal.valueOf(hashPrice).setScale(6, RoundingMode.HALF_UP).doubleValue();

    return String.valueOf(hashPriceTruncated);
  }

  private String calculateHashPriceSats(double hashrate) { // TODO put into BiFunctiom
    double blockReward = 6.31; // TODO get average fees instead of hardcoding
    double blocksPerDay = 144; // constant
    double satsPerBitcoin = 100000000;
    double terahashHashrate = hashrate / 1000;
    double hashPrice = (satsPerBitcoin / terahashHashrate) * blockReward * blocksPerDay;
    double hashPriceTruncated =
        BigDecimal.valueOf(hashPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();

    return String.valueOf(hashPriceTruncated);
  }
}
