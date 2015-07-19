import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Simulator {

    private ControlTower ct; //control tower to manage aircraft
    private static double p; //probability for commercial aircraft generation
    private AircraftGenerator ag; //object to generate aircraft to populate queues
    private Runway runway; //runway to hold Aircraft objects when they are taking off or landing

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
            numberOfSteps = 1;

        Simulator s = new Simulator(); // Construct new Simulation

        s.move(numberOfSteps); // Move the vehicles
    }

    public Simulator()
    {
        //initialize objects
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
        ag.generateTakeoff(); //add aircraft randomly to takeoff and landing queues (maximum 1 per queue per step)
        ag.generateLanding();

        //debug information showing current step, the contents of queues and runway
        System.out.println("Step " + step + ":");
        System.out.println("Takeoff Queue: " + ag.getTakeoffList());
        System.out.println("Landing Queue: " + ag.getLandingList());
        System.out.println();
        System.out.println("Runway: " + runway.getAircraft());
        System.out.println();

        runway.process(); //process the runway for one step
        ct.manageQueues(ag.getTakeoffQueue(), ag.getLandingQueue(), runway); //manage queues of aircraft and adding them to the runway

    } // end of moveOneStep
}
