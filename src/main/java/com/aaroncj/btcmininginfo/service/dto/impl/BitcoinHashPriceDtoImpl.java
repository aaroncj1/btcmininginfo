package com.aaroncj.btcmininginfo.service.dto.impl;

import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;

public class BitcoinHashPriceDtoImpl implements BitcoinHashPriceDto {

  private final String hashrate;
  private final String hashPriceDollars;
  private final String hashPriceSats;
  private final String price;

  public BitcoinHashPriceDtoImpl(
      String hashrate, String hashPriceDollars, String hashPriceSats, String price) {
    this.hashrate = hashrate;
    this.hashPriceDollars = hashPriceDollars;
    this.hashPriceSats = hashPriceSats;
    this.price = price;
  }

  @Override
  public String getHashrate() {
    return hashrate;
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
