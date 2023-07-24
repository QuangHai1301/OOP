package emty;

public class ChucVu {
	private String maLoaiChucVu;
	private String tenLoaiChucVu;
	public String getMaLoaiChucVu() {
		return maLoaiChucVu;
	}
	public void setMaLoaiChucVu(String maLoaiChucVu) {
		this.maLoaiChucVu = maLoaiChucVu;
	}
	public String getTenLoaiChucVu() {
		return tenLoaiChucVu;
	}
	public void setTenLoaiChucVu(String tenLoaiChucVu) {
		this.tenLoaiChucVu = tenLoaiChucVu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiChucVu == null) ? 0 : maLoaiChucVu.hashCode());
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
		ChucVu other = (ChucVu) obj;
		if (maLoaiChucVu == null) {
			if (other.maLoaiChucVu != null)
				return false;
		} else if (!maLoaiChucVu.equals(other.maLoaiChucVu))
			return false;
		return true;
	}
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChucVu(String maLoaiChucVu, String tenLoaiChucVu) {
		super();
		this.maLoaiChucVu = maLoaiChucVu;
		this.tenLoaiChucVu = tenLoaiChucVu;
	}
	@Override
	public String toString() {
		return "ChucVu [maLoaiChucVu=" + maLoaiChucVu + ", tenLoaiChucVu=" + tenLoaiChucVu + "]";
	}
	
}
