package cheryl.ordering.comprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeleteOrders {
	public static int deleteOrders(String order_id){
		Connection conn = null;
		PreparedStatement pst = null;
		int result=0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("jdbc drive not found");
			e.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "Jiaguwen816");
		}catch(SQLException err){
			System.out.println("cannot connect sql");
			err.printStackTrace();			
		}
		if(conn!=null){
			try{
				String sql="delete from ordering.orders where order_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, order_id);
				result = pst.executeUpdate();
			}catch(SQLException e){
				System.out.println("sql statement error");
				e.printStackTrace();		
			}finally{
				try {
					conn.close();
					pst.close();
				} catch (SQLException e) {
					System.out.println("fail to close connection");
					e.printStackTrace();
				}
			}
		}	
		return result;

	}

}
