package com.github.robertblanke.wiener_options_api.dto;

public record OptionEvaluationDto(
    float simulatedOptionValue, float[][] wienerProcesses, float blackScholesOptionValue) {}
