package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinHashrateProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinHashrateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BitcoinHashrateProxyImpl implements BitcoinHashrateProxy {

  private final String blockchainDotInfoHashrateUrl;
  private final RestTemplate restTemplate;

  public BitcoinHashrateProxyImpl(
      @Qualifier("blockchainDotInfoHashrateUrl") String blockchainDotInfoHashrateUrl,
      RestTemplate restTemplate) {
    this.blockchainDotInfoHashrateUrl = blockchainDotInfoHashrateUrl;
    this.restTemplate = restTemplate;
  }

  @Override
  public String execute() throws UnableToRetrieveBitcoinHashrateException {
    try {
      return restTemplate.getForObject(blockchainDotInfoHashrateUrl, String.class);
    } catch (Exception e) {
      System.out.println("Exception occurred calling Blockchain.com : " + e);
      throw new UnableToRetrieveBitcoinHashrateException(e);
    }
  }
}
