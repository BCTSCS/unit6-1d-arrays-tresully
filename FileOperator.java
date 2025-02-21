import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FileOperator {
    private Scanner fileReader;
    private File myFile;

    public FileOperator(String filename) {
        setFile(filename);
    }

    public void setFile(String filename) {
        myFile = new File(filename);
        try {
            fileReader = new Scanner(myFile);
        } catch (FileNotFoundException error) {
            System.out.println("File not found");
        }
    }

    public int[] toIntArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = fileReader.nextInt();
        }
        return arr;
    }

    public double[] toDoubleArray(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = fileReader.nextDouble();
        }
        return arr;
    }

    public String[] toStringArray(int size) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = fileReader.nextLine();
        }
        return arr;
    }
    
    public double calculateMedian(int[] data) {
        Arrays.sort(data); 
        int n = data.length;
        if (n % 2 == 0) {
            return (data[n / 2 - 1] + data[n / 2]) / 2.0; 
        } else {
            return data[n / 2]; 
        }
    }

    public static void main(String[] args) {
        FileOperator fileOp = new FileOperator("data.txt"); 
        int[] numbers = fileOp.toIntArray(10); 
        double median = fileOp.calculateMedian(numbers);
        System.out.println("Median: " + median);
    }
}
