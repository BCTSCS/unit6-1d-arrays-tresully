import java.util.Arrays;

public class DataAnalyzer {
    public static int searchList(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i; 
            }
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                return mid; 
            }
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return -1; 
    }

    public static int[] reverseList(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        
        System.out.println("Linear Search (50): " + searchList(arr, 50));
    
        System.out.println("Binary Search (30): " + binarySearch(arr, 30));
        
        int[] reversed = reverseList(arr);
        System.out.println("Reversed List: " + Arrays.toString(reversed));
    }
}
