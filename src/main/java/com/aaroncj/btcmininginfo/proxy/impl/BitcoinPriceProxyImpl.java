package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinPriceProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinPriceException;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BitcoinPriceProxyImpl implements BitcoinPriceProxy {

  private final String blockchainDotInfoPriceUrl;
  private final Function<String, String> blockchainPriceMapper;
  private final RestTemplate restTemplate;

  public BitcoinPriceProxyImpl(
      @Qualifier("blockchainDotInfoPriceUrl") String blockchainDotInfoPriceUrl,
      Function<String, String> blockchainPriceMapper,
      RestTemplate restTemplate) {
    this.blockchainDotInfoPriceUrl = blockchainDotInfoPriceUrl;
    this.blockchainPriceMapper = blockchainPriceMapper;
    this.restTemplate = restTemplate;
  }

  @Override
  public String execute() throws UnableToRetrieveBitcoinPriceException {
    String response;
    try {
      response = restTemplate.getForObject(blockchainDotInfoPriceUrl, String.class);
    } catch (Exception e) {
      System.out.println("Exception occurred calling Blockchain.com : " + e);
      throw new UnableToRetrieveBitcoinPriceException(e);
    }
    return blockchainPriceMapper.apply(response);
  }
}
