import java.util.LinkedList;
import java.util.Random;

public class AircraftGenerator {

    private final double LIGHTPLANE_CREATION_PROBABILITY = 0.007;
    private final double GLIDER_CREATION_PROBABILITY = 0.002;
    private double p;
    private TakeoffQueue to;
    private LandingQueue ln;
    private LinkedList<Aircraft> takeoffQueue;
    private LinkedList<Aircraft> landingQueue;
    private int tcounter = 1;
    private int lcounter = 1;

    public AircraftGenerator(double p)
    {
        this.p = p;
        takeoffQueue = new LinkedList<>();
        landingQueue = new LinkedList<>();
        to = new TakeoffQueue();
        ln = new LandingQueue();

    }

    public void generateTakeoff()
    {
        Random rand = new Random();
        if (rand.nextDouble() <= GLIDER_CREATION_PROBABILITY)
        {
            Aircraft ac = new Glider();
            ac.setNumber(tcounter);
            to.addAircraft(ac);
            //takeoffQueue.add(ac);
            tcounter++;
        } else if (rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY)
        {
            Aircraft ac = new LightAircraft();
            ac.setNumber(tcounter);
            to.addAircraft(ac);
            //takeoffQueue.add(ac);
            tcounter++;

        } else if (rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY + p)
        {
            Aircraft ac = new Commercial();
            ac.setNumber(tcounter);
            to.addAircraft(ac);
            //takeoffQueue.add(ac);
            tcounter++;
        }

    } // End of generate

    public void generateLanding()
    {
        Random rand = new Random();
        if (rand.nextDouble() <= GLIDER_CREATION_PROBABILITY)
        {
            Aircraft ac = new Glider();
            ac.setNumber(lcounter);
            ln.addAircraft(ac);
            lcounter++;
        } else if (rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY)
        {
            Aircraft ac = new LightAircraft();
            ac.setNumber(lcounter);
            ln.addAircraft(ac);
            lcounter++;
        } else if (rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY + p)
        {
            Aircraft ac = new Commercial();
            ac.setNumber(lcounter);
            ln.addAircraft(ac);
            lcounter++;
        }
    }

//	public void addLanding(Aircraft ac) {
//		landingQueue.add(ac);
//	}


//	public LinkedList<Aircraft> getTakeoffQueue() {
//		return takeoffQueue;
//	}

    public TakeoffQueue getTakeoffQueue()
    {
        return to;
    }

    public LandingQueue getLandingQueue()
    {
        return ln;
    }


    public String getTakeoffList()
    {
        String str = "[";
        //for(int i = 0; i < takeoffQueue.size(); i++) {
        for (int i = 0; i < to.getSize(); i++)
        {
            //str += takeoffQueue.get(i).toString() + ", ";
            str += to.getAircraft(i).toString() + ", ";
        }
        str += "]";
        return str;
    }

    public String getLandingList()
    {
        String str = "[";
        //for(int i = 0; i < landingQueue.size(); i++) {
        for (int i = 0; i < ln.getSize(); i++)
        {
            //str += landingQueue.get(i).toString() + ", ";
            str += ln.getAircraft(i).toString() + ", ";
        }
        str += "]";
        return str;
    }
}
