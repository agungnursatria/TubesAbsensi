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
public class Absensi {
    private String id_absensi;
    private int jam;
    private int menit;
    private String tanggal;
    private String status;
    private boolean terlambat;
    
    public Absensi(String id_absensi,int jam, int menit, String tanggal, String status){
        this.id_absensi = id_absensi;
        this.jam = jam;
        this.menit = menit;
        this.tanggal = tanggal;
        this.status = status;
        if(status == "Masuk"){
            terlambat = (((jam == 7 && menit <= 30) || jam < 7) ? false : true);
        }                
    }
    
    public Absensi(){}
    
    public String getId(){
        return id_absensi;
    }
    
    public int getJam(){
        return jam;
    }
    
    public int getMenit(){
        return menit;
    }
    
    
    public String getTanggal(){
        return tanggal;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String getTerlambat(){
        return ((terlambat==true) ? "Terlambat" : "Tidak Terlambat");
    }
    
    public void setId(String id_absensi){
        this.id_absensi = id_absensi;
    }
    
    public void setJam(int jam){
        this.jam = jam;
    }
    
    public void setMenit(int menit){
        this.menit = menit;
    }
    
    
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setTerlambat(boolean terlambat){
        this.terlambat = terlambat;
    }
    
}
