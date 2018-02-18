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
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Agung Nursatria
 */
public class Controller_PilihPegawaiTetap implements ActionListener {
    private Aplikasi aplikasi;
    private PilihPegawaiTetap ppt;
    private String dept;

    public Controller_PilihPegawaiTetap(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        dept = null;
        ppt = new PilihPegawaiTetap();
        ppt.addActionListener(this);
        LinkedHashSet<String> s = new LinkedHashSet();
        for(int i=0;i<aplikasi.getPerusahaan().getNumofDepartemen();i++){
              s.add(aplikasi.getPerusahaan().getDepartemen(i).getNama());
        }
        ppt.getListpildept().setListData(new Vector<String>(s));
        ppt.add(new JScrollPane(ppt.getListpildept()));
        ppt.getjScrollPane1().setViewportView(ppt.getListpildept());
        
        ppt.getListpildept().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent lse) {
                    dept = ppt.getListpildept().getSelectedValue().toString();
                }
            }
        );
        ppt.setVisible(true);
    }
    
    public Aplikasi getAplikasi(){
        return aplikasi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
          Object source = ae.getSource();
          if(source.equals(ppt.getJbtnSubmit()))
          {
            //masukkan data ke aplikasi dan database
            aplikasi.pasangPilihanPegawaiTetap(Double.parseDouble(ppt.getTxtGaji().getText().toString()), dept);
            JOptionPane.showMessageDialog(ppt, "Pegawai Baru Berhasil Ditambahkan");
            ppt.dispose();
            new Controller_MenuAdmin(aplikasi);
          }
    }
    
    
}
