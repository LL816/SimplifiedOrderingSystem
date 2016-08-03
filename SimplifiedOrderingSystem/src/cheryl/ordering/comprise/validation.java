package cheryl.ordering.comprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class validation 
{
	public static boolean verify(String name, String passwd){
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		boolean status = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("failed to find MySQL JDBC Driver");
			e.printStackTrace();
			return false;
		}
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "Jiaguwen816");//need to be improved!
		}catch(SQLException err){
			System.out.println("SQL connection failed");
			err.printStackTrace();
			
		}
		if(connection != null){
			try {
				pst = connection.prepareStatement("select * from ordering.usersinfo where user_name=? and passwd=?");
				pst.setString(1, name);
				pst.setString(2,passwd);
				rst = pst.executeQuery();
				status = rst.next();
			} catch (SQLException e) {
				System.out.println("invalid sql");
				e.printStackTrace();
			}finally{
				try {
					connection.close();
					pst.close();
					rst.close();
				} catch (SQLException e) {
					System.out.println("fail to close connection");
					e.printStackTrace();
				}
			}
		}			
		return status;
	}	
}
