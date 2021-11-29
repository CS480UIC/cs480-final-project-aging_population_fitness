package user_injury.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import user_injury.domain.User_injury;

/**
 * DDL functions performed in database
 */
public class User_injuryDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "aging_population_fitness"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "1234"; //TODO change password

	public User_injury /*here*/ findByInjuryID(String injury_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User_injury user_injury = new User_injury();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
		    String sql = "select * from user_injury where user_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,injury_id); /* here */
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String injuryID = resultSet.getString("injury_id");
		    	System.out.println(injury_id);		//testing line
		    	System.out.println(injuryID);		//testing line
		    	if(injuryID.equals(injury_id)){
		    		System.out.println("theyre equal");
		    		user_injury.setInjuryID(resultSet.getString("injury_id"));
		    		user_injury.setUserID(resultSet.getString("user_id"));
		    		user_injury.setUserInjuryName(resultSet.getString("user_injury_name"));
		    		user_injury.setUserInjuryDescription(resultSet.getString("user_injury_description"));
		    		user_injury.setUserInjurySeverity(resultSet.getString("user_injury_severity"));
		    		user_injury.setUserInjuryDate(resultSet.getString("user_injury_date"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user_injury;
	}	
	
	/**
	 * insert User_injury
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(User_injury form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			/* here */
			String sql = "insert into user_injury (user_id, user_injury_name, user_injury_description, user_injury_severity, user_injury_date) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUserID());
		    preparestatement.setString(2,form.getUserInjuryName());
		    preparestatement.setString(3,form.getUserInjuryDescription());
		    preparestatement.setString(4,form.getUserInjurySeverity());
		    preparestatement.setString(5,form.getUserInjuryDate());
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
	public void update(User_injury form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			/* here */
			String sql = "UPDATE user_injury SET user_id = ?, user_injury_name = ?, user_injury_description = ?, user_injury_severity = ?, user_injury_date = ? where injury_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUserID());
		    preparestatement.setString(2,form.getUserInjuryName());
		    preparestatement.setString(3,form.getUserInjuryDescription());
		    preparestatement.setString(4,form.getUserInjurySeverity());
		    preparestatement.setString(5,form.getUserInjuryDate());
		    preparestatement.setString(6,form.getInjuryID());
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
	public void delete(String injury_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			/* here */
			String sql = "delete from user_injury where injury_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, injury_id);
		    System.out.print( "id to delete: ");
		    System.out.println( injury_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
