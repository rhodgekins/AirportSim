
public class FuelledCraft extends Aircraft {

    private int fuel;

    public FuelledCraft()
    {
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
    { //deplete fuel by 1.  if fuel is 0 then the plane will crash
        fuel--;
        if (fuel <= 0)
        {
            crashed = true;
        }
    }

    public boolean needsTowing()
    {
        return false; // fuelled aircraft do not need towing along the runway to take off
    }
}
