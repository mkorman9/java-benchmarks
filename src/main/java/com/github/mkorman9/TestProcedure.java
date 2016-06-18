package com.github.mkorman9;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface TestProcedure {
    long BENCHMARK_REPEAT = 1000L;

    void run();

    default List<Long> perform() {
        List<Long> timeMeasurements = new ArrayList<>((int)BENCHMARK_REPEAT);
        for (int i = 0; i < BENCHMARK_REPEAT; i++) {
            timeMeasurements.add(measureProcedureTime());
        }
        return timeMeasurements;
    }

    default long measureProcedureTime() {
        long startTime = System.nanoTime();

        run();

        long duration = System.nanoTime() - startTime;
        return duration / 1000000L;
    }
}
