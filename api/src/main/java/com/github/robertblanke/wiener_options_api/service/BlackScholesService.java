package com.github.robertblanke.wiener_options_api.service;

/** Service interface for calculating option prices using the Black-Scholes model. */
public interface BlackScholesService {

  /**
   * Calculates the price of a European option using the Black-Scholes formula.
   *
   * @param isCallOption true for call option, false for put option
   * @param spotPrice current price of the underlying asset
   * @param strikePrice strike price of the option
   * @param riskFreeRate the risk-free interest rate
   * @param assetVolatility volatility of the underlying asset
   * @param maturity time to maturity in years
   * @return the calculated option price
   */
  float evaluate(
      boolean isCallOption,
      float spotPrice,
      float strikePrice,
      float riskFreeRate,
      float assetVolatility,
      float maturity);
}
