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
public class Controller_UbahPassword implements ActionListener{
    private Aplikasi aplikasi;
    private int indexlistpegawai;
    private UbahPassword up;
    private String status;
    
    public Controller_UbahPassword(Aplikasi aplikasi,String status,int i){
        this.aplikasi = aplikasi;
        this.status = status;
        indexlistpegawai = i;
        up = new UbahPassword();
        up.addActionListener(this);
        up.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(up.getJbtnSubmit())){
            //ubah data password, gunakan database
            up.dispose();
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
