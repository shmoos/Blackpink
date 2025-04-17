import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BlackPinkCapstone extends JFrame{
	
	public BlackPinkCapstone() {
		
		ApplicationPanel application = new ApplicationPanel();
		
		//GraphicsPanel graphics = new GraphicsPanel(250,250,200,0,0,0,0,0);
		
		Container c = getContentPane();
	    c.setBackground(Color.GRAY);
	    //c.add(graphics);
	    c.add(application);
		
	}

	public static void main(String[] args) {
		// O Auto-generated method stub
		BlackPinkCapstone window = new BlackPinkCapstone();
		window.setBounds(50, 15, 1025, 800); // change dimensions to show all 3 vending machines 
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);

	}

}
