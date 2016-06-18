package com.github.mkorman9;

import java.util.ArrayList;
import java.util.List;

class TestProcedure {
    private static final long BENCHMARK_REPEAT = 1000L;

    private Runnable procedure;

    TestProcedure(Runnable procedure) {
        this.procedure = procedure;
    }

    List<Long> perform() {
        List<Long> timeMeasurments = new ArrayList<>();
        for (int i = 0; i < BENCHMARK_REPEAT; i++) {
            timeMeasurments.add(measureProcedureTime(procedure));
        }
        return timeMeasurments;
    }

    private static long measureProcedureTime(Runnable procedure) {
        long startTime = System.nanoTime();

        procedure.run();

        long duration = System.nanoTime() - startTime;
        return duration / 1000000L;
    }
}
