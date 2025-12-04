import java.util.Arrays;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<String> input = Day03.loadInput("day03Input.txt");

        // String[] array = {"987654321111111", "811111111111119", "234234234234278", "818181911112111"};
        // ArrayList<String> input = new ArrayList<String>(Arrays.asList(array));
        
        // part one 
        int voltageSum = Day03.partOne(input); 
        System.out.println("voltage: "+voltageSum);

    }
}