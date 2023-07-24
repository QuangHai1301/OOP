package View;

import java.awt.EventQueue;import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import QLKaraoke_Controller.Controller_Main;
import emty.TaiKhoan;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.SoftBevelBorder;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class Main extends JFrame {
	
	public TaiKhoan taiKhoanDangNhap;
	
	private JPanel contentPane;
	public JTable table_OutputListTimKiemPhong;
	private JPanel Panel_TrangChu;
	public CardLayout cl_Panel_GiaoDienManHinhTong;
	public JMenuItem mntmTimKiemPhong;
	public JPanel Panel_GiaoDienManHinhTong;
	public JMenuItem mntmTrangChinh;
	public JTextField textQLPhongMaPhong;
	public JTextField textQLPhongTenPhong;
	public JTable table_OutputListQuanLyPhong;
	public JMenuItem mntmQuanLyPhong;
	public JTextField textMaKhachHangTimKiemKH;//dasua
	public JTextField textHoTenTimKiemKH;//dasua
	public JTextField textSDTTimKiemKH;//dasua
	public JTextField textDiaChiTimKiemKH;//dasua
	public JButton btnTimKHTimKiemKH; //dasua
	public JTable table_OutPutTKkhachHang;
	public JTextField textMaKhachHangQLKH;
	public JTextField textHoTenQLKH;
	public JTextField textSDTQLKH;
	public JTextField textDiaChiQLKH;
	public JTable table_OutPutQLKH;
	public JTextField textMaNhanVienQLNV;
	public JTextField textHoTenQLNV;
	public JTextField textSDTQLNV;
	public JTextField textDiaChiQLNV;
	public JTable table_OutputListQLNV;
	public JTextField textMaNhanVienTKNV;
	public JTextField textHoTenTKNV;
	public JTable table_OutputListTKNV;
	public JMenuItem mntmQuanLyKhachHang;
	public JMenuItem mntmTimKiemKhachHang;
	public JMenuItem mntmQuanLyNhanVien;
	public JMenuItem mntmTimKiemNhanVien;
	public JTextField textMaDichVuQLDV;//dasua
	public JTextField textTenDichVuQLDV;//dasua
	public JTextField textGiaMuaQLDV;//dasua
	public JTable table_OutputListQLDV;
	public JTextField textMaDichVuTKDV;//dasua
	public JTextField textTenDichVuTKDV;//dasua
	public JTextField textSoLuongTKDV;//dasua
	public JTable table_OutputListTKDV;//dasua
	public JButton btnTimKiemTKDV;//dasua
	public JMenuItem mntmQuanLyDichVu;
	public JMenuItem mntmTimKiemDichVu;
	public JTable table_OutputListQLTK;
	public JTextField textTenTaiKhoanTKTK;
	public JTable table_OutputListTKTK;
	public JMenuItem mntmQuanLyTaiKhoan;
	public JMenuItem mntmTimKiemTaiKhoan;
	public JTable table_OutputListDSKHDP;
	public JMenuItem mntmDatPhong;
	public JTable table_OutputListDSPDPTHD;
	public JTable table_OutputListDSHDCTT;
	public JMenuItem mntmThanhToan;
	public JTable table_danhSachHoaDonTK;
	public JMenuItem mntmTheoNgay;

	public JLabel lblNameTaiKhoan;
	public JTable table_OutputListDSPTDP;
	public JTextField textGhiChuKQDP;
	public JTextField textGhiChuKQQLPDP;
	public JTextField textTenKhachHangKQQLPDP;
	public JTextField textSoDienThoaiKQQLPDP;

	public JMenuItem mntmCapNhatPhieuDatPhong;
	public JTable table_PhieuDatPhongQLPDP;
	public JTable table_DanhSachPhieuDP;

	public JButton btn_Title_DangXuat;

	public JButton btnQLPhongThem;

	public JComboBox<String> comboBoxQLPhongLoaiPhong;

	public JButton btnQLPhongXoa;

	public JButton btnQLPhongSua;

	public JButton btnThemQLKH;

	public JButton btnXoaQLKH;

	public JButton btnSuaQLKH;

	public JButton btnTimPhongTimKiem;

	public JCheckBox chckbxTimPhongMaPhong;

	public JCheckBox chckbxTimPhongTenPhong;

	public JCheckBox chckbxTimPhongLoaiPhong;

	public JCheckBox chckbxTimPhongTrangThai;

	public JComboBox comboBoxTimPhongLoaiPhong;

	public JPanel panel_InputTimKiemPhong;

	public JComboBox comboBoxTimPhongTrangThai;

	public JButton btnXoaQLNV;

	public JButton btnThemQLNV;

	public JButton btnSuaQLNV;

	public JButton btntDatPhongDP;
	
	public JTextField textMaDatPhongKQDP;

	public JButton btnHuyQLPDP;

	public JButton btnSuaQLPDP;
	public JCheckBox chckbxTimKHSDTKhachHang, chckbxTimKHDiaChiKH, chckbxTimKHMaKhachHang,chckbxTimKHHoTenKH; //dasua
	public JButton btnThemQLDV, btnXoaQLDV, btnSuaQLDV;//dasua
	public JComboBox<String> comboBoxLoaiDichVuQLDV, comboBox_LoaiDichVuTKDV;//dasua
	public JCheckBox chckbxTenDichVuTKDV, chckbxLoaiDichVuTKDV, chckbxSoLuongTKDV, chckbxMaDichVuTKDV;
	public JTextField textField_DonGiaDDV;
	public JTextField textField_SoLuongDDV;
	public JTextField textField_TongTienTT;

	public JComboBox comboBox_SoNguoiDP;
	public JTable table_PhieuDatPhongDP;

	public JComboBox comboBox_GioLDP;

	public JComboBox comboBox_PhutDP;

	public JDateChooser dateChooserNgayDatPhongDP;
	public JTextField textField_TenNhanVienQLPDP;
	public JTextField textField_TenKhachHangKQDP;
	public JTextField textField_SoDienThoaiKQDP;
	public JTextField textField_TenNhanVienKQDP;

	public JComboBox comboBox_SoNguoiQLDP;

	public JComboBox comboBox_GioQLDP;

	public JComboBox comboBox_PhutQLDP;

	public JDateChooser dateChooser_NgayDatPhongQLDP;

	public JButton btnQLPhongXoaTrang;

	public JComboBox comboBoxTimPhongMaPhong;

	public JComboBox comboBoxTimPhongTenPhong;
	public JTextField textField_TenPhongDDV;
	public JTextField textField_LoaiPhongDDV;
	public JTextField textField_GiaPhongDDV;
	public JTable table_ChiTietDichVuDDV;

	public JComboBox comboBox_GioDDV;

	public JComboBox comboBox_PhutDDV;

	public JComboBox comboBoxLoaiDichVuDDV;

	public JComboBox comboBox_TenDichVuDDV;

	public JDateChooser dateChooserNgayLapHD;

	public JButton btnBatDauTinhGioDDV;
	public JTextField textField_NgayGioNhanPhongDDV;
	public JButton btnXoaTrangQLKH;

	public JButton btnThemDichVuDDV, btnXoaTrangQLDV;
	public JTextField textField_TienThuaTTKQ;
	public JTextField textField_1_TienNhanTTKQ;

	public JButton btnInHoaDonTT;
	public JTextField textField_maHoaDonTHD;
	public JTextField textField_hoTenNhanVienLHD;
	public JTextField textField_hoTenKhachHangLHD;
	public JTextField textField_maDatPhongLHD;

	public JMenuItem mntmLapHoaDon;
	public JTextField textField_hoTenNhanVienTT;
	public JTextField textField_hoTenKhachHangTT;
	public JTextField textField_maDatPhongTT;
	public JTextField textField_ngayLapLHD;
	public JTextField textField_ngayLapTT;
	public JTable table_DanhSachDichVuTT;
	public JTable table_danhSachDichVuLHD;
	public JTable table_danhSachPhieuDatPhongLHD;
	public JTextField textField_maLoaiDichVuLDV;
	public JTextField textField_tenLoaiDichVuLDV;
	public JTable table_danhSachLoaiDichVuLDV;
	public JTextField textField_maLoaiChucVuLCV;
	public JTextField textField_tenLoaiChucVuLCV;
	public JTable table_danhSachLoaiChucVuLCV;

	public JMenuItem mntmLoaiPhong;

	public JMenuItem mntmLoaiDichVu;

	public JMenuItem mntmLoaiChucVu;
	public JTextField textField_maLoaiPhongLP;
	public JTextField textField_tenLoaiPhongLP;
	public JTable table_danhSachLoaiPhongLP;
	public JTextField textField_TongHoaDonTK;
	public JTextField textField_TongDoanhThuTK;

	public JComboBox comboBox_PhutLHD;

	public JComboBox comboBox_GioLHD;

	public JButton btnLapHoaDonLHD;

	public JDateChooser dateChooserNgayLapLHD;

	public JLabel lblmaHoaDonLHD;

	public JLabel lblMaHoaDonTT;

	public JButton btntThanhToanTT;
	public JTable table_khachHang_nhanVienQLTK;

	public JMenuItem mntmDatDichVu;
	

	public JComboBox comboBox_GioiTinhTKNV;

	public JButton btnTimKiemTKNV;

	public JCheckBox chckbxMaNhanVienTKNV;

	public JCheckBox chckbxHoTenTKNV;

	public JCheckBox chckbxGioiTinhTKNV;

	public JCheckBox chckbxNgayVaoLamTKNV;

	public JCheckBox chckbxChucVuTKNV;

	public JComboBox comboBox_ChucVuTKNV;

	public JDateChooser dateChooser_NgayVaoLamTKNV;

	public JTextField textTenTaiKhoanQLTK;

	public JButton btnThemQLTK;

	public JButton btnXoaQLTK;

	public JButton btnSuaQLTK;

	public JComboBox comboBox_QuyenHanQLTK;

	public JButton btnXoaTrangQLTK;

	public JComboBox comboBoxKH_NV_QLTK;

	public JButton btnTimKiemTKTK;

	public JCheckBox chckbxTenTaiKhoanTKTK;

	public JCheckBox chckbxQuyenHanTKTK;

	public JComboBox comboBox_QuyenHanTKTK;

	public JComboBox comboBoxGioiTinhQLNV;

	public JButton btnXoaTrangQLNV;

	public JComboBox comboBoxChucVuQLNV;

	public JDateChooser dateChooserNgayVaoLamQLNV;

	public JButton btnThemLCV;

	public JButton btnXoaLCV;

	public JButton btnSuaLCV;
	
	public JButton btnXoaTrangLCV;
	public JButton btnThemLDV,btnXoaTrangLDV, btnSuaLDV, btnXoaLDV;
	public JButton btnXoaTrangLP, btnSuaLP, btnXoaLP, btnThemLP;
	public JTextField textField_giaPhongLP;
	public JCheckBox chckbx_ThongKeNamTK, chckbx_ThongKeThangTK, chckbxThongKeNgayTK;
	public JButton btnThongKeTK, btnTongTienGiamDanTK, btnInThongKe, btnTongTienTangDanTK;
	public JDateChooser dateChooser_ThongKeNgayTK;
	public JComboBox comboBox_nam1TK, comboBox_namTK, comboBox_thangTK;
	public JPasswordField passwordFieldMKQLTK;
	public JPasswordField passwordField_againMKQLTK;

	public JButton btnHuyDichVuDDV;
	public JTextField textFieldnamekh;
	public JTextField textField_sdt;
	public JTextField textField_mdp;

	public JButton btnTimKiempdp;

	public JCheckBox chckbxdoubletime;

	public JCheckBox chckbxNameKH;

	public JCheckBox chckbxSDTqlpdp;

	public JCheckBox chckbxMaDP;

	public JDateChooser dateChooser_timkiempdp1;

	public JDateChooser dateChooser_timkiempdp2;

	public JButton btnXoaTrangTimKiempdp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(null);
					frame.setVisible(true);
					int check = -1;
					while(check != 0) {
						check = JOptionPane.showConfirmDialog(frame,"Đăng nhập đi bạn ơi ai chơi đi tắt vậy :))");
					}
					if(check == 0) {
						frame.setVisible(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main(TaiKhoan taiKhoanDangNhap) {
//		khởi tạo kết nối sql
		ConnectDB connect = new ConnectDB();
		connect.getConnectDB();
		
		
		
		this.taiKhoanDangNhap = taiKhoanDangNhap;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 904);
		setLocationRelativeTo(null);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		ActionListener action_Main = new Controller_Main(this);
		MouseListener Main_mouse_action = new Controller_Main(this);

//		tổng hợp các phần menu
		JMenu menuTrangChu = new JMenu("Trang Chủ");
		menuTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuTrangChu.setIcon(new ImageIcon(Main.class.getResource("house.png")));
		menuBar.add(menuTrangChu);
		
		mntmTrangChinh = new JMenuItem("Trang Chính");
		mntmTrangChinh.addActionListener(action_Main);
		mntmTrangChinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuTrangChu.add(mntmTrangChinh);
			
		JMenu menuKhachHang = new JMenu("Khách Hàng");
		menuKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuKhachHang.setBackground(Color.WHITE);
		menuKhachHang.setIcon(new ImageIcon(Main.class.getResource("customer.png")));
		menuBar.add(menuKhachHang);
		
		mntmQuanLyKhachHang = new JMenuItem("Quản Lý Khách Hàng");
		mntmQuanLyKhachHang.addActionListener(action_Main);
		mntmQuanLyKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuKhachHang.add(mntmQuanLyKhachHang);
		
		mntmTimKiemKhachHang = new JMenuItem("Tìm Kiếm Khách Hàng");
		mntmTimKiemKhachHang.addActionListener(action_Main);
		mntmTimKiemKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuKhachHang.add(mntmTimKiemKhachHang);
		
		JMenu menuNhanVien = new JMenu("Nhân Viên");
		menuNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuNhanVien.setIcon(new ImageIcon(Main.class.getResource("staff.png")));
		menuBar.add(menuNhanVien);
		
		mntmQuanLyNhanVien = new JMenuItem("Quản Lý Nhân Viên");
		mntmQuanLyNhanVien.addActionListener(action_Main);
		mntmQuanLyNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuNhanVien.add(mntmQuanLyNhanVien);
		
		mntmTimKiemNhanVien = new JMenuItem("Tìm Kiếm Nhân Viên");
		mntmTimKiemNhanVien.addActionListener(action_Main);
		mntmTimKiemNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuNhanVien.add(mntmTimKiemNhanVien);
		
		mntmLoaiChucVu = new JMenuItem("Loại Chức Vụ");
		mntmLoaiChucVu.addActionListener(action_Main);
		mntmLoaiChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuNhanVien.add(mntmLoaiChucVu);
		
		JMenu menuPhong = new JMenu("Phòng");
		menuPhong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuPhong.setIcon(new ImageIcon(Main.class.getResource("room.png")));
		menuBar.add(menuPhong);
		
		mntmDatPhong = new JMenuItem("Đặt Phòng");
		mntmDatPhong.addActionListener(action_Main);
		mntmDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuPhong.add(mntmDatPhong);
		
		mntmQuanLyPhong = new JMenuItem("Quản Lý Phòng");
		mntmQuanLyPhong.addActionListener(action_Main);
		
		mntmCapNhatPhieuDatPhong = new JMenuItem("Cập Nhật Phiếu Đặt Phòng");
		mntmCapNhatPhieuDatPhong.addActionListener(action_Main);
		mntmCapNhatPhieuDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuPhong.add(mntmCapNhatPhieuDatPhong);
		mntmQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuPhong.add(mntmQuanLyPhong);
		
		mntmTimKiemPhong = new JMenuItem("Tìm Kiếm Phòng");
		mntmTimKiemPhong.addActionListener(action_Main);
		mntmTimKiemPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuPhong.add(mntmTimKiemPhong);
		
		mntmLoaiPhong = new JMenuItem("Loại Phòng");
		mntmLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mntmLoaiPhong.addActionListener(action_Main);
		menuPhong.add(mntmLoaiPhong);
		
		JMenu menuDichVu = new JMenu("Dịch Vụ");
		mntmLoaiPhong.addActionListener(action_Main);
		menuDichVu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuDichVu.setIcon(new ImageIcon(Main.class.getResource("customer-service.png")));
		menuBar.add(menuDichVu);
		
		mntmQuanLyDichVu = new JMenuItem("Quản Lý Dịch Vụ");
		mntmQuanLyDichVu.addActionListener(action_Main);
		
		mntmDatDichVu = new JMenuItem("Đặt Dịch Vụ");
		mntmDatDichVu.addActionListener(action_Main);
		mntmDatDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuDichVu.add(mntmDatDichVu);
		mntmQuanLyDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuDichVu.add(mntmQuanLyDichVu);
		
		mntmTimKiemDichVu = new JMenuItem("Tìm Kiếm Dịch Vụ");
		mntmTimKiemDichVu.addActionListener(action_Main);
		mntmTimKiemDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuDichVu.add(mntmTimKiemDichVu);
		
		mntmLoaiDichVu = new JMenuItem("Loại Dịch Vụ");
		mntmLoaiDichVu.addActionListener(action_Main);
		mntmLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuDichVu.add(mntmLoaiDichVu);
		
		JMenu menuThongKe = new JMenu("Thống Kê");
		menuThongKe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuThongKe.setIcon(new ImageIcon(Main.class.getResource("analytics.png")));
		menuBar.add(menuThongKe);
		
		mntmTheoNgay = new JMenuItem("Thống Kê Doanh Thu");
		mntmTheoNgay.addActionListener(action_Main);
		mntmTheoNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuThongKe.add(mntmTheoNgay);
		
		JMenu menuTaiKhoan = new JMenu("Tài Khoản");
		menuTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuTaiKhoan.setIcon(new ImageIcon(Main.class.getResource("/View/user.png")));
		menuBar.add(menuTaiKhoan);
		
		mntmQuanLyTaiKhoan = new JMenuItem("Quản Lý Tài Khoản");
		mntmQuanLyTaiKhoan.addActionListener(action_Main);
		mntmQuanLyTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuTaiKhoan.add(mntmQuanLyTaiKhoan);
		
		mntmTimKiemTaiKhoan = new JMenuItem("Tìm Kiếm Tài Khoản");
		mntmTimKiemTaiKhoan.addActionListener(action_Main);
		mntmTimKiemTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuTaiKhoan.add(mntmTimKiemTaiKhoan);
		
		JMenu menuHoaDon = new JMenu("Hóa Đơn");
		menuHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuHoaDon.setIcon(new ImageIcon(Main.class.getResource("/View/bill.png")));
		menuBar.add(menuHoaDon);
		
		mntmThanhToan = new JMenuItem("Thanh Toán");
		mntmThanhToan.addActionListener(action_Main);
		
		mntmLapHoaDon = new JMenuItem("Lập Hóa Đơn");
		mntmLapHoaDon.addActionListener(action_Main);
		mntmLapHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuHoaDon.add(mntmLapHoaDon);
		mntmThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		menuHoaDon.add(mntmThanhToan);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		phần content của giao diện
		JPanel panel_Title_TaiKhoan = new JPanel();
		panel_Title_TaiKhoan.setBackground(UIManager.getColor("ToolBar.dockingBackground"));
		panel_Title_TaiKhoan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_TaiKhoan.setBounds(0, 11, 1184, 115);
		contentPane.add(panel_Title_TaiKhoan);
		panel_Title_TaiKhoan.setLayout(null);
		
		JLabel lblChaoMungTroLai = new JLabel("Chào Mừng Bạn Đã Trở Lại");
		lblChaoMungTroLai.setForeground(Color.BLACK);
		lblChaoMungTroLai.setFont(new Font("#9Slide03 AllRoundGothic", Font.BOLD, 45));
		lblChaoMungTroLai.setBounds(239, 30, 582, 59);
		panel_Title_TaiKhoan.add(lblChaoMungTroLai);
		
		JPanel panel_TaiKhoan_DangXuat = new JPanel();
		panel_TaiKhoan_DangXuat.setBackground(Color.ORANGE);
		panel_TaiKhoan_DangXuat.setBounds(1027, 11, 149, 93);
		panel_Title_TaiKhoan.add(panel_TaiKhoan_DangXuat);
		
		lblNameTaiKhoan = new JLabel("Tài Khoản");
		panel_TaiKhoan_DangXuat.add(lblNameTaiKhoan);
		lblNameTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		JLabel lbl_Icon_User = new JLabel("");
		panel_TaiKhoan_DangXuat.add(lbl_Icon_User);
		lbl_Icon_User.setIcon(new ImageIcon(Main.class.getResource("/View/user.png")));
		
		btn_Title_DangXuat = new JButton("Đăng Xuất");
		btn_Title_DangXuat.setBackground(Color.LIGHT_GRAY);
		panel_TaiKhoan_DangXuat.add(btn_Title_DangXuat);
		btn_Title_DangXuat.addActionListener(action_Main);
		btn_Title_DangXuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		cái này là cardlayout chứa tất cả giao diện
		cl_Panel_GiaoDienManHinhTong = new CardLayout(0,  0);
		
		Panel_GiaoDienManHinhTong = new JPanel();
		Panel_GiaoDienManHinhTong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Panel_GiaoDienManHinhTong.setBounds(0, 137, 1184, 694);
		contentPane.add(Panel_GiaoDienManHinhTong);
		Panel_GiaoDienManHinhTong.setLayout(cl_Panel_GiaoDienManHinhTong);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình trang chủ
		Panel_TrangChu = new JPanel();
		Panel_TrangChu.setBackground(Color.WHITE);
		Panel_GiaoDienManHinhTong.add(Panel_TrangChu, "manHinhTrangChu");
		Panel_TrangChu.setLayout(null);
		
		JLabel lbl_ImageTrangChu = new JLabel("");
		lbl_ImageTrangChu.setBounds(95, 11, 1024, 690);
		lbl_ImageTrangChu.setIcon(new ImageIcon(Main.class.getResource("/View/istockphoto-844147782-1024x1024.jpg")));
		Panel_TrangChu.add(lbl_ImageTrangChu);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình tìm kiếm phòng
		JPanel Panel_TimKiemPhong = new JPanel();
		Panel_GiaoDienManHinhTong.add(Panel_TimKiemPhong, "manHinhTimKiemPhong");
		Panel_TimKiemPhong.setLayout(null);
		
		JPanel panel_Title_TimKiemPhong = new JPanel();
		panel_Title_TimKiemPhong.setBackground(new Color(0, 191, 255));
		panel_Title_TimKiemPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_TimKiemPhong.setBounds(10, 11, 1160, 64);
		Panel_TimKiemPhong.add(panel_Title_TimKiemPhong);
		panel_Title_TimKiemPhong.setLayout(null);
		
		JLabel lbl_Title_TimKiemPhong = new JLabel("Tìm Kiếm Phòng");
		lbl_Title_TimKiemPhong.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_Title_TimKiemPhong.setBounds(399, 11, 367, 53);
		panel_Title_TimKiemPhong.add(lbl_Title_TimKiemPhong);
		
		JPanel panel_InputOutputTimKiemPhong = new JPanel();
		panel_InputOutputTimKiemPhong.setBackground(new Color(0, 191, 255));
		panel_InputOutputTimKiemPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputTimKiemPhong.setBounds(10, 86, 1160, 593);
		Panel_TimKiemPhong.add(panel_InputOutputTimKiemPhong);
		panel_InputOutputTimKiemPhong.setLayout(null);
		
		panel_InputTimKiemPhong = new JPanel();
		panel_InputTimKiemPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputTimKiemPhong.setBounds(10, 11, 1140, 276);
		panel_InputOutputTimKiemPhong.add(panel_InputTimKiemPhong);
		panel_InputTimKiemPhong.setLayout(null);
		
		JLabel lblNhapThongTinPhongCanTim = new JLabel("Nhập Thông Tin Phòng Cần Tìm :");
		lblNhapThongTinPhongCanTim.setBounds(10, 11, 349, 27);
		panel_InputTimKiemPhong.add(lblNhapThongTinPhongCanTim);
		lblNhapThongTinPhongCanTim.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaPhong.setBounds(395, 70, 79, 27);
		panel_InputTimKiemPhong.add(lblMaPhong);
		
		JLabel lblTenPhong = new JLabel("Tên Phòng");
		lblTenPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenPhong.setBounds(391, 117, 83, 27);
		panel_InputTimKiemPhong.add(lblTenPhong);
		
		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTrangThai.setBounds(385, 211, 89, 27);
		panel_InputTimKiemPhong.add(lblTrangThai);
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoaiPhong.setBounds(385, 166, 89, 27);
		panel_InputTimKiemPhong.add(lblLoaiPhong);
		
		chckbxTimPhongMaPhong = new JCheckBox("");
		chckbxTimPhongMaPhong.setBounds(727, 70, 21, 23);
		
		panel_InputTimKiemPhong.add(chckbxTimPhongMaPhong);
		
		chckbxTimPhongTenPhong = new JCheckBox("");
		chckbxTimPhongTenPhong.setBounds(727, 117, 21, 23);
		panel_InputTimKiemPhong.add(chckbxTimPhongTenPhong);
		
		chckbxTimPhongLoaiPhong = new JCheckBox("");
		chckbxTimPhongLoaiPhong.setBounds(727, 166, 21, 23);
		panel_InputTimKiemPhong.add(chckbxTimPhongLoaiPhong);
		
		chckbxTimPhongTrangThai = new JCheckBox("");
		chckbxTimPhongTrangThai.setBounds(727, 215, 21, 23);
		panel_InputTimKiemPhong.add(chckbxTimPhongTrangThai);
		
		btnTimPhongTimKiem = new JButton("Tìm Kiếm");
		btnTimPhongTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimPhongTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimPhongTimKiem.addActionListener(action_Main);
		btnTimPhongTimKiem.setBounds(818, 196, 122, 38);
		
		panel_InputTimKiemPhong.add(btnTimPhongTimKiem);
		
		comboBoxTimPhongLoaiPhong = new JComboBox();
		comboBoxTimPhongLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxTimPhongLoaiPhong.setBounds(484, 160, 222, 36);
		panel_InputTimKiemPhong.add(comboBoxTimPhongLoaiPhong);
		
		comboBoxTimPhongTrangThai = new JComboBox();
		comboBoxTimPhongTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxTimPhongTrangThai.setBounds(484, 209, 222, 36);
		panel_InputTimKiemPhong.add(comboBoxTimPhongTrangThai);
		
		comboBoxTimPhongMaPhong = new JComboBox();
		comboBoxTimPhongMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxTimPhongMaPhong.setBounds(484, 64, 222, 36);
		panel_InputTimKiemPhong.add(comboBoxTimPhongMaPhong);
		
		comboBoxTimPhongTenPhong = new JComboBox();
		comboBoxTimPhongTenPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxTimPhongTenPhong.setBounds(484, 111, 222, 36);
		panel_InputTimKiemPhong.add(comboBoxTimPhongTenPhong);
		
		JPanel panel_OutputTimKiemPhong = new JPanel();
		panel_OutputTimKiemPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputTimKiemPhong.setBounds(10, 298, 1140, 284);
		panel_InputOutputTimKiemPhong.add(panel_OutputTimKiemPhong);
		panel_OutputTimKiemPhong.setLayout(null);
		
		JLabel lblDanhSachPhongCanTim = new JLabel("Danh Sách Phòng Cần Tìm :");
		lblDanhSachPhongCanTim.setBounds(10, 11, 295, 27);
		lblDanhSachPhongCanTim.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_OutputTimKiemPhong.add(lblDanhSachPhongCanTim);
		
		JPanel panel_OutputList = new JPanel();
		panel_OutputList.setBounds(10, 38, 1120, 235);
		panel_OutputTimKiemPhong.add(panel_OutputList);
		panel_OutputList.setLayout(null);
		
		table_OutputListTimKiemPhong = new JTable();
		table_OutputListTimKiemPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListTimKiemPhong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Phòng", "Tên Phòng", "Loại Phòng", "Trạng Thái", "Giá Phòng"
			}
		));
		
		JScrollPane scrollPane_OutputListTimKiemPhong = new JScrollPane(table_OutputListTimKiemPhong);
		scrollPane_OutputListTimKiemPhong.setBounds(0, 0, 1120, 235);
		panel_OutputList.add(scrollPane_OutputListTimKiemPhong);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình quản lý phòng
		JPanel Panel_QuanLyPhong = new JPanel();
		Panel_GiaoDienManHinhTong.add(Panel_QuanLyPhong, "manHinhQuanLyPhong");
		Panel_QuanLyPhong.setLayout(null);
		
		JPanel panel_TitleQuanLyPhong = new JPanel();
		panel_TitleQuanLyPhong.setLayout(null);
		panel_TitleQuanLyPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleQuanLyPhong.setBackground(new Color(0, 191, 255));
		panel_TitleQuanLyPhong.setBounds(10, 11, 1160, 64);
		Panel_QuanLyPhong.add(panel_TitleQuanLyPhong);
		
		JLabel lblTitleQuanLyPhong = new JLabel("Quản Lý Phòng");
		lblTitleQuanLyPhong.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblTitleQuanLyPhong.setBounds(399, 11, 340, 53);
		panel_TitleQuanLyPhong.add(lblTitleQuanLyPhong);
		
		JPanel panel_InputOutputQuanLyPhong = new JPanel();
		panel_InputOutputQuanLyPhong.setLayout(null);
		panel_InputOutputQuanLyPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQuanLyPhong.setBackground(new Color(0, 191, 255));
		panel_InputOutputQuanLyPhong.setBounds(10, 86, 1160, 593);
		Panel_QuanLyPhong.add(panel_InputOutputQuanLyPhong);
		
		JPanel panel_InputQuanLyPhong = new JPanel();
		panel_InputQuanLyPhong.setLayout(null);
		panel_InputQuanLyPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQuanLyPhong.setBounds(10, 11, 1140, 276);
		panel_InputOutputQuanLyPhong.add(panel_InputQuanLyPhong);
		
		JLabel lblNhapThongTinQuanLyPhong = new JLabel("Nhập Thông Tin Phòng Cần Quản Lý :");
		lblNhapThongTinQuanLyPhong.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinQuanLyPhong.setBounds(10, 11, 412, 27);
		panel_InputQuanLyPhong.add(lblNhapThongTinQuanLyPhong);
		
		JLabel lblMaPhongQuanLyPhong = new JLabel("Mã Phòng");
		lblMaPhongQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaPhongQuanLyPhong.setBounds(126, 60, 80, 27);
		panel_InputQuanLyPhong.add(lblMaPhongQuanLyPhong);
		
		JLabel lblTenPhongQuanLyPhong = new JLabel("Tên Phòng");
		lblTenPhongQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenPhongQuanLyPhong.setBounds(126, 134, 80, 27);
		panel_InputQuanLyPhong.add(lblTenPhongQuanLyPhong);
		
		JLabel lblLoaiPhongQuanLyPhong = new JLabel("Loại Phòng");
		lblLoaiPhongQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoaiPhongQuanLyPhong.setBounds(552, 60, 89, 27);
		panel_InputQuanLyPhong.add(lblLoaiPhongQuanLyPhong);
		
		textQLPhongMaPhong = new JTextField();
		textQLPhongMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textQLPhongMaPhong.setColumns(10);
		textQLPhongMaPhong.setBounds(216, 58, 222, 38);
		panel_InputQuanLyPhong.add(textQLPhongMaPhong);
		
		textQLPhongTenPhong = new JTextField();
		textQLPhongTenPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textQLPhongTenPhong.setColumns(10);
		textQLPhongTenPhong.setBounds(216, 130, 222, 38);
		panel_InputQuanLyPhong.add(textQLPhongTenPhong);
		
		btnQLPhongThem = new JButton("Thêm");
		btnQLPhongThem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnQLPhongThem.setBackground(Color.LIGHT_GRAY);
		btnQLPhongThem.setBounds(149, 204, 122, 38);
		btnQLPhongThem.addActionListener(action_Main);
		panel_InputQuanLyPhong.add(btnQLPhongThem);
		
		comboBoxQLPhongLoaiPhong = new JComboBox();
		comboBoxQLPhongLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxQLPhongLoaiPhong.setBounds(651, 59, 222, 36);
		panel_InputQuanLyPhong.add(comboBoxQLPhongLoaiPhong);
		
		btnQLPhongXoa = new JButton("Xóa");
		btnQLPhongXoa.addActionListener(action_Main);

		btnQLPhongXoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnQLPhongXoa.setBackground(Color.LIGHT_GRAY);
		btnQLPhongXoa.setBounds(414, 204, 122, 38);
		panel_InputQuanLyPhong.add(btnQLPhongXoa);
		
		btnQLPhongSua = new JButton("Sửa");
		btnQLPhongSua.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnQLPhongSua.setBackground(Color.LIGHT_GRAY);
		btnQLPhongSua.setBounds(666, 204, 122, 38);
		btnQLPhongSua.addActionListener(action_Main);
		panel_InputQuanLyPhong.add(btnQLPhongSua);
		
		btnQLPhongXoaTrang = new JButton("Xóa Trắng");
		btnQLPhongXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnQLPhongXoaTrang.setBackground(Color.LIGHT_GRAY);
		btnQLPhongXoaTrang.setBounds(894, 204, 122, 38);
		btnQLPhongXoaTrang.addActionListener(action_Main);
		panel_InputQuanLyPhong.add(btnQLPhongXoaTrang);
		
		JPanel panel_OutPutQuanLyPhong = new JPanel();
		panel_OutPutQuanLyPhong.setLayout(null);
		panel_OutPutQuanLyPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutPutQuanLyPhong.setBounds(10, 298, 1140, 284);
		panel_InputOutputQuanLyPhong.add(panel_OutPutQuanLyPhong);
		
		JLabel lblDanhSachCacPhong = new JLabel("Danh Sách Các Phòng :");
		lblDanhSachCacPhong.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachCacPhong.setBounds(10, 11, 248, 27);
		panel_OutPutQuanLyPhong.add(lblDanhSachCacPhong);
		
		JPanel panel_OutputListQuanLyPhong = new JPanel();
		panel_OutputListQuanLyPhong.setLayout(null);
		panel_OutputListQuanLyPhong.setBounds(10, 38, 1120, 235);
		panel_OutPutQuanLyPhong.add(panel_OutputListQuanLyPhong);
		
		table_OutputListQuanLyPhong = new JTable();
		table_OutputListQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListQuanLyPhong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Phòng", "Tên Phòng", "Loại Phòng", "Trạng Thái", "Giá Phòng"
			}
		));
		table_OutputListQuanLyPhong.addMouseListener(Main_mouse_action);
		
		JScrollPane scrollPane_OutputListQuanLyPhong = new JScrollPane(table_OutputListQuanLyPhong);
		scrollPane_OutputListQuanLyPhong.setBounds(0, 0, 1120, 235);
		panel_OutputListQuanLyPhong.add(scrollPane_OutputListQuanLyPhong);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình tìm kiếm khách hàng
		JPanel Panel_TimKiemKhachHang = new JPanel();
		Panel_GiaoDienManHinhTong.add(Panel_TimKiemKhachHang, "manHinhTimKiemKhachHang");
		Panel_TimKiemKhachHang.setLayout(null);
		
		JPanel panel_Title_TimKiemKhachHang = new JPanel();
		panel_Title_TimKiemKhachHang.setLayout(null);
		panel_Title_TimKiemKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_TimKiemKhachHang.setBackground(new Color(0, 191, 255));
		panel_Title_TimKiemKhachHang.setBounds(10, 11, 1160, 64);
		Panel_TimKiemKhachHang.add(panel_Title_TimKiemKhachHang);
		
		JLabel lblTimKiemKhachHang = new JLabel("Tìm Kiếm Khách Hàng");
		lblTimKiemKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblTimKiemKhachHang.setBounds(319, 11, 515, 53);
		panel_Title_TimKiemKhachHang.add(lblTimKiemKhachHang);
		
		JPanel panel_InputOutputTimKiemKhachHang = new JPanel();
		panel_InputOutputTimKiemKhachHang.setLayout(null);
		panel_InputOutputTimKiemKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputTimKiemKhachHang.setBackground(new Color(0, 191, 255));
		panel_InputOutputTimKiemKhachHang.setBounds(10, 86, 1160, 593);
		Panel_TimKiemKhachHang.add(panel_InputOutputTimKiemKhachHang);
		
		JPanel panel_InputTimKiemKhachHang = new JPanel();
		panel_InputTimKiemKhachHang.setLayout(null);
		panel_InputTimKiemKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputTimKiemKhachHang.setBounds(10, 11, 1140, 276);
		panel_InputOutputTimKiemKhachHang.add(panel_InputTimKiemKhachHang);
		
		JLabel lblNhapThongTinKhachHangTimKiem = new JLabel("Nhập Thông Tin Khách Hàng Cần Tìm :");
		lblNhapThongTinKhachHangTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinKhachHangTimKiem.setBounds(10, 11, 418, 27);
		panel_InputTimKiemKhachHang.add(lblNhapThongTinKhachHangTimKiem);
		
		JLabel lblMaKhachHangTimKiemKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHangTimKiemKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaKhachHangTimKiemKhachHang.setBounds(333, 62, 127, 27);
		panel_InputTimKiemKhachHang.add(lblMaKhachHangTimKiemKhachHang);
		
		JLabel lblHoTenTimKiemKhachHang = new JLabel("Họ Tên");
		lblHoTenTimKiemKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHoTenTimKiemKhachHang.setBounds(401, 109, 59, 27);
		panel_InputTimKiemKhachHang.add(lblHoTenTimKiemKhachHang);
		
		JLabel lblSoDienThoaiTimKiemKhachHang = new JLabel("Số Điện Thoại");
		lblSoDienThoaiTimKiemKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoaiTimKiemKhachHang.setBounds(345, 207, 115, 27);
		panel_InputTimKiemKhachHang.add(lblSoDienThoaiTimKiemKhachHang);
		
		JLabel lblDiaChiTimKiemKhachHang = new JLabel("Địa Chỉ");
		lblDiaChiTimKiemKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChiTimKiemKhachHang.setBounds(398, 162, 62, 27);
		panel_InputTimKiemKhachHang.add(lblDiaChiTimKiemKhachHang);
		
		textMaKhachHangTimKiemKH = new JTextField();
		textMaKhachHangTimKiemKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaKhachHangTimKiemKH.setColumns(10);
		textMaKhachHangTimKiemKH.setBounds(470, 58, 222, 38);
		panel_InputTimKiemKhachHang.add(textMaKhachHangTimKiemKH);
		
		textHoTenTimKiemKH = new JTextField();
		textHoTenTimKiemKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textHoTenTimKiemKH.setColumns(10);
		textHoTenTimKiemKH.setBounds(470, 105, 222, 38);
		panel_InputTimKiemKhachHang.add(textHoTenTimKiemKH);
		
		textSDTTimKiemKH = new JTextField();
		textSDTTimKiemKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textSDTTimKiemKH.setColumns(10);
		textSDTTimKiemKH.setBounds(470, 203, 222, 38);
		panel_InputTimKiemKhachHang.add(textSDTTimKiemKH);
		
		chckbxTimKHMaKhachHang = new JCheckBox("");
		chckbxTimKHMaKhachHang.setBounds(713, 66, 21, 23);
		panel_InputTimKiemKhachHang.add(chckbxTimKHMaKhachHang);
		
		chckbxTimKHHoTenKH = new JCheckBox("");
		chckbxTimKHHoTenKH.setBounds(713, 113, 21, 23);
		panel_InputTimKiemKhachHang.add(chckbxTimKHHoTenKH);
		
		chckbxTimKHDiaChiKH = new JCheckBox("");
		chckbxTimKHDiaChiKH.setBounds(713, 162, 21, 23);
		panel_InputTimKiemKhachHang.add(chckbxTimKHDiaChiKH);
		
		chckbxTimKHSDTKhachHang = new JCheckBox("");
		chckbxTimKHSDTKhachHang.setBounds(713, 211, 21, 23);
		panel_InputTimKiemKhachHang.add(chckbxTimKHSDTKhachHang);
		
		btnTimKHTimKiemKH = new JButton("Tìm Kiếm");
		btnTimKHTimKiemKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKHTimKiemKH.setBackground(Color.LIGHT_GRAY);
		btnTimKHTimKiemKH.setBounds(818, 196, 122, 38);
		btnTimKHTimKiemKH.addActionListener(action_Main);//dasua
		panel_InputTimKiemKhachHang.add(btnTimKHTimKiemKH);
		
		textDiaChiTimKiemKH = new JTextField();
		textDiaChiTimKiemKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textDiaChiTimKiemKH.setColumns(10);
		textDiaChiTimKiemKH.setBounds(470, 154, 222, 38);
		panel_InputTimKiemKhachHang.add(textDiaChiTimKiemKH);
		
		JPanel panel_OutputTimKiemKhachHang = new JPanel();
		panel_OutputTimKiemKhachHang.setLayout(null);
		panel_OutputTimKiemKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputTimKiemKhachHang.setBounds(10, 298, 1140, 284);
		panel_InputOutputTimKiemKhachHang.add(panel_OutputTimKiemKhachHang);
		
		JLabel lblDanhSachKHTim = new JLabel("Danh Sách Khách Hàng Cần Tìm :");
		lblDanhSachKHTim.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachKHTim.setBounds(10, 11, 366, 27);
		panel_OutputTimKiemKhachHang.add(lblDanhSachKHTim);
		
		JPanel panel_OutputListTKKhachHang = new JPanel();
		panel_OutputListTKKhachHang.setLayout(null);
		panel_OutputListTKKhachHang.setBounds(10, 38, 1120, 235);
		panel_OutputTimKiemKhachHang.add(panel_OutputListTKKhachHang);
		
		table_OutPutTKkhachHang = new JTable();
		table_OutPutTKkhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutPutTKkhachHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Khách Hàng", "Họ Tên", "Địa Chỉ", "Số Điện Thoại"
			}
		));
		
		JScrollPane scrollPane_OutPutTKKhachHang = new JScrollPane(table_OutPutTKkhachHang);
		scrollPane_OutPutTKKhachHang.setBounds(0, 0, 1120, 235);
		panel_OutputListTKKhachHang.add(scrollPane_OutPutTKKhachHang);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình quản lý khách hàng
		JPanel Panel_QuanLyKhachHang = new JPanel();
		Panel_GiaoDienManHinhTong.add(Panel_QuanLyKhachHang, "manHinhQuanLyKhachHang");
		Panel_QuanLyKhachHang.setLayout(null);
		
		JPanel panel_TitleQuanLyKhachHang = new JPanel();
		panel_TitleQuanLyKhachHang.setLayout(null);
		panel_TitleQuanLyKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleQuanLyKhachHang.setBackground(new Color(0, 191, 255));
		panel_TitleQuanLyKhachHang.setBounds(10, 11, 1160, 64);
		Panel_QuanLyKhachHang.add(panel_TitleQuanLyKhachHang);
		
		JLabel lblQuanLyKhachHang = new JLabel("Quản Lý Khách Hàng");
		lblQuanLyKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblQuanLyKhachHang.setBounds(328, 11, 477, 53);
		panel_TitleQuanLyKhachHang.add(lblQuanLyKhachHang);
		
		JPanel panel_InputOutputQuanLyKhachHang = new JPanel();
		panel_InputOutputQuanLyKhachHang.setLayout(null);
		panel_InputOutputQuanLyKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQuanLyKhachHang.setBackground(new Color(0, 191, 255));
		panel_InputOutputQuanLyKhachHang.setBounds(10, 86, 1160, 593);
		Panel_QuanLyKhachHang.add(panel_InputOutputQuanLyKhachHang);
		
		JPanel panel_InputQuanLyKhachHang = new JPanel();
		panel_InputQuanLyKhachHang.setLayout(null);
		panel_InputQuanLyKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQuanLyKhachHang.setBounds(10, 11, 1140, 276);
		panel_InputOutputQuanLyKhachHang.add(panel_InputQuanLyKhachHang);
		
		JLabel lblNhapThongTinKhachHang = new JLabel("Nhập Thông Tin Khách Hàng :");
		lblNhapThongTinKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinKhachHang.setBounds(10, 11, 326, 27);
		panel_InputQuanLyKhachHang.add(lblNhapThongTinKhachHang);
		
		JLabel lblMaKhachHangQLKH = new JLabel("Mã Khách Hàng");
		lblMaKhachHangQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaKhachHangQLKH.setBounds(182, 76, 127, 27);
		panel_InputQuanLyKhachHang.add(lblMaKhachHangQLKH);
		
		JLabel lblHoTenQLKH = new JLabel("Họ Tên");
		lblHoTenQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHoTenQLKH.setBounds(250, 138, 59, 27);
		panel_InputQuanLyKhachHang.add(lblHoTenQLKH);
		
		JLabel lblSDTQLKH = new JLabel("Số Điện Thoại");
		lblSDTQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSDTQLKH.setBounds(617, 140, 115, 27);
		panel_InputQuanLyKhachHang.add(lblSDTQLKH);
		
		JLabel lblDiaChiQLKH = new JLabel("Địa Chỉ");
		lblDiaChiQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChiQLKH.setBounds(670, 78, 62, 27);
		panel_InputQuanLyKhachHang.add(lblDiaChiQLKH);
		
		textMaKhachHangQLKH = new JTextField();
		textMaKhachHangQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaKhachHangQLKH.setColumns(10);
		textMaKhachHangQLKH.setBounds(319, 74, 222, 38);
		textMaKhachHangQLKH.addMouseListener(Main_mouse_action);
		panel_InputQuanLyKhachHang.add(textMaKhachHangQLKH);
		
		textHoTenQLKH = new JTextField();
		textHoTenQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textHoTenQLKH.setColumns(10);
		textHoTenQLKH.setBounds(319, 136, 222, 38);
		panel_InputQuanLyKhachHang.add(textHoTenQLKH);
		
		textSDTQLKH = new JTextField();
		textSDTQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textSDTQLKH.setColumns(10);
		textSDTQLKH.setBounds(742, 138, 222, 38);
		panel_InputQuanLyKhachHang.add(textSDTQLKH);
		
		btnThemQLKH = new JButton("Thêm");
		btnThemQLKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemQLKH.setBackground(Color.LIGHT_GRAY);
		btnThemQLKH.setBounds(189, 206, 122, 38);
		btnThemQLKH.addActionListener(action_Main);
		panel_InputQuanLyKhachHang.add(btnThemQLKH);
		
		textDiaChiQLKH = new JTextField();
		textDiaChiQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textDiaChiQLKH.setColumns(10);
		textDiaChiQLKH.setBounds(742, 76, 222, 38);
		panel_InputQuanLyKhachHang.add(textDiaChiQLKH);
		
		btnXoaQLKH = new JButton("Xóa");
		btnXoaQLKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaQLKH.setBackground(Color.LIGHT_GRAY);
		btnXoaQLKH.setBounds(413, 206, 122, 38);
		btnXoaQLKH.addActionListener(action_Main);
		panel_InputQuanLyKhachHang.add(btnXoaQLKH);
		
		btnSuaQLKH = new JButton("Sửa");
		btnSuaQLKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaQLKH.setBackground(Color.LIGHT_GRAY);
		btnSuaQLKH.setBounds(636, 206, 122, 38);
		panel_InputQuanLyKhachHang.add(btnSuaQLKH);
		
		btnXoaTrangQLKH = new JButton("Xóa Trắng");
		btnXoaTrangQLKH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangQLKH.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangQLKH.setBounds(876, 206, 122, 38);
		panel_InputQuanLyKhachHang.add(btnXoaTrangQLKH);
		btnXoaTrangQLKH.addActionListener(action_Main);
		btnSuaQLKH.addActionListener(action_Main);
		
		JPanel panel_OutputQLKH = new JPanel();
		panel_OutputQLKH.setLayout(null);
		panel_OutputQLKH.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputQLKH.setBounds(10, 298, 1140, 284);
		panel_InputOutputQuanLyKhachHang.add(panel_OutputQLKH);
		
		JLabel lblDanhSachKHOutPut = new JLabel("Danh Sách Khách Hàng:");
		lblDanhSachKHOutPut.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachKHOutPut.setBounds(10, 11, 259, 27);
		panel_OutputQLKH.add(lblDanhSachKHOutPut);
		
		JPanel panel_OutputListQLKH = new JPanel();
		panel_OutputListQLKH.setLayout(null);
		panel_OutputListQLKH.setBounds(10, 38, 1120, 235);
		panel_OutputQLKH.add(panel_OutputListQLKH);
		
		table_OutPutQLKH = new JTable();
		table_OutPutQLKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutPutQLKH.addMouseListener(Main_mouse_action);
		table_OutPutQLKH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Khách Hàng", "Họ Tên", "Địa Chỉ", "Số Điện Thoại"
			}
		));
		
		JScrollPane scrollPane_OutPutQLKH = new JScrollPane(table_OutPutQLKH);
		scrollPane_OutPutQLKH.setBounds(0, 0, 1120, 235);
		panel_OutputListQLKH.add(scrollPane_OutPutQLKH);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình quản lý nhân viên
		JPanel Panel_QuanLyNhanVien = new JPanel();
		Panel_GiaoDienManHinhTong.add(Panel_QuanLyNhanVien, "manHinhQuanLyNhanVien");
		Panel_QuanLyNhanVien.setLayout(null);
		
		JPanel panel_Title_QuanLyNhanVien = new JPanel();
		panel_Title_QuanLyNhanVien.setLayout(null);
		panel_Title_QuanLyNhanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_QuanLyNhanVien.setBackground(new Color(0, 191, 255));
		panel_Title_QuanLyNhanVien.setBounds(10, 11, 1160, 64);
		Panel_QuanLyNhanVien.add(panel_Title_QuanLyNhanVien);
		
		JLabel lblTitleQuanLyNhanVien = new JLabel("Quản Lý Nhân Viên");
		lblTitleQuanLyNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblTitleQuanLyNhanVien.setBounds(340, 11, 434, 53);
		panel_Title_QuanLyNhanVien.add(lblTitleQuanLyNhanVien);
		
		JPanel panel_InputOutputQLNV = new JPanel();
		panel_InputOutputQLNV.setLayout(null);
		panel_InputOutputQLNV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQLNV.setBackground(new Color(0, 191, 255));
		panel_InputOutputQLNV.setBounds(10, 86, 1160, 593);
		Panel_QuanLyNhanVien.add(panel_InputOutputQLNV);
		
		JPanel panel_InputQuanLyNhanVien = new JPanel();
		panel_InputQuanLyNhanVien.setLayout(null);
		panel_InputQuanLyNhanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQuanLyNhanVien.setBounds(10, 11, 1140, 276);
		panel_InputOutputQLNV.add(panel_InputQuanLyNhanVien);
		
		JLabel lblNhapThongTinNhanVienQLNV = new JLabel("Nhập Thông Tin Nhân Viên :");
		lblNhapThongTinNhanVienQLNV.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinNhanVienQLNV.setBounds(10, 11, 303, 27);
		panel_InputQuanLyNhanVien.add(lblNhapThongTinNhanVienQLNV);
		
		JLabel lblMaNhanVienQLNV = new JLabel("Mã Nhân Viên");
		lblMaNhanVienQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaNhanVienQLNV.setBounds(66, 49, 114, 27);
		panel_InputQuanLyNhanVien.add(lblMaNhanVienQLNV);
		
		JLabel lblHoTenQLNV = new JLabel("Họ Tên");
		lblHoTenQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHoTenQLNV.setBounds(121, 102, 59, 27);
		panel_InputQuanLyNhanVien.add(lblHoTenQLNV);
		
		JLabel lblSDTQLNV = new JLabel("Số Điện Thoại");
		lblSDTQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSDTQLNV.setBounds(66, 197, 114, 27);
		panel_InputQuanLyNhanVien.add(lblSDTQLNV);
		
		JLabel lblGioiTinhQLNV = new JLabel("Giới Tính");
		lblGioiTinhQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinhQLNV.setBounds(102, 148, 78, 27);
		panel_InputQuanLyNhanVien.add(lblGioiTinhQLNV);
		
		textMaNhanVienQLNV = new JTextField();
		textMaNhanVienQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaNhanVienQLNV.setColumns(10);
		textMaNhanVienQLNV.setBounds(190, 49, 222, 38);
		panel_InputQuanLyNhanVien.add(textMaNhanVienQLNV);
		
		textHoTenQLNV = new JTextField();
		textHoTenQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textHoTenQLNV.setColumns(10);
		textHoTenQLNV.setBounds(190, 98, 222, 38);
		panel_InputQuanLyNhanVien.add(textHoTenQLNV);
		
		textSDTQLNV = new JTextField();
		textSDTQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textSDTQLNV.setColumns(10);
		textSDTQLNV.setBounds(190, 193, 222, 38);
		panel_InputQuanLyNhanVien.add(textSDTQLNV);
		
		btnThemQLNV = new JButton("Thêm");
		btnThemQLNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemQLNV.setBackground(Color.LIGHT_GRAY);
		btnThemQLNV.setBounds(953, 49, 122, 38);
		btnThemQLNV.addActionListener(action_Main);
		panel_InputQuanLyNhanVien.add(btnThemQLNV);
		
		btnXoaQLNV = new JButton("Xóa");
		btnXoaQLNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaQLNV.setBackground(Color.LIGHT_GRAY);
		btnXoaQLNV.setBounds(953, 96, 122, 38);
		btnXoaQLNV.addActionListener(action_Main);
		panel_InputQuanLyNhanVien.add(btnXoaQLNV);
		
		btnSuaQLNV = new JButton("Sửa");
		btnSuaQLNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaQLNV.setBackground(Color.LIGHT_GRAY);
		btnSuaQLNV.setBounds(953, 143, 122, 38);
		btnSuaQLNV.addActionListener(action_Main);
		panel_InputQuanLyNhanVien.add(btnSuaQLNV);
		
		JLabel lblNgayVaoLamQLNV = new JLabel("Ngày Vào Làm");
		lblNgayVaoLamQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgayVaoLamQLNV.setBounds(454, 102, 122, 27);
		panel_InputQuanLyNhanVien.add(lblNgayVaoLamQLNV);
		
		JLabel lblDiaChiQLNV = new JLabel("Địa Chỉ");
		lblDiaChiQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChiQLNV.setBounds(514, 53, 62, 27);
		panel_InputQuanLyNhanVien.add(lblDiaChiQLNV);
		
		textDiaChiQLNV = new JTextField();
		textDiaChiQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textDiaChiQLNV.setColumns(10);
		textDiaChiQLNV.setBounds(587, 50, 222, 38);
		panel_InputQuanLyNhanVien.add(textDiaChiQLNV);
		
		JLabel lblChucVuQLNV = new JLabel("Chức Vụ");
		lblChucVuQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChucVuQLNV.setBounds(507, 148, 69, 27);
		panel_InputQuanLyNhanVien.add(lblChucVuQLNV);
		
		comboBoxGioiTinhQLNV = new JComboBox();
		comboBoxGioiTinhQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxGioiTinhQLNV.setBounds(190, 147, 222, 35);
		comboBoxGioiTinhQLNV.addActionListener(action_Main);
		panel_InputQuanLyNhanVien.add(comboBoxGioiTinhQLNV);
		
		btnXoaTrangQLNV = new JButton("Xóa Trắng");
		btnXoaTrangQLNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangQLNV.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangQLNV.setBounds(953, 191, 122, 38);
		btnXoaTrangQLNV.addActionListener(action_Main);
		panel_InputQuanLyNhanVien.add(btnXoaTrangQLNV);
		
		comboBoxChucVuQLNV = new JComboBox();
		comboBoxChucVuQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxChucVuQLNV.setBounds(587, 147, 222, 35);
		comboBoxChucVuQLNV.addActionListener(action_Main);
		panel_InputQuanLyNhanVien.add(comboBoxChucVuQLNV);
		
		dateChooserNgayVaoLamQLNV = new JDateChooser();
		dateChooserNgayVaoLamQLNV.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayVaoLamQLNV.setBounds(587, 100, 222, 36);
		panel_InputQuanLyNhanVien.add(dateChooserNgayVaoLamQLNV);
		
		JPanel panel_Output_QLNV = new JPanel();
		panel_Output_QLNV.setLayout(null);
		panel_Output_QLNV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Output_QLNV.setBounds(10, 298, 1140, 284);
		panel_InputOutputQLNV.add(panel_Output_QLNV);
		
		JLabel lblDanhSachNhanVienQLNV = new JLabel("Danh Sách Nhân Viên:");
		lblDanhSachNhanVienQLNV.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachNhanVienQLNV.setBounds(10, 11, 238, 27);
		panel_Output_QLNV.add(lblDanhSachNhanVienQLNV);
		
		JPanel panel_OutputListQLNV = new JPanel();
		panel_OutputListQLNV.setLayout(null);
		panel_OutputListQLNV.setBounds(10, 38, 1120, 235);
		panel_Output_QLNV.add(panel_OutputListQLNV);
		
		table_OutputListQLNV = new JTable();
		table_OutputListQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListQLNV.addMouseListener(Main_mouse_action);
		table_OutputListQLNV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Nhân Viên", "Họ Tên", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Ngày Vào Làm", "Chức Vụ"
			}
		));
		
		JScrollPane scrollPane_OutputListQLNV = new JScrollPane(table_OutputListQLNV);
		scrollPane_OutputListQLNV.setBounds(0, 0, 1120, 235);
		panel_OutputListQLNV.add(scrollPane_OutputListQLNV);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình tìm kiếm nhân viên
		JPanel Panel_TimKiemNhanVien = new JPanel();
		Panel_GiaoDienManHinhTong.add(Panel_TimKiemNhanVien, "manHinhTimKiemNhanVien");
		Panel_TimKiemNhanVien.setLayout(null);
		
		JPanel panel_TitleTKNV = new JPanel();
		panel_TitleTKNV.setLayout(null);
		panel_TitleTKNV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleTKNV.setBackground(new Color(0, 191, 255));
		panel_TitleTKNV.setBounds(10, 11, 1160, 64);
		Panel_TimKiemNhanVien.add(panel_TitleTKNV);
		
		JLabel lbl_TitleRKNV = new JLabel("Tìm Kiếm Nhân Viên");
		lbl_TitleRKNV.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleRKNV.setBounds(348, 11, 461, 53);
		panel_TitleTKNV.add(lbl_TitleRKNV);
		
		JPanel panel_InputOutputTKNV = new JPanel();
		panel_InputOutputTKNV.setLayout(null);
		panel_InputOutputTKNV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputTKNV.setBackground(new Color(0, 191, 255));
		panel_InputOutputTKNV.setBounds(10, 86, 1160, 593);
		Panel_TimKiemNhanVien.add(panel_InputOutputTKNV);
		
		JPanel panel_InputTKNV = new JPanel();
		panel_InputTKNV.setLayout(null);
		panel_InputTKNV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputTKNV.setBounds(10, 11, 1140, 276);
		panel_InputOutputTKNV.add(panel_InputTKNV);
		
		JLabel lblNhapThongTinTimKiemNhanVien = new JLabel("Nhập Thông Tin Nhân Viên Tìm Kiếm :");
		lblNhapThongTinTimKiemNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinTimKiemNhanVien.setBounds(10, 11, 402, 27);
		panel_InputTKNV.add(lblNhapThongTinTimKiemNhanVien);
		
		JLabel lblMaNhanVienTKNV = new JLabel("Mã Nhân Viên");
		lblMaNhanVienTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaNhanVienTKNV.setBounds(54, 62, 114, 27);
		panel_InputTKNV.add(lblMaNhanVienTKNV);
		
		JLabel lblHoTenTKNV = new JLabel("Họ Tên");
		lblHoTenTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHoTenTKNV.setBounds(109, 129, 59, 27);
		panel_InputTKNV.add(lblHoTenTKNV);
		
		JLabel lblGioiTinhTKNV = new JLabel("Giới Tính");
		lblGioiTinhTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinhTKNV.setBounds(87, 191, 78, 27);
		panel_InputTKNV.add(lblGioiTinhTKNV);
		
		textMaNhanVienTKNV = new JTextField();
		textMaNhanVienTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaNhanVienTKNV.setColumns(10);
		textMaNhanVienTKNV.setBounds(190, 60, 222, 38);
		panel_InputTKNV.add(textMaNhanVienTKNV);
		
		textHoTenTKNV = new JTextField();
		textHoTenTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textHoTenTKNV.setColumns(10);
		textHoTenTKNV.setBounds(190, 127, 222, 38);
		panel_InputTKNV.add(textHoTenTKNV);
		
		JLabel lblNgayVaoLamTKNV = new JLabel("Ngày Vào Làm");
		lblNgayVaoLamTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgayVaoLamTKNV.setBounds(537, 62, 122, 27);
		panel_InputTKNV.add(lblNgayVaoLamTKNV);
		
		JLabel lblChucVuTKNV = new JLabel("Chức Vụ");
		lblChucVuTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChucVuTKNV.setBounds(590, 129, 69, 27);
		panel_InputTKNV.add(lblChucVuTKNV);
		
		comboBox_GioiTinhTKNV = new JComboBox();
		comboBox_GioiTinhTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioiTinhTKNV.setBounds(190, 191, 222, 35);
		comboBox_GioiTinhTKNV.addActionListener(action_Main);
		panel_InputTKNV.add(comboBox_GioiTinhTKNV);
		
		btnTimKiemTKNV = new JButton("Tìm Kiếm");
		btnTimKiemTKNV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKiemTKNV.setBackground(Color.LIGHT_GRAY);
		btnTimKiemTKNV.setBounds(669, 187, 122, 38);
		btnTimKiemTKNV.addActionListener(action_Main);
		panel_InputTKNV.add(btnTimKiemTKNV);
		
		chckbxMaNhanVienTKNV = new JCheckBox("");
		chckbxMaNhanVienTKNV.setBounds(418, 68, 21, 23);
		panel_InputTKNV.add(chckbxMaNhanVienTKNV);
		
		chckbxHoTenTKNV = new JCheckBox("");
		chckbxHoTenTKNV.setBounds(418, 135, 21, 23);
		panel_InputTKNV.add(chckbxHoTenTKNV);
		
		chckbxGioiTinhTKNV = new JCheckBox("");
		chckbxGioiTinhTKNV.setBounds(418, 197, 21, 23);
		panel_InputTKNV.add(chckbxGioiTinhTKNV);
		
		chckbxNgayVaoLamTKNV = new JCheckBox("");
		chckbxNgayVaoLamTKNV.setBounds(897, 68, 21, 23);
		panel_InputTKNV.add(chckbxNgayVaoLamTKNV);
		
		chckbxChucVuTKNV = new JCheckBox("");
		chckbxChucVuTKNV.setBounds(897, 135, 21, 23);
		panel_InputTKNV.add(chckbxChucVuTKNV);
		
		comboBox_ChucVuTKNV = new JComboBox();
		comboBox_ChucVuTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_ChucVuTKNV.setBounds(669, 121, 222, 35);
		comboBox_ChucVuTKNV.addActionListener(action_Main);
		panel_InputTKNV.add(comboBox_ChucVuTKNV);
		
		dateChooser_NgayVaoLamTKNV = new JDateChooser();
		dateChooser_NgayVaoLamTKNV.setDateFormatString("yyyy-MM-dd");
		dateChooser_NgayVaoLamTKNV.setBounds(669, 62, 222, 36);
		
		panel_InputTKNV.add(dateChooser_NgayVaoLamTKNV);
		
		JPanel panel_OutputTKNV = new JPanel();
		panel_OutputTKNV.setLayout(null);
		panel_OutputTKNV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputTKNV.setBounds(10, 298, 1140, 284);
		panel_InputOutputTKNV.add(panel_OutputTKNV);
		
		JLabel lblDanhSachNhanVienTimKiem = new JLabel("Danh Sách Nhân Viên Tìm Kiếm :");
		lblDanhSachNhanVienTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachNhanVienTimKiem.setBounds(10, 11, 346, 27);
		panel_OutputTKNV.add(lblDanhSachNhanVienTimKiem);
		
		JPanel panel_OutputListTKNV = new JPanel();
		panel_OutputListTKNV.setLayout(null);
		panel_OutputListTKNV.setBounds(10, 38, 1120, 235);
		panel_OutputTKNV.add(panel_OutputListTKNV);
		
		table_OutputListTKNV = new JTable();
		table_OutputListTKNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListTKNV.addMouseListener(Main_mouse_action);
		table_OutputListTKNV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Nhân Viên", "Họ Tên", "Giới Tính","Địa Chỉ", "Ngày Vào Làm","Số Điện Thoại", "Chức Vụ"
			}
		));
		
		JScrollPane scrollPane_OutputListTKNV = new JScrollPane(table_OutputListTKNV);
		scrollPane_OutputListTKNV.setBounds(0, 0, 1120, 235);
		panel_OutputListTKNV.add(scrollPane_OutputListTKNV);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình quản lý dịch vụ
		JPanel Panel_QuanLyDichVu = new JPanel();
		Panel_QuanLyDichVu.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_QuanLyDichVu, "manHinhQuanLyDichVu");
		
		JPanel panel_TitleQLDV = new JPanel();
		panel_TitleQLDV.setLayout(null);
		panel_TitleQLDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleQLDV.setBackground(new Color(0, 191, 255));
		panel_TitleQLDV.setBounds(10, 11, 1160, 64);
		Panel_QuanLyDichVu.add(panel_TitleQLDV);
		
		JLabel lbl_TItleQLDV = new JLabel("Quản Lý Dịch Vụ");
		lbl_TItleQLDV.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TItleQLDV.setBounds(387, 11, 387, 53);
		panel_TitleQLDV.add(lbl_TItleQLDV);
		
		JPanel panel_InputOutputQLDV = new JPanel();
		panel_InputOutputQLDV.setLayout(null);
		panel_InputOutputQLDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQLDV.setBackground(new Color(0, 191, 255));
		panel_InputOutputQLDV.setBounds(10, 86, 1160, 593);
		Panel_QuanLyDichVu.add(panel_InputOutputQLDV);
		
		JPanel panel_InputQLDV = new JPanel();
		panel_InputQLDV.setLayout(null);
		panel_InputQLDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQLDV.setBounds(10, 11, 1140, 276);
		panel_InputOutputQLDV.add(panel_InputQLDV);
		
		JLabel lblNhapThongTinDVQL = new JLabel("Nhập Thông Tin Dịch Vụ Cần Quản Lý :");
		lblNhapThongTinDVQL.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinDVQL.setBounds(10, 11, 412, 27);
		panel_InputQLDV.add(lblNhapThongTinDVQL);
		
		JLabel lblMaDichVuQLDV = new JLabel("Mã Dịch Vụ");
		lblMaDichVuQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaDichVuQLDV.setBounds(110, 62, 96, 27);
		panel_InputQLDV.add(lblMaDichVuQLDV);
		
		JLabel lblTenDichVuQLDV = new JLabel("Tên Dịch Vụ");
		lblTenDichVuQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenDichVuQLDV.setBounds(106, 134, 100, 27);
		panel_InputQLDV.add(lblTenDichVuQLDV);
		
		JLabel lblGiaMuaQLDV = new JLabel("Giá Mua");
		lblGiaMuaQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGiaMuaQLDV.setBounds(561, 62, 69, 27);
		panel_InputQLDV.add(lblGiaMuaQLDV);
		
		textMaDichVuQLDV = new JTextField();
		textMaDichVuQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaDichVuQLDV.setColumns(10);
		textMaDichVuQLDV.setBounds(216, 58, 222, 38);
		panel_InputQLDV.add(textMaDichVuQLDV);
		
		textTenDichVuQLDV = new JTextField();
		textTenDichVuQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textTenDichVuQLDV.setColumns(10);
		textTenDichVuQLDV.setBounds(216, 130, 222, 38);
		panel_InputQLDV.add(textTenDichVuQLDV);
		
		textGiaMuaQLDV = new JTextField();
		textGiaMuaQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textGiaMuaQLDV.setColumns(10);
		textGiaMuaQLDV.setBounds(640, 60, 222, 38);
		panel_InputQLDV.add(textGiaMuaQLDV);
		
		btnThemQLDV = new JButton("Thêm");
		btnThemQLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemQLDV.setBackground(Color.LIGHT_GRAY);
		btnThemQLDV.setBounds(640, 128, 122, 38);
		btnThemQLDV.addActionListener(action_Main);
		panel_InputQLDV.add(btnThemQLDV);
		
		btnXoaQLDV = new JButton("Xóa");
		btnXoaQLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaQLDV.setBackground(Color.LIGHT_GRAY);
		btnXoaQLDV.setBounds(772, 129, 122, 38);
		btnXoaQLDV.addActionListener(action_Main);
		panel_InputQLDV.add(btnXoaQLDV);
		
		btnSuaQLDV = new JButton("Sửa");
		btnSuaQLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaQLDV.setBackground(Color.LIGHT_GRAY);
		btnSuaQLDV.setBounds(640, 200, 122, 38);
		btnSuaQLDV.addActionListener(action_Main);
		panel_InputQLDV.add(btnSuaQLDV);
		
		JLabel lblLoaiDichVuQLDV = new JLabel("Loại Dịch Vụ");
		lblLoaiDichVuQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoaiDichVuQLDV.setBounds(100, 205, 106, 27);
		panel_InputQLDV.add(lblLoaiDichVuQLDV);
		
		comboBoxLoaiDichVuQLDV = new JComboBox();
		comboBoxLoaiDichVuQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxLoaiDichVuQLDV.setBounds(216, 204, 222, 36);
		panel_InputQLDV.add(comboBoxLoaiDichVuQLDV);
		
		btnXoaTrangQLDV = new JButton("Xóa Trắng");
		btnXoaTrangQLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangQLDV.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangQLDV.setBounds(772, 200, 122, 38);
		btnXoaTrangQLDV.addActionListener(action_Main);
		panel_InputQLDV.add(btnXoaTrangQLDV);
		
		JPanel panel_OutputQLDV = new JPanel();
		panel_OutputQLDV.setLayout(null);
		panel_OutputQLDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputQLDV.setBounds(10, 298, 1140, 284);
		panel_InputOutputQLDV.add(panel_OutputQLDV);
		
		JLabel lblDanhSachDichVuQLDV = new JLabel("Danh Sách Các Dịch Vụ :");
		lblDanhSachDichVuQLDV.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachDichVuQLDV.setBounds(10, 11, 257, 27);
		panel_OutputQLDV.add(lblDanhSachDichVuQLDV);
		
		JPanel panel_OutputListQLDV = new JPanel();
		panel_OutputListQLDV.setLayout(null);
		panel_OutputListQLDV.setBounds(10, 38, 1120, 235);
		panel_OutputQLDV.add(panel_OutputListQLDV);
		
		table_OutputListQLDV = new JTable();
		table_OutputListQLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListQLDV.addMouseListener(Main_mouse_action);
		table_OutputListQLDV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Dịch Vụ", "Giá", "Loại Dịch Vụ"
			}
		));
		
		JScrollPane scrollPane_OutputListQLDV = new JScrollPane(table_OutputListQLDV);
		scrollPane_OutputListQLDV.setBounds(0, 0, 1120, 235);
		panel_OutputListQLDV.add(scrollPane_OutputListQLDV);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình tìm kiếm dịch vụ
		JPanel Panel_TimKiemDichVu = new JPanel();
		Panel_TimKiemDichVu.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_TimKiemDichVu, "manHinhTimKiemDichVu");
		
		JPanel panel_TitleTKDV = new JPanel();
		panel_TitleTKDV.setLayout(null);
		panel_TitleTKDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleTKDV.setBackground(new Color(0, 191, 255));
		panel_TitleTKDV.setBounds(10, 11, 1160, 64);
		Panel_TimKiemDichVu.add(panel_TitleTKDV);
		
		JLabel lblTitleTKDV = new JLabel("Tìm Kiếm Dịch Vụ");
		lblTitleTKDV.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblTitleTKDV.setBounds(373, 11, 408, 53);
		panel_TitleTKDV.add(lblTitleTKDV);
		
		JPanel panel_InputOutputTKDV = new JPanel();
		panel_InputOutputTKDV.setLayout(null);
		panel_InputOutputTKDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputTKDV.setBackground(new Color(0, 191, 255));
		panel_InputOutputTKDV.setBounds(10, 86, 1160, 593);
		Panel_TimKiemDichVu.add(panel_InputOutputTKDV);
		
		JPanel panel_InputTKDV = new JPanel();
		panel_InputTKDV.setLayout(null);
		panel_InputTKDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputTKDV.setBounds(10, 11, 1140, 276);
		panel_InputOutputTKDV.add(panel_InputTKDV);
		
		JLabel lblNhapThongTinTKDV = new JLabel("Nhập Thông Tin Dịch Vụ Cần Tìm Kiếm :");
		lblNhapThongTinTKDV.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinTKDV.setBounds(10, 11, 429, 27);
		panel_InputTKDV.add(lblNhapThongTinTKDV);
		
		textMaDichVuTKDV = new JTextField();
		textMaDichVuTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaDichVuTKDV.setColumns(10);
		textMaDichVuTKDV.setBounds(190, 60, 222, 38);
		panel_InputTKDV.add(textMaDichVuTKDV);
		
		textTenDichVuTKDV = new JTextField();
		textTenDichVuTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textTenDichVuTKDV.setColumns(10);
		textTenDichVuTKDV.setBounds(190, 127, 222, 38);
		panel_InputTKDV.add(textTenDichVuTKDV);
		
		textSoLuongTKDV = new JTextField();
		textSoLuongTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textSoLuongTKDV.setColumns(10);
		textSoLuongTKDV.setBounds(190, 191, 222, 38);
		panel_InputTKDV.add(textSoLuongTKDV);
		
		comboBox_LoaiDichVuTKDV = new JComboBox();
		comboBox_LoaiDichVuTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_LoaiDichVuTKDV.setBounds(669, 62, 222, 35);
		panel_InputTKDV.add(comboBox_LoaiDichVuTKDV);
		
		btnTimKiemTKDV = new JButton("Tìm Kiếm");
		btnTimKiemTKDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKiemTKDV.setBackground(Color.LIGHT_GRAY);
		btnTimKiemTKDV.setBounds(718, 135, 122, 38);
		btnTimKiemTKDV.addActionListener(action_Main);
		panel_InputTKDV.add(btnTimKiemTKDV);
		
		chckbxMaDichVuTKDV = new JCheckBox("");
		chckbxMaDichVuTKDV.setBounds(418, 68, 21, 23);
		panel_InputTKDV.add(chckbxMaDichVuTKDV);
		
		chckbxTenDichVuTKDV = new JCheckBox("");
		chckbxTenDichVuTKDV.setBounds(418, 135, 21, 23);
		panel_InputTKDV.add(chckbxTenDichVuTKDV);
		
		chckbxSoLuongTKDV = new JCheckBox("");
		chckbxSoLuongTKDV.setBounds(418, 197, 21, 23);
		panel_InputTKDV.add(chckbxSoLuongTKDV);
		
		chckbxLoaiDichVuTKDV = new JCheckBox("");
		chckbxLoaiDichVuTKDV.setBounds(897, 68, 21, 23);
		panel_InputTKDV.add(chckbxLoaiDichVuTKDV);
		
		JLabel lblMaDichVuTKDV = new JLabel("Mã Dịch Vụ");
		lblMaDichVuTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaDichVuTKDV.setBounds(84, 64, 96, 27);
		panel_InputTKDV.add(lblMaDichVuTKDV);
		
		JLabel lblTenDichVuTKDV = new JLabel("Tên Dịch Vụ");
		lblTenDichVuTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenDichVuTKDV.setBounds(80, 131, 100, 27);
		panel_InputTKDV.add(lblTenDichVuTKDV);
		
		JLabel lblSoLuongTKDV = new JLabel("Đơn vị tính");
		lblSoLuongTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoLuongTKDV.setBounds(91, 195, 89, 27);
		panel_InputTKDV.add(lblSoLuongTKDV);
		
		JLabel lblLoaiDichVuTKDV = new JLabel("Loại Dịch Vụ");
		lblLoaiDichVuTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoaiDichVuTKDV.setBounds(553, 64, 106, 27);
		panel_InputTKDV.add(lblLoaiDichVuTKDV);
		
		JPanel panel_OutputTKDV = new JPanel();
		panel_OutputTKDV.setLayout(null);
		panel_OutputTKDV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputTKDV.setBounds(10, 298, 1140, 284);
		panel_InputOutputTKDV.add(panel_OutputTKDV);
		
		JLabel lblDanhSachDichVuTK = new JLabel("Danh Sách Dịch Vụ Tìm Kiếm :");
		lblDanhSachDichVuTK.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachDichVuTK.setBounds(10, 11, 324, 27);
		panel_OutputTKDV.add(lblDanhSachDichVuTK);
		
		JPanel panel_OutputListTKDV = new JPanel();
		panel_OutputListTKDV.setLayout(null);
		panel_OutputListTKDV.setBounds(10, 38, 1120, 235);
		panel_OutputTKDV.add(panel_OutputListTKDV);
		
		table_OutputListTKDV = new JTable();
		table_OutputListTKDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListTKDV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Dịch Vụ", "Giá", "Loại Dịch Vụ"//dasua
			}
		));
		
		JScrollPane scrollPane_OutputListTKDV = new JScrollPane(table_OutputListTKDV);
		scrollPane_OutputListTKDV.setBounds(0, 0, 1120, 235);
		panel_OutputListTKDV.add(scrollPane_OutputListTKDV);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình quản lý tài khoản
		JPanel Panel_QuanLyTaiKoan = new JPanel();
		Panel_QuanLyTaiKoan.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_QuanLyTaiKoan, "manHinhQuanLyTaiKhoan");
		
		JPanel panel_Title_QLTK = new JPanel();
		panel_Title_QLTK.setLayout(null);
		panel_Title_QLTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_QLTK.setBackground(new Color(0, 191, 255));
		panel_Title_QLTK.setBounds(10, 11, 1160, 64);
		Panel_QuanLyTaiKoan.add(panel_Title_QLTK);
		
		JLabel lblTitleQLTK = new JLabel("Quản Lý Tài Khoản");
		lblTitleQLTK.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblTitleQLTK.setBounds(373, 11, 435, 53);
		panel_Title_QLTK.add(lblTitleQLTK);
		
		JPanel panel_InputOutputQLTK = new JPanel();
		panel_InputOutputQLTK.setLayout(null);
		panel_InputOutputQLTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQLTK.setBackground(new Color(0, 191, 255));
		panel_InputOutputQLTK.setBounds(10, 86, 1160, 593);
		Panel_QuanLyTaiKoan.add(panel_InputOutputQLTK);
		
		JPanel panel_InputQLTK = new JPanel();
		panel_InputQLTK.setLayout(null);
		panel_InputQLTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQLTK.setBounds(10, 11, 1140, 276);
		panel_InputOutputQLTK.add(panel_InputQLTK);
		
		JLabel lblNhapThongTinTaiKhoanQuanLy = new JLabel("Nhập Thông Tin Tài Khoản Cần Quản Lý :");
		lblNhapThongTinTaiKhoanQuanLy.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinTaiKhoanQuanLy.setBounds(10, 11, 444, 27);
		panel_InputQLTK.add(lblNhapThongTinTaiKhoanQuanLy);
		
		JLabel lblTenTaiKhoanQLTK = new JLabel("Tên Tài Khoản");
		lblTenTaiKhoanQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenTaiKhoanQLTK.setBounds(47, 53, 118, 27);
		panel_InputQLTK.add(lblTenTaiKhoanQLTK);
		
		JLabel lblNhapLaiMatKhauQLTK = new JLabel("Nhập Lại Mật Khẩu");
		lblNhapLaiMatKhauQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNhapLaiMatKhauQLTK.setBounds(10, 149, 155, 27);
		panel_InputQLTK.add(lblNhapLaiMatKhauQLTK);
		
		JLabel lblMatKhauQLTK = new JLabel("Mật Khảu");
		lblMatKhauQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMatKhauQLTK.setBounds(88, 102, 77, 27);
		panel_InputQLTK.add(lblMatKhauQLTK);
		
		textTenTaiKhoanQLTK = new JTextField();
		textTenTaiKhoanQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textTenTaiKhoanQLTK.setColumns(10);
		textTenTaiKhoanQLTK.setBounds(175, 49, 222, 38);
		panel_InputQLTK.add(textTenTaiKhoanQLTK);
		
		btnThemQLTK = new JButton("Thêm");
		btnThemQLTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThemQLTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemQLTK.setBackground(Color.LIGHT_GRAY);
		btnThemQLTK.setBounds(10, 231, 122, 38);
		btnThemQLTK.addActionListener(action_Main);
		panel_InputQLTK.add(btnThemQLTK);
		
		btnXoaQLTK = new JButton("Xóa");
		btnXoaQLTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaQLTK.setBackground(Color.LIGHT_GRAY);
		btnXoaQLTK.setBounds(153, 231, 122, 38);
		btnXoaQLTK.addActionListener(action_Main);
		panel_InputQLTK.add(btnXoaQLTK);
		
		btnSuaQLTK = new JButton("Sửa");
		btnSuaQLTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaQLTK.setBackground(Color.LIGHT_GRAY);
		btnSuaQLTK.setBounds(301, 231, 122, 38);
		btnSuaQLTK.addActionListener(action_Main);
		panel_InputQLTK.add(btnSuaQLTK);
		
		JLabel lblQuyenHanQLTK = new JLabel("Quyền Hạn");
		lblQuyenHanQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuyenHanQLTK.setBounds(78, 193, 87, 27);
		panel_InputQLTK.add(lblQuyenHanQLTK);
		
		comboBox_QuyenHanQLTK = new JComboBox();
		comboBox_QuyenHanQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_QuyenHanQLTK.setBounds(175, 191, 222, 36);
		comboBox_QuyenHanQLTK.addActionListener(action_Main);
		panel_InputQLTK.add(comboBox_QuyenHanQLTK);
		
		btnXoaTrangQLTK = new JButton("Xóa Trắng");
		btnXoaTrangQLTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangQLTK.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangQLTK.setBounds(448, 231, 122, 38);
		btnXoaTrangQLTK.addActionListener(action_Main);
		panel_InputQLTK.add(btnXoaTrangQLTK);
		
		JLabel lblDanhSachKhach = new JLabel("Danh Sách Khách Hàng Nhân Viên :");
		lblDanhSachKhach.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachKhach.setBounds(605, 11, 380, 27);
		panel_InputQLTK.add(lblDanhSachKhach);
		
		comboBoxKH_NV_QLTK = new JComboBox();
		comboBoxKH_NV_QLTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxKH_NV_QLTK.addActionListener(action_Main);
		comboBoxKH_NV_QLTK.setBounds(989, 11, 141, 27);
		panel_InputQLTK.add(comboBoxKH_NV_QLTK);
		
		JPanel panel = new JPanel();
		panel.setBounds(605, 53, 525, 216);
		panel_InputQLTK.add(panel);
		panel.setLayout(null);
		
		table_khachHang_nhanVienQLTK = new JTable();
		table_khachHang_nhanVienQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_khachHang_nhanVienQLTK.addMouseListener(Main_mouse_action);
		table_khachHang_nhanVienQLTK.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Họ Tên", "Số Điện Thoại"
			}
		));
		table_khachHang_nhanVienQLTK.addMouseListener(Main_mouse_action);
		JScrollPane scrollPane = new JScrollPane(table_khachHang_nhanVienQLTK);
		scrollPane.setBounds(0, 0, 525, 216);
		panel.add(scrollPane);
		
		passwordFieldMKQLTK = new JPasswordField();
		passwordFieldMKQLTK.setBounds(175, 99, 222, 38);
		panel_InputQLTK.add(passwordFieldMKQLTK);
		
		passwordField_againMKQLTK = new JPasswordField();
		passwordField_againMKQLTK.setBounds(175, 146, 222, 38);
		panel_InputQLTK.add(passwordField_againMKQLTK);
		
		JPanel panel_OutputQLTK = new JPanel();
		panel_OutputQLTK.setLayout(null);
		panel_OutputQLTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputQLTK.setBounds(10, 298, 1140, 284);
		panel_InputOutputQLTK.add(panel_OutputQLTK);
		
		JLabel lblDanhSachTaiKhoanQLTK = new JLabel("Danh Sách Tài Khoản :");
		lblDanhSachTaiKhoanQLTK.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachTaiKhoanQLTK.setBounds(10, 11, 248, 27);
		panel_OutputQLTK.add(lblDanhSachTaiKhoanQLTK);
		
		JPanel panel_OutputListQLTK = new JPanel();
		panel_OutputListQLTK.setLayout(null);
		panel_OutputListQLTK.setBounds(10, 38, 1120, 235);
		panel_OutputQLTK.add(panel_OutputListQLTK);
		
		table_OutputListQLTK = new JTable();
		table_OutputListQLTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		table_OutputListQLTK.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Tài Khoản", "Mật Khẩu", "Quyền Hạn"
			}
		));
		table_OutputListQLTK.addMouseListener(Main_mouse_action);
		JScrollPane scrollPane_OutPutListQLTK = new JScrollPane(table_OutputListQLTK);
		scrollPane_OutPutListQLTK.setBounds(0, 0, 1120, 235);
		panel_OutputListQLTK.add(scrollPane_OutPutListQLTK);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình tìm kiếm tài khoảng
		JPanel Panel_TimKiemTaiKhoan = new JPanel();
		Panel_TimKiemTaiKhoan.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_TimKiemTaiKhoan, "manHinhTimKiemTaiKhoan");
		
		JPanel panel_TitleTKTK = new JPanel();
		panel_TitleTKTK.setLayout(null);
		panel_TitleTKTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleTKTK.setBackground(new Color(0, 191, 255));
		panel_TitleTKTK.setBounds(10, 11, 1160, 64);
		Panel_TimKiemTaiKhoan.add(panel_TitleTKTK);
		
		JLabel lblTitleTKTK = new JLabel("Tìm Kiếm Tài Khoản");
		lblTitleTKTK.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblTitleTKTK.setBounds(350, 11, 462, 53);
		panel_TitleTKTK.add(lblTitleTKTK);
		
		JPanel panel_InputOutputTKTK = new JPanel();
		panel_InputOutputTKTK.setLayout(null);
		panel_InputOutputTKTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputTKTK.setBackground(new Color(0, 191, 255));
		panel_InputOutputTKTK.setBounds(10, 86, 1160, 593);
		Panel_TimKiemTaiKhoan.add(panel_InputOutputTKTK);
		
		JPanel panel_QuyenHanTKTK = new JPanel();
		panel_QuyenHanTKTK.setLayout(null);
		panel_QuyenHanTKTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_QuyenHanTKTK.setBounds(10, 11, 1140, 276);
		panel_InputOutputTKTK.add(panel_QuyenHanTKTK);
		
		JLabel lblNhapThongTinTaiKhoanTK = new JLabel("Nhập Thông Tin Tài Khoản Cần Tìm Kiếm :");
		lblNhapThongTinTaiKhoanTK.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhapThongTinTaiKhoanTK.setBounds(10, 11, 429, 27);
		panel_QuyenHanTKTK.add(lblNhapThongTinTaiKhoanTK);
		
		textTenTaiKhoanTKTK = new JTextField();
		textTenTaiKhoanTKTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textTenTaiKhoanTKTK.setColumns(10);
		textTenTaiKhoanTKTK.setBounds(251, 60, 222, 38);
		panel_QuyenHanTKTK.add(textTenTaiKhoanTKTK);
		
		btnTimKiemTKTK = new JButton("Tìm Kiếm");
		btnTimKiemTKTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKiemTKTK.setBackground(Color.LIGHT_GRAY);
		btnTimKiemTKTK.setBounds(490, 143, 122, 38);
		btnTimKiemTKTK.addActionListener(action_Main);
		panel_QuyenHanTKTK.add(btnTimKiemTKTK);
		
		chckbxTenTaiKhoanTKTK = new JCheckBox("");
		chckbxTenTaiKhoanTKTK.setBounds(479, 68, 21, 23);
		panel_QuyenHanTKTK.add(chckbxTenTaiKhoanTKTK);
		
		chckbxQuyenHanTKTK = new JCheckBox("");
		chckbxQuyenHanTKTK.setBounds(977, 68, 21, 23);
		panel_QuyenHanTKTK.add(chckbxQuyenHanTKTK);
		
		JLabel lblTenTaiKhoanTKTK = new JLabel("Tên Tài Khoản");
		lblTenTaiKhoanTKTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenTaiKhoanTKTK.setBounds(123, 64, 118, 27);
		panel_QuyenHanTKTK.add(lblTenTaiKhoanTKTK);
		
		JLabel lblQuyenHanTKTK = new JLabel("Quyền Hạn");
		lblQuyenHanTKTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuyenHanTKTK.setBounds(652, 64, 87, 27);
		panel_QuyenHanTKTK.add(lblQuyenHanTKTK);
		
		comboBox_QuyenHanTKTK = new JComboBox();
		comboBox_QuyenHanTKTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_QuyenHanTKTK.setBounds(749, 62, 222, 36);
		comboBox_QuyenHanTKTK.addActionListener(action_Main);
		panel_QuyenHanTKTK.add(comboBox_QuyenHanTKTK);
		
		JPanel panel_OutputTKTK = new JPanel();
		panel_OutputTKTK.setLayout(null);
		panel_OutputTKTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputTKTK.setBounds(10, 298, 1140, 284);
		panel_InputOutputTKTK.add(panel_OutputTKTK);
		
		JLabel lblDanhSachTimKiemTaiKhoan = new JLabel("Danh Sách Tài Khoản Tìm Kiếm :");
		lblDanhSachTimKiemTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachTimKiemTaiKhoan.setBounds(10, 11, 324, 27);
		panel_OutputTKTK.add(lblDanhSachTimKiemTaiKhoan);
		
		JPanel panel_OutputListTKTK = new JPanel();
		panel_OutputListTKTK.setLayout(null);
		panel_OutputListTKTK.setBounds(10, 38, 1120, 235);
		panel_OutputTKTK.add(panel_OutputListTKTK);
		
		table_OutputListTKTK = new JTable();
		table_OutputListTKTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListTKTK.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Tài Khoản", "Mật Khẩu", "Quyền Hạn"
			}
		));
		table_OutputListTKTK.addMouseListener(Main_mouse_action);
		JScrollPane scrollPane_OutputListTKTK = new JScrollPane(table_OutputListTKTK);
		scrollPane_OutputListTKTK.setBounds(0, 0, 1120, 235);
		panel_OutputListTKTK.add(scrollPane_OutputListTKTK);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình đặt phòng
		JPanel Panel_DatPhong = new JPanel();
		Panel_DatPhong.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_DatPhong, "manHinhDatPhong");
		
		JPanel panel_TitleDP = new JPanel();
		panel_TitleDP.setLayout(null);
		panel_TitleDP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleDP.setBackground(new Color(0, 191, 255));
		panel_TitleDP.setBounds(10, 11, 1160, 64);
		Panel_DatPhong.add(panel_TitleDP);
		
		JLabel lbl_TitleDP = new JLabel("Đặt Phòng");
		lbl_TitleDP.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleDP.setBounds(466, 11, 233, 53);
		panel_TitleDP.add(lbl_TitleDP);
		
		JPanel panel_InputOutPutDP = new JPanel();
		panel_InputOutPutDP.setLayout(null);
		panel_InputOutPutDP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutPutDP.setBackground(new Color(0, 191, 255));
		panel_InputOutPutDP.setBounds(10, 86, 1160, 593);
		Panel_DatPhong.add(panel_InputOutPutDP);
		
		JPanel panel_KH_NV_DP = new JPanel();
		panel_KH_NV_DP.setLayout(null);
		panel_KH_NV_DP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_KH_NV_DP.setBounds(10, 11, 1140, 571);
		panel_InputOutPutDP.add(panel_KH_NV_DP);
		
		JLabel lblDanhSachKhachHangDP = new JLabel("Danh Sách Khách Hàng");
		lblDanhSachKhachHangDP.setBounds(10, 11, 193, 22);
		panel_KH_NV_DP.add(lblDanhSachKhachHangDP);
		lblDanhSachKhachHangDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel panel_OutputListDSKHDP = new JPanel();
		panel_OutputListDSKHDP.setBounds(10, 44, 585, 221);
		panel_KH_NV_DP.add(panel_OutputListDSKHDP);
		panel_OutputListDSKHDP.setLayout(null);
		
		table_OutputListDSKHDP = new JTable();
		table_OutputListDSKHDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListDSKHDP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Khách Hàng", "Họ Tên", "Số Điện Thoại"
			}
		));
		
		JScrollPane scrollPane_OutputListDSKHDP = new JScrollPane(table_OutputListDSKHDP);
		scrollPane_OutputListDSKHDP.setBounds(0, 5, 585, 216);
		panel_OutputListDSKHDP.add(scrollPane_OutputListDSKHDP);
		
		JLabel lblDanhSachPhongTrong = new JLabel("Danh Sách Phòng Trống");
		lblDanhSachPhongTrong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDanhSachPhongTrong.setBounds(10, 309, 205, 22);
		panel_KH_NV_DP.add(lblDanhSachPhongTrong);
		
		JPanel panel_OutputListDSPTDP = new JPanel();
		panel_OutputListDSPTDP.setLayout(null);
		panel_OutputListDSPTDP.setBounds(10, 339, 597, 221);
		panel_KH_NV_DP.add(panel_OutputListDSPTDP);
		
		table_OutputListDSPTDP = new JTable();
		table_OutputListDSPTDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListDSPTDP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Phòng", "Tên Phòng", "Loại Phòng", "Trạng Thái", "Giá Phòng"
			}
		));
		
		JScrollPane scrollPane_OutputListDSPTDP = new JScrollPane(table_OutputListDSPTDP);
		scrollPane_OutputListDSPTDP.setBounds(0, 0, 597, 216);
		panel_OutputListDSPTDP.add(scrollPane_OutputListDSPTDP);
		
		JLabel lblSoNguoiDP = new JLabel("Số Người :");
		lblSoNguoiDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoNguoiDP.setBounds(666, 385, 83, 22);
		panel_KH_NV_DP.add(lblSoNguoiDP);
		
		JLabel lblNgayDatPhongDP = new JLabel("Ngày Đặt Phòng :");
		lblNgayDatPhongDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNgayDatPhongDP.setBounds(617, 473, 142, 22);
		panel_KH_NV_DP.add(lblNgayDatPhongDP);
		
		btntDatPhongDP = new JButton("Đặt Phòng");
		btntDatPhongDP.setBounds(960, 513, 170, 47);
		panel_KH_NV_DP.add(btntDatPhongDP);
		btntDatPhongDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btntDatPhongDP.addActionListener(action_Main);
		btntDatPhongDP.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblGhiChuDP = new JLabel("Ghi Chú :");
		lblGhiChuDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGhiChuDP.setBounds(672, 431, 77, 22);
		panel_KH_NV_DP.add(lblGhiChuDP);
		
		textGhiChuKQDP = new JTextField();
		textGhiChuKQDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textGhiChuKQDP.setColumns(10);
		textGhiChuKQDP.setBounds(759, 429, 210, 31);
		panel_KH_NV_DP.add(textGhiChuKQDP);
		
		JLabel lblMaDatPhongDP = new JLabel("Mã Đặt Phòng :");
		lblMaDatPhongDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaDatPhongDP.setBounds(625, 342, 124, 22);
		panel_KH_NV_DP.add(lblMaDatPhongDP);
		
		textMaDatPhongKQDP = new JTextField();
		textMaDatPhongKQDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textMaDatPhongKQDP.setColumns(10);
		textMaDatPhongKQDP.setBounds(759, 339, 210, 33);
		panel_KH_NV_DP.add(textMaDatPhongKQDP);
		
		JLabel lblPhieuDatPhongDP = new JLabel("Phiếu Đặt Phòng");
		lblPhieuDatPhongDP.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblPhieuDatPhongDP.setBounds(959, 11, 171, 31);
		panel_KH_NV_DP.add(lblPhieuDatPhongDP);
		
		JLabel lblTenKhachHangDP = new JLabel("Tên Khách Hàng");
		lblTenKhachHangDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenKhachHangDP.setBounds(617, 55, 142, 22);
		panel_KH_NV_DP.add(lblTenKhachHangDP);
		
		JLabel lblSoDienThoaiDP = new JLabel("Số Điện Thoại");
		lblSoDienThoaiDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoDienThoaiDP.setBounds(638, 102, 111, 22);
		panel_KH_NV_DP.add(lblSoDienThoaiDP);
		
		JPanel panel_OutputListDSPDPDP = new JPanel();
		panel_OutputListDSPDPDP.setLayout(null);
		panel_OutputListDSPDPDP.setBounds(617, 142, 513, 164);
		panel_KH_NV_DP.add(panel_OutputListDSPDPDP);
		
		table_PhieuDatPhongDP = new JTable();
		table_PhieuDatPhongDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_PhieuDatPhongDP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Đặt Phòng", "Mã Phòng", "Số Người", "Ngày Đặt", "Ghi Chú"
			}
		));
		
		JScrollPane scrollPane_OutputListDSPDPDP = new JScrollPane(table_PhieuDatPhongDP);
		scrollPane_OutputListDSPDPDP.setBounds(0, 5, 513, 159);
		panel_OutputListDSPDPDP.add(scrollPane_OutputListDSPDPDP);
		
		JLabel lblTenNhanVienDP = new JLabel("Tên Nhân Viên");
		lblTenNhanVienDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenNhanVienDP.setBounds(944, 75, 117, 22);
		panel_KH_NV_DP.add(lblTenNhanVienDP);
		
		dateChooserNgayDatPhongDP = new JDateChooser();
		dateChooserNgayDatPhongDP.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayDatPhongDP.setBounds(759, 473, 210, 29);
		panel_KH_NV_DP.add(dateChooserNgayDatPhongDP);
		
		comboBox_SoNguoiDP = new JComboBox();
		comboBox_SoNguoiDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_SoNguoiDP.setBounds(759, 385, 55, 33);
		panel_KH_NV_DP.add(comboBox_SoNguoiDP);
		
		JLabel lbl_GioVaoTHD_1 = new JLabel("Giờ Đặt :");
		lbl_GioVaoTHD_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_GioVaoTHD_1.setBounds(678, 515, 73, 22);
		panel_KH_NV_DP.add(lbl_GioVaoTHD_1);
		
		comboBox_GioLDP = new JComboBox();
		comboBox_GioLDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioLDP.setBounds(761, 511, 50, 35);
		panel_KH_NV_DP.add(comboBox_GioLDP);
		
		JLabel lbl_DanhSachBanHangTHD_2_3_2_2 = new JLabel(":");
		lbl_DanhSachBanHangTHD_2_3_2_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_DanhSachBanHangTHD_2_3_2_2.setBounds(821, 517, 11, 22);
		panel_KH_NV_DP.add(lbl_DanhSachBanHangTHD_2_3_2_2);
		
		comboBox_PhutDP = new JComboBox();
		comboBox_PhutDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutDP.setBounds(842, 511, 50, 33);
		panel_KH_NV_DP.add(comboBox_PhutDP);
		
		textField_TenKhachHangKQDP = new JTextField();
		textField_TenKhachHangKQDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenKhachHangKQDP.setEditable(false);
		textField_TenKhachHangKQDP.setBounds(760, 53, 158, 31);
		panel_KH_NV_DP.add(textField_TenKhachHangKQDP);
		textField_TenKhachHangKQDP.setColumns(10);
		
		textField_SoDienThoaiKQDP = new JTextField();
		textField_SoDienThoaiKQDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoDienThoaiKQDP.setEditable(false);
		textField_SoDienThoaiKQDP.setColumns(10);
		textField_SoDienThoaiKQDP.setBounds(760, 100, 158, 31);
		panel_KH_NV_DP.add(textField_SoDienThoaiKQDP);
		
		textField_TenNhanVienKQDP = new JTextField();
		textField_TenNhanVienKQDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenNhanVienKQDP.setEditable(false);
		textField_TenNhanVienKQDP.setColumns(10);
		textField_TenNhanVienKQDP.setBounds(944, 102, 170, 31);
		panel_KH_NV_DP.add(textField_TenNhanVienKQDP);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình tạo hóa đơn
		JPanel Panel_DatDichVu = new JPanel();
		Panel_DatDichVu.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_DatDichVu, "manHinhDatDichVu");
		
		JPanel panel_Title_TaoHoaDon = new JPanel();
		panel_Title_TaoHoaDon.setLayout(null);
		panel_Title_TaoHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_TaoHoaDon.setBackground(new Color(0, 191, 255));
		panel_Title_TaoHoaDon.setBounds(10, 11, 1160, 64);
		Panel_DatDichVu.add(panel_Title_TaoHoaDon);
		
		JLabel lbl_TitleTHD = new JLabel("Đặt Dịch Vụ");
		lbl_TitleTHD.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleTHD.setBounds(433, 11, 274, 53);
		panel_Title_TaoHoaDon.add(lbl_TitleTHD);
		
		JPanel panel_InputOutputTHD = new JPanel();
		panel_InputOutputTHD.setLayout(null);
		panel_InputOutputTHD.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputTHD.setBackground(new Color(0, 191, 255));
		panel_InputOutputTHD.setBounds(10, 86, 1160, 593);
		Panel_DatDichVu.add(panel_InputOutputTHD);
		
		JPanel panel_OutputKH_NV_THD = new JPanel();
		panel_OutputKH_NV_THD.setLayout(null);
		panel_OutputKH_NV_THD.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputKH_NV_THD.setBounds(10, 11, 1140, 571);
		panel_InputOutputTHD.add(panel_OutputKH_NV_THD);
		
		JPanel panel_OutputListDSPDPTHD1 = new JPanel();
		panel_OutputListDSPDPTHD1.setBounds(10, 41, 552, 343);
		panel_OutputKH_NV_THD.add(panel_OutputListDSPDPTHD1);
		panel_OutputListDSPDPTHD1.setLayout(null);
		
		table_OutputListDSPDPTHD = new JTable();
		table_OutputListDSPDPTHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListDSPDPTHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Đặt Phòng", "Số Người", "Ngày Đặt", "Ghi Chú"
			}
		));
		table_OutputListDSPDPTHD.addMouseListener(Main_mouse_action);
		
		JScrollPane scrollPane_OutputListDSPDPDDV = new JScrollPane(table_OutputListDSPDPTHD);
		scrollPane_OutputListDSPDPDDV.setBounds(0, 0, 552, 343);
		panel_OutputListDSPDPTHD1.add(scrollPane_OutputListDSPDPDDV);
		
		JLabel lblDanhSachPhieuDatPhongTHD = new JLabel("Danh Sách Phiếu Đặt Phòng  :");
		lblDanhSachPhieuDatPhongTHD.setBounds(10, 8, 236, 22);
		panel_OutputKH_NV_THD.add(lblDanhSachPhieuDatPhongTHD);
		lblDanhSachPhieuDatPhongTHD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		btnBatDauTinhGioDDV = new JButton("Bắt Đầu Tính Giờ");
		btnBatDauTinhGioDDV.setBounds(47, 459, 177, 31);
		panel_OutputKH_NV_THD.add(btnBatDauTinhGioDDV);
		
		btnBatDauTinhGioDDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBatDauTinhGioDDV.addActionListener(action_Main);
		btnBatDauTinhGioDDV.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbl_GioVaoTHD = new JLabel("Giờ Vào :");
		lbl_GioVaoTHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_GioVaoTHD.setBounds(10, 398, 73, 22);
		panel_OutputKH_NV_THD.add(lbl_GioVaoTHD);
		
		JLabel lbl_NgayNhanTHD = new JLabel("Ngày Nhận :");
		lbl_NgayNhanTHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_NgayNhanTHD.setBounds(271, 402, 85, 22);
		panel_OutputKH_NV_THD.add(lbl_NgayNhanTHD);
		
		comboBox_GioDDV = new JComboBox();
		comboBox_GioDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioDDV.setBounds(93, 394, 50, 35);
		panel_OutputKH_NV_THD.add(comboBox_GioDDV);
		
		JLabel lbl_DanhSachBanHangTHD_2_3_2 = new JLabel(":");
		lbl_DanhSachBanHangTHD_2_3_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_DanhSachBanHangTHD_2_3_2.setBounds(153, 400, 11, 22);
		panel_OutputKH_NV_THD.add(lbl_DanhSachBanHangTHD_2_3_2);
		
		comboBox_PhutDDV = new JComboBox();
		comboBox_PhutDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutDDV.setBounds(174, 394, 50, 33);
		panel_OutputKH_NV_THD.add(comboBox_PhutDDV);
		
		JLabel lbltDichVu = new JLabel("Đặt Dịch Vụ ");
		lbltDichVu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbltDichVu.setBounds(572, 393, 106, 22);
		panel_OutputKH_NV_THD.add(lbltDichVu);
		
		JLabel lblNewLabel = new JLabel("Loại Dịch Vụ :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(572, 430, 106, 22);
		panel_OutputKH_NV_THD.add(lblNewLabel);
		
		JLabel lblTnDichVu = new JLabel("Tên Dịch Vụ :");
		lblTnDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnDichVu.setBounds(572, 468, 106, 22);
		panel_OutputKH_NV_THD.add(lblTnDichVu);
		
		JLabel lblnGia = new JLabel("Đơn Giá :");
		lblnGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblnGia.setBounds(604, 501, 74, 22);
		panel_OutputKH_NV_THD.add(lblnGia);
		
		JLabel lblSLng = new JLabel("Số Lượng :");
		lblSLng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSLng.setBounds(593, 532, 85, 31);
		panel_OutputKH_NV_THD.add(lblSLng);
		
		comboBoxLoaiDichVuDDV = new JComboBox();
		comboBoxLoaiDichVuDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBoxLoaiDichVuDDV.setBounds(691, 421, 198, 31);
		comboBoxLoaiDichVuDDV.addActionListener(action_Main);
		panel_OutputKH_NV_THD.add(comboBoxLoaiDichVuDDV);
		
		comboBox_TenDichVuDDV = new JComboBox();
		comboBox_TenDichVuDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_TenDichVuDDV.setBounds(691, 461, 198, 31);
		comboBox_TenDichVuDDV.addActionListener(action_Main);
		panel_OutputKH_NV_THD.add(comboBox_TenDichVuDDV);
		
		textField_DonGiaDDV = new JTextField();
		textField_DonGiaDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_DonGiaDDV.setEditable(false);
		textField_DonGiaDDV.setBounds(691, 499, 198, 31);
		panel_OutputKH_NV_THD.add(textField_DonGiaDDV);
		textField_DonGiaDDV.setColumns(10);
		
		textField_SoLuongDDV = new JTextField();
		textField_SoLuongDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoLuongDDV.setColumns(10);
		textField_SoLuongDDV.setBounds(691, 536, 198, 31);
		panel_OutputKH_NV_THD.add(textField_SoLuongDDV);
		
		JLabel lblThngTinHoa = new JLabel("Thông Tin Dịch Vụ Phòng :");
		lblThngTinHoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblThngTinHoa.setBounds(572, 6, 225, 22);
		panel_OutputKH_NV_THD.add(lblThngTinHoa);
		
		JPanel panel_OutputListDSPDPTHD1_1 = new JPanel();
		panel_OutputListDSPDPTHD1_1.setLayout(null);
		panel_OutputListDSPDPTHD1_1.setBounds(572, 134, 552, 250);
		panel_OutputKH_NV_THD.add(panel_OutputListDSPDPTHD1_1);
		
		table_ChiTietDichVuDDV = new JTable();
		table_ChiTietDichVuDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_ChiTietDichVuDDV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Dịch Vụ", "Số Lượng", "Giá", "Thành Tiền"
			}
		));
		
		JScrollPane scrollPane_OutputListDPDDV = new JScrollPane(table_ChiTietDichVuDDV);
		scrollPane_OutputListDPDDV.setBounds(0, 0, 552, 250);
		panel_OutputListDSPDPTHD1_1.add(scrollPane_OutputListDPDDV);
		
		JLabel lblTnKhachHang = new JLabel("Tên Phòng :");
		lblTnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTnKhachHang.setBounds(572, 41, 99, 22);
		panel_OutputKH_NV_THD.add(lblTnKhachHang);
		
		JLabel lblSinThoai = new JLabel("Loại Phòng :");
		lblSinThoai.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSinThoai.setBounds(835, 41, 106, 22);
		panel_OutputKH_NV_THD.add(lblSinThoai);
		
		btnThemDichVuDDV = new JButton("Thêm Dịch Vụ");
		btnThemDichVuDDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemDichVuDDV.setBackground(Color.LIGHT_GRAY);
		btnThemDichVuDDV.setBounds(929, 532, 155, 31);
		btnThemDichVuDDV.addActionListener(action_Main);
		panel_OutputKH_NV_THD.add(btnThemDichVuDDV);
		
		dateChooserNgayLapHD = new JDateChooser();
		dateChooserNgayLapHD.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayLapHD.setBounds(366, 398, 174, 31);
		panel_OutputKH_NV_THD.add(dateChooserNgayLapHD);
		
		textField_TenPhongDDV = new JTextField();
		textField_TenPhongDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenPhongDDV.setEditable(false);
		textField_TenPhongDDV.setBounds(681, 41, 125, 31);
		panel_OutputKH_NV_THD.add(textField_TenPhongDDV);
		textField_TenPhongDDV.setColumns(10);
		
		textField_LoaiPhongDDV = new JTextField();
		textField_LoaiPhongDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_LoaiPhongDDV.setEditable(false);
		textField_LoaiPhongDDV.setColumns(10);
		textField_LoaiPhongDDV.setBounds(951, 41, 125, 31);
		panel_OutputKH_NV_THD.add(textField_LoaiPhongDDV);
		
		JLabel lblGiaPhong = new JLabel("Giá Phòng :");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGiaPhong.setBounds(572, 90, 99, 22);
		panel_OutputKH_NV_THD.add(lblGiaPhong);
		
		textField_GiaPhongDDV = new JTextField();
		textField_GiaPhongDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_GiaPhongDDV.setEditable(false);
		textField_GiaPhongDDV.setColumns(10);
		textField_GiaPhongDDV.setBounds(681, 88, 125, 31);
		panel_OutputKH_NV_THD.add(textField_GiaPhongDDV);
		
		JLabel lblNgayGi = new JLabel(" Ngày Giờ Dặt :");
		lblNgayGi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNgayGi.setBounds(816, 90, 125, 22);
		panel_OutputKH_NV_THD.add(lblNgayGi);
		
		textField_NgayGioNhanPhongDDV = new JTextField();
		textField_NgayGioNhanPhongDDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_NgayGioNhanPhongDDV.setEditable(false);
		textField_NgayGioNhanPhongDDV.setColumns(10);
		textField_NgayGioNhanPhongDDV.setBounds(951, 88, 125, 31);
		panel_OutputKH_NV_THD.add(textField_NgayGioNhanPhongDDV);
		
		btnHuyDichVuDDV = new JButton("Hủy Dịch Vụ");
		btnHuyDichVuDDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnHuyDichVuDDV.setBackground(Color.LIGHT_GRAY);
		btnHuyDichVuDDV.addActionListener(action_Main);
		btnHuyDichVuDDV.setBounds(929, 492, 155, 31);
		panel_OutputKH_NV_THD.add(btnHuyDichVuDDV);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình thanh toán
		JPanel Panel_ThanhToan = new JPanel();
		Panel_ThanhToan.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_ThanhToan, "manHinhThanhToan");
		
		JPanel panel_TitleThanhToan = new JPanel();
		panel_TitleThanhToan.setLayout(null);
		panel_TitleThanhToan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleThanhToan.setBackground(new Color(0, 191, 255));
		panel_TitleThanhToan.setBounds(10, 11, 1160, 64);
		Panel_ThanhToan.add(panel_TitleThanhToan);
		
		JLabel lbl_TitleThanhToan = new JLabel("Thanh Toán");
		lbl_TitleThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleThanhToan.setBounds(447, 11, 266, 53);
		panel_TitleThanhToan.add(lbl_TitleThanhToan);
		
		JPanel panel_ContentThanhToan = new JPanel();
		panel_ContentThanhToan.setLayout(null);
		panel_ContentThanhToan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ContentThanhToan.setBackground(new Color(0, 191, 255));
		panel_ContentThanhToan.setBounds(10, 86, 1160, 593);
		Panel_ThanhToan.add(panel_ContentThanhToan);
		
		JPanel panel_OutputListCTT_CTHD = new JPanel();
		panel_OutputListCTT_CTHD.setLayout(null);
		panel_OutputListCTT_CTHD.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputListCTT_CTHD.setBounds(10, 11, 1140, 402);
		panel_ContentThanhToan.add(panel_OutputListCTT_CTHD);
		
		JLabel lblDanhSachHDChuaTT = new JLabel("Danh Sách Hóa Đơn Chưa Thanh Toán :");
		lblDanhSachHDChuaTT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDanhSachHDChuaTT.setBounds(10, 11, 318, 27);
		panel_OutputListCTT_CTHD.add(lblDanhSachHDChuaTT);
		
		JPanel panel_OutputListDSHDCTT = new JPanel();
		panel_OutputListDSHDCTT.setLayout(null);
		panel_OutputListDSHDCTT.setBounds(10, 38, 488, 353);
		panel_OutputListCTT_CTHD.add(panel_OutputListDSHDCTT);
		
		table_OutputListDSHDCTT = new JTable();
		table_OutputListDSHDCTT.addMouseListener(Main_mouse_action);
		table_OutputListDSHDCTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_OutputListDSHDCTT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Hóa Đơn", "Mã Nhân Viên","Ngày Lập", "Trạng Thái"
			}
		));
		
		JScrollPane scrollPane_OutputListDSHDCTT = new JScrollPane(table_OutputListDSHDCTT);
		scrollPane_OutputListDSHDCTT.setBounds(0, 0, 488, 353);
		panel_OutputListDSHDCTT.add(scrollPane_OutputListDSHDCTT);
		
		JLabel lbl_TitleThanhToan_1_1_1 = new JLabel("Hóa Đơn");
		lbl_TitleThanhToan_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleThanhToan_1_1_1.setBounds(737, 11, 194, 53);
		panel_OutputListCTT_CTHD.add(lbl_TitleThanhToan_1_1_1);
		
		JLabel lblHoTnNhn_1 = new JLabel("Họ Tên Nhân Viên :");
		lblHoTnNhn_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHoTnNhn_1.setBounds(523, 87, 156, 27);
		panel_OutputListCTT_CTHD.add(lblHoTnNhn_1);
		
		JLabel lblHoTnKhach_1 = new JLabel("Họ Tên Khách Hàng :");
		lblHoTnKhach_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHoTnKhach_1.setBounds(508, 125, 171, 27);
		panel_OutputListCTT_CTHD.add(lblHoTnKhach_1);
		
		JLabel lblMatPhong_1 = new JLabel("Mã Đặt Phòng :");
		lblMatPhong_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMatPhong_1.setBounds(555, 163, 124, 27);
		panel_OutputListCTT_CTHD.add(lblMatPhong_1);
		
		textField_hoTenNhanVienTT = new JTextField();
		textField_hoTenNhanVienTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_hoTenNhanVienTT.setEditable(false);
		textField_hoTenNhanVienTT.setColumns(10);
		textField_hoTenNhanVienTT.setBounds(689, 87, 171, 27);
		panel_OutputListCTT_CTHD.add(textField_hoTenNhanVienTT);
		
		textField_hoTenKhachHangTT = new JTextField();
		textField_hoTenKhachHangTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_hoTenKhachHangTT.setEditable(false);
		textField_hoTenKhachHangTT.setColumns(10);
		textField_hoTenKhachHangTT.setBounds(689, 125, 171, 27);
		panel_OutputListCTT_CTHD.add(textField_hoTenKhachHangTT);
		
		textField_maDatPhongTT = new JTextField();
		textField_maDatPhongTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maDatPhongTT.setEditable(false);
		textField_maDatPhongTT.setColumns(10);
		textField_maDatPhongTT.setBounds(689, 168, 171, 27);
		panel_OutputListCTT_CTHD.add(textField_maDatPhongTT);
		
		JLabel lblDanhSachPhiu_1_1 = new JLabel("Danh Sách Dịch Vụ :");
		lblDanhSachPhiu_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDanhSachPhiu_1_1.setBounds(513, 206, 171, 27);
		panel_OutputListCTT_CTHD.add(lblDanhSachPhiu_1_1);
		
		JPanel panel_OutputListDSHDCTT_1_2_1 = new JPanel();
		panel_OutputListDSHDCTT_1_2_1.setLayout(null);
		panel_OutputListDSHDCTT_1_2_1.setBounds(513, 233, 617, 158);
		panel_OutputListCTT_CTHD.add(panel_OutputListDSHDCTT_1_2_1);
		
		table_DanhSachDichVuTT = new JTable();
		table_DanhSachDichVuTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_DanhSachDichVuTT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Dịch Vụ", "Số Lượng", "Giá", "Thành Tiền"
			}
		));
		
		JScrollPane scrollPane_OutputListDSHDCTT_1_2_1 = new JScrollPane(table_DanhSachDichVuTT);
		scrollPane_OutputListDSHDCTT_1_2_1.setBounds(0, 0, 617, 158);
		panel_OutputListDSHDCTT_1_2_1.add(scrollPane_OutputListDSHDCTT_1_2_1);
		
		JLabel lblMaHoan_1_1 = new JLabel("Mã Hóa Đơn");
		lblMaHoan_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaHoan_1_1.setBounds(976, 87, 102, 27);
		panel_OutputListCTT_CTHD.add(lblMaHoan_1_1);
		
		lblMaHoaDonTT = new JLabel("DP001");
		lblMaHoaDonTT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMaHoaDonTT.setBounds(976, 113, 79, 19);
		panel_OutputListCTT_CTHD.add(lblMaHoaDonTT);
		
		JLabel lblNgayLp_1 = new JLabel("Ngày Lập :");
		lblNgayLp_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNgayLp_1.setBounds(879, 168, 93, 27);
		panel_OutputListCTT_CTHD.add(lblNgayLp_1);
		
		textField_ngayLapTT = new JTextField();
		textField_ngayLapTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_ngayLapTT.setEditable(false);
		textField_ngayLapTT.setColumns(10);
		textField_ngayLapTT.setBounds(976, 168, 154, 27);
		panel_OutputListCTT_CTHD.add(textField_ngayLapTT);
		
		JPanel panel_OutputListCTTDTT = new JPanel();
		panel_OutputListCTTDTT.setLayout(null);
		panel_OutputListCTTDTT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputListCTTDTT.setBounds(10, 424, 1140, 158);
		panel_ContentThanhToan.add(panel_OutputListCTTDTT);
		
		JLabel lblTongTienTT = new JLabel("Tổng Tiền : ");
		lblTongTienTT.setBounds(10, 11, 95, 26);
		panel_OutputListCTTDTT.add(lblTongTienTT);
		lblTongTienTT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		btntThanhToanTT = new JButton("Thanh Toán");
		btntThanhToanTT.addActionListener(action_Main);
		btntThanhToanTT.setBounds(663, 67, 150, 43);
		panel_OutputListCTTDTT.add(btntThanhToanTT);
		btntThanhToanTT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btntThanhToanTT.setBackground(Color.LIGHT_GRAY);
		
		btnInHoaDonTT = new JButton("In Hóa Đơn");
		btnInHoaDonTT.addActionListener(action_Main);
		btnInHoaDonTT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnInHoaDonTT.setBackground(new Color(0, 191, 255));
		btnInHoaDonTT.setBounds(927, 28, 203, 119);
		btnInHoaDonTT.setIcon(new ImageIcon(Main.class.getResource("../View/printer.png")));
		panel_OutputListCTTDTT.add(btnInHoaDonTT);
		
		textField_TongTienTT = new JTextField();
		textField_TongTienTT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TongTienTT.setEditable(false);
		textField_TongTienTT.setBounds(115, 11, 144, 31);
		panel_OutputListCTTDTT.add(textField_TongTienTT);
		textField_TongTienTT.setColumns(10);
		
		JLabel lblTongTienTT_1 = new JLabel("Tiền Thừa : ");
		lblTongTienTT_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTongTienTT_1.setBounds(306, 80, 95, 26);
		panel_OutputListCTTDTT.add(lblTongTienTT_1);
		
		textField_TienThuaTTKQ = new JTextField();
		textField_TienThuaTTKQ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TienThuaTTKQ.setEditable(false);
		textField_TienThuaTTKQ.setColumns(10);
		textField_TienThuaTTKQ.setBounds(411, 80, 144, 31);
		panel_OutputListCTTDTT.add(textField_TienThuaTTKQ);
		
		JLabel lblTongTienTT_2 = new JLabel("Tiền Nhận : ");
		lblTongTienTT_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTongTienTT_2.setBounds(10, 80, 95, 26);
		panel_OutputListCTTDTT.add(lblTongTienTT_2);
		
		textField_1_TienNhanTTKQ = new JTextField();
		textField_1_TienNhanTTKQ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1_TienNhanTTKQ.setColumns(10);
		textField_1_TienNhanTTKQ.setBounds(115, 80, 144, 31);
		panel_OutputListCTTDTT.add(textField_1_TienNhanTTKQ);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình thống kê ngày
		JPanel Panel_ThongKe = new JPanel();
		Panel_ThongKe.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_ThongKe, "manHinhThongKeNgay");
		
		JPanel panel_TitleTKN = new JPanel();
		panel_TitleTKN.setLayout(null);
		panel_TitleTKN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleTKN.setBackground(new Color(0, 191, 255));
		panel_TitleTKN.setBounds(10, 11, 1160, 64);
		Panel_ThongKe.add(panel_TitleTKN);
		
		JLabel lbl_TitleThongKeNgay = new JLabel("Thống Kê");
		lbl_TitleThongKeNgay.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleThongKeNgay.setBounds(457, 11, 220, 53);
		panel_TitleTKN.add(lbl_TitleThongKeNgay);
		
		JPanel panel_ContentTKN = new JPanel();
		panel_ContentTKN.setLayout(null);
		panel_ContentTKN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ContentTKN.setBackground(new Color(0, 191, 255));
		panel_ContentTKN.setBounds(10, 86, 1160, 593);
		Panel_ThongKe.add(panel_ContentTKN);
		
		JPanel panel_OutputListTGTKN = new JPanel();
		panel_OutputListTGTKN.setLayout(null);
		panel_OutputListTGTKN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputListTGTKN.setBounds(10, 11, 1140, 191);
		panel_ContentTKN.add(panel_OutputListTGTKN);
		
		JLabel lblChonKhoangThoiGianTK = new JLabel("Chọn Khoảng Thời Gian Bạn Cần Thống Kê");
		lblChonKhoangThoiGianTK.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblChonKhoangThoiGianTK.setBounds(10, 11, 471, 27);
		panel_OutputListTGTKN.add(lblChonKhoangThoiGianTK);
		
		btnThongKeTK = new JButton("Thống Kê");
		btnThongKeTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThongKeTK.setBackground(Color.LIGHT_GRAY);
		btnThongKeTK.setBounds(10, 142, 134, 38);
		btnThongKeTK.addActionListener(action_Main);
		panel_OutputListTGTKN.add(btnThongKeTK);
		
		JLabel lblNewLabel_2 = new JLabel("Theo Ngày :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(41, 64, 97, 27);
		panel_OutputListTGTKN.add(lblNewLabel_2);
		
		dateChooser_ThongKeNgayTK = new JDateChooser();
		dateChooser_ThongKeNgayTK.setDateFormatString("yyyy-MM-dd");
		dateChooser_ThongKeNgayTK.setBounds(148, 64, 154, 38);
		panel_OutputListTGTKN.add(dateChooser_ThongKeNgayTK);
		
		JLabel lblNewLabel_2_1 = new JLabel("Theo Tháng :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(422, 67, 113, 27);
		panel_OutputListTGTKN.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Theo Năm :");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(847, 64, 97, 27);
		panel_OutputListTGTKN.add(lblNewLabel_2_1_1);
		
		chckbxThongKeNgayTK = new JCheckBox("");
		chckbxThongKeNgayTK.setBounds(308, 69, 21, 23);
		panel_OutputListTGTKN.add(chckbxThongKeNgayTK);
		
		chckbx_ThongKeThangTK = new JCheckBox("");
		chckbx_ThongKeThangTK.setBounds(712, 71, 21, 23);
		panel_OutputListTGTKN.add(chckbx_ThongKeThangTK);
		
		chckbx_ThongKeNamTK = new JCheckBox("");
		chckbx_ThongKeNamTK.setBounds(1051, 68, 21, 23);
		panel_OutputListTGTKN.add(chckbx_ThongKeNamTK);
		
		btnTongTienGiamDanTK = new JButton("Tổng Tiền Giảm Dần");
		btnTongTienGiamDanTK.setBounds(885, 142, 239, 38);
		panel_OutputListTGTKN.add(btnTongTienGiamDanTK);
		btnTongTienGiamDanTK.addActionListener(action_Main);
		btnTongTienGiamDanTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTongTienGiamDanTK.setBackground(Color.LIGHT_GRAY);
		
		btnTongTienTangDanTK = new JButton("Tổng Tiền Tăng Dần");
		btnTongTienTangDanTK.setBounds(595, 142, 258, 38);
		panel_OutputListTGTKN.add(btnTongTienTangDanTK);
		btnTongTienTangDanTK.addActionListener(action_Main);
		btnTongTienTangDanTK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTongTienTangDanTK.setBackground(Color.LIGHT_GRAY);
		
		comboBox_thangTK = new JComboBox();
		comboBox_thangTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_thangTK.setBounds(545, 64, 60, 38);
		for (int i = 1; i < 13; i++) {
			comboBox_thangTK.addItem(i);
		}
		panel_OutputListTGTKN.add(comboBox_thangTK);
		
		comboBox_namTK = new JComboBox();
		comboBox_namTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_namTK.setBounds(615, 64, 91, 38);
		for (int i = 2019; i < 2023; i++) {
			comboBox_namTK.addItem(i);
		}
		panel_OutputListTGTKN.add(comboBox_namTK);
		
		comboBox_nam1TK = new JComboBox();
		comboBox_nam1TK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_nam1TK.setBounds(954, 64, 91, 38);
		for (int i = 2019; i < 2023; i++) {
			comboBox_nam1TK.addItem(i);
		}
		panel_OutputListTGTKN.add(comboBox_nam1TK);
		
		JPanel panel_OutputListDSTKN = new JPanel();
		panel_OutputListDSTKN.setLayout(null);
		panel_OutputListDSTKN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputListDSTKN.setBounds(10, 213, 1140, 286);
		panel_ContentTKN.add(panel_OutputListDSTKN);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("Danh Sách Hóa Đơn Thống Kê :");
		lblNewLabel_5_1_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_5_1_3.setBounds(10, 11, 345, 27);
		panel_OutputListDSTKN.add(lblNewLabel_5_1_3);
		
		JPanel panel_9_3 = new JPanel();
		panel_9_3.setLayout(null);
		panel_9_3.setBounds(10, 38, 1120, 235);
		panel_OutputListDSTKN.add(panel_9_3);
		
		table_danhSachHoaDonTK = new JTable();
		table_danhSachHoaDonTK.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Phòng", "Tên Nhân Viên", "Giờ Trả Phòng", "Trạng Thái", "Tổng Tiền"
			}
		));
		table_danhSachHoaDonTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JScrollPane scrollPane_6 = new JScrollPane(table_danhSachHoaDonTK);
		scrollPane_6.setBounds(0, 0, 1120, 235);
		panel_9_3.add(scrollPane_6);
		
		JLabel lblTongSoHoaDonTK = new JLabel("Tổng Số Hóa Đơn:");
		lblTongSoHoaDonTK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTongSoHoaDonTK.setBounds(10, 517, 160, 29);
		panel_ContentTKN.add(lblTongSoHoaDonTK);
		
		JLabel lblTongDoanhThuNgayTK = new JLabel("Tổng Doanh Thu :");
		lblTongDoanhThuNgayTK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTongDoanhThuNgayTK.setBounds(346, 517, 158, 29);
		panel_ContentTKN.add(lblTongDoanhThuNgayTK);
		
		textField_TongHoaDonTK = new JTextField();
		textField_TongHoaDonTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TongHoaDonTK.setEditable(false);
		textField_TongHoaDonTK.setBounds(180, 516, 117, 34);
		panel_ContentTKN.add(textField_TongHoaDonTK);
		textField_TongHoaDonTK.setColumns(10);
		
		textField_TongDoanhThuTK = new JTextField();
		textField_TongDoanhThuTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TongDoanhThuTK.setEditable(false);
		textField_TongDoanhThuTK.setColumns(10);
		textField_TongDoanhThuTK.setBounds(514, 516, 188, 34);
		panel_ContentTKN.add(textField_TongDoanhThuTK);
		
		btnInThongKe = new JButton("In Thống Kê");
		btnInThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnInThongKe.setBounds(1016, 548, 134, 34);
		btnInThongKe.addActionListener(action_Main);
		panel_ContentTKN.add(btnInThongKe);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		màn hình quản lý phiếu đặt phòng
		JPanel Panel_QuanLyPhieuDatPhong = new JPanel();
		Panel_QuanLyPhieuDatPhong.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_QuanLyPhieuDatPhong, "manHinhQuanLyPhieuDatPhong");
		
		JPanel panel_TitleQuanLyPhieuDatPhong = new JPanel();
		panel_TitleQuanLyPhieuDatPhong.setLayout(null);
		panel_TitleQuanLyPhieuDatPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleQuanLyPhieuDatPhong.setBackground(new Color(0, 191, 255));
		panel_TitleQuanLyPhieuDatPhong.setBounds(10, 11, 1160, 64);
		Panel_QuanLyPhieuDatPhong.add(panel_TitleQuanLyPhieuDatPhong);
		
		JLabel lblQuanLyPhieuDatPhong = new JLabel("Quản Lý Phiếu Đặt Phòng");
		lblQuanLyPhieuDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblQuanLyPhieuDatPhong.setBounds(279, 11, 574, 53);
		panel_TitleQuanLyPhieuDatPhong.add(lblQuanLyPhieuDatPhong);
		
		JPanel panel_InputOutputDSPDPQLPDP = new JPanel();
		panel_InputOutputDSPDPQLPDP.setLayout(null);
		panel_InputOutputDSPDPQLPDP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputDSPDPQLPDP.setBackground(new Color(0, 191, 255));
		panel_InputOutputDSPDPQLPDP.setBounds(10, 86, 1160, 593);
		Panel_QuanLyPhieuDatPhong.add(panel_InputOutputDSPDPQLPDP);
		
		JPanel panel_InputOutputDSPDPQLPDP1 = new JPanel();
		panel_InputOutputDSPDPQLPDP1.setLayout(null);
		panel_InputOutputDSPDPQLPDP1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputDSPDPQLPDP1.setBounds(10, 11, 1140, 571);
		panel_InputOutputDSPDPQLPDP.add(panel_InputOutputDSPDPQLPDP1);
		
		JLabel lblDanhSachQLPhieuDatPhong = new JLabel("Danh Sách Phiếu Đặt Phòng :");
		lblDanhSachQLPhieuDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachQLPhieuDatPhong.setBounds(10, 11, 309, 27);
		panel_InputOutputDSPDPQLPDP1.add(lblDanhSachQLPhieuDatPhong);
		
		JPanel panel_OutputListDSPDPQLPDP = new JPanel();
		panel_OutputListDSPDPQLPDP.setLayout(null);
		panel_OutputListDSPDPQLPDP.setBounds(10, 38, 585, 463);
		panel_InputOutputDSPDPQLPDP1.add(panel_OutputListDSPDPQLPDP);
		
		table_DanhSachPhieuDP = new JTable();
		table_DanhSachPhieuDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_DanhSachPhieuDP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Đặt Phòng", "Số Người", "Ngày Đặt", "Ghi Chú", "Trạng Thái"
			}
		));
		table_DanhSachPhieuDP.addMouseListener(Main_mouse_action);
		
		JScrollPane scrollPane_OutputListQuanLyPhong_1 = new JScrollPane(table_DanhSachPhieuDP);
		scrollPane_OutputListQuanLyPhong_1.setBounds(0, 0, 585, 462);
		panel_OutputListDSPDPQLPDP.add(scrollPane_OutputListQuanLyPhong_1);
		
		JLabel lblPhieuDatPhongQLPDP = new JLabel("Phiếu Đặt Phòng");
		lblPhieuDatPhongQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPhieuDatPhongQLPDP.setBounds(957, 11, 173, 27);
		panel_InputOutputDSPDPQLPDP1.add(lblPhieuDatPhongQLPDP);
		
		JLabel lblTenKhachHangQLPDP = new JLabel("Tên Khách Hàng :");
		lblTenKhachHangQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenKhachHangQLPDP.setBounds(617, 69, 142, 22);
		panel_InputOutputDSPDPQLPDP1.add(lblTenKhachHangQLPDP);
		
		JLabel lblSoDienThoaiQLPDP = new JLabel("Số Điện Thoại :");
		lblSoDienThoaiQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoDienThoaiQLPDP.setBounds(637, 102, 122, 22);
		panel_InputOutputDSPDPQLPDP1.add(lblSoDienThoaiQLPDP);
		
		JPanel panel_OutputListPDPQLPDP = new JPanel();
		panel_OutputListPDPQLPDP.setLayout(null);
		panel_OutputListPDPQLPDP.setBounds(617, 142, 513, 96);
		panel_InputOutputDSPDPQLPDP1.add(panel_OutputListPDPQLPDP);
		
		table_PhieuDatPhongQLPDP = new JTable();
		table_PhieuDatPhongQLPDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_PhieuDatPhongQLPDP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Phòng", "Tên Phòng", "Loại Phòng", "Trạng Thái"
			}
		));
		
		JScrollPane scrollPane_OutputListDSKHDP_2_1 = new JScrollPane(table_PhieuDatPhongQLPDP);
		scrollPane_OutputListDSKHDP_2_1.setBounds(0, 0, 513, 96);
		panel_OutputListPDPQLPDP.add(scrollPane_OutputListDSKHDP_2_1);
		
		JLabel lblSoNguoiQLPDP = new JLabel("Số Người :");
		lblSoNguoiQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoNguoiQLPDP.setBounds(617, 249, 91, 22);
		panel_InputOutputDSPDPQLPDP1.add(lblSoNguoiQLPDP);
		
		JLabel lblNgaytDatPhongQLPDP = new JLabel("Ngày Đặt Phòng :");
		lblNgaytDatPhongQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNgaytDatPhongQLPDP.setBounds(798, 249, 142, 22);
		panel_InputOutputDSPDPQLPDP1.add(lblNgaytDatPhongQLPDP);
		
		JLabel lblGhiChuQLPDP = new JLabel("Ghi Chú :");
		lblGhiChuQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGhiChuQLPDP.setBounds(617, 300, 83, 22);
		panel_InputOutputDSPDPQLPDP1.add(lblGhiChuQLPDP);
		
		textGhiChuKQQLPDP = new JTextField();
		textGhiChuKQQLPDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textGhiChuKQQLPDP.setColumns(10);
		textGhiChuKQQLPDP.setBounds(710, 294, 171, 38);
		panel_InputOutputDSPDPQLPDP1.add(textGhiChuKQQLPDP);
		
		textTenKhachHangKQQLPDP = new JTextField();
		textTenKhachHangKQQLPDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textTenKhachHangKQQLPDP.setEditable(false);
		textTenKhachHangKQQLPDP.setColumns(10);
		textTenKhachHangKQQLPDP.setBounds(769, 69, 171, 27);
		panel_InputOutputDSPDPQLPDP1.add(textTenKhachHangKQQLPDP);
		
		textSoDienThoaiKQQLPDP = new JTextField();
		textSoDienThoaiKQQLPDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textSoDienThoaiKQQLPDP.setEditable(false);
		textSoDienThoaiKQQLPDP.setColumns(10);
		textSoDienThoaiKQQLPDP.setBounds(769, 103, 171, 29);
		panel_InputOutputDSPDPQLPDP1.add(textSoDienThoaiKQQLPDP);
		
		JLabel lblTenNhanVienQLPDP = new JLabel("Tên Nhân Viên :");
		lblTenNhanVienQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTenNhanVienQLPDP.setBounds(632, 36, 127, 22);
		panel_InputOutputDSPDPQLPDP1.add(lblTenNhanVienQLPDP);
		
		dateChooser_NgayDatPhongQLDP = new JDateChooser();
		dateChooser_NgayDatPhongQLDP.setDateFormatString("yyyy-MM-dd");
		dateChooser_NgayDatPhongQLDP.setBounds(944, 249, 171, 32);
		panel_InputOutputDSPDPQLPDP1.add(dateChooser_NgayDatPhongQLDP);
		
		comboBox_SoNguoiQLDP = new JComboBox();
		comboBox_SoNguoiQLDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_SoNguoiQLDP.setBounds(707, 249, 47, 32);
		panel_InputOutputDSPDPQLPDP1.add(comboBox_SoNguoiQLDP);
		
		textField_TenNhanVienQLPDP = new JTextField();
		textField_TenNhanVienQLPDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenNhanVienQLPDP.setEditable(false);
		textField_TenNhanVienQLPDP.setColumns(10);
		textField_TenNhanVienQLPDP.setBounds(769, 31, 171, 27);
		panel_InputOutputDSPDPQLPDP1.add(textField_TenNhanVienQLPDP);
		
		JLabel lbl_GioVaoTHD_1_1 = new JLabel("Giờ Đặt :");
		lbl_GioVaoTHD_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_GioVaoTHD_1_1.setBounds(904, 299, 73, 22);
		panel_InputOutputDSPDPQLPDP1.add(lbl_GioVaoTHD_1_1);
		
		comboBox_GioQLDP = new JComboBox();
		comboBox_GioQLDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioQLDP.setBounds(987, 295, 50, 35);
		panel_InputOutputDSPDPQLPDP1.add(comboBox_GioQLDP);
		
		JLabel lbl_DanhSachBanHangTHD_2_3_2_2_1 = new JLabel(":");
		lbl_DanhSachBanHangTHD_2_3_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_DanhSachBanHangTHD_2_3_2_2_1.setBounds(1047, 301, 11, 22);
		panel_InputOutputDSPDPQLPDP1.add(lbl_DanhSachBanHangTHD_2_3_2_2_1);
		
		comboBox_PhutQLDP = new JComboBox();
		comboBox_PhutQLDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutQLDP.setBounds(1068, 295, 50, 33);
		panel_InputOutputDSPDPQLPDP1.add(comboBox_PhutQLDP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(617, 345, 513, 215);
		panel_InputOutputDSPDPQLPDP1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTimKim = new JLabel("Tìm Kiếm");
		lblTimKim.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTimKim.setBounds(10, 11, 103, 27);
		panel_1.add(lblTimKim);
		
		JLabel lblT = new JLabel("Từ :");
		lblT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblT.setBounds(10, 70, 32, 22);
		panel_1.add(lblT);
		
		dateChooser_timkiempdp1 = new JDateChooser();
		dateChooser_timkiempdp1.setDateFormatString("yyyy-MM-dd");
		dateChooser_timkiempdp1.setBounds(52, 60, 148, 32);
		panel_1.add(dateChooser_timkiempdp1);
		
		JLabel lbln = new JLabel("Đến :");
		lbln.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbln.setBounds(210, 70, 41, 22);
		panel_1.add(lbln);
		
		dateChooser_timkiempdp2 = new JDateChooser();
		dateChooser_timkiempdp2.setDateFormatString("yyyy-MM-dd");
		dateChooser_timkiempdp2.setBounds(261, 60, 148, 32);
		panel_1.add(dateChooser_timkiempdp2);
		
		btnTimKiempdp = new JButton("Tìm Kiếm");
		btnTimKiempdp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKiempdp.setBackground(Color.LIGHT_GRAY);
		btnTimKiempdp.setBounds(381, 166, 122, 38);
		btnTimKiempdp.addActionListener(action_Main);
		panel_1.add(btnTimKiempdp);
		
		JLabel lblTnKhachHang_1 = new JLabel("Tên Khách Hàng");
		lblTnKhachHang_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTnKhachHang_1.setBounds(10, 109, 138, 22);
		panel_1.add(lblTnKhachHang_1);
		
		textFieldnamekh = new JTextField();
		textFieldnamekh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldnamekh.setColumns(10);
		textFieldnamekh.setBounds(158, 104, 171, 27);
		panel_1.add(textFieldnamekh);
		
		JLabel lblSoDienThoaiQLPDP_1 = new JLabel("Số Điện Thoại :");
		lblSoDienThoaiQLPDP_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoDienThoaiQLPDP_1.setBounds(10, 142, 122, 22);
		panel_1.add(lblSoDienThoaiQLPDP_1);
		
		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(158, 142, 171, 27);
		panel_1.add(textField_sdt);
		
		JLabel lblSoDienThoaiQLPDP_1_1 = new JLabel("Mã Đặt Phòng :");
		lblSoDienThoaiQLPDP_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSoDienThoaiQLPDP_1_1.setBounds(10, 180, 122, 22);
		panel_1.add(lblSoDienThoaiQLPDP_1_1);
		
		textField_mdp = new JTextField();
		textField_mdp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_mdp.setColumns(10);
		textField_mdp.setBounds(158, 177, 171, 27);
		panel_1.add(textField_mdp);
		
		chckbxdoubletime = new JCheckBox("");
		chckbxdoubletime.setBounds(415, 72, 21, 23);
		panel_1.add(chckbxdoubletime);
		
		chckbxNameKH = new JCheckBox("");
		chckbxNameKH.setBounds(335, 111, 21, 23);
		panel_1.add(chckbxNameKH);
		
		chckbxSDTqlpdp = new JCheckBox("");
		chckbxSDTqlpdp.setBounds(335, 144, 21, 23);
		panel_1.add(chckbxSDTqlpdp);
		
		chckbxMaDP = new JCheckBox("");
		chckbxMaDP.setBounds(335, 176, 21, 23);
		panel_1.add(chckbxMaDP);
		
		btnXoaTrangTimKiempdp = new JButton("Xóa Trắng");
		btnXoaTrangTimKiempdp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangTimKiempdp.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangTimKiempdp.setBounds(381, 117, 122, 38);
		btnXoaTrangTimKiempdp.addActionListener(action_Main);
		panel_1.add(btnXoaTrangTimKiempdp);
		
		btnHuyQLPDP = new JButton("Hủy Đặt Phòng");
		btnHuyQLPDP.setBounds(120, 512, 164, 38);
		panel_InputOutputDSPDPQLPDP1.add(btnHuyQLPDP);
		btnHuyQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnHuyQLPDP.setBackground(Color.LIGHT_GRAY);
		
		btnSuaQLPDP = new JButton("Sửa");
		btnSuaQLPDP.setBounds(333, 512, 122, 38);
		panel_InputOutputDSPDPQLPDP1.add(btnSuaQLPDP);
		btnSuaQLPDP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaQLPDP.setBackground(Color.LIGHT_GRAY);
		btnSuaQLPDP.addActionListener(action_Main);
		btnHuyQLPDP.addActionListener(action_Main);
		
		JPanel Panel_LapHoaDon = new JPanel();
		Panel_LapHoaDon.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_LapHoaDon, "manHinhLapHoaDon");
		
		JPanel panel_TitleThanhToan_1 = new JPanel();
		panel_TitleThanhToan_1.setLayout(null);
		panel_TitleThanhToan_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TitleThanhToan_1.setBackground(new Color(0, 191, 255));
		panel_TitleThanhToan_1.setBounds(10, 11, 1160, 64);
		Panel_LapHoaDon.add(panel_TitleThanhToan_1);
		
		JLabel lbl_TitleThanhToan_1 = new JLabel("Lập Hóa Đơn");
		lbl_TitleThanhToan_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleThanhToan_1.setBounds(447, 11, 293, 53);
		panel_TitleThanhToan_1.add(lbl_TitleThanhToan_1);
		
		JPanel panel_ContentThanhToan_1 = new JPanel();
		panel_ContentThanhToan_1.setLayout(null);
		panel_ContentThanhToan_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ContentThanhToan_1.setBackground(new Color(0, 191, 255));
		panel_ContentThanhToan_1.setBounds(10, 86, 1160, 593);
		Panel_LapHoaDon.add(panel_ContentThanhToan_1);
		
		JPanel panel_OutputListCTT_CTHD_1 = new JPanel();
		panel_OutputListCTT_CTHD_1.setLayout(null);
		panel_OutputListCTT_CTHD_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputListCTT_CTHD_1.setBounds(10, 11, 1140, 571);
		panel_ContentThanhToan_1.add(panel_OutputListCTT_CTHD_1);
		
		JLabel lblDanhSachPhiu = new JLabel("Danh Sách Phiếu Đặt Phòng :");
		lblDanhSachPhiu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDanhSachPhiu.setBounds(10, 61, 243, 27);
		panel_OutputListCTT_CTHD_1.add(lblDanhSachPhiu);
		
		JPanel panel_OutputListDSHDCTT_1 = new JPanel();
		panel_OutputListDSHDCTT_1.setLayout(null);
		panel_OutputListDSHDCTT_1.setBounds(10, 88, 488, 222);
		panel_OutputListCTT_CTHD_1.add(panel_OutputListDSHDCTT_1);
		
		table_danhSachPhieuDatPhongLHD = new JTable();
		table_danhSachPhieuDatPhongLHD.addMouseListener(Main_mouse_action);
		table_danhSachPhieuDatPhongLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_danhSachPhieuDatPhongLHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Đặt Phòng", "Số Người", "Ngày Nhận", "Ghi Chú"
			}
		));
		
		JScrollPane scrollPane_OutputListDSHDCTT_1 = new JScrollPane(table_danhSachPhieuDatPhongLHD);
		scrollPane_OutputListDSHDCTT_1.setBounds(0, 0, 488, 220);
		panel_OutputListDSHDCTT_1.add(scrollPane_OutputListDSHDCTT_1);
		
		JLabel lblMaHoan = new JLabel("Mã Hóa Đơn :");
		lblMaHoan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaHoan.setBounds(10, 11, 117, 27);
		panel_OutputListCTT_CTHD_1.add(lblMaHoan);
		
		textField_maHoaDonTHD = new JTextField();
		textField_maHoaDonTHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maHoaDonTHD.setBounds(137, 11, 143, 31);
		panel_OutputListCTT_CTHD_1.add(textField_maHoaDonTHD);
		textField_maHoaDonTHD.setColumns(10);
		
		JLabel lbl_TitleThanhToan_1_1 = new JLabel("Hóa Đơn");
		lbl_TitleThanhToan_1_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lbl_TitleThanhToan_1_1.setBounds(737, 11, 194, 53);
		panel_OutputListCTT_CTHD_1.add(lbl_TitleThanhToan_1_1);
		
		JLabel lblHoTnNhn = new JLabel("Họ Tên Nhân Viên :");
		lblHoTnNhn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHoTnNhn.setBounds(523, 87, 156, 27);
		panel_OutputListCTT_CTHD_1.add(lblHoTnNhn);
		
		JLabel lblHoTnKhach = new JLabel("Họ Tên Khách Hàng :");
		lblHoTnKhach.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHoTnKhach.setBounds(508, 125, 171, 27);
		panel_OutputListCTT_CTHD_1.add(lblHoTnKhach);
		
		JLabel lblMatPhong = new JLabel("Mã Đặt Phòng :");
		lblMatPhong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMatPhong.setBounds(555, 163, 124, 27);
		panel_OutputListCTT_CTHD_1.add(lblMatPhong);
		
		textField_hoTenNhanVienLHD = new JTextField();
		textField_hoTenNhanVienLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_hoTenNhanVienLHD.setEditable(false);
		textField_hoTenNhanVienLHD.setBounds(689, 87, 171, 27);
		panel_OutputListCTT_CTHD_1.add(textField_hoTenNhanVienLHD);
		textField_hoTenNhanVienLHD.setColumns(10);
		
		textField_hoTenKhachHangLHD = new JTextField();
		textField_hoTenKhachHangLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_hoTenKhachHangLHD.setEditable(false);
		textField_hoTenKhachHangLHD.setColumns(10);
		textField_hoTenKhachHangLHD.setBounds(689, 125, 171, 27);
		panel_OutputListCTT_CTHD_1.add(textField_hoTenKhachHangLHD);
		
		textField_maDatPhongLHD = new JTextField();
		textField_maDatPhongLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maDatPhongLHD.setEditable(false);
		textField_maDatPhongLHD.setColumns(10);
		textField_maDatPhongLHD.setBounds(689, 168, 171, 27);
		panel_OutputListCTT_CTHD_1.add(textField_maDatPhongLHD);
		
		JLabel lblDanhSachPhiu_1 = new JLabel("Danh Sách Dịch Vụ :");
		lblDanhSachPhiu_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDanhSachPhiu_1.setBounds(513, 206, 171, 27);
		panel_OutputListCTT_CTHD_1.add(lblDanhSachPhiu_1);
		
		JPanel panel_OutputListDSHDCTT_1_2 = new JPanel();
		panel_OutputListDSHDCTT_1_2.setLayout(null);
		panel_OutputListDSHDCTT_1_2.setBounds(513, 233, 617, 327);
		panel_OutputListCTT_CTHD_1.add(panel_OutputListDSHDCTT_1_2);
		
		table_danhSachDichVuLHD = new JTable();
		table_danhSachDichVuLHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Dịch Vụ", "Số Lượng", "Giá", "Thành Tiền"
			}
		));
		
		JScrollPane scrollPane_OutputListDSHDCTT_1_2 = new JScrollPane(table_danhSachDichVuLHD);
		scrollPane_OutputListDSHDCTT_1_2.setBounds(0, 0, 617, 327);
		panel_OutputListDSHDCTT_1_2.add(scrollPane_OutputListDSHDCTT_1_2);
		
		JLabel lblMaHoan_1 = new JLabel("Mã Hóa Đơn");
		lblMaHoan_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaHoan_1.setBounds(976, 87, 102, 27);
		panel_OutputListCTT_CTHD_1.add(lblMaHoan_1);
		
		lblmaHoaDonLHD = new JLabel("DP001");
		lblmaHoaDonLHD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblmaHoaDonLHD.setBounds(976, 113, 79, 19);
		panel_OutputListCTT_CTHD_1.add(lblmaHoaDonLHD);
		
		btnLapHoaDonLHD = new JButton("Lập Hóa Đơn");
		btnLapHoaDonLHD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLapHoaDonLHD.setBounds(10, 394, 154, 38);
		btnLapHoaDonLHD.addActionListener(action_Main);
		panel_OutputListCTT_CTHD_1.add(btnLapHoaDonLHD);
		
		JLabel lbl_GioRaTT_1 = new JLabel("Giờ ra :");
		lbl_GioRaTT_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl_GioRaTT_1.setBounds(10, 321, 73, 22);
		panel_OutputListCTT_CTHD_1.add(lbl_GioRaTT_1);
		
		comboBox_GioLHD = new JComboBox();
		comboBox_GioLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioLHD.setBounds(93, 321, 53, 31);
		panel_OutputListCTT_CTHD_1.add(comboBox_GioLHD);
		
		JLabel lbl_DanhSachBanHangTHD_2_3_2_1_1 = new JLabel(":");
		lbl_DanhSachBanHangTHD_2_3_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_DanhSachBanHangTHD_2_3_2_1_1.setBounds(156, 321, 11, 22);
		panel_OutputListCTT_CTHD_1.add(lbl_DanhSachBanHangTHD_2_3_2_1_1);
		
		comboBox_PhutLHD = new JComboBox();
		comboBox_PhutLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutLHD.setBounds(177, 321, 53, 31);
		panel_OutputListCTT_CTHD_1.add(comboBox_PhutLHD);
		
		dateChooserNgayLapLHD = new JDateChooser();
		dateChooserNgayLapLHD.setDateFormatString("yyyy-MM-dd");
		dateChooserNgayLapLHD.setBounds(251, 323, 183, 29);
		panel_OutputListCTT_CTHD_1.add(dateChooserNgayLapLHD);
		
		JLabel lblNgayLp = new JLabel("Ngày Lập :");
		lblNgayLp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNgayLp.setBounds(879, 168, 93, 27);
		panel_OutputListCTT_CTHD_1.add(lblNgayLp);
		
		textField_ngayLapLHD = new JTextField();
		textField_ngayLapLHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_ngayLapLHD.setEditable(false);
		textField_ngayLapLHD.setColumns(10);
		textField_ngayLapLHD.setBounds(976, 168, 154, 27);
		panel_OutputListCTT_CTHD_1.add(textField_ngayLapLHD);
		
