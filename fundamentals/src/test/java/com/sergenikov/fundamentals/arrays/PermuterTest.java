package com.sergenikov.fundamentals.arrays;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PermuterTest {

    private Permuter fixture;
    
    @Before
    public void setup() {
        this.fixture = new Permuter();
    }

    @Test
    public void permite_should_produceAllPermutations_when_intArrayProvided() {

	final int[] input = new int[] {1, 2, 3};

	final List<int[]> expected = Arrays.asList(
					     new int[] {1,2,3},
					     new int[] {1,3,2},
					     new int[] {2,1,3},
					     new int[] {2,3,1},
					     new int[] {3,2,1},
					     new int[] {3,1,2}
					     );

	final List<int[]> actual = this.fixture.permute(new int[] {1,2,3});

	assertEquals(6, actual.size());
	
	for (int i = 0; i < 6; i++) {
	    Assert.assertArrayEquals(expected.get(i), actual.get(i));
	}
    }

    @Test
    public void permute_should_produceAllPermutations_when_stringIsProvided() {

	String input = "abc";

	final List<String> expected = Arrays.asList(
						    "abc",
						    "acb",
						    "bac",
						    "bca",
						    "cab",
						    "cba"
						    );

	List<String> actual = this.fixture.permute(input);

	assertEquals(expected, actual);
    }
}
