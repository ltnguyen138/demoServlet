package khachhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class khachhangDBUtils {

	public static List<khachhang> queryKhachhang (Connection conn)throws SQLException{
		String sql="SELECT a.MaKH,a.TenKH,a.EmailKH, a.SdtKH FROM khachhang a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<khachhang> list =new ArrayList<khachhang>();
		while (rs.next()) {
			int MaKH=rs.getInt("a.MaKH");
			String TenKH=rs.getString("a.TenKH");
			String EmailKH=rs.getString("a.EmailKH");
			String SdtKH=rs.getString("a.SdtKH");
			khachhang khachhang = new khachhang();
			khachhang.setMaKH(MaKH);
			khachhang.setTenKH(TenKH);
			khachhang.setEmailKH(EmailKH);
			khachhang.setSdtKH(SdtKH);
			list.add(khachhang);
		}
		return list;
	}
	public static List<khachhang> searchKhachhang(Connection conn, int search) throws SQLException{
		String sql="SELECT a.MaKH,a.TenKH,a.EmailKH, a.SdtKH FROM khachhang a WHERE a.MaKH=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, search);
		ResultSet rs = pstm.executeQuery();
		List<khachhang> list =new ArrayList<khachhang>();
		while (rs.next()) {
			int MaKH=rs.getInt("a.MaKH");
			String TenKH=rs.getString("a.TenKH");
			String EmailKH=rs.getString("a.EmailKH");
			String SdtKH=rs.getString("a.SdtKH");
			khachhang khachhang = new khachhang();
			khachhang.setMaKH(MaKH);
			khachhang.setTenKH(TenKH);
			khachhang.setEmailKH(EmailKH);
			khachhang.setSdtKH(SdtKH);
			list.add(khachhang);
			return list;
		}
		return null;
	}
	
	public static khachhang findKhachhang(Connection conn, int MaKH) throws SQLException{
		String sql="SELECT a.MaKH,a.TenKH,a.EmailKH, a.SdtKH FROM khachhang a WHERE a.MaKH=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaKH);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String TenKH=rs.getString("a.TenKH");
			String EmailKH=rs.getString("a.EmailKH");
			String SdtKH=rs.getString("a.SdtKH");
			khachhang khachhang = new khachhang(MaKH,TenKH,EmailKH,SdtKH);
			return khachhang;
		}
		return null;
	}
	
	public static void updateKhachhang(Connection conn, khachhang khachhang) throws SQLException{
		String sql="UPDATE khachhang a SET a.TenKH=?,a.EmailKH=?, a.SdtKH=? WHERE a.MaKH=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, khachhang.getTenKH());
		pstm.setString(2, khachhang.getEmailKH());
		pstm.setString(3, khachhang.getSdtKH());
		pstm.setInt(4, khachhang.getMaKH());
		pstm.executeUpdate();
	}
	
	public static void insertKhachhang(Connection conn, khachhang khachhang) throws SQLException{
		String sql="INSERT INTO khachhang(MaKH,TenKH,EmailKH,SdtKH) VALUES (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, khachhang.getMaKH());
		pstm.setString(2, khachhang.getTenKH());
		pstm.setString(3, khachhang.getEmailKH());
		pstm.setString(4, khachhang.getSdtKH());
		pstm.executeUpdate();
	}
	
	public static void deleteKhachhang(Connection conn, int MaKH) throws SQLException{
		String sql="DELETE FROM khachhang WHERE MaKH=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaKH);
		pstm.executeUpdate();
	}
}
