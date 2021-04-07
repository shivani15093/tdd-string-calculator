package tdd.string.calculator.app;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTests {
    // Test Cases for Part 1
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
}
