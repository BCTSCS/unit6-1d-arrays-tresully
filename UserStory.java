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
    public int findMinCapacity(){
        int minCapacity = seatCapacities[0];
        String minVenue = venueNames[0];
        for (int i=1; i<seatCapacities.length; i++){
            if (seatCapacities[i] < minCapacity) {
                minCapacity = seatCapacities[i];
                minVenue = venueNames[i];
            }
        }
        System.out.println("The minimum capacity: " + minVenue + " with size: " + minCapacity);
        return minCapacity;
    }
    public int findMaxCapacity(){
        int maxCapacity = seatCapacities[0];
        String maxVenue = venueNames[0];
        for (int i=1; i<seatCapacities.length; i++){
            if (seatCapacities[i] > maxCapacity) {
                maxCapacity = seatCapacities[i];
                maxVenue = venueNames[i];
            }
        }
        System.out.println("The maximum capacity: " + maxVenue + " with size: " + maxCapacity);
        return maxCapacity;
    }
    public double computeAvgCapacity(){
        int totalSeats = 0;
        for (int capacity: seatCapacities){
            totalSeats += capacity;
        }
        double avgCapacity = (double) totalSeats / seatCapacities.length;
        System.out.println("Average Capacity: " + String.format("%.2f", avgCapacity));
        return avgCapacity;
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

    public int computeModeCapacity() {
        int modeValue = seatCapacities[0];
        int highestFrequency = 1;
        
        for (int i = 0; i < seatCapacities.length; i++) {
            int count = 0;
            for (int j = 0; j < seatCapacities.length; j++) {
                if (seatCapacities[j] == seatCapacities[i]) {
                    count++;
                }
            }
            if (count > highestFrequency) {
                highestFrequency = count;
                modeValue = seatCapacities[i];
            }
        }
        System.out.println("Mode Capacity: " + modeValue + " (appears " + highestFrequency + " times)");
        return modeValue;
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
        analysis.findMinCapacity();
        analysis.findMaxCapacity();
        analysis.computeAvgCapacity();
        analysis.computeMedianCapacity();
        analysis.computeModeCapacity();
    }
}