//		màn hình cập nhật loại dịch vụ
		JPanel Panel_LoaiDichVu = new JPanel();
		Panel_LoaiDichVu.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_LoaiDichVu, "manHinhLoaiDichVu");
		
		JPanel panel_Title_QLTK_1 = new JPanel();
		panel_Title_QLTK_1.setLayout(null);
		panel_Title_QLTK_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_QLTK_1.setBackground(new Color(0, 191, 255));
		panel_Title_QLTK_1.setBounds(10, 11, 1160, 64);
		Panel_LoaiDichVu.add(panel_Title_QLTK_1);
		
		JLabel lblLoaiDichVu = new JLabel("Loại Dịch Vụ");
		lblLoaiDichVu.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblLoaiDichVu.setBounds(470, 11, 287, 53);
		panel_Title_QLTK_1.add(lblLoaiDichVu);
		
		JPanel panel_InputOutputQLTK_1 = new JPanel();
		panel_InputOutputQLTK_1.setLayout(null);
		panel_InputOutputQLTK_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQLTK_1.setBackground(new Color(0, 191, 255));
		panel_InputOutputQLTK_1.setBounds(10, 86, 1160, 593);
		Panel_LoaiDichVu.add(panel_InputOutputQLTK_1);
		
		JPanel panel_InputQLTK_1 = new JPanel();
		panel_InputQLTK_1.setLayout(null);
		panel_InputQLTK_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQLTK_1.setBounds(10, 11, 1140, 276);
		panel_InputOutputQLTK_1.add(panel_InputQLTK_1);
		
		JLabel lblNhpThngTin = new JLabel("Nhập Thông Tin Loại Dịch Vụ :");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhpThngTin.setBounds(10, 11, 321, 27);
		panel_InputQLTK_1.add(lblNhpThngTin);
		
		JLabel lblMaLoaiDich = new JLabel("Mã Loại Dịch Vụ");
		lblMaLoaiDich.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaLoaiDich.setBounds(107, 108, 137, 27);
		panel_InputQLTK_1.add(lblMaLoaiDich);
		
		textField_maLoaiDichVuLDV = new JTextField();
		textField_maLoaiDichVuLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maLoaiDichVuLDV.setColumns(10);
		textField_maLoaiDichVuLDV.setBounds(254, 104, 222, 38);
		panel_InputQLTK_1.add(textField_maLoaiDichVuLDV);
		
		btnThemLDV = new JButton("Thêm");
		btnThemLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemLDV.setBackground(Color.LIGHT_GRAY);
		btnThemLDV.setBounds(267, 208, 122, 38);
		btnThemLDV.addActionListener(action_Main);
		panel_InputQLTK_1.add(btnThemLDV);
		
		btnXoaLDV = new JButton("Xóa");
		btnXoaLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaLDV.setBackground(Color.LIGHT_GRAY);
		btnXoaLDV.setBounds(420, 208, 122, 38);
		btnXoaLDV.addActionListener(action_Main);
		panel_InputQLTK_1.add(btnXoaLDV);
		
		btnSuaLDV = new JButton("Sửa");
		btnSuaLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaLDV.setBackground(Color.LIGHT_GRAY);
		btnSuaLDV.setBounds(579, 208, 122, 38);
		btnSuaLDV.addActionListener(action_Main);
		panel_InputQLTK_1.add(btnSuaLDV);
		
		JLabel lblTnLoaiDich = new JLabel("Tên Loại Dịch Vụ");
		lblTnLoaiDich.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnLoaiDich.setBounds(608, 108, 141, 27);
		panel_InputQLTK_1.add(lblTnLoaiDich);
		
		btnXoaTrangLDV = new JButton("Xóa Trắng");
		btnXoaTrangLDV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangLDV.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangLDV.setBounds(731, 208, 122, 38);
		btnXoaTrangLDV.addActionListener(action_Main);
		panel_InputQLTK_1.add(btnXoaTrangLDV);
		
		textField_tenLoaiDichVuLDV = new JTextField();
		textField_tenLoaiDichVuLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_tenLoaiDichVuLDV.setColumns(10);
		textField_tenLoaiDichVuLDV.setBounds(759, 106, 222, 38);
		panel_InputQLTK_1.add(textField_tenLoaiDichVuLDV);
		
		JPanel panel_OutputQLTK_1 = new JPanel();
		panel_OutputQLTK_1.setLayout(null);
		panel_OutputQLTK_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputQLTK_1.setBounds(10, 298, 1140, 284);
		panel_InputOutputQLTK_1.add(panel_OutputQLTK_1);
		
		JLabel lblDanhSachLoai = new JLabel("Danh Sách Loại Dịch Vụ :");
		lblDanhSachLoai.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachLoai.setBounds(10, 11, 248, 27);
		panel_OutputQLTK_1.add(lblDanhSachLoai);
		
		JPanel panel_OutputListQLTK_1 = new JPanel();
		panel_OutputListQLTK_1.setLayout(null);
		panel_OutputListQLTK_1.setBounds(208, 38, 716, 235);
		panel_OutputQLTK_1.add(panel_OutputListQLTK_1);
		
		table_danhSachLoaiDichVuLDV = new JTable();
		table_danhSachLoaiDichVuLDV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_danhSachLoaiDichVuLDV.addMouseListener(Main_mouse_action);
		table_danhSachLoaiDichVuLDV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Loại Dịch Vụ", "Tên Loại Dịch Vụ"
			}
		));
		
		JScrollPane scrollPane_OutPutListQLTK_1 = new JScrollPane(table_danhSachLoaiDichVuLDV);
		scrollPane_OutPutListQLTK_1.setBounds(0, 0, 717, 235);
		panel_OutputListQLTK_1.add(scrollPane_OutPutListQLTK_1);
		
		JPanel Panel_LoaiChucVu = new JPanel();
		Panel_LoaiChucVu.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_LoaiChucVu, "manHinhLoaiChucVu");
		
		
		JPanel panel_Title_QLTK_1_1 = new JPanel();
		panel_Title_QLTK_1_1.setLayout(null);
		panel_Title_QLTK_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_QLTK_1_1.setBackground(new Color(0, 191, 255));
		panel_Title_QLTK_1_1.setBounds(10, 11, 1160, 64);
		Panel_LoaiChucVu.add(panel_Title_QLTK_1_1);
		
		JLabel lblLoaiChcVu = new JLabel("Loại Chức Vụ");
		lblLoaiChcVu.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblLoaiChcVu.setBounds(434, 11, 303, 53);
		panel_Title_QLTK_1_1.add(lblLoaiChcVu);
		
		JPanel panel_InputOutputQLTK_1_1 = new JPanel();
		panel_InputOutputQLTK_1_1.setLayout(null);
		panel_InputOutputQLTK_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQLTK_1_1.setBackground(new Color(0, 191, 255));
		panel_InputOutputQLTK_1_1.setBounds(10, 86, 1160, 593);
		Panel_LoaiChucVu.add(panel_InputOutputQLTK_1_1);
		
		JPanel panel_InputQLTK_1_1 = new JPanel();
		panel_InputQLTK_1_1.setLayout(null);
		panel_InputQLTK_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQLTK_1_1.setBounds(10, 11, 1140, 276);
		panel_InputOutputQLTK_1_1.add(panel_InputQLTK_1_1);
		
		JLabel lblNhpThngTin_2 = new JLabel("Nhập Thông Tin Loại Chức Vụ :");
		lblNhpThngTin_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhpThngTin_2.setBounds(10, 11, 321, 27);
		panel_InputQLTK_1_1.add(lblNhpThngTin_2);
		
		JLabel lblMaLoaiChc = new JLabel("Mã Loại Chức Vụ");
		lblMaLoaiChc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaLoaiChc.setBounds(103, 108, 141, 27);
		panel_InputQLTK_1_1.add(lblMaLoaiChc);
		
		textField_maLoaiChucVuLCV = new JTextField();
		textField_maLoaiChucVuLCV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maLoaiChucVuLCV.setColumns(10);
		textField_maLoaiChucVuLCV.setBounds(254, 104, 222, 38);
		panel_InputQLTK_1_1.add(textField_maLoaiChucVuLCV);
		
		btnThemLCV = new JButton("Thêm");
		btnThemLCV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemLCV.setBackground(Color.LIGHT_GRAY);
		btnThemLCV.setBounds(267, 208, 122, 38);
		btnThemLCV.addActionListener(action_Main);
		panel_InputQLTK_1_1.add(btnThemLCV);
		
		btnXoaLCV = new JButton("Xóa");
		btnXoaLCV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaLCV.setBackground(Color.LIGHT_GRAY);
		btnXoaLCV.setBounds(420, 208, 122, 38);
		btnXoaLCV.addActionListener(action_Main);
		panel_InputQLTK_1_1.add(btnXoaLCV);
		
		btnSuaLCV = new JButton("Sửa");
		btnSuaLCV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaLCV.setBackground(Color.LIGHT_GRAY);
		btnSuaLCV.setBounds(579, 208, 122, 38);
		btnSuaLCV.addActionListener(action_Main);
		panel_InputQLTK_1_1.add(btnSuaLCV);
		
		JLabel lblTnLoaiChc = new JLabel("Tên Loại Chức Vụ");
		lblTnLoaiChc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnLoaiChc.setBounds(604, 110, 145, 27);
		panel_InputQLTK_1_1.add(lblTnLoaiChc);
		
		btnXoaTrangLCV = new JButton("Xóa Trắng");
		btnXoaTrangLCV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangLCV.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangLCV.setBounds(731, 208, 122, 38);
		btnXoaTrangLCV.addActionListener(action_Main);
		panel_InputQLTK_1_1.add(btnXoaTrangLCV);
		
		textField_tenLoaiChucVuLCV = new JTextField();
		textField_tenLoaiChucVuLCV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_tenLoaiChucVuLCV.setColumns(10);
		textField_tenLoaiChucVuLCV.setBounds(759, 106, 222, 38);
		panel_InputQLTK_1_1.add(textField_tenLoaiChucVuLCV);
		
		JPanel panel_OutputQLTK_1_1 = new JPanel();
		panel_OutputQLTK_1_1.setLayout(null);
		panel_OutputQLTK_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputQLTK_1_1.setBounds(10, 298, 1140, 284);
		panel_InputOutputQLTK_1_1.add(panel_OutputQLTK_1_1);
		
		JLabel lblDanhSachLoai_2 = new JLabel("Danh Sách Loại Chức Vụ :");
		lblDanhSachLoai_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachLoai_2.setBounds(10, 11, 270, 27);
		panel_OutputQLTK_1_1.add(lblDanhSachLoai_2);
		
		JPanel panel_OutputListQLTK_1_1 = new JPanel();
		panel_OutputListQLTK_1_1.setLayout(null);
		panel_OutputListQLTK_1_1.setBounds(268, 38, 655, 235);
		panel_OutputQLTK_1_1.add(panel_OutputListQLTK_1_1);
		
		table_danhSachLoaiChucVuLCV = new JTable();
		table_danhSachLoaiChucVuLCV.addMouseListener(Main_mouse_action);
		table_danhSachLoaiChucVuLCV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Loại Chức Vụ", "Tên Loại Chức Vụ"
			}
		));
		
		JScrollPane scrollPane_OutPutListQLTK_1_1 = new JScrollPane(table_danhSachLoaiChucVuLCV);
		scrollPane_OutPutListQLTK_1_1.setBounds(0, 0, 656, 235);
		panel_OutputListQLTK_1_1.add(scrollPane_OutPutListQLTK_1_1);
		
