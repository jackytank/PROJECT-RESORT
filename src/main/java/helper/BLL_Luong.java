/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_Luong;
import dao.DAO_NhanVien;
import entity.Luong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tamnt
 */
public class BLL_Luong {

    public static void dodulieu(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO_Luong.LayLuong();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaLuong");
                obj[1] = ChuyenDoi.DinhDangSo(rs.getDouble("LuongTheoGio"));
                obj[2] = rs.getInt("SoGioLam");
//                obj[3]=rs.getDate("NgayBatDauLam");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");
        }
    }

    public static boolean KT_THem(Luong L) {
        String kt2 = "[0-9]{1,99}[.][0-9]{1,99}";
        ResultSet rs = DAO_Luong.LayLuong();
        try {
            while (rs.next()) {
                if (L.getMaluong().matches(rs.getString("MaLuong"))) {
                    ThongBao.thongbao("Mã lương đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_Luong.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (L.getMaluong().trim().equals("") || L.getLuonggio().trim().equals("") || L.getSogiolam().trim().equals("")) {
            ThongBao.thongbao("Không để trống dữ liệu", "");
            return false;
        }
        if (L.getMaluong().length() < 1) {
            ThongBao.thongbao("Mã lương có tối thiểu 2 ký tự ", "");
            return false;
        }
        if (!L.getLuonggio().matches(kt2)) {
            ThongBao.thongbao("Nhập số vào lương", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Sua(Luong L) {
        String kt2 = "[0-9]{1,99}||[0-9]{1,99}[.][0-9]{1,99}";
        if (L.getMaluong().trim().equals("") || L.getLuonggio().trim().equals("") || L.getSogiolam().trim().equals("")) {
            ThongBao.thongbao("Không để trống dữ liệu", "");
            return false;
        }
        if (L.getMaluong().length() < 1) {
            ThongBao.thongbao("Mã lương có tối thiểu 2 ký tự ", "");
            return false;
        }
        if (!L.getLuonggio().matches(kt2)) {
            ThongBao.thongbao("Nhập số vào lương", "");
            return false;
        }
        return true;
    }

    public static void DoDuLieuBang(JTable tbl) {
        SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO_NhanVien.LayNV();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaNhanVien");
                obj[1] = rs.getString("TenNhanVien");
                obj[2] = rs.getString("MaLuong");
                try {
                    obj[3] = ChuyenDoi.GetDate2(rs.getDate("NgayBatDauLam"));
                } catch (Exception e) {
                    obj[3] = null;
                }

//                boolean gt = rs.getBoolean("GioiTinh");
//                if (gt) {
//                    obj[2] = "Nam";
//                } else {
//                    obj[2] = "Nữ";
//                }
//                obj[3] = rs.getDate("NgaySinh");
//                obj[4] = rs.getString("SoDienThoai");
//                obj[5] = rs.getString("DiaChi");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");

        }
    }

    public static boolean KT_xoa(String maluong) {
        ResultSet rs = DAO_NhanVien.LayNV();// Kiểm tra mã lương khi xóa có đang tồn tại ở nhân viên hay không
        try {
            while (rs.next()) {
                if (rs.getString("MaLuong").equals(maluong)) {
                    ThongBao.thongbao("Mã lương này đang tồn tại ở ít nhất 1 nhân viên", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
        return true;
    }
}
