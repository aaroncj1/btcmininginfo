package com.aaroncj.btcmininginfo.service.mapper;

import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import org.springframework.stereotype.Component;

@Component
public class BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
    implements BiFunction<BitcoinHashPriceDto, MinerDataInputDto, MinerProfitabilityResponse> {

  private final MinerProfitabilityResponse minerProfitabilityResponse;

  public BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
      MinerProfitabilityResponse minerProfitabilityResponse) {
    this.minerProfitabilityResponse = minerProfitabilityResponse;
  }

  @Override
  public MinerProfitabilityResponse apply(
      BitcoinHashPriceDto bitcoinHashPriceDto, MinerDataInputDto minerDataInputDto) {
    double days =
        minerDataInputDto.getDays() != null ? Double.parseDouble(minerDataInputDto.getDays()) : 1;

    double revenueDollars =
        calculateRevenue(
            Double.parseDouble(minerDataInputDto.getTerahash()),
            Double.parseDouble(bitcoinHashPriceDto.getHashPriceDollars()));

    double costDollars =
        calculateCost(
            Double.parseDouble(minerDataInputDto.getPricePerKWH()),
            Double.parseDouble(minerDataInputDto.getTotalWattage()));

    double profitDollars = calculateProfit(revenueDollars, costDollars);

    double revenueSats =
        dollarsToSats(revenueDollars, Double.parseDouble(bitcoinHashPriceDto.getPrice()));

    double profitSats =
        dollarsToSats(profitDollars, Double.parseDouble(bitcoinHashPriceDto.getPrice()));

    minerProfitabilityResponse.setRevenueDollars(multiplyByDaysAndFormat(revenueDollars, days));
    minerProfitabilityResponse.setElectricCost(multiplyByDaysAndFormat(costDollars, days));
    minerProfitabilityResponse.setProfitDollars(multiplyByDaysAndFormat(profitDollars, days));
    minerProfitabilityResponse.setRevenueSats(multiplyByDaysAndFormat(revenueSats, days));
    minerProfitabilityResponse.setProfitSats(multiplyByDaysAndFormat(profitSats, days));
    return minerProfitabilityResponse;
  }

  private double calculateRevenue(double terahash, double hashprice) {
    return BigDecimal.valueOf(terahash * hashprice).setScale(4, RoundingMode.HALF_UP).doubleValue();
  }

  private double calculateCost(double kwhCost, double wattage) {
    return BigDecimal.valueOf(kwhCost * wattage * 24 / 1000)
        .setScale(4, RoundingMode.HALF_UP)
        .doubleValue();
  }

  private double calculateProfit(double revenue, double cost) {

    return BigDecimal.valueOf(revenue - cost).setScale(4, RoundingMode.HALF_UP).doubleValue();
  }

  private double dollarsToSats(double dollarAmount, double bitcoinPrice) {

    return BigDecimal.valueOf((dollarAmount / bitcoinPrice) * 100000000)
        .setScale(4, RoundingMode.HALF_UP)
        .doubleValue();
  }

  private String multiplyByDaysAndFormat(double dailyUnit, double numberOfDays) {
    return BigDecimal.valueOf((dailyUnit * numberOfDays))
        .setScale(3, RoundingMode.HALF_UP)
        .toString();
  }
}
