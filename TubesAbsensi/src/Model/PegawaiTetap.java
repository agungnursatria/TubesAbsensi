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
public class PegawaiTetap extends Pegawai{
    private double gaji;
    private ArrayList<Tunjangan> tunjangan;

    public PegawaiTetap(String username, String password, String id_pegawai, String nama, int umur, String alamat, String email, char jenis_kelamin,double gaji) {
        super(username, password, id_pegawai, nama, umur, alamat, email, jenis_kelamin);
        tunjangan = new ArrayList();
        this.gaji = gaji;
    }
    
    public double getGaji(){
        return gaji;
    }
    
    public Tunjangan getTunjangan(int i){
        return tunjangan.get(i);
    }
    
    public int getNumOfTunjangan(){
        return tunjangan.size();
    }
    
    public void setGaji(double gaji){
        this.gaji = gaji;
    }
    
    public void AddTunjangan(Tunjangan t){
        tunjangan.add(t);
    }

    @Override
    public String getUsername() {
        return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNama() {
        return super.getNama(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getIdPegawai() {
        return super.getIdPegawai(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUmur() {
        return super.getUmur(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAlamat() {
        return super.getAlamat(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJK() {
        return super.getJK(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getNumOfAbsen() {
        return super.getNumOfAbsen(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Absensi getAbsen(int i) {
        return super.getAbsen(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createAbsen(int jam, int menit, String tanggal, String status) {
        super.createAbsen(jam, menit, tanggal, status); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setUsername(String username) {
        super.setUsername(username); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setPassword(String password) {
        super.setPassword(password); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setNama(String nama) {
        super.setNama(nama); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setId(String id_pegawai) {
        super.setId(id_pegawai); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setUmur(int umur) {
        super.setUmur(umur); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void setAlamat(String alamat) {
        super.setAlamat(alamat); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setJK(char jenis_kelamin) {
        super.setJK(jenis_kelamin); //To change body of generated methods, choose Tools | Templates.
    }

}
