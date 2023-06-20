package hanghoa;

public class hanghoa {

	private int maHH;
	private String tenHH;
	private int maNCC;
	private int soluong;
	private float donGia;
	
	
	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getMaHH() {
		return maHH;
	}

	public void setMaHH(int MaHH) {
		maHH = MaHH;
	}

	public String getTenHH() {
		return tenHH;
	}

	public void setTenHH(String TenHH) {
		tenHH = TenHH;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int MaNCC) {
		maNCC = MaNCC;
	}



	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float DonGia) {
		donGia = DonGia;
	}

	

	
	public hanghoa(int maHH, String tenHH, int maNCC, int soluong, float donGia) {
		super();
		this.maHH = maHH;
		this.tenHH = tenHH;
		this.maNCC = maNCC;
		this.soluong = soluong;
		this.donGia = donGia;
	}

	public hanghoa() {
		// TODO Auto-generated constructor stub
	}

}
