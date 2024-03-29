package tdd.string.calculator.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTests {

    StringCalculator stringCalculator;

    @Before
    public void setUp(){
        stringCalculator = new StringCalculator();
    }

    // Test Cases for Part 1 -> handle only for 0,1,2 numbers
    @Test
    public void emptyStringTest(){
        Assert.assertEquals(0, stringCalculator.add(""));
    }
    @Test
    public void singleNumberStringTest(){
        Assert.assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    public void twoNumbersStringTest(){
        Assert.assertEquals(3, stringCalculator.add("1,2"));
    }

    // Test Cases for Part 2 -> handle for any number of numbers
    @Test
    public void anyNumbersStringTest(){
        Assert.assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    // Test Cases for Part 3 -> handle for \n or , as delimiter
    @Test
    public void newLineAsDelimiterTest(){
        Assert.assertEquals(36, stringCalculator.add("1\n2,3,4,5\n6,7,8"));
    }
    // Test Cases for Part 4 -> handle for any delimiter
    // Basic Case
    @Test
    public void anyDelimiterTest1(){
        Assert.assertEquals(6, stringCalculator.add("//;\n1;2;3"));
    }
    // Provide custom delimiter as newLine
    @Test
    public void anyDelimiterTest2(){
        Assert.assertEquals(6, stringCalculator.add("//\n\n1\n2\n3"));
    }
    // Provide custom delimiter as space
    @Test
    public void anyDelimiterTest3(){
        Assert.assertEquals(6, stringCalculator.add("// \n1 2 3"));
    }
    // No numbers follow after providing custom delimiter
    @Test
    public void anyDelimiterTest4(){
        Assert.assertEquals(0, stringCalculator.add("//;\n"));
    }
    //Provide custom delimiter of length more than one
    @Test
    public void anyDelimiterTest5(){
        Assert.assertEquals(6, stringCalculator.add("//->\n1->2->3"));
    }

    //Provide custom delimiter along with handling newLine
    @Test
    public void anyDelimiterTest6(){
        Assert.assertEquals(11, stringCalculator.add("//;\n1;1\n2;3;4"));
    }

    //Part 5 -> Provide negative number
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void singleNegativeNumberTest(){
        exceptionRule.expect(NegativeNumberException.class);
        exceptionRule.expectMessage("Negatives not allowed - [-3]");
        stringCalculator.add("1,2,-3");
    }

    // Part 6 -> Provide multiple negative numbers
    @Test
    public void multipleNegativeNumbersTest1(){
        exceptionRule.expect(NegativeNumberException.class);
        exceptionRule.expectMessage("Negatives not allowed - [-2, -3]");
        stringCalculator.add("1,-2,-3");
    }

    @Test
    public void multipleNegativeNumbersTest2(){
        exceptionRule.expect(NegativeNumberException.class);
        exceptionRule.expectMessage("Negatives not allowed - [-1, -4]");
        stringCalculator.add("//;\n1;-1\n2;3;-4");
    }
    @Test
    public void callCouterTest(){
        stringCalculator.add("");
        stringCalculator.add("1,2,3,4,5");
        stringCalculator.add("//;\n");
        stringCalculator.add("//->\n1->2->3");
        stringCalculator.add("//;\n1;1\n2;3;4");
        exceptionRule.expect(NegativeNumberException.class);
        stringCalculator.add("1,2,-3");
        stringCalculator.add("1,-2,-3");
        stringCalculator.add("//;\n1;-1\n2;3;-4");
        Assert.assertEquals(8, stringCalculator.getCalledCount());
    }
}
