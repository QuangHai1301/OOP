package QLKaraoke_Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import View.DangNhap;
import View.HoaDon_view;
import View.Main;
import View.ThongKe_view;
import dao.ChiTietHoaDon_dao;
import dao.ChucVu_dao;
import dao.DichVu_dao;
import dao.HoaDon_dao;
import dao.KhachHang_dao;
import dao.LoaiDichVu_dao;
import dao.LoaiPhong_dao;
import dao.NhanVien_dao;
import dao.PhieuDatPhong_dao;
import dao.Phong_dao;
import dao.QuyenHan_dao;
import dao.TaiKhoan_dao;
import dao.TrangThaiHoaDon_dao;
import dao.TrangThaiPhong_dao;
import emty.ChiTietHoaDon;
import emty.ChucVu;
import emty.DichVu;
import emty.HoaDon;
import emty.KhachHang;
import emty.LoaiDichVu;
import emty.LoaiPhong;
import emty.NhanVien;
import emty.PhieuDatPhong;
import emty.Phong;
import emty.QuyenTaiKhoan;
import emty.TaiKhoan;
import emty.TrangThaiHoaDon;
import emty.TrangThaiPhieuDatPhong;
import emty.TrangThaiPhong;
import sun.swing.text.CountingPrintable;

public class Controller_Main implements ActionListener, MouseListener {

	JFrame f;
	public Main view_main;
	public HoaDon_view hoadon_main;
	public ThongKe_view thongke_main = new ThongKe_view();;
	public DangNhap view_DangNhap;
	private TaiKhoan_dao tk_dao = new TaiKhoan_dao();
	private KhachHang_dao kh_dao = new KhachHang_dao();
	private Phong_dao p_dao = new Phong_dao();
	private NhanVien_dao nv_dao = new NhanVien_dao();
	private PhieuDatPhong_dao pdp_dao = new PhieuDatPhong_dao();
	private LoaiPhong_dao lp_dao = new LoaiPhong_dao();
	private TrangThaiPhong_dao ttp_dao = new TrangThaiPhong_dao();
	private LoaiDichVu_dao ldv_dao = new LoaiDichVu_dao();
	private DichVu_dao dv_dao = new DichVu_dao();
	private ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
	private HoaDon_dao hd_dao = new HoaDon_dao();
	private TrangThaiHoaDon_dao tthd_dao = new TrangThaiHoaDon_dao();
	private ChucVu_dao cv_dao = new ChucVu_dao();// cuong
	private QuyenHan_dao qh_dao = new QuyenHan_dao();
	private String lenhsql = null;

	public Controller_Main(Main view_main) {
		super();
		this.view_main = view_main;
	}

//	sự kiện action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
//		resset bên quản lý phiếu đặt phòng
		if(o.equals(this.view_main.btnXoaTrangTimKiempdp)) {
			this.view_main.dateChooser_timkiempdp1.setCalendar(null);
			this.view_main.dateChooser_timkiempdp2.setCalendar(null);
			this.view_main.textFieldnamekh.setText("");
			this.view_main.textField_sdt.setText("");
			this.view_main.textField_mdp.setText("");
		}
		
//		tìm kiếm bên quản lý phiếu đặt phòng
		if(o.equals(this.view_main.btnTimKiempdp)) {
			String sql = "select MaDP, SoNguoi, NgayDat, [dbo].[LoaiTrangThaiDatPhong].TenLoaiTT, GhiChu from PhieuDatPhong join KhachHang on PhieuDatPhong.MaKH=KhachHang.MaKH join LoaiTrangThaiDatPhong on PhieuDatPhong.MaLoaiTT=LoaiTrangThaiDatPhong.MaLoaiTT where ";
			int dem = 0;
			if (this.view_main.chckbxNameKH.isSelected()) {
				String tenkh = this.view_main.textFieldnamekh.getText().trim();
				if(tenkh.equals("")) {
					JOptionPane.showMessageDialog(f, "nội dung tìm kiếm không được để trống !");
				}else {
					++dem;
					if (dem == 1) {
						sql += " HoTen=" + "N'" + tenkh + "'";
					} else {
						sql += " and HoTen=" + "N'" + tenkh + "'";
					}
				}
			}

			if (this.view_main.chckbxSDTqlpdp.isSelected()) {
				String soDienThoai = this.view_main.textField_sdt.getText().trim();
				if(soDienThoai.equals("")) {
					JOptionPane.showMessageDialog(f, "nội dung tìm kiếm không được để trống !");
				}else {
					++dem;
					if (dem == 1) {
						sql += " SDT=" + "N'" + soDienThoai + "'";
					} else {
						sql += " and SDT=" + "N'" + soDienThoai + "'";
					}
				}
			}

			if (this.view_main.chckbxMaDP.isSelected()) {
				String maDP = (String) this.view_main.textField_mdp.getText().trim();
				if(maDP.equals("")) {
					JOptionPane.showMessageDialog(f, "nội dung tìm kiếm không được để trống !");
				}else {
					++dem;
					if (dem == 1) {
						sql += " maDP=" + "N'" + maDP + "'";
					} else {
						sql += " and maDP=" + "N'" + maDP + "'";
					}
				}
			}
			if (dem == 0) {
				System.out.println(1);
				ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
				lspdp = pdp_dao.getAllPhieuDatPhong();
				
				if (this.view_main.chckbxdoubletime.isSelected()) {
					Date tungay = this.view_main.dateChooser_timkiempdp1.getDate();
					Date denngay = this.view_main.dateChooser_timkiempdp2.getDate();
					if(tungay ==null || denngay == null) {
						JOptionPane.showMessageDialog(f, "Vui Lòng chọn khoảng thời gian tìm kiếm !");
					}else {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						LocalDate tungay1 = LocalDate.parse(sdf.format(tungay));
						LocalDate denngay1 = LocalDate.parse(sdf.format(denngay));
						
						ArrayList<PhieuDatPhong> lspdp1 = new ArrayList<PhieuDatPhong>();
						
						for (PhieuDatPhong phieuDatPhong : lspdp) {
							LocalDate ngaydat = LocalDate.of(phieuDatPhong.getNgayDat().getYear(), phieuDatPhong.getNgayDat().getMonth(), phieuDatPhong.getNgayDat().getDayOfMonth());
							if((tungay1.compareTo(ngaydat) == 0 || tungay1.compareTo(ngaydat) < 0) && (denngay1.compareTo(ngaydat) == 0 || denngay1.compareTo(ngaydat) > 0)) {
								lspdp1.add(phieuDatPhong);
							}
						}
						
						DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
						this.ressetTable(this.view_main.table_DanhSachPhieuDP, dModel);
						
						for (PhieuDatPhong phieuDatPhong : lspdp1) {
							dModel.addRow(new Object [] {
									phieuDatPhong.getMaDatPhong(),
									phieuDatPhong.getSoNguoi(),
									phieuDatPhong.getNgayDat(),
									phieuDatPhong.getGhiChu(),
									phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP()
							});
						}
					}
				}else {
					DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
					this.ressetTable(this.view_main.table_DanhSachPhieuDP, dModel);
					
					for (PhieuDatPhong phieuDatPhong : lspdp) {
						dModel.addRow(new Object [] {
								phieuDatPhong.getMaDatPhong(),
								phieuDatPhong.getSoNguoi(),
								phieuDatPhong.getNgayDat(),
								phieuDatPhong.getGhiChu(),
								phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP()
						});
					}
				}
			} else {
				System.out.println(2);
				ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
				lspdp = pdp_dao.getAllPhieuDatPhong_TimKiem(sql);
				
				if (this.view_main.chckbxdoubletime.isSelected()) {
					Date tungay = this.view_main.dateChooser_timkiempdp1.getDate();
					Date denngay = this.view_main.dateChooser_timkiempdp2.getDate();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					LocalDate tungay1 = LocalDate.parse(sdf.format(tungay));
					LocalDate denngay1 = LocalDate.parse(sdf.format(denngay));
					
					ArrayList<PhieuDatPhong> lspdp1 = new ArrayList<PhieuDatPhong>();
					
					for (PhieuDatPhong phieuDatPhong : lspdp) {
						LocalDate ngaydat = LocalDate.of(phieuDatPhong.getNgayDat().getYear(), phieuDatPhong.getNgayDat().getMonth(), phieuDatPhong.getNgayDat().getDayOfMonth());
						if((tungay1.compareTo(ngaydat) == 0 || tungay1.compareTo(ngaydat) < 0) && (denngay1.compareTo(ngaydat) == 0 || denngay1.compareTo(ngaydat) > 0)) {
							lspdp1.add(phieuDatPhong);
						}
					}
					
					DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
					this.ressetTable(this.view_main.table_DanhSachPhieuDP, dModel);
					
					for (PhieuDatPhong phieuDatPhong : lspdp1) {
						dModel.addRow(new Object [] {
								phieuDatPhong.getMaDatPhong(),
								phieuDatPhong.getSoNguoi(),
								phieuDatPhong.getNgayDat(),
								phieuDatPhong.getGhiChu(),
								phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP()
						});
					}
				}else {
					DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
					this.ressetTable(this.view_main.table_DanhSachPhieuDP, dModel);
					
					for (PhieuDatPhong phieuDatPhong : lspdp) {
						dModel.addRow(new Object [] {
								phieuDatPhong.getMaDatPhong(),
								phieuDatPhong.getSoNguoi(),
								phieuDatPhong.getNgayDat(),
								phieuDatPhong.getGhiChu(),
								phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP()
						});
					}
				}
			}
		}
		
//		hủy dịch vụ bên đặt dịch vụ
		if(o.equals(this.view_main.btnHuyDichVuDDV)) {
			DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSPDPTHD.getModel();
			int selectRow = this.view_main.table_OutputListDSPDPTHD.getSelectedRow();
			
			DefaultTableModel dModel1 = (DefaultTableModel) this.view_main.table_ChiTietDichVuDDV.getModel();
			int selectRow1 = this.view_main.table_ChiTietDichVuDDV.getSelectedRow();
			
			if(selectRow == -1) {
				JOptionPane.showMessageDialog(f, "Vui Lòng chọn phiếu đặt phòng !");
			}else {
				String maDP = dModel.getValueAt(selectRow, 0).toString();
				if(selectRow1 == -1) {
					JOptionPane.showMessageDialog(f, "Vui Lòng chọn dịch vụ cần hủy !");
				}else {
					String maDV = dModel1.getValueAt(selectRow1, 0).toString();
					if(!cthd_dao.Delete(maDP, maDV)) {
						JOptionPane.showMessageDialog(f, "hủy dịch vụ không thành công !");
					}else {
						JOptionPane.showMessageDialog(f, "hủy dịch vụ thành công !");
						ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
						lscthd = cthd_dao.getChiTietHoaDon_MaDP(maDP);

//						thêm thông tin dịch vụ lấy từ phiếu đặt phòng
						this.ressetTable(this.view_main.table_ChiTietDichVuDDV, dModel1);
						for (ChiTietHoaDon chiTietHoaDon : lscthd) {
							float ThanhTien = chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaDichVu().getGia();
							dModel1.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
									chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
									chiTietHoaDon.getMaDichVu().getGia(), ThanhTien });
						}
					}
				}
			}
		}
		
//		đăng xuất
		if(o.equals(this.view_main.btn_Title_DangXuat)) {
			this.view_main.setVisible(false);
			this.view_DangNhap = new DangNhap();
			this.view_DangNhap.setVisible(true);
		}
		
		
//		nhấn vào combobx bên quản lý tài khoản loại nhân viên và khách hàng
		if(o.equals(this.view_main.comboBoxKH_NV_QLTK)) {
			DefaultTableModel model = (DefaultTableModel) this.view_main.table_khachHang_nhanVienQLTK.getModel();
			this.ressetTable(this.view_main.table_khachHang_nhanVienQLTK, model);
			if(this.view_main.comboBoxKH_NV_QLTK.getSelectedIndex() == 0) {
				ArrayList<NhanVien> lsnv_emptyTK = new ArrayList<NhanVien>();
				lsnv_emptyTK = nv_dao.getAllNhanVien_NotTK();
				
				for (NhanVien nhanVien : lsnv_emptyTK) {
					model.addRow(new Object [] {
							nhanVien.getMaNhanVien(),
							nhanVien.getHoTen(),
							nhanVien.getSoDienThoai()
					});
				}
			}else {
				ArrayList<KhachHang> lskh_emptyTK = new ArrayList<KhachHang>();
				lskh_emptyTK = kh_dao.getAllKhachHang_NotTK();
				
				for (KhachHang khachHang : lskh_emptyTK) {
					model.addRow(new Object [] {
							khachHang.getMaKH(),
							khachHang.getHoTen(),
							khachHang.getSoDienThoai()
					});
				}
			}
		}
//		nhấn vào nút thanh toán bên màn hình thanh toán
		if (o.equals(this.view_main.btntThanhToanTT)) {
			int selectRow = this.view_main.table_OutputListDSHDCTT.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(view_main, "Vui Lòng chọn hóa đơn cần thanh toán !");
			} else {
				float tongTien = Float.parseFloat(this.view_main.textField_TongTienTT.getText());
				if (this.view_main.textField_1_TienNhanTTKQ.getText().equals("")) {
					JOptionPane.showMessageDialog(view_main, "Vui Lòng nhập số tiền khách đưa !");
				}else if(Float.parseFloat(this.view_main.textField_1_TienNhanTTKQ.getText()) < tongTien) {
					JOptionPane.showMessageDialog(f, "Tiền nhận phải lớn hơn tổng tiền !");
				}else {
					float tienNhan = Float.parseFloat(this.view_main.textField_1_TienNhanTTKQ.getText());
					float tienThua = tienNhan - tongTien;
					this.view_main.textField_TienThuaTTKQ.setText(tienThua + "");

					DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSHDCTT.getModel();
					String maHD = dModel.getValueAt(selectRow, 0).toString().trim();

					if (hd_dao.updateDaThanhToanHD(maHD)
							&& pdp_dao.updateTrangThaiHetHan(this.view_main.textField_maDatPhongTT.getText().trim())) {
						JOptionPane.showMessageDialog(view_main, "Thanh Toán Thành Công !");
					} else {
						JOptionPane.showMessageDialog(view_main,
								"Cập nhật trạng thái thanh toán và trạng thái phiếu đặt phòng thất bại !");
					}
				}
			}
		}

//		nhấn vào nút lập hóa đơn
		if (o.equals(this.view_main.btnLapHoaDonLHD)) {
			java.util.regex.Pattern rg = java.util.regex.Pattern.compile("^HD[0-9]{3,}$");
			String maHoaDon = this.view_main.textField_maHoaDonTHD.getText().trim();
			ArrayList<HoaDon> lskh = new ArrayList<HoaDon>();
			lskh = hd_dao.getAllHoaDon();
			int k = 0;
			for (HoaDon khachHang : lskh) {
				if(maHoaDon.equalsIgnoreCase(khachHang.getMaHoaDon())) {
					
					k = 1;
				}
			}
			if (maHoaDon.equals("") || !rg.matcher(maHoaDon).find()) {
				JOptionPane.showMessageDialog(view_main, "Mã hóa đơn không được để trống và có dạng HD001");
			}
			else if(k==1) {
				JOptionPane.showMessageDialog(view_main, "Mã khách hàng đã tồn tại");
			}
			else {
//				lấy phiếu đặt phòng
				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_danhSachPhieuDatPhongLHD.getModel();
				int selectRow = this.view_main.table_danhSachPhieuDatPhongLHD.getSelectedRow();
				if (selectRow == -1) {
					JOptionPane.showMessageDialog(view_main, "Vui Lòng chọn phiếu đặt phòng !");
				} else {
					String maDP = dModel.getValueAt(selectRow, 0).toString().trim();
					PhieuDatPhong pdp = new PhieuDatPhong();
					ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
					lspdp = pdp_dao.getAllPhieuDatPhong();
					for (PhieuDatPhong phieuDatPhong : lspdp) {
						if (phieuDatPhong.getMaDatPhong().equals(maDP)) {
							pdp = phieuDatPhong;
							break;
						}
					}

					String tenTaiKhoan = this.view_main.taiKhoanDangNhap.getTenTK();
					System.out.println(tenTaiKhoan);
					NhanVien nv = new NhanVien();
//					lấy nhân viên
					ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
					lsnv = nv_dao.getAllNhanVien();
					for (NhanVien nhanVien : lsnv) {
						if (nhanVien.getTenTaiKhoan().getTenTK().equals(tenTaiKhoan)) {
							nv = nhanVien;
							break;
						}
					}

//					lấy khách Hàng
					KhachHang kh = new KhachHang();
					ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
					dskh = kh_dao.getAllKhachHang();
					for (KhachHang khachHang : dskh) {
						if (khachHang.getMaKH().equals(pdp.getMaKhachHang().getMaKH())) {
							kh = khachHang;
							break;
						}
					}

//					ngày nhận phòng
					String ngayNhanPhong = dModel.getValueAt(selectRow, 2).toString().trim();
					LocalDateTime ngayNhanPhong1 = LocalDateTime.parse(ngayNhanPhong);
					LocalDate ngayNhanPhong2 = LocalDate.of(ngayNhanPhong1.getYear(), ngayNhanPhong1.getMonth(),
							ngayNhanPhong1.getDayOfMonth());

//					lấy thời gian lập hóa đơn
					int gioLap = (int) this.view_main.comboBox_GioLHD.getSelectedItem();
					int phutLap = (int) this.view_main.comboBox_PhutLHD.getSelectedItem();

					LocalTime gioPhutLap = LocalTime.of(gioLap, phutLap);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					LocalDate ngayLap = LocalDate.parse(sdf.format(this.view_main.dateChooserNgayLapLHD.getDate()));

					LocalDateTime ngayGioLap = null;

					if (ngayNhanPhong2.compareTo(ngayLap) == 0) {
						if (gioLap == ngayNhanPhong1.getHour() && phutLap >= ngayNhanPhong1.getMinute()) {
							ngayGioLap = LocalDateTime.of(ngayLap, gioPhutLap);
						} else if (gioLap > ngayNhanPhong1.getHour()) {
							ngayGioLap = LocalDateTime.of(ngayLap, gioPhutLap);
						} else {
							JOptionPane.showMessageDialog(view_main, "Thời gian chọn không phù hợp !");
						}
					} else if (ngayNhanPhong2.compareTo(ngayLap) > 0) {
						ngayGioLap = LocalDateTime.of(ngayLap, gioPhutLap);
					} else {
						JOptionPane.showMessageDialog(view_main,
								"Có vẻ phiếu đặt phòng của bạn đã hết hiệu lực !");
					}

					if (ngayGioLap != null) {
//						tạo hóa đơn
						TrangThaiHoaDon tthd = new TrangThaiHoaDon("LTT02", "");

						HoaDon hd = new HoaDon(maHoaDon, nv, ngayGioLap, tthd, 0);

//						thêm hóa đơn vào cơ sở dữ liệu
//						update mã hóa đơn vào chi tiết hóa đon
						if (hd_dao.insertHoaDon(hd) && cthd_dao.update(maDP, maHoaDon)) {
							JOptionPane.showMessageDialog(view_main, "Tạo hóa đơn thành công !");

							// lấy dịch vụ theo mã đặt phòng
							ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
							lscthd = cthd_dao.getChiTietHoaDon_MaDP(maDP);

							// đưa các dịch vụ vào bảng chi tiết dịch vụ
							DefaultTableModel dModel3 = (DefaultTableModel) this.view_main.table_danhSachDichVuLHD
									.getModel();
							// lấy phòng theo mã đặt phòng
							ArrayList<Phong> lsp = new ArrayList<Phong>();
							Phong p = new Phong();
							lsp = p_dao.getAllPhong();
							for (Phong phong : lsp) {
								if (phong.getMaPhong().equals(pdp.getMaPhong().getMaPhong())) {
									p = phong;
								}
							}
							// tính phòng xài trong bao nhiêu phút
							long diffInMinutes = java.time.Duration.between(pdp.getNgayGioVao(), ngayGioLap)
									.toMinutes();
							// thêm phòng vào danh sách dịch vụ
							dModel3.addRow(
									new Object[] { p.getMaPhong(), p.getTenPhong(), 1, p.getMaLoaiPhong().getGiaPhong(),
											(p.getMaLoaiPhong().getGiaPhong() / 60) * (diffInMinutes)

									});
							for (ChiTietHoaDon chiTietHoaDon : lscthd) {
								dModel3.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
										chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
										chiTietHoaDon.getMaDichVu().getGia(),
										chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaDichVu().getGia() });
							}
							// thêm dữ liệu vào các ô text
							this.view_main.textField_hoTenNhanVienLHD.setText(nv.getHoTen());
							this.view_main.textField_hoTenKhachHangLHD.setText(kh.getHoTen());
							this.view_main.textField_maDatPhongLHD.setText(maDP);
							this.view_main.lblmaHoaDonLHD.setText(maHoaDon);
							this.view_main.textField_ngayLapLHD.setText(ngayGioLap.toString());

							float tongTienDichVu = 0;
							int countRowDV = this.view_main.table_danhSachDichVuLHD.getRowCount();
							for (int i = 0; i < countRowDV; i++) {
								tongTienDichVu += Float.parseFloat(dModel3.getValueAt(i, 4).toString().trim());
							}
//							cập nhật lại tổng tiền cho hóa đơn
							if (hd_dao.updateTongTien(maHoaDon, tongTienDichVu)) {
								JOptionPane.showMessageDialog(view_main, "Cập nhật tổng tiền thành công !");
								String maDatPhong = pdp_dao.layPDP_MaHD(this.view_main.textField_maHoaDonTHD.getText().trim());
								for (PhieuDatPhong phieuDatPhong : lspdp) {
									if (phieuDatPhong.getMaDatPhong().equals(maDatPhong)) {
										pdp = phieuDatPhong;
										break;
									}
								}
								if (p_dao.updatePhongTrong(pdp.getMaPhong().getMaPhong())) {
									JOptionPane.showMessageDialog(view_main, "Reset phòng thành công !");
								} else {
									JOptionPane.showMessageDialog(view_main, "Reset phòng không thành công !");
								}
							} else {
								JOptionPane.showMessageDialog(view_main, "Cập nhật tổng tiền thất bại !");
							}
						} else {
							JOptionPane.showMessageDialog(view_main, "Tạo Hóa đơn không thành công !");
						}
					}
				}
			}
		}

