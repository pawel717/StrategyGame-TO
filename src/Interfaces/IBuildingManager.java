package Interfaces;
import java.util.List;

import Exceptions.ConditionsUnfullfiled;
import Exceptions.NegativeAmountOfCoins;
import GameModel.BuildingTypes;

public interface IBuildingManager
{
	public List<BuildingTypes> getBuildings();
	public void build(BuildingTypes type) throws NegativeAmountOfCoins, ConditionsUnfullfiled;
}
