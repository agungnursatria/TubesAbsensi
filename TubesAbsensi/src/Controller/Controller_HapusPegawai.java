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
public class Controller_HapusPegawai implements ActionListener{
    private Aplikasi aplikasi;
    private HapusPegawai hp;
    
    public Controller_HapusPegawai(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        hp = new HapusPegawai();
        hp.addActionListener(this);
        hp.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       try{
        if(source.equals(hp.getJbtnSubmit())){
           //simpan di aplikasi, & database, lalu return data
           hp.dispose();
           new Controller_MenuAdmin(aplikasi);
        }
       } catch (Exception e){
           JOptionPane.showMessageDialog(hp, e.getMessage());
       }
       hp.Reset();
    }
    
    
}
