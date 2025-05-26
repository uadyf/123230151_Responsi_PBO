package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputData extends JFrame {

    ControllerKandidat controller;

    JLabel header = new JLabel("Input Kandidat");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputPath = new JLabel("Path");
    JLabel labelInputWriting = new JLabel("Writing");
    JLabel labelInputCoding = new JLabel("Coding");
    JLabel labelInputInterview = new JLabel("Interview");
    JLabel labelInputScore = new JLabel("Score");
    JLabel labelInputStatus = new JLabel("Status");

    JTextField inputNama = new JTextField();
    JTextField inputPath = new JTextField();
    JTextField inputWriting = new JTextField();
    JTextField inputCoding = new JTextField();
    JTextField inputInterview = new JTextField();
    JTextField inputScore = new JTextField();
    JTextField inputStatus = new JTextField();

    JButton tombolTambah = new JButton("Tambah Kandidat");
    JButton tombolKembali = new JButton("Kembali");

    public InputData() {
        setTitle("Input Kandidat");
        setVisible(true);
        setSize(500, 600); // Ukuran lebih realistis
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(labelInputNama);
        add(inputNama);
        add(labelInputPath);
        add(inputPath);
        add(labelInputWriting);
        add(inputWriting);
        add(labelInputCoding);
        add(inputCoding);
        add(labelInputInterview);
        add(inputInterview);
        add(labelInputScore);
        add(inputScore);
        add(labelInputStatus);
        add(inputStatus);
        add(tombolTambah);
        add(tombolKembali);

        int y = 20;
        int spacing = 60;

        header.setBounds(20, y, 200, 24);
        y += spacing;

        labelInputNama.setBounds(20, y, 100, 24);
        inputNama.setBounds(150, y, 300, 24);
        y += spacing;

        labelInputPath.setBounds(20, y, 100, 24);
        inputPath.setBounds(150, y, 300, 24);
        y += spacing;

        labelInputWriting.setBounds(20, y, 100, 24);
        inputWriting.setBounds(150, y, 300, 24);
        y += spacing;

        labelInputCoding.setBounds(20, y, 100, 24);
        inputCoding.setBounds(150, y, 300, 24);
        y += spacing;

        labelInputInterview.setBounds(20, y, 100, 24);
        inputInterview.setBounds(150, y, 300, 24);
        y += spacing;

        labelInputScore.setBounds(20, y, 100, 24);
        inputScore.setBounds(150, y, 300, 24);
        y += spacing;

        labelInputStatus.setBounds(20, y, 100, 24);
        inputStatus.setBounds(150, y, 300, 24);
        y += spacing;

        tombolKembali.setBounds(20, y, 200, 30);
        tombolTambah.setBounds(250, y, 200, 30);

        controller = new ControllerKandidat(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertKandidat();
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputPath() {
        return inputPath.getText();
    }

    public String getInputWriting() {
        return inputWriting.getText();
    }

    public String getInputCoding() {
        return inputCoding.getText();
    }

    public String getInputInterview() {
        return inputInterview.getText();
    }

    public String getInputScore() {
        return inputScore.getText();
    }

    public String getInputStatus() {
        return inputStatus.getText();
    }
}
