public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private Abilities specialMove;


  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock, Abilities specialMove)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, new BasicAttack());
	this.chanceToBlock = chanceToBlock;
	this.specialMove = specialMove;
  }
  
  public double getChanceToBlock()
  {
	  return this.chanceToBlock;
  }
  
  public int getNumTurns()
  {
	  return this.numTurns;
  }
  
  public void setNumTurns(int turns)
  {
	  this.numTurns = turns;
  }
  
public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }

  public void specialMove(DungeonCharacter opponent)
  {
	  specialMove.attack(this,opponent);
  }

public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}
	

}