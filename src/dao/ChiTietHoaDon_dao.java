package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.ChiTietHoaDon;
import emty.DichVu;
import emty.PhieuDatPhong;
import emty.Phong;

public class ChiTietHoaDon_dao {
	public ArrayList<ChiTietHoaDon> getChiTietHoaDon_MaDP(String maDP){
		ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select [dbo].[DichVu].MaDV, TenDV, Gia, SoLuong from ChiTietHoaDon join PhieuDatPhong on ChiTietHoaDon.MaDP=PhieuDatPhong.MaDP join DichVu on ChiTietHoaDon.MaDV=DichVu.MaDV where [dbo].[PhieuDatPhong].MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maDP);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString(1);
				String tenDV = rs.getString(2);
				float gia = rs.getFloat(3);
				int soLuong = rs.getInt(4);
				
				DichVu dv = new DichVu(maDV, null, tenDV, gia);
				PhieuDatPhong pdp = new PhieuDatPhong(maDP);
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(null, dv, pdp, soLuong);
				lscthd.add(cthd);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở get Chi Tiet Hoa Don Theo maDP");
		}
		return lscthd;
	}
	
	public ArrayList<ChiTietHoaDon> getChiTietHoaDon_MaHD(String maHD){
		ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select [dbo].[DichVu].MaDV, TenDV, Gia, SoLuong, [dbo].[PhieuDatPhong].MaDP from ChiTietHoaDon join PhieuDatPhong on ChiTietHoaDon.MaDP=PhieuDatPhong.MaDP join DichVu on ChiTietHoaDon.MaDV=DichVu.MaDV where MaHD=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString(1);
				String tenDV = rs.getString(2);
				float gia = rs.getFloat(3);
				int soLuong = rs.getInt(4);
				String maDP = rs.getString(5);
				
				DichVu dv = new DichVu(maDV, null, tenDV, gia);
				PhieuDatPhong pdp = new PhieuDatPhong(maDP);
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(null, dv, pdp, soLuong);
				lscthd.add(cthd);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở get Chi Tiet Hoa Don Theo maHD");
		}
		return lscthd;
	}
	
	
	public boolean addCTHD(ChiTietHoaDon cthd) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO ChiTietHoaDon VALUES(?,?,?,?)");
			stm.setString(1, cthd.getMaDatPhong().getMaDatPhong());
			stm.setString(2, null);
			stm.setString(3, cthd.getMaDichVu().getMaDichVu());
			stm.setInt(4, cthd.getSoLuong());
			n = stm.executeUpdate();
			System.out.println("Thêm Chi Tiết Hóa Đon Thành Công !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	
	public boolean update(String maDP, String maHD) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update ChiTietHoaDon set MaHD=? where MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			stmt.setString(2, maDP);
			stmt.executeUpdate();
			System.out.println("cập nhật của chi tiết hóa đơn thành công");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update phieu dat phong du lieu ma hoa don");
			return false;
		}
	}
	
	public boolean updateSL(int SoLuong, String maDP, String MaDV) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update ChiTietHoaDon set SoLuong=? where MaDP=? and MaDV=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, SoLuong);
			stmt.setString(2, maDP);
			stmt.setString(3, MaDV);
			stmt.executeUpdate();
			System.out.println("cập nhật số lượng của chi tiết hóa đơn thành công");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update phieu dat phong du lieu ma hoa don");
			return false;
		}
	}
	
	public boolean Delete(String maDP, String maDV) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "delete ChiTietHoaDon where MaDP=? and MaDV=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maDP);
			stmt.setString(2, maDV);
			stmt.executeUpdate();
			System.out.println("Xóa chi tiết hóa đơn thành công");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở xóa chi tiết hóa đơn du lieu ma hoa don");
			return false;
		}
	}
}
