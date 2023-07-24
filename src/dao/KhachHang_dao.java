package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.KhachHang;
import emty.TaiKhoan;

public class KhachHang_dao {
	public ArrayList<KhachHang> getAllKhachHang(){
		ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaKH = rs.getString(1);
				String TenTK = rs.getString(2);
				String HoTen = rs.getString(3);
				String DiaChi = rs.getString(4);
				String SDT = rs.getString(5);
				
				TaiKhoan tk = new TaiKhoan(TenTK);
				KhachHang kh = new KhachHang(MaKH, tk, HoTen, DiaChi, SDT);
				lskh.add(kh);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Khách Hàng");
		}
		return lskh;
	}
	public void delete(String ma) {

		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from KhachHang where MaKH=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("LÃ´Ìƒi Æ¡Ì‰ xÃ³a khÃ¡ch hÃ ng");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean update(String ma, String tenKH, String sdt, String diaChi) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " KhachHang set HoTen=? , DiaChi=?, SDT=? where MaKH=?");
			stm.setString(1, tenKH);
			stm.setString(2, diaChi);
			stm.setString(3, sdt);
			stm.setString(4, ma);
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

	public boolean add(String ma, String tenKH, String sdt, String diaChi, String tenTK) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO KhachHang VALUES(?,?,?,?,?)");
			stm.setString(1, ma);
			stm.setString(2, tenTK);
			stm.setString(3, tenKH);
			stm.setString(4, diaChi);
			stm.setString(5, sdt);
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
	public ArrayList<KhachHang> timKiemKhachHang(String sql1){
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sql1;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaKH = rs.getString(1);
				String TenTK = rs.getString(2);
				String HoTen = rs.getString(3);
				String DiaChi = rs.getString(4);
				String SDT = rs.getString(5);
				
				TaiKhoan tk = new TaiKhoan(TenTK);
				KhachHang kh = new KhachHang(MaKH, tk, HoTen, DiaChi, SDT);
				ds.add(kh);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Tìm Kiếm khách hàng");
		}
		return ds;
	}
	
	public ArrayList<KhachHang> getAllKhachHang_NotTK(){
		ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where TenTK is NULL";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaKH = rs.getString(1);
				String TenTK = rs.getString(2);
				String HoTen = rs.getString(3);
				String DiaChi = rs.getString(4);
				String SDT = rs.getString(5);
				
				TaiKhoan tk = new TaiKhoan(TenTK);
				KhachHang kh = new KhachHang(MaKH, tk, HoTen, DiaChi, SDT);
				lskh.add(kh);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Khách Hàng chưa có tài khoản");
		}
		return lskh;
	}
	
	public boolean updateTKKH(String TenTK, String maKH) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update KhachHang set TenTK=? where MaKH=?");
			stm.setString(1, TenTK);
			stm.setString(2, maKH);
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
