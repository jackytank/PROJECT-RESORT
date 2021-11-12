/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author tamnt
 */
public class mycombobox {

    Object value;//lưu mã
    Object text;// lưu tên

    public mycombobox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String toString() {
        return text.toString();

    }
}
