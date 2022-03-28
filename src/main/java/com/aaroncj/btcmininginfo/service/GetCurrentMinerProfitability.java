package com.aaroncj.btcmininginfo.service;

import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;

public interface GetCurrentMinerProfitability {

  MinerProfitabilityResponse execute(MinerDataInputDto minerDataInputDto);
}
