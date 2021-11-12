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
public class HoaDon {
    private int MaHoaDon;
    private int MaDatPhong;
    private String TenUser;
    private String TenKH;
    private String MaPhong;
    private float SoNgayThue;
    private float SoGioThue;
    private int TienPhong;
    private int CheckIn;
    private int CheckOut;
    private int TienDV;
    private int ThanhTien;
    private Date NgayThanhToan;
    private String GhiChu;

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(int MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public String getTenUser() {
        return TenUser;
    }

    public void setTenUser(String TenUser) {
        this.TenUser = TenUser;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public float getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(float SoNgayThue) {
        this.SoNgayThue = SoNgayThue;
    }

    public float getSoGioThue() {
        return SoGioThue;
    }

    public void setSoGioThue(float SoGioThue) {
        this.SoGioThue = SoGioThue;
    }

    public int getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(int TienPhong) {
        this.TienPhong = TienPhong;
    }

    public int getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(int CheckIn) {
        this.CheckIn = CheckIn;
    }

    public int getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(int CheckOut) {
        this.CheckOut = CheckOut;
    }

    public int getTienDV() {
        return TienDV;
    }

    public void setTienDV(int TienDV) {
        this.TienDV = TienDV;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
