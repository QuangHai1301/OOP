package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class HoaDon_view extends JFrame {

	public JPanel contentPaneIsPrint;
	public JTable table_dichvuHD;
	private Main Main_view;
	public JLabel lblmaHoaDonHD;
	public JLabel lblNgayLapHD;
	public JLabel lbltongTienHD;
	public JLabel lbltienNhanHD;
	public JLabel lbltienThuaHD;
	public JLabel lblhoTenKhachHangHD;
	public JLabel lblDiaChiHD;
	public JLabel lblsdtHD;
	public JLabel lblhoTenNhanVien;
	public JLabel lblsoDienThoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon_view frame = new HoaDon_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HoaDon_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 898);
		setResizable(true);
		setLocationRelativeTo(null);
		contentPaneIsPrint = new JPanel();
		contentPaneIsPrint.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneIsPrint);
		contentPaneIsPrint.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 801, 837);
		contentPaneIsPrint.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KARAOKE NICE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(297, 11, 182, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(58, 63, 121, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa Chỉ :");
		lblNewLabel_1_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(58, 114, 121, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Hóa Đơn :");
		lblNewLabel_1_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(58, 163, 121, 22);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("02372849323 - 03847274834");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(195, 63, 219, 22);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("188 Phường 2 Quận Gò Vấp, Thành Phố Hồ Chí Minh");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(195, 114, 409, 22);
		panel.add(lblNewLabel_1_3_1);
		
		lblmaHoaDonHD = new JLabel("HD027");
		lblmaHoaDonHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblmaHoaDonHD.setBounds(195, 163, 121, 22);
		panel.add(lblmaHoaDonHD);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày Lập :");
		lblNewLabel_1_2_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(483, 163, 121, 22);
		panel.add(lblNewLabel_1_2_1);
		
		lblNgayLapHD = new JLabel("2022-11-15");
		lblNgayLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgayLapHD.setBounds(620, 163, 171, 22);
		panel.add(lblNgayLapHD);
		
		JLabel lblHoanThanh = new JLabel("HÓA ĐƠN THANH TOÁN");
		lblHoanThanh.setForeground(new Color(0, 0, 128));
		lblHoanThanh.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblHoanThanh.setBounds(257, 232, 272, 41);
		panel.add(lblHoanThanh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLUE, 3));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(10, 271, 781, 105);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Họ Tên Khách Hàng :");
		lblNewLabel_1_4.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(10, 11, 176, 22);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Địa Chỉ :");
		lblNewLabel_1_4_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(10, 73, 78, 22);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1_4_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_2.setBounds(433, 11, 133, 22);
		panel_1.add(lblNewLabel_1_4_2);
		
		lblhoTenKhachHangHD = new JLabel("Ngô Thiên Phú");
		lblhoTenKhachHangHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblhoTenKhachHangHD.setBounds(196, 11, 227, 22);
		panel_1.add(lblhoTenKhachHangHD);
		
		lblDiaChiHD = new JLabel("99 Lê Duẩn , Thành Phố Bà Rịa Vũng Tàu");
		lblDiaChiHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDiaChiHD.setBounds(98, 73, 468, 22);
		panel_1.add(lblDiaChiHD);
		
		lblsdtHD = new JLabel("0234356534");
		lblsdtHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsdtHD.setBounds(576, 11, 195, 22);
		panel_1.add(lblsdtHD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLUE, 3));
		panel_2.setBounds(10, 384, 781, 291);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		table_dichvuHD = new JTable();
		table_dichvuHD.setBorder(new LineBorder(Color.WHITE, 0));
		table_dichvuHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Dịch Vụ", "Số Lượng", "Giá", "Thành Tiền"
			}
		));
		
		JScrollPane scrollPane_dichvuHD = new JScrollPane(table_dichvuHD);
		scrollPane_dichvuHD.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_dichvuHD.setBounds(10, 11, 761, 269);
		panel_2.add(scrollPane_dichvuHD);
		
		lbltongTienHD = new JLabel("1.200.000 VND");
		lbltongTienHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltongTienHD.setBounds(620, 686, 171, 22);
		panel.add(lbltongTienHD);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Tổng Tiền :");
		lblNewLabel_1_4_3.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_3.setBounds(515, 686, 89, 22);
		panel.add(lblNewLabel_1_4_3);
		
		lbltienNhanHD = new JLabel("2.000.000 VND");
		lbltienNhanHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltienNhanHD.setBounds(620, 729, 171, 22);
		panel.add(lbltienNhanHD);
		
		JLabel lblNewLabel_1_4_3_1 = new JLabel("Tiền Nhận :");
		lblNewLabel_1_4_3_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_3_1.setBounds(515, 729, 89, 22);
		panel.add(lblNewLabel_1_4_3_1);
		
		lbltienThuaHD = new JLabel("800.000 VND");
		lbltienThuaHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltienThuaHD.setBounds(620, 773, 171, 22);
		panel.add(lbltienThuaHD);
		
		JLabel lblNewLabel_1_4_3_2 = new JLabel("Tiền Thừa :");
		lblNewLabel_1_4_3_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4_3_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_3_2.setBounds(515, 773, 89, 22);
		panel.add(lblNewLabel_1_4_3_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Nhân Viên :");
		lblNewLabel_1_2_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_2.setBounds(10, 686, 100, 22);
		panel.add(lblNewLabel_1_2_2);
		
		lblhoTenNhanVien = new JLabel("Trần Duy Khánh");
		lblhoTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblhoTenNhanVien.setBounds(120, 686, 160, 22);
		panel.add(lblhoTenNhanVien);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Số Điện Thoại :");
		lblNewLabel_1_4_2_1.setForeground(new Color(72, 61, 139));
		lblNewLabel_1_4_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_2_1.setBounds(10, 729, 133, 22);
		panel.add(lblNewLabel_1_4_2_1);
		
		lblsoDienThoai = new JLabel("0234356534");
		lblsoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsoDienThoai.setBounds(153, 729, 195, 22);
		panel.add(lblsoDienThoai);
		
		JLabel lblNewLabel_1_3_2_2_2_1_1 = new JLabel("Cảm Ơn Quý Khách Đã Tin Tưởng Và Sử Dụng Dịch Vụ !");
		lblNewLabel_1_3_2_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_2_2_2_1_1.setBounds(42, 804, 437, 22);
		panel.add(lblNewLabel_1_3_2_2_2_1_1);
	}
	
	
	public void InHoaDon(JPanel jpanel) {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setJobName("Hóa Đơn Thanh Toán");
		printerJob.setPrintable(new Printable() {
			
			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				if(pageIndex > 0) {
					return Printable.NO_SUCH_PAGE;
				}
				Graphics2D graphics2d = (Graphics2D) graphics;
				graphics2d.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
				graphics2d.scale(0.74, 0.74);
				jpanel.paint(graphics2d);
				return Printable.PAGE_EXISTS;
			}
		});
		
			boolean returNingresult = printerJob.printDialog();
			if(returNingresult) {
				try {
					printerJob.print();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
}
