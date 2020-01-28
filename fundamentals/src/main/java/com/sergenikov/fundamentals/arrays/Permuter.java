package com.sergenikov.fundamentals.arrays;

import java.util.List;
import java.util.ArrayList;

public class Permuter {

    /*
     * String permuter
     */
    public List<String> permute(String a) {
	List<String> results = new ArrayList<>();
	this.permuteHelper("", a, results);
	return results;
    }

    private void permuteHelper(String prefix, String suffix, List<String> results) {
	if (suffix.length() == 0) {
	    results.add(prefix);
	} else {
	    for (int i = 0; i < suffix.length(); i++) {
		this.permuteHelper(
				   prefix + suffix.charAt(i),
				   suffix.substring(0, i) + suffix.substring(i+1, suffix.length()),
				   results
				   );
	    }
	}
    }
    
    /*
     * int array permuter
     */
    public List<int[]> permute(int[] a) {
	final List<int[]> results = new ArrayList<>();
	this.permuteHelper(a, 0, results);
	return results;
    }

    private void permuteHelper(int[] a, int index, final List<int[]> results) {
	if (index >= a.length) {
	    results.add(a.clone());
	} else {
	    for (int i = index; i < a.length; i++) {
		this.swap(a, index, i);
		this.permuteHelper(a, index + 1, results);
		this.swap(a, index, i);
	    }
	}
    }

    private void swap(final int[] a, int i, int j) {
	int buffer = a[i];
	a[i] = a[j];
	a[j] = buffer;
    }
    
}
