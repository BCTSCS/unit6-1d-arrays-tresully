import javax.swing.*;
import java.awt.*;


public class DataGui extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private FileOperator file = new FileOperator("data/arenas.txt");
    
    public DataGui() {
        setTitle("Arena Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeTeamButton = new JButton("Analyze by Team");
        JButton analyzeLocationButton = new JButton("Analyze by Location");
        JButton analyzeCapacityButton = new JButton("Analyze by Capacity");
        JButton analyzeChampionshipButton = new JButton("Analyze by Championships");
        JButton commonLocationButton = new JButton("Get Most Common Arena Location");
        JButton largestArenaButton = new JButton("Get Arena With Largest Capacity");
        JButton minChampionshipsButton = new JButton("Get Team with Min Championship wins");
        JButton capacityByCityButton = new JButton("Get Capacity by City");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeTeamButton);
        add(analyzeLocationButton);
        add(analyzeCapacityButton);
        add(analyzeChampionshipButton);
        add(capacityByCityButton);
        add(commonLocationButton);
        add(largestArenaButton);
        add(minChampionshipsButton);
        add(new JScrollPane(resultsArea));

        analyzeTeamButton.addActionListener(e -> analyzeByTeam());
        analyzeLocationButton.addActionListener(e -> analyzeByLocation());
        analyzeCapacityButton.addActionListener(e -> analyzeByCapacity());
        analyzeChampionshipButton.addActionListener(e -> analyzeByChampionships());
        capacityByCityButton.addActionListener(e -> analyzeCapacityByCity());
        commonLocationButton.addActionListener(e -> getMostCommonArena());
        largestArenaButton.addActionListener(e -> getLargestArena());
        minChampionshipsButton.addActionListener(e -> getMinChampionships());
    }

    public static String string(String[] arr) {
        String result = "";
        for(String s : arr) {
            result += s + "\n";
        }
        return result;
    }
    private static String string_int(int[] arr) {
        String result = "";
        for(int s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private void analyzeByTeam(){
        String[] arenas = DataAnalyzer.arenasByTeam((inputField.getText()),file);

        resultsArea.setText("Arenas by Team " + inputField.getText() + ": \n" + string(arenas) + "\n");
    }
    private void analyzeByLocation(){
        String[] arenas = DataAnalyzer.arenasByLocation((inputField.getText()),file);

        resultsArea.setText("Arenas by Location " + inputField.getText() + ": \n" + string(arenas) + "\n");
    }
    private void analyzeByCapacity(){
        String[] arenas = DataAnalyzer.arenasByCapacity((inputField.getText()),file);

        resultsArea.setText("Arenas by Capacity " + inputField.getText() + ": \n" + string(arenas) + "\n");
    }
    private void analyzeByChampionships(){
        String[] arenas = DataAnalyzer.arenasByChampionships((inputField.getText()),file);

        resultsArea.setText("Arenas by # of Championships " + inputField.getText() + ": \n" + string(arenas) + "\n");
    }
    private void analyzeCapacityByCity(){
        int[] capacities = DataAnalyzer.capacityByCity((inputField.getText()),file);

        resultsArea.setText("Capacities by City " + inputField.getText() + ": \n" + string_int(capacities) + "\n");
    }


private void getMostCommonArena(){
        String location = DataAnalyzer.findMostCommonArena(file);
        resultsArea.setText("Most Common Arena: " + location);
    }


    private void getLargestArena(){
        String arena = DataAnalyzer.largestArena(file);
        resultsArea.setText("Largest Arena: " + arena);
    }

    private void getMinChampionships(){
        String[] arenas = DataAnalyzer.minChampionships(file);
        resultsArea.setText("Teams with the smallest # of championships: " + string(arenas));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGui().setVisible(true));
    }
}
    