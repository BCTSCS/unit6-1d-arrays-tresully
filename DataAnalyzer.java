import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class DataAnalyzer {
    public static int[] reverseList(int[] numbers){
        for (int i = 0; i < numbers.length / 2; i++) {
            // Store the element from the left side
            int temp = numbers[i];
            // Put the right side element into the left position
            numbers[i] = numbers[numbers.length - 1 - i];
            // Put the stored left element into the right position
            numbers[numbers.length - 1 - i] = temp;
        }
        return numbers;
    }
    //binary search
    // public static int searchList(int[] numbers, int target){
        
    //     int low = 0;
    //     int high = numbers.length - 1;
    
    //     while (low <= high) {
    //         int index = (high+low)/2;
    //         if (target == numbers[index]) {
    //             return index;
    //         } else if (target < numbers[index]){
    //             high = index - 1;
    //         } else {
    //             low = index + 1;
    //         }
    //     }
    //     return -1;
    // }
    // // linear search
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index <= numbers.length - 1){
            if (numbers[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = new int[100];
        try {
                File f = new File("./numbers.txt");
                Scanner input = new Scanner(f);
                for (int i=0; i < 100; i++){
                    arr[i] = input.nextInt();
                }
                
                
            } catch(IOException e){
                System.out.println("file not found");
        }
        
        System.out.println(searchList(arr, 81));
        int[] reversearr = (reverseList(arr));
        for (int i=0; i < reversearr.length; i++){
            System.out.print(reversearr[i] + " ");
        }
    }
}