package com.github.robertblanke.wiener_options_api.controller;

import com.github.robertblanke.wiener_options_api.dto.OptionEvaluationDto;
import com.github.robertblanke.wiener_options_api.dto.OptionEvaluationRequest;
import com.github.robertblanke.wiener_options_api.service.OptionEvaluationService;
import com.github.robertblanke.wiener_options_api.service.parameter.WienerProcessParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** REST controller for evaluating financial options. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/evaluate")
public class OptionEvaluationController {

  private final OptionEvaluationService optionEvaluationService;

  @GetMapping("/option")
  public OptionEvaluationDto evaluateOption(@RequestBody final OptionEvaluationRequest request) {

    final WienerProcessParameters wienerProcessParameters =
        new WienerProcessParameters(
            request.spotPrice(),
            request.riskFreeRate(),
            request.assetVolatility(),
            request.timeStep(),
            request.numberOfTimeSteps());

    return optionEvaluationService.evaluate(request.numberOfPaths(), wienerProcessParameters);
  }
}
