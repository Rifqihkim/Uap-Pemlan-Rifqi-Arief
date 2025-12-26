package org.example;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MoodManager {

    public static ArrayList<Mood> moods = new ArrayList<>();
    private static final String DIR = "data";
    private static final String FILE = "data/moods.csv";

    public static void loadData() {
        moods.clear();
        try {
            File file = new File(FILE);
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",", 3);
                moods.add(new Mood(d[0], d[1], d[2]));
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal load data");
        }
    }

    public static void saveData() {
        try {
            File dir = new File(DIR);
            if (!dir.exists()) dir.mkdir();

            PrintWriter pw = new PrintWriter(new FileWriter(FILE));
            for (Mood m : moods) {
                pw.println(m.toCSV());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal simpan CSV");
        }
    }
}
