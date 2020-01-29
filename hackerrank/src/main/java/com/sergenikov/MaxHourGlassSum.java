package com.sergenikov;

import java.lang.Math;

public class MaxHourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
	int max = Integer.MIN_VALUE;

	int n = arr.length;

	// make sure we don't run off the edge of the array
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		max = Math.max(singleHourGlass(arr, i, j), max);
	    }
	}
    
	return max;
    }

    private static int singleHourGlass(int[][] a, int i, int j) {

        int sum = 0;

        if (i + 1 >= a.length) return 0;
        if (j + 1 >= a[0].length) return 0;

        for (int k = j; k < j + 3; k++) {
            sum += a[i][k];
        }

        sum += a[i+1][j+1];

        int m = i + 2;
        
        for (int k = j; k < j + 3; k++) {
            sum += a[m][k];
        }
        
        return sum;
    }
        
}
