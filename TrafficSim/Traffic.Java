import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;

public class Traffic 
{

	JFrame frame = new JFrame("Traffic Simulator");
	Road road = new Road(); 
	
	
	public Traffic() 
	{
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout()); 
		frame.add(road, BorderLayout.CENTER); 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		
		Semi testsemi = new Semi(10, 20); 
		road.addCar(testsemi);  
		SUV testSUV = new SUV(10, 170); 
		road.addCar(testSUV);
		Sports testSports = new Sports(10, 320); 
		road.addCar(testSports);  
		frame.repaint();  
	}
	
	public static void main(String[] args) 
	{
		new Traffic(); 
	}

}
