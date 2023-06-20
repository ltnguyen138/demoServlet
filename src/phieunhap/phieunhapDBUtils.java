package phieunhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class phieunhapDBUtils {

	public static List<phieunhap> queryPhieunhap (Connection conn)throws SQLException{
		String sql="SELECT a.maphieunhap,a.mancc,a.manv,a.ngaylapphieu,a.thanhtien FROM phieunhap a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<phieunhap> list =new ArrayList<phieunhap>();
		while (rs.next()) {
			long maphieunhap=rs.getLong("a.maphieunhap");
			int mancc=rs.getInt("a.mancc");
			int mannv=rs.getInt("a.manv");
			float thanhtien=rs.getFloat("a.thanhtien");
			String ngaylapphieu=rs.getString("a.ngaylapphieu");
			phieunhap phieunhap = new phieunhap();
			phieunhap.setMaphieunhap(maphieunhap);
			phieunhap.setMancc(mancc);
			phieunhap.setMannv(mannv);
			phieunhap.setThanhtien(thanhtien);	
			phieunhap.setNgaylapphieu(ngaylapphieu);
			list.add(phieunhap);
		}
		return list;
	}
	
	public static List<phieunhap> searchPhieunhap(Connection conn, long search) throws SQLException{
		String sql="SELECT a.maphieunhap,a.mancc,a.manv,a.ngaylapphieu,a.thanhtien FROM phieunhap a WHERE a.maphieunhap=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, search);
		ResultSet rs = pstm.executeQuery();
		List<phieunhap> list =new ArrayList<phieunhap>();
		while (rs.next()) {
			long maphieunhap=rs.getLong("a.maphieunhap");
			int mancc=rs.getInt("a.mancc");
			int mannv=rs.getInt("a.manv");
			float thanhtien=rs.getFloat("a.thanhtien");
			String ngaylapphieu=rs.getString("a.ngaylapphieu");
			phieunhap phieunhap = new phieunhap();
			phieunhap.setMaphieunhap(maphieunhap);
			phieunhap.setMancc(mancc);
			phieunhap.setMannv(mannv);
			phieunhap.setThanhtien(thanhtien);	
			phieunhap.setNgaylapphieu(ngaylapphieu);
			list.add(phieunhap);
		}
		return list;
	}
	
	public static phieunhap findPhieunhap(Connection conn, long maphieunhap) throws SQLException{
		String sql="SELECT a.maphieunhap,a.mancc,a.manv,a.ngaylapphieu,a.thanhtien FROM phieunhap a WHERE a.maphieunhap=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieunhap);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int mancc=rs.getInt("a.mancc");
			int manv=rs.getInt("a.manv");
			float thanhtien=rs.getFloat("a.thanhtien");
			String ngaylapphieu=rs.getString("a.ngaylapphieu");
			phieunhap phieunhap = new phieunhap(maphieunhap,mancc,manv,ngaylapphieu,thanhtien);
			return phieunhap;
		}
		return null;
	}
	
	public static void updatePhieunhap(Connection conn, phieunhap phieunhap) throws SQLException{
		String sql="UPDATE phieunhap a SET a.mancc=?,a.manv=?,a.thanhtien=?,a.ngaylapphieu=? WHERE a.maphieunhap=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, phieunhap.getMancc());
		pstm.setInt(2, phieunhap.getMannv());
		pstm.setFloat(3, phieunhap.getThanhtien());
		pstm.setString(4, phieunhap.getNgaylapphieu());
		pstm.setLong(5, phieunhap.getMaphieunhap());
		pstm.executeUpdate();
	}
	
	public static void insertPhieunhap(Connection conn, phieunhap phieunhap) throws SQLException{
		String sql="INSERT INTO phieunhap(maphieunhap,mancc,manv,ngaylapphieu,thanhtien) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, phieunhap.getMaphieunhap());
		pstm.setInt(2, phieunhap.getMancc());
		pstm.setInt(3, phieunhap.getMannv());
		pstm.setString(4, phieunhap.getNgaylapphieu());
		pstm.setFloat(5, phieunhap.getThanhtien());
		
		
		pstm.executeUpdate();
	}
	
	public static void deletePhieunhap(Connection conn, long maphieunhap) throws SQLException{
		String sql="DELETE FROM phieunhap WHERE  maphieunhap=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, maphieunhap);
		pstm.executeUpdate();
	}

}
