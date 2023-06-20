package ncc;

public class ncc {

	private int maNCC;
	private String tenNCC;
	private String emailNCC;
	private String diaChiNCC;
	private String sdtNCC;
	
	
	public String getSdtNCC() {
		return sdtNCC;
	}

	public void setSdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int MaNCC) {
		maNCC = MaNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String TenNCC) {
		tenNCC = TenNCC;
	}

	public String getEmailNCC() {
		return emailNCC;
	}

	public void setEmailNCC(String EmailNCC) {
		emailNCC = EmailNCC;
	}

	public String getDiaChiNCC() {
		return diaChiNCC;
	}

	public void setDiaChiNCC(String DiaChiNCC) {
		diaChiNCC = DiaChiNCC;
	}

	
	public ncc(int MaNCC, String TenNCC, String EmailNCC, String DiaChiNCC,String SdtNCC) {

		  maNCC= MaNCC;
		tenNCC = TenNCC;
		emailNCC = EmailNCC;
		diaChiNCC = DiaChiNCC;
		sdtNCC=SdtNCC;
	}

	public ncc() {
		
	}

}
