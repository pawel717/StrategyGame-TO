package Interfaces;

import GameModel.BuildingTypes;

public interface ITimerManager
{
	public void addTimer(int delay, BuildingTypes type);
	public void start();
	public void stop();
}