//		sự kiện mở màn hình thanh toán 
		if (o.equals(view_main.mntmThanhToan)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhThanhToan");

				this.view_main.textField_hoTenNhanVienTT.setText("");
				this.view_main.textField_hoTenKhachHangTT.setText("");
				this.view_main.textField_maDatPhongTT.setText("");
				this.view_main.textField_ngayLapTT.setText("");
				this.view_main.lblMaHoaDonTT.setText("");
				this.view_main.textField_TongTienTT.setText("");
				this.view_main.textField_1_TienNhanTTKQ.setText("");
				this.view_main.textField_TienThuaTTKQ.setText("");

				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_DanhSachDichVuTT.getModel();
				this.ressetTable(this.view_main.table_DanhSachDichVuTT, dModel);

				ArrayList<HoaDon> lshd = new ArrayList<HoaDon>();
				lshd = this.hd_dao.getAllHoaDon_TrangThaiChuaThanhToan();

				ArrayList<TrangThaiHoaDon> lstthd = new ArrayList<TrangThaiHoaDon>();
				lstthd = tthd_dao.getAllTrangThaiHoaDon();

				DefaultTableModel model = (DefaultTableModel) this.view_main.table_OutputListDSHDCTT.getModel();
				this.ressetTable(this.view_main.table_OutputListDSHDCTT, model);
				for (HoaDon hoaDon : lshd) {
					TrangThaiHoaDon tthd = new TrangThaiHoaDon();
					for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
						if (trangThaiHoaDon.getMaTrangThaiHoaDon()
								.equals(hoaDon.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
							tthd = trangThaiHoaDon;
							break;
						}
					}
					model.addRow(new Object[] { hoaDon.getMaHoaDon(), hoaDon.getMaNhanVien().getMaNhanVien(),
							hoaDon.getNgayGioRa(), tthd.getTenTrangThaiHoaDon() });
				}
			}
		}

//		sự kiện mở màn hình lập hóa đơn
		if (o.equals(view_main.mntmLapHoaDon)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhLapHoaDon");
				this.resetLapHoaDon();

				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_danhSachDichVuLHD.getModel();
				this.ressetTable(this.view_main.table_danhSachDichVuLHD, dModel);

				ArrayList<PhieuDatPhong> lspdpd = new ArrayList<PhieuDatPhong>();
				lspdpd = pdp_dao.getAllPhieuDatPhong_DaNhan();

				DefaultTableModel model = (DefaultTableModel) this.view_main.table_danhSachPhieuDatPhongLHD.getModel();
				this.ressetTable(this.view_main.table_danhSachPhieuDatPhongLHD, model);

				for (PhieuDatPhong phieuDatPhong : lspdpd) {
					model.addRow(new Object[] { phieuDatPhong.getMaDatPhong(), phieuDatPhong.getSoNguoi(),
							phieuDatPhong.getNgayGioVao(), phieuDatPhong.getGhiChu() });
				}

				ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
				lsnv = nv_dao.getAllNhanVien();

				this.view_main.comboBox_GioLHD.removeAllItems();
				this.view_main.comboBox_PhutLHD.removeAllItems();

				for (int i = 0; i <= 23; i++) {
					this.view_main.comboBox_GioLHD.addItem(i);
				}
				for (int i = 0; i <= 59; i++) {
					this.view_main.comboBox_PhutLHD.addItem(i);
				}
			}
		}

//		nhấn vào nút in hóa đơn thanh toán 
		if (o.equals(this.view_main.btnInHoaDonTT)) {
			int selectRow = this.view_main.table_OutputListDSHDCTT.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(view_main, "Vui lòng chọn hóa đơn cần in !");
			}else if(this.view_main.textField_TienThuaTTKQ.getText().equals("")) {
				JOptionPane.showMessageDialog(f, "Vui lòng thanh toán trước khi in !");
			}else {
				this.hoadon_main = new HoaDon_view();
				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSHDCTT.getModel();
				String maHD = dModel.getValueAt(selectRow, 0).toString().trim();
				String ngayLap = dModel.getValueAt(selectRow, 2).toString().trim();
				float tongTien = Float.parseFloat(this.view_main.textField_TongTienTT.getText());
				float tienNhan = Float.parseFloat(this.view_main.textField_1_TienNhanTTKQ.getText());
				float tienThua = Float.parseFloat(this.view_main.textField_TienThuaTTKQ.getText());
				PhieuDatPhong pdp = new PhieuDatPhong();
				ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
				lspdp = pdp_dao.getAllPhieuDatPhong();
				for (PhieuDatPhong phieuDatPhong : lspdp) {
					if (phieuDatPhong.getMaDatPhong().equals(this.view_main.textField_maDatPhongTT.getText())) {
						pdp = phieuDatPhong;
						break;
					}
				}

				NhanVien nv = new NhanVien();
				ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
				lsnv = nv_dao.getAllNhanVien();
				for (NhanVien nhanVien : lsnv) {
					if (nhanVien.getMaNhanVien().equals(pdp.getMaNhanVien().getMaNhanVien())) {
						nv = nhanVien;
					}
				}

				KhachHang kh = new KhachHang();
				ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
				lskh = kh_dao.getAllKhachHang();
				for (KhachHang khachHang : lskh) {
					if (khachHang.getMaKH().equals(pdp.getMaKhachHang().getMaKH())) {
						kh = khachHang;
						break;
					}
				}

				ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
				lscthd = cthd_dao.getChiTietHoaDon_MaDP(pdp.getMaDatPhong());
				
				DecimalFormat formatter = new DecimalFormat("###,###,###");

				this.hoadon_main.lblmaHoaDonHD.setText(maHD);
				this.hoadon_main.lblNgayLapHD.setText(ngayLap);
				this.hoadon_main.lbltongTienHD.setText(formatter.format(tongTien)+" VND");
				this.hoadon_main.lbltienNhanHD.setText(formatter.format(tienNhan)+ " VND");
				this.hoadon_main.lbltienThuaHD.setText(formatter.format(tienThua)+ " VND");
				this.hoadon_main.lblhoTenKhachHangHD.setText(kh.getHoTen());
				this.hoadon_main.lblDiaChiHD.setText(kh.getDiaChi());
				this.hoadon_main.lblsdtHD.setText(kh.getSoDienThoai());
				this.hoadon_main.lblhoTenNhanVien.setText(nv.getHoTen());
				this.hoadon_main.lblsoDienThoai.setText(nv.getSoDienThoai());

				DefaultTableModel dModel2 = (DefaultTableModel) this.hoadon_main.table_dichvuHD.getModel();
				for (ChiTietHoaDon chiTietHoaDon : lscthd) {
					dModel2.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
							chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
							chiTietHoaDon.getMaDichVu().getGia(),
							chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaDichVu().getGia() });
				}

				Phong p = new Phong();
				ArrayList<Phong> lsp = new ArrayList<Phong>();
				lsp = p_dao.getAllPhong();
				for (Phong phong : lsp) {
					if (phong.getMaPhong().equals(pdp.getMaPhong().getMaPhong())) {
						p = phong;
						break;
					}
				}

				long diffInMinutes = java.time.Duration.between(pdp.getNgayGioVao(), LocalDateTime.parse(ngayLap))
						.toMinutes();
				System.out.println(diffInMinutes);
				dModel2.addRow(new Object[] { p.getMaPhong(), p.getTenPhong(), 1, p.getMaLoaiPhong().getGiaPhong(),
						(p.getMaLoaiPhong().getGiaPhong() / 60) * (diffInMinutes) });

				this.hoadon_main.setVisible(true);
				hoadon_main.InHoaDon(this.hoadon_main.contentPaneIsPrint);
			}
		}

//		nhấn vào nút thêm dịch vụ
		if (o.equals(this.view_main.btnThemDichVuDDV)) {
			DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSPDPTHD.getModel();
			int selectRow = this.view_main.table_OutputListDSPDPTHD.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(view_main, "Vui Lòng chọn phiếu đặt phòng cần thêm dịch vụ !");
			} else {
				String tenDV = this.view_main.comboBox_TenDichVuDDV.getSelectedItem().toString().trim();

				String maDP = this.view_main.table_OutputListDSPDPTHD.getValueAt(selectRow, 0).toString().trim();
				String regexSoLuong = "^[0-9]+$";
				java.util.regex.Pattern rg = java.util.regex.Pattern.compile(regexSoLuong);
				if (this.view_main.textField_SoLuongDDV.getText().equals("")
						|| !rg.matcher(this.view_main.textField_SoLuongDDV.getText()).find()) {
					JOptionPane.showMessageDialog(view_main,
							"Vui Lòng Nhập Số Lượng hoặc kí tự bạn nhập không hợp lệ !");
				} else {
					int soLuong = Integer.parseInt(this.view_main.textField_SoLuongDDV.getText());

//					lấy dịch vụ từ danh sách
					ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
					lsdv = dv_dao.getAllDichVu();
					DichVu dv = new DichVu();
					for (DichVu dichVu : lsdv) {
						if (dichVu.getTenDichVu().equals(tenDV)) {
							dv = dichVu;
							break;
						}
					}
					
					PhieuDatPhong pdp = new PhieuDatPhong(maDP);
					boolean checkDV = false;
					int SoLuong1 = 0;
					ArrayList<ChiTietHoaDon> lscthd1 = new ArrayList<ChiTietHoaDon>();
					ChiTietHoaDon cthd = new ChiTietHoaDon(null, dv, pdp, soLuong);
					lscthd1 = cthd_dao.getChiTietHoaDon_MaDP(pdp.getMaDatPhong());
					for (ChiTietHoaDon chiTietHoaDon : lscthd1) {
						if(cthd.getMaDatPhong().getMaDatPhong().equals(chiTietHoaDon.getMaDatPhong().getMaDatPhong()) && cthd.getMaDichVu().getMaDichVu().equals(chiTietHoaDon.getMaDichVu().getMaDichVu())) {
							checkDV = true;
							SoLuong1 = chiTietHoaDon.getSoLuong();
							break;
						}
					}
					if(checkDV) {
						if(cthd_dao.updateSL(SoLuong1+soLuong, cthd.getMaDatPhong().getMaDatPhong(), cthd.getMaDichVu().getMaDichVu())) {
							JOptionPane.showMessageDialog(view_main, "Thêm dịch vụ thành công !");
							ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
							lscthd = cthd_dao.getChiTietHoaDon_MaDP(maDP);
//							resset lại bảng chi tiết hóa đơn và combobox
							DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_ChiTietDichVuDDV
									.getModel();
							this.ressetTable(this.view_main.table_ChiTietDichVuDDV, defaultTableModel);

							for (ChiTietHoaDon chiTietHoaDon : lscthd) {
								defaultTableModel.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
										chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
										chiTietHoaDon.getMaDichVu().getGia(),
										chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaDichVu().getGia() });
							}

							this.view_main.comboBoxLoaiDichVuDDV.setSelectedIndex(0);
							this.view_main.comboBox_TenDichVuDDV.setSelectedIndex(0);
							this.view_main.textField_SoLuongDDV.setText("");
						}else {
							JOptionPane.showMessageDialog(f, "Cập Nhật số lượng không thành công !");
						}
					}else if(this.cthd_dao.addCTHD(cthd)) {
//					cập nhật chi tiết hóa đơn
						JOptionPane.showMessageDialog(view_main, "Thêm dịch vụ thành công !");
						ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
						lscthd = cthd_dao.getChiTietHoaDon_MaDP(maDP);
//						resset lại bảng chi tiết hóa đơn và combobox
						DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_ChiTietDichVuDDV
								.getModel();
						this.ressetTable(this.view_main.table_ChiTietDichVuDDV, defaultTableModel);

						for (ChiTietHoaDon chiTietHoaDon : lscthd) {
							defaultTableModel.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
									chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
									chiTietHoaDon.getMaDichVu().getGia(),
									chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaDichVu().getGia() });
						}

						this.view_main.comboBoxLoaiDichVuDDV.setSelectedIndex(0);
						this.view_main.comboBox_TenDichVuDDV.setSelectedIndex(0);
						this.view_main.textField_SoLuongDDV.setText("");
					} else {
						JOptionPane.showMessageDialog(view_main, "Thêm dịch vụ không thành công !");
					}
				}
			}
		}

//		nhấn vào nút button tính giờ trong đặt dịch vụ
		if (o.equals(this.view_main.btnBatDauTinhGioDDV)) {
			int selectRow = this.view_main.table_OutputListDSPDPTHD.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(view_main, "Vui Lòng chọn phiếu đặt phòng !");
			} else {
				String ngayGioDat = this.view_main.textField_NgayGioNhanPhongDDV.getText();
				if (!ngayGioDat.equals("null")) {
					JOptionPane.showMessageDialog(view_main, "Phòng Này đã bắt đầu tính giờ !");
				} else {
					DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSPDPTHD.getModel();
					LocalDateTime ngayGioDat1 = LocalDateTime.parse(dModel.getValueAt(selectRow, 2).toString().trim());
					LocalDate ngayGioDat11 = LocalDate.of(ngayGioDat1.getYear(), ngayGioDat1.getMonth(),
							ngayGioDat1.getDayOfMonth());

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date ngayNhan = this.view_main.dateChooserNgayLapHD.getDate();
					LocalDate date = LocalDate.parse(sdf.format(ngayNhan));
					LocalDateTime ngayGioNhan = null;

					int gioNhan = Integer.parseInt(this.view_main.comboBox_GioDDV.getSelectedItem().toString().trim());
					int phutNhan = Integer
							.parseInt(this.view_main.comboBox_PhutDDV.getSelectedItem().toString().trim());

					if (ngayGioDat11.compareTo(date) == 0) {
						if (gioNhan == ngayGioDat1.getHour() && phutNhan >= ngayGioDat1.getMinute()) {
							LocalTime time = LocalTime.of(gioNhan, phutNhan);
							ngayGioNhan = LocalDateTime.of(date, time);
						} else if (gioNhan > ngayGioDat1.getHour()) {
							LocalTime time = LocalTime.of(gioNhan, phutNhan);
							ngayGioNhan = LocalDateTime.of(date, time);
						} else {
							JOptionPane.showMessageDialog(view_main, "Giờ nhận phòng không hợp lệ !");
						}
					} else if (ngayGioDat11.compareTo(date) < 0) {
						LocalTime time = LocalTime.of(gioNhan, phutNhan);
						ngayGioNhan = LocalDateTime.of(date, time);
					} else {
						JOptionPane.showMessageDialog(view_main,
								"Phiếu đặt phòng của bạn có thể đã quá hạn !");
					}
					System.out.println(ngayGioNhan);
					if (ngayGioNhan != null) {
						String maDP = dModel.getValueAt(selectRow, 0).toString().trim();

						Phong p = new Phong();
						ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
						lspdp = pdp_dao.getAllPhieuDatPhong();
						for (PhieuDatPhong phieuDatPhong : lspdp) {
							if (phieuDatPhong.getMaDatPhong().equals(maDP)) {
								p = phieuDatPhong.getMaPhong();
								break;
							}
						}

						if (pdp_dao.updateGioNhanPhong(maDP, ngayGioNhan) && p_dao.updatePhongDuocDatKhiTinhGio(p)) {
							JOptionPane.showMessageDialog(view_main, "Cập nhật thời gian thành công !");
							this.view_main.comboBox_GioDDV.setSelectedIndex(0);
							this.view_main.comboBox_PhutDDV.setSelectedIndex(0);
							this.view_main.textField_NgayGioNhanPhongDDV.setText(ngayGioNhan.toString());
						} else {
							JOptionPane.showMessageDialog(view_main, "Cập nhật thời gian không thành công !");
						}
					}
				}
			}
		}

//		nhấn vào combobox tên dịch vụ bên đặt dịch vụ
		if (o.equals(this.view_main.comboBox_TenDichVuDDV)) {
			if (this.view_main.comboBox_TenDichVuDDV.getItemCount() > 0) {
				String tenDichVu = this.view_main.comboBox_TenDichVuDDV.getSelectedItem().toString().trim();
				DichVu dv = new DichVu();

				ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
				lsdv = dv_dao.getAllDichVu();

				for (DichVu dichVu : lsdv) {
					if (dichVu.getTenDichVu().equals(tenDichVu)) {
						dv = dichVu;
						break;
					}
				}

				this.view_main.textField_DonGiaDDV.setText(dv.getGia() + "");
			}
		}

//		nhấn vào combobox loại dịch vụ bên đặt dịch vụ
		if (o.equals(this.view_main.comboBoxLoaiDichVuDDV)) {

			this.view_main.comboBox_TenDichVuDDV.removeAllItems();

			if (this.view_main.comboBoxLoaiDichVuDDV.getItemCount() > 0) {
				String tenLoaiDichVu = this.view_main.comboBoxLoaiDichVuDDV.getSelectedItem().toString().trim();

				LoaiDichVu ldv = new LoaiDichVu();
				ArrayList<LoaiDichVu> lsldv = new ArrayList<LoaiDichVu>();
				lsldv = ldv_dao.getAllLoaiDichVu();
				for (LoaiDichVu loaiDichVu : lsldv) {
					if (loaiDichVu.getTenLoaiDichVu().equals(tenLoaiDichVu)) {
						ldv = loaiDichVu;
						break;
					}
				}

				ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
				ArrayList<DichVu> lsdv1 = new ArrayList<DichVu>();
				lsdv = dv_dao.getAllDichVu1();
				for (DichVu dichVu : lsdv) {
					if (dichVu.getLoaiDichVu().getMaLoaiDichVu().equals(ldv.getMaLoaiDichVu())) {
						lsdv1.add(dichVu);
					}
				}

				this.view_main.comboBox_TenDichVuDDV.removeAllItems();
				for (DichVu dichVu : lsdv1) {
					this.view_main.comboBox_TenDichVuDDV.addItem(dichVu.getTenDichVu());
				}
			}
		}

//		nút tìm kiếm bên tìm kiếm phòng
		if (o.equals(view_main.btnTimPhongTimKiem)) {
			String sql = "select MaPhong,TenPhong,[LoaiPhong].TenLoai,[LoaiTrangThaiPhong].TenLoaiTT,GiaPhong from phong join LoaiPhong on Phong.MaLoai=LoaiPhong.MaLoai join LoaiTrangThaiPhong on Phong.MaLoaiTT=LoaiTrangThaiPhong.MaLoaiTT where ";
			int dem = 0;
			if (this.view_main.chckbxTimPhongMaPhong.isSelected()) {
				String maphong = this.view_main.comboBoxTimPhongMaPhong.getSelectedItem().toString().trim();
				++dem;
				if (dem == 1) {
					sql += " MaPhong=" + "N'" + maphong + "'";
				} else {
					sql += " and MaPhong=" + "N'" + maphong + "'";
				}
			}

			if (this.view_main.chckbxTimPhongTenPhong.isSelected()) {
				String tenphong = this.view_main.comboBoxTimPhongTenPhong.getSelectedItem().toString().trim();
				++dem;
				if (dem == 1) {
					sql += " TenPhong=" + "N'" + tenphong + "'";
				} else {
					sql += " and TenPhong=" + "N'" + tenphong + "'";
				}
			}

			if (this.view_main.chckbxTimPhongLoaiPhong.isSelected()) {
				String loaiphong = (String) this.view_main.comboBoxTimPhongLoaiPhong.getSelectedItem();
				++dem;
				if (dem == 1) {
					sql += " TenLoai=" + "N'" + loaiphong + "'";
				} else {
					sql += " and TenLoai=" + "N'" + loaiphong + "'";
				}
			}

			if (this.view_main.chckbxTimPhongTrangThai.isSelected()) {
				String trangthai = (String) view_main.comboBoxTimPhongTrangThai.getSelectedItem();
				++dem;
				if (dem == 1) {
					sql += " TenLoaiTT=" + "N'" + trangthai + "'";
				} else {
					sql += " and TenLoaiTT=" + "N'" + trangthai + "'";
				}
			}
			if (dem == 0) {
				JOptionPane.showMessageDialog(view_main, "Vui lòng chọn thuộc tính phòng cần tìm kiếm !");
			} else {
				ArrayList<Phong> lsp = new ArrayList<Phong>();
				lsp = p_dao.getTimKiemPhong(sql);

				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTimKiemPhong
						.getModel();
				this.ressetTable(this.view_main.table_OutputListTimKiemPhong, defaultTableModel);

				this.addTableListPhongQLP(lsp, defaultTableModel);

				this.XoaTrangTKP();
			}
		}

