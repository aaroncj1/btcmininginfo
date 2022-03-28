package com.aaroncj.btcmininginfo.proxy.integration;

import com.aaroncj.btcmininginfo.proxy.BitcoinHashrateProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinHashrateException;
import com.aaroncj.btcmininginfo.proxy.impl.BitcoinHashrateProxyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BitcoinHashrateProxyIntegrationTest {

  @Test
  public void getBitcoinPriceProxy() throws UnableToRetrieveBitcoinHashrateException {
    RestTemplate restTemplate = new RestTemplate();

    BitcoinHashrateProxy bitcoinHashrateProxy = new BitcoinHashrateProxyImpl(restTemplate);

    String actual = bitcoinHashrateProxy.execute();
    System.out.println("Hashrate: " + actual);
    Assertions.assertDoesNotThrow(bitcoinHashrateProxy::execute);
  }
}
