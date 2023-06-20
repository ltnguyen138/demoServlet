package ctphieunhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ctphieunhapDBUtils {

	public static List<ctphieunhap> queryCtphieunhap (Connection conn)throws SQLException{
		String sql="SELECT a.maphieunhap,a.mahanghoa,a.tenhanghoa,a.soluong,a.dongia FROM ctphieunhap a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<ctphieunhap> list =new ArrayList<ctphieunhap>();
		while (rs.next()) {
			long maphieunhap=rs.getLong("a.maphieunhap");
			int mahanghoa=rs.getInt("a.mahanghoa");
			String tenhanghoa=rs.getString("a.tenhanghoa");
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieunhap ctphieunhap = new ctphieunhap();
			ctphieunhap.setMaphieu(maphieunhap);
			ctphieunhap.setMahanghoa(mahanghoa);
			ctphieunhap.setTenhanghoa(tenhanghoa);
			ctphieunhap.setSoluong(soluong);
			ctphieunhap.setDongia(dongia);
			list.add(ctphieunhap);
		}
		return list;
	}
	public static ctphieunhap searchCtphieunhap(Connection conn, String search) throws SQLException{
		long searchm= 0;
		try {
			searchm = Long.parseLong(search);
		}catch (Exception e) {
			searchm= 0;
		}
		String sql="SELECT a.maphieunhap,a.mahanghoa,a.tenhanghoa,a.soluong,a.dongia FROM ctphieunhap a WHERE a.maphieunhap=?  "; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1,searchm );
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			long maphieunhap=rs.getLong("a.maphieunhap");
			int mahanghoa=rs.getInt("a.mahanghoa");
			String tenhanghoa=rs.getString("a.tenhanghoa");
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieunhap ctphieunhap = new ctphieunhap(maphieunhap,mahanghoa,tenhanghoa,soluong,dongia);
			return ctphieunhap;
		}
		return null;
	}
	public static ctphieunhap findCtphieunhap(Connection conn, long maphieunhap, int mahanghoa) throws SQLException{
		String sql="SELECT a.maphieunhap,a.mahanghoa,a.tenhanghoa,a.soluong,a.dongia FROM ctphieunhap a WHERE a.maphieunhap=? and a.mahanghoa=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieunhap);
		pstm.setInt(2, mahanghoa);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			
			String tenhanghoa=rs.getString("a.tenhanghoa");
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieunhap ctphieunhap = new ctphieunhap(maphieunhap,mahanghoa,tenhanghoa,soluong,dongia);
			return ctphieunhap;
		}
		return null;
	}
	public static List<ctphieunhap> findCtphieunhap(Connection conn, long maphieunhap) throws SQLException{
		String sql="SELECT a.maphieunhap,a.mahanghoa,a.tenhanghoa,a.soluong,a.dongia FROM ctphieunhap a WHERE a.maphieunhap=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieunhap);
		ResultSet rs = pstm.executeQuery();
		List<ctphieunhap> list =new ArrayList<ctphieunhap>();
		while (rs.next()) {
			
			int mahanghoa=rs.getInt("a.mahanghoa");
			String tenhanghoa=rs.getString("a.tenhanghoa");
			int soluong=rs.getInt("a.soluong");
			int dongia=rs.getInt("a.dongia");
			ctphieunhap ctphieunhap = new ctphieunhap();
			ctphieunhap.setMaphieu(maphieunhap);
			ctphieunhap.setMahanghoa(mahanghoa);
			ctphieunhap.setTenhanghoa(tenhanghoa);
			ctphieunhap.setSoluong(soluong);
			ctphieunhap.setDongia(dongia);
			list.add(ctphieunhap);
		}
		return list;
	}
	
	public static void updateCtphieunhap(Connection conn, ctphieunhap ctphieunhap) throws SQLException{
		String sql="UPDATE ctphieunhap a SET  a.soluong=?,a.dongia=? WHERE a.maphieunhap=? and a.mahanghoa=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		
		pstm.setInt(1, ctphieunhap.getSoluong());
		pstm.setInt(2, ctphieunhap.getDongia());
		pstm.setLong(3, ctphieunhap.getMaphieu());
		pstm.setInt(4, ctphieunhap.getMahanghoa());
		pstm.executeUpdate();
	}
	
	public static void insertCtphieunhap(Connection conn, ctphieunhap ctphieunhap) throws SQLException{
		String sql="INSERT INTO ctphieunhap(maphieunhap,mahanghoa,tenhanghoa,soluong,dongia) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, ctphieunhap.getMaphieu());
		pstm.setInt(2, ctphieunhap.getMahanghoa());
		pstm.setString(3, ctphieunhap.getTenhanghoa());
		pstm.setInt(4, ctphieunhap.getSoluong());
		pstm.setInt(5, ctphieunhap.getDongia());
		pstm.executeUpdate();
	}
	
	public static void deleteCtphieunhap(Connection conn, long maphieunhap,int mahanghoa) throws SQLException{
		String sql="DELETE FROM ctphieunhap WHERE maphieunhap=? and a.mahanghoa=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieunhap);
		pstm.setInt(2, mahanghoa);
		pstm.executeUpdate();
	}

}
