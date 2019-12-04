
public class HeroFactory {
	private Hero theHero;
	public Hero heroFactory(String hero, String name)
	{
		if(hero.equals("Warrior"))
		{
			theHero = new Warrior(name);
		}
		if(hero.equals("Sorceress"))
		{
			theHero = new Sorceress(name);
		}
		if(hero.equals("Thief"))
		{
			theHero = new Thief(name);
		}
		return theHero;
	}
}
