package com.company;


// Counting-Sort implementation. may

public class CountingSort {
    private int[] data;
    private int[] occurrences;
    private int[] cumulative;
    private int[] sorted;
    private int absval;

    CountingSort(int[] A, int[] range) {
        this.data = A;
        this.absval = Math.abs(range[0]);
        int totrange = absval + range[1];
        for (int i = 0; i < data.length; i++) {
            data[i] += absval;
        }

        this.occurrences = new int[totrange + 1];
        this.cumulative = new int[totrange + 1];
        this.sorted = new int[data.length];
    }

    public int[] sort() {
        // Step one: Count occurrences
        for (int element : data) {
            occurrences[element]++;
        }
        // Step two: Create cumulative occurrences list
        cumulative[0] = occurrences[0];
        for (int i = 1; i < occurrences.length; i++) {
            cumulative[i] = occurrences[i] + cumulative[i - 1];
        }
        // Step three: Sort!
        for (int element : data) {
            sorted[cumulative[element]-- - 1] = element;
        }
        // Extra step, subtract offset
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] -= this.absval;
        }
        return sorted;
    }
}
