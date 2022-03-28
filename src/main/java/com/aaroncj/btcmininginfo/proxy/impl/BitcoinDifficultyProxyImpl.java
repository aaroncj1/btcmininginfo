package com.aaroncj.btcmininginfo.proxy.impl;

import com.aaroncj.btcmininginfo.proxy.BitcoinDifficultyProxy;
import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinDifficultyException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BitcoinDifficultyProxyImpl implements BitcoinDifficultyProxy {

  private final RestTemplate restTemplate;

  public BitcoinDifficultyProxyImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public String execute() throws UnableToRetrieveBitcoinDifficultyException {
    try {
      return restTemplate.getForObject("https://blockchain.info/q/hashrate", String.class);
    } catch (Exception e) {
      System.out.println("Exception occurred calling Blockchain.com : " + e);
      throw new UnableToRetrieveBitcoinDifficultyException(e);
    }
  }
}