//		nhấn vào nút sửa phòng bên quản lý phòng
		if (o.equals(this.view_main.btnQLPhongSua)) {
			int selectRow = this.view_main.table_OutputListQuanLyPhong.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(view_main, "Vui lòng chọn phòng cần sửa !");
			} else {
				String MaPhong = this.view_main.textQLPhongMaPhong.getText();
				String TenPhong = this.view_main.textQLPhongTenPhong.getText();
				String TenMaLoai = this.view_main.comboBoxQLPhongLoaiPhong.getSelectedItem().toString().trim();

//				lấy loại phòng từ tên mã loại
				LoaiPhong lp = new LoaiPhong();
				ArrayList<LoaiPhong> lslp = new ArrayList<LoaiPhong>();
				lslp = lp_dao.getAllLoaiPhong();
				for (LoaiPhong loaiPhong : lslp) {
					if (loaiPhong.getTenLoaiPhong().equals(TenMaLoai)) {
						lp = loaiPhong;
						break;
					}
				}

//				tạo phòng
				Phong p = new Phong(MaPhong, TenPhong, lp, null);

//				cập nhật phòng vào csdl
				if (this.p_dao.updatePhong(p)) {
					JOptionPane.showMessageDialog(view_main, "Cập nhật phòng thành công !");
//					add dữ liệu mới vào bảng phòng
					DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQuanLyPhong
							.getModel();
					this.ressetTable(this.view_main.table_OutputListQuanLyPhong, defaultTableModel);

					ArrayList<Phong> lsp = new ArrayList<Phong>();
					lsp = p_dao.getAllPhong();
					this.addTableListPhongQLP(lsp, defaultTableModel);

					this.XoaTrangQLP();
				} else {
					JOptionPane.showMessageDialog(view_main, "Cập nhật phòng không thành công !");
				}
			}
		}

//		nhấn vào nút xóa phòng trong quản lý phòng
		if (o.equals(this.view_main.btnQLPhongXoa)) {
			int selectRow = this.view_main.table_OutputListQuanLyPhong.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(view_main, "Vui Lòng chọn phòng cần xóa !");
			} else {
				String MaPhong = this.view_main.textQLPhongMaPhong.getText();
				if (this.p_dao.deletePhong(MaPhong)) {
					JOptionPane.showMessageDialog(view_main, "Xóa phòng thành công !");
					DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQuanLyPhong
							.getModel();
					this.ressetTable(this.view_main.table_OutputListQuanLyPhong, defaultTableModel);
					ArrayList<Phong> lsp = new ArrayList<Phong>();
					lsp = p_dao.getAllPhong();
					this.addTableListPhongQLP(lsp, defaultTableModel);

					this.XoaTrangQLP();
				} else {
					JOptionPane.showMessageDialog(view_main, "Xóa phòng thất bại !");
				}
			}
		}

//		dùng để xóa trắng quản lý phòng khi nhấp vào nút xóa trắng
		if (o.equals(this.view_main.btnQLPhongXoaTrang)) {
			this.XoaTrangQLP();
		}

//		nhấp vào nút thêm phòng
		if (o.equals(this.view_main.btnQLPhongThem)) {
//			lấy dữ liệu từ text và combobox
			String MaPhong = view_main.textQLPhongMaPhong.getText();
			String regexMaPhong = "^P[0-9]{3,}$";
			java.util.regex.Pattern rg = java.util.regex.Pattern.compile(regexMaPhong);
			if (MaPhong.equals("") || !rg.matcher(MaPhong).find()) {
				JOptionPane.showMessageDialog(view_main, "Mã Phòng không được để trống và có dạng P001");
			} else {
				String TenPhong = view_main.textQLPhongTenPhong.getText();
				if (TenPhong.equals("")) {
					JOptionPane.showMessageDialog(view_main, "Tên Phòng không được để trống");
				} else {
					String LoaiPhong1 = view_main.comboBoxQLPhongLoaiPhong.getSelectedItem().toString().trim();

//					lấy loai phòng theo tên loại phòng
					LoaiPhong lp = new LoaiPhong();
					ArrayList<LoaiPhong> lslp = new ArrayList<LoaiPhong>();
					lslp = lp_dao.getAllLoaiPhong();
					for (LoaiPhong loaiPhong : lslp) {
						if (loaiPhong.getTenLoaiPhong().equalsIgnoreCase(LoaiPhong1)) {
							lp = loaiPhong;
						}
					}

					TrangThaiPhong ttp = new TrangThaiPhong("LTT01", "");
					Phong p = new Phong(MaPhong, TenPhong, lp, ttp);

//					thêm phòng mới vào csdl
					if (p_dao.insertPhong(p)) {
						JOptionPane.showMessageDialog(view_main, "Thêm Phòng thành công !");
//						add lại dữ liệu vào bảng phòng
						DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQuanLyPhong
								.getModel();
						this.ressetTable(this.view_main.table_OutputListQuanLyPhong, defaultTableModel);
						ArrayList<Phong> lsp = new ArrayList<Phong>();
						lsp = p_dao.getAllPhong();
						this.addTableListPhongQLP(lsp, defaultTableModel);
						this.XoaTrangQLP();
					} else {
						JOptionPane.showMessageDialog(view_main, "Thêm Phòng không thành công !");
					}
				}
			}
		}

//		nhấn vào nút hủy phiếu đặt phòng
		if (o.equals(this.view_main.btnHuyQLPDP)) {

//			lấy dữ liệu từ text combobox và bảng 
			DefaultTableModel model = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
			int selectRow = this.view_main.table_DanhSachPhieuDP.getSelectedRow();
			String maDatPhong = model.getValueAt(selectRow, 0).toString().trim();
			String trangThai = "Chưa nhận";
			if(!trangThai.equalsIgnoreCase(model.getValueAt(selectRow, 4).toString().trim())) {
				JOptionPane.showMessageDialog(f, "Không thể hủy phiếu đặt phòng này !");
			}else {
//				hủy phiếu đặt phòng
				if(pdp_dao.updateTrangDaHuy(maDatPhong)) {
					JOptionPane.showMessageDialog(f, "Hủy đặt Phòng thành công !");
					
					DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_PhieuDatPhongQLPDP.getModel();
					String maPhong = dModel.getValueAt(0, 0).toString();
					
					if (p_dao.updatePhongTrong(maPhong)) {
						JOptionPane.showMessageDialog(view_main, "Reset phòng thành công !");
//						reset lại bảng và add lại dữ liệu
						this.ressetTable(this.view_main.table_DanhSachPhieuDP, model);
						ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
						lspdp = pdp_dao.getAllPhieuDatPhong();
						for (PhieuDatPhong phieuDatPhong : lspdp) {
							model.addRow(new Object[] { phieuDatPhong.getMaDatPhong(), phieuDatPhong.getSoNguoi(),
									phieuDatPhong.getNgayDat(), phieuDatPhong.getGhiChu(),
									phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP(), });
						}
					} else {
						JOptionPane.showMessageDialog(view_main, "Reset phòng không thành công !");
					}
				}else {
					JOptionPane.showMessageDialog(f, "Hủy Phòng thất bại !");
				}
			}
		}

//		nhấn vào nút sửa phiếu đặt phòng
		if (o.equals(this.view_main.btnSuaQLPDP)) {
//			lấy dữ liệu từ text combobox và bảng 
			DefaultTableModel model = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
			int selectRow = this.view_main.table_DanhSachPhieuDP.getSelectedRow();
			String maDatPhong = model.getValueAt(selectRow, 0).toString().trim();
			int soNguoi = Integer.parseInt(this.view_main.comboBox_SoNguoiQLDP.getSelectedItem().toString().trim());
			String ghiChu = this.view_main.textGhiChuKQQLPDP.getText();
			Date ngayDat = this.view_main.dateChooser_NgayDatPhongQLDP.getDate();
			int gioDat = Integer.parseInt(this.view_main.comboBox_GioQLDP.getSelectedItem().toString().trim());
			int phutDat = Integer.parseInt(this.view_main.comboBox_PhutQLDP.getSelectedItem().toString().trim());

//			gán dạng dữ liệu thời gian 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(sdf.format(ngayDat));
			LocalTime time = LocalTime.of(gioDat, phutDat);
			LocalDateTime ngayGioDatPhieu = LocalDateTime.of(date, time);

//			tạo phiếu đặt phòng
			PhieuDatPhong pdp = new PhieuDatPhong(maDatPhong, null, null, null, soNguoi, ngayGioDatPhieu, null, ghiChu,
					null);
			if(!pdp_dao.update(pdp)) {
				JOptionPane.showMessageDialog(f, "Cập nhật không thành công !");
			}else {
				JOptionPane.showMessageDialog(f, "Cập nhật thành công !");
//				reset lại bảng và add lại dữ liệu
				this.ressetTable(this.view_main.table_DanhSachPhieuDP, model);
				ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
				lspdp = pdp_dao.getAllPhieuDatPhong();
				for (PhieuDatPhong phieuDatPhong : lspdp) {
					model.addRow(new Object[] { phieuDatPhong.getMaDatPhong(), phieuDatPhong.getSoNguoi(),
							phieuDatPhong.getNgayDat(), phieuDatPhong.getGhiChu(),
							phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP(), });
				}
			}
		}

//		nhấn nút đặt phòng
		if (o.equals(this.view_main.btntDatPhongDP)) {
//			lấy dữ liệu và kiểm tra bên hai table phòng và khách hàng
			KhachHang kh = new KhachHang();
			Phong p = new Phong();
			int row = this.view_main.table_OutputListDSKHDP.getSelectedRow();
			int row1 = this.view_main.table_OutputListDSPTDP.getSelectedRow();

			if (row == -1 || row1 == -1) {
				JOptionPane.showMessageDialog(f,
						"Bạn Chưa chọn phòng muốn đặt hoặc khách hàng muốn đặt phòng !");
			} else {
//				lây khách hàng từ bảng
				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListDSKHDP
						.getModel();
				String maKhachHang = defaultTableModel.getValueAt(row, 0).toString().trim();
				ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
				lskh = kh_dao.getAllKhachHang();
				for (KhachHang khachHang : lskh) {
					if (khachHang.getMaKH().equals(maKhachHang)) {
						kh = khachHang;
						break;
					}
				}
//				lấy phòng trống từ bảng
				DefaultTableModel defaultTableModel1 = (DefaultTableModel) this.view_main.table_OutputListDSPTDP
						.getModel();
				String maPhong = defaultTableModel1.getValueAt(row1, 0).toString().trim();
				ArrayList<Phong> lsp = new ArrayList<Phong>();
				lsp = p_dao.getPhongTrong();
				for (Phong phong : lsp) {
					if (phong.getMaPhong().equals(maPhong)) {
						p = phong;
						break;
					}
				}

//				lấy thông tin từ các text và combobox
				String maDatPhong = this.view_main.textMaDatPhongKQDP.getText().trim();
				String regexMaDatPhong = "^DP[0-9]{3,}$";
				java.util.regex.Pattern rg = java.util.regex.Pattern.compile(regexMaDatPhong);
				if (maDatPhong.equals("") || !rg.matcher(maDatPhong).find()) {
					JOptionPane.showMessageDialog(f, "Mã Đặt Phòng Không được trống và có dạng DP001");
				} else {
					int soNguoi = Integer
							.parseInt(this.view_main.comboBox_SoNguoiDP.getSelectedItem().toString().trim());
					String ghiChu = this.view_main.textGhiChuKQDP.getText().trim();
					Date ngayDat = this.view_main.dateChooserNgayDatPhongDP.getDate();
					int gioDat = Integer.parseInt(this.view_main.comboBox_GioLDP.getSelectedItem().toString().trim());
					int phutDat = Integer.parseInt(this.view_main.comboBox_PhutDP.getSelectedItem().toString().trim());
					String tenTaiKhoan = this.view_main.taiKhoanDangNhap.getTenTK();
					if (ngayDat == null) {
						JOptionPane.showMessageDialog(f, "Vui Lòng chọn ngày đặt phòng !");
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						LocalDate date = LocalDate.parse(sdf.format(ngayDat));
						LocalDate dateNow = LocalDate.now();
						LocalTime time = null;
						if (date.compareTo(dateNow) < 0) {
							JOptionPane.showMessageDialog(f, "Ngày Phải lớn hơn hoặc bằng ngày hiện tại");
						} else if (date.compareTo(dateNow) == 0) {
							LocalTime timeNow = LocalTime.now();
							if (gioDat == timeNow.getHour() && phutDat >= timeNow.getMinute()) {
								time = LocalTime.of(gioDat, phutDat);
							} else if (gioDat > timeNow.getHour()) {
								time = LocalTime.of(gioDat, phutDat);
							} else {
								JOptionPane.showMessageDialog(f, "Giờ đặt không phù hợp !");
							}
						} else {
							time = LocalTime.of(gioDat, phutDat);
						}
						if (time != null) {
							LocalDateTime ngayGioDat = LocalDateTime.of(date, time);

							NhanVien nv = new NhanVien();
							TrangThaiPhieuDatPhong ttpdp = new TrangThaiPhieuDatPhong("LCV02", "");
							ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
							lsnv = nv_dao.getAllNhanVien();
							for (NhanVien nhanVien : lsnv) {
								if (nhanVien.getTenTaiKhoan().getTenTK().equalsIgnoreCase(tenTaiKhoan)) {
									nv = nhanVien;
									break;
								}
							}

//							tạo phiếu đặt phòng
							PhieuDatPhong pdp = new PhieuDatPhong(maDatPhong, p, kh, nv, soNguoi, ngayGioDat, null,
									ghiChu, ttpdp);
//							thêm phiếu đặt phòng vào cơ sở dữ liệu
//							cập nhật lại phòng thành đã được đặt
							ArrayList<PhieuDatPhong> ds = new ArrayList<PhieuDatPhong>();
							ds = pdp_dao.getAllPhieuDatPhong();
							int k = 0;
							for (PhieuDatPhong khachHang : ds) {
								if(maDatPhong.equalsIgnoreCase(khachHang.getMaDatPhong())) {
									
									k = 1;
								}
							}
							if(k==1) {
								JOptionPane.showMessageDialog(view_main, "Mã đặt phòng đã tồn tại");
							}
							else if (pdp_dao.addPDP(pdp) && p_dao.updatePhongDuocDat(p)) {

								JOptionPane.showMessageDialog(f, "Đặt Phòng Thành Công !");

//								resset lại dữ liệu bảng khách hàng
								ArrayList<KhachHang> lskh1 = new ArrayList<KhachHang>();
								lskh1 = kh_dao.getAllKhachHang();
								DefaultTableModel defaultTableModel_bangkhachhang = (DefaultTableModel) this.view_main.table_OutputListDSKHDP
										.getModel();
								this.ressetTable(view_main.table_OutputListDSKHDP, defaultTableModel_bangkhachhang);
								for (KhachHang khachHang : lskh1) {
									defaultTableModel_bangkhachhang.addRow(new Object[] { khachHang.getMaKH(),
											khachHang.getHoTen(), khachHang.getSoDienThoai(), });
								}

//								resset lại dữ liệu phòng trống
								ArrayList<Phong> lsplan2 = new ArrayList<Phong>();
								lsplan2 = p_dao.getPhongTrong();
								DefaultTableModel defaultTableMode_cuaphongtrong = (DefaultTableModel) this.view_main.table_OutputListDSPTDP
										.getModel();
								this.ressetTable(view_main.table_OutputListDSPTDP, defaultTableMode_cuaphongtrong);

								for (Phong phong : lsplan2) {
									defaultTableMode_cuaphongtrong.addRow(new Object[] { phong.getMaPhong(),
											phong.getTenPhong(), phong.getMaLoaiPhong().getTenLoaiPhong(),
											phong.getMaTrangThaiPhong().getTenTrangThaiPhong(),
											phong.getMaLoaiPhong().getGiaPhong(), });
								}
//								đưa dữ liệu lên giao diện
								this.view_main.textField_TenKhachHangKQDP.setText(kh.getHoTen());
								this.view_main.textField_SoDienThoaiKQDP.setText(kh.getSoDienThoai());
								this.view_main.textField_TenNhanVienKQDP.setText(nv.getHoTen());
								DefaultTableModel tableModel = (DefaultTableModel) this.view_main.table_PhieuDatPhongDP
										.getModel();
								tableModel.addRow(new Object[] { pdp.getMaDatPhong(), pdp.getMaPhong().getMaPhong(),
										pdp.getSoNguoi(), pdp.getNgayDat(), pdp.getGhiChu() });
//								reset lại các text
								this.view_main.textMaDatPhongKQDP.setText("");
								this.view_main.comboBox_SoNguoiDP.setSelectedIndex(0);
								this.view_main.textGhiChuKQDP.setText("");
								this.view_main.dateChooserNgayDatPhongDP.setCalendar(null);
								this.view_main.comboBox_GioLDP.setSelectedIndex(0);
								this.view_main.comboBox_PhutDP.setSelectedIndex(0);
							} else {
								JOptionPane.showMessageDialog(f, "Đặt Phòng Thất Bại !");
							}
						}
					}
				}

			}
		}

//		sự kiên khi mở màn hình trang chính
		if (o.equals(view_main.mntmTrangChinh)) {
			view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhTrangChu");
		}

//		sự kiện mở màn hình quản lý khách hàng
		if (o.equals(view_main.mntmQuanLyKhachHang)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhQuanLyKhachHang");
				ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
				lskh = kh_dao.getAllKhachHang();
				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutPutQLKH.getModel();
				this.ressetTable(view_main.table_OutPutQLKH, defaultTableModel);
				for (KhachHang khachHang : lskh) {
					defaultTableModel.addRow(new Object[] { khachHang.getMaKH(), khachHang.getHoTen(),
							khachHang.getDiaChi(), khachHang.getSoDienThoai(), });
				}
			}
		}

//		nút xóa bên quản lý khách hàng
		if (o.equals(view_main.btnXoaQLKH)) {
			delete_QLKH();
		}

//		nút sửa bên quản lý khách hàng
		if (o.equals(view_main.btnSuaQLKH)) {
			update_QLKH();
		}

// nút thêm bên quản lý khách hàng
		if (o.equals(view_main.btnThemQLKH)) {
			if (validData_QLKH()) {
				add_QLKH();
			}
		}
// nút xóa trắng bên quản lý khách hàng
		if (o.equals(view_main.btnXoaTrangQLKH)) {
			xoaTrangQLKH();
		}

//		sự kiện mở màn hình tìm kiếm khách hàng
		if (o.equals(view_main.mntmTimKiemKhachHang)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhTimKiemKhachHang");
				loadDataTimKiemKhachHang();
			}
		}

//		nút tìm kiếm bên tìm kiếm khách hàng
		if (o.equals(view_main.btnTimKHTimKiemKH)) {
			String sql = "select * from KhachHang ";
			int dem = 0;
			if (this.view_main.chckbxTimKHMaKhachHang.isSelected()) {
				String maKH = this.view_main.textMaKhachHangTimKiemKH.getText();
				++dem;
				if (dem == 1) {
					sql += "where MaKH=" + "N'" + maKH + "'";
				} else {
					sql += " and MaKH=" + "N'" + maKH + "'";
				}
			}

			if (this.view_main.chckbxTimKHHoTenKH.isSelected()) {
				String ten = this.view_main.textHoTenTimKiemKH.getText();
				++dem;
				if (dem == 1) {
					sql += "where HoTen like " + "N'%" + ten + "%'";
				} else {
					sql += " and HoTen like " + "N'%" + ten + "%'";
				}
			}

			if (this.view_main.chckbxTimKHSDTKhachHang.isSelected()) {
				String sdt = view_main.textSDTTimKiemKH.getText();
				++dem;
				if (dem == 1) {
					sql += "where SDT=" + "N'" + sdt + "'";
				} else {
					sql += " and SDT=" + "N'" + sdt + "'";
				}
			}

			if (this.view_main.chckbxTimKHDiaChiKH.isSelected()) {
				String dc = view_main.textDiaChiTimKiemKH.getText();
				++dem;
				if (dem == 1) {
					sql += "where DiaChi like " + "N'%" + dc + "%'";
				} else {
					sql += " and DiaChi like " + "N'%" + dc + "%'";
				}
			}

			ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
			ds = kh_dao.timKiemKhachHang(sql);

			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutPutTKkhachHang.getModel();
			this.ressetTable(view_main.table_OutPutTKkhachHang, defaultTableModel);
			for (KhachHang khachHang : ds) {
				defaultTableModel.addRow(new Object[] { khachHang.getMaKH(), khachHang.getHoTen(),
						khachHang.getDiaChi(), khachHang.getSoDienThoai(), });
			}
			xoaTrangTKKH();
			if (dem == 0) {
				loadDataTimKiemKhachHang();
				;
			}
		}

