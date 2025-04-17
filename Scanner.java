// class is used to get user input on various nutrition facts

/*
 * Yusuf Jabbar, Yujun Lee, Leon Meng
 * CapstoneBLACKPINK 
 * P6 Mr Taylor Intro to Java
 */

public class Scanner {

	//fields --- various types of macros?
	
	private double protein;		// grams
	private double sodium;			
	private double carbohydrates;
	private double calories;
	
	
	
	//constructors
	
	public Scanner (double proteinAmount, double sodiumAmount, double carbohydrateAmount, double caloriesAmount) {
		
		protein = proteinAmount;
		sodium = sodiumAmount;
		carbohydrates = carbohydrateAmount;
		calories = caloriesAmount;

	}
	//methods
	
	//setters
	public void addProtein(double proteinAmount)
	{
		protein += proteinAmount;					// stubbed out return
	}
	
	public void addSodium(double sodiumAmount)
	{
		sodium += sodiumAmount;
	}
	
	public void addCarbohydrates(double carbohydrateAmount)
	{
		carbohydrates += carbohydrateAmount;					// stubbed out return
	}
	
	public void addCalories(double caloriesAmount)
	{
		calories += caloriesAmount;					// stubbed out return
	}
	
	//getters
	
	public double getProtein() {
		return protein;
	}
	
	public double getSodium() {
		return sodium;
	}
	
	public double getCarbohydrates() {
		return carbohydrates;
	}
	
	public double getCalories() {
		return calories;
	}
	
	public void reset() {
		protein = 0;
		sodium = 0;
		carbohydrates = 0;
		calories = 0;
	}
	
	
}
