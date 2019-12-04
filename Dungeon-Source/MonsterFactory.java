
public class MonsterFactory {
	private Monster theMonster;
	public Monster monsterFactory(String monster)
	{
		if(monster.equals("Ogre"))
		{
			theMonster = new Ogre();
		}
		if(monster.equals("Skeleton"))
		{
			theMonster = new Skeleton();
		}
		if(monster.equals("Gremlin"))
		{
			theMonster = new Gremlin();
		}
		return theMonster;
	}
}
