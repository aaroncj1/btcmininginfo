package com.aaroncj.btcmininginfo.proxy;

import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinPriceException;

public interface BitcoinPriceProxy {

  String execute() throws UnableToRetrieveBitcoinPriceException;
}
