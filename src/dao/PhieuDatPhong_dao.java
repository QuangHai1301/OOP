package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.KhachHang;
import emty.NhanVien;
import emty.PhieuDatPhong;
import emty.Phong;
import emty.TrangThaiPhieuDatPhong;

public class PhieuDatPhong_dao {
	public boolean addPDP(PhieuDatPhong pdp) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO PhieuDatPhong VALUES(?,?,?,?,?,?,?,?,?)");
			stm.setString(1, pdp.getMaDatPhong());
			stm.setString(2, pdp.getMaPhong().getMaPhong());
			stm.setString(3, pdp.getMaKhachHang().getMaKH());
			stm.setString(4, pdp.getMaNhanVien().getMaNhanVien());
			stm.setInt(5, pdp.getSoNguoi());
			stm.setObject(6, pdp.getNgayDat());
			stm.setObject(7, pdp.getNgayGioVao());
			stm.setString(8, pdp.getGhiChu());
			stm.setString(9, pdp.getMaTrangThaiPhieuDP().getMaTrangThaiPhieuDP());
			n = stm.executeUpdate();
			System.out.println("Thêm Phiếu Đặt Phòng Thành Công !");
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
	
	public ArrayList<PhieuDatPhong> getAllPhieuDatPhong(){
		ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select MaDP, MaPhong, MaKH, MaNV, SoNguoi, NgayDat, NgayGioVao, GhiChu, TenLoaiTT from PhieuDatPhong join LoaiTrangThaiDatPhong on PhieuDatPhong.MaLoaiTT=LoaiTrangThaiDatPhong.MaLoaiTT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDP = rs.getString(1);
				String MaPhong = rs.getString(2);
				String MaKH = rs.getString(3);
				String MaNV = rs.getString(4);
				int SoNguoi = rs.getInt(5);
				Timestamp NgayDatPhieu = (Timestamp) rs.getObject(6);
				Timestamp NgayGioVao = (Timestamp) rs.getObject(7);
				String GhiChu = rs.getString(8);
				String TenLoaiTT = rs.getString(9);
				Phong p = new Phong(MaPhong);
				NhanVien nv = new  NhanVien(MaNV);
				KhachHang kh = new KhachHang(MaKH);
				TrangThaiPhieuDatPhong ttpdp = new TrangThaiPhieuDatPhong("", TenLoaiTT);
				
				PhieuDatPhong pdp = new PhieuDatPhong();
				if(NgayGioVao == null) {
					pdp = new PhieuDatPhong(MaDP, p, kh, nv, SoNguoi, NgayDatPhieu.toLocalDateTime(), null, GhiChu, ttpdp);
				}else {
					pdp = new PhieuDatPhong(MaDP, p, kh, nv, SoNguoi, NgayDatPhieu.toLocalDateTime(), NgayGioVao.toLocalDateTime(), GhiChu, ttpdp);
				}
				lspdp.add(pdp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL phieu dat phong");
		}
		return lspdp;
	}
	
	public ArrayList<PhieuDatPhong> getAllPhieuDatPhong_CoTheDatDV(){
		ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select MaDP, MaPhong, MaKH, MaNV, SoNguoi, NgayDat, NgayGioVao, GhiChu, TenLoaiTT from PhieuDatPhong join LoaiTrangThaiDatPhong on PhieuDatPhong.MaLoaiTT=LoaiTrangThaiDatPhong.MaLoaiTT where PhieuDatPhong.MaLoaiTT in ('LCV01','LCV02')";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDP = rs.getString(1);
				String MaPhong = rs.getString(2);
				String MaKH = rs.getString(3);
				String MaNV = rs.getString(4);
				int SoNguoi = rs.getInt(5);
				Timestamp NgayDatPhieu = (Timestamp) rs.getObject(6);
				Timestamp NgayGioVao = (Timestamp) rs.getObject(7);
				String GhiChu = rs.getString(8);
				String TenLoaiTT = rs.getString(9);
				Phong p = new Phong(MaPhong);
				NhanVien nv = new  NhanVien(MaNV);
				KhachHang kh = new KhachHang(MaKH);
				TrangThaiPhieuDatPhong ttpdp = new TrangThaiPhieuDatPhong("", TenLoaiTT);
				
				PhieuDatPhong pdp = new PhieuDatPhong();
				if(NgayGioVao == null) {
					pdp = new PhieuDatPhong(MaDP, p, kh, nv, SoNguoi, NgayDatPhieu.toLocalDateTime(), null, GhiChu, ttpdp);
				}else {
					pdp = new PhieuDatPhong(MaDP, p, kh, nv, SoNguoi, NgayDatPhieu.toLocalDateTime(), NgayGioVao.toLocalDateTime(), GhiChu, ttpdp);
				}
				lspdp.add(pdp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL phieu dat phong");
		}
		return lspdp;
	}
	
