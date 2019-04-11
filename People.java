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
    private HashMap<String, People> Person;     
    /**
     * Constructor for objects of class People     */
    public People(String description)
    {
        this.description3 = description3;
        Person = new HashMap<String, People>();
    }
    public void setPeople(String name, People Desc)
    {
        Person.put(name, Desc);
    }
    public People getPeople(String name)
    {
        return Person.get(name);   
    }
}