package QLKaraoke_Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.DangNhap;
import View.Main;
import dao.TaiKhoan_dao;
import emty.TaiKhoan;

public class Controller_DangNhap implements ActionListener{
	public DangNhap view_DangNhap;
	public Main view_Main;
	JFrame f;
	
	public Controller_DangNhap(DangNhap view_DangNhap) {
		super();
		this.view_DangNhap = view_DangNhap;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(view_DangNhap.btnDangNhap)) {
			boolean checkTaiKhoan = false;
			boolean checkMatKhau = false;
			String TenTK = view_DangNhap.textTaiKhoanDN.getText();
			String MK = view_DangNhap.passwordMatKhauDN.getText();
			TaiKhoan taiKhoanDangNhap = new TaiKhoan(TenTK, MK);
			ArrayList<TaiKhoan> lstk = new ArrayList<TaiKhoan>();
			TaiKhoan_dao tkd = new TaiKhoan_dao();
			lstk = tkd.getAllTaiKhoan();
			if(taiKhoanDangNhap.getTenTK().equals("") | taiKhoanDangNhap.getMK().equals("")) {
				JOptionPane.showMessageDialog(f, "Tài Khoản Hoặc Mật Khẩu Không Được Để Trống !");
			}else {
				for (TaiKhoan taiKhoan : lstk) {
					if(taiKhoan.getTenTK().equals(taiKhoanDangNhap.getTenTK())) {
						checkTaiKhoan = true;
						if(taiKhoan.getMK().equals(taiKhoanDangNhap.getMK())) {
							checkMatKhau = true;
							view_DangNhap.setVisible(false);
							view_Main = new Main(taiKhoan);
							view_Main.setVisible(true);
							view_Main.lblNameTaiKhoan.setText(taiKhoan.getTenTK());
							String quyen = taiKhoan.getMaQuyen().getMaQuyen();
							System.out.println(quyen);
							System.out.println(quyen.equals("LQ03"));
							if(quyen.equals("LQ02")) {
								break;
							}else if(quyen.equals("LQ03")) {
								this.view_Main.mntmQuanLyKhachHang.setBackground(Color.red);
								this.view_Main.mntmTimKiemKhachHang.setBackground(Color.red);
								this.view_Main.mntmQuanLyNhanVien.setBackground(Color.red);
								this.view_Main.mntmLoaiChucVu.setBackground(Color.red);
								this.view_Main.mntmDatPhong.setBackground(Color.red);
								this.view_Main.mntmCapNhatPhieuDatPhong.setBackground(Color.red);
								this.view_Main.mntmQuanLyPhong.setBackground(Color.red);
								this.view_Main.mntmLoaiPhong.setBackground(Color.red);
								this.view_Main.mntmLoaiDichVu.setBackground(Color.red);
								this.view_Main.mntmQuanLyDichVu.setBackground(Color.red);
								this.view_Main.mntmDatDichVu.setBackground(Color.red);
								this.view_Main.mntmTheoNgay.setBackground(Color.red);
								this.view_Main.mntmQuanLyTaiKhoan.setBackground(Color.red);
								this.view_Main.mntmTimKiemTaiKhoan.setBackground(Color.red);
								this.view_Main.mntmLapHoaDon.setBackground(Color.red);
								this.view_Main.mntmThanhToan.setBackground(Color.red);
								this.view_Main.mntmTimKiemNhanVien.setBackground(Color.red);
							}else {
								this.view_Main.mntmQuanLyNhanVien.setBackground(Color.red);
								this.view_Main.mntmLoaiChucVu.setBackground(Color.red);
								this.view_Main.mntmQuanLyPhong.setBackground(Color.red);
								this.view_Main.mntmLoaiPhong.setBackground(Color.red);
								this.view_Main.mntmQuanLyDichVu.setBackground(Color.red);
								this.view_Main.mntmLoaiDichVu.setBackground(Color.red);
								this.view_Main.mntmQuanLyTaiKhoan.setBackground(Color.red);
								this.view_Main.mntmTimKiemTaiKhoan.setBackground(Color.red);
								this.view_Main.mntmTheoNgay.setBackground(Color.red);
							}
						}
					}
				}
			}
			
			if(checkTaiKhoan == false) {
				JOptionPane.showMessageDialog(f, "Tài Khoản Không Tồn Tại !");
			}else {
				if(checkMatKhau == false) {
					JOptionPane.showMessageDialog(f, "Mật Khẩu Sai !");
				}
			}
		}
		if(o.equals(view_DangNhap.btnXoaTrangDN)) {
			view_DangNhap.textTaiKhoanDN.setText("");
			view_DangNhap.passwordMatKhauDN.setText("");
		}
		
	}

}
