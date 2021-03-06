package user.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	/**
	 * Register a user
	 */
	public void regist(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		User user = userDao.findByUsername(form.getUsername());
		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		userDao.add(form);
	}
	
	
	/**
	 * Login function
	 */
	public void login(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new UserException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new UserException(" The password is not right");
		
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findall();
		
	}
	
	public List<Object> findDifficultyGreaterThanFive() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findDifficultyGreaterThanFive();
		
	}
	
	public List<Object> findSeverityGreaterThanThree() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findSeverityGreaterThanThree();
		
	}
	
	public List<Object> findSeverityGreaterThanFive() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findSeverityGreaterThanFive();
		
	}
	
	public List<Object> findProfileNamesInjuryAge() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findProfileNamesInjuryAge();
		
	}
	
	public List<Object> findBenefitsExerciseChest() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findBenefitsExerciseChest();
		
	}
	
	public List<Object> findUsersMoreThanTwoInjuries() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findUsersMoreThanTwoInjuries();
		
	}
	
	public List<Object> findUsersAndInjuries() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findUsersAndInjuries();
		
	}
	
	public List<Object> findExercisesAndBenefits() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findExercisesAndBenefits();
		
	}
	
}
