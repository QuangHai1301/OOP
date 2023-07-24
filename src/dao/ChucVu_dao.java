package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.ChucVu;
import emty.LoaiPhong;

public class ChucVu_dao {

	public ArrayList<ChucVu> getAllChucVu(){
		ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiChucVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaLoaiCV = rs.getString(1);
				String TenLoaiCV = rs.getString(2);
				ChucVu cv = new ChucVu(MaLoaiCV, TenLoaiCV);
				lscv.add(cv);
				
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL loại Chức Vụ");
		}
		return lscv;
	}
	
	public boolean add(ChucVu cv) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO LoaiChucVu VALUES(?,?)");
			stm.setString(1, cv.getMaLoaiChucVu());
			stm.setString(2, cv.getTenLoaiChucVu());
		
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
	public void delete(String ma) {

		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from LoaiChucVu where MaLoaiCV=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở xóa chức vụ");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean update(ChucVu cv) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " LoaiChucVu set TenLoaiCV=?  where MaLoaiCV=?");
			stm.setString(1, cv.getMaLoaiChucVu());
			stm.setString(2, cv.getTenLoaiChucVu());
			
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
