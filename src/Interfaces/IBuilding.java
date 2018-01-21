package Interfaces;
import java.util.List;

import GameModel.BuildingTypes;
import GameModel.InsufficientAmountOfCoins;
import GameModel.Player;

public interface IBuilding
{
	public boolean checkConditions(Player playerContext);
}
