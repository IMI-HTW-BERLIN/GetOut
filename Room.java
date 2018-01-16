import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private HashMap <String,Room> exits;
    private boolean isExit = false;
    private HashSet <Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new HashSet<>();
    }
    
    public Room(String description, boolean isExit) 
    {
        this(description);
        this.isExit = isExit;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction The direction of the exit.
     * @param neighbour The room in the given direction.
     */
    public void setExits(String direction, Room neighbour) 
    {
       exits.put(direction, neighbour);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() +
                ((items.size() != 0)? ("\n"+ getItems()): "");
        
    }

    public Room getExit (String direction)
    {
        return exits.get(direction);
    }
    
    public String getExitString ()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys)
        {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public boolean isExit(){
        return isExit;
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public String getItems()
    {
        String returnString = "Things in this room: ";
        for(Item item : items)
        {
            returnString += item.getName() + ", ";
        }
        returnString = returnString.replaceAll(", $", "");
        return returnString;
    }
    
    public Item getItem(String item){
        for(Item i : items){
            if(i.getName().equals(item)){
                return i;
            }
        }
        return null;
    }
}
