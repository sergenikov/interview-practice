package com.sergenikov.fundamentals.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ArraysTest {

    private Arrays fixture;
    
    @Before
    public void setup() {
        this.fixture = new Arrays();
    }

    @Test
    public void simpleReverse_should_reverse_whenEvenArray() {
	int[] input = new int[] {1, 2, 3, 4};
	this.fixture.simpleReverse(input);
	Assert.assertArrayEquals(
		     new int[] {4, 3, 2, 1},
		     input
		     );
	
    }

    @Test
    public void simpleReverse_should_reverse_whenOddArray() {
	int[] input = new int[] {1, 2, 3, 4, 5};
	this.fixture.simpleReverse(input);
	Assert.assertArrayEquals(
		     new int[] {5, 4, 3, 2, 1},
		     input
		     );
	
    }
}
