package com.sergenikov;

import java.util.Arrays;

public class ArrayLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int n = a.length;

        int[] buffer = Arrays.copyOfRange(a, 0, d);

        for (int i = d; i < n; i++) {
            a[i - d] = a[i];
        }

        for (int i = 0; i < buffer.length; i++) {
            a[n - d + i] = buffer[i];
        }

        return a;

    }

}
