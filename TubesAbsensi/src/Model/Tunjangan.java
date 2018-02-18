package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agung Nursatria
 */
public class Tunjangan {
    private String nama;
    private double jumlah;
    
    public Tunjangan(String nama,double jumlah){
        this.nama = nama;
        this.jumlah = jumlah;
    }
    
    public String getNama(){
        return nama;
    }
    
    public double getJumlah(){
        return jumlah;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setJumlah(double jumlah){
        this.jumlah = jumlah;
    }
}   

