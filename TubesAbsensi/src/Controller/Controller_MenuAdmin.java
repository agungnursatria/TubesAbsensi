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
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Vector;
import javax.swing.JScrollPane;
/**
 *
 * @author Agung Nursatria
 */
public class Controller_MenuAdmin implements ActionListener{
    private Aplikasi aplikasi;
    private MenuAdmin ma;
    
    public Controller_MenuAdmin(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        ma = new MenuAdmin();
        ma.addActionListener(this);
        LinkedHashSet<String> s = new LinkedHashSet();
        
        // List Pegawai
        ArrayList<Pegawai> p = aplikasi.getPegawai();
        if(p!=null){
            for (Pegawai p1 : p) {
                s.add(p1.getNama());
            }
            ma.getjListPegawai().setListData(new Vector<String>(s));
            ma.add(new JScrollPane(ma.getjListPegawai()));
            ma.getjScrollPane1().setViewportView(ma.getjListPegawai());
        }
        
        //List Departemen
        for(int i=0;i<aplikasi.getPerusahaan().getNumofDepartemen();i++){
              s.add(aplikasi.getPerusahaan().getDepartemen(i).getNama());
        }
        ma.getjListDepartemen().setListData(new Vector<String>(s));
        ma.add(new JScrollPane(ma.getjListDepartemen()));
        ma.getjScrollPane3().setViewportView(ma.getjListDepartemen());
        ma.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       if(source.equals(ma.getJbtnTambahP())){
           new Controller_TambahPegawai(aplikasi);
       }
       if(source.equals(ma.getJbtnTambahD())){
           new Controller_TambahDepartemen(aplikasi);
       }
       if(source.equals(ma.getjBtnHapusP())){
           new Controller_HapusPegawai(aplikasi);
       }
       if(source.equals(ma.getjBtnLogOut())){
           new Controller_Dashboard(aplikasi);
       }
       if(source.equals(ma.getJbtnEditPerusahaan()))
       {
           new Controller_EditPerusahaan(aplikasi);
       }
       ma.dispose();
    }
}
