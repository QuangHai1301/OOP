package emty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PhieuDatPhong {
	private String maDatPhong;
	private Phong maPhong;
	private KhachHang maKhachHang;
	private NhanVien maNhanVien;
	private int soNguoi;
	private LocalDateTime ngayDat;
	private LocalDateTime ngayGioVao;
	private String ghiChu;
	private TrangThaiPhieuDatPhong maTrangThaiPhieuDP;
	public String getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(String maDatPhong) {
		this.maDatPhong = maDatPhong;
	}
	public Phong getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}
	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public LocalDateTime getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(LocalDateTime ngayDat) {
		this.ngayDat = ngayDat;
	}
	public LocalDateTime getNgayGioVao() {
		return ngayGioVao;
	}
	public void setNgayGioVao(LocalDateTime ngayGioVao) {
		this.ngayGioVao = ngayGioVao;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public TrangThaiPhieuDatPhong getMaTrangThaiPhieuDP() {
		return maTrangThaiPhieuDP;
	}
	public void setMaTrangThaiPhieuDP(TrangThaiPhieuDatPhong maTrangThaiPhieuDP) {
		this.maTrangThaiPhieuDP = maTrangThaiPhieuDP;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDatPhong == null) ? 0 : maDatPhong.hashCode());
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
		PhieuDatPhong other = (PhieuDatPhong) obj;
		if (maDatPhong == null) {
			if (other.maDatPhong != null)
				return false;
		} else if (!maDatPhong.equals(other.maDatPhong))
			return false;
		return true;
	}
	public PhieuDatPhong(String maDatPhong, Phong maPhong, KhachHang maKhachHang, NhanVien maNhanVien, int soNguoi,
			LocalDateTime ngayDat, LocalDateTime ngayGioVao, String ghiChu, TrangThaiPhieuDatPhong maTrangThaiPhieuDP) {
		super();
		this.maDatPhong = maDatPhong;
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.soNguoi = soNguoi;
		this.ngayDat = ngayDat;
		this.ngayGioVao = ngayGioVao;
		this.ghiChu = ghiChu;
		this.maTrangThaiPhieuDP = maTrangThaiPhieuDP;
	}
	public PhieuDatPhong(String maDatPhong) {
		super();
		this.maDatPhong = maDatPhong;
	}
	public PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maDatPhong=" + maDatPhong + ", maPhong=" + maPhong + ", maKhachHang=" + maKhachHang
				+ ", maNhanVien=" + maNhanVien + ", soNguoi=" + soNguoi + ", ngayDat=" + ngayDat + ", ngayGioVao="
				+ ngayGioVao + ", ghiChu=" + ghiChu + ", maTrangThaiPhieuDP=" + maTrangThaiPhieuDP + "]";
	}
	
	
}
