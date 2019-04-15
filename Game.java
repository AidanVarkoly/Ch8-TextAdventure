import java.util.HashMap;
import java.util.Scanner;
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
    private static Room currentRoom;

    /**
      * Create the game and initialise its internal map.
      */
    public Game() 
    {
      createGame();
      parser = new Parser();
    }
      
    /**
      * Create all the rooms and link their exits together.
      */
    public void createGame()
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
      vent = new Room ("at one of the vents. This one seems brand new.\nThere is" +
        " a raccoon with a crystal ball in her hands");
        
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
      Item brassKnuck, brokenBot, revolver, crucifix;
        
      brassKnuck= new Item("brass knuckles", "a rusty pair of hamster-sized brass knuckles");
      brokenBot = new Item("broken bottle", "a broken beer bottle");
      revolver = new Item("revolver", "some kind of revolver");
      crucifix = new Item("crucifix", "a crucifix, and accidentally broke it apart- ..oh wait, it's a shiv.");
        
      //ADD ITEMS//
      hamBowl.addItem(brassKnuck);
      bed.addItem(brokenBot);
      toilet.addItem(revolver);
      dresser.addItem(crucifix);
        
      //--NPC LIST--//
      People dSnuts, coonani; 
      People roachard;
      People ratattoo;
       
      dSnuts = new People("dSnuts", "He shivers.\n" +
      "'I heard .. you was gonna be running a mafia. \nTell ya what- there's a freakin gun in the toilet.", 
      "'See, I told you. I have a feeling you didn't believe me.'");
      ventDuct.addPeople(dSnuts);
        
      roachard = new People("Roachard", "He stares at you with his beady eyes. \n 'Hey I'm Roachard, " +
        "but everyone calls me Dick. My full name is Roachard Roach. \nAnyway, d'ya happen to know there's some kinda " +
        "weird x-shaped thing in the dresser? You seem like you'd need it. Laters.'", 
        "'Oh you really picked that shit up? lol.");
      bed.addPeople(roachard);
       
      coonani = new People("Coonani", "The crystal ball glows. 'I see an item in store for you, my friend.'\n" + 
      "She squints at the ball. 'There seems to be a clear weapon underneath the bed. Use it for your victory.'",
      "'Cool.' She says, and ignores you.");
      vent.addPeople(coonani);
      
      ratattoo = new People("Ratattoo", "'Wassup bitch. I'm a tattoo artist, first name Ratattoo, last name Oui. It's French or " +
      "whatever. Anyway, just saw that you were starting a gang or sum shit. \nWell I think you should probably look the part." + 
      "if you haven't already, I would pick up a pair of brass knuckles or some shit.'", "'Lookin tuff dude.'");
      garden.addPeople(ratattoo);
              
      currentRoom = cage;  // start game in the cage
      }
      
    /**
=======
        People James; 
        People Mary;
        James = new People("James", "Dude standing in the corner");
        Mary = new People("Mary", "A nice Woman");
        
        cage.addPeople(James);
        ratCage.addPeople(Mary);
        currentRoom = cage;  // start game in the cage
       }
       /**
>>>>>>> 11088c0532a5d0e60b383381d857d9da6d8ff96b
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

      switch (commandWord) 
      {
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
                
         /**
         case PICKUP:
         pickUp(command);
         break;
         */
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

      if (nextRoom == null) 
      {
          System.out.println("There is no door!");
      }
       else 
      {
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
      if(command.hasSecondWord()) 
      {
         System.out.println("Quit what?");
         return false;
      }
      else
      {
         return true;  // signal that we want to quit
      }
    }
}
