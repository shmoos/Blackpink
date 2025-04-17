import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class ApplicationPanel extends JPanel implements ActionListener{
	
	//fields
	private GraphicsPanel graphics;
	private Analysis analyzer;
	private UserType[] types = new UserType[] {new Athletes(), new NineToFive(), new StayAtHomeParents(), new Students()};
	private JComboBox chooseType;
	private JButton displayUserType;
	private JLabel scanner, protein, sodium, carbohydrate, calories;
	private JTextField carbohydrateInput, proteinInput, sodiumInput, calorieInput;
	private JTextArea analysis;
	private JButton reset, add, analyze;
	
	
	//constructors
	public ApplicationPanel() {
		
		setBackground(Color.WHITE);
		
		setupGui();
		
	}
	
	//methods
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(225,200,180));
		g.fillRect(590, 60, 410, 700);
		g.setColor(Color.BLACK);
		g.drawRect(590, 60, 410, 700);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton)e.getSource();
		
		if (button == displayUserType) {
			UserType type = (UserType)chooseType.getSelectedItem();
			JOptionPane.showMessageDialog(null, type.getUserType(), "User Type Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (button == add) {
			if(isDecimal(proteinInput.getText()) 
					&& isDecimal(sodiumInput.getText())
					&& isDecimal(carbohydrateInput.getText())
					&& isDecimal(calorieInput.getText())) {
				analyzer.addProtein(toDouble(proteinInput.getText()));
				analyzer.addSodium(toDouble(sodiumInput.getText()));
				analyzer.addCarbohydrates(toDouble(carbohydrateInput.getText()));
				analyzer.addCalories(toDouble(calorieInput.getText()));
				refresh();
			}
			else {
				JOptionPane.showMessageDialog(null, "Input values should be nonnegative number", "Error", JOptionPane.ERROR_MESSAGE);
				refresh();
			}
		}
		else if (button == reset) {
			graphics.reset();
			analyzer.reset();
			analysis.setText("");
			refresh();
		}
		else if (button == analyze) {
			analysis.setText(analyzer.analyzeUser());
			graphics.setUser((UserType)chooseType.getSelectedItem());
			graphics.setNutrition(analyzer.getProtein(), analyzer.getSodium(), analyzer.getCarbohydrates(), analyzer.getCalories());
			graphics.repaint();
			refresh();
		}
		
	}
	
	public boolean isNumeric(String input) {
		boolean result = true;
		for(int i = 0; i < input.length() && result == true; i++) {
			result = Character.isDigit(input.charAt(i));
		}
		return result;
	}
	
	public boolean isDecimal(String input) {
		
		int point = input.indexOf('.');
		if (point == -1) {
			return isNumeric(input);
		}
		else {
			String intPortion = input.substring(0, point);
			String decimalPortion = input.substring(point+1);
			return isNumeric(intPortion) && isNumeric(decimalPortion);
		}
		
	}
	
	public double toDouble(String input) {
		
		int point = input.indexOf('.');
		if (point == -1) {
			return (double)Integer.parseInt(input);
		}
		else {
			String intPortion = input.substring(0, point);
			String decimalPortion = input.substring(point+1);
			return Integer.parseInt(intPortion) + (double)Integer.parseInt(decimalPortion)/Math.pow(10, decimalPortion.length());
		}
	}
	
	
	
	public void refresh() {
		proteinInput.setText("");
		sodiumInput.setText("");
		carbohydrateInput.setText("");
		calorieInput.setText("");
		analyzer.setUser((UserType)chooseType.getSelectedItem());
		
		//debug code (delete later)////////////////////////////////////////////////////////////////////////////////****************
		System.out.println("Protein: " + analyzer.getProtein() + "g\n" 
		+ "Sodium: " + analyzer.getSodium() + "mg\n" 
		+ "Carbohydrate: " + analyzer.getCarbohydrates() + "g\n"
		+ "Calories: " + analyzer.getCalories() + "g\n");
	}
	
	public void setupGui() {
		
		chooseType = new JComboBox(types);
		graphics = new GraphicsPanel(275, 275, 550, 0, 0, 0, 0, (UserType)chooseType.getSelectedItem());
		analyzer = new Analysis(0, 0, 0, 0, (UserType)chooseType.getSelectedItem());
		
		displayUserType = new JButton("i");
		displayUserType.setPreferredSize(new Dimension(37, 30));
		displayUserType.setToolTipText("See User Type Information");
		displayUserType.addActionListener(this);
		
		scanner = new JLabel("Input nutrition fact");
		scanner.setPreferredSize(new Dimension(75, 30));
		protein = new JLabel("Protein(g)");
		protein.setPreferredSize(new Dimension(75, 50));
		sodium = new JLabel("Sodium(mg)");
		sodium.setPreferredSize(new Dimension(75, 50));
		carbohydrate = new JLabel("Carbs(g)");
		calories = new JLabel("Calories(g)");
		calories.setPreferredSize(new Dimension(75, 50));
//		gram = new JLabel("Grams");
//		gram.setPreferredSize(new Dimension(75, 50));
		
		proteinInput = new JTextField(10);
		proteinInput.setPreferredSize(new Dimension (150, 50));
		sodiumInput = new JTextField(10);
		sodiumInput.setPreferredSize(new Dimension (150, 50));
		carbohydrateInput = new JTextField(10);
		carbohydrateInput.setPreferredSize(new Dimension (150, 50));
		calorieInput = new JTextField(10);
		calorieInput.setPreferredSize(new Dimension (150, 50));
//		gramInput = new JTextField(10);
//		gramInput.setPreferredSize(new Dimension (150, 50));
		
		analysis = new JTextArea(10, 5);
		analysis.setEditable(false);
//		analysis.setLineWrap(true);
		
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(75, 30));
		reset.setToolTipText("Reset Data");
		reset.addActionListener(this);
		add = new JButton("Add");
		add.setPreferredSize(new Dimension(75, 30));
		add.setToolTipText("Add data");
		add.addActionListener(this);
		analyze = new JButton("Analyze");
		analyze.setPreferredSize(new Dimension(75, 30));
		analyze.setToolTipText("Analyze Data");
		analyze.addActionListener(this);
		
		//main wall
		Box wall = Box.createHorizontalBox();
		wall.setPreferredSize(new Dimension(1000, 750));
		wall.add(Box.createHorizontalStrut(13));
		
		//left portion of the panel
		Box leftWall = Box.createVerticalBox();
		leftWall.setPreferredSize(new Dimension(550, 750));
		Box pieChartBox = Box.createHorizontalBox();
		pieChartBox.setPreferredSize(new Dimension(550, 550));
		pieChartBox.add(graphics);
		leftWall.add(pieChartBox);
		leftWall.add(Box.createHorizontalStrut(5));
		leftWall.add(analysis);
		leftWall.add(Box.createHorizontalStrut(5));
		wall.add(leftWall); 
		wall.add(Box.createHorizontalStrut(15)); 
		
		
		//right portion of the panel
		Box rightWall = Box.createVerticalBox();
		rightWall.setPreferredSize(new Dimension(380, 750));
		//top portion of the rightWall
		Box userTypeChoice = Box.createHorizontalBox();
		userTypeChoice.setPreferredSize(new Dimension(375, 45));
		userTypeChoice.add(Box.createHorizontalStrut(5));
		userTypeChoice.add(chooseType);
		userTypeChoice.add(Box.createHorizontalStrut(10));
		userTypeChoice.add(displayUserType);
		userTypeChoice.add(Box.createHorizontalStrut(5));
		rightWall.add(userTypeChoice);
		rightWall.add(Box.createVerticalStrut(5));
		//middle-bottom portion of the rightWall
		
		Box scannerBox = Box.createVerticalBox();
		scannerBox.setPreferredSize(new Dimension(375, 600));
		scannerBox.add(Box.createVerticalStrut(5));
		//scanner JLabel
		Box scannerText = Box.createHorizontalBox();
		scannerText.add(scanner);
		scannerBox.add(scannerText);
		scannerBox.add(Box.createVerticalStrut(5));
		
		//input box
		Box inputBox = Box.createHorizontalBox();
		inputBox.setPreferredSize(new Dimension(375, 220));
		inputBox.add(Box.createHorizontalStrut(10));
		//jlabel box
		Box nutritionText = Box.createVerticalBox();
		nutritionText.setPreferredSize(new Dimension(85, 175));
		//nutritionText.add(Box.createVerticalStrut(5));
		nutritionText.add(protein);
		nutritionText.add(Box.createVerticalStrut(130));
		nutritionText.add(sodium);
		nutritionText.add(Box.createVerticalStrut(130));
		nutritionText.add(carbohydrate);
		nutritionText.add(Box.createVerticalStrut(130));
		nutritionText.add(calories);
		inputBox.add(nutritionText);
		inputBox.add(Box.createHorizontalStrut(30));
		//text box
		Box textBox = Box.createVerticalBox();
		textBox.setPreferredSize(new Dimension(295, 175));
		textBox.add(proteinInput);
		textBox.add(Box.createVerticalStrut(10));
		textBox.add(sodiumInput);
		textBox.add(Box.createVerticalStrut(10));
		textBox.add(carbohydrateInput);
		textBox.add(Box.createVerticalStrut(10));
		textBox.add(calorieInput);
		textBox.add(Box.createVerticalStrut(10));
		inputBox.add(textBox);
		scannerBox.add(inputBox);
		scannerBox.add(Box.createVerticalStrut(10));
		
		
		
