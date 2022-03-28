package com.aaroncj.btcmininginfo.controller.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinerProfitabilityResponseTest {

  @Test
  public void get_set_revenueSats() {
    String expected = "revenueSats";
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    minerProfitabilityResponse.setRevenueSats(expected);

    Assertions.assertEquals(expected, minerProfitabilityResponse.getRevenueSats());
  }

  @Test
  public void get_set_revenueDollars() {
    String expected = "revenueDollars";
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    minerProfitabilityResponse.setRevenueDollars(expected);

    Assertions.assertEquals(expected, minerProfitabilityResponse.getRevenueDollars());
  }

  @Test
  public void get_set_electricCost() {
    String expected = "electricCost";
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    minerProfitabilityResponse.setElectricCost(expected);

    Assertions.assertEquals(expected, minerProfitabilityResponse.getElectricCost());
  }

  @Test
  public void get_set_profitSats() {
    String expected = "profitSats";
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    minerProfitabilityResponse.setProfitSats(expected);

    Assertions.assertEquals(expected, minerProfitabilityResponse.getProfitSats());
  }

  @Test
  public void get_set_profitDollars() {
    String expected = "profitDollars";
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    minerProfitabilityResponse.setProfitDollars(expected);

    Assertions.assertEquals(expected, minerProfitabilityResponse.getProfitDollars());
  }

  @Test
  public void allArgsConstructor() {
    String revenueSats = "revenueSats";
    String revenueDollars = "revenueDollars";
    String electricCost = "electricCost";
    String profitSats = "profitSats";
    String profitDollars = "profitDollars";

    MinerProfitabilityResponse minerProfitabilityResponse =
        new MinerProfitabilityResponse(
            revenueSats, revenueDollars, electricCost, profitSats, profitDollars);

    Assertions.assertEquals(revenueSats, minerProfitabilityResponse.getRevenueSats());
    Assertions.assertEquals(revenueDollars, minerProfitabilityResponse.getRevenueDollars());
    Assertions.assertEquals(electricCost, minerProfitabilityResponse.getElectricCost());
    Assertions.assertEquals(profitSats, minerProfitabilityResponse.getProfitSats());
    Assertions.assertEquals(profitDollars, minerProfitabilityResponse.getProfitDollars());
  }
}
