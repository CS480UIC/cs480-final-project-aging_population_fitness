package benefit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//import java.util.ArrayList;
//import java.util.List;

import benefit.domain.Benefit;

/**
 * DDL functions performed in database
 */
public class BenefitDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "aging_population_fitness"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "1234"; //TODO change password

	public Benefit findByBenefitID(String benefit_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Benefit benefit = new Benefit();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
		    String sql = "select * from benefit where benefit_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,benefit_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String benefitID = resultSet.getString("benefit_id");
		    	System.out.println(benefit_id);		//testing line
		    	System.out.println(benefitID);		//testing line
		    	if(benefitID.equals(benefit_id)){
		    		System.out.println("theyre equal");
		    		benefit.setBenefitID(resultSet.getString("benefit_id"));
		    		benefit.setExerciseID(resultSet.getString("exercise_id"));
		    		benefit.setBenefitName(resultSet.getString("benefit_name"));
		    		benefit.setBenefitDescription(resultSet.getString("benefit_description"));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return benefit;
	}	
	
	/**
	 * insert Exercise
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Benefit form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "insert into benefit (exercise_id, benefit_name, benefit_description) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getExerciseID());
		    preparestatement.setString(2,form.getBenefitName());
		    preparestatement.setString(3,form.getBenefitDescription());
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
	public void update(Benefit form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "UPDATE benefit SET exercise_id = ?, benefit_name = ?, benefit_description = ? where benefit_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getExerciseID());
			preparestatement.setString(2,form.getBenefitName());
		    preparestatement.setString(3,form.getBenefitDescription());
		    preparestatement.setString(4,form.getBenefitID());
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
	public void delete(String benefit_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aging_population_fitness", MySQL_user, MySQL_password);
			
			String sql = "delete from benefit where benefit_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, benefit_id);
		    System.out.print( "id to delete: ");
		    System.out.println( benefit_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
