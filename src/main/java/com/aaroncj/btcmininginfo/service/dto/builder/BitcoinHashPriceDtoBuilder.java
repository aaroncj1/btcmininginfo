package com.aaroncj.btcmininginfo.service.dto.builder;

import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;

public interface BitcoinHashPriceDtoBuilder {

  BitcoinHashPriceDto build();

  BitcoinHashPriceDtoBuilder setHashrate(String hashrate);

  BitcoinHashPriceDtoBuilder setHashPriceDollars(String hashPriceDollars);

  BitcoinHashPriceDtoBuilder setHashPriceSats(String hashPriceSats);

  BitcoinHashPriceDtoBuilder setPrice(String price);
}
