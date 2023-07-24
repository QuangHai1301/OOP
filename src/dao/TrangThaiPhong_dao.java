package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.LoaiPhong;
import emty.TrangThaiPhong;

public class TrangThaiPhong_dao {
	public ArrayList<TrangThaiPhong> getAllTrangThaiPhong(){
		ArrayList<TrangThaiPhong> lsttp = new ArrayList<TrangThaiPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiTrangThaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiTT = rs.getString(1);
				String tenLoaiTT = rs.getString(2);
				
				TrangThaiPhong ttp = new TrangThaiPhong(maLoaiTT, tenLoaiTT);
				lsttp.add(ttp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL loại phòng");
		}
		return lsttp;
	}
}
