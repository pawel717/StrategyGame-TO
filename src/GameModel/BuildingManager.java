package GameModel;
import java.util.ArrayList;
import java.util.List;

import Interfaces.IBuilding;
import Interfaces.IBuildingManager;

public class BuildingManager implements IBuildingManager
{
	private Player player;
	private List<BuildingTypes> listOfBuildings;
	
	public BuildingManager(Player player)
	{
		this.player = player;
		this.listOfBuildings = new ArrayList <BuildingTypes>();
	}
	
	@Override
	public void build(BuildingTypes type) throws InsufficientAmountOfCoins
	{
		coinsSufficiency(type);
		
		IBuilding building;
		switch(type)
		{
			case Mint:
				building = new RestrictedBuilding(type);
				break;
				
			case GoldMine:
				building = new RestrictedBuilding(type);
				break;
				
			case Sawmill:
				building = new RestrictedBuilding(type);
				break;
				
			default:
				building = new NormalBuilding(type);
				break;
		}
		
		if(building.checkConditions(player))
			listOfBuildings.add(type);
	}

	private void coinsSufficiency(BuildingTypes type) throws InsufficientAmountOfCoins
	{
		if(player.getCoinsState().getCoins() < type.cost)
			throw new InsufficientAmountOfCoins("Cost:"+type.cost+" state:"+player.getCoinsState().getCoins());
	}
	
	@Override
	public List<BuildingTypes> getBuildings() 
	{
		return this.listOfBuildings;
	}

}
