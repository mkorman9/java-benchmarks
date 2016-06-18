package com.github.mkorman9;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    private static final TestProcedure upwardIteration = (int[] array) -> {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
    };

    private static final TestProcedure downwardIteration = (int[] array) -> {
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = random.nextInt();
        }
    };

    private static final TestProcedure exceptionStop = (int[] array) -> {
        try {
            for (int i = 0; ; i++) {
                array[i] = random.nextInt();
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
        }
    };

    private static void performTestForElements(int n) {
        final int[] array = new int[n];

        System.out.printf("%d elements\n--------\n", n);
        upwardIteration.perform(array).forEach(e -> System.out.printf("%d\t", e));
        System.out.println();
        downwardIteration.perform(array).forEach(e -> System.out.printf("%d\t", e));
        System.out.println();
        exceptionStop.perform(array).forEach(e -> System.out.printf("%d\t", e));
        System.out.println("\n");
    }

    public static void main(final String[] args) {
        List<Integer> trials = Arrays.asList(10000, 100000, 1000000, 60000000);
        trials.stream().forEach(Main::performTestForElements);
    }
}
