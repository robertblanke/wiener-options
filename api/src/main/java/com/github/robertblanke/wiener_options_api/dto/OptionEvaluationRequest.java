package com.github.robertblanke.wiener_options_api.dto;

/**
 * Request object containing the parameters for evaluating a financial option.
 *
 * @param numberOfPaths the number of simulation paths to use
 * @param spotPrice the current price of the underlying asset
 * @param riskFreeRate the risk-free interest rate
 * @param assetVolatility the volatility of the underlying asset
 * @param timeStep the time increment for each simulation step
 * @param numberOfTimeSteps the total number of time steps in the simulation
 */
public record OptionEvaluationRequest(
    int numberOfPaths,
    float spotPrice,
    float riskFreeRate,
    float assetVolatility,
    float timeStep,
    int numberOfTimeSteps) {}
