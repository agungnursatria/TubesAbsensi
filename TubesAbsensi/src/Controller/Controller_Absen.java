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
public class Controller_Absen implements ActionListener{
    private Aplikasi aplikasi;
    private Absen ab;
    
    public Controller_Absen(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        ab = new Absen();
        ab.addActionListener(this);
        ab.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try{
            if (source.equals(ab.getJbtnSubmit())){
                // masukin data ke aplikasi
                // save data ke database
                String status;
                if(ab.getRButKeluar().isSelected()== true){
                    status = ab.getRButKeluar().getText();
                }
                else
                {
                    status = ab.getRButMasuk().getText();
                }
                String tanggal = ab.getTxtHari()+"-"+ab.getTxtBulan()+"-"+ab.getTxtTahun();
                aplikasi.CreateAbsen(Integer.parseInt(ab.getTxtJam().getText()),Integer.parseInt(ab.getTxtMenit().getText()), tanggal, status, ab.getTxtId().getText());
                JOptionPane.showMessageDialog(ab,"Data Berhasil Terinput");
                ab.dispose();
                new Controller_Dashboard(aplikasi);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(ab, "Inputan Salah");
        } 
        ab.Reset();
    }
    
    
}
