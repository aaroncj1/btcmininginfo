package com.aaroncj.btcmininginfo.controller;

import com.aaroncj.btcmininginfo.controller.dto.BitcoinDataApiDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerDataInputDto;
import com.aaroncj.btcmininginfo.controller.dto.MinerProfitabilityResponse;
import com.aaroncj.btcmininginfo.service.GetCurrentHashPrice;
import com.aaroncj.btcmininginfo.service.GetCurrentMinerProfitability;
import com.aaroncj.btcmininginfo.service.dto.BitcoinHashPriceDto;
import com.aaroncj.btcmininginfo.service.exception.UnableToGetCurrentHashPrice;
import java.util.function.Function;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bitcoin")
public class RestAPIController {

  private final Function<BitcoinHashPriceDto, BitcoinDataApiDto>
      bitcoinHashPriceDtoBitcoinDataApiDtoMapper;
  private final GetCurrentHashPrice getCurrentHashPrice;
  private final GetCurrentMinerProfitability getCurrentMinerProfitability;

  public RestAPIController(
      Function<BitcoinHashPriceDto, BitcoinDataApiDto> bitcoinHashPriceDtoBitcoinDataApiDtoMapper,
      GetCurrentHashPrice getCurrentHashPrice,
      GetCurrentMinerProfitability getCurrentMinerProfitability) {
    this.bitcoinHashPriceDtoBitcoinDataApiDtoMapper = bitcoinHashPriceDtoBitcoinDataApiDtoMapper;
    this.getCurrentHashPrice = getCurrentHashPrice;
    this.getCurrentMinerProfitability = getCurrentMinerProfitability;
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<BitcoinDataApiDto> bitcoinMiningProfitabilityPerTeraHash()
      throws UnableToGetCurrentHashPrice {
    return ResponseEntity.ok(
        bitcoinHashPriceDtoBitcoinDataApiDtoMapper.apply(getCurrentHashPrice.execute()));
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<MinerProfitabilityResponse> bitcoinMiningProfitabilityByTeraHashWattage(
      @RequestBody MinerDataInputDto minerDataInputDto) {
    return ResponseEntity.ok(getCurrentMinerProfitability.execute(minerDataInputDto));
  }
}
