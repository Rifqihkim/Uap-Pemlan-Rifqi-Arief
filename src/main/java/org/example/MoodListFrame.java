package org.example;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MoodListFrame extends JFrame {

    DefaultTableModel model;
    JTable table;
    TableRowSorter<DefaultTableModel> sorter;

    public MoodListFrame() {
        setTitle("List Mood");
        setSize(700,350);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(
                new Object[]{"Tanggal","Mood","Catatan"},0);

        for (Mood m : MoodManager.moods) {
            model.addRow(new Object[]{m.getDate(),m.getMood(),m.getNote()});
        }

        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JTextField txtSearch = new JTextField();
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                sorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }
        });

        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int idx = table.convertRowIndexToModel(row);
                new MoodFormFrame(MoodManager.moods.get(idx), idx);
                dispose();
            }
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int idx = table.convertRowIndexToModel(row);
                MoodManager.moods.remove(idx);
                MoodManager.saveData();
                dispose();
                new MoodListFrame();
            }
        });

        JPanel bottom = new JPanel();
        bottom.add(btnEdit);
        bottom.add(btnDelete);

        add(txtSearch, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MoodListFrame extends JFrame {

    public MoodListFrame() {
        setTitle("Daftar Mood");
        setSize(600, 300);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Tanggal", "Mood", "Catatan"}, 0);

        for (Mood m : MoodManager.moods) {
            model.addRow(new Object[]{
                    m.getDate(),
                    m.getMood(),
                    m.getNote()
            });
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table));

        setVisible(true);
    }
}