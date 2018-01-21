package GameModel;

public class Game 
{
	public static void main(String[] args)
	{
		Player player = new Player("aa");
		System.out.println(player.getBuildingState().getBuildings());
		System.out.println(player.getCoinsState().getCoins());
		try {
			player.getBuildingState().build(BuildingTypes.Quarry);
		} catch (InsufficientAmountOfCoins e) {
			System.out.println("Za ma³o coinów");
		}
		
		System.out.println(player.getBuildingState().getBuildings());
		System.out.println(player.getCoinsState().getCoins());
		
		while(true)
		{
			
			
		}
		
		
	}
	
}
