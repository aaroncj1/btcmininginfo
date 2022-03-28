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

    minerProfitabilityResponse.setRevenueDollars(String.valueOf(revenueDollars * days));
    minerProfitabilityResponse.setElectricCost(String.valueOf(costDollars * days));
    minerProfitabilityResponse.setProfitDollars(String.valueOf(profitDollars * days));
    minerProfitabilityResponse.setRevenueSats(String.valueOf(revenueSats * days));
    minerProfitabilityResponse.setProfitSats(String.valueOf(profitSats * days));
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
}
