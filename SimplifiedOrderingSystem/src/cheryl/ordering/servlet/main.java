package cheryl.ordering.servlet;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		boolean result = validation.verify(user_name, passwd);
		
		request.getSession().setAttribute("user_name", user_name);
		
		if (result){
//			request.getSession().setAttribute("LAT", "lll");
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher("/succeed.jsp");
			dispatcher.forward(request, response);
			*/
			
			Cookie cookies[] = request.getCookies();
			for(int i=0; cookies!=null && i<cookies.length;i++){
				if(cookies[i].getName().equals("lastAccessTime")){
					long value = Long.parseLong(cookies[i].getValue());
					Date lastAccessTime = new Date(value);
					request.getSession().setAttribute("LAT", lastAccessTime.toLocaleString());
				}
				else{
					request.getSession().setAttribute("LAT", "null");
				}
			}		
					
			Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
			cookie.setMaxAge(30*24*3600);
			cookie.setPath("/SimplifiedOrderingSystem");
			response.addCookie(cookie);
//			System.out.print(request.getServletContext().getRealPath(cookie.getPath()));
			response.sendRedirect("/SimplifiedOrderingSystem/succeed.jsp");
		}
		else{
			request.getSession().setAttribute("errorMessage", "invalid username or password! Please try again!");
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
			dispatcher.forward(request, response);
			*/
			response.sendRedirect("/SimplifiedOrderingSystem/entry.jsp");
		}
		

	}

}
