package hanghoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class hanghoaDBUtils {

	public static List<hanghoa> queryHanghoa (Connection conn)throws SQLException{
		String sql="SELECT a.MaHH,a.TenHH,a.MaNCC, a.soluong, a.DonGia FROM hanghoa a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<hanghoa> list =new ArrayList<hanghoa>();
		while (rs.next()) {
			int MaHH=rs.getInt("a.MaHH");
			String TenHH=rs.getString("a.TenHH");
			int MaNCC=rs.getInt("a.MaNCC");
			int soluong=rs.getInt("a.soluong");
			float DonGia=rs.getFloat("a.DonGia");
			hanghoa hanghoa = new hanghoa();
			hanghoa.setMaHH(MaHH);
			hanghoa.setTenHH(TenHH);
			hanghoa.setMaNCC(MaNCC);
			hanghoa.setSoluong(soluong);
			hanghoa.setDonGia(DonGia);
			list.add(hanghoa);
		}
		return list;
	}
	
	public static List<hanghoa> searchHanghoa(Connection conn, int search) throws SQLException{
		String sql="SELECT a.MaHH,a.TenHH,a.MaNCC, a.soluong, a.DonGia FROM hanghoa a WHERE a.MaHH=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, search);
		ResultSet rs = pstm.executeQuery();
		List<hanghoa> list =new ArrayList<hanghoa>();
		while (rs.next()) {
			int MaHH=rs.getInt("a.MaHH");
			String TenHH=rs.getString("a.TenHH");
			int MaNCC=rs.getInt("a.MaNCC");
			int soluong=rs.getInt("a.soluong");
			float DonGia=rs.getFloat("a.DonGia");
			hanghoa hanghoa = new hanghoa();
			hanghoa.setMaHH(MaHH);
			hanghoa.setTenHH(TenHH);
			hanghoa.setMaNCC(MaNCC);
			hanghoa.setSoluong(soluong);
			hanghoa.setDonGia(DonGia);
			list.add(hanghoa);
			System.out.print(hanghoa.getTenHH());
		}
		return list;
	}
	
	public static hanghoa findHanghoa(Connection conn, int MaHH) throws SQLException{
		String sql="SELECT a.MaHH,a.TenHH,a.MaNCC, a.soluong, a.DonGia FROM hanghoa a WHERE a.MaHH=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaHH);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String TenHH=rs.getString("a.TenHH");
			int MaNCC=rs.getInt("a.MaNCC");
			int soluong=rs.getInt("a.soluong");
			float DonGia=rs.getFloat("a.DonGia");
			hanghoa hanghoa = new hanghoa(MaHH,TenHH,MaNCC,soluong,DonGia);
			return hanghoa;
		}
		return null;
	}
	
	public static void updateHanghoa(Connection conn, hanghoa hanghoa) throws SQLException{
		String sql="UPDATE hanghoa a SET a.TenHH=?,a.MaNCC=?, a.soluong=?, a.DonGia=? WHERE a.MaHH=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, hanghoa.getTenHH());
		pstm.setInt(2, hanghoa.getMaNCC());
		pstm.setInt(3, hanghoa.getSoluong());
		pstm.setFloat(4, hanghoa.getDonGia());
		pstm.setInt(5, hanghoa.getMaHH());
		pstm.executeUpdate();
	}
	public static void updateSLHanghoa(Connection conn, int MaHH, int soluong) throws SQLException{
		String sql="UPDATE hanghoa a SET  a.soluong=?  WHERE a.MaHH=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, soluong);

		pstm.setInt(2, MaHH);
		pstm.executeUpdate();
	}
	public static void updateDGHanghoa(Connection conn, int MaHH, float dongia) throws SQLException{
		String sql="UPDATE hanghoa a SET  a.DonGia=?  WHERE a.MaHH=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setFloat(1, dongia);

		pstm.setInt(2, MaHH);
		pstm.executeUpdate();
	}
	public static void insertHanghoa(Connection conn, hanghoa hanghoa) throws SQLException{
		String sql="INSERT INTO hanghoa(MaHH,TenHH,MaNCC,soluong,DonGia) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, hanghoa.getMaHH());
		pstm.setString(2, hanghoa.getTenHH());
		pstm.setInt(3, hanghoa.getMaNCC());
		pstm.setInt(4, hanghoa.getSoluong());
		pstm.setFloat(5, hanghoa.getDonGia());
		
		pstm.executeUpdate();
	}
	
	public static void deleteHanghoa(Connection conn, int MaHH) throws SQLException{
		String sql="DELETE FROM hanghoa WHERE MaHH=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, MaHH);
		pstm.executeUpdate();
	}

}
