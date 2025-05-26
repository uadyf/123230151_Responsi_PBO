/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Kandidat.*;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControllerKandidat {

    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAOKandidat daoKandidat;

    List<ModelKandidat> daftarKandidat;

    public ControllerKandidat(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoKandidat = new DAOKandidat();
    }

    public ControllerKandidat(InputData halamanInput) {
        this.halamanInput = halamanInput;
        this.daoKandidat = new DAOKandidat();
    }

    public ControllerKandidat(EditData halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoKandidat = new DAOKandidat();
    }

    public void showAllKandidat() {
        daftarKandidat = daoKandidat.getAll();
        ModelTable table = new ModelTable(daftarKandidat);
        halamanTable.getTableKandidat().setModel(table);
    }

    public void insertKandidat() {
        try {
            ModelKandidat kandidatBaru = new ModelKandidat();
            String nama = halamanInput.getInputNama();
            String path = halamanInput.getInputPath();
            Integer writing = Integer.parseInt(halamanInput.getInputWriting());
            Integer coding = Integer.parseInt(halamanInput.getInputCoding());
            Integer interview = Integer.parseInt(halamanInput.getInputInterview());
            Double score = Double.parseDouble(halamanInput.getInputScore());
            String status = halamanInput.getInputStatus();
            

            if ("".equals(nama) || "".equals(path) || "".equals(status)) {
                throw new Exception("Data tidak boleh kosong!");
            }

            kandidatBaru.setName(nama);
            kandidatBaru.setPath(path);
            kandidatBaru.setWriting(writing);
            kandidatBaru.setCoding(coding);
            kandidatBaru.setInterview(interview);
            kandidatBaru.setScore(score);
            kandidatBaru.setStatus(status);
            

            daoKandidat.insert(kandidatBaru);

            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editKandidat(int id) {
        try {
            ModelKandidat kandidatEdit = new ModelKandidat();

            String nama = halamanInput.getInputNama();
            String path = halamanInput.getInputPath();
            Integer writing = Integer.parseInt(halamanInput.getInputWriting());
            Integer coding = Integer.parseInt(halamanInput.getInputCoding());
            Integer interview = Integer.parseInt(halamanInput.getInputInterview());
            Double score = Double.parseDouble(halamanInput.getInputScore());
            String status = halamanInput.getInputStatus();

            if ("".equals(nama) || "".equals(path) || "".equals(status)) {
                throw new Exception("Data tidak boleh kosong!");
            }

            kandidatEdit.setName(nama);
            kandidatEdit.setPath(path);
            kandidatEdit.setWriting(writing);
            kandidatEdit.setCoding(coding);
            kandidatEdit.setInterview(interview);
            kandidatEdit.setScore(score);
            kandidatEdit.setStatus(status);

            daoKandidat.update(kandidatEdit);

            JOptionPane.showMessageDialog(null, "Data kandidat berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteKandidat(Integer baris) {
        Integer id = (int) halamanTable.getTableKandidat().getValueAt(baris, 0);
        String nama = halamanTable.getTableKandidat().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Kandidat",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoKandidat.delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllKandidat();
        }
    }
}
