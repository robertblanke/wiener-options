package com.github.robertblanke.wiener_options_api.service;

import org.springframework.stereotype.Service;

/** Default implementation of the OptionPayoutService. */
@Service
public class DefaultOptionPayoutService implements OptionPayoutService {

  @Override
  public float[] calculatePayouts(
      final float[] underlyingPrices,
      final float spotPrice,
      final float riskFreeRate,
      final float timeToMaturity) {

    final float[] payouts = new float[underlyingPrices.length];

    for (int i = 0; i < payouts.length; i++) {
      payouts[i] =
          calculateDiscountedCallPayout(
              underlyingPrices[i], spotPrice, riskFreeRate, timeToMaturity);
    }

    return payouts;
  }

  /**
   * Calculates the discounted payout for a European call option.
   *
   * @param finalPrice the price of the underlying asset at maturity
   * @param spotPrice the spot price of the underlying asset
   * @param riskFreeRate the risk-free interest rate
   * @param timeToMaturity time to maturity of the option in years
   * @return the discounted payout of the call option
   */
  private float calculateDiscountedCallPayout(
      final float finalPrice,
      final float spotPrice,
      final float riskFreeRate,
      final float timeToMaturity) {

    final float difference = finalPrice - spotPrice;

    if (difference > 0) {
      return (float) (difference * Math.exp(-riskFreeRate * timeToMaturity));
    }

    return 0.0f;
  }
}
