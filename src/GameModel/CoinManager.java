package GameModel;
import java.util.ArrayList;
import java.util.List;

import Exceptions.NegativeAmountOfCoins;
import Interfaces.ICoinManager;
import Interfaces.IObservable;
import Interfaces.IObserver;

public class CoinManager implements ICoinManager, IObservable
{
	private GameModel context;
	private int coinState;
	private List<IObserver> observers;
	
	public CoinManager(GameModel context)
	{
		this.context = context;
		this.coinState = 2000;
		this.observers = new ArrayList <IObserver>();
	}

	@Override
	public int getCoins() 
	{
		return this.coinState;
	}

	@Override
	public void setCoins(int coinState) throws NegativeAmountOfCoins
	{
		if(coinState < 0)
			throw new NegativeAmountOfCoins();
		else
		{
			this.coinState = coinState;
			notifyObservers();
		}
	}

	@Override
	public void addObserver(IObserver observer) 
	{
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) 
	{
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() 
	{
		for(IObserver o : observers)
			o.update();
	}

	public CoinManager copy() 
	{
		 CoinManager coinManagerCopy = new CoinManager(this.context);
		 coinManagerCopy.coinState = this.coinState;
		 for(IObserver observer : this.observers)
			 coinManagerCopy.addObserver(observer);
		 
		 return coinManagerCopy;
	}

	public void setContext(GameModel context)
	{
		this.context = context;
	}

}
