/*
*@Katrina Mehring
*
*This class does the behind scene work
*/

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//class based on GoogleMapApp
@SuppressWarnings("serial")
public class AppPanel extends JFrame
{
	CardGame cg;
	Bet bet, oldBet;
	AppPanel app;
	
	public AppPanel()
	{
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		cg = new CardGame();
		bet = new Bet(0, 0, 10.00, 10.00, cg, true);
		add(cg);
		add(bet);
	}
	
	public AppPanel(boolean don)
	{
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		oldBet = new Bet();
		double thisBet = oldBet.getBetAmount();
		double potAmount = oldBet.getPot();
		double player = oldBet.getPlayerMoney();
		double dealer = oldBet.getDealerMoney();
		
		if(player-(thisBet*2)<0)
		{
			JOptionPane.showMessageDialog(null, "Seems you don't have enough to make the next bet. Don't worry, I'll be going on my way!");
			System.exit(0);
		}
		else if(dealer-(thisBet*2)<0)
		{
			JOptionPane.showMessageDialog(null, "Seems that you got the best of me. I guess I'll be leaving you!");
			System.exit(0);
		}
		else
		{
			cg = new CardGame();
			bet = new Bet(thisBet, potAmount, player, dealer, cg, false);

			add(cg);
			add(bet);
		}
	}
	
	public void anApp()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(900,515);
		this.setLocation(215, 0);//help from Brian
		this.setVisible(true);
	}
}
