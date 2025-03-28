public class Team {
    public static int num_teams = 0;
    private int id;
    private String name;
    private String location;
    private String arena;
    private int num_championships;
    private int capacity;

    public Team(String nm, String city, String ar, int champs, int cap){
        id = num_teams;
        num_teams++;
        name = nm;
        location = city;
        arena = ar;
        num_championships = champs;
        capacity = cap;



    }

    public int getID(){
        return this.id;
    }
    public int getChamps(){
        return this.num_championships;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }

    public String getArena(){
        return this.arena;
    }

    public void setID(int id){
        this.id = id;
    }
    public void setChamps(int champs){
        this.num_championships = champs;
    }
    public void setCapacity(int cap){
        this.capacity = cap;
    }

    public void setArena(String arena){
        this.arena = arena;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String toString(){
        return "Team Name: " + this.getName() + "\nArena Name: " + this.getArena() + "\nLocation: " + this.getLocation() +  "\nChampionships: " + this.getChamps() + "\nCapacity: " + this.getCapacity();
    }


    
}