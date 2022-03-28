package com.aaroncj.btcmininginfo.service.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinDifficultyProxy;
import com.aaroncj.btcmininginfo.proxy.BitcoinPriceProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinDifficultyException;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinPriceException;
import com.aaroncj.btcmininginfo.service.GetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetCurrentHashPriceImplTest {

  @Mock BitcoinDifficultyProxy bitcoinDifficultyProxy;
  @Mock BitcoinPriceProxy bitcoinPriceProxy;

  private GetCurrentHashPrice getCurrentHashPrice;

  @BeforeEach
  public void setUp() throws UnableToRetrieveBitcoinDifficultyException {
    Mockito.when(bitcoinDifficultyProxy.execute()).thenReturn("205200000000");

    getCurrentHashPrice = new GetCurrentHashPriceImpl(bitcoinDifficultyProxy, bitcoinPriceProxy);
  }

  @Test
  public void execute_getBitcoinPriceCalled()
      throws UnableToGetCurrentHashPrice, UnableToRetrieveBitcoinPriceException {
    Mockito.when(bitcoinPriceProxy.execute()).thenReturn("42000");

    getCurrentHashPrice.execute();

    Mockito.verify(bitcoinPriceProxy).execute();
  }

  @Test
  public void execute_getBitcoinDifficultyCalled()
      throws UnableToRetrieveBitcoinDifficultyException, UnableToGetCurrentHashPrice,
          UnableToRetrieveBitcoinPriceException {
    Mockito.when(bitcoinPriceProxy.execute()).thenReturn("42000");

    getCurrentHashPrice.execute();

    Mockito.verify(bitcoinDifficultyProxy).execute();
  }

  @Test
  public void execute_returnBitcoinPrice()
      throws UnableToGetCurrentHashPrice, UnableToRetrieveBitcoinPriceException {
    Mockito.when(bitcoinPriceProxy.execute()).thenReturn("42000");

    BitcoinHashPriceDto actual = getCurrentHashPrice.execute();

    Assertions.assertEquals("0.185979", actual.getHashPriceDollars());
  }

  @Test
  public void execute_throwUnableToGetCurrentHashPrice_UnableToRetrieveBitcoinPriceException()
      throws UnableToRetrieveBitcoinPriceException {
    Mockito.when(bitcoinPriceProxy.execute())
        .thenThrow(UnableToRetrieveBitcoinPriceException.class);

    Assertions.assertThrows(UnableToGetCurrentHashPrice.class, getCurrentHashPrice::execute);
  }

  @Test
  public void execute_throwUnableToGetCurrentHashPrice_UnableToRetrieveBitcoinDifficultyException()
      throws UnableToRetrieveBitcoinDifficultyException {
    Mockito.when(bitcoinDifficultyProxy.execute())
        .thenThrow(UnableToRetrieveBitcoinDifficultyException.class);

    Assertions.assertThrows(UnableToGetCurrentHashPrice.class, getCurrentHashPrice::execute);
  }
}
