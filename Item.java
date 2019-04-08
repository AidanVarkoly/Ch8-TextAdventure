import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String description2;
    private ArrayList<Item> items = null;
    
    public Item(String description)
    {
        this.description2 = description2;
        this.items = new ArrayList<Item>();
    }
    
    
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    
    
}    
   
