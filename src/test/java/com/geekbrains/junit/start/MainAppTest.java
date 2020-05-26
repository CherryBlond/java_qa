package com.geekbrains.junit.start;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {
    @ParameterizedTest
    @MethodSource("findLastFourProvider")
    void findLastFourTest(int[] in, int[] out) {
        MainApp app = new MainApp();
        int[] result = app.findLastFour(in);
        assertArrayEquals(result, out);
    }

    @Test
    void findLastFourExceptionTest() {
        MainApp app = new MainApp();
        Assertions.assertThrows(RuntimeException.class, () -> {
            app.findLastFour(new int[]{1, 1, 1});
        });
    }

    public static Stream<Arguments> findLastFourProvider() {
        return Stream.of(
            Arguments.arguments(new int[]{1, 4, 1}, new int[]{1}),
            Arguments.arguments(new int[]{4, 1, 1}, new int[]{1, 1}),
            Arguments.arguments(new int[]{4, 1, 4, 2}, new int[]{2}),
            Arguments.arguments(new int[]{4, 4, 4}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("checkOnesAndFoursProvider")
    void checkOnesAndFoursTest(int[] in, boolean out) {
        MainApp app = new MainApp();
        boolean result = app.checkOnesAndFours(in);
        assertEquals(result, out);
    }

    public static Stream<Arguments> checkOnesAndFoursProvider() {
        return Stream.of(
            Arguments.arguments(new int[]{1, 1, 1}, false),
            Arguments.arguments(new int[]{4, 4, 4}, false),
            Arguments.arguments(new int[]{1, 4, 3}, false),
            Arguments.arguments(new int[]{3, 4, 1}, false),
            Arguments.arguments(new int[]{1, 4, 1}, true)
        );
    }
}