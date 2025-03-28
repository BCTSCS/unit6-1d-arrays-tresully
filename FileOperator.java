import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class FileOperator {
    private Scanner fileReader;
    private File myFile; 

    public FileOperator(String filename){
        setFile(filename);
    }

    public void setFile(String filename){
        myFile = new File(filename);
        try{
            fileReader = new Scanner(myFile);
        }catch(FileNotFoundException error){
            System.out.println("File not found.");
        }
    }

    public int[] toIntArray(String filepath, int size){
        int[] arr = new int[size];
        this.setFile(filepath);
        for(int i = 0; i < size; i++){
            arr[i] = fileReader.nextInt();
        }
        return arr;
    }

    public double[] toDoubleArray(String filepath, int size){
        double[] arr = new double[size];
        this.setFile(filepath);
        for(int i = 0; i< size; i++){
            arr[i] = fileReader.nextDouble();
        }
        return arr;
    }

    public String[] toStringArray(String filepath, int size){
        String[] arr = new String[size];
        this.setFile(filepath);
        for(int i = 0; i < size; i++){
            arr[i] = fileReader.nextLine();
        }
        return arr;
    }

    public ArrayList<String> toStringArray(String filepath){
        ArrayList<String> arr = new ArrayList<String>();
        this.setFile(filepath);
        while(fileReader.hasNextLine()){
            arr.add(fileReader.nextLine());
        }
        return arr;
    }

    public ArrayList<Integer> toIntgArray(String filepath){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        this.setFile(filepath);
        while(fileReader.hasNextInt()){
            arr.add(fileReader.nextInt());
        }
        return arr;
    }

    public ArrayList<Double> toDoubleArray(String filepath){
        ArrayList<Double> arr = new ArrayList<Double>();
        this.setFile(filepath);
        while(fileReader.hasNextDouble()){
            arr.add(fileReader.nextDouble());
        }
        return arr;
    }

    
}