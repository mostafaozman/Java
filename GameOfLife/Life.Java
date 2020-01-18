/*
 * 
 * This program implements Conway's game of life Simulation
 * 
 *  Author: Mostafa O
*/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Life implements MouseListener, ActionListener, Runnable
{
	//Variables and objects
	boolean[][] cells = new boolean[25][25];
	JFrame frame = new JFrame("Life Simulation");
	LifePanel panel = new LifePanel(cells);
	Container south = new Container();
	JButton step = new JButton("Step");
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	boolean running = false;
	//Constructor 
	public Life()
	{
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		panel.addMouseListener(this);
		// South Container
		south.setLayout(new GridLayout(1,3));
		south.add(step);
		step.addActionListener(this);
		south.add(start);
		stop.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new Life();

	}

	@Override
	public void mouseClicked(MouseEvent event) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent event) 
	{
		
	}

	// When the mouse is released it will find the location of the cell that the curser was located and paint the cell
	@Override
	public void mouseReleased(MouseEvent event)
	{
		System.out.println(event.getX() + "," + event.getY());
		double width = ((double)panel.getWidth()) / cells[0].length;
		double height = ((double)panel.getHeight()) / cells.length;
		int column = Math.min(cells[0].length, (int)(event.getX() / width));
		int row = Math.min(cells.length, (int)(event.getY() / height));
		System.out.println(column + "," + row);
		cells[row][column] = !cells[row][column];
		frame.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent event) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent event) 
	{
		
	}
	// These are the actions that will be performed when each button is clicked
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(step))
		{
			System.out.println("Step");
			step();
		}
		if (event.getSource().equals(start))
		{
			System.out.println("Start");
			if (running = false)
			{
				running = true;
				Thread t = new Thread(this);
				t.start();
			}
		}
		if (event.getSource().equals(stop))
		{
			System.out.println("Stop");
			running = false;
		}
		
	}
	// Continuously step as long as stop has not been clicked
	@Override
	public void run() 
	{
		while (running = true)
		{
			step();
			try 
			{
				// 500ms delay between each step
				Thread.sleep(500);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void step()
	{
		// checking each cell around a painted cell and counting the number of cells
		boolean[][] nextCells = new boolean[cells.length][cells[0].length];
		for (int row = 0; row < cells.length; row++)
		{
		for (int column = 0; column < cells[0].length; column++)
		{
			int neighborCount = 0;
			if (row > 0 && column > 0 && cells[row-1][column-1] == true)//up left
			{
				neighborCount++;
			}
			if (row > 0 && cells[row-1][column] == true )//up
			{
				neighborCount++;
			}
			if (row > 0 && column < cells[0].length-1 && cells[row-1][column+1] == true)//up right
			{
				neighborCount++;
			}
			if (column > 0 && cells[row][column-1] == true)//left
			{
				neighborCount++;
			}
			if (column < cells[0].length-1 && cells[row][column+1] == true)//right
			{
				neighborCount++;
			}
			if (row < cells.length-1 && column > 0 && cells[row+1][column-1] == true)//down left
			{
				neighborCount++;
			}
			if (row < cells.length-1 && cells[row+1][column] == true)//down
			{
				neighborCount++;
			}
			if (row < cells.length-1 && column < cells[0].length-1 && cells[row+1][column+1] == true)//down right
			{
				neighborCount++;
			}
			//Rules of Life
			if (cells[row][column] == true)//Alive
			{
				if (neighborCount == 2 || neighborCount == 3)
				{
					nextCells[row][column] = true; //Alive next time
				}
				else 
				{
					nextCells[row][column] = false; //Dead next time
				}
			}
			else //Dead right now
			{
				if (neighborCount == 3)
				{
					nextCells[row][column] = true; //Alive next time
				}
				else
				{
					nextCells[row][column] = false; //Dead next time
				}
			}
		}
	}
	/*for (int row = 0; row < cells.length; row++) {
		for (int column = 0; column < cells[0].length; column++) {
			if (nextCells[row][column] == true)	{
				cells[row][column] = true;
			}
			else 	{
				cells[row][column] = false;
			}
		}
			
	}
	*/
	cells = nextCells;
	panel.setCells(nextCells);
	frame.repaint();
	
	}

} 
