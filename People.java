
/**
 * Write a description of class People here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class People
{
    // instance variables - replace the example below with your own
    private String Name; 
    private String dialogue;
    private String dialogue2;
    /**
     * Constructor for objects of class People     */
    public People(String Person, String dialogue, String dialogue2)
    {
        this.dialogue = dialogue;
        this.dialogue2 = dialogue2;
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
    public String getDialogue()
    {
        return dialogue;   
    }
    public String getDialogue2()
    {
        return dialogue2;
    }
}
