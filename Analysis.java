/*
 * Yusuf Jabbar, Yujun Lee, Leon Meng
 * CapstoneBLACKPINK 
 * P6 Mr Taylor Intro to Java
 */
public class Analysis extends Scanner {

	// fields
	private UserType user;
	
	private int a, b, c;

	// constructors
	public Analysis(double proteinAmount, double sodiumAmount, double carbohydrateAmount, double caloriesAmount,
			UserType userType) {
		super(proteinAmount, sodiumAmount, carbohydrateAmount, caloriesAmount);
		user = userType;
		a = 0;
		b = 0;
		c = 0;
	}

	// methods

//		int good = 0;
//		int bad = 0; 
//		int noChange = 0; 
//		
//			
//		if (userType == good) {
//			System.out.println("Your diet is good. As you see above your daily calorie intake compared to the targeted calorie intake is good."
//					+ "No major changes should be changed. "
//					+ "THANK YOU for using our program. ");// insert a good response containing that they are  following their calorie intake. 
//		}
//		if (userType == bad) { 
//			System.out.println("You should try changing your diet. What is shown above is your daily calorie intake that should change."
//					+ "Try follwing the modified set of calories that should get you to your goal as soon as possible."
//					+ "Have a nice day and THANK YOU for using our program.");// insert a bad response containing that they are not following their calorie intake. 
	// if (user == noChange) {
	// insert a response containng no change in diet.

	public double calculateProteinPercent() { // calculates the percent of the protein needed to satisfy the user

		double proteinAmount2 = user.getUserProtein();

		double returnValue1 = super.getProtein() / proteinAmount2;

		return returnValue1;

	}

	public double calculateCarbohydratesPercent() { // calculates the percent of the Carbohydrates needed to satisfy the
													// user

		double carbohydrateAmount2 = user.getUserCarbohydrate();

		double returnValue2 = super.getCarbohydrates() / carbohydrateAmount2;
		return returnValue2;
	}

	public double calculateCaloriesPercent() { // calculates the percent of the Calories needed to satisfy the user

		double calorieAmount2 = user.getUserCalories();

		double returnValue3 = super.getCalories() / calorieAmount2;
		return returnValue3;
	}

	public double calculateSodiumPercent() { // calculates the percent of the Sodium needed to satisfy the user

		double sodiumAmount2 = user.getUserSodium();

		double returnValue4 = super.getSodium() / sodiumAmount2;
		return returnValue4;

	}

	public String analyzeUser() { // caluclating the full spread of all calorie requirement
//		if (calculateProteinPercent() > 0.85 && calculateCarbohydratesPercent() > 0.85
//				&& calculateCaloriesPercent() > 0.85 && calculateSodiumPercent() > 0.85) {
//			return "Your diet is good. As you see above your daily calorie intake compared to the targeted"
//					+ " calorie intake is good."
//							+ "Total Daily Protein Percet Consumed-->" + calculateProteinPercent();
//
//		}
		
		String result = "";
		
		// excellent results
		if(calculateProteinPercent() > 0.85) {
			a++;
			result = result + "\nYour protein intake is " + super.getProtein() + " grams. This amount satisfies your daily intake.";
		}
		
		if(calculateSodiumPercent() > 0.85) {
			a++;
			result = result + "\nYour sodium intake is " + super.getSodium() + " miligrams. This amount satisfies your daily intake.";
		}
		
		if(calculateCarbohydratesPercent() > 0.85) {
			a++;
			result = result + "\nYour carbohydrate intake is " + super.getCarbohydrates() + " grams. This amount satisfies your daily intake.";
		}
		
		if(calculateCaloriesPercent() > 0.85) {
			a++;
			result = result + "\nYour calories intake is " + super.getCalories() + " grams. This amount satisfies your daily intake.";
		}
		
		// average results
		if(calculateProteinPercent() >= 0.55 && calculateProteinPercent() <= 0.85) {
			b++;
			result = result + "\nYour protein intake is " + super.getProtein() + " grams. This amount does not satisfy your daily intake.";
		}
		
		if(calculateSodiumPercent() >= 0.55 && calculateSodiumPercent() <= 0.85) {
			b++;
			result = result + "\nYour sodium intake is " + super.getSodium() + " miligrams. This amount does not satisfy your daily intake.";
		}
		
		if(calculateCarbohydratesPercent() >= 0.55 && calculateCarbohydratesPercent() <= 0.85) {
			b++;
			result = result + "\nYour carbohydrate intake is " + super.getCarbohydrates() + " grams. This amount does not satisfy your daily intake.";
		}
		
		if(calculateCaloriesPercent() >= 0.55 && calculateCarbohydratesPercent() <= 0.85) {
			b++;
			result = result + "\nYour calories intake is " + super.getCalories() + " grams. This amount does not satisfy your daily intake.";
		}
		
		// bad results
		if(calculateProteinPercent() < 0.55) {
			c++;
			result = result + "\nYour protein intake is " + super.getProtein() + " grams. This amount is not sufficient for your daily intake.";
		}
		
		if(calculateSodiumPercent() < 0.55) {
			c++;
			result = result + "\nYour sodium intake is " + super.getSodium() + " miligrams. This amount is not sufficient for your daily intake.";
		}
		
		if(calculateCarbohydratesPercent() < 0.55) {
			c++;
			result = result + "\nYour carbohydrate intake is " + super.getCarbohydrates() + " grams. This amount is not sufficient for your daily intake.";
		}
		
		if(calculateCaloriesPercent() < 0.55) {
			c++;
			result = result + "\nYour calories intake is " + super.getCalories() + " grams. This amount is not sufficient for your daily intake.";
		}
		
		// conclusive statement
		if (a >= 3)
			result = result + "\n\nConclusively, you have a balanced and nutritious diet that aligns with your health goals.";
			
		else if (b >= 2 && c < 2)
			result = result + "\n\nConclusively your diet is well balanced and aligns with your health goals in most aspects, but certain macros are lacking. ";
			
		else if (c >= 2)
			result = result + "\n\nConclusively, your diet does not align with your health goals as it doesn't meet nutritional standards"; 
		
		// hard to make logic work...possible if more time
//		if (a + b + c < 4) {
//			result = result + "\nThe inputted macros are not sufficient in producing a conclusive statement regarding your health goals.";
//		}
		
		return result;
		
	}

	public void setUser(UserType userType) {
		user = userType;
	}

}
