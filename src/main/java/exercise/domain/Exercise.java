package exercise.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Exercise {
	/*
	 * Correspond to the exercise table
	 */
	
	private String exercise_id;
	private String exercise_name; 
	private String exercise_description;
	private String exercise_difficulty;
	
	
	public String getExerciseID() {
		return exercise_id;
	}

	public void setExerciseID(String exerciseID) {
		this.exercise_id = exerciseID;
	}
	
	public String getExerciseName() {
		return exercise_name;
	}

	public void setExerciseName(String exerciseName) {
		this.exercise_name = exerciseName;
	}

	public String getExerciseDescription() {
		return exercise_description;
	}

	public void setExerciseDescription(String exerciseDescription) {
		this.exercise_description = exerciseDescription;
	}
	
	public String getExerciseDifficulty() {
		return exercise_difficulty;
	}

	public void setExerciseDifficulty(String exerciseDifficulty) {
		this.exercise_difficulty = exerciseDifficulty;
	}

	@Override
	public String toString() {
		return "Exercise [ exercise_id=" + exercise_id + ", exercise_name="
				+ exercise_name + ", exercise_description=" + exercise_description + ", exercise_difficulty=" + exercise_difficulty + "]";
	}
}
