/*
*@author: Katrina Mehring
*
*The MenuFrame, which makes the magic happen
*/

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MenuFrame extends JPanel implements ActionListener
{
	AppPanel playApp;
	Instructions instructions;
	JButton newGame;
	JButton exit;
	JButton doubleOrNothing;
	JButton instr;
	AppPanel app;
	boolean gameCreated;
	
	Graphics guy;
	
	public MenuFrame()
	{
		playApp = new AppPanel();
		instructions = new Instructions();
		newGame = new JButton();
		exit = new JButton();
		doubleOrNothing = new JButton();
		instr = new JButton();
		gameCreated = false;
		
		newGame.setText("Start a New Game (Bet a Quarter)");
		exit.setText("Exit");
		doubleOrNothing.setText("Play Again (Double or Nothing)");
		instr.setText("Read Instructions");
		
		add(newGame);
		add(doubleOrNothing);
		add(instr);
		add(exit);
		
		newGame.addActionListener(this);
		exit.addActionListener(this);
		doubleOrNothing.addActionListener(this);
		instr.addActionListener(this);
	}
	
	public static void main(String [] args)
	{
		JFrame menu = new JFrame();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setTitle("Find The Queen Game Menu");
		menu.setSize(210, 170);
		MenuFrame newMenu = new MenuFrame();
		menu.add(newMenu);
		menu.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		//Help from Professor Heiner on November 25
		if(((JButton)e.getSource()).equals(newGame))//Help from Brian in class 12/2/14
		{
			if(!gameCreated)		
			{
				gameCreated = true;
				app = new AppPanel();
			}
			else
			{
				app.dispose();
				app = new AppPanel();
			}
			app.anApp();
		}
		if(((JButton)e.getSource()).equals(doubleOrNothing))//Help from Brian in class 12/2/14
		{
			boolean don = true;
			if(!gameCreated)
			{
				gameCreated = true;
				app = new AppPanel(don);
			}
			else
			{
				app.dispose();
				app = new AppPanel(don);
			}
			app.anApp();
		}
		if(((JButton)e.getSource()).equals(instr))
		{
			instructions.Instruction();
		}
		if(((JButton)e.getSource()).equals(exit))
		{
			System.exit(0);
		}
	}
}
