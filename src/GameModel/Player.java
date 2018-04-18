package GameModel;

public class Player 
{
	private String name;
	
	public Player()
	{
		this.setName("New_Player");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player copy()
	{
		Player playerCopy = new Player();
		playerCopy.name = this.name;
		
		return playerCopy;
	}
}
