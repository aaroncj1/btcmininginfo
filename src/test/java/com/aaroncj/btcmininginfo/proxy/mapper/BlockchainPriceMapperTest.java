package com.aaroncj.btcmininginfo.proxy.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BlockchainPriceMapperTest {

  @Test
  public void apply_returnPrice() {
    String response =
        "{\"symbol\":\"BTC-USD\",\"price_24h\":40815.17,\"volume_24h\":459.12007076,\"last_trade_price\":42035.18}";
    String expected = "42035.18";
    BlockchainPriceMapper blockchainPriceMapper = new BlockchainPriceMapper();
    String actual = blockchainPriceMapper.apply(response);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void apply_returnNull_responseIsNull() {
    String response = "";
    String expected = "";
    BlockchainPriceMapper blockchainPriceMapper = new BlockchainPriceMapper();
    String actual = blockchainPriceMapper.apply(response);
    Assertions.assertEquals(expected, actual);
  }
}
