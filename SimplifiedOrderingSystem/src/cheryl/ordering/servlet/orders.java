package cheryl.ordering.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cheryl.ordering.comprise.OrdersList;
import cheryl.ordering.comprise.MyPair;
import java.util.ArrayList;

/**
 * Servlet implementation class orders
 */
@WebServlet("/orders")
public class orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_name = request.getSession().getAttribute("user_name").toString();
//		response.getWriter().println(user_name.toString());
		/**/
		MyPair result = OrdersList.listOrders(user_name);
		ArrayList merchandise_name = result.getElement1();
		ArrayList total_price = result.getElement2();
		response.getWriter().println("current user's orders are listed as below");
		response.getWriter().println("merchandise name		total price");
		int size = merchandise_name.size();
		for (int i=0; i<size;i++){
			response.getWriter().println(merchandise_name.get(i) + "	" + total_price.get(i));
		}
		
	}

}
