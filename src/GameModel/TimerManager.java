package GameModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import Exceptions.NegativeAmountOfCoins;
import Interfaces.ITimerManager;

public class TimerManager implements ITimerManager
{
	private List<Timer> listOfTimers;
	private GameModel context;

	public TimerManager(GameModel context)
	{
		this.context = context;
		this.listOfTimers = new ArrayList<Timer>();
	}
	
	@Override
	public void addTimer(int delay, BuildingTypes type)
	{
		Timer timer = new Timer(delay, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					context.getCoinManager().setCoins(context.getCoinManager().getCoins()+type.revenue);
				} catch (NegativeAmountOfCoins e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
		});
		timer.start();
		
		listOfTimers.add(timer);
	}
	
	@Override
	public void start()
	{
		for(Timer timer : listOfTimers)
			timer.start();
	}
	
	@Override
	public void stop()
	{
		for(Timer timer : listOfTimers)
			timer.stop();
	}

	public TimerManager copy() 
	{
		TimerManager timerManagerCopy = new TimerManager(this.context);
		for(Timer timer : listOfTimers)
			timerManagerCopy.listOfTimers.add(timer);
			
		return timerManagerCopy;
	}

	public void setContext(GameModel context) 
	{
		this.context = context;
	}

	public List<Timer> getTimers() {
		return this.listOfTimers;
	}

}
