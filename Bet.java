/*
*@author:Katrina Mehring
*
*This class controls the betting panel
*/

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

//class based off InfoPanel.java from GoogleMapApp
//help from Brian

@SuppressWarnings("serial")
public class Bet extends JPanel
{
	JLabel yourMoney = new JLabel();
	JLabel inThePot = new JLabel();
	JLabel myMoney = new JLabel();
	private static double playerAmount, betAmount, potAmount, dealerAmount;
	
	public Bet()
	{
		setLayout(new GridLayout(1,3));
		setSize(900,100);
		playerAmount = getPlayerMoney();
		betAmount = getBetAmount();
		potAmount = getPot();
		dealerAmount = getDealerMoney();
		
		yourMoney = new JLabel("Your Money: $" + playerAmount);
		inThePot = new JLabel("In the Pot: $" + potAmount);
		myMoney = new JLabel("Dealer's money: $" + dealerAmount);
		
		add(yourMoney);
		add(inThePot);
		add(myMoney);
	}
	
	public Bet(double thisBet, double thisPotAmount, double player, double dealer, CardGame cg, boolean firstGame)
	{
		setLayout(new GridLayout(1,3));
		setSize(900,50);
		setBetAmount(thisBet);
		thisBet = getBetAmount();

		if(firstGame)
		{
			setPlayerMoney(player);
			setDealerMoney(dealer);
			setNewPot(thisBet);
		}

		boolean thisWin = cg.getWin();
		if(!firstGame)
		{
			setPlayerMoney(thisPotAmount, thisBet, thisWin);
			setDealerMoney(thisPotAmount, thisBet, thisWin);
			setNewPot(thisBet);
		}
		
		playerAmount = getPlayerMoney();
		potAmount = getPot();
		dealerAmount = getDealerMoney();
		yourMoney = new JLabel("Your Money: $" + playerAmount);
		inThePot = new JLabel("In the Pot: $" + potAmount);
		myMoney = new JLabel("Dealer's money: $" + dealerAmount);
		
		add(yourMoney);
		add(inThePot);
		add(myMoney);
	}
	
	public void setPlayerMoney(double potAmount, double thisBet, boolean win)
	{
		if(win)
		{
		}
		else
		{
			playerAmount-=potAmount;
		}
	}
	
	public void setPlayerMoney(double playerMoney)
	{
		playerAmount = playerMoney-.25;
	}
	
	public double getPlayerMoney()
	{

		return playerAmount;
	}
	
	public void setDealerMoney(double potAmount, double thisBet, boolean win)
	{
		if(win)
		{
			dealerAmount-=potAmount;
		}
		else if(!win)
		{
		}
	}
	
	public void setDealerMoney(double dealerMoney)
	{
		dealerAmount = dealerMoney-.25;
	}
	
	public double getDealerMoney()
	{

		return dealerAmount;
	}
	
	public void setNewPot(double bet)
	{
		potAmount = bet*2;
	}
	
	public double getPot()
	{
		return potAmount;
	}
	
	public void setBetAmount(double oldBet)
	{
		if(oldBet == 0)
		{
			betAmount = oldBet + .25;
		}
		else
		{
			betAmount = oldBet*2;
		}
	}
	
	public double getBetAmount()
	{
		return betAmount;
	}
}

