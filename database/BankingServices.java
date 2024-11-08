package database;
import java.sql.*;
public class BankingServices {
	private Connection connection;
	boolean adminLoggedIn=false;
	
	public BankingServices() {
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_db","root","Ramya@25");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean adminLogin(String username,String password) {
		String query="select * from Admin where username=? and password=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("Admin logged in successfully!");
				adminLoggedIn=true;
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Invalid admin credentials");
		return false;
	}
}
