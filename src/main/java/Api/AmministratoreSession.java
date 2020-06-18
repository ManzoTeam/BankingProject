package Api;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import Actors.Amministratore;

public class AmministratoreSession {
	
	@Path("/loginamministratore")
	public class AmministratoreLogin extends HttpServlet{
		
		
		private static final long serialVersionUID = 1L;

		public AmministratoreLogin() {
			super();
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse res) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Amministratore amm = new Amministratore();
			try {
				amm.login(email,password);
				
				String page = "login.jsp";
				
				if(amm.login(email, password) != null) {
					HttpSession sess = req.getSession();
					sess.setAttribute("amministratore", amm);
					page = "home.jsp";
				}else {
					String mex = "Invalid email/password";
					req.setAttribute("message", mex);
				}
				RequestDispatcher disp = req.getRequestDispatcher(page);
				disp.forward(req, res);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
		
	@Path("/logoutamministratore")
		public class AmministratoreLogout extends HttpServlet{

		private static final long serialVersionUID = 1L;
		
		public AmministratoreLogout() {
			super();
		}
		
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			HttpSession sess = req.getSession(false);
			if(sess != null) {
				sess.removeAttribute("amministratore");
			}
			
			RequestDispatcher disp = req.getRequestDispatcher("login.jsp");
			disp.forward(req, res);
		}
		
		
	}
	
	
}
