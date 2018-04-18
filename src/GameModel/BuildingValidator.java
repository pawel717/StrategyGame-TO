package GameModel;

import Exceptions.ConditionsUnfullfiled;

public class BuildingValidator
{
	protected GameModel context;
	
	public BuildingValidator(GameModel context) 
	{
		this.context = context;
	}

	public boolean validate(BuildingTypes type) throws ConditionsUnfullfiled
	{
		if(checkConditions())
			return true;
		else
			throw new ConditionsUnfullfiled();
	}

	protected boolean checkConditions() 
	{
		return true;
	}
	
}
