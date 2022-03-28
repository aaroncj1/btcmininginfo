package com.aaroncj.btcmininginfo.proxy;

import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinHashrateException;

public interface BitcoinHashrateProxy {

  String execute() throws UnableToRetrieveBitcoinHashrateException;
}
