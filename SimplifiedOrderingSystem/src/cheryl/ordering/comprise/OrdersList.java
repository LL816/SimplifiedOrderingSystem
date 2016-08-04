package cheryl.ordering.comprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cheryl.ordering.comprise.MyPair;
import java.util.ArrayList;

public class OrdersList {
	
	public static MyPair listOrders(String username){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		ArrayList merchandise_name = new ArrayList();
		ArrayList total_price = new ArrayList();
		ArrayList order_id = new ArrayList();
		int element_number = 3;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("cannot locate jdbc driver");
			e.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Jiaguwen816");
		}catch(SQLException err){
			System.out.println("fail to connect server");
			err.printStackTrace();
		}
		if(conn!=null){
			try{
				String sql = "select usersinfo.user_name, merchandise.merchandise_name, round(merchandise.price * orders.num,2) as total_price, orders.order_id from ordering.orders inner join ordering.usersinfo inner join ordering.merchandise on orders.user_id = usersinfo.user_id and orders.merchandise_id = merchandise.merchandise_id where user_name=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, username);
				rst = pst.executeQuery();
				while(rst.next()){
					merchandise_name.add(rst.getString("merchandise_name"));
					total_price.add(rst.getString("total_price"));
					order_id.add(rst.getString("order_id"));
				}
				
			}catch(SQLException e){
				System.out.println("invalid sql");
				e.printStackTrace();
			}
		}
		if(merchandise_name.size()!=total_price.size()){
			System.out.println("wrong search result");
			return null;
		}
		
		MyPair result = new MyPair(element_number);
		result.setElement(0, merchandise_name);
		result.setElement(1, total_price);
		result.setElement(2, order_id);
		return result;
	}

}
