package algorithms.utilities;

import algorithms.interfaces.GreatestCommonDivisorCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreatestCommonDivisorCalculatorImplTest {
  final GreatestCommonDivisorCalculator calculator = new GreatestCommonDivisorCalculatorImpl();

  @Test
  public void itShouldReturnOneForRelativelyPrimeNumbers() {
    final long gcd = calculator.calculateGreatestCommonDivisor(2, 3);
    assertEquals(gcd, 1);
  }

  @Test
  public void itShouldReturnNumberForTwoIdenticalValues() {
    final long input = 3;
    final long gcd = calculator.calculateGreatestCommonDivisor(input, input);
    assertEquals(gcd, input);
  }

  @Test
  public void itShouldReturnGCD() {
    final long gcd = calculator.calculateGreatestCommonDivisor(1071, 462);
    assertEquals(gcd, 21);
  }

  @Test
  public void itShouldReturnNonZeroValueWhenOneInputIsZero() {
    final long input = 1;
    long gcd = calculator.calculateGreatestCommonDivisor(0, input);
    assertEquals(gcd, input);

    gcd = calculator.calculateGreatestCommonDivisor(input, 0);
    assertEquals(gcd, input);
  }
}