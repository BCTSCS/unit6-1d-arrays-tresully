import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Basketball{
    private static ArrayList<Team> teams = new ArrayList<Team>();

    public Basketball(){
        FileOperator file = new FileOperator("data/arenas.txt");
        String[] arena_names = file.toStringArray("data/arenas.txt", 30);
        String[] locations = file.toStringArray("data/locations.txt", 30);
        String[] team_names = file.toStringArray("data/teams.txt", 30);
        int[] capacities = file.toIntArray("data/capacities.txt", 30);
        int[] championships = file.toIntArray("data/championships.txt", 30);
        for(int i = 0; i < arena_names.length; i++){
            teams.add(new Team(team_names[i], locations[i], arena_names[i], championships[i], capacities[i]));
        }
    }


    public static void main(String[] args){
       
    }
    
    public ArrayList<Team> getTeams(){
        return this.teams;
    }

    public static int arenasbyTeam(String target){
        for(Team team : teams){
            if(team.getName().equals(target)){
            return team.getID();
            }
        }
        return -1;
    }


    public static int findMostCommonArena(FileOperator file) {

        List<String> locationList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        
        for (Team team: teams){
            if(locationList.contains(team.getLocation())){
                int index = locationList.indexOf(team.getLocation());
                countList.set(index, countList.get(index) +1);
            }
            else{
                locationList.add(team.getLocation());
                countList.add(1);
                
            }
        }
        
        int maxIndex = 0;
        for (int i = 1; i < countList.size(); i++) {
            if (countList.get(i) > countList.get(maxIndex)) {
                maxIndex = i;
            }
        }
        
        // return locationList.get(maxIndex);
        return maxIndex;
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

    
     




}
