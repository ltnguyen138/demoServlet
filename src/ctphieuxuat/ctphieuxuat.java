package ctphieuxuat;

public class ctphieuxuat {

	private long maphieuxuat;
	private int mahanghoa;
	private int soluong;
	private int dongia;
	public long getMaphieuxuat() {
		return maphieuxuat;
	}
	public void setMaphieuxuat(long maphieuxuat) {
		this.maphieuxuat = maphieuxuat;
	}
	public int getMahanghoa() {
		return mahanghoa;
	}
	public void setMahanghoa(int mahanghoa) {
		this.mahanghoa = mahanghoa;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public ctphieuxuat(long maphieuxuat, int mahanghoa, int soluong, int dongia) {
		super();
		this.maphieuxuat = maphieuxuat;
		this.mahanghoa = mahanghoa;
		this.soluong = soluong;
		this.dongia = dongia;
	}
	public ctphieuxuat() {
		super();
	}
	

}
