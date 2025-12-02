import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day02 {

    public static long partOne(ArrayList<String> list) {
        long sum = 0;

        // looping through all the IDs
        for (String s : list) {
            long start = Long.parseLong(s.substring(0, s.indexOf('-')));
            long end = Long.parseLong(s.substring(s.indexOf('-') + 1));
            int maxLen = s.substring(s.indexOf('-') + 1).length(); 
            System.out.println("start: "+ start + ", end: " + end); 

            // looping through the whole range
            for (long i = start; i <= end; i++) {
                String first = (String.valueOf(i)).substring(0, (maxLen / 2));
                String second = (String.valueOf(i)).substring((maxLen / 2));
                // System.out.println("first = "+first+", second = "+second);

                // check if they are invalid aka repeating digits
                if(first.equals(second)) {
                    sum += i; 
                    System.out.println("added "+i);
                }                
            }   
        }

        return sum; 
    }
}