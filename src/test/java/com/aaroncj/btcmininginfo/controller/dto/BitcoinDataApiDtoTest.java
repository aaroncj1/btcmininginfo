package com.aaroncj.btcmininginfo.controller.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitcoinDataApiDtoTest {

  @Test
  public void get_set_bitcoinPrice() {
    String expected = "bitcoinPrice";
    BitcoinDataApiDto bitcoinDataApiDto = new BitcoinDataApiDto();

    bitcoinDataApiDto.setBitcoinPrice(expected);

    Assertions.assertEquals(expected, bitcoinDataApiDto.getBitcoinPrice());
  }

  @Test
  public void get_set_difficulty() {
    String expected = "difficulty";
    BitcoinDataApiDto bitcoinDataApiDto = new BitcoinDataApiDto();

    bitcoinDataApiDto.setDifficulty(expected);

    Assertions.assertEquals(expected, bitcoinDataApiDto.getDifficulty());
  }

  @Test
  public void get_set_hashPriceDollars() {
    String expected = "hashPriceDollars";
    BitcoinDataApiDto bitcoinDataApiDto = new BitcoinDataApiDto();

    bitcoinDataApiDto.setHashPriceDollars(expected);

    Assertions.assertEquals(expected, bitcoinDataApiDto.getHashPriceDollars());
  }

  @Test
  public void get_set_hashPriceSats() {
    String expected = "hashPriceSats";
    BitcoinDataApiDto bitcoinDataApiDto = new BitcoinDataApiDto();

    bitcoinDataApiDto.setHashPriceSats(expected);

    Assertions.assertEquals(expected, bitcoinDataApiDto.getHashPriceSats());
  }

  @Test
  public void allArgsConstructor() {
    String bitcoinPrice = "bitcoinPrice";
    String difficulty = "difficulty";
    String hashPriceDollars = "hashPriceDollars";
    String hashPriceSats = "hashPriceSats";

    BitcoinDataApiDto bitcoinDataApiDto =
        new BitcoinDataApiDto(bitcoinPrice, difficulty, hashPriceDollars, hashPriceSats);

    Assertions.assertEquals(bitcoinPrice, bitcoinDataApiDto.getBitcoinPrice());
    Assertions.assertEquals(difficulty, bitcoinDataApiDto.getDifficulty());
    Assertions.assertEquals(hashPriceDollars, bitcoinDataApiDto.getHashPriceDollars());
    Assertions.assertEquals(hashPriceSats, bitcoinDataApiDto.getHashPriceSats());
  }
}
