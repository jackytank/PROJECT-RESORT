/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Phong;
import helper.ThongBao;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_Phong {

    public static ResultSet LayPhong(int TrangThai) {
        String sql = null;
        switch (TrangThai) {
            case 0 -> sql = "select * from Phong";
            case 1 -> sql = "SELECT * FROM Phong where TinhTrang like N'trong'";
            case 2 -> sql = "SELECT * FROM Phong where TinhTrang like N'sudung'";
            case 3 -> sql = "SELECT * FROM Phong where TinhTrang like N'dondep'";
            case 4 -> sql = "SELECT * FROM Phong where TinhTrang like N'dattruoc'";
            default -> {
            }
        }

        return connection.Getdata(sql);
    }

    public static ResultSet LayTang() {
        String sql = "select DISTINCT MaTang from Phong";
        return connection.Getdata(sql);
    }

    public static void Update(String MaPhong) {//cập nhật phòng thành 'sudung'
        String sql = "UPDATE [dbo].[Phong] "
                + " SET  "
                + "[TinhTrang] = N'sudung'   "
                + " WHERE MaPhong=N'" + MaPhong + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void UpdateDatTruoc(String MaPhong) {//cập nhật trạng thái phòng thành 'dattruoc'
        String sql = "UPDATE [dbo].[Phong] SET [TinhTrang] =N'dattruoc' WHERE MaPhong=N'" + MaPhong + "'";
        connection.ExecuteTruyVan(sql);
    }
//    public static void UpdateDatTruocThanhThue(String MaPhong){
//    String sql="UPDATE [dbo].[Phong] SET [TinhTrang] =N'sudung' WHERE MaPhong=N'"+MaPhong+"'";//update phòng từ trạng thái đặt trước thành sử dụng
//    connection.ExecuteTruyVan(sql);
//    }

    public static void Update2(String MaPhong) {
        String sql = "UPDATE [dbo].[Phong] SET [TinhTrang] =N'dondep' WHERE MaPhong =N'" + MaPhong + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void UpdateHoanThanhDonDep(String MaPhong) {
        String sql = "UPDATE [dbo].[Phong] SET [TinhTrang] =N'trong' WHERE MaPhong=N'" + MaPhong + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void ThemPhong(Phong P) {
        String sql = "INSERT INTO [dbo].[Phong] "
                + "           ([MaPhong] "
                + "           ,[MaLoaiPhong] "
                + "           ,[DienTich] "
                + ",[MaTang]"
                + ",[GiuongDon]"
                + "  ,[GiuongDoi]"
                + "           ,[Hinh] "
                + "           ,[TinhTrang] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + P.getMaPhong() + "' "
                + "           ,N'" + P.getMaLoaiPhong() + "' "
                + "           ," + P.getDienTich() + " "
                + "," + P.getTang() + " "
                + "," + P.getGiuongDon() + " "
                + "," + P.getGiuongDoi() + " "
                + "           ,N'" + P.getHinh() + "' "
                + "           ,N'trong' "
                + "           ,N'" + P.getGhiChu() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static ResultSet LayTheoMa(String MaPhong) {
        String sql = "SELECT * FROM [dbo].[Phong] where MaPhong=N'" + MaPhong + "'";
        return connection.Getdata(sql);
    }

    public static void Xoa(String MaPhong) {
        String sql = "DELETE FROM [dbo].[Phong]  WHERE MaPhong=N'" + MaPhong + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(Phong P) {
        String sql = "UPDATE [dbo].[Phong] "
                + "   SET [MaPhong] = N'" + P.getMaPhong() + "' "
                + "      ,[MaLoaiPhong] = N'" + P.getMaLoaiPhong() + "' "
                + "      ,[DienTich] =" + P.getDienTich() + " "
                + "      ,[Hinh] = N'" + P.getHinh() + "' "
                + ",[MaTang] = " + P.getTang() + " "
                + ",[GiuongDon] =" + P.getGiuongDon() + " "
                + ",[GiuongDoi] = " + P.getGiuongDoi() + " "
                //                + "      ,[TinhTrang] = N'"+P.getTinhTrang()+"' "
                + "      ,[GhiChu] = N'" + P.getGhiChu() + "' "
                + " WHERE MaPhong =N'" + P.getMaPhong() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Sửa thành công", "");
        } else {
            ThongBao.thongbao("Sửa không thành công", "");
        }
    }

    public static ResultSet LayPHongTheoTang(String tang) {
        String sql = "SELECT * FROM [dbo].[Phong] where MaTang=" + tang + "";
        return connection.Getdata(sql);

    }

    public static ResultSet LayTheoTangVaGiuongDon(String tang, int giuong) {
        String sql = "SELECT * FROM [dbo].[Phong] where GiuongDon=" + giuong + " and MaTang=" + tang + "";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTheoTangVaGiuongDoi(String tang, int giuong) {
        String sql = "SELECT * FROM [dbo].[Phong] where GiuongDoi=" + giuong + " and MaTang=" + tang + "";
        return connection.Getdata(sql);
    }
}
