package com.aaroncj.btcmininginfo.service.mapper;

import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapperTest {

  @Mock private BitcoinHashPriceDto bitcoinHashPriceDto;
  @Mock private MinerDataInputDto minerDataInputDto;
  @Mock private MinerProfitabilityResponse minerProfitabilityResponse;

  private BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
      bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper;

  private MinerProfitabilityResponse expected;

  @BeforeEach
  public void setUp() {
    expected = new MinerProfitabilityResponse("4468.085", "2.100", "2.592", "-1046.809", "-0.492");

    Mockito.when(minerDataInputDto.getTerahash()).thenReturn("10.5");
    Mockito.when(minerDataInputDto.getPricePerKWH()).thenReturn(".12");
    Mockito.when(minerDataInputDto.getTotalWattage()).thenReturn("900");
    Mockito.when(minerDataInputDto.getDays()).thenReturn("1");
    Mockito.when(bitcoinHashPriceDto.getHashPriceDollars()).thenReturn(".2");
    Mockito.when(bitcoinHashPriceDto.getPrice()).thenReturn("47000");

    bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
        new BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
            minerProfitabilityResponse);
  }

  @Test
  public void apply_setRevenueDollars() {
    bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
        bitcoinHashPriceDto, minerDataInputDto);

    Mockito.verify(minerProfitabilityResponse).setRevenueDollars(Mockito.anyString());
  }

  @Test
  public void apply_returnMinerProfitabilityResponseDataElectricalCost() {
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
            new BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
                minerProfitabilityResponse);

    MinerProfitabilityResponse actual =
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
            bitcoinHashPriceDto, minerDataInputDto);

    Assertions.assertEquals(expected.getElectricCost(), actual.getElectricCost());
  }

  @Test
  public void apply_returnMinerProfitabilityResponseDataRevenueSats() {
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
            new BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
                minerProfitabilityResponse);

    MinerProfitabilityResponse actual =
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
            bitcoinHashPriceDto, minerDataInputDto);

    Assertions.assertEquals(expected.getRevenueSats(), actual.getRevenueSats());
  }

  @Test
  public void apply_returnMinerProfitabilityResponseDataRevenueDollars() {
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
            new BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
                minerProfitabilityResponse);

    MinerProfitabilityResponse actual =
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
            bitcoinHashPriceDto, minerDataInputDto);

    Assertions.assertEquals(expected.getRevenueDollars(), actual.getRevenueDollars());
  }

  @Test
  public void apply_returnMinerProfitabilityResponseDataProfitDollars() {
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
            new BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
                minerProfitabilityResponse);

    MinerProfitabilityResponse actual =
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
            bitcoinHashPriceDto, minerDataInputDto);

    Assertions.assertEquals(expected.getProfitDollars(), actual.getProfitDollars());
  }

  @Test
  public void apply_returnMinerProfitabilityResponseDataProfitSats() {
    MinerProfitabilityResponse minerProfitabilityResponse = new MinerProfitabilityResponse();

    BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper =
            new BitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper(
                minerProfitabilityResponse);

    MinerProfitabilityResponse actual =
        bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
            bitcoinHashPriceDto, minerDataInputDto);

    Assertions.assertEquals(expected.getProfitSats(), actual.getProfitSats());
  }
}
