package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDB.ConnectDB;
import QLKaraoke_Controller.Controller_DangNhap;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import java.awt.Color;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	public JTextField textTaiKhoanDN;
	public JPasswordField passwordMatKhauDN;
	public JButton btnDangNhap;
	public JButton btnXoaTrangDN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		
		ConnectDB connect = new ConnectDB();
		connect.getConnectDB();
		
		ActionListener action_DangNhap = new Controller_DangNhap(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 574, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 568, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_DangNhap = new JPanel();
		panel_DangNhap.setBackground(Color.WHITE);
		panel_DangNhap.setForeground(Color.WHITE);
		panel_DangNhap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DangNhap.setBounds(10, 11, 534, 93);
		panel.add(panel_DangNhap);
		panel_DangNhap.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("\u0110\u0103ng Nh\u00E2\u0323p");
		lblDangNhap.setBounds(172, 23, 192, 47);
		lblDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_DangNhap.add(lblDangNhap);
		
		JPanel panel_DangNhapInput = new JPanel();
		panel_DangNhapInput.setBackground(Color.WHITE);
		panel_DangNhapInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DangNhapInput.setBounds(10, 115, 534, 224);
		panel.add(panel_DangNhapInput);
		panel_DangNhapInput.setLayout(null);
		
		JLabel lblTaiKhoanDN = new JLabel("Ta\u0300i Khoa\u0309n");
		lblTaiKhoanDN.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblTaiKhoanDN.setBounds(96, 18, 98, 39);
		panel_DangNhapInput.add(lblTaiKhoanDN);
		
		JLabel lblMatKhauDN = new JLabel("M\u00E2\u0323t Kh\u00E2\u0309u");
		lblMatKhauDN.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblMatKhauDN.setBounds(103, 86, 91, 39);
		panel_DangNhapInput.add(lblMatKhauDN);
		
		textTaiKhoanDN = new JTextField();
		textTaiKhoanDN.setColumns(10);
		textTaiKhoanDN.setBounds(271, 22, 206, 39);
		panel_DangNhapInput.add(textTaiKhoanDN);
		
		btnDangNhap = new JButton("\u0110\u0103ng Nh\u00E2\u0323p");
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDangNhap.setBounds(96, 162, 128, 39);
		btnDangNhap.addActionListener(action_DangNhap);
		panel_DangNhapInput.add(btnDangNhap);
		
		passwordMatKhauDN = new JPasswordField();
		passwordMatKhauDN.setBounds(271, 90, 206, 39);
		panel_DangNhapInput.add(passwordMatKhauDN);
		
		btnXoaTrangDN = new JButton("Xo\u0301a Tr\u0103\u0301ng");
		btnXoaTrangDN.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnXoaTrangDN.setBounds(296, 162, 128, 39);
		btnXoaTrangDN.addActionListener(action_DangNhap);
		panel_DangNhapInput.add(btnXoaTrangDN);
	}
}