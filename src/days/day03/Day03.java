import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day03 {
    public static ArrayList<String> loadInput(String filePath) {
        filePath = "../../inputs/" + filePath;
        //System.out.println("filepath: " + filePath);
        ArrayList<String> returnStringArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                returnStringArray.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }

        return returnStringArray;
    }

    public static int partOne(ArrayList<String> list) {
        int voltageSum = 0; 
        int currMaxVoltage = 0; 

        // loop through the list 
        for (String s : list) {
            // loop through the digits (use toCharArray()?) 
            char[] charArray = s.toCharArray();
            int firstDigit = 0; 
            int indexFirstDigit = 0; 
            int secondDigit = 0; 

            for (int i = 0; i < charArray.length; i++) {
                // find the biggest digit (note if it is in the lsd)
                int curr = Integer.parseInt(String.valueOf(charArray[i])); 
                if (curr > firstDigit) {
                    firstDigit = curr; 
                    indexFirstDigit = i; 
                }
            }

            System.out.println("first digit: "+firstDigit+" at "+indexFirstDigit);
                
            // loop through the digits again 
                // if the biggest digit was in the lsd, search through all other digits 
                // else find the next biggest digit to the right of the biggest digit 

            if (indexFirstDigit == charArray.length - 1) {
                System.out.println("got here");

                for (int i = 0; i < charArray.length - 1; i++) {
                    int curr = Integer.parseInt(String.valueOf(charArray[i])); 
                    if (curr > secondDigit) 
                        secondDigit = curr; 
                }

                int temp = firstDigit; 
                firstDigit = secondDigit; 
                secondDigit = temp; 
            }

            else {
                for (int i = indexFirstDigit + 1; i < charArray.length; i++) {
                    int curr = Integer.parseInt(String.valueOf(charArray[i])); 
                    if (curr > secondDigit) 
                        secondDigit = curr;
                }
            }
            
            // add the current max voltage to the running sum 
            currMaxVoltage = (10*firstDigit) + secondDigit; 
            System.out.println("currMaxVoltage = "+currMaxVoltage);
            voltageSum += currMaxVoltage;
            System.out.println();
        }
        
        return voltageSum; 
    }
}