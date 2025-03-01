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
        JButton analyzeLocationButton = new JButton("Analyze by Location");
        JButton capacityByCityButton = new JButton("Get Capacity by City");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeLocationButton);
        add(capacityByCityButton);
        add(new JScrollPane(resultsArea));

        analyzeLocationButton.addActionListener(e -> analyzeByLocation());
        capacityByCityButton.addActionListener(e -> analyzeCapacityByCity());
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

    private void analyzeByLocation(){
        String[] arenas = DataAnalyzer.arenasByLocation((inputField.getText()),file);

        resultsArea.setText("Arenas by Location " + inputField.getText() + ": \n" + string(arenas) + "\n");
    }
    private void analyzeCapacityByCity(){
        int[] capacities = DataAnalyzer.capacityByCity((inputField.getText()),file);

        resultsArea.setText("Capacities by City " + inputField.getText() + ": \n" + string_int(capacities) + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGui().setVisible(true));
    }
}
    