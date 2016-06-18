package com.github.mkorman9;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface TestProcedure {
    long BENCHMARK_REPEAT = 50L;

    void run(int[] array);

    default List<Long> perform(int[] array) {
        List<Long> timeMeasurements = new ArrayList<>((int)BENCHMARK_REPEAT);
        for (int i = 0; i < BENCHMARK_REPEAT; i++) {
            timeMeasurements.add(measureProcedureTime(array));
        }
        return timeMeasurements;
    }

    default long measureProcedureTime(int[] array) {
        long startTime = System.nanoTime();

        run(array);

        long duration = System.nanoTime() - startTime;
        return duration;
    }
}
