// implemented class of UserType
/*
 * Yusuf Jabbar, Yujun Lee, Leon Meng
 * CapstoneBLACKPINK 
 * P6 Mr Taylor Intro to Java
 */
public class NineToFive implements UserType {

	public String toString() {
		return "NineToFive";
	}

	public String getUserType() {
		return "The 9 to 5 Profile has 61.2g of protein, 2300mg of sodium, 325g of carbohydrates, and a total of 2,700 calories per day.";
	}

	public double getUserProtein() {
		return 61.2;
	}

	public double getUserSodium() {
		return 2300;
	}

	public double getUserCarbohydrate() {
		return 325;
	}

	public double getUserCalories() {
		return 2700;
	}
	// 9-5 Adult Work
	// Protein: 61.2 g
	// Sodium:2,300 mg = 2.3g
	// Carbohydrates: 325 g
	// Calories: 2,700 calories

}
