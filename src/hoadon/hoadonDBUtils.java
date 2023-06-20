package hoadon;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


public class hoadonDBUtils {

	public static List<hoadon> queryHoadon (Connection conn)throws SQLException{
		String sql="SELECT a.MaHD,a.MaKH,a.ThanhTien,a.NgayLapHD FROM hoadon a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<hoadon> list =new ArrayList<hoadon>();
		while (rs.next()) {
			int MaHD=rs.getInt("a.MaHD");
			int MaKH=rs.getInt("a.MaKH");
			float ThanhTien=rs.getFloat("a.ThanhTien");
			String NgayLapHD=rs.getString("a.NgayLapHD");
			hoadon hoadon = new hoadon();
			hoadon.setMaHD(MaHD);
			hoadon.setMaKH(MaKH);
			hoadon.setThanhTien(ThanhTien);
			hoadon.setNgayLapHD(NgayLapHD);
			list.add(hoadon);
		}
		return list;
	}
	
	public static hoadon findHoadon(Connection conn, int MaHD) throws SQLException{
		String sql="SELECT a.MaHD,a.MaKH,a.ThanhTien,a.NgayLapHD FROM hoadon a WHERE a.MaHD=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaHD);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int MaKH=rs.getInt("a.MaKH");
			float ThanhTien=rs.getFloat("a.ThanhTien");
			String NgayLapHD=rs.getString("a.NgayLapHD");
			hoadon hoadon = new hoadon(MaHD,MaKH,ThanhTien,NgayLapHD);
			return hoadon;
		}
		return null;
	}
	
	public static void updateHoadon(Connection conn, hoadon hoadon) throws SQLException{
		String sql="UPDATE hoadon a SET a.MaKH=?,a.ThanhTien=?,a.NgayLapHD=? WHERE a.MaHD=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, hoadon.getMaKH());
		pstm.setFloat(2, hoadon.getThanhTien());
		pstm.setString(3, hoadon.getNgayLapHD());
		pstm.setInt(4, hoadon.getMaHD());
		pstm.executeUpdate();
	}
	
	public static void insertHoadon(Connection conn, hoadon hoadon) throws SQLException{
		String sql="INSERT INTO hoadon(MaHD,MaKH,ThanhTien,NgayLapHD) VALUES (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, hoadon.getMaHD());
		pstm.setInt(2, hoadon.getMaKH());
		pstm.setFloat(3, hoadon.getThanhTien());
		pstm.setString(4, hoadon.getNgayLapHD());
		
		pstm.executeUpdate();
	}
	
	public static void deleteHoadon(Connection conn, int MaHD) throws SQLException{
		String sql="DELETE FROM hoadon WHERE  MaHD=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaHD);
		pstm.executeUpdate();
	}

}
