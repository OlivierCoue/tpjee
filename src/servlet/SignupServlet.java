package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUser;
import model.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		if(username!=null && email!=null && password!=null 
			&& !username.trim().isEmpty() && !email.trim().isEmpty() && !password.trim().isEmpty() && !repeatPassword.trim().isEmpty()
			&& repeatPassword!=null && password.equals(repeatPassword)) {
			
			password = User.hashPassword(password);
			boolean isAdmin = email.equals("admin@admin.com") ? true : false;
			User user = new User(username, email, password, isAdmin);
			DaoUser.save(user);
			HttpSession sess = request.getSession();
			sess.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("signupFailed", true);
			getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request,response);
		}
	}

}
