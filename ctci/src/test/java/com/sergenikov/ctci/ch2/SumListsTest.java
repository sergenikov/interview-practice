package com.sergenikov.ctci.ch2;

import com.sergenikov.ctci.ch2.Node;
import com.sergenikov.ctci.ch2.SumLists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumListsTest {

  private SumLists sumLists;

  @Before
  public void setup() {
    this.sumLists = new SumLists();
  }

  @Test
  public void test1() {
    Node list1 = new Node(7, new Node(2, null));
    Node list2 = new Node(5, new Node(4, null));

    List<Integer> solution = sumLists.sumLists(list1, list2);
    System.out.println(solution.toString());

    assertEquals(Arrays.asList(6, 2, 1), sumLists.sumLists(list1, list2));
  }

  @Test
  public void test2() {
    Node list1 = new Node(5, null);
    Node list2 = new Node(7, null);

    List<Integer> solution = sumLists.sumLists(list1, list2);
    System.out.println(solution.toString());

    assertEquals(Arrays.asList(2, 1), sumLists.sumLists(list1, list2));
  }

  @Test(expected = NullPointerException.class)
  public void test3() {
    Node list1 = new Node(5, null);
    Node list2 = new Node(7, new Node(3, null));

    List<Integer> solution = sumLists.sumLists(list1, list2);
    System.out.println(solution.toString());
  }
}
