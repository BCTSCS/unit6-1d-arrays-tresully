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
