package com.aaroncj.btcmininginfo.proxy.integration;

import com.aaroncj.btcmininginfo.proxy.BitcoinDifficultyProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinDifficultyException;
import com.aaroncj.btcmininginfo.proxy.impl.BitcoinDifficultyProxyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BitcoinDifficultyProxyIntegrationTest {

  @Test
  public void getBitcoinPriceProxy() throws UnableToRetrieveBitcoinDifficultyException {
    RestTemplate restTemplate = new RestTemplate();

    BitcoinDifficultyProxy bitcoinDifficultyProxy = new BitcoinDifficultyProxyImpl(restTemplate);

    String actual = bitcoinDifficultyProxy.execute();
    System.out.println("Difficulty: " + actual);
    Assertions.assertDoesNotThrow(bitcoinDifficultyProxy::execute);
  }
}
