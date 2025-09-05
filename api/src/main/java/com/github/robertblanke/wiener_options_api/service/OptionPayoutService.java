package com.github.robertblanke.wiener_options_api.service;

/** Service interface for calculating option payouts. */
public interface OptionPayoutService {

  /**
   * Calculates the payouts for a set of underlying asset prices.
   *
   * @param underlyingPrices array of underlying asset prices
   * @param spotPrice the spot price of the underlying asset
   * @param riskFreeRate the risk-free interest rate
   * @param timeToMaturity time to maturity of the option in years
   * @return array of calculated option payouts
   */
  float[] calculatePayouts(
      float[] underlyingPrices, float spotPrice, float riskFreeRate, float timeToMaturity);
}
