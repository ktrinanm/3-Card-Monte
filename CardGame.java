/*
*@author: Katrina Mehring
*
*This class is what runs the card game
*/

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class CardGame extends JPanel implements ActionListener
{
	JButton [] cards;
	ImageIcon queenCard;
	ImageIcon kingCard;
	ImageIcon jackCard;
	ImageIcon cardback;
	JFrame cardGame;
	static boolean win;
	
	public CardGame()
	{		
		try {
			//initializing member components
			//set Layout and add components
			setLayout(new GridLayout(1,3));
			
			cards = new JButton[3];
			queenCard = new ImageIcon("queenCard.png");
			kingCard = new ImageIcon("kingCard.png");
			jackCard = new ImageIcon("jackCard.png");
			cardback = new ImageIcon("cardback.png");
			
			for(int i = 0; i < cards.length; i++)
			{
				cards[i] = new JButton();
				cards[i].setIcon(cardback);
				add(cards[i]);
				cards[i].addActionListener(this);
			}

			setMaximumSize(new Dimension(900,450));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int choice = (int)Math.ceil(Math.random()*3);
		if(choice == 1)
		{
			((JButton)e.getSource()).setIcon(queenCard);
			setWin(true);
			boolean thisWin = getWin();
			checkWin(thisWin);
		}
		if(choice == 2)
		{
			((JButton)e.getSource()).setIcon(kingCard);
			setWin(false);
			boolean thisWin = getWin();
			checkWin(thisWin);
		}
		if(choice == 3)
		{
			((JButton)e.getSource()).setIcon(jackCard);
			setWin(false);
			boolean thisWin = getWin();
			checkWin(thisWin);
		}
		
		
	}

	public void checkWin(boolean win)
	{
		if(win)
		{
			JOptionPane.showMessageDialog(null, "You found the Queen! Seems the pot goes to you.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Elusive lady that one! Seems I take the pot!");
		}
	}
	
	public void setWin(boolean thisWin)
	{
		win = thisWin;
	}
	
	public boolean getWin()
	{
		return win;
	}
}