//		sự kiện mở màn hình quản lý nhân viên
		if (o.equals(view_main.mntmQuanLyNhanVien)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhQuanLyNhanVien");
				// 1.thêm dữ liệu vào combobox

				this.view_main.comboBoxGioiTinhQLNV.removeAllItems();
				this.view_main.comboBoxGioiTinhQLNV.addItem("Nam");
				this.view_main.comboBoxGioiTinhQLNV.addItem("Nữ");
				this.view_main.comboBoxGioiTinhQLNV.addItem("Khác");

				//
				ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
				lscv = cv_dao.getAllChucVu();
				this.view_main.comboBoxChucVuQLNV.removeAllItems();
				for (ChucVu chucVu : lscv) {
					this.view_main.comboBoxChucVuQLNV.addItem(chucVu.getTenLoaiChucVu());
					loadDataQuanLyNhanVien();

				}
			}
		}
		// LẤY DỮ LIỆU LÊN BẢNG QUẢN LÍ NHÂN VIÊN

		// NÚT XÓA QUẢN LÍ NHÂN VIÊN
		if (o.equals(view_main.btnXoaQLNV)) {
			delete_QLNV();
		}
		// NÚT SỬA QUẢN LÍ NHÂN VIÊN
		if (o.equals(view_main.btnSuaQLNV)) {
			update_QLNV();
		}
		// NÚT THÊM BÊN QUẢN LÍ NHÂN VIÊN
		if (o.equals(view_main.btnThemQLNV)) {

			add_QLNV();

		}
		// NÚT XÓA TRẮNG BÊN QUẢN LÍ NHÂN VIÊN
		if (o.equals(view_main.btnXoaTrangQLNV)) {
			xoatrangQLNV();
		}

		// SỰ KIỆN MỞ MÀN HÌNH TÌM KIẾM NHÂN VIÊN
		if (o.equals(view_main.mntmTimKiemNhanVien)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhTimKiemNhanVien");
				// reset lại các combobox

				this.view_main.comboBox_GioiTinhTKNV.removeAllItems();
				// gán giới tính vào combobox
				this.view_main.comboBox_GioiTinhTKNV.addItem("Nam");
				this.view_main.comboBox_GioiTinhTKNV.addItem("Nữ");
				this.view_main.comboBox_GioiTinhTKNV.addItem("Khác");
				//
				ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
				lscv = cv_dao.getAllChucVu();
				this.view_main.comboBox_ChucVuTKNV.removeAllItems();
				for (ChucVu chucVu : lscv) {

					this.view_main.comboBox_ChucVuTKNV.addItem(chucVu.getTenLoaiChucVu());
					loadDataTimKiemNhanVien();
				}
			}
		}

		// NÚT TÌM KIẾM NHÂN VIÊN
		if (o.equals(view_main.btnTimKiemTKNV)) {
			String sql = "select * from NhanVien";
			int dem = 0;

			if (this.view_main.chckbxMaNhanVienTKNV.isSelected()) {
				String MaNV = this.view_main.textMaNhanVienTKNV.getText();
				++dem;
				if (dem == 1) {
					sql += " where MaNV= " + "N'" + MaNV + "'";
				} else {
					sql += " and MaNV=" + "N'" + MaNV + "'";
				}
			}

			if (this.view_main.chckbxHoTenTKNV.isSelected()) {
				String ten = this.view_main.textHoTenTKNV.getText();
				++dem;
				if (dem == 1) {
					sql += " where HoTen like " + "N'%" + ten + "%'";
				} else {
					sql += " and HoTen like " + "N'%" + ten + "%'";
				}
			}
				if (this.view_main.chckbxGioiTinhTKNV.isSelected()) {
					String gioitinh = view_main.comboBox_GioiTinhTKNV.getSelectedItem().toString().trim();
					++dem;
					if (dem == 1) {
						sql+=" where GioiTinh like " + "N'%" + gioitinh + "%'";
					}else {
						sql+=" and GioiTinh like " + "N'%" + gioitinh + "%'";
					}
				}
				if (this.view_main.chckbxNgayVaoLamTKNV.isSelected()) {
					Date NgayVaoLam = view_main.dateChooser_NgayVaoLamTKNV.getDate();
					++dem;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					LocalDate date = LocalDate.parse(sdf.format(NgayVaoLam));
					int day = date.getDayOfMonth();
					int month = date.getMonthValue();
					int year = date.getYear();
					if(dem == 1) {
						sql+=" WHERE DATEPART(YYYY,NgayVaoLam)= " + year + " AND DATEPART(mm,NgayVaoLam)= " + month
								+ " AND DATEPART(DD,NgayVaoLam)= " + day;
					}else {
						sql+=" and DATEPART(YYYY,NgayVaoLam)= " + year + " AND DATEPART(mm,NgayVaoLam)= " + month
								+ " AND DATEPART(DD,NgayVaoLam)= " + day;
					}
				}
				if(this.view_main.chckbxChucVuTKNV.isSelected()) {
					String TenLoaiCV=(String) view_main.comboBox_ChucVuTKNV.getSelectedItem().toString();
					String maCV="";
					ArrayList<ChucVu> ds = new ArrayList<ChucVu>();
					ds = cv_dao.getAllChucVu();
					for (ChucVu chucVu : ds) {
						if (chucVu.getTenLoaiChucVu().equals(TenLoaiCV)) {
							maCV = chucVu.getMaLoaiChucVu();
						}
					}
					++dem;
					if (dem==1) {
						sql+=" where MaLoaiCV = " + "'" +maCV+ "'";
					}else {
						sql+="and MaLoaiCV = "+"'"+maCV+"'";
					}
				}
				
			ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
			dsnv = nv_dao.timkiemNhanVien(sql);

			ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
			lscv = cv_dao.getAllChucVu();

			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKNV.getModel();
			this.ressetTable(view_main.table_OutputListTKNV, defaultTableModel);

			for (NhanVien NhanVien : dsnv) {
				ChucVu cv = new ChucVu();
				for (ChucVu chucVu : lscv) {
					if (NhanVien.getMaLoaiChucVu().getMaLoaiChucVu().equals(chucVu.getMaLoaiChucVu())) {
						cv = chucVu;
						break;

					}
				}
				defaultTableModel.addRow(new Object[] { NhanVien.getMaNhanVien(), NhanVien.getHoTen(),
						NhanVien.getGioiTinh(), NhanVien.getDiaChi(), NhanVien.getNgayVaoLam(),
						NhanVien.getSoDienThoai(), cv.getTenLoaiChucVu() });

			}
			xoatrangKTNV();
			if (dem == 0) {
				loadDataTimKiemNhanVien();
			}

		}

//		sự kiện mở màn hình đặt phòng
		if (o.equals(view_main.mntmDatPhong)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhDatPhong");

				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_PhieuDatPhongDP.getModel();
				this.ressetTable(this.view_main.table_PhieuDatPhongDP, dModel);

//				dữ liệu vào các combobox
				for (int i = 1; i <= 9; i++) {
					this.view_main.comboBox_SoNguoiDP.addItem(i);
				}
				for (int i = 0; i <= 23; i++) {
					this.view_main.comboBox_GioLDP.addItem(i);
				}
				for (int i = 0; i <= 59; i++) {
					this.view_main.comboBox_PhutDP.addItem(i);
				}

//				dữ liệu vào bảng khách hàng
				ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
				lskh = kh_dao.getAllKhachHang();
				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListDSKHDP.getModel();
				this.ressetTable(view_main.table_OutputListDSKHDP, defaultTableModel);
				for (KhachHang khachHang : lskh) {
					defaultTableModel.addRow(
							new Object[] { khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getSoDienThoai(), });
				}

//				này là của phòng trống
				ArrayList<Phong> lsp = new ArrayList<Phong>();
				lsp = p_dao.getPhongTrong();
				DefaultTableModel defaultTableMode = (DefaultTableModel) this.view_main.table_OutputListDSPTDP.getModel();
				this.ressetTable(view_main.table_OutputListDSPTDP, defaultTableMode);

				for (Phong phong : lsp) {
					defaultTableMode.addRow(new Object[] { phong.getMaPhong(), phong.getTenPhong(),
							phong.getMaLoaiPhong().getTenLoaiPhong(), phong.getMaTrangThaiPhong().getTenTrangThaiPhong(),
							phong.getMaLoaiPhong().getGiaPhong(), });
				}
			}

		}

//		sự kiện mở màn hình quản lý phòng
		if (o.equals(view_main.mntmQuanLyPhong)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhQuanLyPhong");
//				lấy tất cả loại phòng và add vô combobox
				this.view_main.comboBoxQLPhongLoaiPhong.removeAllItems();
				ArrayList<LoaiPhong> lp = lp_dao.getAllLoaiPhong();
				for (LoaiPhong loaiPhong : lp) {
					this.view_main.comboBoxQLPhongLoaiPhong.addItem(loaiPhong.getTenLoaiPhong());
				}

//				lấy tất cả các phòng và add vô table
				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQuanLyPhong
						.getModel();
				this.ressetTable(view_main.table_OutputListQuanLyPhong, defaultTableModel);
				ArrayList<Phong> lsp = new ArrayList<Phong>();
				lsp = p_dao.getAllPhong();
				for (Phong phong : lsp) {
					defaultTableModel.addRow(new Object[] { phong.getMaPhong(), phong.getTenPhong(),
							phong.getMaLoaiPhong().getTenLoaiPhong(), phong.getMaTrangThaiPhong().getTenTrangThaiPhong(),
							phong.getMaLoaiPhong().getGiaPhong() });
				}
			}
		}

//		sự kiện mở màn hình quản lý phiếu đặt phòng
		if (o.equals(view_main.mntmCapNhatPhieuDatPhong)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_PhieuDatPhongQLPDP.getModel();
				this.ressetTable(this.view_main.table_PhieuDatPhongQLPDP, dModel);

//				load dữ liệu lên bảng phiếu đặt phòng
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong,
						"manHinhQuanLyPhieuDatPhong");
				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
				this.ressetTable(this.view_main.table_DanhSachPhieuDP, defaultTableModel);
				ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
				lspdp = pdp_dao.getAllPhieuDatPhong();
				for (PhieuDatPhong phieuDatPhong : lspdp) {
					defaultTableModel.addRow(new Object[] { phieuDatPhong.getMaDatPhong(), phieuDatPhong.getSoNguoi(),
							phieuDatPhong.getNgayDat(), phieuDatPhong.getGhiChu(),
							phieuDatPhong.getMaTrangThaiPhieuDP().getTenTrangThaiPhieuDP()

					});
				}

//				load dữ liệu vào các combobox trong quản lý phiếu đặt phòng
				for (int i = 1; i <= 9; i++) {
					this.view_main.comboBox_SoNguoiQLDP.addItem(i);
				}
				for (int i = 0; i <= 23; i++) {
					this.view_main.comboBox_GioQLDP.addItem(i);
				}
				for (int i = 0; i <= 59; i++) {
					this.view_main.comboBox_PhutQLDP.addItem(i);
				}
			}
		}

//		sự kiện mở màn hình tìm kiếm phòng
		if (o.equals(view_main.mntmTimKiemPhong)) {
			view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhTimKiemPhong");
//			reset lại các combobox
			this.view_main.comboBoxTimPhongTenPhong.removeAllItems();
			this.view_main.comboBoxTimPhongTrangThai.removeAllItems();
			this.view_main.comboBoxTimPhongLoaiPhong.removeAllItems();
//			gán loại phòng vào combobox
			ArrayList<LoaiPhong> lslp = new ArrayList<LoaiPhong>();
			lslp = lp_dao.getAllLoaiPhong();
			for (LoaiPhong loaiPhong : lslp) {
				this.view_main.comboBoxTimPhongLoaiPhong.addItem(loaiPhong.getTenLoaiPhong());
			}
//			gán trạng thái phòng vào combobox
			ArrayList<TrangThaiPhong> lsttp = new ArrayList<TrangThaiPhong>();
			lsttp = ttp_dao.getAllTrangThaiPhong();
			for (TrangThaiPhong trangThaiPhong : lsttp) {
				this.view_main.comboBoxTimPhongTrangThai.addItem(trangThaiPhong.getTenTrangThaiPhong());
			}
//			gán mã phòng và tên phòng vào combobox
			ArrayList<Phong> lsp = new ArrayList<Phong>();
			lsp = p_dao.getAllPhong();

			for (Phong phong : lsp) {
				this.view_main.comboBoxTimPhongMaPhong.addItem(phong.getMaPhong());
				this.view_main.comboBoxTimPhongTenPhong.addItem(phong.getTenPhong());
			}
//			reset table và add dữ liệu vào bảng
			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTimKiemPhong
					.getModel();
			this.ressetTable(view_main.table_OutputListTimKiemPhong, defaultTableModel);
			this.addTableListPhongQLP(lsp, defaultTableModel);
		}

//		sự kiện mở màn hình quản lý dịch vụ
		if (o.equals(view_main.mntmQuanLyDichVu)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhQuanLyDichVu");
				ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
				loadDataQLDV();// dasua
				ArrayList<LoaiDichVu> ds = new ArrayList<LoaiDichVu>();
				view_main.comboBoxLoaiDichVuQLDV.removeAllItems();
				ds = ldv_dao.getAllLoaiDichVu();
				for (LoaiDichVu LoaiDichVu : ds) {
					view_main.comboBoxLoaiDichVuQLDV.addItem(LoaiDichVu.getTenLoaiDichVu());
				}
			}
		}

//		nút xóa trắng quản lý dịch vụ
		if (o.equals(view_main.btnXoaTrangQLDV)) {
			xoaTrangQLDV();
		}
//		nút thêm quản lý dịch vụ
		if (o.equals(view_main.btnThemQLDV)) {
			if (validData_QLDV()) {
				add_QLDV();
			}
			loadDataQLDV();
		}

//		nút xóa quản lý dịch vụ
		if (o.equals(view_main.btnXoaQLDV)) {
			delete_QLDV();
		}

//		nút sửa quản lý dịch vụ
		if (o.equals(view_main.btnSuaQLDV)) {
			if (validData_QLDV()) {
				update_QLDV();
			}
			loadDataQLDV();
		}

//		sự kiện mở màn hình tìm kiếm dịch vụ
		if (o.equals(view_main.mntmTimKiemDichVu)) {
			view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhTimKiemDichVu");
			loadDataTKDV();
			loadComboboxTKDV();

		}
//		nút tìm kiếm trong tìm kiếm dịch vụ
		if (o.equals(view_main.btnTimKiemTKDV)) {
			String sql = "select [MaDV],[TenDV],[Gia],[TenLoaiDV] from DichVu join LoaiDichVu on DichVu.MaLoaiDV = LoaiDichVu.MaLoaiDV ";
			int dem = 0;
			if (this.view_main.chckbxMaDichVuTKDV.isSelected()) {
				String maDV = this.view_main.textMaDichVuTKDV.getText();
				++dem;
				if (dem == 1) {
					sql += "where MaDV=" + "N'" + maDV + "'";
				} else {
					sql += " and MaDV=" + "N'" + maDV + "'";
				}
			}

			if (this.view_main.chckbxTenDichVuTKDV.isSelected()) {
				String ten = this.view_main.textTenDichVuTKDV.getText();
				++dem;
				if (dem == 1) {
					sql += "where TenDV like " + "N'%" + ten + "%'";
				} else {
					sql += " and TenDV like " + "N'%" + ten + "%'";
				}
			}

			if (this.view_main.chckbxLoaiDichVuTKDV.isSelected()) {
				String ldv = (String) view_main.comboBox_LoaiDichVuTKDV.getSelectedItem();
				String maLDV = "";
				ArrayList<LoaiDichVu> ds = new ArrayList<LoaiDichVu>();
				ds = ldv_dao.getAllLoaiDichVu();
				for (LoaiDichVu LoaiDichVu : ds) {
					if (LoaiDichVu.getTenLoaiDichVu().equals(ldv)) {
						maLDV = LoaiDichVu.getMaLoaiDichVu();
					}
				}
				++dem;
				if (dem == 1) {
					sql += " where DichVu.MaLoaiDV = " + "N'" + maLDV + "'";
				} else {
					sql += " and DichVu.MaLoaiDV = " + "N'" + maLDV + "'";
				}
			}

			ArrayList<DichVu> ds = new ArrayList<DichVu>();
			ds = dv_dao.timKiemDichVu(sql);

			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKDV.getModel();
			this.ressetTable(view_main.table_OutputListTKDV, defaultTableModel);
			for (DichVu DichVu : ds) {
				defaultTableModel.addRow(new Object[] { DichVu.getMaDichVu(), DichVu.getTenDichVu(), DichVu.getGia(),
						DichVu.getLoaiDichVu().getTenLoaiDichVu(), });
			}
			xoaTrangTKKH();
			if (dem == 0) {
				loadDataTimKiemKhachHang();
				;
			}
		}

//		sụ kiện mở màn hình thống kê
		if (o.equals(view_main.mntmTheoNgay)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhThongKeNgay");
			}
		}
