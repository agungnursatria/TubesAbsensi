/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.TambahPegawai;
import java.util.ArrayList;
/**
 *
 * @author Agung Nursatria
 */
public class Aplikasi {
    Perusahaan perusahaan;
    ArrayList<Pegawai> daftarpegawai;
    ArrayList<Tunjangan> daftarTunjangan;
    Database db;
    
    public Aplikasi(){
        db = new Database();
        db.connect();
        perusahaan = new Perusahaan();
        perusahaan = db.loadPerusahaan();
        daftarpegawai = db.loadPegawai();
        daftarTunjangan = db.loadTunjangan();
    }
    
    
    public void AddPegawai(Pegawai p,String namadept){
        int i = perusahaan.getIndexDepartemen(namadept);
        perusahaan.getDepartemen(i).AddPegawai(p);
        db.savePegawai(p, namadept);
    } 
    
    public void AddPegawai(Pegawai p){
        daftarpegawai.add(p);
    }
    
    public void AddTunjangan(Tunjangan t,String id)
    {
        daftarTunjangan.add(t);
        db.saveTunjangan(t, id);
    }
    
    public void CreateDepartemen(String nama){
        perusahaan.createDepartemen(nama);
        db.saveDepartemen(nama, perusahaan.getNama());
    } 
    
    public void CreateAbsen(int jam,int menit,String tanggal,String Status, String id_absensi){
        int i = daftarpegawai.indexOf(id_absensi);
        daftarpegawai.get(i).createAbsen(jam, menit, tanggal, Status);
        Absensi a = new Absensi(daftarpegawai.get(i).getIdPegawai(),jam,menit,tanggal,Status);
        if(daftarpegawai.get(i) instanceof PegawaiHonorer){
            db.saveAbsenp_honorer(a, id_absensi);
        }
        else
        {
            db.saveAbsenp_tetap(a, id_absensi);
        }
    }
    
    public Perusahaan getPerusahaan(){
        return perusahaan;
    }
    
    public ArrayList<Pegawai> getPegawai(){
        return daftarpegawai;
    }
    
    public Pegawai getPegawai(int i){
        return daftarpegawai.get(i);
    }
    
    public Pegawai getPegawaiLogin(String username,String password){  //mencari pegawai di objek arraylist pegawai
        for (Pegawai pegawai : daftarpegawai) {
            if(pegawai.getUsername().equals(username) && pegawai.getPassword().equals(password)){
                return pegawai;
            }
        }
        return null;
    }
    
    public int getIndexPegawaiDepartemen(Pegawai p,Departemen d){   //mencari pegawai di objek perusahaan
        return d.getIndexPegawai(p.getIdPegawai());
    }
    
    public int getIndexPegawaiArray(Pegawai p){
        return daftarpegawai.indexOf(p);
    }
    
    public void pasangPilihanPegawaiTetap(double gaji,String namadept){
        ((PegawaiTetap) daftarpegawai.get(daftarpegawai.size()-1)).setGaji(gaji);
        AddPegawai(daftarpegawai.get(daftarpegawai.size()-1), namadept);
        db.savePegawai(daftarpegawai.get(daftarpegawai.size()-1), namadept);
    }
    
    public void pasangPilihanPegawaiHonorer(double gaji_perjam,int lama_kontrak,String namadept){
        ((PegawaiHonorer) daftarpegawai.get(daftarpegawai.size()-1)).setGaji_perjam(gaji_perjam);
        ((PegawaiHonorer) daftarpegawai.get(daftarpegawai.size()-1)).setLama_Kontrak(lama_kontrak);
        AddPegawai(daftarpegawai.get(daftarpegawai.size()-1), namadept);
        db.savePegawai(daftarpegawai.get(daftarpegawai.size()-1), namadept);
    }
    
    public void rubahPerusahaan(String nama,String alamat,String kontak){
        String namalama = perusahaan.getNama();
        perusahaan.setNama(nama);
        perusahaan.setAlamat(alamat);
        perusahaan.setNomorKontak(kontak);
        db.updatePerusahaan(perusahaan, namalama);
    }
    
    public boolean verifikasi(String username){
        return db.VerifikasiUsername(username);
    }
    
    public Pegawai LupaPass(String id,String username){
        return db.CariPegawai(id, username);
    }
    
    public void refresh(){
        db.LoadDepartemen(perusahaan, daftarpegawai);
    }
}       
