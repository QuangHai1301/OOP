package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import ConnectDB.ConnectDB;
import emty.NhanVien;
import emty.TaiKhoan;

public class NhanVien_dao {
	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaNV = rs.getString(1);
				String HoTen = rs.getString(2);
				String GioiTinh = rs.getString(3);
				String DiaChi = rs.getString(4);
				String SDT = rs.getString(5);
				String NgayVaoLam = rs.getString(6);
				String ChucVu = rs.getString(7);
				String TenTK = rs.getString(8);
				
				LocalDate NgayVaoLam1 = LocalDate.parse(NgayVaoLam);
				emty.ChucVu cv = new emty.ChucVu(ChucVu,"");
				
				TaiKhoan tk = new TaiKhoan(TenTK);
				NhanVien nv = new NhanVien(MaNV, HoTen, GioiTinh, DiaChi, SDT, NgayVaoLam1 , cv, tk);
				 
				lsnv.add(nv);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Nhân Viên");
		}
		return lsnv;
	}
	
	public void delete(String ma) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("delete from NhanVien where MaNV=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi Dữ Liệu Xóa Nhân Viên");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean update(NhanVien nv) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " NhanVien set HoTen=? , GioiTinh=?, DiaChi=?, SDT=?, NgayVaoLam=?, MaLoaiCV=? where MaNV=?");
			//stm.setString(1, nv.getMaNhanVien());
			stm.setString(1, nv.getHoTen());
			stm.setString(2, nv.getGioiTinh());
			stm.setString(3, nv.getDiaChi());
			stm.setString(4, nv.getSoDienThoai());
			stm.setObject(5, nv.getNgayVaoLam());			
			stm.setString(6, nv.getMaLoaiChucVu().getMaLoaiChucVu());
			stm.setString(7, nv.getMaNhanVien());
			//stm.setString(8, null);
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
	
	public boolean add(NhanVien nv) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?)");
			
			stm.setString(1, nv.getMaNhanVien());
			stm.setString(2, nv.getHoTen());
			stm.setString(3, nv.getGioiTinh());
			stm.setString(4, nv.getDiaChi());
			stm.setString(5, nv.getSoDienThoai());
			stm.setObject(6, nv.getNgayVaoLam());			
			stm.setString(7, nv.getMaLoaiChucVu().getMaLoaiChucVu());
			//System.out.println(nv.getMaLoaiChucVu());
			stm.setString(8, null);
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
	
	public ArrayList<NhanVien> timkiemNhanVien(String sql1){
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sql1;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaNV = rs.getString(1);
				String HoTen = rs.getString(2);
				String GioiTinh = rs.getString(3);
				String DiaChi = rs.getString(4);
				String SDT = rs.getString(5);
				String NgayVaoLam = rs.getString(6);
				String ChucVu = rs.getString(7);
				String TenTK = rs.getString(8);
				
				LocalDate NgayVaoLam1 = LocalDate.parse(NgayVaoLam);
				emty.ChucVu cv = new emty.ChucVu(ChucVu,"");
				TaiKhoan tk = new TaiKhoan(TenTK);
				NhanVien nv = new NhanVien(MaNV, HoTen, GioiTinh, DiaChi, SDT, NgayVaoLam1 , cv, tk);
				ds.add(nv);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Tìm Kiếm Nhân Viên");
		}
		return ds;
	}
	
	
	public ArrayList<NhanVien> getAllNhanVien_NotTK(){
		ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where TenTK is NULL";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaNV = rs.getString(1);
				String HoTen = rs.getString(2);
				String GioiTinh = rs.getString(3);
				String DiaChi = rs.getString(4);
				String SDT = rs.getString(5);
				String NgayVaoLam = rs.getString(6);
				String ChucVu = rs.getString(7);
				String TenTK = rs.getString(8);
				
				LocalDate NgayVaoLam1 = LocalDate.parse(NgayVaoLam);
				emty.ChucVu cv = new emty.ChucVu(ChucVu,"");
				
				TaiKhoan tk = new TaiKhoan(TenTK);
				NhanVien nv = new NhanVien(MaNV, HoTen, GioiTinh, DiaChi, SDT, NgayVaoLam1 , cv, tk);
				 
				lsnv.add(nv);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Nhân Viên chua co tai khoan");
		}
		return lsnv;
	}
	
	public boolean updateTKNV(String TenTK, String maNV) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " NhanVien set TenTK=? where MaNV=?");
			stm.setString(1, TenTK);
			stm.setString(2, maNV);
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
