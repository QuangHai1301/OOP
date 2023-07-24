package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.QuyenTaiKhoan;

public class QuyenHan_dao {
	public ArrayList<QuyenTaiKhoan> getALLQuyenTaiKhoan(){
		ArrayList<QuyenTaiKhoan> lstk = new ArrayList<QuyenTaiKhoan>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiQuyen";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maQuyen = rs.getString(1);
				String tenQuyen = rs.getString(2);
				QuyenTaiKhoan qtk = new QuyenTaiKhoan(maQuyen, tenQuyen);
				lstk.add(qtk);
				
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL loại TaiKhoan");
		}
		return lstk;
	}
	
}
