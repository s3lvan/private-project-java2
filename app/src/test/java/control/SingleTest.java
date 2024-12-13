package control;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Single operations.
 * Contains unit tests for range sum, array maximum, and modulus operations.
 */
public class SingleTest {
    private Single single;

    @BeforeEach
    void setUp() {
        single = new Single();
    }

    /**
     * Tests the sumRange method with various scenarios including:
     * - Normal range calculation
     * - Empty range (start equals end)
     * - Negative numbers
     */
    @Test
    void testSumRange() {
        assertEquals(55, single.sumRange(1, 10), "Sum of range 1-10 should be 55");
        assertEquals(0, single.sumRange(5, 5), "Sum of empty range should be 0");
        assertEquals(-5, single.sumRange(-3, -1), "Sum of negative range should be correct");
        assertThrows(IllegalArgumentException.class, 
            () -> single.sumRange(10, 1), 
            "Should throw exception when start > end");
    }

    /**
     * Tests the maxArray method with various scenarios including:
     * - Normal array with mixed numbers
     * - Array with all same numbers
     * - Array with negative numbers
     * - Edge cases with single element and empty array
     */
    @Test
    void testMaxArray() {
        assertEquals(9, single.maxArray(new int[]{1, 5, 9, 3, 7}), "Should find maximum in mixed array");
        assertEquals(5, single.maxArray(new int[]{5, 5, 5}), "Should handle array with same numbers");
        assertEquals(-1, single.maxArray(new int[]{-5, -3, -1, -4}), "Should handle negative numbers");
        assertEquals(42, single.maxArray(new int[]{42}), "Should handle single element array");
        assertThrows(IllegalArgumentException.class, 
            () -> single.maxArray(new int[]{}), 
            "Should throw exception for empty array");
    }

    /**
     * Tests the sumModulus method with various scenarios including:
     * - Standard cases with different divisors
     * - Edge cases with zero divisor
     * - Large numbers
     * - Negative numbers
     */
    @Test
    void testSumModulus() {
        assertEquals(6, single.sumModulus(new int[]{1, 2, 3, 4, 5}, 3), 
            "Sum of numbers divisible by 3 should be correct");
        assertEquals(0, single.sumModulus(new int[]{1, 2, 3, 4, 5}, 7), 
            "Should return 0 when no numbers are divisible");
        assertEquals(15, single.sumModulus(new int[]{5, 10, 15, 20}, 5), 
            "Should correctly sum numbers divisible by 5");
        assertThrows(IllegalArgumentException.class, 
            () -> single.sumModulus(new int[]{1, 2, 3}, 0), 
            "Should throw exception for zero divisor");
        assertThrows(IllegalArgumentException.class, 
            () -> single.sumModulus(new int[]{}, 5), 
            "Should throw exception for empty array");
    }

    /**
     * Tests error conditions for negative divisors in sumModulus.
     */
    @Test
    void testSumModulusErrorConditions() {
        assertThrows(IllegalArgumentException.class, 
            () -> single.sumModulus(new int[]{1, 2, 3}, -1), 
            "Should throw exception for negative divisor");
    }
}