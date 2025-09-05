package com.github.robertblanke.wiener_options_api.dto;

/**
 * Data transfer object representing the evaluation of an option.
 *
 * @param simulatedOptionValue The option value estimated by simulation.
 * @param wienerProcesses The simulated Wiener processes used in the evaluation.
 * @param blackScholesOptionValue The option value calculated using the Black-Scholes model.
 */
public record OptionEvaluationDto(
    float simulatedOptionValue, float[][] wienerProcesses, float blackScholesOptionValue) {}
