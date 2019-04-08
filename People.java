import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
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
    private ArrayList<People> list2 = null;

    /**
     * Constructor for objects of class People     */
    public People(String Description)
    {
        description3 = description3;
        this.list2 = new ArrayList<People>();
    }

    public void addPeople(People people)
    {
        list2.add(people);
    }
    public String getShortDescription()
    {
     return description3;   
    }
}
