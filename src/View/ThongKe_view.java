package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ThongKe_view extends JFrame {

	public JPanel contentPane;
	public JTextField textField_ThoiGianThongKe;
	public JTable table_ThongKeDoanhThu;
	public JTextField textField_TongHoaDon;
	public JTextField textField_TongDoanhThu;
	public JTextField textField_HoTenNhanVien;
	public JTextField textField_ngayLapTK;
	public Main Main_view;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe_view frame = new ThongKe_view();
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
	public ThongKe_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 816, 805);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 780, 744);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Karaoke Nice");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(329, 11, 151, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(254, 178, 264, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số Điện Thoại :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(34, 56, 121, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Địa Chỉ :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(85, 89, 70, 22);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("03272849323 - 03847274834");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(165, 54, 194, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("188 Phường 2, Quận Gò Vấp, Thành Phố Hồ Chí Minh");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(165, 91, 423, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thời Gian Thống Kê :");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(343, 145, 181, 22);
		panel.add(lblNewLabel_2_1_1);
		
		textField_ThoiGianThongKe = new JTextField();
		textField_ThoiGianThongKe.setEditable(false);
		textField_ThoiGianThongKe.setBounds(528, 145, 151, 27);
		panel.add(textField_ThoiGianThongKe);
		textField_ThoiGianThongKe.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 245, 760, 386);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		table_ThongKeDoanhThu = new JTable();
		table_ThongKeDoanhThu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Tên Phòng", "Tên Nhân Viên", "Giờ Trả Phòng", "Trạng Thái", "Tổng Tiền"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table_ThongKeDoanhThu);
		scrollPane.setBounds(0, 0, 760, 386);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tổng Số Hóa Đơn :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(10, 642, 151, 22);
		panel.add(lblNewLabel_2_2);
		
		textField_TongHoaDon = new JTextField();
		textField_TongHoaDon.setEditable(false);
		textField_TongHoaDon.setBounds(165, 642, 154, 27);
		panel.add(textField_TongHoaDon);
		textField_TongHoaDon.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tổng Doanh Thu :");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(329, 641, 151, 22);
		panel.add(lblNewLabel_2_2_1);
		
		textField_TongDoanhThu = new JTextField();
		textField_TongDoanhThu.setEditable(false);
		textField_TongDoanhThu.setColumns(10);
		textField_TongDoanhThu.setBounds(484, 641, 156, 27);
		panel.add(textField_TongDoanhThu);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Họ Tên Nhân Viên :");
		lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_2_1_1.setBounds(10, 698, 151, 22);
		panel.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Ngày Lập :");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_2_1_1_1.setBounds(395, 698, 92, 22);
		panel.add(lblNewLabel_2_2_1_1_1);
		
		textField_HoTenNhanVien = new JTextField();
		textField_HoTenNhanVien.setEditable(false);
		textField_HoTenNhanVien.setBounds(165, 698, 161, 27);
		panel.add(textField_HoTenNhanVien);
		textField_HoTenNhanVien.setColumns(10);
		
		textField_ngayLapTK = new JTextField();
		textField_ngayLapTK.setEditable(false);
		textField_ngayLapTK.setColumns(10);
		textField_ngayLapTK.setBounds(484, 698, 156, 27);
		panel.add(textField_ngayLapTK);
	}
	public void InThongKe(JPanel jpanel) {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setJobName("Thống kê");
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
					System.out.println("lỗi bên hàm in thống kê !");
				}
			}
	}
	
	
	
	
	
	
}
