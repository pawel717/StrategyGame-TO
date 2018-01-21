package GameModel;
import Interfaces.ICoin;

public class CoinManager implements ICoin
{
	private Player player;
	private int coinState;
	
	public CoinManager(Player player)
	{
		this.player = player;
		this.coinState = 2000;
	}

	@Override
	public int getCoins() 
	{
		return this.coinState;
	}

	@Override
	public void setCoins(int coinState)
	{
		this.coinState = coinState;
	}
	
	public void revenueUpdate()
	{
		for(BuildingTypes building : player.getBuildingState().getBuildings())
		{
			this.coinState += building.revenue;
		}
	}

}
