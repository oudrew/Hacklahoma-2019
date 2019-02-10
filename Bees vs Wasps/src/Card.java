
public class Card 
{
    private String name;
    private String affiliation;
    private int damage;
    private int selfDamage;
    private int healing;
    private int modifier;
    private String ability;
    private int ID;
    
    public Card(String name, String affiliation, String ability, int id)
    {
        this.name = name;
        this.affiliation = affiliation;
        this.ability = ability;
        this.ID = id;
        damage = 0;
        healing = 0;
        modifier = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the affiliation
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * @param affiliation the affiliation to set
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    
    public int getDamage() {
    	return damage;
    }
    
    public void setDamage(int damage) {
    	this.damage = damage;
    }
    
    public int getSelfDamage() {
    	return selfDamage;
    }
    
    public void setSelfDamage(int selfDamage) {
    	this.selfDamage = selfDamage;
    }
    
    public void setHealing(int healing) {
    	this.healing = healing;
    }
    
    public int getHealing() {
    	return healing;
    }
    
    public int getModifier() {
    	return modifier;
    }
    
    public void setModifier(int modifier) {
    	this.modifier = modifier;
    }

    /**
     * @return the ability
     */
    public String getAbility() {
        return ability;
    }

    /**
     * @param ability the ability to set
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }
    
    public int getID()
    {
        return this.ID;
    }
    
    public void setID(int id)
    {
        this.ID = id;
    }
    
}
