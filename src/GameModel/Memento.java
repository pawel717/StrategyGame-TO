package GameModel;

public class Memento
{

	private Player player;
	private BuildingManager buildingManager;
	private CoinManager coinManager;
	private TimerManager timerManager;

	public Memento(GameModel context) 
	{
		this.player = context.getPlayer().copy();
		this.buildingManager = context.getBuildingManager().copy();		
		this.coinManager = context.getCoinManager().copy();
		this.timerManager = context.getTimerManager().copy();	
	}

	public Player getPlayer() {
		return player;
	}

	public BuildingManager getBuildingManager() {
		return buildingManager;
	}
	
	public CoinManager getCoinManager() {
		return coinManager;
	}

	public TimerManager getTimerManager() {
		return timerManager;
	}
	
}
