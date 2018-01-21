package Interfaces;
import java.util.List;

import GameModel.BuildingTypes;
import GameModel.InsufficientAmountOfCoins;

public interface IBuildingManager
{
	public List<BuildingTypes> getBuildings();
	public void build(BuildingTypes type) throws InsufficientAmountOfCoins;
}
