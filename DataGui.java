import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private FileOperator file = new FileOperator("data/arenas.txt");
    private  static Basketball ball = new Basketball();
    public static int counter = 0;
    
    public DataGUI() {
        setTitle("Arena Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeTeamButton = new JButton("Analyze by Team");
        JButton commonLocationButton = new JButton("Get Most Common Arena Location");
        JButton saveScreenButton = new JButton("Save Screen");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeTeamButton);
        add(commonLocationButton);
        add(new JScrollPane(resultsArea));
        add(saveScreenButton);

        analyzeTeamButton.addActionListener(e -> analyzeByTeam());
        commonLocationButton.addActionListener(e -> getMostCommonArena());
        saveScreenButton.addActionListener(e -> saveScreen());
    }

    private static String stringify(String[] arr) {
        String result = "";
        for(String s : arr) {
            result += s + "\n";
        }
        return result;
    }
    public static Team getTeam(int index){
        for(Team team: ball.getTeams()){
            if(index == team.getID()){
                return team;
            }
        }
        return ball.getTeams().get(0);
    }
    private static String stringify_int(int[] arr) {
        String result = "";
        for(int s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private void analyzeByTeam(){
        int index = Basketball.arenasbyTeam(inputField.getText());

        resultsArea.setText("Arenas by Team " + inputField.getText() + ": \n" + getTeam(index) + "\n");
    }


    private void getMostCommonArena(){
        int index = Basketball.findMostCommonArena(file);
        resultsArea.setText("Most Common Arena: " + getTeam(index).getLocation());
    }

    public void saveScreen(){
        counter++;
        try{
            int w = resultsArea.getWidth();
            int h = resultsArea.getHeight();
            int type =BufferedImage.TYPE_INT_ARGB;
            BufferedImage sshot = new BufferedImage(w,h,type);

            Graphics2D g2d = sshot.createGraphics();
            resultsArea.paint(g2d);

            File out = new File("Search "+ counter + ".png");
            ImageIO.write(sshot,"png",out);
            g2d.dispose();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}
    