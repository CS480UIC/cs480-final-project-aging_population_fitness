package user_exercise.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class User_exercise {
	/*
	 * Correspond to the exercise table
	 */
	
	private String user_id;
	private String exercise_id;
	
	public String getUserID() {
		return user_id;
	}

	public void setUserID(String user_id) {
		this.user_id = user_id;
	}
	
	public String getExerciseID() {
		return exercise_id;
	}

	public void setExerciseID(String exercise_id) {
		this.exercise_id = exercise_id;
	}
}

	@Override
	public String toString() {
		return "User_exercise [ user_id=" + user_id + ", exercise_id="
				+ exercise_id + "]";
	}
}