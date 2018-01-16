
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String description;
    private int weight;
    private String name;
    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        this.description = description;
        this.weight = weight;
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * @return The description of the item.
     */
    public String getDescription()
    {
        return description;
    }
    
    public int getWeight(){
        return weight;
    }
}
