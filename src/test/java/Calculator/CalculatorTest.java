package Calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.pow;

class CalculatorTest {
    protected String input1;
    protected Calculator c;
    protected String input2;
    protected String input3;
    protected String input4;
    protected String input5;
    protected final double error = 1e-9;
    protected double checkInput1;
    protected double checkInput3;

    @BeforeEach
    void setUp() {
        c = new Calculator();
        input1 = "-15*(7-mod10(58)+sqrt(12*98+(9+5*6)))/5+(12.2-(9+8*(7+8/4)))";
        input2 = "2+2*2+";
        input3 = "2*(2+9/9)";
        input4 = "2*7*(7+9";
        input5 = "2*7*(7+9+UIO)";
        checkInput1 = -15 * (7 - (58 % 10) + pow((12 * 98 + (9 + 5 * 6)), 0.5)) / 5 + (12.2 - (9 + 8 * (7 + 8 / 4)));
        checkInput3 = 2 * (2 + 9 / 9);
    }

    @Test
    void calculationTest() {
        final double precision = 1e-10;
        System.out.println("Test 1 :");
        Assertions.assertEquals(checkInput1, c.Calculation(input1), precision);
        System.out.println("Test 2 :");
        Assertions.assertEquals(1e-9, c.Calculation(input2), precision);
        System.out.println("Test 3 :");
        Assertions.assertEquals(checkInput3, c.Calculation(input3), precision);
        System.out.println("Test 4 :");
        Assertions.assertEquals(1e-9, c.Calculation(input4), precision);
        System.out.println("Test 5 :");
        Assertions.assertEquals(1e-9, c.Calculation(input5), precision);
    }
}