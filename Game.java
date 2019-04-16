import java.util.ArrayList;
/**
 The HamFather
 * This game is about you, a hamster, who tries to escape his domestic life 
 * to lead the rodent mafia of your dreams.
 * 
 * @author Isabella Dela Pena, Aidan Varkoly
 * @version 2019.04.04
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Items> Inventory;
    public static boolean InRoom = false;
     /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        Inventory = new ArrayList<Items>();
    }
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room cage, hamWheel, hamHouse, hamBowl, hamDoor;
      Room brokenVent, vent;
      Room humanRoom, bed, mirror, dresser;
      Room ventDuct, bathroom;
      Room toilet, medCab;
      Room sewer;
      Room garden, petStore, ratCage;
      
      // Inside the Hamster Cage //
      cage = new Room("in hamster prison");
      hamWheel = new Room("at the hamster wheel. Your personal gym");
      hamHouse = new Room("in your hammy home. Home sweet home");
      hamBowl = new Room("at your feeding grounds");
      hamDoor = new Room("looking outside the prison bars. The gate");
        
      //Escape routes//
      brokenVent = new Room("at the old shitty vent that smells " 
        + "like mothballs.");
      vent = new Room ("at one of the vents. This one seems brand new." +
        "\nThere is a raccoon with a crystal ball in her hands");
        
      //In the Human Room//
      humanRoom = new Room("in the warden's room");
      bed = new Room("at the warden's bed. It looks comfy, but smells like" +
        " socks and cheese puffs. \nThere is a roach braiding his antenna hairs");
      mirror = new Room("at the mirror. You look handsome");
      dresser = new Room("at the dresser. You often see the warden keep " +
        "clothes and valuables here");
        
      //Vent - Bathroom//
      ventDuct = new Room("in the vent duct. It's dusty as fuck.\nThere's a "
        + "rabid squirrel shaking by the vent wall.");
      bathroom = new Room("in the bathroom");
      toilet = new Room("on the toilet seat. It's gross.");
      sewer = new Room("in the sewer. I don't know why. You're a hamster, not "
        + "some dirty ass rat or mutant turtle");
      medCab = new Room("at the medicine cabinet. You smell hemorrhoid cream");
        
      //Outside//
      garden = new Room("outside where the warden grows flowers.\nThere is a small " +
        "dormouse standing by the flowers");
      petStore = new Room("in the pet store where you were kidnapped");
      ratCage = new Room("standing in front of RBG's lair.\nThere's a bunch of " +
        "tuff ass rodents standing by the cage door");
        
      // EXITS 1: CAGE//
      cage.setExit("north", hamDoor);
      cage.setExit("south", hamWheel);
      cage.setExit("east", hamHouse);
      cage.setExit("west", hamBowl);
        
      hamHouse.setExit("west", cage);

      hamBowl.setExit("east", cage);
        
      hamDoor.setExit("north", humanRoom);
      hamDoor.setExit("south", cage);
      hamDoor.setExit("east", brokenVent);
      hamDoor.setExit("west", vent);

      hamWheel.setExit("north", cage);
        
      //EXITS 2: BEDROOM//
      humanRoom.setExit("south", hamDoor);
      humanRoom.setExit("northeast", mirror);
      humanRoom.setExit("east", dresser);
      humanRoom.setExit("west", bed);
        
      bed.setExit("east", humanRoom);
        
      mirror.setExit("south", dresser);
      mirror.setExit("west", humanRoom);
        
      dresser.setExit("north", mirror);
      dresser.setExit("west", humanRoom);
        
      //EXITS 3: VENTS//
      brokenVent.setExit("west", hamDoor);
      brokenVent.setExit("south", ventDuct);
        
      vent.setExit("east", hamDoor);
        
      ventDuct.setExit("east", bathroom);
      ventDuct.setExit("south", garden);
      ventDuct.setExit("north", brokenVent);
        
      //EXITS 4: BATHROOM//
      bathroom.setExit("east", toilet);
      bathroom.setExit("south", medCab);
      bathroom.setExit("west", ventDuct);
        
      toilet.setExit("down", sewer);
      toilet.setExit("west", bathroom);
      
      sewer.setExit("up", toilet);
        
      medCab.setExit("north", bathroom);
       
        
      //EXITS 5: OUTSIDE//
      garden.setExit("north", ventDuct);
      garden.setExit("across", petStore);
        
      petStore.setExit("across", garden);
      petStore.setExit("north", ratCage);
        
      ratCage.setExit("south", petStore);
        
      //--ITEM LIST--//
      Items brassKnuck, brokenBot, revolver, crucifix;
        
      brassKnuck= new Items("brass knuckles", "a rusty pair of hamster-sized brass knuckles");
      brokenBot = new Items("broken bottle", "a broken beer bottle");
      revolver = new Items("revolver", "some kind of revolver");
      crucifix = new Items("crucifix", "a crucifix, oh wait, it's a shiv.");
        
      //ADD ITEMS//
      hamBowl.addItems(brassKnuck);
      bed.addItems(brokenBot);
      toilet.addItems(revolver);
      dresser.addItems(crucifix);
        
      //--NPC LIST--//
      People dSnuts, coonani; 
      People roachard;
      People ratattoo;
       
      dSnuts = new People("dSnuts", "He shivers.\n" +
      "'I heard .. you was gonna be running a mafia. \nTell ya what- there's a freakin gun in the toilet.", 
      "'You fucking imbecile I said its in the fucking toilet");
      ventDuct.addPeople(dSnuts);
        
      roachard = new People("Roachard", "He stares at you with his beady eyes. \n 'Hey I'm Roachard, " +
        "but everyone calls me Dick. My full name is Roachard Roach. \nAnyway, d'ya happen to know there's some kinda " +
        "weird x-shaped thing in the dresser? \nYou seem like you'd need it. Laters.'", 
        "'Hey, just check the dresser man it should be in there.");
      bed.addPeople(roachard);
       
      coonani = new People("Coonani", "The crystal ball glows. 'I see an item in store for you, my friend.'\n" + 
      "She squints at the ball. 'There seems to be a clear weapon underneath the bed. Use it for your victory.'",
      "'Check where the monsters usually are...");
      vent.addPeople(coonani);
      
      ratattoo = new People("Ratattoo", "'Wassup bitch. I'm a tattoo artist, first name Ratattoo, last name Oui. It's French or " +
      "\n" + "whatever. Anyway, just saw that you were starting a gang or sum shit." + "\nWell I think you should probably look the part." + 
      "if you haven't already, I would pick up a pair of brass knuckles or some shit.'", "'\nMHMMM pick up the brass knuckles'");
      garden.addPeople(ratattoo);
              
        
        currentRoom = cage;  // start game in the cage
        if (currentRoom == ratCage)
        {
            InRoom = true;
        }
    }
    public void addItem(Items item)
    {
       Inventory.add(item); 
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing!");
        System.out.println("Goodbye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("The HamFather");
        System.out.println("-------------");
        System.out.println("You are a hamster trying to escape your domestic life");
        System.out.println("to lead the rodent mafia ring of your dreams.");
        System.out.println("Good luck.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                 System.out.println("I don't know what you mean...");
                 break;

            case HELP:
                 printHelp();
                 break;

            case GO:
                 goRoom(command);
                 break;

            case QUIT:
                 wantToQuit = quit(command);
                 break;
            
            case PICKUP:
                 pickUpItem(command);
                 break;
            
            case INVENTORY:
                 printInventory();
                 break;
            
            case LOOK:
                 printItems(command);
                 break;
          
            case TALK:
                 TalkTo(command);
                 break;
            
            case FIGHT:
                 wantToQuit = end(command);
                 break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("SAY HELLO TO MY LITTLE FRIENDS");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    private void printInventory()
    {
     String output = "";
     for (int i = 0; i<Inventory.size(); i++)
     {    
       output += Inventory.get(i).getItem() + " ";
     }    
     System.out.println("You are carrying:");
     System.out.println(output);
    }
    private void printItems(Command command)
    {
        if(!command.hasSecondWord())
        {
        Room.searched = true;
        System.out.println(currentRoom.getLongDescription());
        Room.searched = false;
        }
    }
    private void TalkTo(Command command)
    {
        if(!command.hasSecondWord()) 
        {
        Room.spoke = true;
        Room.spoke2 = false;
        System.out.println(currentRoom.getLongDescription());
        Room.spoke = false;
        Room.spoke2 = true;
        }
    }
        private void pickUpItem(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Get what?");
            return;
        }

        String item = command.getSecondWord();
        
        // Try to leave current room.
        Items newItem = currentRoom.getItems(item);

        if (newItem == null) 
        {
            System.out.println("There is no item!");
        }
        else 
        {
            Inventory.add(newItem);
            currentRoom.removeItem(item);
            System.out.println("Picked up:" + item);
            System.out.println(currentRoom.getLongDescription());
        }
    }
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    private boolean end(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("You cannot fight that");
            return false;
        }
        else
        {
           if(InRoom = true && Inventory.size() >= 4)
           {
               System.out.println("It is time to fight the Mob Boss, \nYou enter the Rat Cage.. It is a cold and horrible place. "
               + "\nA bell rings and the fight begins, The Mob Boss is a big bastard. \nLuckily you brought a gun to a fist fight."
               + "\nYou pull out your revolver and blow his head off.");
               return true;
           }
           else if (InRoom = false && Inventory.size() >= 4)
           {
              System.out.println("The Mafia boss is not in here");
              return false;
           }
           else if (InRoom = true && Inventory.size() <= 4)
           {
              System.out.println("If you go in there now you will get slaughtered, go find the rest of the items");
              return false;
           }
           else if (InRoom = false && Inventory.size() <= 4)
           {
              System.out.println("Bro you trying to fight a mob boss whos not even in here and with barely any weapons." 
              + "WTF IS WRONG WITH YOU");
              return false;
           }
        }
        return false;
    }
  }
