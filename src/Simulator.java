import java.util.Iterator;

public class Simulator {

    private ControlTower ct; //control tower to manage aircraft
    private static double p; //probability for commercial aircraft generation
    private AircraftGenerator ag; //object to generate aircraft to populate queues
    private Runway runway; //runway to hold Aircraft objects when they are taking off or landing
    private SimulatorView s;
    private int crashed;

    public static void main(String[] args)
    {
        p = 0.005;  // By default, use a probability of 0.1
        if (args.length >= 1)
        {
            p = Integer.parseInt(args[0]);
        }

        int numberOfSteps = 2880;  // By default, run for 2880 steps (24 hours, 30 min per step)
        if (args.length >= 2)
        {
            numberOfSteps = Integer.parseInt(args[1]);
        }
        if (numberOfSteps <= 0)
            numberOfSteps = 1;

        Simulator s = new Simulator(); // construct new Simulator

        s.move(numberOfSteps); // move the simulator
    }

    public Simulator()
    {
        //initialize objects
        ct = new ControlTower();
        ag = new AircraftGenerator();
        runway = new Runway();
        s = new TextView();
    } // end of constructor


    public void move(int numberOfSteps)
    {
        for (int step = 1; step <= numberOfSteps; step++)
        {
            moveOneStep(step);
        }
        s.finalStats(crashed, runway.getTakeOffs(), runway.getLandings(), runway.getTotalWait());
    }

    public void moveOneStep(int step)
    {

        checkCrashed();
        waitIncrementer();
        fuelDecrementer();
        ag.generateTakeoff(); //add aircraft randomly to takeoff and landing queues (maximum 1 per queue per step)
        ag.generateLanding();

        //debug information showing current step, the contents of queues and runway
        s.showStatus(step, ag.getTakeoffList(), ag.getLandingList(), runway.getAircraft());

        runway.process(ag.getLandingQueue()); //process the runway for one step
        ct.manageQueues(ag.getTakeoffQueue(), ag.getLandingQueue(), runway); //manage queues of aircraft and adding them to the runway

    } // end of moveOneStep

    public static double getP()
    {
        return p;
    }

    private void fuelDecrementer()
    { //deplete fuel only for aircraft in the landing queue
        for (Aircraft nextP : ag.getLandingQueue().getList())
        {
            System.out.println("Plane " + nextP.getNumber() + " has " + (nextP.getFuel() / 2) + " minutes of fuel left");
            nextP.depleteFuel();
        }
    }

    private void checkCrashed()
    { // check if an aircraft has crashed.  if so, remove from queue and increment crashed counter
        for (Iterator<Aircraft> iter = ag.getLandingQueue().getList().iterator(); iter.hasNext(); )
        {
            Aircraft nextP = iter.next();
            if (nextP.hasCrashed())
            {
                iter.remove();
                crashed++;
            }
        }
    }

    private void waitIncrementer()
    { //increments waiting time each step for aircraft in queues
        for (Aircraft nextP : ag.getLandingQueue().getList())
        {
            nextP.waitOneStep();
        }
        for (Aircraft nextP : ag.getTakeoffQueue().getList())
        {
            nextP.waitOneStep();
        }
    }
}
