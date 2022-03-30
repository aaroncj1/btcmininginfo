package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinHashrateProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinHashrateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

class BitcoinHashrateProxyImplTest {

  private static final String blockchainDotInfoHashrateUrl = "https://blockchain.info/q/hashrate";

  @Test
  public void execute_returnHashrate() throws UnableToRetrieveBitcoinHashrateException {
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    String expected = "response";
    Mockito.when(restTemplate.getForObject(blockchainDotInfoHashrateUrl, String.class))
        .thenReturn(expected);
    BitcoinHashrateProxy bitcoinHashrateProxy =
        new BitcoinHashrateProxyImpl(blockchainDotInfoHashrateUrl, restTemplate);
    String actual = bitcoinHashrateProxy.execute();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void execute_throwException_restTemplateThrowsException() {
    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    Mockito.when(restTemplate.getForObject(blockchainDotInfoHashrateUrl, String.class))
        .thenThrow(new RestClientException("EXCEPTION"));
    BitcoinHashrateProxy bitcoinHashrateProxy =
        new BitcoinHashrateProxyImpl(blockchainDotInfoHashrateUrl, restTemplate);
    Assertions.assertThrows(
        UnableToRetrieveBitcoinHashrateException.class, bitcoinHashrateProxy::execute);
  }
}
