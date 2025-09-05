package com.github.robertblanke.wiener_options_api.service;

import com.github.robertblanke.wiener_options_api.service.parameter.WienerProcessParameters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import org.springframework.stereotype.Service;

/** Default implementation of the WienerProcessSimulationService interface. */
@Service
public class DefaultWienerProcessSimulationService implements WienerProcessSimulationService {

  @Override
  public float[][] simulateWienerProcesses(
      final int numberOfPaths, final WienerProcessParameters wienerProcessParameters) {

    final float[][] simulatedPaths =
        new float[numberOfPaths][wienerProcessParameters.numberOfTimeSteps() + 1];

    for (int i = 0; i < simulatedPaths.length; i++) {
      simulatedPaths[i] = simulateWienerProcess(wienerProcessParameters);
    }

    return simulatedPaths;
  }

  /**
   * Simulates a single Wiener process path using the Geometric Brownian Motion model.
   *
   * @param wienerProcessParameters the parameters for the Wiener process simulation
   * @return an array representing the simulated Wiener process path
   */
  private float[] simulateWienerProcess(final WienerProcessParameters wienerProcessParameters) {

    final float[] singlePath = new float[wienerProcessParameters.numberOfTimeSteps() + 1];
    singlePath[0] = wienerProcessParameters.spotPrice();

    final Random random = new Random();

    for (int subPeriod = 0; subPeriod < wienerProcessParameters.numberOfTimeSteps(); subPeriod++) {

      final double randomValue = random.nextGaussian();

      float growthFactor =
          (float)
              Math.exp(
                  (wienerProcessParameters.riskFreeRate()
                              - 0.5 * Math.pow(wienerProcessParameters.assetVolatility(), 2))
                          * wienerProcessParameters.timeStep()
                      + wienerProcessParameters.assetVolatility()
                          * randomValue
                          * Math.sqrt(wienerProcessParameters.timeStep()));

      singlePath[subPeriod + 1] = singlePath[subPeriod] * growthFactor;
    }

    return singlePath;
  }

  @Override
  public float[][] getRelevantWienerProcesses(final float[][] wienerProcesses) {

    final List<WienerProcessWithIndex> sortedProcesses =
        sortWienerProcessesByLastValue(wienerProcesses);

    final float[][] relevantPaths = new float[3][];

    relevantPaths[0] = sortedProcesses.getFirst().getWienerProcess();
    relevantPaths[1] = sortedProcesses.get(wienerProcesses.length / 2).getWienerProcess();
    relevantPaths[2] = sortedProcesses.get(wienerProcesses.length - 1).getWienerProcess();

    return relevantPaths;
  }

  /**
   * Sorts the Wiener processes based on their last value.
   *
   * @param wienerProcesses the array of Wiener processes to be sorted
   * @return a list of WienerProcessWithIndex objects sorted by their last value
   */
  private List<WienerProcessWithIndex> sortWienerProcessesByLastValue(
      final float[][] wienerProcesses) {

    final List<WienerProcessWithIndex> processWithIndexList = new ArrayList<>();

    for (int i = 0; i < wienerProcesses.length; i++) {
      processWithIndexList.add(new WienerProcessWithIndex(i, wienerProcesses[i]));
    }

    processWithIndexList.sort(Comparator.comparingDouble(WienerProcessWithIndex::getLastValue));

    return processWithIndexList;
  }

  /** Class to hold a Wiener process along with its index and last value for sorting purposes. */
  @Getter
  private static class WienerProcessWithIndex {

    /** The index of the Wiener process in the original array. */
    private final int index;

    /** The Wiener process represented as an array. */
    private final float[] wienerProcess;

    /** The last value of the Wiener process, used for sorting. */
    private final float lastValue;

    /**
     * Constructor to initialize the Wiener process with its index and last value.
     *
     * @param index the index of the Wiener process
     * @param wienerProcess the Wiener process array
     */
    public WienerProcessWithIndex(final int index, final float[] wienerProcess) {
      this.index = index;
      this.wienerProcess = wienerProcess;
      this.lastValue = wienerProcess[wienerProcess.length - 1];
    }
  }
}
