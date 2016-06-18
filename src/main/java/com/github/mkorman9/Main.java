package com.github.mkorman9;

import java.util.Random;

public class Main {
    public static void main(final String[] args) {
        final int[] array = new int[Integer.MAX_VALUE / 32];
        final Random random = new Random();

        TestProcedure upwardIteration = () -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt();
            }
        };

        TestProcedure downwardIteration = () -> {
            for (int i = array.length - 1; i >= 0; i--) {
                array[i] = random.nextInt();
            }
        };

        TestProcedure exceptionStop = () -> {
            try {
                for (int i = 0; ; i++) {
                    array[i] = random.nextInt();
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
            }
        };

        upwardIteration.perform().forEach(System.out::println);
        System.out.println();

        downwardIteration.perform().forEach(System.out::println);
        System.out.println();

        exceptionStop.perform().forEach(System.out::println);
        System.out.println();
    }
}
