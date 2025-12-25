package org.example;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MoodManager {

    public static ArrayList<Mood> moods = new ArrayList<>();
    private static final String DIR_NAME = "data";
    private static final String FILE_NAME = "data/moods.csv";

    public static void loadData() {
        moods.clear();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 3);
                moods.add(new Mood(data[0], data[1], data[2]));
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal load data!");
        }
    }

    public static void saveData() {
        try {
            File dir = new File(DIR_NAME);
            if (!dir.exists()) dir.mkdir();

            File file = new File(FILE_NAME);
            if (!file.exists()) file.createNewFile();

            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (Mood m : moods) {
                pw.println(m.toCSV());
            }
            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan CSV!");
        }
    }
}
