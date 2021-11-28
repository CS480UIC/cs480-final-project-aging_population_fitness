package benefit.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Benefit {
	/*
	 * Correspond to the exercise table
	 */
	
	private String benefit_id;
	private String exercise_id; 
	private String benefit_name;
	private String benefit_description;
	
	public String getBenefitID() {
		return benefit_id;
	}

	public void setBenefitID(String benefitID) {
		this.benefit_id = benefitID;
	}
	
	public String getExerciseID() {
		return exercise_id;
	}

	public void setExerciseID(String exerciseID) {
		this.exercise_id = exerciseID;
	}
	
	public String getBenefitName() {
		return benefit_name;
	}

	public void setBenefitName(String benefitName) {
		this.benefit_name = benefitName;
	}

	public String getBenefitDescription() {
		return benefit_description;
	}

	public void setBenefitDescription(String benefitDescription) {
		this.benefit_description = benefitDescription;
	}
	
	

	@Override
	public String toString() {
		return "Benefit [ benefit_id=" + benefit_id + "exercise_id=" + exercise_id + ", benefit_name="
				+ benefit_name + ", benefit_description=" + benefit_description + "]";
	}
}
