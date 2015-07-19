
import java.util.Random;

public class AircraftGenerator {

    private AircraftQueue to, ln; //queues to hold aircraft taking off and landing
    private int tcounter = 1; //counters currently used for debugging
    private int lcounter = 1;

    public AircraftGenerator()
    {
        to = new AircraftQueue(); //initialise takeoff and landing queues
        ln = new AircraftQueue();
    }

    public void generateTakeoff()
    {
        Random rand = new Random(); //new random number

        if (rand.nextDouble() <= Glider.getProbability())
        { //if number matches the Glider's probability
            Aircraft ac = new Glider(); //create new Glider object
            ac.setPrefix("tk_"); //debug info
            ac.setNumber(tcounter); //debug info
            to.addAircraft(ac); //add aircraft to the queue
            tcounter++;
        } else if (rand.nextDouble() <= (Glider.getProbability() + LightAircraft.getProbability()))
        { //if number matches the Light Aircraft's probability
            Aircraft ac = new LightAircraft(); //create new LightAircraft object
            ac.setPrefix("tk_"); //debug info
            ac.setNumber(tcounter); //debug info
            to.addAircraft(ac); //add aircraft to the queue
            tcounter++;
        } else if (rand.nextDouble() <= (Glider.getProbability() + LightAircraft.getProbability() + Commercial.getProbability()))
        { //if number matches the Commercial Aircraft's probability
            Aircraft ac = new Commercial(); //create new Commercial object
            ac.setPrefix("tk_"); //debug info
            ac.setNumber(tcounter); //debug info
            to.addAircraft(ac); //add aircraft to the queue
            tcounter++;
        }
    }

    public void generateLanding()
    {
        Random rand = new Random(); //new random number

        if (rand.nextDouble() <= Glider.getProbability())
        { //if number matches the Glider's probability
            Aircraft ac = new Glider(); //create new Glider object
            ac.setPrefix("ln_"); //debug info
            ac.setNumber(lcounter); //debug info
            ln.addAircraft(ac); //add aircraft to the queue
            lcounter++;
        } else if (rand.nextDouble() <= (Glider.getProbability() + LightAircraft.getProbability()))
        { //if number matches the Light Aircraft's probability
            Aircraft ac = new LightAircraft(); //create new LightAircraft object
            Random gen = new Random(42); // Or choose a different seed
            int flyingTime = gen.nextInt(20) + 20; // time measured in half-minutes
            ac.setFuel(flyingTime); // set amount of fuel for the aircraft
            ac.setPrefix("ln_"); //debug info
            ac.setNumber(lcounter); //debug info
            ln.addAircraft(ac); //add aircraft to the queue
            lcounter++;
        } else if (rand.nextDouble() <= (Glider.getProbability() + LightAircraft.getProbability() + Commercial.getProbability()))
        { //if number matches the Commercial Aircraft's probability
            Aircraft ac = new Commercial(); //create new Commercial object
            Random gen = new Random(42); // Or choose a different seed
            int flyingTime = gen.nextInt(40) + 40; // time measured in half-minutes
            ac.setFuel(flyingTime); // set amount of fuel for the aircraft
            ac.setPrefix("ln_"); //debug info; //debug info
            ac.setNumber(lcounter); //debug info
            ln.addAircraft(ac); //add aircraft to the queue
            lcounter++;
        }
    }

    public AircraftQueue getTakeoffQueue()
    {
        return to;
    }

    public AircraftQueue getLandingQueue()
    {
        return ln;
    }

    //last two methods are for debugging currently. may or may not be in the final version
    public String getTakeoffList()
    {
        String str = "[";
        for (int i = 0; i < to.getSize(); i++)
        {
            str += to.getAircraft(i).toString() + to.getAircraft(i).getNumber() + ", ";
        }
        str += "]";
        return str;
    }

    public String getLandingList()
    {
        String str = "[";
        for (int i = 0; i < ln.getSize(); i++)
        {
            str += ln.getAircraft(i).toString() + ln.getAircraft(i).getNumber() + ", ";
        }
        str += "]";
        return str;
    }
}
