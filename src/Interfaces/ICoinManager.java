package Interfaces;

import Exceptions.NegativeAmountOfCoins;

public interface ICoinManager 
{
	public int getCoins();
	public void setCoins(int coinState) throws NegativeAmountOfCoins;
}
