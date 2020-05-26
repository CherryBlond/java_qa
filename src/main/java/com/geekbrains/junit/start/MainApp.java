package com.geekbrains.junit.start;

public class MainApp {
    public int[] findLastFour(int[] numbers) {
        int lastIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 4) {
                lastIndex = i;
            }
        }
        if (lastIndex == -1) {
            throw new RuntimeException();
        }

        int[] result = new int[numbers.length - lastIndex - 1];
        for (int i = lastIndex + 1, j = 0; i < numbers.length; i++, j++) {
            result[j] = numbers[i];
        }
        return result;
    }

    public boolean checkOnesAndFours(int[] numbers) {
        int indexOfOne = -1;
        int indexOfFour = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                indexOfOne = i;
            } else if (numbers[i] == 4) {
                indexOfFour = i;
            } else {
                return false;
            }
        }

        return indexOfOne != -1 && indexOfFour != -1;
    }
}
