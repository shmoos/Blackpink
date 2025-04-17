// implemented class of UserType
/*
 * Yusuf Jabbar, Yujun Lee, Leon Meng
 * CapstoneBLACKPINK 
 * P6 Mr Taylor Intro to Java
 */
public class StayAtHomeParents implements UserType {

	public String toString() {
		return "StayAtHomeParents";
	}

	public String getUserType() {
		return "The Stay At Home Parent Profile has 55.1g of protein, 2070mg of sodium, 292.5g of carbohydrates, and a total of 2,430 calories per day.";
	}

	public double getUserProtein() {
		return 55.1;
	}

	public double getUserSodium() {
		return 2070;
	}

	public double getUserCarbohydrate() {
		return 292.5;
	}

	public double getUserCalories() {
		return 2430;
	}
}
