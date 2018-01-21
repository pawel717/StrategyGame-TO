package GameModel;

public enum BuildingTypes
{
	Mint(3000, 10000),
	GoldMine(100, 5000),
	Sawmill(500, 3000),
	LumbermansCabin(300, 1500),
	Quarry(200, 500);
	
	public final int revenue;
	public final int cost;
	
	BuildingTypes(int revenue, int cost)
	{
		this.revenue = revenue;
		this.cost = cost;
	}
}
