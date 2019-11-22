
public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}


}