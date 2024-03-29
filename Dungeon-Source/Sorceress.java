public class Sorceress extends Hero
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress(String name)
	{
		super(name, 75, 5, .7, 25, 50, .3, new SorceressHeal());


    }
    

public int getMIN_ADD() {
		return MIN_ADD;
	}

	public int getMAX_ADD() {
		return MAX_ADD;
	}

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}
 

}