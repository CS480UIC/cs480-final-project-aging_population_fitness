package exercise_injury.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Exercise_injury {
	/*
	 * Correspond to the exercise table
	 */
	
	private String injury_id;
	private String exercise_id; 
	private String exercise_injury_name;
	private String exercise_injury_description;
	
	
	public String getInjuryID() {
		return injury_id;
	}

	public void setInjuryID(String injuryID) {
		this.injury_id = injuryID;
	}
	
	public String getExerciseID() {
		return exercise_id;
	}

	public void setExerciseID(String exerciseID) {
		this.exercise_id = exerciseID;
	}
	
	public String getExerciseInjuryName() {
		return exercise_injury_name;
	}

	public void setExerciseInjuryName(String exerciseInjuryName) {
		this.exercise_injury_name = exerciseInjuryName;
	}

	public String getExerciseInjuryDescription() {
		return exercise_injury_description;
	}

	public void setExerciseInjuryDescription(String exerciseInjuryDescription) {
		this.exercise_injury_description = exerciseInjuryDescription;
	}
	
	

	@Override
	public String toString() {
		return "Exercise_injury [ injury_id=" + injury_id + ", exercise_id=" + exercise_id + ", exercise_injury_name="
				+ exercise_injury_name + ", exercise_injury_description=" + exercise_injury_description + "]";
	}
}
