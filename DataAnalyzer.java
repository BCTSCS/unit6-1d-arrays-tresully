import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class DataAnalyzer{


    public static void main(String[] args){
        int[] list = {10,20,30,40,50};
        System.out.println(searchList(list, 40));
        System.out.println(searchList(20, list));
        int[] numbers = new int[100];
        try {
            File f = new File("numbers.txt");
            
            Scanner input = new Scanner(f);
            for(int i = 0; i < 100; i++){
                numbers[i] = input.nextInt();
            }
           
            input.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        System.out.println(searchList(numbers, 17));
        int[] newNumbers = reverseList(numbers);

        printArray(newNumbers);

        FileOperator file = new FileOperator("arenas.txt");

        



        
       

    }
    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.print("]");
    }
     // Linear Search  
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index <= numbers.length - 1){
            if(numbers[index] == target){
                return index;
            }
            index++;
        }

        return -1;
    }
    // Binary Search - List must be sorted first
    public static int searchList(int target, int[] numbers){
        int minIndex = 0;
        int maxIndex = numbers.length -1;
        while (minIndex <= maxIndex){
            int middleIndex = (maxIndex+minIndex)/2;
            if(numbers[middleIndex] == target){
                return middleIndex;
            }
            else{
                if(target > numbers[middleIndex]){
                    minIndex = middleIndex + 1;
                }else{
                    maxIndex = middleIndex - 1;
                }
            }
        }
        return -1;
    }
    public static int[] reverseList(int[] array){
        int[] newArray = new int[array.length];

        for(int i = 0; i < array.length-1; i++){
            newArray[i] = array[array.length-1-i];
        }
        return newArray;
    }

    public static int findMax(int[] values){
        int max = values[0];
        for(int i = 0; i < values.length; i++){
            if(values[i] > max){
                max = values[i];
            }
        }
        return max;
    }

    public static int[] ascendOrDescend(int[] arr, int flip){
        // if flip = 1, sorts in ascending order
        // if flip = 0, sorts in descending order
        int temp;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j< arr.length; j++){
                if (arr[j] > arr[i]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        if(flip == 1){
            return reverseList(arr);
        }
        else{
            return arr;
        }
    }
   
    public static int[] findString(String[] list, String target){
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            if(list[i].equals(target)){
                indices.add(i);
            }
            
        }
        int[] result = new int[indices.size()];
        for(int i = 0; i < indices.size(); i++){
            result[i] = indices.get(i);
        }
        return result;
    }

    public static String[] arenasWith(String[] list, String target, FileOperator file){
        int[] indices = findString(list ,target);
        String[] arenaNames = file.toStringArray("data/arenas.txt", 30);
        String[] arenas = new String[indices.length];
        for(int i = 0; i< indices.length; i++){
            arenas[i] = arenaNames[indices[i]];
        }
        return arenas;
    }

    public static String[] arenasByTeam(String target, FileOperator file){
        String filepath = "data/teams.txt";
        int arr_size = 30;

        String[] foundList = file.toStringArray(filepath,arr_size);
        String[] arenas = arenasWith(foundList, target, file);
        return arenas;

    }


    public static String findMostCommonArena(FileOperator file) {
       
        ArrayList<String> locations = file.toStringArray("data/locations.txt");

        List<String> locationList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        
        for (String location : locations) {
            if (locationList.contains(location)) {
                int index = locationList.indexOf(location);
                countList.set(index, countList.get(index) + 1);
            } else {
                locationList.add(location);
                countList.add(1);
            }
        }
        
        int maxIndex = 0;
        for (int i = 1; i < countList.size(); i++) {
            if (countList.get(i) > countList.get(maxIndex)) {
                maxIndex = i;
            }
        }
        
        return locationList.get(maxIndex);
    }

    public static String largestArena(FileOperator file){
        String[] arenas = file.toStringArray("data/arenas.txt", 30);
        int[] capacities = file.toIntArray("data/capacities.txt",30);
        int max_size = capacities[0];
        String largest_arena = arenas[0];

        for(int i = 0 ; i < arenas.length; i++){
            if(capacities[i] > max_size){
                max_size = capacities[i];
                largest_arena = arenas[i];
            }
        }
        return largest_arena;

    }

    public static String[] minChampionships(FileOperator file){
        ArrayList<String> min_teams = new ArrayList<String>();
        ArrayList<Integer> min_championships = new ArrayList<Integer>();
        String[] arenas = file.toStringArray("data/teams.txt", 30);
        int[] championships = file.toIntArray("data/championships.txt", 30);

        min_teams.add(arenas[0]);
        min_championships.add(championships[0]);

        for(int i = 0; i < arenas.length; i++){
            if(championships[i] < min_championships.get(0)){
                min_teams.clear();
                min_championships.clear();
                min_teams.add(arenas[i]);
                min_championships.add(championships[i]);
            }
            else if(championships[i] == min_championships.get(0)){
                min_teams.add(arenas[i]);
                min_championships.add(championships[i]);
            }
            
        }
        return min_teams.toArray(new String[0]);
    }

    public static int[] capacityByCity(String target, FileOperator file){
        String[] arenas = file.toStringArray("data/arenas.txt", 30);
        ArrayList<Integer> final_capacities = new ArrayList<>();
        int[] capacities = file.toIntArray("data/capacities.txt", 30);

        for (int i = 0; i < arenas.length; i++){
            if(arenas[i].equals(target)){
                final_capacities.add(capacities[i]);
            }
        }
        int[] new_capacities = new int[final_capacities.size()];
        
        for(int i = 0; i < new_capacities.length; i++){
            new_capacities[i] = final_capacities.get(i);
        }
        return new_capacities;

    }






}