
public class Aircraft {

    private int number;
    private boolean takingOff = false;
    private boolean landing = false;
    protected int count;
    private String name;

    public Aircraft()
    {
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public void setCount(int count)
    {
        this.count = count;
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

    public void setTakingOff(boolean takingOff)
    {
        this.takingOff = takingOff;
    }

    public boolean isTakingOff()
    {
        return takingOff;
    }

    public void setLanding(boolean takingOff)
    {
        this.landing = takingOff;
    }

    public boolean isLanding()
    {
        return landing;
    }

    public String toString()
    {
        return "" + number;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
