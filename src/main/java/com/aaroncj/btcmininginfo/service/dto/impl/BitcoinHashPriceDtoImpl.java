package com.aaroncj.btcmininginfo.service.dto.impl;

import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;

public class BitcoinHashPriceDtoImpl implements BitcoinHashPriceDto {

  private final String difficulty;
  private final String hashPriceDollars;
  private final String hashPriceSats;
  private final String price;

  public BitcoinHashPriceDtoImpl(
      String difficulty, String hashPriceDollars, String hashPriceSats, String price) {
    this.difficulty = difficulty;
    this.hashPriceDollars = hashPriceDollars;
    this.hashPriceSats = hashPriceSats;
    this.price = price;
  }

  @Override
  public String getDifficulty() {
    return difficulty;
  }

  @Override
  public String getHashPriceDollars() {
    return hashPriceDollars;
  }

  @Override
  public String getHashPriceSats() {
    return hashPriceSats;
  }

  @Override
  public String getPrice() {
    return price;
  }
}
