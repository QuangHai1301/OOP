package emty;

public class ChiTietHoaDon {
	private HoaDon maHoaDon;
	private DichVu maDichVu;
	private PhieuDatPhong maDatPhong;
	private int soLuong;
	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public DichVu getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(DichVu maDichVu) {
		this.maDichVu = maDichVu;
	}
	public PhieuDatPhong getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(PhieuDatPhong maDatPhong) {
		this.maDatPhong = maDatPhong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon(HoaDon maHoaDon, DichVu maDichVu, PhieuDatPhong maDatPhong, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maDichVu = maDichVu;
		this.maDatPhong = maDatPhong;
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maDichVu=" + maDichVu + ", maDatPhong=" + maDatPhong
				+ ", soLuong=" + soLuong + "]";
	}
	
	
	
}