//		sự kiện nhấn nút thống kê
		if (o.equals(view_main.btnThongKeTK)) {
			String sql = "SELECT DISTINCT PDP.MaPhong, HD.MaNV, NgayGioRa, MaLoaiTTTT, TongTien FROM HoaDon HD JOIN ChiTietHoaDon CTHD ON CTHD.MaHD = HD.MaHD JOIN PhieuDatPhong PDP ON PDP.MaDP = CTHD.MaDP";
			int dem = 0;
			if (this.view_main.chckbxThongKeNgayTK.isSelected() && this.view_main.chckbx_ThongKeThangTK.isSelected()) {
				JOptionPane.showMessageDialog(view_main, "Chỉ chọn một mốc thời gian");
				this.view_main.chckbxThongKeNgayTK.setSelected(false);
				this.view_main.chckbx_ThongKeThangTK.setSelected(false);
				this.view_main.chckbx_ThongKeNamTK.setSelected(false);
			} else if (this.view_main.chckbxThongKeNgayTK.isSelected()
					&& this.view_main.chckbx_ThongKeNamTK.isSelected()) {
				JOptionPane.showMessageDialog(view_main, "Chỉ chọn một mốc thời gian");
				this.view_main.chckbxThongKeNgayTK.setSelected(false);
				this.view_main.chckbx_ThongKeNamTK.setSelected(false);
			} else if (this.view_main.chckbx_ThongKeThangTK.isSelected()
					&& this.view_main.chckbx_ThongKeNamTK.isSelected()) {
				JOptionPane.showMessageDialog(view_main, "Chỉ chọn một mốc thời gian");
				this.view_main.chckbx_ThongKeThangTK.setSelected(false);
				this.view_main.chckbx_ThongKeNamTK.setSelected(false);
			} else if (this.view_main.chckbxThongKeNgayTK.isSelected()
					&& this.view_main.chckbx_ThongKeThangTK.isSelected()
					&& this.view_main.chckbx_ThongKeNamTK.isSelected()) {
				JOptionPane.showMessageDialog(view_main, "Chỉ chọn một mốc thời gian");
				this.view_main.chckbxThongKeNgayTK.setSelected(false);
				this.view_main.chckbx_ThongKeThangTK.setSelected(false);
				this.view_main.chckbx_ThongKeNamTK.setSelected(false);
			} else if (this.view_main.chckbxThongKeNgayTK.isSelected()) {
				dem++;
				Date ngayThongKe = this.view_main.dateChooser_ThongKeNgayTK.getDate();
//				gán dạng dữ liệu thời gian 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(sdf.format(ngayThongKe));
				int day = date.getDayOfMonth();
				int month = date.getMonthValue();
				int year = date.getYear();
				sql += " WHERE DATEPART(YYYY,HD.NgayGioRa)= " + year + " AND DATEPART(mm,HD.NgayGioRa)= " + month + "AND PDP.MaLoaiTT = 'LCV04'"
						+ " AND DATEPART(DD,HD.NgayGioRa)= " + day;
				lenhsql = sql;
//				cập nhật giao diện thongke_view
				thongke_main.textField_ThoiGianThongKe.setText(date+"");
								
			} else if (this.view_main.chckbx_ThongKeThangTK.isSelected()) {
				dem++;
				int month = (int) view_main.comboBox_thangTK.getSelectedItem();
				int year = (int) view_main.comboBox_namTK.getSelectedItem();

				sql += " WHERE DATEPART(YYYY,HD.NgayGioRa)= " + year + " AND DATEPART(mm,HD.NgayGioRa)= " + month + "AND PDP.MaLoaiTT = 'LCV04'";
				lenhsql = sql;
//				cập nhật giao diện thongke_view
				thongke_main.textField_ThoiGianThongKe.setText(month+"/"+year);
			} else if (this.view_main.chckbx_ThongKeNamTK.isSelected()) {
				dem++;
				int year = (int) view_main.comboBox_nam1TK.getSelectedItem();

				sql += " WHERE DATEPART(YYYY,HD.NgayGioRa)= " + year + "AND PDP.MaLoaiTT = 'LCV04'";
				lenhsql = sql;
//				cập nhật giao diện thongke_view
				thongke_main.textField_ThoiGianThongKe.setText(""+year) ;
			}

			ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
			ds = hd_dao.xuatThongKe(sql);

			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_danhSachHoaDonTK.getModel();
			this.ressetTable(view_main.table_danhSachHoaDonTK, defaultTableModel);
		

			ArrayList<TrangThaiHoaDon> lstthd = new ArrayList<TrangThaiHoaDon>();
			lstthd = tthd_dao.getAllTrangThaiHoaDon();

			ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
			dsnv = nv_dao.getAllNhanVien();
			int count = 0;
			double tongTien = 0;
			for (HoaDon khachHang : ds) {
				TrangThaiHoaDon tthd = new TrangThaiHoaDon();
				for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
					if (trangThaiHoaDon.getMaTrangThaiHoaDon()
							.equals(khachHang.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
						tthd = trangThaiHoaDon;
						break;
					}
				}
				NhanVien nv = new NhanVien();
				for (NhanVien nhanvien : dsnv) {
					if (nhanvien.getMaNhanVien().equals(khachHang.getMaNhanVien().getMaNhanVien())) {
						nv = nhanvien;
						break;
					}
				}
				defaultTableModel.addRow(new Object[] { khachHang.getMaHoaDon(), nv.getHoTen(),
						khachHang.getNgayGioRa(), tthd.getTenTrangThaiHoaDon(), khachHang.getTongTien() });
				count++;
				tongTien += khachHang.getTongTien();
			}
			
			
			DefaultTableModel defaultTableModel1 = (DefaultTableModel) this.thongke_main.table_ThongKeDoanhThu.getModel();
			this.ressetTable(thongke_main.table_ThongKeDoanhThu, defaultTableModel1);
			for (HoaDon khachHang : ds) {
				TrangThaiHoaDon tthd = new TrangThaiHoaDon();
				for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
					if (trangThaiHoaDon.getMaTrangThaiHoaDon()
							.equals(khachHang.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
						tthd = trangThaiHoaDon;
						break;
					}
				}
				NhanVien nv = new NhanVien();
				for (NhanVien nhanvien : dsnv) {
					if (nhanvien.getMaNhanVien().equals(khachHang.getMaNhanVien().getMaNhanVien())) {
						nv = nhanvien;
						break;
					}
				}
				defaultTableModel1.addRow(new Object[] { khachHang.getMaHoaDon(), nv.getHoTen(),
						khachHang.getNgayGioRa(), tthd.getTenTrangThaiHoaDon(), khachHang.getTongTien() });
			}
			view_main.textField_TongHoaDonTK.setText(count + "");
			view_main.textField_TongDoanhThuTK.setText(tongTien + "VNĐ");
			thongke_main.textField_TongHoaDon.setText(count + "");
			thongke_main.textField_TongDoanhThu.setText(tongTien +"");
			
			if (dem == 0) {
				this.ressetTable(view_main.table_danhSachHoaDonTK, defaultTableModel);
				lenhsql = null;
				view_main.textField_TongHoaDonTK.setText("");
				view_main.textField_TongDoanhThuTK.setText("");
				thongke_main.textField_TongHoaDon.setText("");
				thongke_main.textField_TongDoanhThu.setText("");
				this.ressetTable(thongke_main.table_ThongKeDoanhThu, defaultTableModel1);
			}
		}

//		sự kiện tổng tiền tăng dần
		if (o.equals(view_main.btnTongTienTangDanTK)) {
			if (lenhsql == null) {
				JOptionPane.showMessageDialog(view_main, "Thống kê rỗng");
			} else {
				String sql1 = lenhsql;
				sql1 += " order by HD.TongTien ";
				ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
				ds = hd_dao.xuatThongKe(sql1);

				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_danhSachHoaDonTK.getModel();
				this.ressetTable(view_main.table_danhSachHoaDonTK, defaultTableModel);
			

				ArrayList<TrangThaiHoaDon> lstthd = new ArrayList<TrangThaiHoaDon>();
				lstthd = tthd_dao.getAllTrangThaiHoaDon();

				ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
				dsnv = nv_dao.getAllNhanVien();
				int count = 0;
				double tongTien = 0;
				for (HoaDon khachHang : ds) {
					TrangThaiHoaDon tthd = new TrangThaiHoaDon();
					for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
						if (trangThaiHoaDon.getMaTrangThaiHoaDon()
								.equals(khachHang.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
							tthd = trangThaiHoaDon;
							break;
						}
					}
					NhanVien nv = new NhanVien();
					for (NhanVien nhanvien : dsnv) {
						if (nhanvien.getMaNhanVien().equals(khachHang.getMaNhanVien().getMaNhanVien())) {
							nv = nhanvien;
							break;
						}
					}
					defaultTableModel.addRow(new Object[] { khachHang.getMaHoaDon(), nv.getHoTen(),
							khachHang.getNgayGioRa(), tthd.getTenTrangThaiHoaDon(), khachHang.getTongTien() });
					count++;
					tongTien += khachHang.getTongTien();
				}
				DefaultTableModel defaultTableModel1 = (DefaultTableModel) this.thongke_main.table_ThongKeDoanhThu.getModel();
				this.ressetTable(thongke_main.table_ThongKeDoanhThu, defaultTableModel1);
				for (HoaDon khachHang : ds) {
					TrangThaiHoaDon tthd = new TrangThaiHoaDon();
					for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
						if (trangThaiHoaDon.getMaTrangThaiHoaDon()
								.equals(khachHang.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
							tthd = trangThaiHoaDon;
							break;
						}
					}
					NhanVien nv = new NhanVien();
					for (NhanVien nhanvien : dsnv) {
						if (nhanvien.getMaNhanVien().equals(khachHang.getMaNhanVien().getMaNhanVien())) {
							nv = nhanvien;
							break;
						}
					}
					defaultTableModel1.addRow(new Object[] { khachHang.getMaHoaDon(), nv.getHoTen(),
							khachHang.getNgayGioRa(), tthd.getTenTrangThaiHoaDon(), khachHang.getTongTien() });
				}
				view_main.textField_TongHoaDonTK.setText(count + "");
				view_main.textField_TongDoanhThuTK.setText(tongTien + "VNĐ");
			}

		}

//		sự kiện tổng tiền giảm dần
		if (o.equals(view_main.btnTongTienGiamDanTK)) {
			if (lenhsql == null) {
				JOptionPane.showMessageDialog(view_main, "Thống kê rỗng");
			} else {
				String sql2 = lenhsql;
				sql2 += " order by HD.TongTien desc";
				ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
				ds = hd_dao.xuatThongKe(sql2);

				DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_danhSachHoaDonTK.getModel();
				this.ressetTable(view_main.table_danhSachHoaDonTK, defaultTableModel);
			

				ArrayList<TrangThaiHoaDon> lstthd = new ArrayList<TrangThaiHoaDon>();
				lstthd = tthd_dao.getAllTrangThaiHoaDon();

				ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
				dsnv = nv_dao.getAllNhanVien();
				int count = 0;
				double tongTien = 0;
				for (HoaDon khachHang : ds) {
					TrangThaiHoaDon tthd = new TrangThaiHoaDon();
					for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
						if (trangThaiHoaDon.getMaTrangThaiHoaDon()
								.equals(khachHang.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
							tthd = trangThaiHoaDon;
							break;
						}
					}
					NhanVien nv = new NhanVien();
					for (NhanVien nhanvien : dsnv) {
						if (nhanvien.getMaNhanVien().equals(khachHang.getMaNhanVien().getMaNhanVien())) {
							nv = nhanvien;
							break;
						}
					}
					defaultTableModel.addRow(new Object[] { khachHang.getMaHoaDon(), nv.getHoTen(),
							khachHang.getNgayGioRa(), tthd.getTenTrangThaiHoaDon(), khachHang.getTongTien() });
					count++;
					tongTien += khachHang.getTongTien();
				}
				DefaultTableModel defaultTableModel1 = (DefaultTableModel) this.thongke_main.table_ThongKeDoanhThu.getModel();
				this.ressetTable(thongke_main.table_ThongKeDoanhThu, defaultTableModel1);
				for (HoaDon khachHang : ds) {
					TrangThaiHoaDon tthd = new TrangThaiHoaDon();
					for (TrangThaiHoaDon trangThaiHoaDon : lstthd) {
						if (trangThaiHoaDon.getMaTrangThaiHoaDon()
								.equals(khachHang.getMaLoaiTrangThaiHoaDon().getMaTrangThaiHoaDon())) {
							tthd = trangThaiHoaDon;
							break;
						}
					}
					NhanVien nv = new NhanVien();
					for (NhanVien nhanvien : dsnv) {
						if (nhanvien.getMaNhanVien().equals(khachHang.getMaNhanVien().getMaNhanVien())) {
							nv = nhanvien;
							break;
						}
					}
					defaultTableModel1.addRow(new Object[] { khachHang.getMaHoaDon(), nv.getHoTen(),
							khachHang.getNgayGioRa(), tthd.getTenTrangThaiHoaDon(), khachHang.getTongTien() });
				}
				view_main.textField_TongHoaDonTK.setText(count + "");
				view_main.textField_TongDoanhThuTK.setText(tongTien + "VNĐ");
			}

		}
//		sự kiện in thống kê
		if (o.equals(view_main.btnInThongKe)) {
			
			java.util.Date date = new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate date1 = LocalDate.parse(sdf.format(date));
			thongke_main.textField_ngayLapTK.setText(date1 + "");

			TaiKhoan taikhoang = new TaiKhoan();
			ArrayList<TaiKhoan> lstk = new ArrayList<TaiKhoan>();
			lstk = tk_dao.getAllTaiKhoan();
			for (TaiKhoan TaiKhoang : lstk) {
				if (TaiKhoang.getTenTK().equals(view_main.lblNameTaiKhoan.getText())) {
					taikhoang = TaiKhoang;
					break;
				}
			}
			System.out.println(taikhoang.getTenTK());
			ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
			dsnv = nv_dao.getAllNhanVien();
			NhanVien nv = new NhanVien();
			for (NhanVien nhanvien : dsnv) {
				if (nhanvien.getTenTaiKhoan().getTenTK().equalsIgnoreCase(taikhoang.getTenTK())) {
					nv = nhanvien;
					break;
				}
			}
			thongke_main.textField_HoTenNhanVien.setText(nv.getHoTen());
			this.thongke_main.setVisible(true);
			thongke_main.InThongKe(this.thongke_main.contentPane);
			
			
			System.out.println(nv.getHoTen());
			System.out.println(date1);
		}
//		sự kiện mở màn hình quản lý tài khoản
		if (o.equals(view_main.mntmQuanLyTaiKhoan)) {
			view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhQuanLyTaiKhoan");
			
			this.view_main.comboBoxKH_NV_QLTK.removeAllItems();
			
			this.view_main.comboBoxKH_NV_QLTK.addItem("Nhân Viên");
			this.view_main.comboBoxKH_NV_QLTK.addItem("Khách Hàng");
			
			ArrayList<NhanVien> lsnv_emptyTK = new ArrayList<NhanVien>();
			lsnv_emptyTK = nv_dao.getAllNhanVien_NotTK();
			
			ArrayList<KhachHang> lskh_emptyKH = new ArrayList<KhachHang>();
			lskh_emptyKH = kh_dao.getAllKhachHang_NotTK();
			
			DefaultTableModel model = (DefaultTableModel) this.view_main.table_khachHang_nhanVienQLTK.getModel();
			this.ressetTable(this.view_main.table_khachHang_nhanVienQLTK, model);
			
			if(this.view_main.comboBoxKH_NV_QLTK.getSelectedIndex() == 0) {
				for (NhanVien nhanVien : lsnv_emptyTK) {
					model.addRow(new Object [] {
							nhanVien.getMaNhanVien(),
							nhanVien.getHoTen(),
							nhanVien.getSoDienThoai()
					});
				}
			}else {
				for (KhachHang khachhang : lskh_emptyKH) {
					model.addRow(new Object [] {
							khachhang.getMaKH(),
							khachhang.getHoTen(),
							khachhang.getSoDienThoai()
					});
				}
			}
			
			
			//add thêm dữ liệu vào combobox
			ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
			lsqtk = qh_dao.getALLQuyenTaiKhoan();
			this.view_main.comboBox_QuyenHanQLTK.removeAllItems();
			
			for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
				this.view_main.comboBox_QuyenHanQLTK.addItem(quyenTaiKhoan.getTenQuyen());
			}
			//load dữ liệu lên bảng
			loadDataQuanLyTK();
		}
		if (o.equals(view_main.btnThemQLTK)) {
			add_QLTK();
			loadDataQuanLyTK();
		}
	
		if (o.equals(view_main.btnXoaQLTK)) {
			delete_QLTK();
		}
		
		if (o.equals(view_main.btnSuaQLTK)) {
			update_QLTK();
		}
		 
		if (o.equals(view_main.btnXoaTrangQLTK)) {
			xoatrangQLTK();
		}
		
	

//		sự kiện mở màn hình tìm kiếm tài khoản
		if (o.equals(view_main.mntmTimKiemTaiKhoan)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhTimKiemTaiKhoan");
				//add thêm dữ liệu vào combobox
				ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
				lsqtk = qh_dao.getALLQuyenTaiKhoan();
				this.view_main.comboBox_QuyenHanTKTK.removeAllItems();
				for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
					
					this.view_main.comboBox_QuyenHanTKTK.addItem(quyenTaiKhoan.getTenQuyen());
					//load dữ liệu lên bảng
					loadDataQuanLyTKTK();
					
				}
			}
		}
		if (o.equals(view_main.btnTimKiemTKTK)) {
			
			//String sql = "select [TenTK],[MK],[TenQuyen] from TaiKhoan join LoaiQuyen on TaiKhoan.MaQuyen = LoaiQuyen.MaQuyen ";

			String sql = "select * from TaiKhoan";
			int dem = 0;
			if(this.view_main.chckbxTenTaiKhoanTKTK.isSelected()) {
				String tenTK= this.view_main.textTenTaiKhoanTKTK.getText();
				++dem;
				if(dem == 1) {
					sql+= " where TenTK= "+"N'"+tenTK+"'";
				}else {
					sql+= " and TenTK="+"N'"+tenTK+"'";
				}
		}
			if (this.view_main.chckbxQuyenHanTKTK.isSelected()) {
				String lqh = (String) view_main.comboBox_QuyenHanTKTK.getSelectedItem();
				String maQH= "";
				ArrayList<QuyenTaiKhoan> ds = new ArrayList<QuyenTaiKhoan>();
				ds =qh_dao.getALLQuyenTaiKhoan();
				for (QuyenTaiKhoan quyenTaiKhoan : ds) {
					if (quyenTaiKhoan.getTenQuyen().equals(lqh)) {
						maQH= quyenTaiKhoan.getMaQuyen();
					}
				}
				++dem;
				if (dem == 1) {
					sql+=" where MaQuyen = "+"N'"+maQH+"'";
				}else {
					sql+=" and MaQuyen = "+"N'"+maQH+"'";
				}
			}
//			ArrayList<TaiKhoan> tk = new ArrayList<TaiKhoan>();
//			tk = tk_dao.timkiemTaiKhoan(sql);
//			
//			ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
//			lsqtk = qh_dao.getALLQuyenTaiKhoan();
//			
//			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKTK.getModel();
//			this.ressetTable(view_main.table_OutputListTKTK, defaultTableModel);
//			
//			for (TaiKhoan taiKhoan : tk) {
//				QuyenTaiKhoan qtk = new QuyenTaiKhoan();
//				for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
//					if (taiKhoan.getMaQuyen().getMaQuyen().equals(quyenTaiKhoan.getMaQuyen())) {
//						qtk = quyenTaiKhoan;
//						break;
//					}
//				}		
//			
//				defaultTableModel.addRow(new Object[] { 
//						taiKhoan.getTenTK(),
//						taiKhoan.getMK(),
//						qtk.getTenQuyen()
//				});
//			}
//			xoatrangTKTK();
//			if(dem == 0) {
//				loadDataQuanLyTKTK();
//			}
			ArrayList<TaiKhoan> tk = new ArrayList<TaiKhoan>();
			tk = tk_dao.timkiemTaiKhoan(sql);
			
			ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
			lsqtk = qh_dao.getALLQuyenTaiKhoan();
			
			DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKTK.getModel();
			this.ressetTable(view_main.table_OutputListTKTK, defaultTableModel);
			
			for (TaiKhoan taiKhoan : tk) {
				QuyenTaiKhoan qtk = new QuyenTaiKhoan();
				for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
					if (taiKhoan.getMaQuyen().getMaQuyen().equals(quyenTaiKhoan.getMaQuyen())) {
						qtk = quyenTaiKhoan;
						break;
					}
				}		
			
				defaultTableModel.addRow(new Object[] { 
						taiKhoan.getTenTK(),
						taiKhoan.getMK(),
						qtk.getTenQuyen()
				
					});
			}
		}
		
		//-------------------------cuong----------------------------		
//		sự kiện mở màn hình loại chức vụ
		if (o.equals(view_main.mntmLoaiChucVu)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhLoaiChucVu");
				loadDataChucVu();
			}
		}
		if(o.equals(view_main.btnThemLCV)){
			if(validData_QLCV()) {
				add_QLCV();
			}
			loadDataChucVu();
		}
			if (o.equals(view_main.btnSuaLCV)) {
				update_QLCV();
			}
			if (o.equals(view_main.btnXoaLCV)) {
				delete_QLCV();
				
			}
			if (o.equals(view_main.btnXoaTrangLCV)) {
				xoatrangQLCV();
			}
		
//-------------------------cuong----------------------------	
		
//			sự kiện mở màn hình loại dịch vụ
		if (o.equals(view_main.mntmLoaiDichVu)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhLoaiDichVu");
				loadDataLoaiDichVu();
			}
		}
//			nút xóa trắng quản lý loại dịch vụ
		if (o.equals(view_main.btnXoaTrangLDV)) {
			xoaTrangQLLDV();
		}
//			nút thêm quản lý loại dịch vụ
		if (o.equals(view_main.btnThemLDV)) {
			if (validData_QLLDV()) {
				add_QLLDV();
				xoaTrangQLLDV();
			}
			loadDataLoaiDichVu();
		}

//			nút xóa quản lý loại dịch vụ
		if (o.equals(view_main.btnXoaLDV)) {
			delete_QLLDV();
		}

//			nút sửa quản lý loại dịch vụ
		if (o.equals(view_main.btnSuaLDV)) {
			if (validData_QLLDV()) {
				update_QLLDV();
			}

		}
		
//		sự kiện mở màn hình loại phòng
		if (o.equals(view_main.mntmLoaiPhong)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(!a.equals("LQ02")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhLoaiPhong");
				loadDataLoaiPhong();
			}
		}
//		nút xóa trắng quản lý loại phòng
		if (o.equals(view_main.btnXoaTrangLP)) {
			xoaTrangQLLP();
		}
//		nút thêm quản lý loại phòng
		if (o.equals(view_main.btnThemLP)) {
			if (validData_QLLP()) {
				add_QLLP();
				xoaTrangQLLP();
			}
			loadDataLoaiPhong();
		}

//		nút xóa quản lý loại phòng
		if (o.equals(view_main.btnXoaLP)) {
			delete_QLLP();
		}

//		nút sửa quản lý loại phòng
		if (o.equals(view_main.btnSuaLP)) {
			if (validData_QLLP()) {
				update_QLLP();
			}

		}
