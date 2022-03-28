package com.aaroncj.btcmininginfo.proxy.mapper;

import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class BlockchainPriceMapper implements Function<String, String> {

  @Override
  public String apply(String response) {
    if (!response.isBlank() || !response.isEmpty()) {
      String[] extractPrice = response.split("last_trade_price\":");
      String[] removeClosingBracket = extractPrice[1].split("}");
      return removeClosingBracket[0];
    } else return "";
  }
}
