/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ThuePhong;
import helper.ThongBao;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tamnt
 */
public class DAO_ThuePhong {

    public static ResultSet Lay() {//lấy đặt phòng chưa thanh toán
        String sql = "SELECT * FROM [dbo].[DatPhong] where TinhTrang like N'Chưa thanh toán'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTheoMa(String MaDP) {
        String sql = "SELECT * FROM [dbo].[DatPhong] where MaDatPhong=" + MaDP + "";
        return connection.Getdata(sql);
    }

    public static void Them(ThuePhong add) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[DatPhong] "
                + "           ([MaKhachHang] "
                + "           ,[MaPhong] "
                + "           ,[LoaiHinhThue] "
                + "           ,[NgayThue] "
                + "           ,[NgayRaDuKien] "
                + "           ,[SoNguoi] "
                + ",[TienDatCoc]"
                + "           ,[TenUser]) "
                + "     VALUES "
                + "           (N'" + add.getMaKH() + "' "
                + "           ,N'" + add.getMaPhong() + "' "
                + "           ,'" + add.isLoaiHinhThue() + "' "
                + "           ,'" + add.getNgayThue() + "' "
                + "           ,'" + add.getNgayRaDuKien() + "' "
                + "           ," + add.getSoNguoi() + " "
                + "," + add.getTienCoc() + " "
                + "           ,N'" + add.getTenUser() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            //sau khi thuê sẽ cập nhật phòng đó thành 'sudung'
            DAO_Phong.Update(add.getMaPhong());
            ThongBao.thongbao("Thuê thành công", "");
        } else {
            ThongBao.thongbao("Thuê  không thành công", "");
        }
    }

    public static void DatTruocPhong(ThuePhong add) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[DatPhong] "
                + "           ([MaKhachHang] "
                + "           ,[MaPhong] "
                + "           ,[LoaiHinhThue] "
                + "           ,[NgayThue] "
                + "           ,[NgayRaDuKien] "
                + "           ,[SoNguoi] "
                + "           ,[TenUser] "
                + "           ,[TinhTrang] "
                + "           ,[TienDatCoc]) "
                + "     VALUES "
                + "           (N'" + add.getMaKH() + "' "
                + "           ,N'" + add.getMaPhong() + "' "
                + "           ,'" + add.isLoaiHinhThue() + "' "
                + "           ,'" + add.getNgayThue() + "' "
                + "           ,'" + add.getNgayRaDuKien() + "' "
                + "           ," + add.getSoNguoi() + " "
                + "           ,N'" + add.getTenUser() + "' "
                + "           ,N'dattruoc' "
                + "           ," + add.getTienCoc() + ")";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            //sau khi đặt trước phòng sẽ đặt trạng thái phòng thành 'dattruoc'
            DAO_Phong.UpdateDatTruoc(add.getMaPhong());
            ThongBao.thongbao("Đặt thành công", "");
        } else {
            ThongBao.thongbao("Đặt  không thành công", "");
        }
    }

    public static void UpdateDatTruocThanhThue(String trangthai, String MaPhong) {
        String sql = "UPDATE [dbo].[DatPhong] SET [TinhTrang] = N'" + trangthai + "' WHERE MaPhong=N'" + MaPhong + "' and TinhTrang=N'dattruoc'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            //sau khi thuê sẽ cập nhật phòng đó thành 'sudung'
            if (trangthai.equals("Chưa thanh toán")) {
                DAO_Phong.Update(MaPhong);
                ThongBao.thongbao("Thuê thành công", "");
            }

        } else {
            ThongBao.thongbao("Không thành công", "");
        }
    }

    public static void UpdateNgayThue(String MaPhong) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngaythue = s.format(d);
        System.out.println("ngày thuê" + ngaythue);
        String sql = "UPDATE [dbo].[DatPhong] SET [NgayThue] = '" + ngaythue + "' WHERE MaPhong=N'" + MaPhong + "' and TinhTrang=N'dattruoc'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(int songuoi, String MaDP) {
        String sql = "UPDATE [dbo].[DatPhong] SET [SoNguoi] = " + songuoi + " WHERE MaDatPhong=" + MaDP + "";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("sửa thành công", "");
        } else {
            ThongBao.thongbao("sửa  không thành công", "");
        }
    }

    public static ResultSet LayTienGio(String MaDP) {
        String sql = "SELECT LoaiPhong.GiaTheoGio,LoaiPhong.GiaTheoNgay FROM DatPhong,Phong,LoaiPhong where DatPhong.MaPhong=Phong.MaPhong and Phong.MaLoaiPhong=LoaiPhong.MaLoaiPhong and DatPhong.MaDatPhong=" + MaDP + "";
        return connection.Getdata(sql);
    }

    public static void TraPhong(String MaDP) {
        String sql = "UPDATE [dbo].[DatPhong] SET [TinhTrang] = N'Đã thanh toán' WHERE MaDatPhong=" + MaDP + "";
        connection.ExecuteTruyVan(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = "SELECT * FROM [dbo].[DatPhong]";
        return connection.Getdata(sql);
    }
}
