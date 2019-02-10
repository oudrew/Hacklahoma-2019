public enum CardsEnum
{
    honeyBee("Honey Bee", "Bee", "Deal 5 damage and take 2 damage", 0),
    killerBee("Killer Bee", "Bee", "Deal 10 damage and take 7 damage", 1),
    queenBee("Queen Bee", "Bee", "Deal 1 damage and heal 6 damage", 2),
    beeKeeper("Bee Keeper", "Bee", "Heal 4 damage", 3),
    apiary("Apiary", "Bee", "Heal 8 damage", 4),
    bumbleBee("Bumble Bee", "Bee", "deal 4 damage and take 1 damage", 5),
    swarm("Swarm", "Bee", "Next attack does twice the damage to your opponenet AND yourself", 6),
    superBee("Super Bee", "Bee", "Deal 14 damage and take 12 damage", 7),
    carpenterBee("Carpenter Bee", "Bee", "Deal 7 damage and take 4 damage", 8),
    workerBee("Worker Bee", "Bee", "Deal 2 damage and heal 3 damage", 9),
    yellowJacket("YellowJacket", "Wasp", "Deal 3 damage, damage increases by 2 each time this is played", 10),
    hornet("Hornet", "Wasp", "deal 2 damage, damage doubles each use up to 10 total", 11),
    mudDauber("Mud Dauber", "Wasp", "Deal 1 damage, damage doubles each use", 12),
    stolenHoney("Stolen Honey", "Wasp", "Heal 7 damage", 13),
    tarantulaHawkWasp("Tarantula Hawk Wasp", "Wasp", "Deals 7 damage", 14),
    reusableStinger("Reusable Stinger", "Wasp", "Copies the last card played", 15),
    paperWasp("Paper Wasp", "Wasp", "Deals 1 damage, increases by 3 each time this is played", 16),
    cicadaKiller("Cicada Killer", "Wasp", "Deals 5 damage, increases by 1 each time this is played", 17),
    megaWasp("Mega Wasp", "Wasp", "Deals half the hive's remaining health", 18),
    poisonWasp("Poison Wasp", "Wasp", "Deals 3 damage, the opponent's next attack damages themselves", 19),
    thrownRock("Thrown Rock", "Neutral", "Deals 5 damage", 20),
    stupidKid("Stupid Kid", "Neutral", "Heals 4 health", 21),
    windStorm("Windstorm", "Neutral", "Deals 7 damage to both players", 22),
    flowers("Flowers", "Neutral", "Heals 4 health", 23),
    sickHive("Sick Hive", "Neutral", "Deals 7 damage to both teams", 24),
    bat("Bat", "Neutral", "Deals 5 damage", 25),
    allergy("Allergy", "Neutral", "Your next attack deals double damage", 26),
    bowAndArrow("Bow and Arrow", "Neutral", "Deals 4 damage, 30% chance to deal double damage", 27),
    hummingBirdFeeder("Hummingbird Feeder", "Neutral", "Heals both teams 10 health", 28),
    river("River", "Neutal", "Heals both teams 7", 29);
    
    private String name;
    private String affiliation;
    private int damage;
    private int selfDamage;
    private int healing;
    private int modifier;
    private String ability;
    private int ID;
    
    CardsEnum(String name, String affiliation, String ability, int id) {
        name = name;
        affiliation = affiliation;
        ability = ability;
        ID = id;
        damage = 0;
        healing = 0;
        modifier = 0;
    }
}