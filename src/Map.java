public class Map
{
    private Room outside_uni;
    private Room reception;
    private Room eden_shop_centre;
    private Room inside_shop_centre;
    private Room jd;
    private Room ann_summers;
    private Room krispy_kreme;
    private Room car_park;
    private Room lilys_walk;
    private Room high_street;
    private Room mcdonalds;
    private Room inside_mcdonalds;

    private Room StartRoom;

    /**
     *
     */
    public Map()
    {
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        createCar_parkRoom();
        createInside_shop_centreRoom();
        createJDRoom();
        createAnn_summersRoom();
        createKrispy_kreamRoom();
        createEden_shop_centreRoom();
        createOutside_uniRoom();
        createReceptionRoom();
        createlilys_walkRoom();
        createHighstreetRoom();
        createMcdonaldsRoom();
        createInside_mcdonaldsRoom();

        StartRoom = outside_uni;  // start game outside
    }


    private void createOutside_uniRoom()
    {
        // create the rooms
        outside_uni = new Room("outside the main entrance of the university");
        // initialise room exits
        outside_uni.setExit("north ",reception);
        outside_uni.setExit("east", lilys_walk);
        outside_uni.setExit("south", high_street);
    }

    private void createReceptionRoom()
    {
        reception = new Room("in the reception");
        reception.setExit("south",outside_uni);
        // exit
        outside_uni.setExit("north",reception);
    }

    private void createlilys_walkRoom()
    {
        // create the rooms
        lilys_walk = new Room("on Lilly's walk road");
        // initialise room exits
        lilys_walk.setExit("south", eden_shop_centre);
        lilys_walk.setExit("west", outside_uni);
        // exit
        outside_uni.setExit("east",lilys_walk);
        eden_shop_centre.setExit("north",lilys_walk);
    }

    private void createHighstreetRoom()
    {
        // create the rooms
        high_street = new Room("in the High street", new Items ("Money"));
        // initialise room exits
        high_street.setExit("north", outside_uni);
        high_street.setExit("east", eden_shop_centre);
        high_street.setExit("south", mcdonalds);
        // exit
        outside_uni.setExit("south",high_street);
        eden_shop_centre.setExit("west",high_street);

    }

    private void createEden_shop_centreRoom()
    {
        eden_shop_centre = new Room("outside the Eden shopping centre");
        eden_shop_centre.setExit("north",lilys_walk);
        eden_shop_centre.setExit("east",car_park);
        eden_shop_centre.setExit("south",inside_shop_centre);
        // exit
        car_park.setExit("west",eden_shop_centre);
        inside_shop_centre.setExit("north",eden_shop_centre);
    }

    private void createCar_parkRoom()
    {
        car_park = new Room("Inside Eden car park", new Items ("CREDITCARD"));
        car_park.setExit("west",eden_shop_centre);
    }

    private void createInside_shop_centreRoom()
    {
        inside_shop_centre = new Room("Inside Eden shopping centre");
        inside_shop_centre.setExit("north",eden_shop_centre);
        inside_shop_centre.setExit("east",jd);
        inside_shop_centre.setExit("south",krispy_kreme);
        inside_shop_centre.setExit("west",ann_summers);
    }

    private void createKrispy_kreamRoom()
    {
        krispy_kreme = new Room("Welcome to Krispy Kream", new Items ("Donuts"));

        krispy_kreme.setExit("north",inside_shop_centre);
        //exit
        inside_shop_centre.setExit("south",krispy_kreme);
    }

    private void createAnn_summersRoom()
    {
        ann_summers = new Room("Inside ann summers. i don't think we should be in here.");
        ann_summers.setExit("east",inside_shop_centre);
        //exit
        inside_shop_centre.setExit("west",ann_summers);
    }

    private void createJDRoom()
    {
        jd = new Room("Inside JD", new Items ("ID"));

        jd.setExit("west",inside_shop_centre);
        inside_shop_centre.setExit("east",jd);
    }

    private void createMcdonaldsRoom()
    {
        // create the rooms
        mcdonalds = new Room("outside Mcdonald's");
        // initialise room exits
        mcdonalds.setExit("north", high_street);
        //exit
        high_street.setExit("south",mcdonalds);
    }

    private void createInside_mcdonaldsRoom()
    {
        // create the rooms

        inside_mcdonalds = new Room("inside McDonald's", new Items ("Cheeseburger"));
        // initialise room exits
        inside_mcdonalds.setExit("north",mcdonalds);
        //exit
        mcdonalds.setExit("south",inside_mcdonalds);
    }

    public Room getStartRoom()
    {
        return StartRoom;
    }
}