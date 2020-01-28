package com.sergenikov.fundamentals.arrays;

import java.lang.Character;

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
    
}
