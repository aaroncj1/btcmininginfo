package com.aaroncj.btcmininginfo.service.dto.impl;

import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.dto.builder.BitcoinHashPriceDtoBuilder;
import com.aaroncj.btcmininginfo.service.dto.builder.impl.BitcoinHashPriceDtoBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitcoinHashPriceDtoImpl_BuilderTest {

  @Test
  public void get_set_difficulty() {
    String expected = "difficulty";
    BitcoinHashPriceDtoBuilder bitcoinHashPriceDtoBuilder = new BitcoinHashPriceDtoBuilderImpl();

    BitcoinHashPriceDto bitcoinHashPriceDto =
        bitcoinHashPriceDtoBuilder.setDifficulty(expected).build();

    Assertions.assertEquals(expected, bitcoinHashPriceDto.getDifficulty());
  }

  @Test
  public void get_set_hashPriceDollars() {
    String expected = "hashPriceDollar";
    BitcoinHashPriceDtoBuilder bitcoinHashPriceDtoBuilder = new BitcoinHashPriceDtoBuilderImpl();

    BitcoinHashPriceDto bitcoinHashPriceDto =
        bitcoinHashPriceDtoBuilder.setHashPriceDollars(expected).build();

    Assertions.assertEquals(expected, bitcoinHashPriceDto.getHashPriceDollars());
  }

  @Test
  public void get_set_hashPriceSats() {
    String expected = "hashPriceSats";
    BitcoinHashPriceDtoBuilder bitcoinHashPriceDtoBuilder = new BitcoinHashPriceDtoBuilderImpl();

    BitcoinHashPriceDto bitcoinHashPriceDto =
        bitcoinHashPriceDtoBuilder.setHashPriceSats(expected).build();

    Assertions.assertEquals(expected, bitcoinHashPriceDto.getHashPriceSats());
  }

  @Test
  public void get_set_price() {
    String expected = "price";
    BitcoinHashPriceDtoBuilder bitcoinHashPriceDtoBuilder = new BitcoinHashPriceDtoBuilderImpl();

    BitcoinHashPriceDto bitcoinHashPriceDto = bitcoinHashPriceDtoBuilder.setPrice(expected).build();

    Assertions.assertEquals(expected, bitcoinHashPriceDto.getPrice());
  }
}
