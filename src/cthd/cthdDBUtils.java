package cthd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class cthdDBUtils {

	public static List<cthd> queryCthd (Connection conn)throws SQLException{
		String sql="SELECT a.MaHD,a.MaHH,a.SoLuong FROM cthd a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<cthd> list =new ArrayList<cthd>();
		while (rs.next()) {
			int MaHD=rs.getInt("a.MaHD");
			int MaHH=rs.getInt("a.MaHH");
			int SoLuong=rs.getInt("a.SoLuong");

			cthd cthd = new cthd();
			cthd.setMaHD(MaHD);
			cthd.setMaHH(MaHH);
			cthd.setSoLuong(SoLuong);
			list.add(cthd);
		}
		return list;
	}
	
	public static cthd findCthd(Connection conn, int MaHD) throws SQLException{
		String sql="SELECT a.MaHD,a.MaHH,a.SoLuong FROM cthd a WHERE a.MaHD=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaHD);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int MaHH=rs.getInt("a.MaHH");
			int SoLuong=rs.getInt("a.SoLuong");
			cthd cthd = new cthd(MaHD,MaHH,SoLuong);
			return cthd;
		}
		return null;
	}
	
	public static void updateCthd(Connection conn, cthd cthd) throws SQLException{
		String sql="UPDATE cthd a SET  a.MaHH=?,a.SoLuong=? WHERE a.MaHD=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, cthd.getMaHH());
		pstm.setInt(2, cthd.getSoLuong());
		pstm.setInt(3, cthd.getMaHD());
		pstm.executeUpdate();
	}
	
	public static void insertCthd(Connection conn, cthd cthd) throws SQLException{
		String sql="INSERT INTO cthd(MaHD,MaHH,SoLuong) VALUES (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, cthd.getMaHD());
		pstm.setInt(2, cthd.getMaHH());
		pstm.setInt(3, cthd.getSoLuong());
		
		pstm.executeUpdate();
	}
	
	public static void deleteCthd(Connection conn, int MaHD) throws SQLException{
		String sql="DELETE FROM cthd WHERE MaHD=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaHD);
		pstm.executeUpdate();
	}

}
