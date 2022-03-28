package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinPriceProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinPriceException;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class BitcoinPriceProxyImplTest {

  @Mock Function<String, String> blockchainPriceMapper;
  @Mock RestTemplate restTemplate;

  private BitcoinPriceProxy bitcoinPriceProxy;

  @BeforeEach
  public void setUp() {
    bitcoinPriceProxy = new BitcoinPriceProxyImpl(blockchainPriceMapper, restTemplate);
    Mockito.when(
            restTemplate.getForObject(
                "https://api.blockchain.com/v3/exchange/tickers/BTC-USD", String.class))
        .thenReturn("response");
  }

  @Test
  public void execute_returnBitcoinPrice() throws UnableToRetrieveBitcoinPriceException {
    String expected = "mappedResponse";
    Mockito.when(blockchainPriceMapper.apply(Mockito.any())).thenReturn("mappedResponse");

    String actual = bitcoinPriceProxy.execute();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void execute_mapProxyResponseToString() throws UnableToRetrieveBitcoinPriceException {
    String response = "response";
    Mockito.when(blockchainPriceMapper.apply(Mockito.any())).thenReturn("mappedResponse");

    bitcoinPriceProxy.execute();

    Mockito.verify(blockchainPriceMapper).apply(response);
  }

  @Test
  public void execute_throwException_restTemplateThrowsException() {
    Mockito.when(
            restTemplate.getForObject(
                "https://api.blockchain.com/v3/exchange/tickers/BTC-USD", String.class))
        .thenThrow(new RestClientException("rce"));

    Assertions.assertThrows(
        UnableToRetrieveBitcoinPriceException.class, bitcoinPriceProxy::execute);
  }
}
