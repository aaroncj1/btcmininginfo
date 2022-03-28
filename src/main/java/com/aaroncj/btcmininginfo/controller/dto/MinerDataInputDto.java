package com.aaroncj.btcmininginfo.controller.dto;

public class MinerDataInputDto {

  private String days;
  private String pricePerKWH;
  private String terahash;
  private String totalWattage;
  private String wattsPerTerahash;

  public MinerDataInputDto() {}

  public MinerDataInputDto(
      String days,
      String pricePerKWH,
      String terahash,
      String totalWattage,
      String wattsPerTerahash) {
    this.days = days;
    this.pricePerKWH = pricePerKWH;
    this.terahash = terahash;
    this.totalWattage = totalWattage;
    this.wattsPerTerahash = wattsPerTerahash;
  }

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public String getPricePerKWH() {
    return pricePerKWH;
  }

  public void setPricePerKWH(String pricePerKWH) {
    this.pricePerKWH = pricePerKWH;
  }

  public String getTerahash() {
    return terahash;
  }

  public void setTerahash(String terahash) {
    this.terahash = terahash;
  }

  public String getTotalWattage() {
    return totalWattage;
  }

  public void setTotalWattage(String totalWattage) {
    this.totalWattage = totalWattage;
  }

  public String getWattsPerTerahash() {
    return wattsPerTerahash;
  }

  public void setWattsPerTerahash(String wattsPerTerahash) {
    this.wattsPerTerahash = wattsPerTerahash;
  }
}
