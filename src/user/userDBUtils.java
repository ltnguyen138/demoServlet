package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDBUtils {
	public static List<user> queryUser (Connection conn)throws SQLException{
		String sql="SELECT a.id,a.tennv,a.sdtnv,a.username,a.password,a.role FROM user a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<user> list =new ArrayList<user>();
		while (rs.next()) {
			int id=rs.getInt("a.id");
			String tennv=rs.getString("a.tennv");
			String sdtnv=rs.getString("a.sdtnv");
			String username=rs.getString("a.username");
			String password=rs.getString("a.password");
			String role=rs.getString("a.role");
			user user = new user();
			user.setId(id);
			user.setTennv(tennv);
			user.setSdtnv(sdtnv);
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			list.add(user);
		}
		list.remove(0);
		return list;
	}

	public static List<user> searchUser(Connection conn, int search) throws SQLException{
		String sql="SELECT a.id,a.tennv,a.sdtnv,a.username,a.password,a.role FROM user a WHERE a.id=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, search);

			
		ResultSet rs = pstm.executeQuery();
		List<user> list =new ArrayList<user>();
		while (rs.next()) {
			int id=rs.getInt("a.id");
			String tennv=rs.getString("a.tennv");
			String sdtnv=rs.getString("a.sdtnv");
			String username=rs.getString("a.username");
			String password=rs.getString("a.password");
			String role=rs.getString("a.role");
			user user = new user();
			user.setId(id);
			user.setTennv(tennv);
			user.setSdtnv(sdtnv);
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			list.add(user);
		}
		
		return list;
	}
	
	public static user findUser(Connection conn, String username, String password) throws SQLException{
		String sql="SELECT a.id,a.tennv,a.sdtnv,a.username,a.password,a.role FROM user a WHERE a.username=? and password=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
			
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int id=rs.getInt("a.id");
			String tennv=rs.getString("a.tennv");
			String sdtnv=rs.getString("a.sdtnv");
			String role=rs.getString("a.role");
			user user = new user(id,tennv,sdtnv,username,password,role);
			return user;
		}
		return null;
	}
	public static user findUser(Connection conn, int id) throws SQLException{
		String sql="SELECT a.id,a.tennv,a.sdtnv,a.username,a.password,a.role FROM user a WHERE a.id=?"; 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
	
			String tennv=rs.getString("a.tennv");
			String sdtnv=rs.getString("a.sdtnv");
			String username=rs.getString("a.username");
			String password=rs.getString("a.password");
			String role=rs.getString("a.role");
			user user = new user(id,tennv,sdtnv,username,password,role);
			return user;
		}
		return null;
	}
	public static void updateUser(Connection conn, user user) throws SQLException{
		String sql="UPDATE user a SET a.tennv=?,a.sdtnv=?, a.username=?,a.password=? WHERE a.id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getTennv());
		pstm.setString(2, user.getSdtnv());
		pstm.setString(3, user.getUsername());
		pstm.setString(4, user.getPassword());
		pstm.setInt(5, user.getId());
		pstm.executeUpdate();
	}
	public static void insertUser(Connection conn, user user) throws SQLException{
		String sql="INSERT INTO user (id,tennv,sdtnv,username,password,role) VALUES (?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, user.getId());
		pstm.setString(2, user.getTennv());
		pstm.setString(3, user.getSdtnv());
		pstm.setString(4, user.getUsername());
		pstm.setString(5, user.getPassword());
		pstm.setString(6, user.getRole());
		pstm.executeUpdate();
	}
	
	public static void deleteUser(Connection conn, int id) throws SQLException{
		String sql="DELETE FROM user WHERE id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	
}
