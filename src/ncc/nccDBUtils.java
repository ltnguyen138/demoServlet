package ncc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class nccDBUtils {

	public static List<ncc> queryNcc (Connection conn)throws SQLException{
		String sql="SELECT a.MaNCC,a.TenNCC,a.EmailNCC, a.DiaChiNCC,a.SdtNCC FROM ncc a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<ncc> list =new ArrayList<ncc>();
		while (rs.next()) {
			int MaNCC=rs.getInt("a.MaNCC");
			String TenNCC=rs.getString("a.TenNCC");
			String EmailNCC=rs.getString("a.EmailNCC");
			String DiaChiNCC=rs.getString("a.DiaChiNCC");
			String SdtNCC=rs.getString("a.SdtNCC");
			ncc ncc = new ncc();
			ncc.setMaNCC(MaNCC);
			ncc.setTenNCC(TenNCC);
			ncc.setEmailNCC(EmailNCC);
			ncc.setDiaChiNCC(DiaChiNCC);
			ncc.setSdtNCC(SdtNCC);
			list.add(ncc);
		}
		return list;
	}
	
	public static List<ncc> searchNcc(Connection conn, int search) throws SQLException{
		String sql="SELECT a.MaNCC,a.TenNCC,a.EmailNCC, a.DiaChiNCC,a.SdtNCC FROM ncc a WHERE a.MaNCC=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, search);
		ResultSet rs = pstm.executeQuery();
		List<ncc> list =new ArrayList<ncc>();
		while (rs.next()) {
			int MaNCC=rs.getInt("a.MaNCC");
			String TenNCC=rs.getString("a.TenNCC");
			String EmailNCC=rs.getString("a.EmailNCC");
			String DiaChiNCC=rs.getString("a.DiaChiNCC");
			String SdtNCC=rs.getString("a.SdtNCC");
			ncc ncc = new ncc();
			ncc.setMaNCC(MaNCC);
			ncc.setTenNCC(TenNCC);
			ncc.setEmailNCC(EmailNCC);
			ncc.setDiaChiNCC(DiaChiNCC);
			ncc.setSdtNCC(SdtNCC);
			list.add(ncc);
			
		}
		return list;
	
	}
	
	public static ncc findNcc(Connection conn, int MaNCC) throws SQLException{
		String sql="SELECT a.MaNCC,a.TenNCC,a.EmailNCC, a.DiaChiNCC,a.SdtNCC FROM ncc a WHERE a.MaNCC=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaNCC);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String TenNCC=rs.getString("a.TenNCC");
			String EmailNCC=rs.getString("a.EmailNCC");
			String DiaChiNCC=rs.getString("a.DiaChiNCC");
			String SdtNCC=rs.getString("a.SdtNCC");
			ncc ncc = new ncc(MaNCC,TenNCC,EmailNCC,DiaChiNCC,SdtNCC);
			return ncc;
		}
		return null;
	}
	
	public static void updateNcc(Connection conn, ncc ncc) throws SQLException{
		String sql="UPDATE ncc a SET a.TenNCC=?,a.EmailNCC=?, a.DiaChiNCC=?,a.SdtNCC=? WHERE a.MaNCC=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, ncc.getTenNCC());
		pstm.setString(2, ncc.getEmailNCC());
		pstm.setString(3, ncc.getDiaChiNCC());
		pstm.setString(4, ncc.getSdtNCC());
		pstm.setInt(5, ncc.getMaNCC());
		pstm.executeUpdate();
	}
	
	public static void insertNcc(Connection conn, ncc ncc) throws SQLException{
		String sql="INSERT INTO ncc(MaNCC,TenNCC,EmailNCC,DiaChiNCC,SdtNCC) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, ncc.getMaNCC());
		pstm.setString(2, ncc.getTenNCC());
		pstm.setString(3, ncc.getEmailNCC());
		pstm.setString(4, ncc.getDiaChiNCC());
		pstm.setString(5, ncc.getSdtNCC());
		pstm.executeUpdate();
	}
	
	public static void deleteNcc(Connection conn, int MaNCC) throws SQLException{
		String sql="DELETE FROM ncc WHERE MaNCC=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaNCC);
		pstm.executeUpdate();
	}
}
