/*
 * Yujun Lee
 * CapstoneBLACKPINK
 * P6 Mr Taylor Intro to Java
 */

import java.awt.*;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {

	// fields
	private int xCenter, yCenter, side;
	private double proteinAmount, sodiumAmount, carbohydrateAmount;
	private double calorie;
	private UserType user;
	private Color chartColor, sectorColor;

	// constructors
	public GraphicsPanel(int x, int y, int s, double protein, double sodium, double carbohydrate, double totalCalories, UserType type) {
		xCenter = x;
		yCenter = y;
		side = s;
		proteinAmount = protein;
		sodiumAmount = sodium;
		carbohydrateAmount = carbohydrate;
		calorie = totalCalories;
		user = type;
		chartColor = new Color(162,215,184);
		sectorColor = new Color(87,115,142);
	}

	// methods

	public void setNutrition(double proteinInput, double sodiumInput, double carbohydrateInput, double calorieInput) {
		proteinAmount = proteinInput; 								// statement defiining varialbe to statement value
		sodiumAmount = sodiumInput;
		carbohydrateAmount = carbohydrateInput;
		calorie = calorieInput;

	}
	
	public void setUser(UserType type) {
		user = type;
	}

	public void reset() {
		proteinAmount = 0;
		sodiumAmount = 0;
		carbohydrateAmount = 0;
		calorie = 0;
		repaint();
	}

	public void drawPieChart(Graphics g, int x, int y, int r, String name) {

	int fromDegree = 90; 
		
//		int red = chartColor.getRed();
//		int green = chartColor.getGreen();
//		int blue = chartColor.getBlue();
//		
//		int backgroundR = (int)((double)red *9 /10);
//		int backgroundG = (int)((double)green *9 /10);
//		int backgroundB = (int)((double)blue *9 /10);
//		
//		g.setColor(new Color(backgroundR, backgroundG, backgroundB));
		
		g.setColor(chartColor);
		g.fillOval(x - r, y - r, 2 * r, 2 * r);
		
		

		g.setColor(sectorColor);
		if(name.equals("Protein")) {
			int proteinAngle = convertToDegrees(proteinAmount, user.getUserProtein());
			drawSector(g, x, y, r, fromDegree, proteinAngle);
			g.setColor(Color.BLACK);
			g.drawString(name, x-15, y-r-15);
		}
		else if(name.equals("Sodium")) {
			int sodiumAngle = convertToDegrees(sodiumAmount, user.getUserSodium());
			drawSector(g, x, y, r, fromDegree, sodiumAngle);
			g.setColor(Color.BLACK);
			g.drawString(name, x-15, y-r-15);
		}
		else if(name.equals("Carbohydrate")) {
			int carbohydrateAngle = convertToDegrees(carbohydrateAmount, user.getUserCarbohydrate());
			drawSector(g, x, y, r, fromDegree, carbohydrateAngle);
			g.setColor(Color.BLACK);
			g.drawString(name, x-30, y-r-15);
		}
		else if(name.equals("Calorie")) {
			int calorieAngle = convertToDegrees(calorie, user.getUserCalories());
			drawSector(g, x, y, r, fromDegree, calorieAngle);
			g.setColor(Color.BLACK);
			g.drawString(name, x-20, y-r-15);
		}
		

//		g.setColor(Color.RED);
//		int proteinAngle = convertToDegrees(proteinAmount, total);
//		drawSector(g, x, y, r, fromDegree, proteinAngle);
//		fromDegree += proteinAngle;
//
//		g.setColor(Color.GREEN);
//		int sodiumAngle = convertToDegrees(sodiumAmount, total);
//		drawSector(g, x, y, r, fromDegree, sodiumAngle);
//		fromDegree += sodiumAngle;
//
//		g.setColor(Color.BLUE);
//		int carbohydrateAngle = convertToDegrees(carbohydrateAmount, total);
//		drawSector(g, x, y, r, fromDegree, carbohydrateAngle);

//		g.setColor(Color.BLACK);
//		g.drawOval(x - 50, y - 50, 100, 100);
//
//		g.setColor(Color.WHITE);
//		g.drawOval(x - 45, y - 45, 90, 90);
//
//		g.setColor(Color.BLACK);
//		g.drawString("Calories", x - 25, y - 3);
//		String calorieString = Double.toString(calorie);
//		g.drawString(calorieString + "cal (g)", x - 20, y + 10);

	}

	// Draws a sector, centered at x, y, of radius r,
	// of angle measure degrees, starting at fromDegree.
	private void drawSector(Graphics g, int x, int y, int r, int fromDegree, int degrees) {
		if (degrees > 359)
			g.fillOval(x - r, y - r, 2 * r, 2 * r);
	    else
		g.fillArc(x - r, y - r, 2 * r, 2 * r, fromDegree, degrees);// troubleshooting, idk why its not working??? anyone know???
	}

	// Returns the number of degrees in a pie chart given percentage.
	private int convertToDegrees(double amount, double totalAmount) {
		int degrees = 0;
		degrees = (int) (amount / totalAmount * 360 + 0.5);
		return degrees;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.drawLine(xCenter, yCenter - (int)((double)side/2), xCenter, yCenter + (int)((double)side/2));
//		g.drawLine(xCenter-(int)((double)side/2), yCenter, xCenter+(int)((double)side/2), yCenter);
		
		//protein	
	//	g.drawString("Protein", xCenter - (int)((double)side *0.22 +0.5)-15, yCenter - (int)((double)side *0.22 +0.5) - (int)((double)side *0.18 +0.5)-10);
		drawPieChart(g, xCenter - (int)((double)side *0.22 +0.5), yCenter - (int)((double)side *0.22 +0.5), (int)((double)side *0.18 +0.5), "Protein");
		
		//sodium
		//g.drawString("Sodium", xCenter, yCenter);
		drawPieChart(g, xCenter + (int)((double)side *0.22 +0.5), yCenter - (int)((double)side *0.22 +0.5), (int)((double)side *0.18 +0.5), "Sodium");
		
		//carbohydrate
		drawPieChart(g, xCenter - (int)((double)side *0.22 +0.5), yCenter + (int)((double)side *0.28 +0.5), (int)((double)side *0.18 +0.5), "Carbohydrate");

		//calorie
		drawPieChart(g, xCenter + (int)((double)side *0.22 +0.5), yCenter + (int)((double)side *0.28 +0.5), (int)((double)side *0.18 +0.5), "Calorie");

	}

}
