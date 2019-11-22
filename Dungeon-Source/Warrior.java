public class Warrior extends Hero
{

    public Warrior(String name)
	{

		super(name, 125, 4, .8, 35, 60, .2, new CrushingBlow());
 
    }

	
	  public void attack(DungeonCharacter opponent) 
	  { 
		  System.out.println(getName() + " swings a mighty sword at " + opponent.getName() + ":");
		  super.attack(opponent); 
	  }

}