package com.example.base;/*
 *  Name: firstName lastName
 *  ID: 0123456789
 */

public class Euclides {

  public static void main(String[] args) {
    if (args == null || args.length != 2) {
      System.out.println(
          "Error: expecting 2 parameters, got " + (args == null ? "0" : args.length));
      return;
    }

    int[] input = new int[2];

    for (int i = 0; i < input.length; i++) {
      if (!args[i].matches("[0-9]+")) {
        System.out.println("Error: expecting a number, but got: " + args[i]);
        return;
      }
      input[i] = Integer.parseInt(args[i]);
    }

    System.out.println(new Euclides().euclid(input[0], input[1]));
  }

  /**
   * Computes greatest common divider.
   *
   * @param a first integer
   * @param b second integer
   * @return greatest common divider of <a, b>
   */
  public int euclid(int a, int b) {
    // let's ensure that a is bigger:
    if (a < b) {
      return euclid(b, a);
    }

    int div = a / b;
    int diff = a - (b * div);

    System.out.println(String.format("%d = %d X %d + %d", a, div, b, diff));

    if (diff == 0) {
      return b;
    }
    return euclid(b, diff);
  }
}
