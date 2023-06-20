package hoadon;

public class hoadon {

	
	private int maHD;
	private int maKH;
	private float thanhTien;
	private String ngayLapHD;
	
	
	
	public String getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(String NgayLapHD) {
		ngayLapHD = NgayLapHD;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int MaHD) {
		maHD = MaHD;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int MaKH) {
		maKH = MaKH;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float ThanhTien) {
		thanhTien = ThanhTien;
	}


	public hoadon(int MaHD, int MaKH, float ThanhTien, String NgayLapHD ) {

		maHD = MaHD;
		maKH = MaKH;
		thanhTien = ThanhTien;
		ngayLapHD=NgayLapHD;
	}

	public hoadon() {
		// TODO Auto-generated constructor stub
	}

}