//		sự kiện mở màn hình Đặt Dịch Vụ
		if(o.equals(view_main.mntmDatDichVu)) {
			String a = this.view_main.taiKhoanDangNhap.getMaQuyen().getMaQuyen().toString().trim();
			if(a.equals("LQ03")) {
				JOptionPane.showMessageDialog(f, "Bạn không có quyền truy cập chức năng này");
			}else {
				view_main.cl_Panel_GiaoDienManHinhTong.show(view_main.Panel_GiaoDienManHinhTong, "manHinhDatDichVu");
				
				this.view_main.comboBox_GioDDV.removeAllItems();
				this.view_main.comboBox_PhutDDV.removeAllItems();
				this.view_main.comboBoxLoaiDichVuDDV.removeAllItems();
				this.view_main.comboBox_TenDichVuDDV.removeAllItems();
				
				for (int i = 0; i <= 23; i++) {
					this.view_main.comboBox_GioDDV.addItem(i);
				}
				for (int i = 0; i <= 59; i++) {
					this.view_main.comboBox_PhutDDV.addItem(i);
				}
				
				ArrayList<LoaiDichVu> lsldv = new ArrayList<LoaiDichVu>();
				lsldv = ldv_dao.getAllLoaiDichVu();
				for (LoaiDichVu loaiDichVu : lsldv) {
					this.view_main.comboBoxLoaiDichVuDDV.addItem(loaiDichVu.getTenLoaiDichVu());
				}
				
				ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
				lsdv = dv_dao.getAllDichVu();
				for (DichVu dichVu : lsdv) {
					if(dichVu.equals(this.view_main.comboBoxLoaiDichVuDDV.getSelectedItem().toString().trim())) {
						this.view_main.comboBox_TenDichVuDDV.addItem(dichVu.getTenDichVu());
					}
				}
				
				ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
				lspdp = pdp_dao.getAllPhieuDatPhong_CoTheDatDV();
				DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSPDPTHD.getModel();
				this.ressetTable(this.view_main.table_OutputListDSPDPTHD, dModel);
				for (PhieuDatPhong phieuDatPhong : lspdp) {
					dModel.addRow(new Object [] {
							phieuDatPhong.getMaDatPhong(),
							phieuDatPhong.getSoNguoi(),
							phieuDatPhong.getNgayDat(),
							phieuDatPhong.getGhiChu()
					});
				}
			}
			
		}

	}

//	hàm xóa trắng bên quản lí nhân viên
	public void xoatrangQLNV() {
		view_main.textMaNhanVienQLNV.setText("");
		view_main.textHoTenQLNV.setText("");
		this.view_main.comboBoxGioiTinhQLNV.setSelectedIndex(0);
		view_main.textDiaChiQLNV.setText("");
		view_main.textSDTQLNV.setText("");
		this.view_main.dateChooserNgayVaoLamQLNV.setCalendar(null);
		this.view_main.comboBoxChucVuQLNV.setSelectedIndex(0);
		
		
	}
	public void xoatrangKTNV() {
		view_main.textMaNhanVienTKNV.setText("");
		view_main.textHoTenTKNV.setText("");
		view_main.comboBox_GioiTinhTKNV.setSelectedItem("");
		view_main.dateChooser_NgayVaoLamTKNV.setDateFormatString(null);
		view_main.comboBox_ChucVuTKNV.setSelectedItem("");
	}
	
	//	lấy dữ liệu trong quản lý nhân viên
	
	public void loadDataQuanLyNhanVien() {
		ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
		lsnv = nv_dao.getAllNhanVien();
		ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
		lscv = cv_dao.getAllChucVu();
	
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQLNV.getModel();
		this.ressetTable(view_main.table_OutputListQLNV, defaultTableModel);
	
		for (NhanVien NhanVien : lsnv) {
			ChucVu cv = new ChucVu();
			for (ChucVu chucVu : lscv) {
				if (NhanVien.getMaLoaiChucVu().getMaLoaiChucVu().equals(chucVu.getMaLoaiChucVu())) {
					cv = chucVu;
					break;
				}
			
			}
			
			defaultTableModel.addRow(new Object[] { 
					NhanVien.getMaNhanVien(),
					NhanVien.getHoTen(),
					NhanVien.getGioiTinh(),
					NhanVien.getDiaChi(),
					NhanVien.getSoDienThoai(),
					NhanVien.getNgayVaoLam(),
					cv.getTenLoaiChucVu()
					
					
							
			});
		}
	}	
	
	//CẬP NHẬT NHÂN VIÊN TRONG QUẢN LÍ NHÂN VIÊN
	public void update_QLNV() {
		int row = view_main.table_OutputListQLNV.getRowCount();
		if (row >= 0) {
			String ma = view_main.textMaNhanVienQLNV.getText();
			String tenNV = view_main.textHoTenQLNV.getText();
			String gioiTinh =  view_main.comboBoxGioiTinhQLNV.getSelectedItem().toString();
			String diaChi = view_main.textDiaChiQLNV.getText();
			String SDT = view_main.textSDTQLNV.getText();
			SimpleDateFormat nvl = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate ngayVaoLam = LocalDate.parse(nvl.format(this.view_main.dateChooserNgayVaoLamQLNV.getDate()));
			String tenChucVu = view_main.comboBoxChucVuQLNV.getSelectedItem().toString();
			
			ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
			lscv = cv_dao.getAllChucVu();
			ChucVu cv = new ChucVu();
			for (ChucVu chucVu2 : lscv) {
				if (tenChucVu.equals(chucVu2.getTenLoaiChucVu())) {
					cv = chucVu2;
					break;
				}
			}
			NhanVien nv = new NhanVien(ma, tenNV, gioiTinh, diaChi, SDT, ngayVaoLam, cv,null);
			if (nv_dao.update(nv)) {
				loadDataQuanLyNhanVien();
				JOptionPane.showMessageDialog(view_main, "Cập Nhật Thành Công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Cập Nhật Không Thành Công");
			}
		}
	}
	//THÊM NHÂN VIÊN TRONG QUAN LÍ NHÂN VIÊN
	public void add_QLNV() {
		int row = view_main.table_OutputListQLNV.getRowCount();
		if (row >= 0) {
			
			String ma = view_main.textMaNhanVienQLNV.getText();
			String tenNV = view_main.textHoTenQLNV.getText();
			String gioiTinh =  view_main.comboBoxGioiTinhQLNV.getSelectedItem().toString();
			String diaChi = view_main.textDiaChiQLNV.getText();
			String SDT = view_main.textSDTQLNV.getText();
			//String ngayVaoLam = view_main.dateChooserNgayVaoLamQLNV.getDate().toString();
			SimpleDateFormat nvl = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate ngayVaoLam = LocalDate.parse(nvl.format(this.view_main.dateChooserNgayVaoLamQLNV.getDate()));
			String tenChucVu = view_main.comboBoxChucVuQLNV.getSelectedItem().toString();
			
			ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
			lscv = cv_dao.getAllChucVu();
			ChucVu cv = new ChucVu();
			for (ChucVu chucVu2 : lscv) {
				if (tenChucVu.equals(chucVu2.getTenLoaiChucVu())) {
					cv = chucVu2;
					break;
				}
			}
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			ds = nv_dao.getAllNhanVien();
			int k = 0;
			for (NhanVien khachHang : ds) {
				if(ma.equalsIgnoreCase(khachHang.getMaNhanVien())) {
					JOptionPane.showMessageDialog(view_main, "Mã nhân viên đã tồn tại");
					k = 1;
				}
			}
			if(k==0) {
				NhanVien nv = new NhanVien(ma, tenNV, gioiTinh, diaChi, SDT, ngayVaoLam, cv, null);
				if (nv_dao.add(nv)) {
					loadDataQuanLyNhanVien();
					JOptionPane.showMessageDialog(view_main, "Thêm Thành Công");
				} else {
					JOptionPane.showMessageDialog(view_main, "Thêm Không Thành Công");
				}
			}
			
		}
	}
	//XÓA NHÂN VIÊN TRONG QUÁN LÍ NHÂN VIÊN
	public void delete_QLNV() {
		int row = view_main.table_OutputListQLNV.getSelectedRow();
		if(row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Bạn có muốn xóa nhân viên này", "Xóa", JOptionPane.YES_NO_OPTION);
			if(ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_OutputListQLNV.getValueAt(row, 0);
				nv_dao.delete(ma);
				loadDataQuanLyNhanVien();
				xoatrangQLNV();
			}
			
		}
	}
	//	HIỂN THỊ THÔNG BÁO LỖI SAI BIỂU THỨC CHÍNH QUY
	public void showMessage1(String a, JTextField b) {
		b.requestFocus();
		JOptionPane.showMessageDialog(null, a);
	}
//	BIỂU THỨC CHÍNH QUY CỦA QUẢN LÍ NHÂN VIÊN
	public boolean validData_QLNV() {
		String ma = view_main.textMaNhanVienQLNV.getText().trim();
		String tenNV = view_main.textHoTenQLNV.getText().trim();
		String gioiTinh =  view_main.comboBoxGioiTinhQLNV.getSelectedItem().toString().trim();
		String diaChi = view_main.textDiaChiQLNV.getText().trim();
		String SDT = view_main.textSDTQLNV.getText().trim();
		String ngayVaoLam = view_main.dateChooserNgayVaoLamQLNV.getDate().toString().trim();
		String chucVu = view_main.comboBoxChucVuQLNV.getSelectedItem().toString().trim();
		if(!(ma.length() > 0)) {
			showMessage1("Bạn chưa nhập mã nhân viên", view_main.textMaNhanVienQLNV);
			return false;
		}
		if(ma.matches("^[A-Z]+\\d{3}") == false) {
			showMessage1("Mã nhân viên bao gồm chữ in hoa và số", view_main.textMaNhanVienQLNV);
			return false;
		}
		if(!(tenNV.length() > 0)) {
			showMessage1("Bạn chưa nhập tên", view_main.textHoTenQLNV);
			return false;
		}
		if(!(SDT.length() > 0)) {
			showMessage1("Bạn chưa nhập số điện thoại", view_main.textSDTQLNV);
			return false;
		}
		if(!(diaChi.length() > 0)) {
			showMessage1("Bạn chưa nhập địa chỉ", view_main.textDiaChiQLNV);
			return false;
		}
		
		return true;
	}
// LẤY DỮ LIỆU TÌM KIẾM NHÂN VIÊN
	public void loadDataTimKiemNhanVien() {
		ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
		lsnv = nv_dao.getAllNhanVien();
		
		ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
		lscv = cv_dao.getAllChucVu();
	
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKNV.getModel();
		this.ressetTable(view_main.table_OutputListTKNV, defaultTableModel);
		
		
		for (NhanVien NhanVien : lsnv) {
			ChucVu cv = new ChucVu();
			for (ChucVu chucVu : lscv) {
				if (NhanVien.getMaLoaiChucVu().getMaLoaiChucVu().equals(chucVu.getMaLoaiChucVu())) {
					cv = chucVu;
					break;
					
				}
			}
			defaultTableModel.addRow(new Object[] { 
					NhanVien.getMaNhanVien(),
					NhanVien.getHoTen(),
					NhanVien.getGioiTinh(),
					NhanVien.getDiaChi(),
					NhanVien.getNgayVaoLam(),
					NhanVien.getSoDienThoai(),
					cv.getTenLoaiChucVu()
				});
		}
	}
	//LOAD DATA LÊN BẢNG CHỨC VỤ
	public void loadDataChucVu() {
		ArrayList<ChucVu> lscv = new ArrayList<ChucVu>();
		lscv = cv_dao.getAllChucVu();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_danhSachLoaiChucVuLCV.getModel();
		this.ressetTable(view_main.table_danhSachLoaiChucVuLCV, defaultTableModel);
		for (ChucVu ChucVu : lscv) {
			defaultTableModel.addRow(new Object[] { 
					ChucVu.getMaLoaiChucVu(),
					ChucVu.getTenLoaiChucVu(),
			});
		}
	}
	//XÓA CHỨC VỤ 
	public void delete_QLCV() {
		int row = view_main.table_danhSachLoaiChucVuLCV.getSelectedRow();
		if(row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Bạn muốn xóa chức vụ này", "Xóa", JOptionPane.YES_NO_OPTION);
			if(ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_danhSachLoaiChucVuLCV.getValueAt(row, 0);
				cv_dao.delete(ma);
				JOptionPane.showMessageDialog(view_main, "Xóa thành công");
				loadDataChucVu();
				xoatrangQLCV();
			}
			
		}
	}
	//




	//UPDATE QUẢN LÍ CHỨC VỤ
	public void update_QLCV() {
		int row = view_main.table_danhSachLoaiChucVuLCV.getSelectedRow();
		if (row >= 0) {
			String ma = view_main.textField_maLoaiChucVuLCV.getText();
			String ten = view_main.textField_tenLoaiChucVuLCV.getText();
			ChucVu cv = new ChucVu(ma, ten);
			if (cv_dao.update(cv)) {
				loadDataChucVu();
				JOptionPane.showMessageDialog(view_main, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(view_main, "cập nhật không thành công");
			}
		}
	}
	//THÊM LOẠI CHỨC VỤ 
	public void add_QLCV() {
		int row = view_main.table_danhSachLoaiChucVuLCV.getRowCount();
		if (row >= 0) {
			String ma = view_main.textField_maLoaiChucVuLCV.getText();
			String ten = view_main.textField_tenLoaiChucVuLCV.getText();
			ChucVu cv = new ChucVu(ma, ten);
			ArrayList<ChucVu> ds = new ArrayList<ChucVu>();
			ds = cv_dao.getAllChucVu();
			int k = 0;
			for (ChucVu khachHang : ds) {
				if(ma.equalsIgnoreCase(khachHang.getMaLoaiChucVu())) {
					JOptionPane.showMessageDialog(view_main, "Mã khách hàng đã tồn tại");
					k = 1;
				}
			}
			if(k==0) {
				if (cv_dao.add(cv)) {
					loadDataChucVu();
					JOptionPane.showMessageDialog(view_main, "Thêm thành công");
				} else {
					JOptionPane.showMessageDialog(view_main, "Thêm không thành công");
				}
			}
			
		}
	}
//	hiển thị thông báo lỗi sai biểu thức chính quy và trỏ về text cần sửa
	public void showMessage2(String a, JTextField b) {
		b.requestFocus();
		JOptionPane.showMessageDialog(null, a);
	}
//	biểu thức chính quy bên quản lý khách hàng
	public boolean validData_QLCV() {
		String ma = view_main.textField_maLoaiChucVuLCV.getText().trim();
		String tenCV = view_main.textField_tenLoaiChucVuLCV.getText().trim();
		
		if(!(ma.length() > 0)) {
			showMessage2("Bạn chưa nhập mã chức vụ", view_main.textField_maLoaiChucVuLCV);
			return false;
		}
		
		if(!(tenCV.length() > 0)) {
			showMessage2("Bạn chưa nhập tên chức vụ", view_main.textField_tenLoaiChucVuLCV);
			return false;
		}
		
		return true;
	}
	

	
	//XÓA TRẮNG QLCV
	public void xoatrangQLCV() {
		view_main.textField_maLoaiChucVuLCV.setText("");
		view_main.textField_tenLoaiChucVuLCV.setText("");
	}
	
	//TÀI KHOẢN
	//-----
	//lấy dữ liệu quản lí tài khoản
	public void loadDataQuanLyTK() {
		ArrayList<TaiKhoan> lstk = new ArrayList<TaiKhoan>();
		lstk = tk_dao.getAllTaiKhoan();
		
		ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
		lsqtk = qh_dao.getALLQuyenTaiKhoan();
		
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQLTK.getModel();
		this.ressetTable(view_main.table_OutputListQLTK, defaultTableModel);
		
		for (TaiKhoan taiKhoan : lstk) {
			QuyenTaiKhoan qtk = new QuyenTaiKhoan();
			for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
				if (taiKhoan.getMaQuyen().getMaQuyen().equals(quyenTaiKhoan.getMaQuyen())) {
					qtk = quyenTaiKhoan;
					break;
				}
			}		
		
			defaultTableModel.addRow(new Object[] { 
					taiKhoan.getTenTK(),
					taiKhoan.getMK(),
					qtk.getTenQuyen()
			
				});
		}
	}
	//XÓA TÀI KHOẢN
	public void delete_QLTK() {
		int row = view_main.table_OutputListQLTK.getSelectedRow();
		if(row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Bạn có muốn xóa tài khoản này", "Xóa", JOptionPane.YES_NO_OPTION);
			if(ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_OutputListQLTK.getValueAt(row, 0);
				tk_dao.delete(ma);
				loadDataQuanLyTK();
				xoatrangQLTK();
			}
			
		}
	}
	//UPDATE TÀI KHOẢN
	public void update_QLTK() {
		int row = view_main.table_OutputListQLTK.getRowCount();
		if (row >= 0) {
			String ten = view_main.textTenTaiKhoanQLTK.getText();
			String MK = view_main.passwordFieldMKQLTK.getText();
			String nhaplaiMK = view_main.passwordField_againMKQLTK.getText();
			String tenQuyenHan = view_main.comboBox_QuyenHanQLTK.getSelectedItem().toString();
			
			ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
			lsqtk = qh_dao.getALLQuyenTaiKhoan();
			QuyenTaiKhoan qtk = new QuyenTaiKhoan();
			for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
				if (tenQuyenHan.equals(quyenTaiKhoan.getTenQuyen())) {
					qtk = quyenTaiKhoan;
					break;
				}
			}
			
		
			TaiKhoan tk = new TaiKhoan(ten, MK, qtk);
			if (tk_dao.update(tk)) {
				loadDataQuanLyTK();
				JOptionPane.showMessageDialog(view_main, "Cập Nhật Thành Công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Cập Nhật Không Thành Công");
			}
		}
	}
	//THÊM TÀI KHOẢN
	public void add_QLTK() {
		int row = view_main.table_OutputListQLTK.getRowCount();
		if (row >= 0) {
			String ten = view_main.textTenTaiKhoanQLTK.getText();
			if(ten.equals("")) {
				JOptionPane.showMessageDialog(f, "Tên Tài Khoản Không được để trống !");
			}else {
				String MK = view_main.passwordFieldMKQLTK.getText();
				if(MK.equals("")) {
					JOptionPane.showMessageDialog(f, "Mật Khẩu không được để trống !");
				}else {
					String nhaplaiMK = view_main.passwordField_againMKQLTK.getText();
					if(nhaplaiMK.equals("")) {
						JOptionPane.showMessageDialog(f, "Vui lòng nhập lại mật khẩu !");
					}else if(!nhaplaiMK.equals(MK)) {
						JOptionPane.showMessageDialog(f, "Mật khẩu không trùng khớp");
					}else {
						String tenQuyenHan = view_main.comboBox_QuyenHanQLTK.getSelectedItem().toString();
						
						ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
						lsqtk = qh_dao.getALLQuyenTaiKhoan();
						QuyenTaiKhoan qtk = new QuyenTaiKhoan();
						for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
							if (tenQuyenHan.equals(quyenTaiKhoan.getTenQuyen())) {
								qtk = quyenTaiKhoan;
								break;
							}
						}
						
						ArrayList<TaiKhoan> lskh = new ArrayList<TaiKhoan>();
						lskh = tk_dao.getAllTaiKhoan();
						int k = 0;
						for (TaiKhoan khachHang : lskh) {
							if(ten.equalsIgnoreCase(khachHang.getTenTK())) {
								JOptionPane.showMessageDialog(view_main, "tên tài khoảng đã tồn tại");
								k = 1;
							}
						}
						if(k==0) {
							TaiKhoan tk = new TaiKhoan(ten, MK, qtk);
							loadDataQuanLyTK();
							DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_khachHang_nhanVienQLTK.getModel();
							int selectRow = this.view_main.table_khachHang_nhanVienQLTK.getSelectedRow();
							if(selectRow == -1) {
								JOptionPane.showMessageDialog(f, "Vui lòng chọn nhân viên hoặc khách hàng cần thêm tài khoản !");
							}else {
								String id_kh_nv = dModel.getValueAt(selectRow, 0).toString().trim();
								if(this.view_main.comboBoxKH_NV_QLTK.getSelectedIndex() == 0) {
									if(tk_dao.add(tk) && nv_dao.updateTKNV(ten, id_kh_nv)) {
										JOptionPane.showMessageDialog(f, "Cập nhật tài khoản nhân viên thành công !");
									}else {
										JOptionPane.showMessageDialog(f, "Cập nhật tài khoản nhân viên không thành công !");
										tk_dao.delete(ten);
									}
								}else {
									if(tk_dao.add(tk) && kh_dao.updateTKKH(ten, id_kh_nv)) {
										JOptionPane.showMessageDialog(f, "Cập nhật tài khoản khách hàng thành công !");
									}else {
										JOptionPane.showMessageDialog(f, "Cập nhật tài khoản khách hàng không thành công !");
										tk_dao.delete(ten);
									}
								}
							}
						}
						
					}
				}
			}
		}
		ArrayList<NhanVien> lsnv_emptyTK = new ArrayList<NhanVien>();
		lsnv_emptyTK = nv_dao.getAllNhanVien_NotTK();
		
		ArrayList<KhachHang> lskh_emptyKH = new ArrayList<KhachHang>();
		lskh_emptyKH = kh_dao.getAllKhachHang_NotTK();
		
		DefaultTableModel model = (DefaultTableModel) this.view_main.table_khachHang_nhanVienQLTK.getModel();
		this.ressetTable(this.view_main.table_khachHang_nhanVienQLTK, model);
		
		if(this.view_main.comboBoxKH_NV_QLTK.getSelectedIndex() == 0) {
			for (NhanVien nhanVien : lsnv_emptyTK) {
				model.addRow(new Object [] {
						nhanVien.getMaNhanVien(),
						nhanVien.getHoTen(),
						nhanVien.getSoDienThoai()
				});
			}
		}else {
			for (KhachHang khachhang : lskh_emptyKH) {
				model.addRow(new Object [] {
						khachhang.getMaKH(),
						khachhang.getHoTen(),
						khachhang.getSoDienThoai()
				});
			}
		}
	}
	//XÓA TRẮNG TÀI KHOẢN
	public void xoatrangQLTK() {
		view_main.textTenTaiKhoanQLTK.setText("");
		view_main.passwordFieldMKQLTK.setText("");
		view_main.passwordField_againMKQLTK.setText("");
		view_main.comboBox_QuyenHanQLTK.setSelectedIndex(0);
	}
	
	public void xoatrangTKTK() {
		view_main.textTenTaiKhoanTKTK.setText("");
		view_main.comboBox_QuyenHanTKTK.setSelectedIndex(0);
	}
	//lấy dữ liệu tìm kiếm tài khoản
	
	public void loadDataQuanLyTKTK() {
		ArrayList<TaiKhoan> lstk = new ArrayList<TaiKhoan>();
		lstk = tk_dao.getAllTaiKhoan();
		
		ArrayList<QuyenTaiKhoan> lsqtk = new ArrayList<QuyenTaiKhoan>();
		lsqtk = qh_dao.getALLQuyenTaiKhoan();
		
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKTK.getModel();
		this.ressetTable(view_main.table_OutputListTKTK, defaultTableModel);
		
		for (TaiKhoan taiKhoan : lstk) {
			QuyenTaiKhoan qtk = new QuyenTaiKhoan();
			for (QuyenTaiKhoan quyenTaiKhoan : lsqtk) {
				if (taiKhoan.getMaQuyen().getMaQuyen().equals(quyenTaiKhoan.getMaQuyen())) {
					qtk = quyenTaiKhoan;
					break;
				}
			}		
		
			defaultTableModel.addRow(new Object[] { 
					taiKhoan.getTenTK(),
					taiKhoan.getMK(),
					qtk.getTenQuyen()
			
				});
		}
	}
	//-----------------------------------------------CUONG---------------------------------------------------- HET
