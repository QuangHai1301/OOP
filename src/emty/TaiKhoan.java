package emty;

public class TaiKhoan {
	private String TenTK;
	private String MK;
	//private String MaQuyenHan;
	private QuyenTaiKhoan maQuyenHan;
	
	
	public QuyenTaiKhoan getMaQuyen() {
		return maQuyenHan;
	}
	public void setMaQuyen(QuyenTaiKhoan maQuyen) {
		this.maQuyenHan = maQuyen;
	}
	public String getTenTK() {
		return TenTK;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}
	public String getMK() {
		return MK;
	}
	public void setMK(String mK) {
		MK = mK;
	}
//	public String getMaQuyenHan() {
//		return MaQuyenHan;
//	}
//	public void setMaQuyenHan(String maQuyenHan) {
//		MaQuyenHan = maQuyenHan;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TenTK == null) ? 0 : TenTK.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (TenTK == null) {
			if (other.TenTK != null)
				return false;
		} else if (!TenTK.equals(other.TenTK))
			return false;
		return true;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String tenTK, String mK, QuyenTaiKhoan maQuyenHan) {
		super();
		this.TenTK = tenTK;
		this.MK = mK;
		//MaQuyenHan = maQuyenHan;
		this.maQuyenHan = maQuyenHan;
	}
	public TaiKhoan(String tenTK, String mK) {
		super();
		TenTK = tenTK;
		MK = mK;
	}
	public TaiKhoan(String tenTK) {
		super();
		this.TenTK = tenTK;
	}
	@Override
	public String toString() {
		return "TaiKhoan [TenTK=" + TenTK + ", MK=" + MK + ", MaQuyenHan=" + maQuyenHan + "]";
	}
	
	
	
}
