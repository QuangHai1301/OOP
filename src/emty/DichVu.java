package emty;

public class DichVu {
	private String maDichVu;
	private LoaiDichVu loaiDichVu;
	private String tenDichVu;
	private float gia;
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	
	public LoaiDichVu getLoaiDichVu() {
		return loaiDichVu;
	}
	public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
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
		DichVu other = (DichVu) obj;
		if (maDichVu == null) {
			if (other.maDichVu != null)
				return false;
		} else if (!maDichVu.equals(other.maDichVu))
			return false;
		return true;
	}
	public DichVu(String maDichVu, LoaiDichVu maLoaiDichVu, String tenDichVu, float gia) {
		super();
		this.maDichVu = maDichVu;
		this.loaiDichVu = maLoaiDichVu;
		this.tenDichVu = tenDichVu;
		this.gia = gia;
	}
	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", maLoaiDichVu=" + loaiDichVu + ", tenDichVu=" + tenDichVu + ", gia="
				+ gia + "]";
	}
	
}
