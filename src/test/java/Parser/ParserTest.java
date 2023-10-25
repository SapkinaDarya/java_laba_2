package Parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParserTest {

    protected String input1;
    protected Parser p;
    protected String input2;
    protected String input3;

    @BeforeEach
    void setUp() {
        p = new Parser();
        input1 = "-15*(7-mod10(58)+sqrt(12*98+(9+5*6)))/5+(12.2-(9+8*(7+8/4)))";
        input2 = "2+2*2+";
        input3 = "2*(2+9/9)";
    }

    @Test
    void isNumericTest() {
        String a = "23.87";
        String b = "34a.9";
        Parser p = new Parser();
        Assertions.assertTrue(p.isNumeric(a));
        Assertions.assertFalse(p.isNumeric(b));
    }

    @Test
    void isOperatorTest() {
        String operand = "*";
        String notOperand = ")";
        String notOperand2 = "*&";
        Assertions.assertTrue(p.isOperator(operand));
        Assertions.assertFalse(p.isOperator(notOperand));
        Assertions.assertFalse(p.isOperator(notOperand2));
    }

    @Test
    void isInputCorrectTest() {
        Assertions.assertTrue(p.isInputCorrect(input1));
        Assertions.assertFalse(p.isInputCorrect(input2));
    }

    @Test
    void strParsTest() {
        String expected1 = " 15 u- 7 58 mod10 - 12 98 * 9 5 6 * + + sqrt + * 5 / 12.2 9 8 7 8 4 / + * + - +";
        String expected3 = " 2 2 9 9 / + *";
        Assertions.assertEquals(expected1, p.StrPars(input1));
        Assertions.assertEquals(expected3, p.StrPars(input3));
    }
}