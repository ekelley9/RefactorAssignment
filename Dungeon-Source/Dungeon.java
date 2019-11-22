import java.util.Scanner;

public class Dungeon
{
	private static Scanner kb = new Scanner(System.in);
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

    }
	public static Hero chooseHero()
	{
		int choice = 0;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		
			choice = kb.nextInt();
	
		

		switch(choice)
		{
			case 1: return characterCreator(1);

			case 2: return characterCreator(2);

			case 3: return characterCreator(3);

			default: System.out.println("invalid choice, returning Thief");
				return characterCreator(0);
		}
	}
	
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;
		kb.nextLine();

		switch(choice)
		{
			case 1: return new Ogre();

			case 2: return new Gremlin();

			case 3: return new Skeleton();

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Skeleton();
		}
	}


	public static boolean playAgain()
	{
		String again = "";


		System.out.println("Play again (y/n)?");
		again = kb.next();

		return (again.equals("Y") || again.equals("y"));

	}
	
	public static void battle(Hero theHero, Monster theMonster)
	{
		String pause = "p";
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		
		while (theHero.isAlive() && theMonster.isAlive() && !pause.equals("q"))
		{
		    
			battleChoices(theHero, theMonster);

			
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = kb.next();

		}

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}
	
	public static void battleChoices(Hero theHero, Monster theMonster)
	{
	    theHero.setNumTurns(theHero.getAttackSpeed()/theMonster.getAttackSpeed());

		if (theHero.getNumTurns() == 0)
			theHero.setNumTurns(theHero.getNumTurns()+ 1);

		System.out.println("Number of turns this round is: " + theHero.getNumTurns());
		int choice = 0;


		do
		{
			attackMenu(theHero);
			boolean isNumber = true;
			
			do{
				try
			    {
			    	choice = kb.nextInt();
			    	isNumber = true;
			    }catch(Exception e)
			    {
			    	System.out.println(e+ "Please enter a valid number");
			    	isNumber = false;
			    }

			}while(!isNumber);
		    
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
		System.out.print("Enter character name: ");
	 	String name = kb.next();
			if(choice == 1)
			{
				return new Warrior(name);
				
			}
			else if(choice == 2)
			{
				return new Sorceress(name);
			}
			else if(choice == 3)
			{
				return new Thief(name);
			}
			else
			{
				return new Thief("Roland");
			}
			
		
			
	  }
	
	
}