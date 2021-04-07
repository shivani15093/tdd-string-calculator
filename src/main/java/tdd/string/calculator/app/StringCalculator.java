package tdd.string.calculator.app;

public class StringCalculator {
    public static int add(String numbers){
        int sum = 0;
        if(!numbers.isEmpty()){
            String[] splitNewLine = numbers.split("\n");
            for(String snl : splitNewLine){
                String[] splitComma = snl.split(",");
                for(String sc : splitComma){
                    sum += Integer.parseInt(sc);
                }
            }
        }
        return sum;
    }
}