//		màn hình loại phòng
		JPanel Panel_LoaiPhong = new JPanel();
		Panel_LoaiPhong.setLayout(null);
		Panel_GiaoDienManHinhTong.add(Panel_LoaiPhong, "manHinhLoaiPhong");
		
		JPanel panel_Title_QLTK_1_1_1 = new JPanel();
		panel_Title_QLTK_1_1_1.setLayout(null);
		panel_Title_QLTK_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_Title_QLTK_1_1_1.setBackground(new Color(0, 191, 255));
		panel_Title_QLTK_1_1_1.setBounds(10, 11, 1160, 64);
		Panel_LoaiPhong.add(panel_Title_QLTK_1_1_1);
		
		JLabel lblLoaiPhong_1 = new JLabel("Loại Phòng");
		lblLoaiPhong_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblLoaiPhong_1.setBounds(434, 11, 246, 53);
		panel_Title_QLTK_1_1_1.add(lblLoaiPhong_1);
		
		JPanel panel_InputOutputQLTK_1_1_1 = new JPanel();
		panel_InputOutputQLTK_1_1_1.setLayout(null);
		panel_InputOutputQLTK_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputOutputQLTK_1_1_1.setBackground(new Color(0, 191, 255));
		panel_InputOutputQLTK_1_1_1.setBounds(10, 86, 1160, 593);
		Panel_LoaiPhong.add(panel_InputOutputQLTK_1_1_1);
		
		JPanel panel_InputQLTK_1_1_1 = new JPanel();
		panel_InputQLTK_1_1_1.setLayout(null);
		panel_InputQLTK_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_InputQLTK_1_1_1.setBounds(10, 11, 1140, 276);
		panel_InputOutputQLTK_1_1_1.add(panel_InputQLTK_1_1_1);
		
		JLabel lblNhpThngTin_2_1 = new JLabel("Nhập Thông Tin Loại Phòng :");
		lblNhpThngTin_2_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNhpThngTin_2_1.setBounds(10, 11, 305, 27);
		panel_InputQLTK_1_1_1.add(lblNhpThngTin_2_1);
		
		JLabel lblMaLoaiPhong = new JLabel("Mã Loại Phòng");
		lblMaLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaLoaiPhong.setBounds(121, 62, 122, 27);
		panel_InputQLTK_1_1_1.add(lblMaLoaiPhong);
		
		textField_maLoaiPhongLP = new JTextField();
		textField_maLoaiPhongLP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maLoaiPhongLP.setColumns(10);
		textField_maLoaiPhongLP.setBounds(253, 60, 222, 38);
		panel_InputQLTK_1_1_1.add(textField_maLoaiPhongLP);
		
		btnThemLP = new JButton("Thêm");
		btnThemLP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThemLP.setBackground(Color.LIGHT_GRAY);
		btnThemLP.setBounds(267, 208, 122, 38);
		btnThemLP.addActionListener(action_Main);
		panel_InputQLTK_1_1_1.add(btnThemLP);
		
		btnXoaLP = new JButton("Xóa");
		btnXoaLP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaLP.setBackground(Color.LIGHT_GRAY);
		btnXoaLP.setBounds(420, 208, 122, 38);
		btnXoaLP.addActionListener(action_Main);
		panel_InputQLTK_1_1_1.add(btnXoaLP);
		
		btnSuaLP = new JButton("Sửa");
		btnSuaLP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSuaLP.setBackground(Color.LIGHT_GRAY);
		btnSuaLP.setBounds(579, 208, 122, 38);
		btnSuaLP.addActionListener(action_Main);
		panel_InputQLTK_1_1_1.add(btnSuaLP);
		
		JLabel lblTnLoaiPhong = new JLabel("Tên Loại Phòng");
		lblTnLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnLoaiPhong.setBounds(119, 125, 124, 27);
		panel_InputQLTK_1_1_1.add(lblTnLoaiPhong);
		
		btnXoaTrangLP = new JButton("Xóa Trắng");
		btnXoaTrangLP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangLP.setBackground(Color.LIGHT_GRAY);
		btnXoaTrangLP.setBounds(731, 208, 122, 38);
		btnXoaTrangLP.addActionListener(action_Main);
		panel_InputQLTK_1_1_1.add(btnXoaTrangLP);
		
		textField_tenLoaiPhongLP = new JTextField();
		textField_tenLoaiPhongLP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_tenLoaiPhongLP.setColumns(10);
		textField_tenLoaiPhongLP.setBounds(253, 125, 222, 38);
		panel_InputQLTK_1_1_1.add(textField_tenLoaiPhongLP);
		
		JLabel lblGiaPhong_1 = new JLabel("Giá Phòng");
		lblGiaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGiaPhong_1.setBounds(589, 62, 82, 27);
		panel_InputQLTK_1_1_1.add(lblGiaPhong_1);
		
		textField_giaPhongLP = new JTextField();
		textField_giaPhongLP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_giaPhongLP.setColumns(10);
		textField_giaPhongLP.setBounds(681, 60, 222, 38);
		panel_InputQLTK_1_1_1.add(textField_giaPhongLP);
		
		JPanel panel_OutputQLTK_1_1_1 = new JPanel();
		panel_OutputQLTK_1_1_1.setLayout(null);
		panel_OutputQLTK_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_OutputQLTK_1_1_1.setBounds(10, 298, 1140, 284);
		panel_InputOutputQLTK_1_1_1.add(panel_OutputQLTK_1_1_1);
		
		JLabel lblDanhSachLoai_2_1 = new JLabel("Danh Sách Loại Phòng");
		lblDanhSachLoai_2_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDanhSachLoai_2_1.setBounds(10, 11, 231, 27);
		panel_OutputQLTK_1_1_1.add(lblDanhSachLoai_2_1);
		
		JPanel panel_OutputListQLTK_1_1_1 = new JPanel();
		panel_OutputListQLTK_1_1_1.setLayout(null);
		panel_OutputListQLTK_1_1_1.setBounds(259, 38, 640, 235);
		panel_OutputQLTK_1_1_1.add(panel_OutputListQLTK_1_1_1);
		
		table_danhSachLoaiPhongLP = new JTable();
		table_danhSachLoaiPhongLP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_danhSachLoaiPhongLP.addMouseListener(Main_mouse_action);
		table_danhSachLoaiPhongLP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Loại Phòng", "Tên Loại Phòng", "Giá Phòng"
			}
		));
		
		JScrollPane scrollPane_OutPutListQLTK_1_1_1 = new JScrollPane(table_danhSachLoaiPhongLP);
		scrollPane_OutPutListQLTK_1_1_1.setBounds(0, 0, 641, 235);
		panel_OutputListQLTK_1_1_1.add(scrollPane_OutPutListQLTK_1_1_1);
		
	}
}
