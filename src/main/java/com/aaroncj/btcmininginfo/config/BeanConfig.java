package com.aaroncj.btcmininginfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean("blockchainDotInfoHashrateUrl")
  public String blockchainDotInfoHashrateUrl() {
    return "https://blockchain.info/q/hashrate";
  }

  @Bean("blockchainDotInfoPriceUrl")
  public String blockchainDotInfoPriceUrl() {
    return "https://api.blockchain.com/v3/exchange/tickers/BTC-USD";
  }
}
