package GameModel;

import java.util.List;

public class RestrictedBuilding extends Building
{
	private List<BuildingTypes> requiredBuildings;
	
	public RestrictedBuilding(BuildingTypes type)
	{
		
		super(type);
	}

	@Override
	public boolean checkConditions(Player playerContext)
	{
		if(playerContext.getBuildingState().getBuildings().containsAll(requiredBuildings))
			return true;
		return false;
	}

}
