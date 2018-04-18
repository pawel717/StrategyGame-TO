package GameModel;

import java.util.ArrayList;
import java.util.List;

public class RestrictedBuildingValidator extends BuildingValidator
{
	private List<BuildingTypes> requiredBuildings;
	
	public RestrictedBuildingValidator(GameModel context)
	{
		super(context);
		requiredBuildings = new ArrayList <BuildingTypes>();
		requiredBuildings.add(BuildingTypes.Quarry);
		requiredBuildings.add(BuildingTypes.LumbermansCabin);
	}
	
	@Override
	protected boolean checkConditions()
	{
		if(context.getBuildingManager().getBuildings().containsAll(requiredBuildings))
			return true;
		return false;
	}
}
