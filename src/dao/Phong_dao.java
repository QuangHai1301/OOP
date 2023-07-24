package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.LoaiPhong;
import emty.Phong;
import emty.TrangThaiPhong;

public class Phong_dao {
	public ArrayList<Phong> getPhongTrong(){
		ArrayList<Phong> lsp = new ArrayList<Phong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select MaPhong,TenPhong,TenLoaiTT,TenLoai,GiaPhong from Phong join LoaiPhong on Phong.MaLoai=LoaiPhong.MaLoai join LoaiTrangThaiPhong on Phong.MaLoaiTT=LoaiTrangThaiPhong.MaLoaiTT where [dbo].[LoaiTrangThaiPhong].MaLoaiTT='LTT01'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaPhong = rs.getString(1);
				String TenPhong = rs.getString(2);
				String TrangThai = rs.getString(3);
				String TenLoai = rs.getString(4);
				float GiaPhong = rs.getFloat(5);
				
				
				LoaiPhong lp = new LoaiPhong("", TenLoai, GiaPhong);
				TrangThaiPhong ttp = new TrangThaiPhong("", TrangThai);
				Phong p = new Phong(MaPhong, TenPhong, lp, ttp);
				lsp.add(p);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Phong Trong");
		}
		return lsp;
	}
	
	
	
	
	public boolean updatePhongDuocDat(Phong p) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update  Phong set MaLoaiTT='LTT03' where  MaPhong=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getMaPhong());
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update Phong duoc dat");
			return false;
		}
	}
	
	
	public boolean updatePhongTrong(String maPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update  Phong set MaLoaiTT='LTT01' where  MaPhong=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maPhong);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update Phong Trong");
			return false;
		}
	}
	
	
	public boolean updatePhongDuocDatKhiTinhGio(Phong p) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update  Phong set MaLoaiTT='LTT02' where  MaPhong=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getMaPhong());
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update Phong Khi Tinh Gio");
			return false;
		}
	}
	
	
	public ArrayList<Phong> getAllPhong(){
		ArrayList<Phong> lsp = new ArrayList<Phong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select MaPhong, TenPhong, [dbo].[LoaiPhong].MaLoai, [dbo].[LoaiTrangThaiPhong].MaLoaiTT, TenLoai, GiaPhong, TenLoaiTT from Phong join LoaiPhong on Phong.MaLoai=LoaiPhong.MaLoai join LoaiTrangThaiPhong on Phong.MaLoaiTT=LoaiTrangThaiPhong.MaLoaiTT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaPhong = rs.getString(1);
				String TenPhong = rs.getString(2);
				String MaLoai = rs.getString(3);
				String MaTrangThai = rs.getString(4);
				String TenLoai = rs.getString(5);
				float GiaPhong = rs.getFloat(6);
				String TenTrangThai = rs.getString(7);
				
				TrangThaiPhong ttp = new TrangThaiPhong(MaTrangThai, TenTrangThai);
				LoaiPhong lp = new LoaiPhong(MaLoai, TenLoai, GiaPhong);
				Phong p = new Phong(MaPhong, TenPhong, lp, ttp);
				lsp.add(p);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Phong");
		}
		return lsp;
	}
	
	
	public boolean insertPhong(Phong p){
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "insert into Phong values(?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getMaPhong());
			stmt.setString(2, p.getTenPhong());
			stmt.setString(3, p.getMaLoaiPhong().getMaLoaiPhong());
			stmt.setString(4, p.getMaTrangThaiPhong().getMaLoaiTrangThai());
			stmt.executeUpdate();
			return true;
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Thêm Phong");
			return false;
		}
	}
	
	
	public boolean deletePhong(String id) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "delete  Phong where MaPhong=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Xóa Phong");
			return false;
		}
	}
	
	
	public boolean updatePhong(Phong p) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update  Phong set TenPhong=?, MaLoai=? where  MaPhong=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getTenPhong());
			stmt.setString(2, p.getMaLoaiPhong().getMaLoaiPhong());
			stmt.setString(3, p.getMaPhong());
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update Phong");
			return false;
		}
	}
	
	
	public ArrayList<Phong> getTimKiemPhong(String sql1){
		ArrayList<Phong> lsp = new ArrayList<Phong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sql1;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaPhong = rs.getString(1);
				String TenPhong = rs.getString(2);
				String TenLoai = rs.getString(3);
				String TenTrangThai = rs.getString(4);
				float GiaPhong = rs.getFloat(5);
				
				LoaiPhong lp = new LoaiPhong("", TenLoai, GiaPhong);
				TrangThaiPhong ttp = new TrangThaiPhong("", TenTrangThai);
				Phong p = new Phong(MaPhong, TenPhong, lp, ttp);
				lsp.add(p);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Phong Tìm Kiếm");
		}
		return lsp;
	}
}
