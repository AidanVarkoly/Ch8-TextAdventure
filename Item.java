/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private static String description2;
    private String name;
    public Item(String item, String description)
    {
        this.name = item;
        this.description2 = description;
    }
    public void setItem(String item)
    {
        name = item;
    }
    public String getItem()
    {
        return name;
    }
    public static String getItemDescription()
    {
       return description2; 
    }
}    
   
