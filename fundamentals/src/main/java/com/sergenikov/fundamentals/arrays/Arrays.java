package com.sergenikov.fundamentals.arrays;

import java.lang.Character;
import java.lang.Math;

public class Arrays {

    public void simpleReverse(int[] a) {

	int n = a.length;
	int buffer;
	int i = 0;
	int j = n - 1;

	while (i <= j) {
	    buffer = a[i];
	    a[i] = a[j];
	    a[j] = buffer;

	    i++;
	    j--;
	}
    }

    // https://www.geeksforgeeks.org/reverse-a-string-without-affecting-special-characters/
    public void reverseWithoutSpecialChars(char[] a) {

	int n = a.length;
	char buffer;
	int i = 0;
	int j = n - 1;

	while (i <= j) {

	    if (this.isSpecialChar(a[i])) {
		i++;
		continue;
	    }

	    if (this.isSpecialChar(a[j])) {
		j--;
		continue;
	    }
	    
	    buffer = a[i];
	    a[i] = a[j];
	    a[j] = buffer;

	    i++;
	    j--;
	}
    }

    private boolean isSpecialChar(char c) {
	return !Character.isAlphabetic((int) c);
    }

    public void mergeSort(int[] a) {
	this.mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int lo, int hi) {
	if (lo < hi) {
	    int m = (lo + hi) / 2;
	    
	    this.mergeSort(a, lo, m);
	    this.mergeSort(a, m + 1, hi);
	    
	    this.merge(a, lo, m, hi);
	}
    }

    private void merge(int[] a, int lo, int mid, int hi) {

	int[] k = new int[mid - lo + 1];
	int[] m = new int[hi - mid];

	int kp = 0; // index into array k
	int mp = 0; // index into array m

	// copy left of a into k
	for (int i = 0; i < k.length; i++) {
	    k[i] = a[lo + i];
	}

	// copy right of a into m
	for (int i = 0; i < m.length; i++) {
	    m[i] = a[mid + 1 + i];
	}
	
	int i = lo; // index into original array a

	while (kp < k.length && mp < m.length) {

	    if (k[kp] <= m[mp]) {
		a[i] = k[kp];
		kp++;
	    } else {
		a[i] = m[mp];
		mp++;
	    }
	    i++;
	}

	// copy remaining elements from k and m
	while (kp < k.length) {
	    a[i] = k[kp];
	    kp++;
	    i++;
	}

	while (mp < m.length) {
	    a[i] = m[mp];
	    mp++;
	    i++;
	}
    }
    
}
