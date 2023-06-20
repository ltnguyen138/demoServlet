package khachhang;

public class khachhang {

	private int maKH;
	private String tenKH;
	private String emailKH;
	private String sdtKH;
	
	
	public int getMaKH() {
		return maKH;
	}


	public void setMaKH(int MaKH) {
		maKH = MaKH;
	}


	public String getTenKH() {
		return tenKH;
	}


	public void setTenKH(String TenKH) {
		tenKH = TenKH;
	}


	public String getEmailKH() {
		return emailKH;
	}


	public void setEmailKH(String EmailKH) {
		emailKH = EmailKH;
	}


	public String getSdtKH() {
		return sdtKH;
	}


	public void setSdtKH(String SdtKH) {
		sdtKH = SdtKH;
	}

	
	public khachhang(int MaKH, String TenKH, String EmailKH, String SdtKH) {

		maKH = MaKH;
		tenKH = TenKH;
		emailKH = EmailKH;
		sdtKH = SdtKH;
	}


	public khachhang() {
		// TODO Auto-generated constructor stub
	}

}
