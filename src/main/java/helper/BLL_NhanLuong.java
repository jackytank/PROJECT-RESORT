/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_NhanLuong;
import entity.NhanLuong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tamnt
 */
public class BLL_NhanLuong {

    public static boolean KT_MaNhanLuong(NhanLuong nl) {
        ResultSet rs = DAO_NhanLuong.Lay();
        try {
            while (rs.next()) {
                if (nl.getMaChiTietLuong().equals(rs.getString("MaChiTietLuong"))) {
                    ThongBao.thongbao("Nhân viên đã có lương", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_NhanLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
