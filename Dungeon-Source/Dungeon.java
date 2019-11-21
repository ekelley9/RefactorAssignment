/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero();
		    theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero chooseHero()
	{
		int choice;
		Hero theHero;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		choice = Keyboard.readInt();

		switch(choice)
		{
			case 1: return characterCreator(1);

			case 2: return characterCreator(2);

			case 3: return characterCreator(3);

			default: System.out.println("invalid choice, returning Thief");
				return characterCreator(0);
		}//end switch
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return new Ogre();

			case 2: return new Gremlin();

			case 3: return new Skeleton();

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Skeleton();
		}//end switch
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			battleChoices(theHero, theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method
	
	public static void battleChoices(Hero theHero, Monster theMonster)
	{
	    theHero.setNumTurns(theHero.getAttackSpeed()/theMonster.getAttackSpeed());

		if (theHero.getNumTurns() == 0)
			theHero.setNumTurns(theHero.getNumTurns()+ 1);

		System.out.println("Number of turns this round is: " + theHero.getNumTurns());
		int choice;


		do
		{
			attackMenu(theHero);
			
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: theHero.attack(theMonster);
			        break;
			    case 2: theHero.specialMove(theMonster);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }

			theHero.setNumTurns(theHero.getNumTurns()-1);
			if (theHero.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + theHero.getNumTurns());

		} while(theHero.getNumTurns() > 0);

	}
	
	public static void attackMenu(Hero theHero)
	{
		if(theHero instanceof Warrior)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		}
		else if(theHero instanceof Thief)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Perform a Sneak Attack");
		    System.out.print("Choose an option: ");
		}
		else if(theHero instanceof Sorceress)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Self Heal");
		    System.out.print("Choose an option: ");
		}
	}
	
	public static Hero characterCreator(int choice)
	  {
			if(choice == 1)
			{
				System.out.print("Enter character name: ");
				return new Warrior(Keyboard.readString());
			}
			else if(choice == 2)
			{
				System.out.print("Enter character name: ");
				return new Sorceress(Keyboard.readString());
			}
			else if(choice == 3)
			{
				System.out.print("Enter character name: ");
				return new Thief(Keyboard.readString());
			}
			else
			{
				return new Thief("Roland");
			}
		
			
	  }
}//end Dungeon class