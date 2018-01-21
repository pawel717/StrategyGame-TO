package GameModel;

import java.util.List;

import Interfaces.IBuilding;

public abstract class Building implements IBuilding
{
	
	private BuildingTypes type;
	
	protected Building(BuildingTypes type)
	{
		this.type = type;
	}
	
	public int getRevenue() 
	{
		return this.type.revenue;
	}
	
	public int getCost() 
	{
		return this.type.cost;
	}

}
