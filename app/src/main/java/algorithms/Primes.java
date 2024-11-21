package algorithms;
import java.util.ArrayList;

import java.util.Vector;

public class Primes {
  /**
   * Checks if a number is prime
   *
   * @param n The number to check.
   * @return True if the number is prime, false otherwise.
   */
  public static boolean IsPrime(int n) {
    if (n < 2) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    // Only need to check up to square root of n
    int sqrt = (int) Math.sqrt(n);
    // Only check odd numbers
    for (int i = 3; i <= sqrt; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sums all prime numbers from 0 to n
   *
   * @param n The number of prime numbers to sum.
   * @return The sum of the first n prime numbers.
   */
  public static int SumPrimes(int n) {
    if (n < 2) return 0;
    
    int sum = 0;
    // Start from 2 since we know smaller numbers aren't prime
    for (int i = 2; i < n; i++) {
      if (IsPrime(i)) {
        sum += i;
      }
    }
    return sum;
  }

  /**
   * Finds all primes factors of a number
   *
   * @param n The number to find the prime factors of.
   * @return An vector of all prime factors of n.
   */
  public static Vector<Integer> PrimeFactors(int n) {
    Vector<Integer> ret = new Vector<Integer>();
    
    if (n < 2) return ret;
    
    // We only need to check up to square root for non-prime factors
    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt; i++) {
      while (n % i == 0) {
        if (IsPrime(i)) {
          ret.add(i);
        }
        n /= i;
      }
    }
    // If n is greater than 1 at this point, it is prime itself
    if (n > 1) {
      ret.add(n);
    }
    return ret;
  }
}