//	ressetTable bất kì
	public void ressetTable(JTable table, DefaultTableModel defaultTableModel) {
		int countRow = table.getRowCount();
		for (int i = 0; i < countRow; i++) {
			defaultTableModel.removeRow(0);
		}
	}

//	thêm phòng trong quản lý phòng
	public void addTableListPhongQLP(ArrayList<Phong> lsp, DefaultTableModel defaultTableModel) {
		for (Phong Phong : lsp) {
			defaultTableModel.addRow(new Object[] { Phong.getMaPhong(), Phong.getTenPhong(),
					Phong.getMaLoaiPhong().getTenLoaiPhong(), Phong.getMaTrangThaiPhong().getTenTrangThaiPhong(),
					Phong.getMaLoaiPhong().getGiaPhong(), });
		}
	}

//	xóa Trắng quản lý phòng
	public void XoaTrangQLP() {
		this.view_main.textQLPhongMaPhong.setText("");
		this.view_main.textQLPhongTenPhong.setText("");
		view_main.comboBoxQLPhongLoaiPhong.setSelectedItem("");
	}

//	xóa trắng trong tìm kiếm phòng
	public void XoaTrangTKP() {
		view_main.comboBoxTimPhongMaPhong.setSelectedIndex(0);
		view_main.comboBoxTimPhongTenPhong.setSelectedIndex(0);
		view_main.comboBoxTimPhongLoaiPhong.setSelectedIndex(0);
		view_main.comboBoxTimPhongTrangThai.setSelectedIndex(0);
	}

//	hàm load data loại dịch vụ
	public void loadDataLoaiPhong() {
		ArrayList<LoaiPhong> lsldv = new ArrayList<LoaiPhong>();
		lsldv = lp_dao.getAllLoaiPhong();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_danhSachLoaiPhongLP.getModel();
		this.ressetTable(view_main.table_danhSachLoaiPhongLP, defaultTableModel);
		for (LoaiPhong ldv : lsldv) {
			defaultTableModel.addRow(new Object[] { ldv.getMaLoaiPhong(), ldv.getTenLoaiPhong(), ldv.getGiaPhong() });
		}
	}

//	thêm loại dịch vụ trong quản lý loại phòng
	public void add_QLLP() {
		String ma = view_main.textField_maLoaiPhongLP.getText();
		String ten = view_main.textField_tenLoaiPhongLP.getText();
		String gia = view_main.textField_giaPhongLP.getText();
		ArrayList<Phong> ds = new ArrayList<Phong>();
		ds = p_dao.getAllPhong();
		int k = 0;
		for (Phong khachHang : ds) {
			if(ma.equalsIgnoreCase(khachHang.getMaPhong())) {
				JOptionPane.showMessageDialog(view_main, "Mã phòng đã tồn tại");
				k = 1;
			}
		}
		if(k==0) {
			if (lp_dao.add(ma, ten, gia)) {
				loadDataQuanLyKhachHang();
				JOptionPane.showMessageDialog(view_main, "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Thêm không thành công");
			}
		}
		
	}

//	hàm xóa bên quản lý loại phòng
	public void delete_QLLP() {
		int row = view_main.table_danhSachLoaiPhongLP.getSelectedRow();
		if (row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Bạn có muốn xóa loại phòng này", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_danhSachLoaiPhongLP.getValueAt(row, 0);
				lp_dao.delete(ma);
				JOptionPane.showMessageDialog(view_main, "Xóa thành công");
				loadDataLoaiPhong();
				xoaTrangQLLP();
			}

		}
	}

//	hàm sửa bên quản lý loại phòng
	public void update_QLLP() {
		int row = view_main.table_danhSachLoaiPhongLP.getSelectedRow();
		if (row >= 0) {
			String ma = view_main.textField_maLoaiPhongLP.getText();
			String ten = view_main.textField_tenLoaiPhongLP.getText();
			String gia = view_main.textField_giaPhongLP.getText();

			if (lp_dao.update(ma, ten, gia)) {
				loadDataLoaiPhong();
				JOptionPane.showMessageDialog(view_main, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Cập nhật không thành công");
			}
		}

	}

//	hàm xóa trắng trong quản lý loại phòng
	public void xoaTrangQLLP() {
		view_main.textField_maLoaiPhongLP.setText("");
		view_main.textField_tenLoaiPhongLP.setText("");
		view_main.textField_giaPhongLP.setText("");
	}

//	biểu thức chính quy bên quản lý loại dịch vụ
	public boolean validData_QLLDV() {
		String ma = view_main.textField_maLoaiDichVuLDV.getText().trim();
		String ten = view_main.textField_tenLoaiDichVuLDV.getText().trim();
		if (!(ma.length() > 0)) {
			showMessage("Bạn chưa nhập mã loại dịch vụ", view_main.textField_maLoaiDichVuLDV);
			return false;
		}
		if (ma.matches("^[A-Z]+\\d{2}") == false) {
			showMessage("Mã dịch vụ chỉ chữ in hoa và số", view_main.textField_maLoaiDichVuLDV);
			return false;
		}
		if (!(ten.length() > 0)) {
			showMessage("Bạn chưa nhập tên loại dịch vụ", view_main.textField_tenLoaiDichVuLDV);
			return false;
		}
		return true;
	}

//	hàm xóa trắng text bên tìm kiếm khách hàng
	public void xoaTrangTKKH() {
		view_main.textMaKhachHangTimKiemKH.setText("");
		view_main.textHoTenTimKiemKH.setText("");
		view_main.textSDTTimKiemKH.setText("");
		view_main.textDiaChiTimKiemKH.setText("");
	}

// lấy dữ liệu tìm kiếm khách hàng
	public void loadDataTimKiemKhachHang() {
		ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
		lskh = kh_dao.getAllKhachHang();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutPutTKkhachHang.getModel();
		this.ressetTable(view_main.table_OutPutTKkhachHang, defaultTableModel);
		for (KhachHang khachHang : lskh) {
			defaultTableModel.addRow(new Object[] { khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getDiaChi(),
					khachHang.getSoDienThoai(), });
		}
	}

//	xóa khách hàng trong quản lý khách hàng
	public void delete_QLKH() {
		int row = view_main.table_OutPutQLKH.getSelectedRow();
		if (row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Báº¡n muá»‘n xÃ³a khÃ¡ch hÃ ng nÃ y", "XÃ³a",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_OutPutQLKH.getValueAt(row, 0);
				kh_dao.delete(ma);
				loadDataQuanLyKhachHang();
				xoaTrangQLKH();
			}

		}
	}

//	xóa trắng trong quản lý khách hàng
	public void xoaTrangQLKH() {
		view_main.textMaKhachHangQLKH.setText("");
		view_main.textHoTenQLKH.setText("");
		view_main.textSDTQLKH.setText("");
		view_main.textDiaChiQLKH.setText("");
	}

//	cập nhật khách hàng trong quản lý khách hàng
	public void update_QLKH() {
		int row = view_main.table_OutPutQLKH.getSelectedRow();
		if (row >= 0) {
			String ma = view_main.textMaKhachHangQLKH.getText();
			String tenKH = view_main.textHoTenQLKH.getText();
			String sdt = view_main.textSDTQLKH.getText();
			String diaChi = view_main.textDiaChiQLKH.getText();
			
			
			if (kh_dao.update(ma, tenKH, sdt, diaChi)) {
				loadDataQuanLyKhachHang();
				JOptionPane.showMessageDialog(view_main, "Cáº­p nháº­t thÃ nh cÃ´ng");
			} else {
				JOptionPane.showMessageDialog(view_main, "Cáº­p nháº­t khÃ´ng thÃ nh cÃ´ng");
			}
		}
	}

//	thêm khách hàng trong quản lý khách hàng
	public void add_QLKH() {
		int row = view_main.table_OutPutQLKH.getRowCount();
		if (row >= 0) {
			String ma = view_main.textMaKhachHangQLKH.getText();
			String tenKH = view_main.textHoTenQLKH.getText();
			String sdt = view_main.textSDTQLKH.getText();
			String diaChi = view_main.textDiaChiQLKH.getText();
			String tenTK = null;
			ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
			lskh = kh_dao.getAllKhachHang();
			int k = 0;
			for (KhachHang khachHang : lskh) {
				if(ma.equalsIgnoreCase(khachHang.getMaKH())) {
					JOptionPane.showMessageDialog(view_main, "Mã khách hàng đã tồn tại");
					k = 1;
				}
			}
			if(k==0) {
				if (kh_dao.add(ma, tenKH, sdt, diaChi, tenTK)) {
					loadDataQuanLyKhachHang();
					JOptionPane.showMessageDialog(view_main, "ThÃªm thÃ nh cÃ´ng");
				} else {
					JOptionPane.showMessageDialog(view_main, "ThÃªm khÃ´ng thÃ nh cÃ´ng");
				}
			}
			
		}
	}

//	hiển thị thông báo lỗi sai biểu thức chính quy và trỏ về text cần sửa
	public void showMessage(String a, JTextField b) {
		b.requestFocus();
		JOptionPane.showMessageDialog(null, a);
	}

//	biểu thức chính quy bên quản lý khách hàng
	public boolean validData_QLKH() {
		String ma = view_main.textMaKhachHangQLKH.getText().trim();
		String tenKH = view_main.textHoTenQLKH.getText().trim();
		String sdt = view_main.textSDTQLKH.getText().trim();
		String diaChi = view_main.textDiaChiQLKH.getText().trim();
		if (!(ma.length() > 0)) {
			showMessage("Báº¡n chÆ°a nháº­p mÃ£ khÃ¡ch hÃ ng", view_main.textMaKhachHangQLKH);
			return false;
		}
		if (ma.matches("^[A-Z]+\\d{3}") == false) {
			showMessage("MÃ£ khÃ¡ch hÃ ng bao gá»“m chá»¯ in hoa vÃ  sá»‘", view_main.textMaKhachHangQLKH);
			return false;
		}
		if (!(tenKH.length() > 0)) {
			showMessage("Báº¡n chÆ°a nháº­p tÃªn", view_main.textHoTenQLKH);
			return false;
		}
		if (!(sdt.length() > 0)) {
			showMessage("Báº¡n chÆ°a nháº­p sá»‘ Ä‘iá»‡n thoáº¡i", view_main.textSDTQLKH);
			return false;
		}
		if (!(diaChi.length() > 0)) {
			showMessage("Báº¡n chÆ°a nháº­p Ä‘á»‹a chá»‰", view_main.textDiaChiQLKH);
			return false;
		}
		

		return true;
	}

//	lấy dữ liệu trong quản lý khách hàng
	public void loadDataQuanLyKhachHang() {
		ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
		lskh = kh_dao.getAllKhachHang();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutPutQLKH.getModel();
		this.ressetTable(view_main.table_OutPutQLKH, defaultTableModel);
		for (KhachHang khachHang : lskh) {
			defaultTableModel.addRow(new Object[] { khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getDiaChi(),
					khachHang.getSoDienThoai(), });
		}
	}

//	load data lên bảng bên tìm kiếm dịch vụ
	public void loadDataTKDV() {
		ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
		lsdv = dv_dao.getAllDichVu();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListTKDV.getModel();
		this.ressetTable(view_main.table_OutputListTKDV, defaultTableModel);
		for (DichVu DichVu : lsdv) {
			defaultTableModel.addRow(new Object[] { DichVu.getMaDichVu(), DichVu.getTenDichVu(), DichVu.getGia(),
					DichVu.getLoaiDichVu().getTenLoaiDichVu(),

			});
		}
	}

//	load data lên bảng bên quản lý dịch vụ
	public void loadDataQLDV() {
		ArrayList<DichVu> lsdv = new ArrayList<DichVu>();
		lsdv = dv_dao.getAllDichVu();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_OutputListQLDV.getModel();
		this.ressetTable(view_main.table_OutputListQLDV, defaultTableModel);
		for (DichVu DichVu : lsdv) {
			defaultTableModel.addRow(new Object[] { DichVu.getMaDichVu(), DichVu.getTenDichVu(), DichVu.getGia(),
					DichVu.getLoaiDichVu().getTenLoaiDichVu(), });
		}
	}

//load dữ liệu lên combobox loại dịch vụ trong tim kiếm
	public void loadComboboxTKDV() {
		ArrayList<LoaiDichVu> ds = new ArrayList<LoaiDichVu>();
		ds = ldv_dao.getAllLoaiDichVu();
		view_main.comboBox_LoaiDichVuTKDV.removeAllItems();
		for (LoaiDichVu LoaiDichVu : ds) {
			view_main.comboBox_LoaiDichVuTKDV.addItem(LoaiDichVu.getTenLoaiDichVu());
		}
	}

//	biểu thức chính quy bên quản lý dịch vụ
	public boolean validData_QLDV() {
		String ma = view_main.textMaDichVuQLDV.getText().trim();
		String ten = view_main.textTenDichVuQLDV.getText().trim();
		String giaMua = view_main.textGiaMuaQLDV.getText().trim();
		if (!(ma.length() > 0)) {
			showMessage("Bạn chưa nhập mã dịch vụ", view_main.textMaDichVuQLDV);
			return false;
		}
		if (ma.matches("^[A-Z]+\\d{2}") == false) {
			showMessage("Mã dịch vụ chỉ chữ in hoa và số", view_main.textMaDichVuQLDV);
			return false;
		}
		if (!(ten.length() > 0)) {
			showMessage("Bạn chưa nhập tên dịch vụ", view_main.textTenDichVuQLDV);
			return false;
		}
		if (!(giaMua.length() > 0)) {
			showMessage("Bạn chưa nhập giá mua", view_main.textGiaMuaQLDV);
			return false;
		}
		float gia = Float.parseFloat(giaMua);
		if (gia < 0 || gia == 0) {
			showMessage("Giá mua phải là số lớn hơn 0", view_main.textGiaMuaQLDV);
			return false;
		}

		return true;
	}

//	hàm xóa bên quản lý dịch vụ
	public void delete_QLDV() {
		int row = view_main.table_OutputListQLDV.getSelectedRow();
		if (row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Bạn có muốn xóa dịch vụ này", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_OutputListQLDV.getValueAt(row, 0);
				dv_dao.delete(ma);
				JOptionPane.showMessageDialog(view_main, "Xóa thành công");
				loadDataQLDV();
				xoaTrangQLDV();
			}

		}
	}

