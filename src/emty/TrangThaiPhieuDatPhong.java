package emty;

public class TrangThaiPhieuDatPhong {
	private String maTrangThaiPhieuDP;
	private String tenTrangThaiPhieuDP;
	public String getMaTrangThaiPhieuDP() {
		return maTrangThaiPhieuDP;
	}
	public void setMaTrangThaiPhieuDP(String maTrangThaiPhieuDP) {
		this.maTrangThaiPhieuDP = maTrangThaiPhieuDP;
	}
	public String getTenTrangThaiPhieuDP() {
		return tenTrangThaiPhieuDP;
	}
	public void setTenTrangThaiPhieuDP(String tenTrangThaiPhieuDP) {
		this.tenTrangThaiPhieuDP = tenTrangThaiPhieuDP;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTrangThaiPhieuDP == null) ? 0 : maTrangThaiPhieuDP.hashCode());
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
		TrangThaiPhieuDatPhong other = (TrangThaiPhieuDatPhong) obj;
		if (maTrangThaiPhieuDP == null) {
			if (other.maTrangThaiPhieuDP != null)
				return false;
		} else if (!maTrangThaiPhieuDP.equals(other.maTrangThaiPhieuDP))
			return false;
		return true;
	}
	public TrangThaiPhieuDatPhong(String maTrangThaiPhieuDP, String tenTrangThaiPhieuDP) {
		super();
		this.maTrangThaiPhieuDP = maTrangThaiPhieuDP;
		this.tenTrangThaiPhieuDP = tenTrangThaiPhieuDP;
	}
	public TrangThaiPhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TrangThaiPhieuDatPhong [maTrangThaiPhieuDP=" + maTrangThaiPhieuDP + ", tenTrangThaiPhieuDP="
				+ tenTrangThaiPhieuDP + "]";
	}
	
}
