package com.simha.signup.DaoImp;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.simha.signup.dto.Customer;
import com.simha.signup.repository.CustomerDAO;

public class CustomerDAOImp implements CustomerDAO {

	@Override
	public Customer Login(String email, String password) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sdm";
			String user="root";
			String pass="root";
			Connection connection=DriverManager.getConnection(url,user,pass);
			String query="select * from customer where email=? and password=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet set = ps.executeQuery();
			Customer c = new Customer();
			while(set.next()) {
				c.setId(set.getInt(1));
				c.setName(set.getString(2));
				c.setEmail(set.getString(3));
				c.setPassword(set.getString(4));
			}
			connection.close();
			return c;
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveCustomer(Customer customer) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sdm";
			String user="root";
			String pass="root";
			String query="Insert into customer values(?,?,?,?)";
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setString(4,customer.getPassword());
			int result = ps.executeUpdate();
			con.close();
			return result+" row/s of Data Saved";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "No Row of Data Saved";
	}

	@Override
	public String updateCustomer(Customer customer) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sdm";
			String user="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,user,pass);
			String query="update customer set name=?,email=?,password=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(5, customer.getId());
			ps.setString(1,customer.getName());
			ps.setString(2,customer.getEmail());
			ps.setString(3,customer.getPassword());
			int res = ps.executeUpdate();
			con.close();
			return res+"rows are updated";
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return "customer data Not saved";
	}

	@Override
	public Customer getCustomerById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sdm";
			String user="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,user,pass);
			String query="SELECT * FROM customer WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			Customer c=new Customer();
			while(set.next()) {
				c.setId(set.getInt(1));
				c.setName(set.getString(2));
				c.setEmail(set.getString(3));
				c.setPassword(set.getString(4));
			}
			con.close();
			return c;
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sdm";
			String user="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,user,pass);
			String query="SELECT * FROM customer";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			List<Customer>  list=null;
			if(set.isBeforeFirst()) {
				list=new ArrayList<>();
			}
			while(set.next()) {
				Customer c=new Customer();
				c.setId(set.getInt(1));
				c.setName(set.getString(2));
				c.setEmail(set.getString(3));
				c.setPassword(set.getString(4));
				list.add(c);
			}
			con.close();
			return list;
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteCustomerById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sdm";
			String user="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,user,pass);
			String query="DELETE FROM customer WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int r = ps.executeUpdate();
			
			con.close();
			return r+" row of Data Deleted";
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return "Not Daleted";
	}

}
