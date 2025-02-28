import java.io.File;
import java.io.IOException;
import java.util.*;

public class DataAnalyzer{
    //reverse list
    public static int[] reverseList(int[] numbers){
        int[] tempList = new int[numbers.length];
        int index = numbers.length-1;
        int i = 0;
        while(index>0){
            tempList[i] = numbers[index];
            i++;
            index--;
        }
        return tempList;
    }
    //Binary Search
    public static int searchList(int target, int[] numbers){
        int minIndex = 0;
        int maxIndex = numbers.length;
        while(minIndex>maxIndex){
            int middleIndex = (int) Math.floor((minIndex+maxIndex)/2);
            if(target == numbers[middleIndex]){
                return middleIndex;
        }else{
            if(target>numbers[middleIndex]){
                minIndex = middleIndex + 1;
            }else{
                maxIndex = middleIndex - 1;
            }
        }
    }
        return -1;
    }
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index<=numbers.length - 1){
            if(numbers[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getMax(int[] numbers){
        int maxNum = numbers[0];
        for(int num : numbers){
          if(num>maxNum){
            maxNum = num;
          }
        }
        return maxNum;
    }

    public static int getMin(int[] numbers){
        int minNum = numbers[0];
        for(int num : numbers){
          if(num<minNum){
            minNum = num;
          }
        }
        return minNum;
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

    public static String[] arenaSearch(String[] list, String target, FileOperator file){
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 0; i<list.length; i++){
            if(list[i].equals(target)){
                indices.add(i);
            }
        }

        String[] arenaNames = file.toStringArray(30);
        String[] arenas = new String[indices.size()];

        for(int i =0; i< indices.size(); i++){
            arenas[i] = arenaNames[indices.get(i)];
        }
        return arenas;
    }

    public static String[] arenasByTeam(String target, FileOperator file){
        FileOperator fileTeam = new FileOperator("teams.txt");
        String[] foundList = fileTeam.toStringArray(30);
        String[] arenas = arenaSearch(foundList, target, file);        
        
        return arenas;
    }

    public static String[] arenasByLocation(String target, FileOperator file){
        FileOperator fileLocation = new FileOperator("locations.txt");
        String[] foundList = fileLocation.toStringArray(30);
        String[] arenas = arenaSearch(foundList, target, file);        
        
        return arenas;
    }
    
    public static String[] arenasByCapacity(String target, FileOperator file){
        FileOperator fileCapacity = new FileOperator("capacities.txt");
        String[] foundList = fileCapacity.toStringArray(30);
        String[] arenas = arenaSearch(foundList, target, file);        
        
        return arenas;
    }
    
    public static String[] arenasByChampionships(String target, FileOperator file){
        FileOperator fileChampionships= new FileOperator("championships.txt");
        String[] foundList = fileChampionships.toStringArray(30);
        String[] arenas = arenaSearch(foundList, target, file);        
        
        return arenas;
    }

    public static String findMostCommonArena(FileOperator file) {
        FileOperator fileLocations = new FileOperator("locations.txt");
        ArrayList<String> locations = fileLocations.toStringList();

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
        FileOperator fileNames = new FileOperator("arenas.txt");
        FileOperator fileCapacities = new FileOperator("capacities.txt");
        String[] arenas = fileNames.toStringArray(30);
        int[] capacities = fileCapacities.toIntArray(30);
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

        FileOperator fileTeams = new FileOperator("teams.txt");
        FileOperator fileChampionships = new FileOperator("championships.txt");

        String[] arenas = fileTeams.toStringArray(30);
        int[] championships = fileChampionships.toIntArray(30);

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
        FileOperator fileNames = new FileOperator("arenas.txt");
        FileOperator fileCapacities = new FileOperator("capacities.txt");

        String[] arenas = fileNames.toStringArray(30);
        ArrayList<Integer> final_capacities = new ArrayList<>();

        int[] capacities = fileCapacities.toIntArray(30);

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

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(searchList(arr ,5));

        int[] newArr = reverseList(arr);
        for(int i = 0; i< newArr.length; i++){
            System.out.print(newArr[i] + " ");
        }
        System.out.println("");

        int[] fileArr = new int[100];
        try{
            File f = new File("numbers.txt");
            Scanner scan = new Scanner(f);
            for(int i=0; i<100; i++){
                fileArr[i] = scan.nextInt();
            }
        }catch(IOException f){
            System.out.println("file not found");
        }

        //linear search
        System.out.println(searchList(fileArr,81));

        //binary search
        System.out.println(searchList(81, fileArr));

        //reverse list
        int[] reverseArr = reverseList(fileArr);
        for(int i=0; i < reverseArr.length -1; i++){
            System.out.print(reverseArr[i] + " ");


        FileOperator file1 = new FileOperator("capacities.txt");
        int[] capacities = file1.toIntArray(30);
        for(int num : capacities){
              System.out.print(num + " ");
        }

        System.out.println("");
        System.out.println(getMax(capacities));
        System.out.println(getMin(capacities));
        int[] OrderedCapacities = ascendOrDescend(capacities, 1);

        FileOperator input = new FileOperator("college.txt");
        ArrayList<String> colleges = input.toStringList();
        for(String college : colleges){
            System.out.print(college + " ");
        }
    }
}}