import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Simulation {

    private static final double LIGHTPLANE_CREATION_PROBABILITY = 0.007;
    private static final double GLIDER_CREATION_PROBABILITY = 0.002;

    private Queue<Plane> planes;
    private static double p;
    private static int numberOfSteps;
    private int i = 0;

    public static void main(String[] args)
    {
        numberOfSteps = 100;  // By default, run for 100 tick
        if (args.length >= 1)
        {
            numberOfSteps = Integer.parseInt(args[0]);
        }

        if (numberOfSteps <= 0)
        {
            numberOfSteps = 1;
        }

        p = 0.02;  // By default, use a seed of 42
        if (args.length >= 2)
        {
            p = Integer.parseInt(args[1]);
        }

        Simulation s = new Simulation(); // Construct new Simulation
        s.move(numberOfSteps); // Move the vehicles
    }

    public Simulation()
    {
        planes = new LinkedList<Plane>();
    } // End of constructor


    public void move(int numberOfSteps)
    {
        for (int step = 1; step <= numberOfSteps; step++)
        {
            populate();
            moveOneStep();
        }
    }

    public void moveOneStep()
    {
        for (Iterator<Plane> iter = planes.iterator(); iter.hasNext(); )
        {
            Plane nextP = iter.next();
            if (nextP instanceof Glider)
            {
                System.out.println("Plane " + nextP.getNumber() + " is a Glider");
                iter.remove();
            } else if (nextP instanceof LightPlane)
            {
                System.out.println("Plane " + nextP.getNumber() + " is a Light Plane");
                iter.remove();
            } else if (nextP instanceof Commercial)
            {
                System.out.println("Plane " + nextP.getNumber() + " is a Commercial Plane");
                iter.remove();
            }
        }
    }

    private void populate()
    {
        Random rand = new Random();
        double prob = rand.nextDouble();
        if (prob <= GLIDER_CREATION_PROBABILITY)
        {
            Plane p = new Glider();
            p.setNumber(i);
            planes.add(p);
        } else if (prob <= LIGHTPLANE_CREATION_PROBABILITY)
        {
            Plane p = new LightPlane();
            p.setNumber(i);
            planes.add(p);
        } else if (prob <= (LIGHTPLANE_CREATION_PROBABILITY + p))
        {
            Plane p = new Commercial();
            p.setNumber(i);
            planes.add(p);
        }
        i++;
    } // End of populate
}
