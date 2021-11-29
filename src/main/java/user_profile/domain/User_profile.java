package user_profile.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class User_profile {
	/*
	 * Correspond to the exercise table
	 */
	
	private String user_id;
	private String username; 
	private String profile_name;	
	
	public String getUserID() {
		return user_id;
	}

	public void setUserID(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getProfileName() {
		return profile_name;
	}

	public void setProfileName(String profileName) {
		this.profile_name = profileName;
	}


	@Override
	public String toString() {
		return "User_profle [ user_id=" + user_id + ", username="
				+ username + ", profile_name=" + profile_name + "]";
	}
}