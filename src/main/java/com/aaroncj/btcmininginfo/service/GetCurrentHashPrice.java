package com.aaroncj.btcmininginfo.service;

import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;

public interface GetCurrentHashPrice {

  BitcoinHashPriceDto execute() throws UnableToGetCurrentHashPrice;
}
