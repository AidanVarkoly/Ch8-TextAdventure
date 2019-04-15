import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class People here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class People
{
    // instance variables - replace the example below with your own
    private String description3;
    public static String Name;
    public ArrayList<People> PeopleItems;
    /**
     * Constructor for objects of class People     */
    public People(String Person, String description3)
    {
        this.description3 = description3;
        this.Name = Person;
        PeopleItems = new ArrayList<People>();
    }
    public void setPeople(String Person)
    {
        Name = Person;
    }
    public static String getPeople()
    {
        return Name;   
    }
    public void addItems(People aItem)
    {
       PeopleItems.add(aItem);
    }
    public String getPeopleDesc()
    {
        return description3;   
    }
}