package com.github.robertblanke.wiener_options_api.service;

import com.github.robertblanke.wiener_options_api.dto.OptionEvaluationDto;

public interface OptionEvaluationService {
  OptionEvaluationDto evaluate(
      int numberOfPaths,
      float spotPrice,
      float riskFreeRate,
      float assetVolatility,
      float timeStep,
      int numberOfTimeSteps);
}
