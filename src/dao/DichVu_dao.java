package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import emty.DichVu;
import emty.LoaiDichVu;

public class DichVu_dao {
	public ArrayList<DichVu> getAllDichVu(){
		ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select MaDV,[dbo].[LoaiDichVu].TenLoaiDV,TenDV,Gia from DichVu join LoaiDichVu on DichVu.MaLoaiDV=LoaiDichVu.MaLoaiDV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDV = rs.getString(1);
				String MaLoaiDV = rs.getString(2);
				String TenDV = rs.getString(3);
				float GiaMua = rs.getFloat(4);
				
				LoaiDichVu ldv = new LoaiDichVu(MaLoaiDV);
				DichVu dv = new DichVu(MaDV, ldv, TenDV, GiaMua);
				
				lsdv.add(dv);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở get ALL Dịch Vụ");
		}
		return lsdv;
	}
	
	public ArrayList<DichVu> getAllDichVu1(){
		ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select MaDV,[dbo].[LoaiDichVu].MaLoaiDV,TenDV,Gia from DichVu join LoaiDichVu on DichVu.MaLoaiDV=LoaiDichVu.MaLoaiDV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDV = rs.getString(1);
				String MaLoaiDV = rs.getString(2);
				String TenDV = rs.getString(3);
				float GiaMua = rs.getFloat(4);
				
				LoaiDichVu ldv = new LoaiDichVu(MaLoaiDV, "");
				DichVu dv = new DichVu(MaDV, ldv, TenDV, GiaMua);
				
				lsdv.add(dv);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở get ALL Dịch Vụ1");
		}
		return lsdv;
	}
	
	
	public boolean add(String MaDV, String TenDV, String GiaMua, String ldv) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(
					"INSERT INTO DichVu VALUES(?,?,?,?)");
			stm.setString(1, MaDV);
			stm.setString(2, ldv);
			stm.setString(3, TenDV);
			stm.setString(4, GiaMua);
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
			stm = con.prepareStatement("delete from DichVu where MaDV=?");
			stm.setString(1, ma);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở xóa dịch vụ");
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean update(String MaDV, String TenDV, String GiaMua, String ldv) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("update " + " DichVu set TenDV=? ,  Gia=?, MaLoaiDV=? where MaDV=?");
			stm.setString(1, TenDV);
			stm.setString(2, GiaMua);
			stm.setString(3, ldv);
			stm.setString(4, MaDV);
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
	public ArrayList<DichVu> timKiemDichVu(String sql1){
		ArrayList<DichVu> ds = new ArrayList<DichVu>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = sql1;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String MaDV = rs.getString(1);
				String MaLoaiDV = rs.getString(4);
				String TenDV = rs.getString(2);
				float GiaMua = rs.getFloat(3);
				
				LoaiDichVu ldv = new LoaiDichVu(MaLoaiDV, "");
				DichVu dv = new DichVu(MaDV, ldv, TenDV, GiaMua);
				
				ds.add(dv);
			}
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi ở Lấy ALL Tìm Kiếm dịch vụ");
		}
		return ds;
	}
}
