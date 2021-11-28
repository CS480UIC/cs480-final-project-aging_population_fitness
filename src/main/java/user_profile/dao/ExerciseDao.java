package exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity1.domain.Entity1;

//import java.util.ArrayList;
//import java.util.List;

import exercise.domain.Exercise;

/**
 * DDL functions performed in database
 */
public class ExerciseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "aging_population_fitness"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "1234"; //TODO change password

	public Exercise findByExerciseID(String exercise_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Exercise exercise = new Exercise();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
		    String sql = "select * from exercise where exercise_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,exercise_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String exerciseID = resultSet.getString("exercise_id");
		    	System.out.println(exercise_id);		//testing line
		    	System.out.println(exerciseID);		//testing line
		    	if(exerciseID.equals(exercise_id)){
		    		System.out.println("theyre equal");
		    		exercise.setExerciseID(resultSet.getString("exercise_id"));
		    		exercise.setExerciseName(resultSet.getString("exercise_name"));
		    		exercise.setExerciseDescription(resultSet.getString("exercise_description"));
		    		exercise.setExerciseDifficulty(resultSet.getString("exercise_difficulty"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return exercise;
	}	
	
	/**
	 * insert Exercise
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Exercise form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "insert into exercise (exercise_name, exercise_description, exercise_difficulty) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getExerciseName());
		    preparestatement.setString(2,form.getExerciseDescription());
		    preparestatement.setString(3,form.getExerciseDifficulty());
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
	public void update(Exercise form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "UPDATE exercise SET exercise_name = ?, exercise_description = ?, exercise_difficulty = ? where exercise_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getExerciseName());
			preparestatement.setString(2,form.getExerciseDescription());
		    preparestatement.setString(3,form.getExerciseDifficulty());
		    preparestatement.setString(4,form.getExerciseID());
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
	public void delete(String exercise_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "delete from exercise where exercise_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, exercise_id);
		    System.out.print( "id to delete: ");
		    System.out.println( exercise_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
