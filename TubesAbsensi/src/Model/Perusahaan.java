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
import java.util.*;

public class Perusahaan {
    private String nama;
    private String alamat;
    private String nomorkontak;
    private ArrayList<Departemen> departemen;
    
    public Perusahaan(String nama,String alamat,String nomorkontak){
        this.nama = nama;
        this.alamat = alamat;
        this.nomorkontak = nomorkontak;
        departemen = new ArrayList();
    }
    
    public Perusahaan(){
        departemen = new ArrayList();
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public String getNomorKontak(){
        return nomorkontak;
    }
    
    public int getNumofDepartemen(){
        return departemen.size();
    }
    
    public Departemen getDepartemen(int i){
        return departemen.get(i);
    }
    
    public int getIndexDepartemen(String nama){
        for (Departemen d : departemen) {
            if(d.getNama().equals(nama)){
                return departemen.indexOf(d);
            }
        }
        return -1;
    }
    
    public int getTotalPegawai(){
        int total=0;
        for(Departemen d : departemen){
            total+=d.getnumOfPeg();
        }
        return total;
        
        //rubah ambil dari database aja
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public void setNomorKontak(String nomorkontak){
        this.nomorkontak = nomorkontak;
    }
    
    public void createDepartemen(String nama){
        departemen.add(new Departemen(nama));
    }
    
    public int getpegawailogin(String username,String password, int i){
        return departemen.get(i).getPegawaiLogin(username, password);
    }
}
