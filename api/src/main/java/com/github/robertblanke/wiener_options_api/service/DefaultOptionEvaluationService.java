package com.github.robertblanke.wiener_options_api.service;

import com.github.robertblanke.wiener_options_api.dto.OptionEvaluationDto;
import com.github.robertblanke.wiener_options_api.service.parameter.WienerProcessParameters;
import org.springframework.stereotype.Service;

/** Default implementation of the OptionEvaluationService interface. */
@Service
public class DefaultOptionEvaluationService implements OptionEvaluationService {

  @Override
  public OptionEvaluationDto evaluate(
      int numberOfPaths, WienerProcessParameters wienerProcessParameters) {
    return null;
  }
}
