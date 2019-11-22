
public class SorceressHeal implements Abilities {

	@Override
	public void attack(DungeonCharacter character, DungeonCharacter opponent) {
		
		int hPoints;

		hPoints = (int)(Math.random() * (((Sorceress) character).getMAX_ADD() - ((Sorceress) character).getMIN_ADD() + 1)) 
				+ ((Sorceress) character).getMIN_ADD();
		character.addHitPoints(hPoints);
		System.out.println(character.getName() + " added [" + hPoints + "] hit points.\n"
							+ "Total hit points remaining are: "
							+ character.getHitPoints());
		 System.out.println();
		
	}

}
