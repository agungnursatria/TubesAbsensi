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
public class Controller_LupaPass implements ActionListener{
    private LupaPass lp;
    private Aplikasi aplikasi;
    
    public Controller_LupaPass(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        lp = new LupaPass();
        lp.addActionListener(this);
        lp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       try{
        if(source.equals(lp.getJbtnSubmit()))
        {
           Pegawai p = aplikasi.LupaPass(lp.getTxtId().getText().toString(), lp.getTxtUsername().getText().toString());
           if(p!=null){
               JOptionPane.showMessageDialog(lp, "Password = "+p.getPassword());
               lp.dispose();                   
           }
           else
           {
               JOptionPane.showMessageDialog(lp, "Akun tidak ditemukan");
               lp.Reset();
           }
        }
        } catch (Exception e){
           JOptionPane.showMessageDialog(lp, "Inputan salah");
        }
    }
}
