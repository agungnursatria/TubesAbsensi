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
public class Controller_TambahDepartemen implements ActionListener{
    private Aplikasi aplikasi;
    private TambahDepartemen td;
    
    public Controller_TambahDepartemen(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        td = new TambahDepartemen();
        td.addActionListener(this);
        td.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(td.getJbtnSubmit())){
            aplikasi.CreateDepartemen(td.getTxtNama().getText().toString());
            td.dispose();
            new Controller_MenuAdmin(aplikasi);
        }
    }
    
    
}
