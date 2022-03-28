package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinDifficultyProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinDifficultyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

class BitcoinDifficultyProxyImplTest {

  @Test
  public void execute_returnDifficulty() throws UnableToRetrieveBitcoinDifficultyException {
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    String expected = "response";
    Mockito.when(restTemplate.getForObject("https://blockchain.info/q/hashrate", String.class))
        .thenReturn(expected);
    BitcoinDifficultyProxy bitcoinDifficultyProxy = new BitcoinDifficultyProxyImpl(restTemplate);
    String actual = bitcoinDifficultyProxy.execute();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void execute_throwException_restTemplateThrowsException() {
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    Mockito.when(restTemplate.getForObject("https://blockchain.info/q/hashrate", String.class))
        .thenThrow(new RestClientException("EXCEPTION"));
    BitcoinDifficultyProxy bitcoinDifficultyProxy = new BitcoinDifficultyProxyImpl(restTemplate);
    Assertions.assertThrows(
        UnableToRetrieveBitcoinDifficultyException.class, bitcoinDifficultyProxy::execute);
  }
}
