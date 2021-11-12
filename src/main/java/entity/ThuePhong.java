/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class ThuePhong {
    private int MaDatPhong;
    private String MaKH;
    private String MaPhong;
    private boolean LoaiHinhThue;
    private Date NgayThue;
    private Date NgayTra;
    private int SoNguoi;
    private String TenUser;
    private String TinhTrang;
    private int TienDatCoc;

    public int getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(int MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public boolean isLoaiHinhThue() {
        return LoaiHinhThue;
    }

    public void setLoaiHinhThue(boolean LoaiHinhThue) {
        this.LoaiHinhThue = LoaiHinhThue;
    }

    public Date getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(Date NgayThue) {
        this.NgayThue = NgayThue;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public String getTenUser() {
        return TenUser;
    }

    public void setTenUser(String TenUser) {
        this.TenUser = TenUser;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public int getTienDatCoc() {
        return TienDatCoc;
    }

    public void setTienDatCoc(int TienDatCoc) {
        this.TienDatCoc = TienDatCoc;
    }
    
}
