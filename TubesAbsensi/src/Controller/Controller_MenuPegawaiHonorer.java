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
public class Controller_MenuPegawaiHonorer implements ActionListener{
    private Aplikasi aplikasi;
    private int indexlistpegawai;
    private String value;
    private MenuPegawaiHonorer mph;
    
    public Controller_MenuPegawaiHonorer(Aplikasi aplikasi,int i){
        this.aplikasi = aplikasi;
        indexlistpegawai = i;
        value = null;
        mph = new MenuPegawaiHonorer();
        //list absensi
        LinkedHashSet<String> s = new LinkedHashSet();
        Pegawai p = aplikasi.getPegawai(i);
        for(int j=0;j<p.getNumOfAbsen();j++){
            s.add(p.getAbsen(j).getId());
        }
        mph.getListdaftarabsen().setListData(new Vector<String>(s));
        mph.add(new JScrollPane(mph.getListdaftarabsen()));
        
        mph.getListdaftarabsen().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent lse) {
                    value = mph.getListdaftarabsen().getSelectedValue();
                    Absensi ab = p.getAbsen(value);
                    if(ab.getStatus() == "Masuk"){
                        mph.getIsiDataAbsen().setText("ID: " + ab.getId()
                            + "\nTanggal: " + ab.getTanggal() 
                            + "\nJam: " + ab.getJam() +" : " + ab.getMenit()
                            + "\nStatus: " + ab.getStatus()
                            + "\nTerlambat : " + ab.getTerlambat());
                    }
                    else
                    {
                        mph.getIsiDataAbsen().setText("ID: " + ab.getId()
                            + "\nTanggal: " + ab.getTanggal() 
                            + "\nJam: " + ab.getJam() +" : " + ab.getMenit()
                            + "\nStatus: " + ab.getStatus());
                    }
                }
            }
        );
        
        mph.addActionListener(this);
        mph.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(mph.getjBtnUbahP())){
            new Controller_UbahPassword(aplikasi, "honorer",indexlistpegawai);
        }
        if (source.equals(mph.getjBtnUbahDataD())){
            new Controller_UbahDataDiri(aplikasi, "honorer",indexlistpegawai);
        }
        mph.dispose();
    }
    
}
