package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.HoaDon;
import emty.KhachHang;
import emty.LoaiDichVu;
import emty.NhanVien;
import emty.TaiKhoan;
import emty.TrangThaiHoaDon;

public class HoaDon_dao {
	public ArrayList<HoaDon> getAllHoaDon(){
		ArrayList<HoaDon> lshd = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString(1);
				String maNhanVien = rs.getString(2);
				Timestamp ngayGioRa = (Timestamp) rs.getObject(3);
				String maLoaiTT = rs.getString(4);
				float tongTien = rs.getFloat(5);
				
				NhanVien nv = new NhanVien(maNhanVien);
				TrangThaiHoaDon tthd = new TrangThaiHoaDon(maLoaiTT, "");
				
				HoaDon hd = new HoaDon(maHoaDon, nv, ngayGioRa.toLocalDateTime(), tthd, tongTien);
				lshd.add(hd);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL hoa don");
		}
		return lshd;
	}
	
	public ArrayList<HoaDon> getAllHoaDon_TrangThaiChuaThanhToan(){
		ArrayList<HoaDon> lshd = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon where MaLoaiTTTT='LTT02'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString(1);
				String maNhanVien = rs.getString(2);
				Timestamp ngayGioRa = (Timestamp) rs.getObject(3);
				String maLoaiTT = rs.getString(4);
				float tongTien = rs.getFloat(5);
				
				NhanVien nv = new NhanVien(maNhanVien);
				TrangThaiHoaDon tthd = new TrangThaiHoaDon(maLoaiTT, "");
				
				HoaDon hd = new HoaDon(maHoaDon, nv, ngayGioRa.toLocalDateTime(), tthd, tongTien);
				lshd.add(hd);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy ALL hoa don chưa thanh toán");
		}
		return lshd;
	}
	
	
	public boolean insertHoaDon(HoaDon hd) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "insert into HoaDon values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getMaNhanVien().getMaNhanVien());
			stmt.setObject(3, hd.getNgayGioRa());
			stmt.setString(4, "LTT02");
			stmt.setFloat(5, hd.getTongTien());
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("loi o them hoa don");
			return false;
		}
	}
	
	
	
	public boolean updateTongTien(String maHD, float TongTien) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update HoaDon set TongTien=? where MaHD=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(2, maHD);
			stmt.setFloat(1, TongTien);
			stmt.executeUpdate();
			System.out.println("cập nhật tổng tiền thành công");
			return true;
		} catch (Exception e) {
			System.out.println("loi o update tong Tien ben hoa don");
			return false;
		}
	}
	
	
	public boolean updateDaThanhToanHD(String maHD) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update HoaDon set MaLoaiTTTT='LTT01' where MaHD=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			stmt.executeUpdate();
			System.out.println("cập nhật trạng thái đã thanh toán cho hóa đơn thành công");
			return true;
		} catch (Exception e) {
			System.out.println("loi o update trạng thái đã thanh toán cho hóa đơn");
			return false;
		}
	}
	public ArrayList<HoaDon> xuatThongKe(String sql1){
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sql1;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString(1);
				String maNhanVien = rs.getString(2);
				Timestamp ngayGioRa = (Timestamp) rs.getObject(3);
				String maLoaiTT = rs.getString(4);
				float tongTien = rs.getFloat(5);
				
				NhanVien nv = new NhanVien(maNhanVien);
				TrangThaiHoaDon tthd = new TrangThaiHoaDon(maLoaiTT, "");
				
				HoaDon hd = new HoaDon(maHoaDon, nv, ngayGioRa.toLocalDateTime(), tthd, tongTien);
				ds.add(hd);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL thống kê hóa đơn");
		}
		return ds;
	}
}