//	hàm sửa bên quản lý dịch vụ
	public void update_QLDV() {
		int row = view_main.table_OutputListQLDV.getSelectedRow();
		if (row >= 0) {
			String ma = view_main.textMaDichVuQLDV.getText();
			String ten = view_main.textTenDichVuQLDV.getText();
			String giaMua = view_main.textGiaMuaQLDV.getText();
			String loaiDV = this.view_main.comboBoxLoaiDichVuQLDV.getSelectedItem().toString();
			String maLDV = "";
			ArrayList<LoaiDichVu> ds = new ArrayList<LoaiDichVu>();
			ds = ldv_dao.getAllLoaiDichVu();
			for (LoaiDichVu LoaiDichVu : ds) {
				if (LoaiDichVu.getTenLoaiDichVu().equals(loaiDV)) {
					maLDV = LoaiDichVu.getMaLoaiDichVu();
				}
			}
			if (dv_dao.update(ma, ten, giaMua, maLDV)) {
				loadDataQuanLyKhachHang();
				JOptionPane.showMessageDialog(view_main, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Cập nhật không thành công");
			}
		}

	}

//	hàm xóa trắng text bên quản lý dịch vụ
	public void xoaTrangQLDV() {
		view_main.textMaDichVuQLDV.setText("");
		view_main.textTenDichVuQLDV.setText("");
		view_main.textGiaMuaQLDV.setText("");
	}

//	hàm load data loại dịch vụ
	public void loadDataLoaiDichVu() {
		ArrayList<LoaiDichVu> lsldv = new ArrayList<LoaiDichVu>();
		lsldv = ldv_dao.getAllLoaiDichVu();
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.view_main.table_danhSachLoaiDichVuLDV.getModel();
		this.ressetTable(view_main.table_danhSachLoaiDichVuLDV, defaultTableModel);
		for (LoaiDichVu ldv : lsldv) {
			defaultTableModel.addRow(new Object[] { ldv.getMaLoaiDichVu(), ldv.getTenLoaiDichVu(), });
		}
	}

//	thêm loại dịch vụ trong quản lý loại dịch vụ
	public void add_QLLDV() {
		String ma = view_main.textField_maLoaiDichVuLDV.getText();
		String ten = view_main.textField_tenLoaiDichVuLDV.getText();
		ArrayList<LoaiDichVu> ds = new ArrayList<LoaiDichVu>();
		ds = ldv_dao.getAllLoaiDichVu();
		int k = 0;
		for (LoaiDichVu khachHang : ds) {
			if(ma.equalsIgnoreCase(khachHang.getMaLoaiDichVu())) {
				JOptionPane.showMessageDialog(view_main, "Mã khách hàng đã tồn tại");
				k = 1;
			}
		}
		if(k==0) {
			if (ldv_dao.add(ma, ten)) {
				loadDataQuanLyKhachHang();
				JOptionPane.showMessageDialog(view_main, "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Thêm không thành công");
			}
		}
		
	}

//	hàm xóa bên quản lý dịch vụ
	public void delete_QLLDV() {
		int row = view_main.table_danhSachLoaiDichVuLDV.getSelectedRow();
		if (row >= 0) {
			int ask = JOptionPane.showConfirmDialog(view_main, "Bạn có muốn xóa loại dịch vụ này", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String ma = (String) view_main.table_danhSachLoaiDichVuLDV.getValueAt(row, 0);
				ldv_dao.delete(ma);
				JOptionPane.showMessageDialog(view_main, "Xóa thành công");
				loadDataLoaiDichVu();
				xoaTrangQLLDV();
			}

		}
	}

//	hàm sửa bên quản lý loại dịch vụ
	public void update_QLLDV() {
		int row = view_main.table_danhSachLoaiDichVuLDV.getSelectedRow();
		if (row >= 0) {
			String ma = view_main.textField_maLoaiDichVuLDV.getText();
			String ten = view_main.textField_tenLoaiDichVuLDV.getText();

			if (ldv_dao.update(ma, ten)) {
				loadDataLoaiDichVu();
				JOptionPane.showMessageDialog(view_main, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(view_main, "Cập nhật không thành công");
			}
		}

	}

//	hàm xóa trắng trong quản lý dịch vụ
	public void xoaTrangQLLDV() {
		view_main.textField_maLoaiDichVuLDV.setText("");
		view_main.textField_tenLoaiDichVuLDV.setText("");
	}

//	biểu thức chính quy bên quản lý phòng
	public boolean validData_QLLP() {
		String ma = view_main.textField_maLoaiPhongLP.getText().trim();
		String ten = view_main.textField_tenLoaiPhongLP.getText().trim();
		String gia = view_main.textField_giaPhongLP.getText().trim();
		if (!(ma.length() > 0)) {
			showMessage("Bạn chưa nhập mã loại dịch vụ", view_main.textField_maLoaiPhongLP);
			return false;
		}
		if (ma.matches("^[A-Z]+\\d{2}") == false) {
			showMessage("Mã dịch vụ chỉ chữ in hoa và số", view_main.textField_maLoaiPhongLP);
			return false;
		}
		if (!(ten.length() > 0)) {
			showMessage("Bạn chưa nhập tên loại phòng", view_main.textField_tenLoaiPhongLP);
			return false;
		}
		if (!(gia.length() > 0)) {
			showMessage("Bạn chưa nhập giá mua", view_main.textField_giaPhongLP);
			return false;
		}
		float giaPhong = Float.parseFloat(gia);
		if (giaPhong < 0 || giaPhong == 0) {
			showMessage("Giá phòng phải là số lớn hơn 0", view_main.textField_giaPhongLP);
			return false;
		}
		return true;
	}

//	hàm thêm bên quản lý nhân viên
	public void add_QLDV() {// dasua
		int row = view_main.table_OutputListQLDV.getRowCount();
		if (row >= 0) {
			String ma = view_main.textMaDichVuQLDV.getText();
			String ten = view_main.textTenDichVuQLDV.getText();
			String giaMua = view_main.textGiaMuaQLDV.getText();
			String loaiDV = this.view_main.comboBoxLoaiDichVuQLDV.getSelectedItem().toString();
			String maLDV = "";
			ArrayList<LoaiDichVu> ds = new ArrayList<LoaiDichVu>();
			ds = ldv_dao.getAllLoaiDichVu();
			for (LoaiDichVu LoaiDichVu : ds) {
				if (LoaiDichVu.getTenLoaiDichVu().equals(loaiDV)) {
					maLDV = LoaiDichVu.getMaLoaiDichVu();
				}
			}
			ArrayList<DichVu> dv = new ArrayList<DichVu>();
			dv = dv_dao.getAllDichVu();
			int k = 0;
			for (DichVu khachHang : dv) {
				if(ma.equalsIgnoreCase(khachHang.getMaDichVu())) {
					JOptionPane.showMessageDialog(view_main, "Mã dịch vụ đã tồn tại");
					k = 1;
				}
			}
			if(k==0) {
				if (dv_dao.add(ma, ten, giaMua, maLDV)) {
					loadDataQLDV();
					JOptionPane.showMessageDialog(view_main, "Thêm thành công");
				} else {
					JOptionPane.showMessageDialog(view_main, "Thêm không thành công");
				}
			}
			
		}
	}

//	reset các text bên lập hóa đơn
	public void resetLapHoaDon() {
		this.view_main.textField_hoTenNhanVienLHD.setText("");
		this.view_main.textField_hoTenKhachHangLHD.setText("");
		this.view_main.textField_maDatPhongLHD.setText("");
		this.view_main.lblmaHoaDonLHD.setText("");
		this.view_main.textField_ngayLapLHD.setText("");
		this.view_main.dateChooserNgayLapLHD.setCalendar(null);
		this.view_main.textField_maHoaDonTHD.setText("");
	}

//	sự kiện click chuột
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
//		click chuột vào danh sách phiếu  bên quản lý phiếu 
		if (o.equals(this.view_main.table_DanhSachPhieuDP)) {
			DefaultTableModel deModel = (DefaultTableModel) this.view_main.table_DanhSachPhieuDP.getModel();
			int rowSelect = this.view_main.table_DanhSachPhieuDP.getSelectedRow();
			String maDatPhong = deModel.getValueAt(rowSelect, 0).toString().trim();
			PhieuDatPhong pdp = new PhieuDatPhong();
			Phong p = new Phong();
			KhachHang kh = new KhachHang();
			NhanVien nv = new NhanVien();

//			lấy phiếu đặt phòng
			ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
			lspdp = pdp_dao.getAllPhieuDatPhong();
			for (PhieuDatPhong phieuDatPhong : lspdp) {
				if (phieuDatPhong.getMaDatPhong().equalsIgnoreCase(maDatPhong)) {
					pdp = phieuDatPhong;
					break;
				}
			}

//			lấy phòng
			ArrayList<Phong> lsp = new ArrayList<Phong>();
			lsp = p_dao.getAllPhong();
			for (Phong phong : lsp) {
				if (phong.getMaPhong().equals(pdp.getMaPhong().getMaPhong())) {
					p = phong;
					break;
				}
			}

//			lấy khách hàng
			ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
			lskh = kh_dao.getAllKhachHang();
			for (KhachHang khachHang : lskh) {
				if (khachHang.getMaKH().equals(pdp.getMaKhachHang().getMaKH())) {
					kh = khachHang;
					break;
				}
			}

//			lấy nhân viên
			ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
			lsnv = nv_dao.getAllNhanVien();
			for (NhanVien nhanVien : lsnv) {
				if (nhanVien.getMaNhanVien().equals(pdp.getMaNhanVien().getMaNhanVien())) {
					nv = nhanVien;
					break;
				}
			}

//			đổ dữ liệu vào text và combobox
			ZoneId defaultZoneId = ZoneId.systemDefault();
			this.view_main.textField_TenNhanVienQLPDP.setText(nv.getHoTen());
			this.view_main.textTenKhachHangKQQLPDP.setText(kh.getHoTen());
			this.view_main.textSoDienThoaiKQQLPDP.setText(kh.getSoDienThoai());
			this.view_main.comboBox_SoNguoiQLDP.setSelectedItem(pdp.getSoNguoi());
			this.view_main.textGhiChuKQQLPDP.setText(pdp.getGhiChu());
			this.view_main.comboBox_GioQLDP.setSelectedItem(pdp.getNgayDat().getHour());
			this.view_main.comboBox_PhutQLDP.setSelectedItem(pdp.getNgayDat().getMinute());
			this.view_main.dateChooser_NgayDatPhongQLDP
					.setDate(Date.from(pdp.getNgayDat().atZone(defaultZoneId).toInstant()));

//			đổ dữ liệu vào table 
			DefaultTableModel model = (DefaultTableModel) this.view_main.table_PhieuDatPhongQLPDP.getModel();
			this.ressetTable(this.view_main.table_PhieuDatPhongQLPDP, model);
			model.addRow(new Object[] { p.getMaPhong(), p.getTenPhong(), p.getMaLoaiPhong().getTenLoaiPhong(),
					p.getMaTrangThaiPhong().getTenTrangThaiPhong() });
		}

//		nhấp chuột vào bảng phòng trong quản lý phòng
		if (o.equals(this.view_main.table_OutputListQuanLyPhong)) {
			int NumRow = this.view_main.table_OutputListQuanLyPhong.getSelectedRow();
			this.view_main.textQLPhongMaPhong
					.setText(this.view_main.table_OutputListQuanLyPhong.getModel().getValueAt(NumRow, 0).toString());
			this.view_main.textQLPhongTenPhong
					.setText(this.view_main.table_OutputListQuanLyPhong.getModel().getValueAt(NumRow, 1).toString());
			this.view_main.comboBoxQLPhongLoaiPhong
					.setSelectedItem(view_main.table_OutputListQuanLyPhong.getValueAt(NumRow, 2).toString());

		}

//		nhấn vào table phiếu đặt phòng trong đặt dịch vụ
		if (o.equals(this.view_main.table_OutputListDSPDPTHD)) {
			DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSPDPTHD.getModel();
			int selectRow = this.view_main.table_OutputListDSPDPTHD.getSelectedRow();

//			lấy mã đặt phòng từ table phiếu đặt phòng
			String maDatPhong = dModel.getValueAt(selectRow, 0).toString().trim();

			ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
			lscthd = cthd_dao.getChiTietHoaDon_MaDP(maDatPhong);

//			thêm thông tin dịch vụ lấy từ phiếu đặt phòng
			DefaultTableModel dModel1 = (DefaultTableModel) this.view_main.table_ChiTietDichVuDDV.getModel();
			this.ressetTable(this.view_main.table_ChiTietDichVuDDV, dModel1);
			for (ChiTietHoaDon chiTietHoaDon : lscthd) {
				float ThanhTien = chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaDichVu().getGia();
				dModel1.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
						chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
						chiTietHoaDon.getMaDichVu().getGia(), ThanhTien });
			}

//			lấy phiếu đặt phòng thông qua mã đặt phòng
			ArrayList<PhieuDatPhong> lspdpd = new ArrayList<PhieuDatPhong>();
			lspdpd = pdp_dao.getAllPhieuDatPhong();
			PhieuDatPhong pdp = new PhieuDatPhong();

			for (PhieuDatPhong phieuDatPhong : lspdpd) {
				if (phieuDatPhong.getMaDatPhong().equals(maDatPhong)) {
					pdp = phieuDatPhong;
					break;
				}
			}
			ZoneId defaultZoneId = ZoneId.systemDefault();
			this.view_main.dateChooserNgayLapHD.setDate(Date.from(pdp.getNgayDat().atZone(defaultZoneId).toInstant()));

//			lấy phòng thông qua mã phòng từ phiếu đặt phòng
			ArrayList<Phong> lsp = new ArrayList<Phong>();
			Phong p = new Phong();
			lsp = p_dao.getAllPhong();
			for (Phong phong : lsp) {
				if (phong.getMaPhong().equals(pdp.getMaPhong().getMaPhong())) {
					p = phong;
					break;
				}
			}

			this.view_main.textField_TenPhongDDV.setText(p.getTenPhong());
			this.view_main.textField_LoaiPhongDDV.setText(p.getMaLoaiPhong().getTenLoaiPhong());
			this.view_main.textField_GiaPhongDDV.setText(p.getMaLoaiPhong().getGiaPhong() + "");
			this.view_main.textField_NgayGioNhanPhongDDV.setText(pdp.getNgayGioVao() + "");
		}
//		click chuột bên quản lý loại phòng
		if (o.equals(this.view_main.table_danhSachLoaiPhongLP)) {
			int row_QLP = view_main.table_danhSachLoaiPhongLP.getSelectedRow();
			view_main.textField_maLoaiPhongLP
					.setText(view_main.table_danhSachLoaiPhongLP.getValueAt(row_QLP, 0).toString());
			view_main.textField_tenLoaiPhongLP
					.setText(view_main.table_danhSachLoaiPhongLP.getValueAt(row_QLP, 1).toString());
			view_main.textField_giaPhongLP
					.setText(view_main.table_danhSachLoaiPhongLP.getValueAt(row_QLP, 2).toString());

		}
//		click chuột bên quản lý khách hàng
		if (o.equals(this.view_main.table_OutPutQLKH)) {
			int row_QLKH = view_main.table_OutPutQLKH.getSelectedRow();
			view_main.textMaKhachHangQLKH.setText(view_main.table_OutPutQLKH.getValueAt(row_QLKH, 0).toString());
			view_main.textHoTenQLKH.setText(view_main.table_OutPutQLKH.getValueAt(row_QLKH, 1).toString());
			view_main.textSDTQLKH.setText(view_main.table_OutPutQLKH.getValueAt(row_QLKH, 3).toString());
			view_main.textDiaChiQLKH.setText(view_main.table_OutPutQLKH.getValueAt(row_QLKH, 2).toString());
		}
//		click chuộc bên quản lý dịch vụ
		if (o.equals(this.view_main.table_OutputListQLDV)) {
			int row_QLDV = view_main.table_OutputListQLDV.getSelectedRow();
			view_main.textMaDichVuQLDV.setText(view_main.table_OutputListQLDV.getValueAt(row_QLDV, 0).toString());
			view_main.textTenDichVuQLDV.setText(view_main.table_OutputListQLDV.getValueAt(row_QLDV, 1).toString());
			view_main.textGiaMuaQLDV.setText(view_main.table_OutputListQLDV.getValueAt(row_QLDV, 2).toString());
			this.view_main.comboBoxLoaiDichVuQLDV
					.setSelectedItem(view_main.table_OutputListQLDV.getValueAt(row_QLDV, 3).toString());
		}

//		click chuột bên quản lý loại dịch vụ
		if (o.equals(this.view_main.table_danhSachLoaiDichVuLDV)) {
			int row_QLKH = view_main.table_danhSachLoaiDichVuLDV.getSelectedRow();
			view_main.textField_maLoaiDichVuLDV
					.setText(view_main.table_danhSachLoaiDichVuLDV.getValueAt(row_QLKH, 0).toString());
			view_main.textField_tenLoaiDichVuLDV
					.setText(view_main.table_danhSachLoaiDichVuLDV.getValueAt(row_QLKH, 1).toString());

		}
//		click chuộc bên quản lý chức vụ
		if(o.equals(this.view_main.table_danhSachLoaiChucVuLCV)) {
			int row_QLCV = view_main.table_danhSachLoaiChucVuLCV.getSelectedRow();
			view_main.textField_maLoaiChucVuLCV.setText(view_main.table_danhSachLoaiChucVuLCV.getValueAt(row_QLCV, 0).toString());
			view_main.textField_tenLoaiChucVuLCV.setText(view_main.table_danhSachLoaiChucVuLCV.getValueAt(row_QLCV, 1).toString());
			
		}

		//click chuột bên quản lí nhân viên
		if (o.equals(this.view_main.table_OutputListQLNV)) {
			int row_QLNV = view_main.table_OutputListQLNV.getSelectedRow();
			view_main.textMaNhanVienQLNV.setText(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 0).toString());
			view_main.textHoTenQLNV.setText(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 1).toString());
			this.view_main.comboBoxGioiTinhQLNV.setSelectedItem(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 2).toString());
			view_main.textDiaChiQLNV.setText(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 3).toString());
			view_main.textSDTQLNV.setText(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 4).toString());
			
			
			LocalDate ngayvaolam = LocalDate.parse(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 5).toString());
			LocalDateTime ngayvaolam1 = LocalDateTime.of(ngayvaolam, LocalTime.of(0, 0));
			ZoneId defaultZoneId = ZoneId.systemDefault();
			this.view_main.dateChooserNgayVaoLamQLNV.setDate(Date.from(ngayvaolam1.atZone(defaultZoneId).toInstant()));
			
			this.view_main.comboBoxChucVuQLNV.setSelectedItem(view_main.table_OutputListQLNV.getValueAt(row_QLNV, 6).toString());
		}
		
//		click chuột vào bảng tài khoản
		if (o.equals(this.view_main.table_OutputListQLTK)) {
			int row_QLTK = view_main.table_OutputListQLTK.getSelectedRow();
			view_main.textTenTaiKhoanQLTK.setText(view_main.table_OutputListQLTK.getValueAt(row_QLTK, 0).toString());
			view_main.passwordFieldMKQLTK.setText(view_main.table_OutputListQLTK.getValueAt(row_QLTK, 1).toString());	
			view_main.passwordField_againMKQLTK.setText(view_main.table_OutputListQLTK.getValueAt(row_QLTK, 1).toString());
			this.view_main.comboBox_QuyenHanQLTK.setSelectedItem(view_main.table_OutputListQLTK.getValueAt(row_QLTK, 2).toString());
			
		}	
//		click chuột vào bảng danh sách hóa đơn chưa thanh toán
		if (o.equals(this.view_main.table_danhSachPhieuDatPhongLHD)) {
//			lấy phiếu đặt phòng
			DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_danhSachPhieuDatPhongLHD.getModel();
			int selectRow = this.view_main.table_danhSachPhieuDatPhongLHD.getSelectedRow();

			String maDP = dModel.getValueAt(selectRow, 0).toString().trim();
			PhieuDatPhong pdp = new PhieuDatPhong();
			ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
			lspdp = pdp_dao.getAllPhieuDatPhong();
			for (PhieuDatPhong phieuDatPhong : lspdp) {
				if (phieuDatPhong.getMaDatPhong().equals(maDP)) {
					pdp = phieuDatPhong;
					break;
				}
			}
			ZoneId defaultZoneId = ZoneId.systemDefault();
			this.view_main.dateChooserNgayLapLHD
					.setDate(Date.from(pdp.getNgayGioVao().atZone(defaultZoneId).toInstant()));
		}

//		nhấn vào table danh sách hóa đơn chưa thanh toán
		if (o.equals(this.view_main.table_OutputListDSHDCTT)) {
			DefaultTableModel dModel = (DefaultTableModel) this.view_main.table_OutputListDSHDCTT.getModel();
			int selectRow = this.view_main.table_OutputListDSHDCTT.getSelectedRow();
//			lấy mã hoá đơn
			String maHD = dModel.getValueAt(selectRow, 0).toString().trim();
//			lấy hóa đơn
			HoaDon hd = new HoaDon();
			ArrayList<HoaDon> lshd = new ArrayList<HoaDon>();
			lshd = hd_dao.getAllHoaDon();
			for (HoaDon hoaDon : lshd) {
				if (hoaDon.getMaHoaDon().equals(maHD)) {
					hd = hoaDon;
					break;
				}
			}
			String ngayLap = hd.getNgayGioRa().toString();
			ArrayList<ChiTietHoaDon> lscthd = new ArrayList<ChiTietHoaDon>();
			lscthd = cthd_dao.getChiTietHoaDon_MaHD(maHD);
//			add chi tiết hóa đơn vào bảng dịch vụ
			DefaultTableModel dModel2 = (DefaultTableModel) this.view_main.table_DanhSachDichVuTT.getModel();
			this.ressetTable(this.view_main.table_DanhSachDichVuTT, dModel2);
			for (ChiTietHoaDon chiTietHoaDon : lscthd) {
				dModel2.addRow(new Object[] { chiTietHoaDon.getMaDichVu().getMaDichVu(),
						chiTietHoaDon.getMaDichVu().getTenDichVu(), chiTietHoaDon.getSoLuong(),
						chiTietHoaDon.getMaDichVu().getGia(),
						chiTietHoaDon.getMaDichVu().getGia() * chiTietHoaDon.getSoLuong() });
			}
//			lấy phiếu đặt phòng
			String maDP = lscthd.get(0).getMaDatPhong().getMaDatPhong();
			PhieuDatPhong pdp = new PhieuDatPhong();
			ArrayList<PhieuDatPhong> lspdp = new ArrayList<PhieuDatPhong>();
			lspdp = pdp_dao.getAllPhieuDatPhong();
			for (PhieuDatPhong phieuDatPhong : lspdp) {
				if (phieuDatPhong.getMaDatPhong().equals(maDP)) {
					pdp = phieuDatPhong;
					break;
				}
			}
//			lấy phòng
			Phong p = new Phong();
			ArrayList<Phong> lsp = new ArrayList<Phong>();
			lsp = p_dao.getAllPhong();
			for (Phong phong : lsp) {
				if (phong.getMaPhong().equals(pdp.getMaPhong().getMaPhong())) {
					p = phong;
					break;
				}
			}

//			tính số phút sử dụng phòng
			long diffInMinutes = java.time.Duration.between(pdp.getNgayGioVao(), hd.getNgayGioRa()).toMinutes();
			dModel2.addRow(new Object[] { p.getMaPhong(), p.getTenPhong(), diffInMinutes / 60,
					p.getMaLoaiPhong().getGiaPhong(), (p.getMaLoaiPhong().getGiaPhong() / 60) * (diffInMinutes) });
//			lấy nhân viên
			NhanVien nv = new NhanVien();
			ArrayList<NhanVien> lsnv = new ArrayList<NhanVien>();
			lsnv = nv_dao.getAllNhanVien();
			for (NhanVien nhanVien : lsnv) {
				if (nhanVien.getMaNhanVien().equals(hd.getMaNhanVien().getMaNhanVien())) {
					nv = nhanVien;
					break;
				}
			}
//			lấy khách hàng
			KhachHang kh = new KhachHang();
			ArrayList<KhachHang> lskh = new ArrayList<KhachHang>();
			lskh = kh_dao.getAllKhachHang();
			for (KhachHang khachHang : lskh) {
				if (khachHang.getMaKH().equals(pdp.getMaKhachHang().getMaKH())) {
					kh = khachHang;
					break;
				}
			}
//			lấy thông tin cần thiết đưa vào các ô text
			this.view_main.textField_hoTenNhanVienTT.setText(nv.getHoTen());
			this.view_main.textField_hoTenKhachHangTT.setText(kh.getHoTen());
			this.view_main.textField_maDatPhongTT.setText(pdp.getMaDatPhong());
			this.view_main.lblMaHoaDonTT.setText(maHD);
			this.view_main.textField_ngayLapTT.setText(ngayLap);
			this.view_main.textField_TongTienTT.setText(hd.getTongTien() + "");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
