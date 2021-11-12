/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import entity.ThuePhong;

/**
 *
 * @author tamnt
 */
public class BLL_ThuePhong {

    public static boolean KT_Them(ThuePhong add) {
        String ktNgay = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";//biểu thức chính qua kt ngày
        String kt = "[0-9]{1,99}";

        if (!add.getSoNguoi().matches(kt)) {
            ThongBao.thongbao("Nhập số vào số người", "");
        }
        return true;
    }
}
