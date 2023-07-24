package emty;

public class TrangThaiPhong {
	private String maLoaiTrangThai;
	private String tenTrangThaiPhong;
	public String getMaLoaiTrangThai() {
		return maLoaiTrangThai;
	}
	public void setMaLoaiTrangThai(String maLoaiTrangThai) {
		this.maLoaiTrangThai = maLoaiTrangThai;
	}
	public String getTenTrangThaiPhong() {
		return tenTrangThaiPhong;
	}
	public void setTenTrangThaiPhong(String tenTrangThaiPhong) {
		this.tenTrangThaiPhong = tenTrangThaiPhong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiTrangThai == null) ? 0 : maLoaiTrangThai.hashCode());
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
		TrangThaiPhong other = (TrangThaiPhong) obj;
		if (maLoaiTrangThai == null) {
			if (other.maLoaiTrangThai != null)
				return false;
		} else if (!maLoaiTrangThai.equals(other.maLoaiTrangThai))
			return false;
		return true;
	}
	public TrangThaiPhong(String maLoaiTrangThai, String tenTrangThaiPhong) {
		super();
		this.maLoaiTrangThai = maLoaiTrangThai;
		this.tenTrangThaiPhong = tenTrangThaiPhong;
	}
	public TrangThaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TrangThaiPhong [maLoaiTrangThai=" + maLoaiTrangThai + ", tenTrangThaiPhong=" + tenTrangThaiPhong + "]";
	}
	
}
