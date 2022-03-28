package com.aaroncj.btcmininginfo.service.dto.builder.impl;

import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.dto.builder.BitcoinHashPriceDtoBuilder;
import com.aaroncj.btcmininginfo.service.dto.impl.BitcoinHashPriceDtoImpl;

public class BitcoinHashPriceDtoBuilderImpl implements BitcoinHashPriceDtoBuilder {

  private String hashrate;
  private String hashPriceDollars;
  private String hashPriceSats;
  private String price;

  @Override
  public BitcoinHashPriceDto build() {

    return new BitcoinHashPriceDtoImpl(
        this.hashrate, this.hashPriceDollars, this.hashPriceSats, this.price);
  }

  @Override
  public BitcoinHashPriceDtoBuilder setHashrate(String hashrate) {
    this.hashrate = hashrate;
    return this;
  }

  @Override
  public BitcoinHashPriceDtoBuilder setHashPriceDollars(String hashPriceDollars) {
    this.hashPriceDollars = hashPriceDollars;
    return this;
  }

  @Override
  public BitcoinHashPriceDtoBuilder setHashPriceSats(String hashPriceSats) {
    this.hashPriceSats = hashPriceSats;
    return this;
  }

  @Override
  public BitcoinHashPriceDtoBuilder setPrice(String price) {
    this.price = price;
    return this;
  }
}
