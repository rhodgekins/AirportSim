import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Simulator {

    private ControlTower ct;
    private static double p;
    private AircraftGenerator ag;
    private Runway runway;

    public static void main(String[] args)
    {
        p = 0.08;  // By default, use a probability of 0.1
        if (args.length >= 1)
        {
            p = Integer.parseInt(args[0]);
        }

        int numberOfSteps = 100;  // By default, run for 2880 steps (24 hours, 30 min per step)
        if (args.length >= 2)
        {
            numberOfSteps = Integer.parseInt(args[1]);
        }
        if (numberOfSteps <= 0)
        {
            numberOfSteps = 1;
        }

        Simulator s = new Simulator(); // Construct new Simulation

        s.move(numberOfSteps); // Move the vehicles
    }

    public Simulator()
    {
        ct = new ControlTower();
        ag = new AircraftGenerator(p);
        runway = new Runway();
    } // End of constructor


    public void move(int numberOfSteps)
    {
        for (int step = 1; step <= numberOfSteps; step++)
        {
            moveOneStep(step);
        }
    }

    public void moveOneStep(int step)
    {
        ag.generateTakeoff();
        ag.generateLanding();
        System.out.println("Step " + step + ":");
        System.out.println("Takeoff Queue: " + ag.getTakeoffList());
        System.out.println("Landing Queue: " + ag.getLandingList());
        System.out.println("Runway: " + runway.getAircraft());
        //ct.manageQueues(ag.getTakeoffQueue(), ag.getLandingQueue());
        runway.process();
        ct.manageQueues(ag.getTakeoffQueue(), ag.getLandingQueue(), runway);
    } // end of moveOneStep
}
