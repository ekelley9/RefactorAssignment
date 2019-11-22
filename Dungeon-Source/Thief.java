public class Thief extends Hero
{

    public Thief(String name)
	{
		super(name, 75, 6, .8, 20, 40, .5, new SurpriseAttack());



	}
    public void attack(DungeonCharacter opponent)
    {
    	System.out.println(this.getName() + "slahses at "+ opponent.getName() + " with his rusty dagger");
    	super.attack(opponent);
    }

}