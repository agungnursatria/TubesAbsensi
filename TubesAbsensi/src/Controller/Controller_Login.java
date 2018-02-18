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
public class Controller_Login implements ActionListener{
    private Aplikasi aplikasi;
    private Login lgn;
    
    public Controller_Login(Aplikasi aplikasi){
        this.aplikasi = aplikasi;
        lgn = new Login();
        lgn.addActionListener(this);
        lgn.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       try{
        if(source.equals(lgn.getJbtnLupa())){
           //open controller lupa password
           new Controller_LupaPass(aplikasi);
//           JOptionPane.showMessageDialog(lgn, "haii");
        }
        if(source.equals(lgn.getJbtnSubmit())){
           //open controller menu admin/pegawaihonorer/pegawaitetap
           try{
               if(lgn.LoginAdmin()){
                    new Controller_MenuAdmin(aplikasi);
                    lgn.dispose();
                }
                else
                {
                    Pegawai p = aplikasi.getPegawaiLogin(lgn.getTxtUsername().getText(),lgn.getTxtPassword().getText());
                    int i = aplikasi.getIndexPegawaiArray(p);
                    if(p!=null){
                        if(p instanceof PegawaiTetap){
                            new Controller_MenuPegawaiTetap(aplikasi,i);
                        }
                        else if(p instanceof PegawaiHonorer){
                            new Controller_MenuPegawaiHonorer(aplikasi,i);
                        }
                    }
                }
           }catch (Exception e){
               lgn.Reset();
               JOptionPane.showMessageDialog(lgn, "username atau password salah");
           }
        }
       } catch (Exception e){
          JOptionPane.showMessageDialog(lgn, e.getMessage());
       }
    }
}
