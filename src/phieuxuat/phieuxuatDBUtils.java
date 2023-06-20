package phieuxuat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class phieuxuatDBUtils {

	public static List<phieuxuat> queryPhieuxuat (Connection conn)throws SQLException{
		String sql="SELECT a.maphieuxuat,a.makh,a.manv,a.ngaylapphieu,a.thanhtien FROM phieuxuat a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<phieuxuat> list =new ArrayList<phieuxuat>();
		while (rs.next()) {
			long maphieuxuat=rs.getLong("a.maphieuxuat");
			int makh=rs.getInt("a.makh");
			int manv=rs.getInt("a.manv");
			float thanhtien=rs.getFloat("a.thanhtien");
			String ngaylapphieu=rs.getString("a.ngaylapphieu");
			phieuxuat phieuxuat = new phieuxuat();
			phieuxuat.setMaphieuxuat(maphieuxuat);
			phieuxuat.setMakh(makh);
			phieuxuat.setManv(manv);
			phieuxuat.setThanhtien(thanhtien);	
			phieuxuat.setNgaylapphieu(ngaylapphieu);
			list.add(phieuxuat);
		}
		return list;
	}
	
	public static List<phieuxuat> searchPhieuxuat(Connection conn, long search) throws SQLException{
		String sql="SELECT a.maphieuxuat,a.makh,a.manv,a.ngaylapphieu,a.thanhtien FROM phieuxuat a WHERE a.maphieuxuat=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, search);
		ResultSet rs = pstm.executeQuery();
		List<phieuxuat> list =new ArrayList<phieuxuat>();
		while (rs.next()) {
			long maphieuxuat=rs.getLong("a.maphieuxuat");
			int makh=rs.getInt("a.makh");
			int manv=rs.getInt("a.manv");
			float thanhtien=rs.getFloat("a.thanhtien");
			String ngaylapphieu=rs.getString("a.ngaylapphieu");
			phieuxuat phieuxuat = new phieuxuat();
			phieuxuat.setMaphieuxuat(maphieuxuat);
			phieuxuat.setMakh(makh);
			phieuxuat.setManv(manv);
			phieuxuat.setThanhtien(thanhtien);	
			phieuxuat.setNgaylapphieu(ngaylapphieu);
			list.add(phieuxuat);
		}
		return list;
	}
	
	public static phieuxuat findPhieuxuat(Connection conn, long maphieuxuat) throws SQLException{
		String sql="SELECT a.maphieuxuat,a.makh,a.manv,a.ngaylapphieu,a.thanhtien FROM phieuxuat a WHERE a.maphieuxuat=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieuxuat);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int mancc=rs.getInt("a.makh");
			int manv=rs.getInt("a.manv");
			float thanhtien=rs.getFloat("a.thanhtien");
			String ngaylapphieu=rs.getString("a.ngaylapphieu");
			phieuxuat phieuxuat = new phieuxuat(maphieuxuat,mancc,manv,ngaylapphieu,thanhtien);
			return phieuxuat;
		}
		return null;
	}
	
	public static void updatePhieuxuat(Connection conn, phieuxuat phieuxuat) throws SQLException{
		String sql="UPDATE phieuxuat a SET a.makh=?,a.manv=?,a.thanhtien=?,a.ngaylapphieu=? WHERE a.maphieuxuat=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, phieuxuat.getMakh());
		pstm.setInt(2, phieuxuat.getManv());
		pstm.setFloat(3, phieuxuat.getThanhtien());
		pstm.setString(4, phieuxuat.getNgaylapphieu());
		pstm.setLong(5, phieuxuat.getMaphieuxuat());
		pstm.executeUpdate();
	}
	
	public static void insertPhieuxuat(Connection conn, phieuxuat phieuxuat) throws SQLException{
		String sql="INSERT INTO phieuxuat(maphieuxuat,makh,manv,ngaylapphieu,thanhtien) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, phieuxuat.getMaphieuxuat());
		pstm.setInt(2, phieuxuat.getMakh());
		pstm.setInt(3, phieuxuat.getManv());
		pstm.setString(4, phieuxuat.getNgaylapphieu());
		pstm.setFloat(5, phieuxuat.getThanhtien());
		
		
		pstm.executeUpdate();
	}
	
	public static void deletePhieuxuat(Connection conn, long maphieuxuat) throws SQLException{
		String sql="DELETE FROM phieunhap WHERE  maphieunhap=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieuxuat);
		pstm.executeUpdate();
	}
}
