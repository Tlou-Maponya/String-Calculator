import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    public void returnZeroOnEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void returnNumberOnNumber(){
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void returnSumOfTwo(){
        assertEquals(2, StringCalculator.add("1,1"));
    }

    @Test
    public void returnSumOfMultiple(){
        assertEquals(10, StringCalculator.add("2,1,1,1,1,1,3"));
    }

    @Test
    public void newLineBetweenInt(){
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void handleDifferentDelimiter(){
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(5, StringCalculator.add("//4\n342"));
    }

    @Test
    public final void handleNegativeNumbers() {

        try {
            StringCalculator.add("-1,-2,3,4");
            fail("Exception expected");
        } catch (RuntimeException e) {
            assertEquals("negatives not allowed: [-1, -2]", e.getMessage());
        }
    }

    @Test
    public void ignoreValuesGreaterThan1000(){
        assertEquals(17, StringCalculator.add("1000,2,1,4,1001,2000,5,5"));
        assertEquals(7, StringCalculator.add("1005,2,1,4,1001,2000"));
    }


}