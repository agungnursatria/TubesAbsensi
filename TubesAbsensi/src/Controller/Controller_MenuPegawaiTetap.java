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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Agung Nursatria
 */
public class Controller_MenuPegawaiTetap implements ActionListener{
    private Aplikasi aplikasi;
    private int indexlistpegawai;
    private String value;
    private MenuPegawaiTetap mpt;
    
    public Controller_MenuPegawaiTetap(Aplikasi aplikasi,int i){
        this.aplikasi = aplikasi;
        indexlistpegawai = i;
        value = null;
        mpt = new MenuPegawaiTetap();
        
        // List Absensi
        LinkedHashSet<String> s = new LinkedHashSet();
        Pegawai p = aplikasi.getPegawai(i);
        for(int j=0;j<p.getNumOfAbsen();j++){
            s.add(p.getAbsen(j).getId());
        }
        mpt.getListdaftarabsen().setListData(new Vector<String>(s));
        mpt.add(new JScrollPane(mpt.getListdaftarabsen()));
        
        mpt.getListdaftarabsen().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent lse) {
                    value = mpt.getListdaftarabsen().getSelectedValue();
                    Absensi ab = p.getAbsen(value);
                    if(ab.getStatus() == "Masuk"){
                        mpt.getIsiDataAbsen().setText("ID: " + ab.getId()
                            + "\nTanggal: " + ab.getTanggal() 
                            + "\nJam: " + ab.getJam() +" : " + ab.getMenit()
                            + "\nStatus: " + ab.getStatus()
                            + "\nTerlambat : " + ab.getTerlambat());
                    }
                    else
                    {
                        mpt.getIsiDataAbsen().setText("ID: " + ab.getId()
                            + "\nTanggal: " + ab.getTanggal() 
                            + "\nJam: " + ab.getJam() +" : " + ab.getMenit()
                            + "\nStatus: " + ab.getStatus());
                    }
                }
            }
        );
        mpt.addActionListener(this);
        mpt.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(mpt.getjBtnTambahT())){
            new Controller_TambahTunjangan(aplikasi,indexlistpegawai);
        }
        if (source.equals(mpt.getjBtnUbahDataD())){
            new Controller_UbahDataDiri(aplikasi, "tetap",indexlistpegawai);
        }
        if (source.equals(mpt.getjBtnUbahP())){
            new Controller_UbahPassword(aplikasi, "tetap",indexlistpegawai);
        }
        mpt.dispose();
        
    }
}
