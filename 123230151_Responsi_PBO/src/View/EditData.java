/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.*;
import Model.Kandidat.*;
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
public class EditData extends JFrame {
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
    JButton tombolEdit = new JButton("Edit Kandidat");
    JButton tombolKembali = new JButton("Kembali");

    public EditData(ModelKandidat kandidat) {
        setTitle("Edit Kandidat");
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
        add(tombolEdit);
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
        tombolEdit.setBounds(240, 160, 215, 40);
        
        inputNama.setText(kandidat.getName());
        inputPath.setText(kandidat.getPath());
        inputWriting.setText(kandidat.getWriting().toString());
        inputCoding.setText(kandidat.getCoding().toString());
        inputInterview.setText(kandidat.getInterview().toString());
        inputScore.setText(Double.toString(kandidat.getScore()));
        inputStatus.setText(kandidat.getStatus());
        
        controller = new ControllerKandidat(this);

        /* 
          Memberikan event handling untuk tombol kembali,
          Ketika tombol kembali diklik, maka akan kembali ke halaman ViewData().
         */
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editKandidat(kandidat.getId());
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
