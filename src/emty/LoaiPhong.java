package emty;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private float giaPhong;
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public float getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(float giaPhong) {
		this.giaPhong = giaPhong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiPhong == null) ? 0 : maLoaiPhong.hashCode());
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
		LoaiPhong other = (LoaiPhong) obj;
		if (maLoaiPhong == null) {
			if (other.maLoaiPhong != null)
				return false;
		} else if (!maLoaiPhong.equals(other.maLoaiPhong))
			return false;
		return true;
	}
	public LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, float giaPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.giaPhong = giaPhong;
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", giaPhong=" + giaPhong
				+ "]";
	}
	
	
}
