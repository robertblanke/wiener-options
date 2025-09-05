package com.github.robertblanke.wiener_options_api.service;

import com.github.robertblanke.wiener_options_api.dto.OptionEvaluationDto;

/** Service interface for evaluating financial options. */
public interface OptionEvaluationService {

  /**
   * Evaluates a financial option using simulation.
   *
   * @param numberOfPaths the number of simulation paths to use
   * @param spotPrice the current price of the underlying asset
   * @param riskFreeRate the risk-free interest rate
   * @param assetVolatility the volatility of the underlying asset
   * @param timeStep the time increment for each simulation step
   * @param numberOfTimeSteps the total number of time steps in the simulation
   * @return an {@link OptionEvaluationDto} containing the evaluation results
   */
  OptionEvaluationDto evaluate(
      int numberOfPaths,
      float spotPrice,
      float riskFreeRate,
      float assetVolatility,
      float timeStep,
      int numberOfTimeSteps);
}
