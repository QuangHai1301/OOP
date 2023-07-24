package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.LoaiDichVu;

public class LoaiDichVu_dao {
	public ArrayList<LoaiDichVu> getAllLoaiDichVu(){
		ArrayList<LoaiDichVu> lsldv = new ArrayList<LoaiDichVu>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiDV = rs.getString(1);
				String tenLoaiDV = rs.getString(2);
				
				LoaiDichVu ldv = new LoaiDichVu(maLoaiDV, tenLoaiDV);
				lsldv.add(ldv);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL loại Dich Vu");
		}
		return lsldv;
	}
	public void delete(String ma) {

		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from LoaiDichVu where MaLoaiDV=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở xóa loại dịch vụ");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean update(String ma, String ten) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " LoaiDichVu set TenLoaiDV=? where MaLoaiDV=?");
			stm.setString(1, ten);
			stm.setString(2, ma);
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

	public boolean add(String ma, String ten) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO LoaiDichVu VALUES(?,?)");
			stm.setString(1, ma);
			stm.setString(2, ten);
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