	public ArrayList<PhieuDatPhong> getAllPhieuDatPhong_TimKiem(String sqll){
		ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sqll;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDP = rs.getString(1);
				int SoNguoi = rs.getInt(2);
				Timestamp NgayDatPhieu = (Timestamp) rs.getObject(3);
				String TenLoaiTT = rs.getString(4);
				String GhiChu = rs.getString(5);
				TrangThaiPhieuDatPhong ttpdp = new TrangThaiPhieuDatPhong("", TenLoaiTT);
				
				PhieuDatPhong pdp = new PhieuDatPhong();
				pdp = new PhieuDatPhong(MaDP, null, null, null, SoNguoi, NgayDatPhieu.toLocalDateTime(), null, GhiChu, ttpdp);
				lspdp.add(pdp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL phieu dat phong tim kiem");
		}
		return lspdp;
	}
	
	
	public ArrayList<PhieuDatPhong> getAllPhieuDatPhong_DaNhan(){
		ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select MaDP, MaPhong, MaKH, MaNV, SoNguoi, NgayDat, NgayGioVao, GhiChu, TenLoaiTT from PhieuDatPhong join LoaiTrangThaiDatPhong on PhieuDatPhong.MaLoaiTT=LoaiTrangThaiDatPhong.MaLoaiTT where PhieuDatPhong.MaLoaiTT = 'LCV01'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDP = rs.getString(1);
				String MaPhong = rs.getString(2);
				String MaKH = rs.getString(3);
				String MaNV = rs.getString(4);
				int SoNguoi = rs.getInt(5);
				Timestamp NgayDatPhieu = (Timestamp) rs.getObject(6);
				Timestamp NgayGioVao = (Timestamp) rs.getObject(7);
				String GhiChu = rs.getString(8);
				String TenLoaiTT = rs.getString(9);
				Phong p = new Phong(MaPhong);
				NhanVien nv = new  NhanVien(MaNV);
				KhachHang kh = new KhachHang(MaKH);
				TrangThaiPhieuDatPhong ttpdp = new TrangThaiPhieuDatPhong("", TenLoaiTT);
				
				PhieuDatPhong pdp = new PhieuDatPhong();
				if(NgayGioVao == null) {
					pdp = new PhieuDatPhong(MaDP, p, kh, nv, SoNguoi, NgayDatPhieu.toLocalDateTime(), null, GhiChu, ttpdp);
				}else {
					pdp = new PhieuDatPhong(MaDP, p, kh, nv, SoNguoi, NgayDatPhieu.toLocalDateTime(), NgayGioVao.toLocalDateTime(), GhiChu, ttpdp);
				}
				lspdp.add(pdp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL phieu dat phong");
		}
		return lspdp;
	}
	
	
	public boolean update(PhieuDatPhong pdp) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update PhieuDatPhong set SoNguoi=?, NgayDat=?, GhiChu=? where MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, pdp.getSoNguoi()+"");
			stmt.setObject(2, pdp.getNgayDat());
			stmt.setString(3, pdp.getGhiChu());
			stmt.setString(4, pdp.getMaDatPhong());
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update phieu dat phong");
			return false;
		}
	}
	
	
	
	public boolean updateTrangThaiHetHan(String maDP) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update PhieuDatPhong set MaLoaiTT='LCV04' where MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, maDP);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update phieu dat phong trang thai het han");
			return false;
		}
	}
	
	
	public boolean updateTrangDaHuy(String maDP) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update PhieuDatPhong set MaLoaiTT='LCV03' where MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, maDP);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update phieu dat phong trang thai Đã hủy");
			return false;
		}
	}
	
	
	
	public void delete(String maDatPhong) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "delete PhieuDatPhong where MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);;
			stmt.setString(1, maDatPhong);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở delete phieu dat phong");
		}
	}
	
	
	
	public boolean updateGioNhanPhong(String maDP, LocalDateTime ngayGioNhan) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update PhieuDatPhong set NgayGioVao=?, MaLoaiTT=? where MaDP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, ngayGioNhan);
			stmt.setString(2, "LCV01");
			stmt.setString(3, maDP);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở update phieu dat phong Ngay Gio Nhan");
			return false;
		}
	}
	
	
	public String layPDP_MaHD(String maHD) {
		String maDP = "";
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select distinct MaDP from HoaDon join ChiTietHoaDon on HoaDon.MaHD=ChiTietHoaDon.MaHD where [dbo].[HoaDon].MaHD=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				maDP = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi lấy mã đặt phòng theo mã hóa đơn !");
		}
		return maDP;
	}
}
