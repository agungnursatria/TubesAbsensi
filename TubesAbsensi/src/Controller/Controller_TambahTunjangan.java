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
/**
 *
 * @author Agung Nursatria
 */
public class Controller_TambahTunjangan implements ActionListener{
    private Aplikasi aplikasi;
    private int indexlistpegawai;
    private TambahTunjangan tt;
    
    public Controller_TambahTunjangan(Aplikasi aplikasi,int i){
        this.aplikasi = aplikasi;
        indexlistpegawai = i;
        tt = new TambahTunjangan();
        tt.addActionListener(this);
        tt.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(tt.getJbtnSubmit())){
            // masukin data ke aplikasi & database
            tt.dispose();
            new Controller_MenuPegawaiTetap(aplikasi,indexlistpegawai);
        }
    }
    
}
