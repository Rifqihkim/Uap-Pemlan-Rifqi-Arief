package org.example;
import javax.swing.*;
import java.time.LocalDate;

public class MoodFormFrame extends JFrame {

    public MoodFormFrame(Mood mood, int index) {
        setTitle("Form Mood");
        setSize(350,300);
        setLocationRelativeTo(null);

        JTextField txtDate = new JTextField(
                mood == null ? LocalDate.now().toString() : mood.getDate());
        JComboBox<String> cmbMood = new JComboBox<>(
                new String[]{"Happy","Sad","Angry","Calm","Excited"});
        JTextArea txtNote = new JTextArea(4,20);

        if (mood != null) {
            cmbMood.setSelectedItem(mood.getMood());
            txtNote.setText(mood.getNote());
        }

        JButton btnSave = new JButton("Save");

        btnSave.addActionListener(e -> {
            try {
                if (txtNote.getText().isEmpty()) {
                    throw new Exception("Catatan kosong");
                }

                if (mood == null) {
                    MoodManager.moods.add(
                            new Mood(txtDate.getText(),
                                    cmbMood.getSelectedItem().toString(),
                                    txtNote.getText()));
                } else {
                    mood.setMood(cmbMood.getSelectedItem().toString());
                    mood.setNote(txtNote.getText());
                    MoodManager.moods.set(index, mood);
                }

                MoodManager.saveData();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid");
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Tanggal"));
        add(txtDate);
        add(new JLabel("Mood"));
        add(cmbMood);
        add(new JLabel("Catatan"));
        add(new JScrollPane(txtNote));
        add(btnSave);

        setVisible(true);
    }
}

