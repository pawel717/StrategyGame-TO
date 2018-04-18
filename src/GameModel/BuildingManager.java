package GameModel;
import java.util.ArrayList;
import java.util.List;

import Exceptions.ConditionsUnfullfiled;
import Exceptions.NegativeAmountOfCoins;
import Interfaces.IBuildingManager;

public class BuildingManager implements IBuildingManager
{
	private GameModel context;
	private List<BuildingTypes> listOfBuildings;
	
	public BuildingManager(GameModel context)
	{
		this.context = context;
		this.listOfBuildings = new ArrayList <BuildingTypes>();
	}
	
	@Override
	public void build(BuildingTypes type) throws ConditionsUnfullfiled, NegativeAmountOfCoins
	{
		
		BuildingValidator buildingValidator;
		
		switch(type)
		{
			case Mint:
				buildingValidator = new RestrictedBuildingValidator(context);
				break;
				
			case GoldMine:
				buildingValidator = new RestrictedBuildingValidator(context);
				break;
				
			case Sawmill:
				buildingValidator = new RestrictedBuildingValidator(context);
				break;
				
			default:
				buildingValidator = new BuildingValidator(context);
				break;
		}
		buildingValidator.validate(type);
		context.getCoinManager().setCoins(context.getCoinManager().getCoins()-type.cost);
		listOfBuildings.add(type);
		context.getTimerManager().addTimer(10000, type);
	}

	@Override
	public List<BuildingTypes> getBuildings() 
	{
		return this.listOfBuildings;
	}

	public BuildingManager copy() 
	{
		BuildingManager buildingManagerCopy = new BuildingManager(this.context);
		for(BuildingTypes building : listOfBuildings)
			buildingManagerCopy.listOfBuildings.add(building);
		
		return buildingManagerCopy;
	}

	public void setContext(GameModel context) 
	{
		this.context = context;
	}
	
}
