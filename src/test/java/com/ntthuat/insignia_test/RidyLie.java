package com.ntthuat.insignia_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ntthuat
 */
class RidyLie {

    private boolean toArray(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return false;
        }
        if (array2.length > array1.length) {
            return false;
        }
        int checkLength = 0;
        boolean firstMatch = false;
        int markedValue = 0;
        int markedPointArray1 = 0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = markedPointArray1; j < array1.length; j++) {
                // we found first equivalent here
                if (array2[i] == array1[j] && !firstMatch) {
                    firstMatch = true;
                    checkLength++;
                    markedValue = j; // (j - markedValue) is the position of the next value we need to check in array1
                    break;
                }
                // if we found first equivalent and next value is not equal, we reset all flags
                if (array2[i] != array1[j] && i == (j - markedValue) && firstMatch) {
                    firstMatch = false;
                    markedValue = 0;
                    checkLength = 0;
                    i = -1; // we will start array2 from 0
                    markedPointArray1 = j; // we will reset starting point of array1 from j, not from 0
                    break;
                }
                // if we found next equivalent, we'll increase checkLength
                if (array2[i] == array1[j] && i == (j - markedValue)) {
                    checkLength++;
                    break;
                }
            }
        }
        if (checkLength == array2.length) {
            return true;
        }

        return false;
    }

    @Test
    void test1() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {8, 9, 10};

        boolean expected = false;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {3, 4, 5};

        boolean expected = true;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {1, 2, 3};

        boolean expected = true;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {5, 6, 7};

        boolean expected = true;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {6, 7, 8};

        boolean expected = false;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        int[] largeArray = {1, 2, 3, 1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {1, 2, 3, 4};

        boolean expected = true;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test7() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {};

        boolean expected = false;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test8() {
        int[] largeArray = {1, 2, 3, 4, 5, 6, 7};
        int[] subArray = {4, 5, 6, 7, 8, 9, 10, 11};

        boolean expected = false;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }

    @Test
    void test9() {
        int[] largeArray = {1234, 56, -345, 789, 23456, 6745};
        int[] subArray = {56, -345, 789};

        boolean expected = true;
        boolean actual = toArray(largeArray, subArray);

        assertEquals(expected, actual);
    }
}
