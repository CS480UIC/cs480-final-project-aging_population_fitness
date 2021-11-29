package user_exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import user_exercise.domain.User_exercise;

/**
 * DDL functions performed in database
 */
public class User_exerciseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "aging_population_fitness"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "1234"; //TODO change password

	public User_exercise findByUserID(String user_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User_exercise user_exercise = new User_exercise();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
		    String sql = "select * from user_exercise where user_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String userID = resultSet.getString("user_id");
		    	System.out.println(user_id);		//testing line
		    	System.out.println(userID);		//testing line
		    	if(userID.equals(user_id)){
		    		System.out.println("theyre equal");
		    		user_exercise.setUserID(resultSet.getString("user_id"));
		    		user_exercise.setUserName(resultSet.getString("username"));
		    		user_exercise.setexerciseName(resultSet.getString("exercise_name"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user_exercise;
	}	
	
	/**
	 * insert User_exercise
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(User_exercise form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "insert into user_exercise (username, user_exercise) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUserName());
		    preparestatement.setString(2,form.getUserexercise());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(User_exercise form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "UPDATE user_exercise SET username = ?, user_exercise = ? where user_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUserName());
			preparestatement.setString(2,form.getUserexercise());
		    preparestatement.setString(3,form.getUserID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String user_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "delete from user_exercise where user_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, user_id);
		    System.out.print( "id to delete: ");
		    System.out.println( user_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
