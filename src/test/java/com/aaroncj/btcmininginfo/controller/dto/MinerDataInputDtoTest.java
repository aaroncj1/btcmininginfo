package com.aaroncj.btcmininginfo.controller.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinerDataInputDtoTest {

  @Test
  public void get_set_days() {
    String expected = "days";
    MinerDataInputDto minerDataInputDto = new MinerDataInputDto();

    minerDataInputDto.setDays(expected);

    Assertions.assertEquals(expected, minerDataInputDto.getDays());
  }

  @Test
  public void get_set_pricePerKWH() {
    String expected = "pricePerKWH";
    MinerDataInputDto minerDataInputDto = new MinerDataInputDto();

    minerDataInputDto.setPricePerKWH(expected);

    Assertions.assertEquals(expected, minerDataInputDto.getPricePerKWH());
  }

  @Test
  public void get_set_terahash() {
    String expected = "terahash";
    MinerDataInputDto minerDataInputDto = new MinerDataInputDto();

    minerDataInputDto.setTerahash(expected);

    Assertions.assertEquals(expected, minerDataInputDto.getTerahash());
  }

  @Test
  public void get_set_TotalWattage() {
    String expected = "TotalWattage";
    MinerDataInputDto minerDataInputDto = new MinerDataInputDto();

    minerDataInputDto.setTotalWattage(expected);

    Assertions.assertEquals(expected, minerDataInputDto.getTotalWattage());
  }

  @Test
  public void get_set_WattsPerTerahash() {
    String expected = "WattsPerTerahash";
    MinerDataInputDto minerDataInputDto = new MinerDataInputDto();

    minerDataInputDto.setWattsPerTerahash(expected);

    Assertions.assertEquals(expected, minerDataInputDto.getWattsPerTerahash());
  }

  @Test
  public void allArgsConstructor() {
    String days = "days";
    String pricePerKWH = "pricePerKWH";
    String terahash = "terahash";
    String TotalWattage = "TotalWattage";
    String WattsPerTerahash = "WattsPerTerahash";

    MinerDataInputDto minerDataInputDto =
        new MinerDataInputDto(days, pricePerKWH, terahash, TotalWattage, WattsPerTerahash);

    Assertions.assertEquals(days, minerDataInputDto.getDays());
    Assertions.assertEquals(pricePerKWH, minerDataInputDto.getPricePerKWH());
    Assertions.assertEquals(terahash, minerDataInputDto.getTerahash());
    Assertions.assertEquals(TotalWattage, minerDataInputDto.getTotalWattage());
    Assertions.assertEquals(WattsPerTerahash, minerDataInputDto.getWattsPerTerahash());
  }
}
