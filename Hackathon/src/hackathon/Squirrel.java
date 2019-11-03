package hackathon;

import java.awt.Rectangle;
import java.awt.Point;

public class Squirrel
{
    private Rectangle loc;
    private int playerID;
    private int numNuts;
    private Movement dir;

    public Squirrel(int id, int x, int y)
    {
        playerID = id;
        loc = new Rectangle(x, y, 180, 190);
        dir = Movement.STILL;
    }

    public void setLocation(int x, int y)
    {
        loc.setLocation(x, y);
    }

    public void move(int x, int y)
    {
        loc.setLocation(loc.x + x, loc.y + y);
    }

    public int getX()
    {
        return (int) loc.getX();
    }

    public int getY() 
    {
        return (int) loc.getY();
    }

    public Movement getDirection()
    {
        return null;
    }

    public void addNut()
    {
        numNuts++;
    }

    public int getNumNuts()
    {
        return numNuts;
    }

    public boolean touched(Point p )
    {
        return loc.contains(p);
    }

    public int getID()
    {
        return 0;
    }

    public byte[] getBytes()
    {
        byte[] data = new byte[16];
        ByteHelp.toBytes(playerID, 0, data);
        ByteHelp.toBytes(loc.x, 4, data);
        ByteHelp.toBytes(loc.y, 8, data);
        ByteHelp.toBytes(numNuts, 12, data);

        return data;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o.getClass() != Squirrel.class)
        {
            return false;
        }

        Squirrel s = (Squirrel) o;
        return s.playerID == this.playerID;
    }
}