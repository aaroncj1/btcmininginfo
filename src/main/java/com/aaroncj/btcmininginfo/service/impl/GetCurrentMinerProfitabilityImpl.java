package com.aaroncj.btcmininginfo.service.impl;

import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.GetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.GetCurrentMinerProfitability;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;
import java.util.function.BiFunction;
import org.springframework.stereotype.Component;

@Component
public class GetCurrentMinerProfitabilityImpl implements GetCurrentMinerProfitability {

  private final GetCurrentHashPrice getCurrentHashPrice;
  private final BiFunction<BitcoinHashPriceDto, MinerDataInputDto, MinerProfitabilityResponse>
      bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper;

  public GetCurrentMinerProfitabilityImpl(
      GetCurrentHashPrice getCurrentHashPrice,
      BiFunction<BitcoinHashPriceDto, MinerDataInputDto, MinerProfitabilityResponse>
          bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper) {
    this.getCurrentHashPrice = getCurrentHashPrice;
    this.bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper;
  }

  @Override
  public MinerProfitabilityResponse execute(MinerDataInputDto minerDataInputDto) {

    try {
      BitcoinHashPriceDto bitcoinHashPriceDto = getCurrentHashPrice.execute();
      return bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
          bitcoinHashPriceDto, minerDataInputDto);
    } catch (UnableToGetCurrentHashPrice e) {
      System.out.println("Cant get hashprice : " + e);
      return null;
    }
  }
}
