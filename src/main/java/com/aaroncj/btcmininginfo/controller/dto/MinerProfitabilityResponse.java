package com.aaroncj.btcmininginfo.controller.dto;

import org.springframework.stereotype.Component;

@Component
public class MinerProfitabilityResponse {

  private String revenueSats;
  private String revenueDollars;
  private String electricCost;
  private String profitSats;
  private String profitDollars;

  public MinerProfitabilityResponse() {}

  public MinerProfitabilityResponse(
      String revenueSats,
      String revenueDollars,
      String electricCost,
      String profitSats,
      String profitDollars) {
    this.revenueSats = revenueSats;
    this.revenueDollars = revenueDollars;
    this.electricCost = electricCost;
    this.profitSats = profitSats;
    this.profitDollars = profitDollars;
  }

  public String getRevenueSats() {
    return revenueSats;
  }

  public void setRevenueSats(String revenueSats) {
    this.revenueSats = revenueSats;
  }

  public String getRevenueDollars() {
    return revenueDollars;
  }

  public void setRevenueDollars(String revenueDollars) {
    this.revenueDollars = revenueDollars;
  }

  public String getElectricCost() {
    return electricCost;
  }

  public void setElectricCost(String electricCost) {
    this.electricCost = electricCost;
  }

  public String getProfitSats() {
    return profitSats;
  }

  public void setProfitSats(String profitSats) {
    this.profitSats = profitSats;
  }

  public String getProfitDollars() {
    return profitDollars;
  }

  public void setProfitDollars(String profitDollars) {
    this.profitDollars = profitDollars;
  }
}
