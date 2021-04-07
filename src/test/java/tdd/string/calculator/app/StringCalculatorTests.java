package tdd.string.calculator.app;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTests {
    // Test Cases for Part 1 -> handle only for 0,1,2 numbers
    @Test
    public void emptyStringTest(){
        Assert.assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void singleNumberStringTest(){
        Assert.assertEquals(1, StringCalculator.add("1"));
    }
    @Test
    public void twoNumbersStringTest(){
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }

    // Test Cases for Part 2 -> handle for any number of numbers
    @Test
    public void anyNumbersStringTest(){
        Assert.assertEquals(15, StringCalculator.add("1,2,3,4,5"));
    }

    // Test Cases for Part 3 -> handle for \n or , as delimiter
    @Test
    public void newLineAsDelimiterTest(){
        Assert.assertEquals(36, StringCalculator.add("1\n2,3,4,5\n6,7,8"));
    }

}
