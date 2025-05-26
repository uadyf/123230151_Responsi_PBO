/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Kandidat.*;
import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ViewData extends JFrame {
    Integer baris;
    
    ControllerKandidat controller;

    JLabel header = new JLabel("Data Kandidat");
    JButton tombolTambah = new JButton("Tambah Kandidat");
    JButton tombolEdit = new JButton("Edit Kandidat");
    JButton tombolHapus = new JButton("Hapus Kandidat");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "Path", "Writing", "Coding", "Interview", "Score", "Status"};

    public ViewData() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Kandidat");
        setVisible(true);
        setSize(552, 580);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 458, 512, 40);

        controller = new ControllerKandidat(this);
        controller.showAllKandidat();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                baris = table.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputData();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    ModelKandidat kandidatTerpilih = new ModelKandidat();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String path = table.getValueAt(baris, 2).toString();
                    Integer writing = Integer.parseInt(table.getValueAt(baris, 3).toString());
                    Integer coding = Integer.parseInt(table.getValueAt(baris, 4).toString());
                    Integer interview = Integer.parseInt(table.getValueAt(baris, 5).toString());
                    double score = Double.parseDouble(table.getValueAt(baris, 6).toString());
                    String status = table.getValueAt(baris, 7).toString();
                    
                    kandidatTerpilih.setId(id);
                    kandidatTerpilih.setName(nama);
                    kandidatTerpilih.setPath(path);
                    kandidatTerpilih.setWriting(writing);
                    kandidatTerpilih.setCoding(coding);
                    kandidatTerpilih.setInterview(interview);
                    kandidatTerpilih.setScore(score);
                    kandidatTerpilih.setStatus(status);
                    
                    dispose();
                    new EditData(kandidatTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteKandidat(baris);

                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
    }

    public JTable getTableKandidat() {
        return table;
    }
}