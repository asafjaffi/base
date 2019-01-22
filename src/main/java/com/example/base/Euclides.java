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

  public int euclid(int a, int b) {
    return 0;
  }
}
