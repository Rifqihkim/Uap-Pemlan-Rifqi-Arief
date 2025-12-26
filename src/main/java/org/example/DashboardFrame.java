package org.example;
import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Mood Tracker - Dashboard");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnInput = new JButton("Input Mood");
        JButton btnList = new JButton("List Mood");
        JButton btnReport = new JButton("Laporan");

        btnInput.addActionListener(e -> new MoodFormFrame(null, -1));
        btnList.addActionListener(e -> new MoodListFrame());
        btnReport.addActionListener(e -> new ReportFrame());

        setLayout(new GridLayout(3,1,10,10));
        add(btnInput);
        add(btnList);
        add(btnReport);

        setVisible(true);
    }
}
