package user.domain;

/**
 * User object
 * @author Aayush Makharia
 */
public class Table {
	/*
	 * Correspond to the user table
	 */
	
	private String col1;
	private String col2; 
	private String col3;
	private String col4;
	

	
	public String getCol1() {
		return col1;
	}

	public void setCol1(String colOne) {
		this.col1 = colOne;
	}
	
	public String getCol2() {
		return col2;
	}

	public void setCol2(String colTwo) {
		this.col2 = colTwo;
	}
	
	public String getCol3() {
		return col3;
	}

	public void setCol3(String colThree) {
		this.col3 = colThree;
	}
	
	public String getCol4() {
		return col4;
	}

	public void setCol4(String colFour) {
		this.col4 = colFour;
	}

	

	
	@Override
	public String toString() {
		return "Table [ col1=" + col1 + ", col2="
				+ col2 + ", col3=" + col3 +"]";
	}
}
