/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X координата данной локации. **/
    public int xCoord;

    /** Y координата данной локации. **/
    public int yCoord;

    /** Реализация метода equals() **/
	//@Override
    public boolean equals(Location l){
		if (this.xCoord == l.xCoord && this.yCoord == l.yCoord) 
			return true;
		else 
			return false;

    }
	
	//@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCoord;
		result = prime * result + yCoord;
		return result; 
	}

    /** Создание новой локации со специальными координатами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Создание новой локации с координатами (0.0). **/
    public Location()
    {
        this(0, 0);
    }
}