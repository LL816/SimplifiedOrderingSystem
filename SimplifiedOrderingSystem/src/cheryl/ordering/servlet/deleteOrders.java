package cheryl.ordering.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import cheryl.ordering.comprise.DeleteOrders;
/**
 * Servlet implementation class delete
 */
@WebServlet("/deleteOrders")
public class deleteOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOrders() {
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
		String order_id = request.getParameter("order_id");
		
		boolean b = isTokenValid(request);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!b){
			request.getSession().setAttribute("message", "invalid repeated delete request");
//			return;
		}
		else{
			request.getSession().removeAttribute("token");
			System.out.println("submit");
			if (DeleteOrders.deleteOrders(order_id)==1){
				request.getSession().setAttribute("message", "an order has been deleted successfully");
			}
		}
		/*
		RequestDispatcher dispatch = request.getRequestDispatcher("/orders.jsp");
		dispatch.forward(request, response);
		*/
		response.sendRedirect("/SimplifiedOrderingSystem/orders.jsp");

	}

	private boolean isTokenValid(HttpServletRequest request) {	
		String tokenClient = request.getParameter("token");
		System.out.println(tokenClient);
		if(tokenClient == null){
			return false;
		}
		String tokenServer = (String) request.getSession().getAttribute("token");
		System.out.println(tokenServer);
		if(tokenServer == null){
			return false;
		}
		if(!tokenClient.equals(tokenServer)){
			return false;
		}
		return true;
	}

}
