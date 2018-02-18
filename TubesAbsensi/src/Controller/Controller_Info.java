/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
/**
 *
 * @author Agung Nursatria
 */
public class Controller_Info{
    private Info info;
    private Perusahaan p;
    
    public Controller_Info(Perusahaan p){
        info = new Info();
        info.set(p.getNama(), p.getAlamat(), p.getNomorKontak(), p.getTotalPegawai());
        info.setVisible(true);
    }    
}
