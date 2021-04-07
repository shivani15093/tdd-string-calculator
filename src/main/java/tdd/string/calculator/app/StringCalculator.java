package tdd.string.calculator.app;

public class StringCalculator {
    public static int add(String numbers){
        int sum = 0;
        if(!numbers.isEmpty()){
            String[] num = numbers.split(",");
            for(String n : num){
                sum += Integer.parseInt(n);
            }
        }
        return sum;
    }
}
