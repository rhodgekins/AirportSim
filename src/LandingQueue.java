import java.util.LinkedList;

public class LandingQueue {

    private LinkedList<Aircraft> landing;

    public LandingQueue()
    {
        landing = new LinkedList<>();
    }

    public void addAircraft(Aircraft a)
    {
        landing.add(a);
    }

    public void removeAircraft()
    {
        landing.remove();
    }

    public Aircraft getHeadOfQueue()
    {
        return landing.peek();
    }

    public Aircraft getAircraft(int i)
    {
        return landing.get(i);
    }

    public int getSize()
    {
        return landing.size();
    }

    public boolean isEmpty()
    {
        return landing.isEmpty();
    }
}
