package emty;

public class QuyenTaiKhoan {
	private String MaQuyen;
	private String TenQuyen;
	public String getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		MaQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return TenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		TenQuyen = tenQuyen;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaQuyen == null) ? 0 : MaQuyen.hashCode());
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
		QuyenTaiKhoan other = (QuyenTaiKhoan) obj;
		if (MaQuyen == null) {
			if (other.MaQuyen != null)
				return false;
		} else if (!MaQuyen.equals(other.MaQuyen))
			return false;
		return true;
	}
	public QuyenTaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuyenTaiKhoan(String maQuyen, String tenQuyen) {
		super();
		MaQuyen = maQuyen;
		TenQuyen = tenQuyen;
	}
	@Override
	public String toString() {
		return "QuyenTaiKhoan [MaQuyen=" + MaQuyen + ", TenQuyen=" + TenQuyen + "]";
	}
	
	
}
