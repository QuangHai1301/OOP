package emty;

public class LoaiDichVu {
	private String maLoaiDichVu;
	private String tenLoaiDichVu;
	public String getMaLoaiDichVu() {
		return maLoaiDichVu;
	}
	public void setMaLoaiDichVu(String maLoaiDichVu) {
		this.maLoaiDichVu = maLoaiDichVu;
	}
	public String getTenLoaiDichVu() {
		return tenLoaiDichVu;
	}
	public void setTenLoaiDichVu(String tenLoaiDichVu) {
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiDichVu == null) ? 0 : maLoaiDichVu.hashCode());
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
		LoaiDichVu other = (LoaiDichVu) obj;
		if (maLoaiDichVu == null) {
			if (other.maLoaiDichVu != null)
				return false;
		} else if (!maLoaiDichVu.equals(other.maLoaiDichVu))
			return false;
		return true;
	}
	public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu) {
		super();
		this.maLoaiDichVu = maLoaiDichVu;
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	public LoaiDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoaiDichVu(String tenLoaiDichVu) {
		super();
		this.tenLoaiDichVu = tenLoaiDichVu;
	}
	@Override
	public String toString() {
		return "LoaiDichVu [maLoaiDichVu=" + maLoaiDichVu + ", tenLoaiDichVu=" + tenLoaiDichVu + "]";
	}
	
}
