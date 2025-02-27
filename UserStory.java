import java.util.Scanner;

public class UserStory {
    private String[] venueNames;
    private int[] seatCapacities;
    private FileOperator venueFile;
    private FileOperator capacityFile;

    public UserStory(){
        venueFile = new FileOperator("./arenas.txt");
        capacityFile = new FileOperator("./capacities.txt");
        venueNames = venueFile.toStringArray(30);
        seatCapacities = capacityFile.toIntArray(30);
    }

    public double computeMedianCapacity() {
        int[] sortedCapacities = seatCapacities.clone();
        selectionSort(sortedCapacities);
        
        double median;
        if (sortedCapacities.length % 2 == 0) {
            median = (double)(sortedCapacities[sortedCapacities.length/2] + 
                            sortedCapacities[sortedCapacities.length/2 - 1]) / 2;
        } else {
            median = sortedCapacities[sortedCapacities.length/2];
        }
        System.out.println("Median Capacity: " + String.format("%.2f", median));
        return median;
    }

     
    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        UserStory analysis = new UserStory();
        
        System.out.println("Arena Capacity Analysis:");
        analysis.computeMedianCapacity();
    }
}
