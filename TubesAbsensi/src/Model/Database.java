/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Agung Nursatria
 */
public class Database {
    private final String server = "jdbc:mysql://localhost:3306/tubesabsensi";
    private final String dbuser = "root";
    private final String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat koneksi");
        }
    }

    public void savePerusahaan(Perusahaan p){
        try {
            String query = "insert into perusahaan(Nama_Perusahaan,Alamat,NomorKontak) values"
                    + "('" + p.getNama() + "'," 
                    + "'" + p.getAlamat() + "'," 
                    + "'" + p.getNomorKontak() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save perusahaan");
        }
    }
    
    public void saveDepartemen(String namadepartemen,String namaperusahaan){
       try {
            String query = "insert into departemen(Nama_Departemen,Nama_Perusahaan) values"
                    + "('" + namadepartemen + "'," 
                    + "'" + namaperusahaan + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save departemen");
        }
    }
    
    public void savePegawai(Pegawai p,String namadepartemen){
       try {
           String query;
           if (p instanceof PegawaiHonorer){
               query = "insert into pegawai_honorer(id_pegawaihonorer,username,password,Nama_Pegawai,email,umur,alamat,jenis_kelamin,totaljamsebulan,gaji_perjam,lama_kontrak,nama_departemen) values"
                    + "('" + p.getIdPegawai()+ "'," 
                    + "'" + p.getUsername()+ "'," 
                    + "'" + p.getPassword()+ "'," 
                    + "'" + p.getNama()+ "'," 
                    + "'" + p.getEmail()+ "'," 
                    + "'" + p.getUmur()+ "'," 
                    + "'" + p.getAlamat() + "'," 
                    + "'" + p.getJK()+ "'," 
                    + "'0','" 
                    + ((PegawaiHonorer) p).getGaji_perjam()+ "'," 
                    + "'" 
                    + ((PegawaiHonorer) p).getLama_Kontrak()+ "'," 
                    + "'" + namadepartemen + "')";
           }
           else
           {
               query = "insert into pegawai_tetap(id_pegawaitetap,username,password,Nama_Pegawai,email,umur,alamat,jenis_kelamin,Gaji,nama_departement) values"
                    + "('" + p.getIdPegawai()+ "'," 
                    + "'" + p.getUsername()+ "'," 
                    + "'" + p.getPassword()+ "'," 
                    + "'" + p.getNama()+ "'," 
                    + "'" + p.getEmail()+ "'," 
                    + "'" + p.getUmur()+ "'," 
                    + "'" + p.getAlamat() + "'," 
                    + "'" + p.getJK()+ "'," 
                    + "'" + ((PegawaiTetap) p).getGaji()+ "'," 
                    + "'" + namadepartemen + "')";
           }
           statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save pegawai");
        }
    }
    
    
    public void saveTunjangan(Tunjangan t,String id_Pegawaitetap){
       try {
            String query = "insert into Tunjangan(Nama_tunjangan,jumlah,id_pegawaitetap) values"
                    + "('" + t.getNama()+ "'," 
                    + "'" + t.getJumlah()+ "'," 
                    + "'" + id_Pegawaitetap + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save tunjangan");
        }
    }
    
    public void saveAbsenp_tetap(Absensi a,String id_Pegawai){
       try {
            String query = "insert into absenp_tetap(id_absensi,jam,menit,tanggal,status,terlambat,id_pegawaitetap) values"
                    + "('" + a.getId()+ "'," 
                    + "'" + a.getJam()+ "'," 
                    + "'" + a.getMenit()+ "'," 
                    + "'" + a.getTanggal()+ "'," 
                    + "'" + a.getStatus()+ "'," 
                    + "'" + a.getTerlambat()+ "'," 
                    + "'" + id_Pegawai + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save tim");
        }
    }
    
    public void saveAbsenp_honorer(Absensi a,String id_pegawaihonorer){
       try {
            String query = "insert into absenp_honorer(id_absensi,jam,menit,tanggal,status,terlambat,id_pegawaihonorer) values"
                    + "('" + a.getId()+ "'," 
                    + "'" + a.getJam()+ "'," 
                    + "'" + a.getMenit()+ "'," 
                    + "'" + a.getTanggal()+ "'," 
                    + "'" + a.getStatus()+ "'," 
                    + "'" + a.getTerlambat()+ "'," 
                    + "'" + id_pegawaihonorer + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save absen honorer");
        }
    }
    
    public void updatePerusahaan(Perusahaan p,String namalama) {
        try {
            String query;
            query = "update perusahaan set Nama_Perusahaan='" + p.getNama()+"',"
                    + "Alamat='" + p.getAlamat()+ "',"
                    + "NomorKontak='" + p.getNomorKontak() + "'"
                    + "Where Nama_Perusahaan='" + namalama+"'";
            statement.executeUpdate(query);
            query = "update departemen set Nama_Perusahaan='" + p.getNama()+"' where Nama_Perusahaan='"+namalama+"'";
            statement.executeUpdate(query);      
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update Perusahaan");
        }
    }
    
    public ArrayList<Pegawai> loadPegawai() {
        try {
            ArrayList<Pegawai> daftarPegawai = new ArrayList<>();
            String query = "select * from pegawai_honorer";
            ResultSet rs = statement.executeQuery(query);
            Pegawai p;
            while (rs.next()) {
                p = new PegawaiHonorer(rs.getString(2), rs.getString(3),rs.getString(1),rs.getString(4),rs.getInt(6),rs.getString(7),rs.getString(5),rs.getString(8).charAt(0),rs.getDouble(10),rs.getInt(11));
                String query2 = "select * from absensip_honorer where id_PegawaiHonorer='"+rs.getString(1)+"'";
                ResultSet rs2 = statement.executeQuery(query2);
                while(rs2.next()){
                    p.createAbsen(rs.getInt(2),rs.getInt(3) , rs.getString(4), rs.getString(5));
                }
                daftarPegawai.add(p);
            }
            query = "select * from pegawai_tetap";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                p = new PegawaiTetap(rs.getString(2), rs.getString(3),rs.getString(1),rs.getString(4),rs.getInt(6),rs.getString(7),rs.getString(5),rs.getString(8).charAt(0),rs.getDouble(9));
                String query2 = "select * from absensip_honorer where id_PegawaiTetap='"+rs.getString(1)+"'";
                ResultSet rs2 = statement.executeQuery(query2);
                while(rs2.next()){
                    p.createAbsen(rs.getInt(2),rs.getInt(3) , rs.getString(4), rs.getString(5));
                }
                query2 = "select * from tunjangan where id_pegawaitetap='"+rs.getString(1)+"'";
                rs2 = statement.executeQuery(query2);
                ArrayList<Tunjangan> tunjangan = new ArrayList();
                tunjangan = loadTunjangan();
                while(rs2.next()){
                    for(int i=0;i<tunjangan.size();i++){
                        if(tunjangan.get(i).getNama() == rs2.getString(1)){
                            ((PegawaiTetap) p).AddTunjangan(tunjangan.get(i));
                        }
                    }
                }
                daftarPegawai.add(p);
            }
            return daftarPegawai;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load pegawai");
        }
    }
    
    public ArrayList<Tunjangan> loadTunjangan() {
        try {
            ArrayList<Tunjangan> daftarTunjangan = new ArrayList<>();
            String query = "select * from tunjangan";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Tunjangan t = new Tunjangan(rs.getString(1),rs.getDouble(2));
                daftarTunjangan.add(t);
            }
            return daftarTunjangan;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load pegawai");
        }
    }
    
    public Perusahaan loadPerusahaan() {
        try {
            Perusahaan p = null;
            String query = "select * from perusahaan";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                p = new Perusahaan(rs.getString(1),rs.getString(2),rs.getString(3));
                String query2 = "select * from departemen where Nama_Perusahaan='"+rs.getString(1)+"'";
                ResultSet rs2 = statement.executeQuery(query2);
                while (rs2.next()) {
                    p.createDepartemen(rs2.getString(1));
                }
            }
            return p;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load perusahaan");
        }
    }
    
    public void LoadDepartemen(Perusahaan p, ArrayList<Pegawai> peg){
        if (peg.size()>0){
            try{
                for (int i=0;i< p.getNumofDepartemen();i++) {
                    String query2 = "select * from pegawai_tetap where nama_departement='"+p.getDepartemen(i)+"'";
                    ResultSet rs2 = statement.executeQuery(query2);
                    while(rs2.next()){
                        for(int j=0;j<peg.size();j++){
                            if(peg.get(i) instanceof PegawaiTetap){
                                if(peg.get(j).getIdPegawai() == rs2.getString(1)){
                                    p.getDepartemen(i).AddPegawai(peg.get(j));
                                }
                            }
                        }
                    }   
                    query2 = "select * from pegawai_honorer where nama_departemen='"+p.getDepartemen(i)+"'";
                    rs2 = statement.executeQuery(query2);
                    while(rs2.next()){
                        for(int j=0;j<peg.size();j++){
                            if(peg.get(i) instanceof PegawaiHonorer){
                                if(peg.get(j).getIdPegawai() == rs2.getString(1)){
                                    p.getDepartemen(i).AddPegawai(peg.get(j));
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("terjadi kesalahan saat load perusahaan");
            }
        }
    }
    
    public void updateDepartemen(Departemen d,String namalama){
        try {
            String query;
            query = "update departemen set Nama_Departemen='" + d.getNama() + "' where Nama_departemen='"+namalama+"'";
            statement.executeUpdate(query);
            query = "update pegawai_tetap set nama_departement='"+d.getNama()+"' where nama departemen='"+namalama+"'";
            query = "update pegawai_honorer set nama_departemen='"+d.getNama()+"' where nama departemen='"+namalama+"'";
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update tim");
        }
    }
    
    public void updatePassword(Pegawai p,String passwordlama){
        try {
            String query;
            if(p instanceof PegawaiTetap){
                query = "update Pegawai_tetap set Password='" + p.getPassword()+ "' where Password='"+passwordlama+"'";
            }
            else
            {
                query = "update Pegawai_Honorer set Password='" + p.getPassword()+ "' where Password='"+passwordlama+"'";
                
            }
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update tim");
        }
    }
    
    public Pegawai CariPegawai(String id,String username){
        try {
            Pegawai p = null;
            String query = "select * from Pegawai_tetap Where id_pegawaitetap='" + id + "' and username='" + username + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                p = new PegawaiTetap(rs.getString(2), rs.getString(3),rs.getString(1),rs.getString(4),rs.getInt(6),rs.getString(7),rs.getString(5),rs.getString(8).charAt(0),rs.getDouble(9));
            }
            else{
                String query2 = "select * from Pegawai_honorer Where id_pegawaihonorer='" + id + "' and username='" + username + "'";
                ResultSet rs2 = statement.executeQuery(query);
                if(rs2.next()){
                    p = new PegawaiHonorer(rs.getString(2), rs.getString(3),rs.getString(1),rs.getString(4),rs.getInt(6),rs.getString(7),rs.getString(5),rs.getString(8).charAt(0),rs.getDouble(10),rs.getInt(11));
                }
            }
            return p;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load perusahaan");
        }
    }
    
    public boolean VerifikasiUsername(String username){
        try {
            String query = "select * from Pegawai_tetap Where username='" + username + "'";
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return true;
            }
            query = "select * from Pegawai_honorer Where username='" + username + "'";
            rs = statement.executeQuery(query);
            if(rs.next()){
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load perusahaan");
        }
    }
}
