
public class SurpriseAttack implements Abilities{

	@Override
	public void attack(DungeonCharacter character, DungeonCharacter opponent) 
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								character.getName() + " gets an additional turn.");
			((Hero) character).setNumTurns(((Hero) character).getNumTurns() + 1);
			character.attack(opponent);
		}
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    character.attack(opponent);


	}

}
