package ctphieunhap;

public class ctphieunhap {

	private long maphieu;
	private int mahanghoa;
	private String tenhanghoa;
	private int soluong;
	private int dongia;
	
	public String getTenhanghoa() {
		return tenhanghoa;
	}
	public void setTenhanghoa(String tenhanghoa) {
		this.tenhanghoa = tenhanghoa;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public long getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(long maphieu) {
		this.maphieu = maphieu;
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
	
	
	public ctphieunhap(long maphieu, int mahanghoa, String tenhanghoa, int soluong, int dongia) {
		super();
		this.maphieu = maphieu;
		this.mahanghoa = mahanghoa;
		this.tenhanghoa = tenhanghoa;
		this.soluong = soluong;
		this.dongia = dongia;
	}
	public ctphieunhap() {
		super();
	}
	

}
