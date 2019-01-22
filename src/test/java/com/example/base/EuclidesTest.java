/*
 *  Name: firstName lastName
 *  ID: 0123456789
 */

package com.example.base;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EuclidesTest {

  Euclides e;

  @BeforeTest
  public void setUp() {
    e = new Euclides();
  }

  @Test
  public void testMainInputs() {
    Euclides.main(null);
    Euclides.main(new String[]{"blah", "hey", "yo"});
    Euclides.main(new String[]{"blah", "hey"});
  }

  @Test
  public void testPositiveCases() {
    int[][] cases = {
        {936, 299, 13},
        {0, 0, 999} // leaving this just to show that the test does fail
    };

    for (int[] aCase : cases) {
      ensureCorrect(aCase);
    }
  }

  @Test
  public void testStoppingConditions() {
    int[][] cases = {
        {666, 1, 1},
        {1, 666, 1}};

    for (int[] aCase : cases) {
      ensureCorrect(aCase);
    }
  }

  private void ensureCorrect(int[] aCase) {
    assertThat(
        String.format("%d -- %d", aCase[0], aCase[1]),
        e.euclid(aCase[0], aCase[1]),
        equalTo(aCase[2]));
  }
}
