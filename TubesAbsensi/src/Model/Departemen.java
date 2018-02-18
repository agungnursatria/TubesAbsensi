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

public class Departemen {
    private String nama;
    private ArrayList<Pegawai> pegawai;
    
    public Departemen(String nama){
        this.nama=nama;
        pegawai = new ArrayList();
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getnumOfPeg(){
        return pegawai.size();
    }
    
    public Pegawai getPegawai(int i){
        return pegawai.get(i);
    }
    
    public int getPegawaiLogin(String username,String password){
        int i=-1;
        for(Pegawai p : pegawai){
            i++;
            if(p.getUsername()== username && p.getPassword() == password){
                return i;
            }
        }
        return -1;
    }
    
    public int getIndexPegawai(String id){
        for (Pegawai p : pegawai) {
            if(p.getIdPegawai().equals(id)){
                return pegawai.indexOf(p);
            }
        }
        return -1;
    }
    
    public void AddPegawai(Pegawai pegawai){
        this.pegawai.add(pegawai);
    }
    
    public void DeletePegawai(Pegawai pegawai){
        this.pegawai.remove(pegawai);
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
}
