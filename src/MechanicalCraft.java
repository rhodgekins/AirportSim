
public class MechanicalCraft extends Aircraft {

    private int fuel;
    private boolean crashed;

    public MechanicalCraft()
    {
        crashed = false;
    }

    public int getFuel()
    {
        return fuel;
    }

    public void setFuel(int fuel)
    {
        this.fuel = fuel;
    }

    public void depleteFuel()
    {
        fuel--;
    }

    public void crashed()
    {
        if (fuel == 0 && isTakingOff()) //if there's no fuel and the plane has taken off...
        {
            crashed = true;
        }
    }
}
