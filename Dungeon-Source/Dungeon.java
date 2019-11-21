import java.util.Scanner;

public class Dungeon {
	public static void main(String[] args) {

		Hero theHero;
		Monster theMonster;

		do {
			theHero = chooseHero();
			theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

	}// end main method

	public static Hero chooseHero() {
		Scanner kb = new Scanner(System.in);
		int choice = 0;
		Hero theHero;

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		choice = kb.nextInt();

		switch (choice) {
		case 1:
			return characterCreator(1);

		case 2:
			return characterCreator(2);

		case 3:
			return characterCreator(3);

		default:
			System.out.println("invalid choice, returning Thief");
			return characterCreator(0);
		}// end switch
	}// end chooseHero method

	/*-------------------------------------------------------------------
	generateMonster randomly selects a Monster and returns it.  It utilizes
	a polymorphic reference (Monster) to accomplish this task.
	---------------------------------------------------------------------*/
	public static Monster generateMonster() {
		int choice;

		choice = (int) (Math.random() * 3) + 1;

		switch (choice) {
		case 1:
			return new Ogre();

		case 2:
			return new Gremlin();

		case 3:
			return new Skeleton();

		default:
			System.out.println("invalid choice, returning Skeleton");
			return new Skeleton();
		}// end switch
	}// end generateMonster method

	/*-------------------------------------------------------------------
	playAgain allows gets choice from user to play another game.  It returns
	true if the user chooses to continue, false otherwise.
	---------------------------------------------------------------------*/
	public static boolean playAgain() {
		Scanner kb = new Scanner(System.in);
		String again;

		System.out.println("Play again (y/n)?");
		again = kb.next();

		return (again.equals('Y') || again.equals('y'));

	}// end playAgain method

	/*-------------------------------------------------------------------
	battle is the actual combat portion of the game.  It requires a Hero
	and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	goes first, then the Monster.  At the conclusion of each round, the
	user has the option of quitting.
	---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster) {
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------");

		// do battle
		while (theHero.isAlive() && theMonster.isAlive()) {
			// hero goes first
			theHero.battleChoices(theMonster);

			// monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			// let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");

		} // end battle loop

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else// both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}// end battle method

	public static Hero characterCreator(int choice) {
		Scanner kb = new Scanner(System.in);
		if (choice == 1) {
			System.out.print("Enter character name: ");
			return new Warrior();
		} else if (choice == 2) {
			System.out.print("Enter character name: ");
			return new Sorceress();
		} else if (choice == 3) {
			System.out.print("Enter character name: ");
			return new Thief();
		} else {
			return new Thief();
		}

	}
}// end Dungeon class