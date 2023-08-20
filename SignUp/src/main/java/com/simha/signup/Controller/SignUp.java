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

@WebServlet("/signup")
public class SignUp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		 
		CustomerDAOImp dao = new CustomerDAOImp();
		Customer a = new Customer();
		a.setId(id);
		a.setName(name);
		a.setEmail(email);
		a.setPassword(pass);
		
		PrintWriter w = resp.getWriter();
		w.write("<style>"
				+ "body{background-image:url(\"https://i0.wp.com/stanzaliving.wpcomstaging.com/wp-content/uploads/2022/04/5ba1a-top-companies-in-india.jpg?fit=1000%2C665&ssl=1\");"
				+ "backdrop-filter:blur(8px);}h2{color:orange;}h1{margin-bottom:200px;color:red;}a{margin:250px}"
				+ "</style>");
		w.write("<body style=\"background-color:orange\">");
		w.write("<h1 align=\"center\">"+"Sucessfully Your Data is Saved"+"</h1>");
		w.write("<h1>"+"<button><a href=signin.html>Signin Here</a></button><button><a href=Home.html>Home</a>"+"</h1></body>");
		w.write(dao.saveCustomer(a));
	}
}
