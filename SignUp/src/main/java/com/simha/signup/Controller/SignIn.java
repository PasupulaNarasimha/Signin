package com.simha.signup.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simha.signup.DaoImp.CustomerDAOImp;
import com.simha.signup.dto.Customer;
@WebServlet("/signin")
public class SignIn extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		PrintWriter w = resp.getWriter();
		CustomerDAOImp dao = new CustomerDAOImp();
		Customer customer = dao.Login(email, pass);
		if(customer.getName()!=null) {
			w.write("<style>"
					+ "body{background-image:url(\"https://i0.wp.com/stanzaliving.wpcomstaging.com/wp-content/uploads/2022/04/5ba1a-top-companies-in-india.jpg?fit=1000%2C665&ssl=1\");"
					+ "backdrop-filter:blur(8px);}h2{color:orange;}h1{margin-bottom:200px;color:red;}"
					+ "</style>");
			
			w.write("<body style=\"background-color:orange\">");
			w.write("<h1 align=\"center\">"+"Welcome "+customer.getName()+"</h1>");
			w.write("<h2 align=\"center\">"+customer.toString()+"</h2><a href=Home.html>Home</a></body>");
		}
		else {
			w.write("<style>"
					+ "body{background-image:url(\"https://i0.wp.com/stanzaliving.wpcomstaging.com/wp-content/uploads/2022/04/5ba1a-top-companies-in-india.jpg?fit=1000%2C665&ssl=1\");"
					+ "backdrop-filter:blur(8px);}h1{color:red;margin-bottom:200px;}h3{color:orange;}a{color:red;}"
					+ "</style>");
			w.write("<h1 align=\"center\">"+"Invalid UserName or Password"+"</h1>");
	 		w.write("<h3 align=\"center\">>"+"To Go to Customer Login(<a href=signin.html>Click Here</a><button><a href=Home.html>Home</a>)"+"</h3>");

		}
	}
}
