package org.alg.sorting;

import java.util.Arrays;

public class MergeSorting {
    public void merge(int[] a, int lo, int hi, int mid) {
        int left = lo, right = mid + 1;
        int[] aux = Arrays.copyOf(a, a.length);
        for (int i = lo; i <= hi; i++){
            if (left > mid) {
                a[i] = aux[right++];
            } else if (right > hi) {
                a[i] = aux[left++];
            } else if (aux[left] < aux[right]) {
                a[i] = aux[left++];
            } else {
                a[i] = aux[right++];
            }
        }
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi -lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, hi, mid);
    }

    public static void main(String[] args) {
        MergeSorting mergeSorting = new MergeSorting();
        int[] array = {3, 5, 34, 67, 68, 89, 93, 1, 4, 9, 11, 54, 71, 99, 44};
        long start = System.nanoTime();
        mergeSorting.sort(array, 0, array.length - 1);
        long estimatedTime = System.nanoTime() - start;
        System.out.println("spend time " + estimatedTime);
        for (int i : array) {
            System.out.println(i);
        }

    }
}
