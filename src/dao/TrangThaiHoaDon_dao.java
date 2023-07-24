package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.LoaiDichVu;
import emty.TrangThaiHoaDon;

public class TrangThaiHoaDon_dao {
	public ArrayList<TrangThaiHoaDon> getAllTrangThaiHoaDon(){
		ArrayList<TrangThaiHoaDon> lstthd = new ArrayList<TrangThaiHoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiTrangThaiThanhToan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiTTHD = rs.getString(1);
				String tenLoaiTTHD = rs.getString(2);
				
				TrangThaiHoaDon tthd = new TrangThaiHoaDon(maLoaiTTHD, tenLoaiTTHD);
				lstthd.add(tthd);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL trang thai hoa don");
		}
		return lstthd;
	}
}
