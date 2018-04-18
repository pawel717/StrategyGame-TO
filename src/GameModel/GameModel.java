package GameModel;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameModel 
{
	private CoinManager coinManager;
	private TimerManager timerManager;
	private BuildingManager buildingManager;
	private Player player;
	
	public GameModel()
	{
		coinManager = new CoinManager(this);
		timerManager = new TimerManager(this);
		buildingManager = new BuildingManager(this);
		player = new Player();
	}

	public CoinManager getCoinManager()
	{
		return this.coinManager;
	}

	public void setCoinManager(CoinManager coinManager)
	{
		this.coinManager = coinManager;
	}

	public TimerManager getTimerManager()
	{
		return this.timerManager;
	}

	public void setTimerManager(TimerManager timerManager) 
	{
		this.timerManager = timerManager;
	}

	public BuildingManager getBuildingManager() {
		return this.buildingManager;
	}

	public void setBuildingManager(BuildingManager buildingManager)
	{
		this.buildingManager = buildingManager;
	}	

	public Player getPlayer()
	{
		return this.player;
	}

	public void setPlayer(Player player) 
	{
		this.player = player;
	}
	
	public Memento saveStateToMemento()
	{
		return new Memento(this);
	}
	
	public void setStateFromMemento(Memento memento)
	{
		for(Timer timer : this.timerManager.getTimers())
		{
			if(!memento.getTimerManager().getTimers().contains(timer))
			{
				timer.stop();
				for(ActionListener listener : timer.getActionListeners())
					timer.removeActionListener(listener);
				timer = null;
			}
		}
		this.player = memento.getPlayer();
		this.buildingManager = memento.getBuildingManager();
		this.coinManager = memento.getCoinManager();
		this.timerManager = memento.getTimerManager();
	}
}
