package com.aaroncj.btcmininginfo.service.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinDifficultyProxy;
import com.aaroncj.btcmininginfo.proxy.BitcoinPriceProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinDifficultyException;
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

  private final BitcoinDifficultyProxy bitcoinDifficultyProxy;
  private final BitcoinPriceProxy bitcoinPriceProxy;

  public GetCurrentHashPriceImpl(
      BitcoinDifficultyProxy bitcoinDifficultyProxy, BitcoinPriceProxy bitcoinPriceProxy) {
    this.bitcoinDifficultyProxy = bitcoinDifficultyProxy;
    this.bitcoinPriceProxy = bitcoinPriceProxy;
  }

  @Override
  public BitcoinHashPriceDto execute() throws UnableToGetCurrentHashPrice {
    try {
      String difficulty = bitcoinDifficultyProxy.execute();
      String price = bitcoinPriceProxy.execute();
      String hashPrice =
          calculateHashPriceDollars(Double.parseDouble(difficulty), Double.parseDouble(price));
      String hashPriceSats = calculateHashPriceSats(Double.parseDouble(difficulty));
      BitcoinHashPriceDtoBuilder bitcoinHashPriceDtoBuilder = new BitcoinHashPriceDtoBuilderImpl();
      return bitcoinHashPriceDtoBuilder
          .setDifficulty(difficulty)
          .setHashPriceDollars(hashPrice)
          .setHashPriceSats(hashPriceSats)
          .setPrice(price)
          .build();
    } catch (UnableToRetrieveBitcoinDifficultyException | UnableToRetrieveBitcoinPriceException e) {
      System.out.println("Unable to get the current hash price data : " + e);
      throw new UnableToGetCurrentHashPrice(e);
    }
  }

  private String calculateHashPriceDollars(
      double difficulty, double price) { // TODO put into BiFunctiom
    double blockReward = 6.31; // TODO get average fees instead of hardcoding
    double blocksPerDay = 144; // constant
    double terahashDifficulty = difficulty / 1000;
    double hashPrice = (price / terahashDifficulty) * blockReward * blocksPerDay;
    double hashPriceTruncated =
        BigDecimal.valueOf(hashPrice).setScale(6, RoundingMode.HALF_UP).doubleValue();

    return String.valueOf(hashPriceTruncated);
  }

  private String calculateHashPriceSats(double difficulty) { // TODO put into BiFunctiom
    double blockReward = 6.31; // TODO get average fees instead of hardcoding
    double blocksPerDay = 144; // constant
    double satsPerBitcoin = 100000000;
    double terahashDifficulty = difficulty / 1000;
    double hashPrice = (satsPerBitcoin / terahashDifficulty) * blockReward * blocksPerDay;
    double hashPriceTruncated =
        BigDecimal.valueOf(hashPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();

    return String.valueOf(hashPriceTruncated);
  }
}
