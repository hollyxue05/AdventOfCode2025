import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Day02 {

    public static long partOne(ArrayList<String> list) {
        long sum = 0;

        // looping through all the IDs
        for (String s : list) {
            long start = Long.parseLong(s.substring(0, s.indexOf('-')));
            long end = Long.parseLong(s.substring(s.indexOf('-') + 1));

            // looping through the whole range
            for (long i = start; i <= end; i++) {
                String curr = String.valueOf(i);
                String first = curr.substring(0, ( curr.length() / 2));
                String second = curr.substring(( curr.length() / 2));

                // check if they are invalid aka repeating digits
                if(first.equals(second)) {
                    sum += i; 
                }                
            }   
        }

        return sum; 
    }

    public static long partTwo(ArrayList<String> list) {
        long sum = 0;
        Set<Long> nums = new HashSet<>();

        // looping through all the IDs
        for (String s : list) {
            long start = Long.parseLong(s.substring(0, s.indexOf('-')));
            long end = Long.parseLong(s.substring(s.indexOf('-') + 1));

            // looping through the whole range
            for (long i = start; i <= end; i++) {
                String curr = String.valueOf(i);

                for (int j = 2; j <= curr.length(); j++) {
                    if (curr.length() % j == 0) {
                        String prefix = curr.substring(0, curr.length() / j);

                        if (prefix.repeat(j).equals(curr))
                            nums.add(i); 
                    }
                }                
            }   
        }

        for (long l : nums) {
            sum += l;
        }

        return sum; 
    }
}