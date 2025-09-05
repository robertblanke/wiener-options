package com.github.robertblanke.wiener_options_api.service;

import com.github.robertblanke.wiener_options_api.dto.OptionEvaluationDto;
import com.github.robertblanke.wiener_options_api.service.parameter.WienerProcessParameters;

/** Service interface for evaluating financial options. */
public interface OptionEvaluationService {

  /**
   * Evaluates a financial option using simulation.
   *
   * @param numberOfPaths the number of simulation paths to use
   * @param wienerProcessParameters the parameters for simulating the Wiener process
   * @return an {@link OptionEvaluationDto} containing the evaluation results
   */
  OptionEvaluationDto evaluate(int numberOfPaths, WienerProcessParameters wienerProcessParameters);
}
