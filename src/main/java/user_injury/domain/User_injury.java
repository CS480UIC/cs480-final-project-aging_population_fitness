package user_injury.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class User_injury {
	/*
	 * Correspond to the exercise table
	 */
	
	private String injury_id;
	private String user_id; 
	private String user_injury_name;
	private String user_injury_description;
	private String user_injury_severity;
	private String user_injury_date;
	
	public String getInjuryID() {
		return injury_id;
	}

	public void setInjuryID(String injury_id) {
		this.injury_id = injury_id;
	}
	
	public String getUserID() {
		return user_id;
	}

	public void setUserID(String user_id) {
		this.user_id = user_id;
	}

	public String getUserInjuryName() {
		return user_injury_name;
	}

	public void setUserInjuryName(String user_injury_name) {
		this.user_injury_name = user_injury_name;
	}
	
	public String getUserInjuryDescription() {
		return user_injury_description;
	}
	
	public void setUserInjuryDescription(String user_injury_description) {
		this.user_injury_description = user_injury_description;
	}
	
	public String getUserInjurySeverity() {
		return user_injury_severity;
	}
	
	public void setUserInjurySeverity(String user_injury_severity) {
		this.user_injury_severity = user_injury_severity;
	}
	
	public String getUserInjuryDate() {
		return user_injury_date;
	}
	
	public void setUserInjuryDate(String user_injury_date) {
		this.user_injury_date = user_injury_date;
	}

	@Override
	public String toString() {
		return "User_injury [ injury_id=" + injury_id + ", user_id="
				+ user_id + ", user_injury_name=" + user_injury_name + 
				", user_injury_description=" + user_injury_description + 
				", user_injury_severity=" + user_injury_severity + 
				", user_injury_date=" + user_injury_date + "]";
	}
}