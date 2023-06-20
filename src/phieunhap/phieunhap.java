package phieunhap;

public class phieunhap {

	private long maphieunhap;
	private int mancc;
	private int mannv;
	private String ngaylapphieu;
	private float thanhtien;
	
	public int getMannv() {
		return mannv;
	}
	public void setMannv(int mannv) {
		this.mannv = mannv;
	}
	public long getMaphieunhap() {
		return maphieunhap;
	}
	public void setMaphieunhap(long maphieunhap) {
		this.maphieunhap = maphieunhap;
	}
	public int getMancc() {
		return mancc;
	}
	public void setMancc(int mancc) {
		this.mancc = mancc;
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
	
	public phieunhap(long maphieunhap, int mancc, int mannv, String ngaylapphieu, float thanhtien) {
		super();
		this.maphieunhap = maphieunhap;
		this.mancc = mancc;
		this.mannv = mannv;
		this.ngaylapphieu = ngaylapphieu;
		this.thanhtien = thanhtien;
	}
	public phieunhap() {
		super();
	}
	
}
