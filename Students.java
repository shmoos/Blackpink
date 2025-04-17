// implemented class of UserType
/*
 * Yusuf Jabbar, Yujun Lee, Leon Meng
 * CapstoneBLACKPINK 
 * P6 Mr Taylor Intro to Java
 */

public class Students implements UserType {

	public String toString() {
		return "Students";
	}

	public String getUserType() {
		return "The Student Profile has 49g of protein, 2300mg of sodium, 130g of carbohydrates, and a total of 2,600 calories per day.";
	}

	public double getUserProtein() {
		return 49;
	}

	public double getUserSodium() {
		return 2300;
	}

	public double getUserCarbohydrate() {
		return 130;
	}

	public double getUserCalories() {
		return 2600;
	}

}
