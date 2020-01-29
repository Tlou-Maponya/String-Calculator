import java.util.ArrayList;

/**
 * @author Tlou Maponya
 * @// TODO: 2020/01/20
 */

public class StringCalculator {
    public static int add(String inputs){

        String delimiter = ",|\n";
        String valueWithoutDelimiter = inputs;

        if(inputs.startsWith("//")) {
            int index = inputs.indexOf("//") + 2;
            delimiter = inputs.substring(index, index + 1);
            valueWithoutDelimiter = inputs.substring(inputs.indexOf("\n") + 1);
        }

        return add(valueWithoutDelimiter, delimiter);
    }

    public static int add(String inputs, String delimiter) {
        int returnVal = 0;
        String[] numberArray = inputs.split(delimiter);
        ArrayList negNumbers = new ArrayList();

        for (int i = 0; i < numberArray.length; i++) {
            String num = numberArray[i];
            if (!inputs.trim().isEmpty()) {
                int intNum =  toInteger(num.trim());
                if (intNum <0) {
                    negNumbers.add(intNum);
                }
                else if (intNum <1000){
                    returnVal = returnVal + intNum;
                }
            }
        }

        if (negNumbers.size() > 0) {
            throw new RuntimeException("negatives not allowed: " + negNumbers.toString());
        }
        return returnVal;
    }

    /**
     * Function that accepts a String parameter and returns an integer
     * @param input
     * @return
     */
    private static int toInteger(String input){
        return Integer.parseInt(input);
    }
}
