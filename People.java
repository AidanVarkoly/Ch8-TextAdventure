import java.util.HashMap;
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
    private static String Name;    
    /**
     * Constructor for objects of class People     */
    public People(String Person, String description3)
    {
        this.description3 = description3;
        this.Name = Person;
    }
    public void setPeople(String Person)
    {
        Name = Person;
    }
    public String getPeople()
    {
        return Name;   
    }
    public String getPeopleDesc()
    {
        return description3;   
    }
}