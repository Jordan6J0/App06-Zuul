import java.util.ArrayList;

public class Player
{
    private String name;
    private int points;
    private int count;

    private ArrayList<Items> itemList;
    private int health;

    public Player(String name)
    {
        health = 2;
        points = 0;
        itemList = new ArrayList<>();
    }

    // POINTS SET POINTS AND ADDING THEM TAKING AWAY
    public int getPoints()
    {
        return points;
    }

    public void resetPoints()
    {
        points = 0;
    }

    public void addPoints(int amount)
    {
        if (amount > 0)
            points += amount;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

    public boolean hasItem(Items targetItem)
    {
        for (Items item : itemList)
        {
            if (item == targetItem)
                return true;
        }
        return false;
    }

    public void takeItem(Items item)
    {
        // itemList.add(item);
        //  if (item == Items.CHEESEBURGER)
        //   {
        //       points = points + 10;
        //    }
        //   if (item == Items.CREDITCARD)
        //    {
        //        points = points + 100;
        //    }
        //   if (item == Items.ID)
        //    {
        //       points = points + 10;
        //   }
        //   if (item == Items.DONUTS)
        //  {
        //      points = points + 100;
        //  }
        //   if (item == Items.MONEY)
        //  {
        //       points = points + 50;
        //  }
    }

    public void printInventory()
    {
        System.out.println("You are carrying :");
        for (Items items : itemList)
        {
            System.out.println(items.getDescription());
        }

    }

    public void takeItem()
    {
    }
}