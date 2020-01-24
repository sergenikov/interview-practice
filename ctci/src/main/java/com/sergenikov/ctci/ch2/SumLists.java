package com.sergenikov.ctci.ch2;

import java.util.LinkedList;
import java.util.List;

// 2.5
public class SumLists {

  public List<Integer> sumLists(final Node list1, final Node list2) {

    final List<Integer> solution = new LinkedList<>();

    int lastValue = sumLists(list1, list2, solution);
    if (lastValue != 0) {
      solution.add(lastValue);
    }

    return solution;
  }

  private Integer sumLists(final Node list1, final Node list2, final List<Integer> solution) {

    if (list1 == null && list2 == null) {
      return 0;
    }

    int val = this.sumLists(list1.next, list2.next, solution);

    val += list1.value;
    val += list2.value;

    int residual = val % 10;
    solution.add(residual);

    return val >= 10 ? 1 : 0;
  }
}
