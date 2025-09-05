package com.github.robertblanke.wiener_options_api.service;

import com.github.robertblanke.wiener_options_api.service.parameter.WienerProcessParameters;

/** Service interface for simulating Wiener processes and selecting relevant paths. */
public interface WienerProcessSimulationService {

  /**
   * Simulates multiple Wiener process paths using the Geometric Brownian Motion model.
   *
   * @param numberOfPaths the number of Wiener process paths to simulate
   * @param wienerProcessParameters the parameters for the Wiener process simulation
   * @return a 2D array where each row represents a simulated Wiener process path
   */
  float[][] simulateWienerProcesses(
      int numberOfPaths, WienerProcessParameters wienerProcessParameters);

  /**
   * Selects three relevant Wiener processes from the provided array: the one with the lowest final
   * value, the median final value, and the highest final value.
   *
   * @param wienerProcesses the array of Wiener processes to select from
   * @return an array containing the three selected Wiener processes
   */
  float[][] getRelevantWienerProcesses(float[][] wienerProcesses);
}
