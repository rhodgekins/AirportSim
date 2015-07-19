import java.util.LinkedList;

public class TakeoffQueue {

    private LinkedList<Aircraft> takeoff;

    public TakeoffQueue()
    {
        takeoff = new LinkedList<>();
    }

    public void addAircraft(Aircraft a)
    {
        takeoff.add(a);
    }

    public void removeAircraft()
    {
        takeoff.remove();
    }

    public Aircraft getHeadOfQueue()
    {
        return takeoff.peek();
    }

    public Aircraft getAircraft(int i)
    {
        return takeoff.get(i);
    }

    public int getSize()
    {
        return takeoff.size();
    }
}
