package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.LoaiPhong;

public class LoaiPhong_dao {
	public ArrayList<LoaiPhong> getAllLoaiPhong(){
		ArrayList<LoaiPhong> lslp = new ArrayList<LoaiPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaLoai = rs.getString(1);
				String TenLoai = rs.getString(2);
				float GiaPhong = rs.getFloat(3);
				
				LoaiPhong lp = new LoaiPhong(MaLoai, TenLoai, GiaPhong);
				lslp.add(lp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL loại phòng");
		}
		return lslp;
	}
	public void delete(String ma) {

		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from LoaiPhong where MaLoai=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở xóa loại phòng");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean update(String ma, String ten, String gia) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " LoaiPhong set TenLoai=?,GiaPhong = ?  where MaLoai=?");
			stm.setString(1, ten);
			stm.setString(3, ma);
			stm.setString(2, gia);
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean add(String ma, String ten, String gia) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO LoaiPhong VALUES(?,?,?)");
			stm.setString(1, ma);
			stm.setString(2, ten);
			stm.setString(3, gia);
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
