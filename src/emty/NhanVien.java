package emty;

import java.time.LocalDate;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private LocalDate ngayVaoLam;
	private ChucVu maLoaiChucVu;
	private TaiKhoan tenTaiKhoan;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public ChucVu getMaLoaiChucVu() {
		return maLoaiChucVu;
	}
	public void setMaLoaiChucVu(ChucVu maLoaiChucVu) {
		this.maLoaiChucVu = maLoaiChucVu;
	}
	public TaiKhoan getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(TaiKhoan tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}
	public NhanVien(String maNhanVien, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
			LocalDate ngayVaoLam, ChucVu maLoaiChucVu, TaiKhoan tenTaiKhoan) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngayVaoLam = ngayVaoLam;
		this.maLoaiChucVu = maLoaiChucVu;
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi="
				+ diaChi + ", soDienThoai=" + soDienThoai + ", ngayVaoLam=" + ngayVaoLam + ", maLoaiChucVu="
				+ maLoaiChucVu + ", tenTaiKhoan=" + tenTaiKhoan + "]";
	}
	
	
	
}
