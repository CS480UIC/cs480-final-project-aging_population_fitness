package user_exercise.service;


import user_exercise.dao.User_exerciseDao;
import user_exercise.domain.User_exercise;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class User_exerciseService {
	private User_exerciseDao user_exerciseDao = new User_exerciseDao();
	
	/**
	 * register a Exercise
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(User_exercise form) throws User_exerciseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//Exercise exercise = exerciseDao.findByUsername(form.getUsername());
		//if(exercise.getUsername()!=null && exercise.getUsername().equals(form.getUsername())) throw new ExerciseException("This user name has been registered!");
		user_exerciseDao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	/*
	public void login(Exercise form) throws ExerciseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Exercise user = exerciseDao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new ExerciseException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new Entity1Exception(" The password is not right");
		
	}
	*/
}
