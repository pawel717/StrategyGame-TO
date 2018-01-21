package GameModel;
import Interfaces.IBuilding;
import Interfaces.IBuildingManager;
import Interfaces.ICoin;

public class Player 
{
	private String name;
	private ICoin coinsState;
	private IBuildingManager buildingsState;
	
	public Player(String name)
	{
		this.name = name;
		this.coinsState = new CoinManager(this);
		this.buildingsState = new BuildingManager(this);
	}
	
	public IBuildingManager getBuildingState()
	{
		return this.buildingsState;
	}
	
	public ICoin getCoinsState()
	{
		return this.coinsState;
	}
}
