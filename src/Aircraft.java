
public abstract class Aircraft {

    private int number;
    protected int count, toCount, lnCount;
    protected String name;
    private String prefix;
    protected boolean crashed = false;
    private boolean takingOff, landing;
    private int waitingTime;

    public Aircraft()
    {
        takingOff = false;
        landing = false;
    }

    public boolean isTakingOff()
    {
        return takingOff;
    }

    public boolean isLanding()
    {
        return landing;
    }

    public String getName()
    {
        return name;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public int getNumber()
    {
        return number;
    }

    public void setTakeoffCount()
    {
        takingOff = true;
        count = toCount; //set count of the aircraft to the takeoff count
    }

    public void setLandCount()
    {
        landing = true;
        count = lnCount; //set count of the aircraft to the landing count
    }

    public int getCount()
    {
        return count;
    }

    public void countdown()
    {
        count--;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String toString()
    {
        char firstChar = name.charAt(0);
        return prefix + firstChar;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void crash()
    {
        crashed = true;
    }

    public boolean hasCrashed()
    {
        return crashed;
    }

    public void waitOneStep()
    {
        waitingTime++;
    }

    public int getWaitingTime()
    {
        return waitingTime;
    }

    public abstract void depleteFuel();

    public abstract int getFuel();

    public abstract void setFuel(int fuel);

    public abstract boolean needsTowing();
}
