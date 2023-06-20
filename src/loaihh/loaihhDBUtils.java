package loaihh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class loaihhDBUtils {

	public static List<loaihh> queryLoaihh (Connection conn)throws SQLException{
		String sql="SELECT a.MaLoaihh,a.TenLoaihh FROM loaihh a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<loaihh> list =new ArrayList<loaihh>();
		while (rs.next()) {
			int MaLoaihh=rs.getInt("a.MaLoaihh");
			String TenLoaihh=rs.getString("a.TenLoaihh");
			loaihh loaihh = new loaihh();
			loaihh.setMaLoaihh(MaLoaihh);;
			loaihh.setTenLoaihh(TenLoaihh);;
			list.add(loaihh);
		}
		return list;
	}

	public static loaihh findLoaihh(Connection conn, int MaLoaihh) throws SQLException{
		String sql="SELECT a.MaLoaihh,a.TenLoaihh FROM loaihh a WHERE a.MaLoaihh=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaLoaihh);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String TenLoaihh=rs.getString("a.TenLoaihh");
			loaihh loaihh = new loaihh(MaLoaihh,TenLoaihh);
			return loaihh;
		}
		return null;
	}
	
	public static void updateLoaihh(Connection conn, loaihh loaihh) throws SQLException{
		String sql="UPDATE loaihh a SET a.TenLoaihh=? WHERE a.MaLoaihh=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, loaihh.getTenLoaihh());
		pstm.setInt(2, loaihh.getMaLoaihh());
		pstm.executeUpdate();
	}
	
	public static void insertLoaihh(Connection conn, loaihh loaihh) throws SQLException{
		String sql="INSERT INTO loaihh(MaLoaihh,TenLoaihh) VALUES (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, loaihh.getMaLoaihh());
		pstm.setString(2, loaihh.getTenLoaihh());
		pstm.executeUpdate();
	}
	
	public static void deleteLoaihh(Connection conn, int MaLoaihh) throws SQLException{
		String sql="DELETE FROM loaihh WHERE MaLoaihh=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaLoaihh);
		pstm.executeUpdate();
	}
}
