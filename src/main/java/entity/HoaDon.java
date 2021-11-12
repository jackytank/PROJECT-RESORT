/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author tamnt
 */
public class HoaDon {

    private int MaDP;
    private double TienPhong;
    private double TienDV;
    private double ThanhTien;
    private double SoNgayThue = 0;
    private double SoGioThue = 0;
    private double PhuThuCheckin = 0;
    private double PhuThuCheckout = 0;

    private String TenUser;
    private String TenKH;
    private String MaPhong;
    private String NgayThanhToan;

    public int getMaDP() {
        return MaDP;
    }

    public void setMaDP(int MaDP) {
        this.MaDP = MaDP;
    }

    public double getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(double TienPhong) {
        this.TienPhong = TienPhong;
    }

    public double getTienDV() {
        return TienDV;
    }

    public void setTienDV(double TienDV) {
        this.TienDV = TienDV;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public double getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(double SoNgayThue) {
        this.SoNgayThue = SoNgayThue;
    }

    public double getSoGioThue() {
        return SoGioThue;
    }

    public void setSoGioThue(double SoGioThue) {
        this.SoGioThue = SoGioThue;
    }

    public double getPhuThuCheckin() {
        return PhuThuCheckin;
    }

    public void setPhuThuCheckin(double PhuThuCheckin) {
        this.PhuThuCheckin = PhuThuCheckin;
    }

    public double getPhuThuCheckout() {
        return PhuThuCheckout;
    }

    public void setPhuThuCheckout(double PhuThuCheckout) {
        this.PhuThuCheckout = PhuThuCheckout;
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

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }
}
