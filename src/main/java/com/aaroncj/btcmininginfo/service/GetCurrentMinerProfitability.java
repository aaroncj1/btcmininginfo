package com.aaroncj.btcmininginfo.service;

import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentMinerProfitabilityException;

public interface GetCurrentMinerProfitability {

  MinerProfitabilityResponse execute(MinerDataInputDto minerDataInputDto)
      throws UnableToGetCurrentMinerProfitabilityException;
}
