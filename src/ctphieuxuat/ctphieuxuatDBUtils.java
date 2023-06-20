package ctphieuxuat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ctphieuxuatDBUtils {

	public static List<ctphieuxuat> queryCtphieuxuat (Connection conn)throws SQLException{
		String sql="SELECT a.maphieuxuat,a.mahanghoa,a.soluong,a.dongia FROM ctphieuxuat a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<ctphieuxuat> list =new ArrayList<ctphieuxuat>();
		while (rs.next()) {
			long maphieuxuat=rs.getLong("a.maphieuxuat");
			int mahanghoa=rs.getInt("a.mahanghoa");
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieuxuat ctphieuxuat = new ctphieuxuat();
			ctphieuxuat.setMaphieuxuat(maphieuxuat);
			ctphieuxuat.setMahanghoa(mahanghoa);
			ctphieuxuat.setSoluong(soluong);
			ctphieuxuat.setDongia(dongia);
			list.add(ctphieuxuat);
		}
		return list;
	}
	
	public static ctphieuxuat findCtphieuxuat(Connection conn, long maphieuxuat, int mahanghoa) throws SQLException{
		String sql="SELECT a.maphieuxuat,a.mahanghoa,a.soluong,a.dongia FROM ctphieuxuat a WHERE a.maphieuxuat=? and a.mahanghoa=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieuxuat);
		pstm.setInt(2, mahanghoa);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			
			
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieuxuat ctphieuxuat = new ctphieuxuat(maphieuxuat,mahanghoa,soluong,dongia);
			return ctphieuxuat;
		}
		return null;
	}
	public static List<ctphieuxuat> findCtphieuxuat(Connection conn, long maphieuxuat) throws SQLException{
		String sql="SELECT a.maphieuxuat,a.mahanghoa,a.soluong,a.dongia FROM ctphieuxuat a WHERE a.maphieuxuat=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieuxuat);
		ResultSet rs = pstm.executeQuery();
		List<ctphieuxuat> list =new ArrayList<ctphieuxuat>();
		while (rs.next()) {
			
			int mahanghoa=rs.getInt("a.mahanghoa");
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieuxuat ctphieuxuat = new ctphieuxuat();
			ctphieuxuat.setMaphieuxuat(maphieuxuat);
			ctphieuxuat.setMahanghoa(mahanghoa);
			ctphieuxuat.setSoluong(soluong);
			ctphieuxuat.setDongia(dongia);
			list.add(ctphieuxuat);
		}
		return list;
	}
	
	public static void updateCtphieuxuat(Connection conn, ctphieuxuat ctphieuxuat) throws SQLException{
		String sql="UPDATE ctphieuxuat a SET  a.soluong=?,a.dongia=? WHERE a.maphieuxuat=? and a.mahanghoa=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		
		pstm.setInt(1, ctphieuxuat.getSoluong());
		pstm.setInt(2, ctphieuxuat.getDongia());
		pstm.setLong(3, ctphieuxuat.getMaphieuxuat());
		pstm.setInt(4, ctphieuxuat.getMahanghoa());
		pstm.executeUpdate();
	}
	
	public static void insertCtphieuxuat(Connection conn, ctphieuxuat ctphieuxuat) throws SQLException{
		String sql="INSERT INTO ctphieuxuat(maphieuxuat,mahanghoa,soluong,dongia) VALUES (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, ctphieuxuat.getMaphieuxuat());
		pstm.setInt(2, ctphieuxuat.getMahanghoa());
		pstm.setInt(3, ctphieuxuat.getSoluong());
		pstm.setInt(4, ctphieuxuat.getDongia());
		pstm.executeUpdate();
	}
	
	public static void deleteCtphieuxuat(Connection conn, long maphieuxuat,int mahanghoa) throws SQLException{
		String sql="DELETE FROM ctphieuxuat WHERE maphieuxuat=? and a.mahanghoa=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieuxuat);
		pstm.setInt(2, mahanghoa);
		pstm.executeUpdate();
	}


}
