package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import user.domain.Table;



/**
 * DDL functions performed in database
 */
public class UserDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "aging_population_fitness";  //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "1234";  //TODO change password
	
	/**
	 * get the Search result with Username 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
		    String sql = "select * from user where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	

	
	
	/**
	 * insert User
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "insert into user values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "select * from user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findSeverityGreaterThanThree() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM average_user_injury_severity_greater_than_three";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("user_id"));
				table.setCol2(resultSet.getString("ROUND( AVG( user_injury_severity) )"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findDifficultyGreaterThanFive() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM difficulty_greater_than_five";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("exercise_id"));
				table.setCol2(resultSet.getString("exercise_name"));
				table.setCol3(resultSet.getString("exercise_description"));
				table.setCol4(resultSet.getString("exercise_difficulty"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findSeverityGreaterThanFive() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM injury_greater_than_five";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("injury_id"));
				table.setCol2(resultSet.getString("user_id"));
				table.setCol3(resultSet.getString("user_injury_name"));
				table.setCol4(resultSet.getString("user_injury_description"));
				table.setCol5(resultSet.getString("user_injury_severity"));
				table.setCol6(resultSet.getString("user_injury_date"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findProfileNamesInjuryAge() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM profile_names_with_injury_age";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("profile_name"));
				table.setCol2(resultSet.getString("user_injury_name"));
				table.setCol3(resultSet.getString("DATEDIFF(DATE(NOW()), user_injury_date)"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findBenefitsExerciseChest() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM benefits_of_exercise_with_chest_in_description";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("benefit_id"));
				table.setCol2(resultSet.getString("exercise_id"));
				table.setCol3(resultSet.getString("benefit_name"));
				table.setCol4(resultSet.getString("benefit_description"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findUsersMoreThanTwoInjuries() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT * FROM users_more_than_two_injuries";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("user_id"));
				table.setCol2(resultSet.getString("profile_name"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findUsersAndInjuries() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT username, profile_name, user_injury_name, user_injury_description, user_injury_severity\r\n"
					+ "FROM user_profile\r\n"
					+ "JOIN user_injury\r\n"
					+ "ON user_profile.user_id = user_injury.user_id;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("username"));
				table.setCol2(resultSet.getString("profile_name"));
				table.setCol3(resultSet.getString("user_injury_name"));
				table.setCol4(resultSet.getString("user_injury_description"));
				table.setCol5(resultSet.getString("user_injury_severity"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findExercisesAndBenefits() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			String sql = "SELECT exercise_name, exercise_description, benefit_name, benefit_description\r\n"
					+ "FROM exercise\r\n"
					+ "JOIN benefit\r\n"
					+ "ON exercise.exercise_id = benefit.exercise_id;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Table table = new Table();
				table.setCol1(resultSet.getString("exercise_name"));
				table.setCol2(resultSet.getString("exercise_description"));
				table.setCol3(resultSet.getString("benefit_name"));
				table.setCol4(resultSet.getString("benefit_description"));
	    		list.add(table);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
