package exercise_injury.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity1.domain.Entity1;

//import java.util.ArrayList;
//import java.util.List;

import exercise_injury.domain.Exercise_injury;

/**
 * DDL functions performed in database
 */
public class Exercise_injuryDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "aging_population_fitness"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "1234"; //TODO change password

	public Exercise_injury findByInjuryID(String injury_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Exercise_injury exercise_injury = new Exercise_injury();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
		    String sql = "select * from exercise_injury where injury_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,injury_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String injuryID = resultSet.getString("injury_id");
		    	System.out.println(injury_id);		//testing line
		    	System.out.println(injuryID);		//testing line
		    	if(injuryID.equals(injury_id)){
		    		System.out.println("theyre equal");
		    		exercise_injury.setInjuryID(resultSet.getString("injury_id"));
		    		exercise_injury.setExerciseID(resultSet.getString("exercise_id"));
		    		exercise_injury.setExerciseInjuryName(resultSet.getString("exercise_injury_name"));
		    		exercise_injury.setExerciseInjuryDescription(resultSet.getString("exercise_injury_description"));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return exercise_injury;
	}	
	
	/**
	 * insert Exercise
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Exercise_injury form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "insert into exercise_injury (exercise_id, exercise_injury_name, exercise_injury_description) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getExerciseID());
		    preparestatement.setString(2,form.getExerciseInjuryName());
		    preparestatement.setString(3,form.getExerciseInjuryDescription());
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
	public void update(Exercise_injury form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "UPDATE exercise_injury SET exercise_id = ?, exercise_injury_name = ?, exercise_injury_description = ? where injury_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getExerciseID());
		    preparestatement.setString(2,form.getExerciseInjuryName());
			preparestatement.setString(3,form.getExerciseInjuryDescription());
		    preparestatement.setString(4,form.getInjuryID());
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
			
			String sql = "delete from exercise_injury where injury_id = ?";
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
