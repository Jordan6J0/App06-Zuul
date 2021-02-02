import java.util.ArrayList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Derek and Andrei
 */

public class Game
{
    private final Parser parser;
    private Room currentRoom;
    private final Map map;
    private Player player;
    ArrayList<Items> inventory = new ArrayList<Items>();
    private Room reception;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        player = new Player("Melvin");
        parser = new Parser();
        map = new Map();
        currentRoom = map.getStartRoom();
        play();
    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (!finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }


    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord)
        {
            case HELP:
                printHelp();
                break;

            case LOOK:
                printItems();
                break;

            case TAKE:
                player.takeItem();
                break;

            case TRADE:
                //          tradeItem ();
                break;

            case USE:
                //            useItem ();
                break;
            case INVENTORY:
                player.printInventory();
                break;

            case GO:
                goRoom (command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            default:

            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;
        }
        return wantToQuit;
    }

    // private void useItem()
    {
        //   currentRoom.useItem;
    }

    //  private void tradeItem()
    {
        // currentRoom.tradeItem;
    }

    private void takeItem(Command command)
    {
        if (!command.hasSecondWord())
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }
        String item = command.getSecondWord();

        // Try to leave current room.
        Items newItem = (Items) currentRoom.getItem();

        if (newItem == null)
        {
            System.out.println("There is no collectables here!");
        } else
        {
           inventory.add(newItem);
           System.out.println("Collectable picked up" + item);
        }
        //   else {
        //  System.out.println("Door is locked use item to open" + command command ());
        //  currentRoom.printItems();
    }

    private void printItems()
    {
        currentRoom.printItems();
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You have lost Your ID. You must wander");
        System.out.println("around High Wycombe to find it so that you can go back to uni.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    // private void takeItem()
    //   System.out.println("you have picked up" + currentRoom.getContainedItem() + "\n" )

    //   player.takeItem(currentRoom.getContainedItem());
    //  currentRoom.removeContainedItem();

    /**
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private boolean goRoom(Command command)
    {
        if (!command.hasSecondWord())
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null)
        {
            System.out.println("There is no door!");
        } else
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            currentRoom.printItems();
            if (currentRoom == reception)
            {
                System.out.println("You win!");
                return true;
            }
        }
        return false;
        //   else {
        //  System.out.println("Door is locked use item to open" + command command ());
        //  currentRoom.printItems();
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if (command.hasSecondWord())
        {
            System.out.println("Quit what?");
            return false;
        } else
        {
            return true;  // signal that we want to quit
        }
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }




}