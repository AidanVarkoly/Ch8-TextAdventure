import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "The HamFather" application. 
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Isabella Dela Pena and Aidan Varkoly
 * @version 2019.04.08
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> Items;
    private ArrayList<People> Person;
    public static boolean searched = false;
    public static boolean spoke = false;
    // stores exits of this room.
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        Items = new ArrayList<Item>();
        Person = new ArrayList<People>();
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    public void addItem(Item aItem)
    {
        Items.add(aItem);
    }
    
    public void addPeople(People aPerson)
    {
        Person.add(aPerson);   
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String temp = "";
        temp += "You are " + description + ".\n" + getExitString() + "\n";
      
     if (searched)
      { if (Items.size() > 0)
       {
         for (int i=0; i<Items.size(); i++) {
           temp += "There is a(n) " + Items.get(i).getItemDescription() + " here\n"; 
         }
       }
       else 
       {
         temp += "There is nothing else here.\n";    
       }
     }
     
     if (spoke)
      {
        if (Person.size() > 0)
        {
          for (int p=0; p<Person.size(); p++) {

              temp += Person.get(p).getDialogue() + "\n" + Person.get(p).getDialogue2() ; 

          }
        }
        else 
        {
         temp += "There is noone in here.\n";   
        }
     }
        return temp;
    }    
    
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}


