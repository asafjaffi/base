/*
 *  Name: firstName lastName
 *  ID: 0123456789
 */

package com.example.base;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.base.EuclidesTest.TestLogger;
import java.util.Arrays;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestLogger.class)
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
        {34, 36, 2}
    };

    ensureCorrect(cases);
  }

  @Test
  public void testStoppingConditions() {
    int[][] cases = {
        {666, 1, 1},
        {1, 666, 1}};

    ensureCorrect(cases);
  }

  private void ensureCorrect(int[][] cases) {
    for (int i = 0; i < cases.length; i++) {
      int[] aCase = cases[i];
      System.out.println(String.format("---=== %d. %s ===---", (i + 1), Arrays.toString(aCase)));
      ensureCorrect(aCase);
    }
  }

  private void ensureCorrect(int[] aCase) {
    assertThat(
        String.format("%d -- %d", aCase[0], aCase[1]),
        e.euclid(aCase[0], aCase[1]),
        equalTo(aCase[2]));
  }

  public static class TestLogger implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
      System.out.println(String.format("\n---===### Testing: %s ###===---",
          iInvokedMethod.getTestMethod().getMethodName()));
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
      // do nothing
    }
  }
}
