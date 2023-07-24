package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
//import emty.QuyenTaiKhoan;
import emty.TaiKhoan;

public class TaiKhoan_dao {
	public ArrayList<TaiKhoan> getAllTaiKhoan(){
		ArrayList<TaiKhoan> lstk = new ArrayList<TaiKhoan>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String TenTK = rs.getString(1);
				String MK = rs.getString(2);
				String MaQuyenHan = rs.getString(3);
				
				emty.QuyenTaiKhoan qtk = new emty.QuyenTaiKhoan(MaQuyenHan, "");
				
				TaiKhoan taikhoan  = new TaiKhoan(TenTK, MK, qtk);
			
				lstk.add(taikhoan);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở lấy all TaiKhoan");
		}
		return lstk;
	}
	
	public void delete(String ma) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from TaiKhoan where TenTK=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi Dữ Liệu Xóa Tài Khoản");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public boolean update(TaiKhoan tk) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " TaiKhoan set MK=? , MaQuyen=? where TenTK=?");
		
			stm.setString(1, tk.getMK());
			stm.setString(2, tk.getMaQuyen().getMaQuyen());
			stm.setString(3, tk.getTenTK());
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
	
	public boolean add(TaiKhoan tk) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("INSERT INTO TaiKhoan VALUES(?,?,?)");
			

			stm.setString(1, tk.getTenTK());
			stm.setString(2, tk.getMK());
			stm.setString(3, tk.getMaQuyen().getMaQuyen());
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
	public ArrayList<TaiKhoan> timkiemTaiKhoan(String sql1){
		ArrayList<TaiKhoan> ds = new ArrayList<TaiKhoan>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sql1;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String TenTK = rs.getString(1);
				String MK = rs.getString(2);
				String MaQuyenHan = rs.getString(3);
				emty.QuyenTaiKhoan qtk = new emty.QuyenTaiKhoan(MaQuyenHan, "");
				TaiKhoan tk = new TaiKhoan(TenTK, MK, qtk);
			ds.add(tk);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Tìm Kiếm Tài Khoản");
		}
		return ds;
		
		
	}
}
