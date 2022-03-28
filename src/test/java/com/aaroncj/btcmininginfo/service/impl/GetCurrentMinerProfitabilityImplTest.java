package com.aaroncj.btcmininginfo.service.impl;

import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.GetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.GetCurrentMinerProfitability;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GetCurrentMinerProfitabilityImplTest {

  @Mock private GetCurrentHashPrice getCurrentHashPrice;
  @Mock private MinerDataInputDto minerDataInputDto;
  @Mock private BitcoinHashPriceDto bitcoinHashPriceDto;
  @Mock private MinerProfitabilityResponse minerProfitabilityResponse;

  @Mock
  private BiFunction<BitcoinHashPriceDto, MinerDataInputDto, MinerProfitabilityResponse>
      bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper;

  private GetCurrentMinerProfitability getCurrentMinerProfitability;

  @BeforeEach
  public void setUp() throws UnableToGetCurrentHashPrice {
    Mockito.when(getCurrentHashPrice.execute()).thenReturn(bitcoinHashPriceDto);
    Mockito.when(
            bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
                bitcoinHashPriceDto, minerDataInputDto))
        .thenReturn(minerProfitabilityResponse);

    getCurrentMinerProfitability =
        new GetCurrentMinerProfitabilityImpl(
            getCurrentHashPrice,
            bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper);
  }

  @Test
  public void execute_getBitcoinPrice() throws UnableToGetCurrentHashPrice {

    getCurrentMinerProfitability.execute(minerDataInputDto);

    Mockito.verify(getCurrentHashPrice).execute();
  }

  @Test
  public void execute_mapResponse() {

    getCurrentMinerProfitability.execute(minerDataInputDto);

    Mockito.verify(bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper)
        .apply(bitcoinHashPriceDto, minerDataInputDto);
  }

  @Test
  public void execute_returnMiningProfitability() {
    MinerProfitabilityResponse expected = new MinerProfitabilityResponse("1", "2", "3", "4", "5");
    Mockito.when(
            bitcoinHashPriceDtoMinerDataInputDtoMinerProfitabilityResponseMapper.apply(
                bitcoinHashPriceDto, minerDataInputDto))
        .thenReturn(expected);

    MinerProfitabilityResponse actual = getCurrentMinerProfitability.execute(minerDataInputDto);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void execute_catchException() throws UnableToGetCurrentHashPrice {
    Mockito.when(getCurrentHashPrice.execute()).thenThrow(UnableToGetCurrentHashPrice.class);

    Assertions.assertNull(getCurrentMinerProfitability.execute(minerDataInputDto));
  }
}
