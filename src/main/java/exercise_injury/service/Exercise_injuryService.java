package exercise_injury.service;


import exercise_injury.dao.Exercise_injuryDao;
import exercise_injury.domain.Exercise_injury;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Exercise_injuryService {
	private Exercise_injuryDao exerciseDao = new Exercise_injuryDao();
	
	/**
	 * register a Exercise
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Exercise_injury form) throws Exercise_injuryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//Exercise exercise = exerciseDao.findByUsername(form.getUsername());
		//if(exercise.getUsername()!=null && exercise.getUsername().equals(form.getUsername())) throw new ExerciseException("This user name has been registered!");
		exerciseDao.add(form);
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
