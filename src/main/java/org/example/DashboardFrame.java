package org.example;
import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Mood Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnInput = new JButton("Input Mood");
        JButton btnList = new JButton("List Mood");
        JButton btnReport = new JButton("Laporan Mood");

        btnInput.addActionListener(e -> new MoodFormFrame());
        btnList.addActionListener(e -> new MoodListFrame());
        btnReport.addActionListener(e -> new ReportFrame());

        setLayout(new GridLayout(3, 1, 10, 10));
        add(btnInput);
        add(btnList);
        add(btnReport);

        setVisible(true);
    }
}
