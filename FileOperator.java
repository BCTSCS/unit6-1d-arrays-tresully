import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public ArrayList<String> toStringList() {
        ArrayList<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return result;
    }

    public ArrayList<Integer> toIntList() {
        ArrayList<Integer> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextInt()) {
                result.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return result;
    }

    public ArrayList<Double> toDoubleList() {
        ArrayList<Double> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextDouble()) {
                result.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return result;
    }

    public static void main(String[] args) {
        FileOperator fileOp = new FileOperator("data.txt");

        ArrayList<Integer> intList = fileOp.toIntList();
        System.out.println("Integer List: " + intList);

        ArrayList<Double> doubleList = fileOp.toDoubleList();
        System.out.println("Double List: " + doubleList);

        ArrayList<String> stringList = fileOp.toStringList();
        System.out.println("String List: " + stringList);
    }
}