//		//protein input box
//		Box proteinBox = Box.createHorizontalBox();
//		proteinBox.setPreferredSize(new Dimension(375, 30));
//		proteinBox.add(protein);
//		proteinBox.add(Box.createHorizontalStrut(30));
//		proteinBox.add(proteinInput);
//		scannerBox.add(proteinBox);
//		scannerBox.add(Box.createVerticalStrut(5));
//		//sodium input box
//		Box sodiumBox = Box.createHorizontalBox();
//		sodiumBox.setPreferredSize(new Dimension(375, 30));
//		sodiumBox.add(sodium);
//		sodiumBox.add(Box.createHorizontalStrut(30));
//		sodiumBox.add(sodiumInput);
//		scannerBox.add(sodiumBox);
//		scannerBox.add(Box.createVerticalStrut(5));
//		//carbohydrate input box
//		Box carbohydrateBox = Box.createHorizontalBox();
//		carbohydrateBox.setPreferredSize(new Dimension(375, 30));
//		carbohydrateBox.add(carbohydrate);
//		carbohydrateBox.add(Box.createHorizontalStrut(30));
//		carbohydrateBox.add(carbohydrateInput);
//		scannerBox.add(carbohydrateBox);
//		scannerBox.add(Box.createVerticalStrut(5));
//		//calorie input box
//		Box calorieBox = Box.createHorizontalBox();
//		calorieBox.setPreferredSize(new Dimension(375, 30));
//		calorieBox.add(calories);
//		calorieBox.add(Box.createHorizontalStrut(30));
//		calorieBox.add(calorieInput);
//		scannerBox.add(calorieBox);
//		scannerBox.add(Box.createVerticalStrut(5));
		
		//gram input box
