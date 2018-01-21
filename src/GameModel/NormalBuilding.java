package GameModel;

public class NormalBuilding extends Building
{

	public NormalBuilding(BuildingTypes type) 
	{
		super(type);
		
	}

	@Override
	public boolean checkConditions(Player playerContext) {
	
		return true;
	}

}
