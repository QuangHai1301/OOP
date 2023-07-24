package emty;

public class TrangThaiHoaDon {
	private String maTrangThaiHoaDon;
	private String tenTrangThaiHoaDon;
	public String getMaTrangThaiHoaDon() {
		return maTrangThaiHoaDon;
	}
	public void setMaTrangThaiHoaDon(String maTrangThaiHoaDon) {
		this.maTrangThaiHoaDon = maTrangThaiHoaDon;
	}
	public String getTenTrangThaiHoaDon() {
		return tenTrangThaiHoaDon;
	}
	public void setTenTrangThaiHoaDon(String tenTrangThaiHoaDon) {
		this.tenTrangThaiHoaDon = tenTrangThaiHoaDon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTrangThaiHoaDon == null) ? 0 : maTrangThaiHoaDon.hashCode());
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
		TrangThaiHoaDon other = (TrangThaiHoaDon) obj;
		if (maTrangThaiHoaDon == null) {
			if (other.maTrangThaiHoaDon != null)
				return false;
		} else if (!maTrangThaiHoaDon.equals(other.maTrangThaiHoaDon))
			return false;
		return true;
	}
	public TrangThaiHoaDon(String maTrangThaiHoaDon, String tenTrangThaiHoaDon) {
		super();
		this.maTrangThaiHoaDon = maTrangThaiHoaDon;
		this.tenTrangThaiHoaDon = tenTrangThaiHoaDon;
	}
	public TrangThaiHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TrangThaiHoaDon [maTrangThaiHoaDon=" + maTrangThaiHoaDon + ", tenTrangThaiHoaDon=" + tenTrangThaiHoaDon
				+ "]";
	}
	
}
