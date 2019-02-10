
public class CardList {
	public static void makeCards(String[] args) {
		makeBeeCards();
		makeWaspCards();
		makeNeutralCards();
	}
	
	public static void makeBeeCards() {
		Card honeyBee = new Card("Honey Bee", "Bee", "Deal 5 damage and take 2 damage", 0);
		honeyBee.setDamage(5);
		honeyBee.setSelfDamage(2);
		
		Card killerBee = new Card("Killer Bee", "Bee", "Deal 10 damage and take 7 damage", 1);
		killerBee.setDamage(10);
		killerBee.setSelfDamage(7);
		
		Card queenBee = new Card("Queen Bee", "Bee", "Deal 1 damage and heal 6 damage", 2);
		queenBee.setDamage(1);
		queenBee.setHealing(6);
		
		Card beeKeeper = new Card("Bee Keeper", "Bee", "Heal 4 damage", 3);
		beeKeeper.setHealing(4);
		
		Card apiary = new Card("Apiary", "Bee", "Heal 8 damage", 4);
		apiary.setHealing(8);
		
		Card bumbleBee = new Card("Bumble Bee", "Bee", "deal 4 damage and take 1 damage", 5);
		bumbleBee.setDamage(4);
		bumbleBee.setSelfDamage(1);
		
		Card swarm = new Card("Swarm", "Bee", "Next attack does twice the damage to your opponenet AND yourself", 6);
		/* SPECIAL ABILITY HERE!!!!!! */
		
		Card superBee = new Card("Super Bee", "Bee", "Deal 14 damage and take 12 damage", 7);
		superBee.setDamage(14);
		superBee.setSelfDamage(12);
		
		Card carpenterBee = new Card("Carpenter Bee", "Bee", "Deal 7 damage and take 4 damage", 8);
		carpenterBee.setDamage(7);
		carpenterBee.setSelfDamage(4);
		
		Card workerBee = new Card("Worker Bee", "Bee", "Deal 2 damage and heal 3 damage", 9);
		workerBee.setDamage(2);
		workerBee.setHealing(3);
	}
	
	public static void makeWaspCards() {
		Card yellowjacket = new Card("YellowJacket", "Wasp", "Deal 3 damage, damage increases by 2 each time this is played", 10);
		yellowjacket.setDamage(3);
		yellowjacket.setModifier(2);
		
		Card hornet = new Card("Hornet", "Wasp", "deal 2 damage, damage doubles each use up to 10 total", 11);
		hornet.setDamage(2);
		hornet.setModifier(2);
		
		Card mudDauber = new Card("Mud Dauber", "Wasp", "Deal 1 damage, damage doubles each use", 12);
		mudDauber.setDamage(1);
		mudDauber.setModifier(2);
		
		Card stolenHoney = new Card("Stolen Honey", "Wasp", "Heal 7 damage", 13);
		stolenHoney.setHealing(7);
		
		Card tarantulaHawkWasp = new Card("Tarantula Hawk Wasp", "Wasp", "Deals 7 damage", 14);
		tarantulaHawkWasp.setDamage(7);
		
		Card reusableStinger = new Card("Reusable Stinger", "Wasp", "Copies the last card played", 15);
		/* SPECIAL ABILITY HERE!!!!!! */
		
		Card paperWasp = new Card("Paper Wasp", "Wasp", "Deals 1 damage, increases by 3 each time this is played", 16);
		paperWasp.setDamage(1);
		paperWasp.setModifier(3);
		
		Card cicadaKiller = new Card("Cicada Killer", "Wasp", "Deals 5 damage, increases by 1 each time this is played", 17);
		cicadaKiller.setDamage(5);
		cicadaKiller.setModifier(1);
		
		Card megaWasp = new Card("Mega Wasp", "Wasp", "Deals half the hive's remaining health", 18);
		/* SPECIAL ABILITY HERE!!!!!! */
		
		Card poisonWasp = new Card ("Poison Wasp", "Wasp", "Deals 3 damage, the opponent's next attack damages themselves", 19);
		poisonWasp.setDamage(3);
		/* SPECIAL ABILITY HERE!!!!!! */
	}
	
	public static void makeNeutralCards() {
		Card thrownRock = new Card("Thrown Rock", "Neutral", "Deals 5 damage", 20);
		thrownRock.setDamage(5);
		
		Card stupidKid = new Card("Stupid Kid", "Neutral", "Heals 4 health", 21);
		stupidKid.setHealing(4);
		
		Card windStorm = new Card("Windstorm", "Neutral", "Deals 7 damage to both players", 22);
		windStorm.setDamage(7);
		
		Card flowers = new Card("Flowers", "Neutral", "Heals 4 health", 23);
		flowers.setHealing(4);
		
		Card sickHive = new Card("Sick Hive", "Neutral", "Deals 7 damage to both teams", 24);
		sickHive.setDamage(7);
		
		Card bat = new Card("Bat", "Neutral", "Deals 5 damage", 25);
		bat.setDamage(5);
		
		Card Allergy = new Card("Allergy", "Neutral", "Your next attack deals double damage", 26);
		/* SPECIAL ABILITY HERE!!!!!! */
		
		Card bowAndArrow = new Card("Bow and Arrow", "Neutral", "Deals 4 damage, 30% chance to deal double damage", 27);
		bowAndArrow.setDamage(4);
		/* SPECIAL ABILITY HERE!!!!!! */
		
		Card hummingbirdFeeder = new Card("Hummingbird Feeder", "Neutral", "Heals both teams 10 health", 28);
		hummingbirdFeeder.setHealing(10);
		
		Card river = new Card ("River", "Neutal", "Heals both teams 7", 29);
		river.setHealing(7);
	}
}
