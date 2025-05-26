/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class InputData extends JFrame {

    ControllerKandidat controller;

    JLabel header = new JLabel("Input Dosen");
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
        setSize(480, 240);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(labelInputNama);
        add(labelInputPath);
        add(labelInputWriting);
        add(labelInputCoding);
        add(labelInputInterview);
        add(labelInputScore);
        add(labelInputStatus);
        add(inputNama);
        add(inputPath);
        add(inputWriting);
        add(inputCoding);
        add(inputInterview);
        add(inputScore);
        add(inputStatus);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputPath.setBounds(20, 96, 440, 24);
        inputPath.setBounds(18, 120, 440, 36);
        labelInputWriting.setBounds(20, 96, 440, 24);
        inputWriting.setBounds(18, 120, 440, 36);
        labelInputCoding.setBounds(20, 96, 440, 24);
        inputCoding.setBounds(18, 120, 440, 36);
        labelInputInterview.setBounds(20, 96, 440, 24);
        inputInterview.setBounds(18, 120, 440, 36);
        labelInputScore.setBounds(20, 96, 440, 24);
        inputScore.setBounds(18, 120, 440, 36);
        labelInputStatus.setBounds(20, 96, 440, 24);
        inputStatus.setBounds(18, 120, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolTambah.setBounds(240, 160, 215, 40);

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
