/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thuy Linh
 * Mã sách: Integer
Tên sách: String
Số lượng: Integer
Đơn giá: BigDecimal
Ngày xuất bản: Date

 */
public class Book implements Serializable{
    private  int MaSach , soLuong ;
    private  String tenSach ;
    private BigDecimal donGia;
    private Date ngayXB ;
    
    public Book() {
    }

    public Book(int MaSach,String tenSach, int soLuong,  BigDecimal donGia, Date ngayXB) {
        this.MaSach = MaSach;
        this.soLuong = soLuong;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.ngayXB = ngayXB;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getNgayXB( ) {
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(ngayXB);
    }

    public void setNgayXB(Date ngayXB) {
        this.ngayXB = ngayXB;
    }
    
}
