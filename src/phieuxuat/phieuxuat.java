package phieuxuat;

public class phieuxuat {

	private long maphieuxuat;
	private int makh;
	private int manv;
	private String ngaylapphieu;
	private float thanhtien;
	
	
	
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public long getMaphieuxuat() {
		return maphieuxuat;
	}
	public void setMaphieuxuat(long maphieuxuat) {
		this.maphieuxuat = maphieuxuat;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getNgaylapphieu() {
		return ngaylapphieu;
	}
	public void setNgaylapphieu(String ngaylapphieu) {
		this.ngaylapphieu = ngaylapphieu;
	}
	public float getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}
	

	public phieuxuat(long maphieuxuat, int makh, int manv, String ngaylapphieu, float thanhtien) {
		super();
		this.maphieuxuat = maphieuxuat;
		this.makh = makh;
		this.ngaylapphieu = ngaylapphieu;
		this.thanhtien = thanhtien;
		this.manv = manv;
	}
	public phieuxuat() {
		super();
	}
}
