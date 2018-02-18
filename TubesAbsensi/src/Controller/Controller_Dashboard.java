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
public class Controller_Dashboard implements ActionListener{
    private Aplikasi aplikasi;
    private Dashboard db;
    
    public Controller_Dashboard(){
        aplikasi = new Aplikasi();
        db = new Dashboard();
        db.addActionListener(this);
        db.setVisible(true);
    }
    
    public Controller_Dashboard(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        db = new Dashboard();
        db.addActionListener(this);
        db.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(db.getjBtnAbsen()))
        {
            new Controller_Absen(aplikasi);
            db.dispose();
        }
        if(source.equals(db.getjBtnInfo())){
            new Controller_Info(aplikasi.getPerusahaan());
        }
        if(source.equals(db.getjBtnLogin())){
            new Controller_Login(aplikasi);
            db.dispose();
        }
    }
}
