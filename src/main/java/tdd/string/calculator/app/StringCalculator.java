package tdd.string.calculator.app;

public class StringCalculator {
    public static int add(String numbers){
        String defaultDelimiter = ",";
        if(numbers.length()>=2 && numbers.substring(0,2).equalsIgnoreCase("//")){
            String delimiter = "";
            boolean numericFound = false;
            for(char d : numbers.substring(2).toCharArray()){
                if(Character.isDigit(d) && delimiter.charAt(delimiter.length()-1)=='\n') {
                    numericFound = true;
                    delimiter = delimiter.substring(0, delimiter.length() - 1);
                    break;
                }
                    delimiter += d;

                }
                if(numericFound){
                    return calculateSum(numbers.substring(delimiter.length()+3), delimiter);
                }
                else {
                    return 0;
                }

            }
        else {
            return calculateSum(numbers, defaultDelimiter);
        }
    }


    private static int calculateSum(String numbers, String delimiter) {
        int sum = 0;
        if(!numbers.isEmpty()){
            String[] splitNewLine = numbers.split("\n");
            for(String snl : splitNewLine){
                String[] splitDelim = snl.split(delimiter);
                for(String sc : splitDelim){
                    sum += Integer.parseInt(sc);
                }
            }
        }
        return sum;
    }
}
