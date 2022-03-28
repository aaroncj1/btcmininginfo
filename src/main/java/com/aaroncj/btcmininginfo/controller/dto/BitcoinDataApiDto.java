package com.aaroncj.btcmininginfo.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class BitcoinDataApiDto {

  private String bitcoinPrice;

  private String difficulty;

  private String hashPriceDollars;

  private String hashPriceSats;

  public BitcoinDataApiDto() {}

  public BitcoinDataApiDto(
      String bitcoinPrice, String difficulty, String hashPriceDollars, String hashPriceSats) {
    this.bitcoinPrice = bitcoinPrice;
    this.difficulty = difficulty;
    this.hashPriceDollars = hashPriceDollars;
    this.hashPriceSats = hashPriceSats;
  }

  public String getBitcoinPrice() {
    return bitcoinPrice;
  }

  public void setBitcoinPrice(String bitcoinPrice) {
    this.bitcoinPrice = bitcoinPrice;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
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
