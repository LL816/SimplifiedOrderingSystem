package cheryl.ordering.comprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class NewOrder {
	public static int newOrder(String username, String merchandise_name, int num){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		int result = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			System.out.println("fail to locate Driver");
			e.printStackTrace();
		}
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Jiaguwen816");
			
		}catch(SQLException err){
			System.out.println("fail to connect");
			err.printStackTrace();
		}
		
		if(conn!=null){
			try{
				int userid=0;
				int merchid=0;
				String sql_getuserid = "select user_id from ordering.usersinfo where user_name=?";
				pst = conn.prepareStatement(sql_getuserid);
				pst.setString(1, username);
				rst = pst.executeQuery();
				if(rst.next()){
					userid = rst.getInt("user_id");
				}
		
				String sql_getmerchid = "select merchandise_id from ordering.merchandise where merchandise_name=?";
				pst = conn.prepareStatement(sql_getmerchid);
				pst.setString(1, merchandise_name);
				rst = pst.executeQuery();
				if(rst.next()){
					merchid = rst.getInt("merchandise_id");
				}
								
				String sql = "insert into ordering.orders (user_id, merchandise_id, num) values (?, ?, ?)";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, userid);
				pst.setInt(2, merchid);
				pst.setInt(3, num);
				result = pst.executeUpdate();
					
			}catch(SQLException e){
				System.out.println("invalid sql");
				e.printStackTrace();
			}finally{				
				try {
					conn.close();
					pst.close();
					rst.close();
				} catch (SQLException e) {
					System.out.println("fail to close connection");
					e.printStackTrace();
				}
				
			}
		}
		return result;		
	}

}
