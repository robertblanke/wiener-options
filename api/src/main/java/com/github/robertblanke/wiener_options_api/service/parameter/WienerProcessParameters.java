package com.github.robertblanke.wiener_options_api.service.parameter;

/**
 * Parameters for simulating a Wiener process in option pricing models.
 *
 * @param spotPrice the current price of the underlying asset
 * @param riskFreeRate the risk-free interest rate
 * @param assetVolatility the volatility of the underlying asset
 * @param timeStep the time increment for each simulation step
 * @param numberOfTimeSteps the total number of time steps in the simulation
 */
public record WienerProcessParameters(
    float spotPrice,
    float riskFreeRate,
    float assetVolatility,
    float timeStep,
    int numberOfTimeSteps) {}
