// implemented class of UserType
/*
 * Yusuf Jabbar, Yujun Lee, Leon Meng
 * CapstoneBLACKPINK 
 * P6 Mr Taylor Intro to Java
 */
public class Athletes implements UserType {

	public String toString() {
		return "Athletes";
	}

	public String getUserType() {
		return "The Athlete Profile has 133.3g of protein, 4300mg of sodium, 576g of carbohydrates, and a total of 4,000 calories per day.";
	}

	public double getUserProtein() {
		return 133.3;
	}

	public double getUserSodium() {
		return 4300;
	}

	public double getUserCarbohydrate() {
		return 576;
	}

	public double getUserCalories() {
		return 4000;
	}
}
