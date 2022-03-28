package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinHashrateProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinHashrateException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BitcoinHashrateProxyImpl implements BitcoinHashrateProxy {

  private final RestTemplate restTemplate;

  public BitcoinHashrateProxyImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public String execute() throws UnableToRetrieveBitcoinHashrateException {
    try {
      return restTemplate.getForObject("https://blockchain.info/q/hashrate", String.class);
    } catch (Exception e) {
      System.out.println("Exception occurred calling Blockchain.com : " + e);
      throw new UnableToRetrieveBitcoinHashrateException(e);
    }
  }
}
