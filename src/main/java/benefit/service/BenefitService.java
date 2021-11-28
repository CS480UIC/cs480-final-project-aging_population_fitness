package benefit.service;


import benefit.dao.BenefitDao;
import benefit.domain.Benefit;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class BenefitService {
	private BenefitDao benefitDao = new BenefitDao();
	
	/**
	 * register a Benefit
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Benefit form) throws BenefitException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		//Exercise exercise = exerciseDao.findByUsername(form.getUsername());
		//if(exercise.getUsername()!=null && exercise.getUsername().equals(form.getUsername())) throw new ExerciseException("This user name has been registered!");
		benefitDao.add(form);
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
