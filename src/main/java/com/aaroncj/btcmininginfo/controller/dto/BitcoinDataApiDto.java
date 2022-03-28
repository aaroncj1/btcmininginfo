package com.aaroncj.btcmininginfo.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class BitcoinDataApiDto {

  private String bitcoinPrice;

  private String hashrate;

  private String hashPriceDollars;

  private String hashPriceSats;

  public BitcoinDataApiDto() {}

  public BitcoinDataApiDto(
      String bitcoinPrice, String hashrate, String hashPriceDollars, String hashPriceSats) {
    this.bitcoinPrice = bitcoinPrice;
    this.hashrate = hashrate;
    this.hashPriceDollars = hashPriceDollars;
    this.hashPriceSats = hashPriceSats;
  }

  public String getBitcoinPrice() {
    return bitcoinPrice;
  }

  public void setBitcoinPrice(String bitcoinPrice) {
    this.bitcoinPrice = bitcoinPrice;
  }

  public String getHashrate() {
    return hashrate;
  }

  public void setHashrate(String hashrate) {
    this.hashrate = hashrate;
  }

  public String getHashPriceDollars() {
    return hashPriceDollars;
  }

  public void setHashPriceDollars(String hashPriceDollars) {
    this.hashPriceDollars = hashPriceDollars;
  }

  public String getHashPriceSats() {
    return hashPriceSats;
  }

  public void setHashPriceSats(String hashPriceSats) {
    this.hashPriceSats = hashPriceSats;
  }
}
