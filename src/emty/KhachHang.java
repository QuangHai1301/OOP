package emty;

public class KhachHang {
	private String MaKH;
	private TaiKhoan tenTaiKhoan;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public TaiKhoan getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(TaiKhoan tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaKH == null) ? 0 : MaKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (MaKH == null) {
			if (other.MaKH != null)
				return false;
		} else if (!MaKH.equals(other.MaKH))
			return false;
		return true;
	}
	public KhachHang(String maKH, TaiKhoan tenTaiKhoan, String hoTen, String diaChi, String soDienThoai) {
		super();
		MaKH = maKH;
		this.tenTaiKhoan = tenTaiKhoan;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH) {
		super();
		MaKH = maKH;
	}
	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", tenTaiKhoan=" + tenTaiKhoan + ", hoTen=" + hoTen + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + "]";
	}
	
	
}
