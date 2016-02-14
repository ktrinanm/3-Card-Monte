/*
*@author: Katrina Mehring
*
*This class brings up the instruction panel
*/

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

//class based off examples on page 656-657 in Java book

@SuppressWarnings("serial")
public class Instructions extends JPanel
{
	public void paint(Graphics guy)
	{

		super.paint(guy);
		
		String instruct = "";
		int i= 0;
		try {
			Scanner input = new Scanner(new File("Instructions.txt"));
			while(input.hasNext())
			{		
				instruct = input.nextLine();
				guy.setColor(Color.BLACK);
				guy.drawString(instruct, 10, 15+(20*i));

				i++;
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Instruction()
	{
		JFrame frame = new JFrame("Instructions");
		//http://chortle.ccsu.edu/Java5/Notes/chap56/ch56_9.html "DISPOSE_ON_CLOSE"
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Instructions paintInstruct = new Instructions();
		frame.add(paintInstruct);
		frame.setSize(200,375);
		frame.setVisible(true);
	}
}
