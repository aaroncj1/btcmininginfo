package com.aaroncj.btcmininginfo.controller;

import com.aaroncj.btcmininginfo.controller.dto.BitcoinDataApiDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.GetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.GetCurrentMinerProfitability;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentMinerProfitabilityException;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MiningProfitabilityControllerTest {

  @Mock private GetCurrentHashPrice getCurrentHashPrice;
  @Mock private GetCurrentMinerProfitability getCurrentMinerProfitability;

  @Mock private BitcoinDataApiDto bitcoinDataApiDto;

  @Mock private BitcoinHashPriceDto bitcoinHashPriceDto;

  @Mock
  private Function<BitcoinHashPriceDto, BitcoinDataApiDto>
      bitcoinHashPriceDtoBitcoinDataApiDtoMapper;

  private MiningProfitabilityController miningProfitabilityController;

  @BeforeEach
  public void setUp() throws UnableToGetCurrentHashPrice {
    Mockito.when(getCurrentHashPrice.execute()).thenReturn(bitcoinHashPriceDto);
    Mockito.when(bitcoinHashPriceDtoBitcoinDataApiDtoMapper.apply(bitcoinHashPriceDto))
        .thenReturn(bitcoinDataApiDto);

    miningProfitabilityController =
        new MiningProfitabilityController(
            bitcoinHashPriceDtoBitcoinDataApiDtoMapper,
            getCurrentHashPrice,
            getCurrentMinerProfitability);
  }

  @Test
  public void bitcoinMiningProfitabilityPerTeraHash_getHashPriceCalled()
      throws UnableToGetCurrentHashPrice {
    miningProfitabilityController.bitcoinMiningProfitabilityPerTeraHash();

    Mockito.verify(getCurrentHashPrice).execute();
  }

  @Test
  public void bitcoinMiningProfitabilityPerTeraHash_mapBitcoinHashPriceDtoToBitcoinDataApiDto()
      throws UnableToGetCurrentHashPrice {
    miningProfitabilityController.bitcoinMiningProfitabilityPerTeraHash();

    Mockito.verify(bitcoinHashPriceDtoBitcoinDataApiDtoMapper).apply(bitcoinHashPriceDto);
  }

  @Test
  public void bitcoinMiningProfitabilityPerTeraHash_returnBitcoinDataDto()
      throws UnableToGetCurrentHashPrice {
    ResponseEntity<BitcoinDataApiDto> expected = ResponseEntity.ok(bitcoinDataApiDto);

    ResponseEntity<BitcoinDataApiDto> actual =
        miningProfitabilityController.bitcoinMiningProfitabilityPerTeraHash();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void bitcoinMiningProfitabilityByTeraHashWattage_getCurrentMinerProfitability()
      throws UnableToGetCurrentMinerProfitabilityException {
    MinerDataInputDto minerDataInputDto = Mockito.mock(MinerDataInputDto.class);

    miningProfitabilityController.bitcoinMiningProfitabilityByTeraHashWattage(minerDataInputDto);

    Mockito.verify(getCurrentMinerProfitability).execute(minerDataInputDto);
  }

  @Test
  public void bitcoinMiningProfitabilityByTeraHashWattage_returnBitcoinDataDto()
      throws UnableToGetCurrentMinerProfitabilityException {
    MinerDataInputDto minerDataInputDto = Mockito.mock(MinerDataInputDto.class);
    ResponseEntity<MinerProfitabilityResponse> expected = ResponseEntity.ok(null);

    ResponseEntity<MinerProfitabilityResponse> actual =
        miningProfitabilityController.bitcoinMiningProfitabilityByTeraHashWattage(
            minerDataInputDto);

    Assertions.assertEquals(expected, actual);
  }
}
