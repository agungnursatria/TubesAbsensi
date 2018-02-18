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

public class PegawaiHonorer extends Pegawai{
    private ArrayList<Integer> total_jamkerjaperbulan; //Perhitungan perbulan
    private double gaji_perjam;
    private int lama_kontrak; //dalam bulan
    
    public PegawaiHonorer(String username, String password, String id_pegawai, String nama, int umur, String alamat, String email, char jenis_kelamin,double gaji_perjam, int lama_kontrak){
        super(username, password, id_pegawai, nama, umur, alamat, email, jenis_kelamin);
        this.gaji_perjam = gaji_perjam;
        this.lama_kontrak = lama_kontrak;
        total_jamkerjaperbulan = new ArrayList();
    }
    
    public double getGaji_perjam(){
        return gaji_perjam;
    }
    
    public int getLama_Kontrak(){
        return lama_kontrak;
    }
    
    public int getJamKerjaSebulan(int i){
        return total_jamkerjaperbulan.get(i);
    }
    
    public void setGaji_perjam(double gaji_pejam){
        this.gaji_perjam = gaji_perjam;
    }
    
    public void setLama_Kontrak(int lama_kontrak){
        this.lama_kontrak = lama_kontrak;
    }
    
    public void setJamKerja(int i,int jumjam){ // i menyatakan bulan ke-
        if(total_jamkerjaperbulan.size()<i){
            total_jamkerjaperbulan.add(jumjam);
        }
        else
        {
            total_jamkerjaperbulan.set(i,(total_jamkerjaperbulan.get(i)+jumjam));
        }
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
