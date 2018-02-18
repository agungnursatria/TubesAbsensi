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
import javax.swing.JTextField;
/**
 *
 * @author Agung Nursatria
 */
public class Controller_EditPerusahaan implements ActionListener{
    private Aplikasi aplikasi;
    private EditPerusahaan ep;
    
    public Controller_EditPerusahaan(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        ep = new EditPerusahaan();
//        ep.setTxtNamaPerusahaan(new JTextField(aplikasi.getPerusahaan().getNama()));
//        ep.setTxtAlamat(new JTextField(aplikasi.getPerusahaan().getAlamat()));
//        ep.setTxtKontak(new JTextField(aplikasi.getPerusahaan().getNomorKontak()));
        ep.getTxtNamaPerusahaan().setText(aplikasi.getPerusahaan().getNama());
        ep.getTxtKontak().setText(aplikasi.getPerusahaan().getNomorKontak());
        ep.getTxtAlamat().setText(aplikasi.getPerusahaan().getAlamat());
        ep.addActionListener(this);
        ep.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ep.getJbtnSubmit())){
            // isi data di aplikasi
            aplikasi.rubahPerusahaan(ep.getTxtNamaPerusahaan().getText().toString(), ep.getTxtAlamat().getText().toString(), ep.getTxtKontak().getText().toString());
            ep.dispose();
            new Controller_MenuAdmin(aplikasi);
        }
    }
}