//		Box gramBox = Box.createHorizontalBox();
//		gramBox.setPreferredSize(new Dimension(375, 50));
//		gramBox.add(gram);
//		gramBox.createHorizontalStrut(30);
//		gramBox.add(gramInput);
//		scannerBox.add(gramBox);
//		scannerBox.add(Box.createVerticalStrut(5));
		//buttons box
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.setPreferredSize(new Dimension(375, 50));
		buttonBox.add(reset);
		buttonBox.add(Box.createHorizontalStrut(35));
		buttonBox.add(add);
		buttonBox.add(Box.createHorizontalStrut(35));
		buttonBox.add(analyze);
		scannerBox.add(buttonBox);
		scannerBox.add(Box.createVerticalStrut(5));
		rightWall.add(scannerBox);
		rightWall.add(Box.createVerticalStrut(5));
		wall.add(rightWall);	
		wall.add(Box.createHorizontalStrut(13));
		
		add(wall);
		 n                        bbbbbbb
		
	}
	
//	public static void main(String[] args) {
//		// O Auto-generated method stub
//		ApplicationPanel window = new ApplicationPanel();
//		window.setBounds(50, 50, 900, 700); // change dimensions to show all 3 vending machines 
//		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	//	window.setResizable(false);
//		window.setVisible(true);
//
//	}
	
}

