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


public class Pegawai {
    private String username;
    private String password;
    private String id_pegawai;
    private String nama;
    private int umur;
    private String alamat;
    private String email;
    private char jenis_kelamin;
    private ArrayList<Absensi> absensi;
    
    public Pegawai(String username, String password,String id_pegawai, String nama, int umur, String alamat, String email,char jenis_kelamin){
        this.absensi = new ArrayList();
        this.username = username;
        this.password = password;
        this.id_pegawai = id_pegawai;
        this.umur = umur;
        this.alamat = alamat;
        this.email = email;
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getIdPegawai(){
        return id_pegawai;
    }
    
    public int getUmur(){
        return umur;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getJK(){
        return ((jenis_kelamin == 'L') ? "Laki-laki" : "Perempuan");
    }
    
    public int getNumOfAbsen(){
        return absensi.size();
    }
    
    public Absensi getAbsen(int i){
        return absensi.get(i);
    }
    
    public Absensi getAbsen(String id){
        for (Absensi ab : absensi) {
            if(ab.getId().equals(id)){
                return absensi.get(absensi.indexOf(ab));
            }
        }
        return null;
    }
    
    public void createAbsen(int jam,int menit,String tanggal, String status){
        String id_absensi;
        if(status == "Masuk"){
            id_absensi = "M"+(absensi.size()+1);
        } else
        {
            id_absensi = "K"+(absensi.size()+1);
        }
        absensi.add(new Absensi(id_absensi,jam,menit,tanggal,status));
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setId(String id_pegawai){
        this.id_pegawai = id_pegawai;
    }
    
    public void setUmur(int umur){
        this.umur = umur;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setJK(char jenis_kelamin){
        this.jenis_kelamin = jenis_kelamin;
    }
}
