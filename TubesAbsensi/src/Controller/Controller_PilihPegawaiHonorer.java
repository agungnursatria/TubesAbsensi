/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.*;
import View.*;
import java.util.LinkedHashSet;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Agung Nursatria
 */
public class Controller_PilihPegawaiHonorer implements ActionListener{
    private Aplikasi aplikasi;
    private PilihPegawaiHonorer pph;
    private String dept;
    
    public Controller_PilihPegawaiHonorer(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        dept = null;
        pph = new PilihPegawaiHonorer();
        pph.addActionListener(this);
        LinkedHashSet<String> s = new LinkedHashSet();
        for(int i=0;i<aplikasi.getPerusahaan().getNumofDepartemen();i++){
              s.add(aplikasi.getPerusahaan().getDepartemen(i).getNama());
        }
        pph.getListpildept().setListData(new Vector<String>(s));    
        pph.add(new JScrollPane(pph.getListpildept()));
        pph.getjScrollPane1().setViewportView(pph.getListpildept());
        
        pph.getListpildept().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent lse) {
                    dept = pph.getListpildept().getSelectedValue().toString();
                }
            }
        );
        
        pph.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(pph.getJbtnSubmit())){
            //masukkan data ke aplikasi dan database
            aplikasi.pasangPilihanPegawaiHonorer(Double.parseDouble(pph.getTxtGajiPerjam().getText().toString()), Integer.parseInt(pph.getTxtLamaKontrak().getText().toString()), dept);
            JOptionPane.showMessageDialog(pph, "Pegawai Baru Berhasil Ditambahkan");
            pph.dispose();
            new Controller_MenuAdmin(aplikasi);
        }
    }
    
    
}
