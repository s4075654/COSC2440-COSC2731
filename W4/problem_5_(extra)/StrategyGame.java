import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;

interface ProgramToCalculateTheResultsOfDistanceAttackAndCloseCombatForAnIndividualHeroAsWellAsAGroupOfHeroes
{
   double calculateTheResultsOfDistanceAttackAndCloseCombat();
}

abstract class Hero implements ProgramToCalculateTheResultsOfDistanceAttackAndCloseCombatForAnIndividualHeroAsWellAsAGroupOfHeroes
{
   private String name;
   private int strength;
   
   final int getStrength()
     {
	return strength;
     }
   
   abstract double distanceAttack();
   abstract double closeCombat();
   
   final public double calculateTheResultsOfDistanceAttackAndCloseCombat()
     {
	return distanceAttack() + closeCombat();
     }
}

class Bowman extends Hero
{
   final double distanceAttack()
     {
	return getStrength() * 30 / 100;
     }
   final double closeCombat()
     {
	return getStrength() * 5 / 100;
     }
}

class Swordsman extends Hero
{
   final double distanceAttack()
     {
	return getStrength() * 4 / 100;
     }
   final double closeCombat()
     {
	return getStrength() * 35 / 100;
     }
}

final class GroupOfHeroes implements ProgramToCalculateTheResultsOfDistanceAttackAndCloseCombatForAnIndividualHeroAsWellAsAGroupOfHeroes
{
   final List<Hero> A_GROUP_OF_HEROES = new ArrayList<Hero>();
   final public double calculateTheResultsOfDistanceAttackAndCloseCombat()
     {
	return A_GROUP_OF_HEROES.parallelStream()
	  .reduce(0.0, (resultsOfDistanceAttackAndCloseCombat, hero) -> resultsOfDistanceAttackAndCloseCombat + hero.calculateTheResultsOfDistanceAttackAndCloseCombat(), Double::sum);
     }
}

enum Control
{
   A_HERO(Hero.class),
   A_GROUP_OF_HEROES(GroupOfHeroes.class);
   
   final private Class<? extends ProgramToCalculateTheResultsOfDistanceAttackAndCloseCombatForAnIndividualHeroAsWellAsAGroupOfHeroes> YOU;
   
   private Control(final Class<? extends ProgramToCalculateTheResultsOfDistanceAttackAndCloseCombatForAnIndividualHeroAsWellAsAGroupOfHeroes> HERO_OR_A_GROUP_OF_HEROES)
     {
	this.YOU = HERO_OR_A_GROUP_OF_HEROES;
     }
}
