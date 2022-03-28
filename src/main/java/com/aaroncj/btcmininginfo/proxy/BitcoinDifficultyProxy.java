package com.aaroncj.btcmininginfo.proxy;

import com.aaroncj.btcmininginfo.proxy.exception.UnableToRetrieveBitcoinDifficultyException;

public interface BitcoinDifficultyProxy {

  String execute() throws UnableToRetrieveBitcoinDifficultyException;
}
