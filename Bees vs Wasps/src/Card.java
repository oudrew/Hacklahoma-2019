
public class Card 
{
    private String name;
    private String affiliation;
    private String ability;
    private int ID;
    
    public Card(String name, String affiliation, String ability, int id)
    {
        this.name = name;
        this.affiliation = affiliation;
        this.ability = ability;
        this.ID = id;
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
