import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    // --- Addition Tests ---

    @Test
    public void testAddPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testAddNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    public void testAddPositiveAndNegative() {
        assertEquals(1, calculator.add(3, -2));
    }

    @Test
    public void testAddZero() {
        assertEquals(7, calculator.add(7, 0));
    }

    // --- Subtraction Tests ---

    @Test
    public void testSubtractPositiveNumbers() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    public void testSubtractNegativeNumbers() {
        assertEquals(1, calculator.subtract(-2, -3));
    }

    @Test
    public void testSubtractResultNegative() {
        assertEquals(-3, calculator.subtract(2, 5));
    }

    @Test
    public void testSubtractZero() {
        assertEquals(4, calculator.subtract(4, 0));
    }

    // --- Multiplication Tests ---

    @Test
    public void testMultiplyPositiveNumbers() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    public void testMultiplyPositiveAndNegative() {
        assertEquals(-6, calculator.multiply(2, -3));
    }

    // --- Division Tests ---

    @Test
    public void testDivideEvenNumbers() {
        assertEquals(2.0, calculator.divide(6, 3), 0.0001);
    }

    @Test
    public void testDivideResultDecimal() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
    }

    @Test
    public void testDivideNegativeByPositive() {
        assertEquals(-3.0, calculator.divide(-6, 2), 0.0001);
    }

    @Test
    public void testDivideNegativeByNegative() {
        assertEquals(3.0, calculator.divide(-6, -2), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZeroThrowsException() {
        calculator.divide(5, 0);
    }
}
