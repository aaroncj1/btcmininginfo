package com.aaroncj.btcmininginfo.controller.dto.mapper;

import com.aaroncj.btcmininginfo.controller.dto.BitcoinDataApiDto;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BitcoinHashPriceDtoBitcoinDataApiDtoMapperTest {

  @Test
  public void apply_setBitcoinPrice() {
    BitcoinDataApiDto bitcoinDataApiDto = Mockito.mock(BitcoinDataApiDto.class);
    BitcoinHashPriceDto bitcoinHashPriceDto = Mockito.mock(BitcoinHashPriceDto.class);

    BitcoinHashPriceDtoBitcoinDataApiDtoMapper bitcoinHashPriceDtoBitcoinDataApiDtoMapper =
        new BitcoinHashPriceDtoBitcoinDataApiDtoMapper(bitcoinDataApiDto);

    bitcoinHashPriceDtoBitcoinDataApiDtoMapper.apply(bitcoinHashPriceDto);

    Mockito.verify(bitcoinDataApiDto).setBitcoinPrice(bitcoinHashPriceDto.getPrice());
  }

  @Test
  public void apply_setDifficulty() {
    BitcoinDataApiDto bitcoinDataApiDto = Mockito.mock(BitcoinDataApiDto.class);
    BitcoinHashPriceDto bitcoinHashPriceDto = Mockito.mock(BitcoinHashPriceDto.class);

    BitcoinHashPriceDtoBitcoinDataApiDtoMapper bitcoinHashPriceDtoBitcoinDataApiDtoMapper =
        new BitcoinHashPriceDtoBitcoinDataApiDtoMapper(bitcoinDataApiDto);

    bitcoinHashPriceDtoBitcoinDataApiDtoMapper.apply(bitcoinHashPriceDto);

    Mockito.verify(bitcoinDataApiDto).setDifficulty(bitcoinHashPriceDto.getDifficulty());
  }

  @Test
  public void apply_setHashPriceDollars() {
    BitcoinDataApiDto bitcoinDataApiDto = Mockito.mock(BitcoinDataApiDto.class);
    BitcoinHashPriceDto bitcoinHashPriceDto = Mockito.mock(BitcoinHashPriceDto.class);

    BitcoinHashPriceDtoBitcoinDataApiDtoMapper bitcoinHashPriceDtoBitcoinDataApiDtoMapper =
        new BitcoinHashPriceDtoBitcoinDataApiDtoMapper(bitcoinDataApiDto);

    bitcoinHashPriceDtoBitcoinDataApiDtoMapper.apply(bitcoinHashPriceDto);

    Mockito.verify(bitcoinDataApiDto)
        .setHashPriceDollars(bitcoinHashPriceDto.getHashPriceDollars());
  }

  @Test
  public void apply_setHashPriceSats() {
    BitcoinDataApiDto bitcoinDataApiDto = Mockito.mock(BitcoinDataApiDto.class);
    BitcoinHashPriceDto bitcoinHashPriceDto = Mockito.mock(BitcoinHashPriceDto.class);

    BitcoinHashPriceDtoBitcoinDataApiDtoMapper bitcoinHashPriceDtoBitcoinDataApiDtoMapper =
        new BitcoinHashPriceDtoBitcoinDataApiDtoMapper(bitcoinDataApiDto);

    bitcoinHashPriceDtoBitcoinDataApiDtoMapper.apply(bitcoinHashPriceDto);

    Mockito.verify(bitcoinDataApiDto).setHashPriceSats(bitcoinHashPriceDto.getHashPriceSats());
  }
}
