package cheryl.ordering.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import cheryl.ordering.comprise.NewOrder;
import java.lang.Integer;
/**
 * Servlet implementation class newOrder
 */
@WebServlet("/newOrder")
public class newOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newOrder() {
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
		String merchandise_name = request.getParameter("merchandise_name");
		int num = Integer.valueOf(request.getParameter("number"));
		
		request.setAttribute("message", "A new order has been submitted successfully!");
		if(NewOrder.newOrder(user_name, merchandise_name, num)==1){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/orders.jsp");
			dispatcher.forward(request, response);
		}
	}

}
