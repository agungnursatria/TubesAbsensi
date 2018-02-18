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
public class Controller_TambahPegawai implements ActionListener{
    private Aplikasi aplikasi;
    private TambahPegawai tp;
    
    public Controller_TambahPegawai(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        tp = new TambahPegawai();
        tp.getTxtId().setText(Integer.toString(aplikasi.getPerusahaan().getTotalPegawai()+1));
        tp.addActionListener(this);
        tp.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try{
            if (source.equals(tp.getJbtnSubmit())){
                if(!aplikasi.verifikasi(tp.getTxtUsername().getText().toString())){
                    Pegawai p;
                    if(tp.getRButHonorer().isSelected()){
                        p = tp.BuatPegawaiH();
                        aplikasi.AddPegawai(p);
                        new Controller_PilihPegawaiHonorer(aplikasi);
                    }else{
                        p = tp.BuatPegawaiT();
                        aplikasi.AddPegawai(p);
                        new Controller_PilihPegawaiTetap(aplikasi);
                    }
                    tp.dispose();
                }
                else
                {
                    throw new IllegalArgumentException("Username sudah digunakan");
                }
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(tp, "Terjadi Kesalahan Input");
        } catch (Exception e){
            JOptionPane.showMessageDialog(tp,e.getMessage());
        }
        tp.Reset();
        tp.getTxtId().setText(Integer.toString(aplikasi.getPerusahaan().getTotalPegawai()+1));
    }
    
    
}
