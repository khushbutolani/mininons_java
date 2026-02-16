import static org.junit.Assert.assertEquals;

import org.example.Calculator;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testMultiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 2));
    }
}

