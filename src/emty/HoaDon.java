package emty;

import java.time.LocalDateTime;

public class HoaDon {
	private String maHoaDon;
	private NhanVien maNhanVien;
	private LocalDateTime ngayGioRa;
	private TrangThaiHoaDon maLoaiTrangThaiHoaDon;
	private float TongTien;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public LocalDateTime getNgayGioRa() {
		return ngayGioRa;
	}
	public void setNgayGioRa(LocalDateTime ngayGioRa) {
		this.ngayGioRa = ngayGioRa;
	}
	public TrangThaiHoaDon getMaLoaiTrangThaiHoaDon() {
		return maLoaiTrangThaiHoaDon;
	}
	public void setMaLoaiTrangThaiHoaDon(TrangThaiHoaDon maLoaiTrangThaiHoaDon) {
		this.maLoaiTrangThaiHoaDon = maLoaiTrangThaiHoaDon;
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		return true;
	}
	public HoaDon(String maHoaDon, NhanVien maNhanVien, LocalDateTime ngayGioRa, TrangThaiHoaDon maLoaiTrangThaiHoaDon,
			float tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.ngayGioRa = ngayGioRa;
		this.maLoaiTrangThaiHoaDon = maLoaiTrangThaiHoaDon;
		TongTien = tongTien;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", ngayGioRa=" + ngayGioRa
				+ ", maLoaiTrangThaiHoaDon=" + maLoaiTrangThaiHoaDon + ", TongTien=" + TongTien + "]";
	}
	
	
	
}
