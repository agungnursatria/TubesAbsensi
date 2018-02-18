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
public class Controller_UbahDataDiri implements ActionListener{
    private Aplikasi aplikasi;
    private int indexlistpegawai;
    private UbahDataDiri udd;
    private String status;
    
    public Controller_UbahDataDiri(Aplikasi aplikasi,String status,int i){
        this.aplikasi = aplikasi;
        this.status = status;
        indexlistpegawai = i;
        udd = new UbahDataDiri();
        udd.addActionListener(this);
        udd.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(udd.getJbtnSubmit())){
            // ubah data diri, gunakan update database
            udd.dispose();
            if(status == "tetap"){
                new Controller_MenuPegawaiTetap(aplikasi,indexlistpegawai);
            }
            else
            {
                new Controller_MenuPegawaiHonorer(aplikasi,indexlistpegawai);
            }
        }
    }
    
}
