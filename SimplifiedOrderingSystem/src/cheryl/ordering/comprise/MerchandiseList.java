package cheryl.ordering.comprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import cheryl.ordering.comprise.MyPair;

public class MerchandiseList {
	public static MyPair listMerchandise(){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		ArrayList merchandise_name = new ArrayList();
		ArrayList price = new ArrayList();
		
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
				String sql = "select merchandise_name, price from ordering.merchandise";
				pst = conn.prepareStatement(sql);
				rst = pst.executeQuery();
				while(rst.next()){
					merchandise_name.add(rst.getString("merchandise_name"));
					price.add(rst.getString("price"));
				}
				
			}catch(SQLException e){
				System.out.println("sql statement error");
				e.printStackTrace();		
			}finally{
				try {
					conn.close();
					rst.close();
					pst.close();
				} catch (SQLException e) {
					System.out.println("fail to close connection");
					e.printStackTrace();
				}
			}
		}
		if(merchandise_name.size() != price.size()){
			System.out.println("Wrong sql result");
			return null;
		}
		MyPair result = new MyPair(merchandise_name,price);
		return result;
	}

}
