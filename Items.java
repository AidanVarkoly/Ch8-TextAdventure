/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Items
{
    // instance variables - replace the example below with your own
    private String description2;
    private String Item;
    /**
     * Constructor for objects of class Item
     */
    public Items (String Name, String description)
    {
        this.description2 = description;
        this.Item = Name;
    }
    public String getItem()
    {
        return Item;
    }
    public void setItem(String Name)
    {
        Item = Name;
    }
    public String getDescription()
    {
       return description2; 
    }
}
