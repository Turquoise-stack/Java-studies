import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] fill_array(int input_length){
        Scanner scanner = new Scanner(System.in);

        int[] input = new int[input_length];

        for (int i = 0; i < input_length ; i++){
            input[i] = scanner.nextInt();
        }
        return input;

    }

    public static void sort_array_numerically(int [] array){
        Arrays.sort(array);
        display_array(array);
    }

    public static void display_array(int[] array){

        for(int i = 0; i < array.length ; i++){
            System.out.println("Number " + (i+1) + ": " + array[i]);
        }
    }

    public static void main(String[] args) {
        int[] my_array = fill_array(4);
        sort_array_numerically(my_array);



    }
}