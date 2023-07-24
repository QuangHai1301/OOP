package emty;

public class Phong {
	private String maPhong;
	private String tenPhong;
	private LoaiPhong maLoaiPhong;
	private TrangThaiPhong maTrangThaiPhong;
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public LoaiPhong getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(LoaiPhong maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public TrangThaiPhong getMaTrangThaiPhong() {
		return maTrangThaiPhong;
	}
	public void setMaTrangThaiPhong(TrangThaiPhong maTrangThaiPhong) {
		this.maTrangThaiPhong = maTrangThaiPhong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
		Phong other = (Phong) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	public Phong(String maPhong, String tenPhong, LoaiPhong maLoaiPhong, TrangThaiPhong maTrangThaiPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.maLoaiPhong = maLoaiPhong;
		this.maTrangThaiPhong = maTrangThaiPhong;
	}
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", maLoaiPhong=" + maLoaiPhong
				+ ", maTrangThaiPhong=" + maTrangThaiPhong + "]";
	}
	
	
}
