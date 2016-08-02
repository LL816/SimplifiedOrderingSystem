package cheryl.ordering.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import cheryl.ordering.comprise.*;;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_name = request.getParameter("username");
		String passwd = request.getParameter("password");
		validation valid = new validation();
		boolean result = valid.verify(user_name, passwd);
		
		if (result){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/succeed.jsp");
			dispatcher.forward(request, response);
		}
		else{
			request.setAttribute("errorMessage", "invalid username or password! Please try again!");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
			dispatcher.forward(request, response);
		}
		

	}

}
