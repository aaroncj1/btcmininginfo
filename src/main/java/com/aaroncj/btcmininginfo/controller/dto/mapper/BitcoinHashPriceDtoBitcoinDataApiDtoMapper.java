package com.aaroncj.btcmininginfo.controller.dto.mapper;

import com.aaroncj.btcmininginfo.controller.dto.BitcoinDataApiDto;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class BitcoinHashPriceDtoBitcoinDataApiDtoMapper
    implements Function<BitcoinHashPriceDto, BitcoinDataApiDto> {

  private final BitcoinDataApiDto bitcoinDataApiDto;

  public BitcoinHashPriceDtoBitcoinDataApiDtoMapper(BitcoinDataApiDto bitcoinDataApiDto) {
    this.bitcoinDataApiDto = bitcoinDataApiDto;
  }

  @Override
  public BitcoinDataApiDto apply(BitcoinHashPriceDto bitcoinHashPriceDto) {
    bitcoinDataApiDto.setBitcoinPrice(bitcoinHashPriceDto.getPrice());
    bitcoinDataApiDto.setHashrate(bitcoinHashPriceDto.getHashrate());
    bitcoinDataApiDto.setHashPriceDollars(bitcoinHashPriceDto.getHashPriceDollars());
    bitcoinDataApiDto.setHashPriceSats(bitcoinHashPriceDto.getHashPriceSats());
    return bitcoinDataApiDto;
  }
}
