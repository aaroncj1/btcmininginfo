package com.aaroncj.btcmininginfo.proxy.integration;

import com.aaroncj.btcmininginfo.proxy.BitcoinPriceProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinPriceException;
import com.aaroncj.btcmininginfo.proxy.impl.BitcoinPriceProxyImpl;
import com.aaroncj.btcmininginfo.proxy.mapper.BlockchainPriceMapper;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BitcoinPriceProxyIntegrationTest {

  @Test
  public void getBitcoinPriceProxy() throws UnableToRetrieveBitcoinPriceException {
    RestTemplate restTemplate = new RestTemplate();
    Function<String, String> blockchainPriceMapper = new BlockchainPriceMapper();

    BitcoinPriceProxy bitcoinPriceProxy =
        new BitcoinPriceProxyImpl(blockchainPriceMapper, restTemplate);

    String actual = bitcoinPriceProxy.execute();
    System.out.println("Price: " + actual);
    Assertions.assertDoesNotThrow(bitcoinPriceProxy::execute);
  }
}
