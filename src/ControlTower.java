
public class ControlTower {

    public ControlTower()
    {

    }

    public void manageQueues(TakeoffQueue takeoff, LandingQueue landing, Runway runway)
    {

        if (runway.isEmpty())
        {

            if (landing.isEmpty())
            {

                if (takeoff.getHeadOfQueue() instanceof Commercial)
                {
                    System.out.println("Commercial aircraft is at the front of the takeoff queue");
                    takeoff.getHeadOfQueue().setTakingOff(true);
                    takeoff.getHeadOfQueue().setCount(4);
                    takeoff.getHeadOfQueue().setName(" (taking off)");
                    runway.addAircraft(takeoff.getHeadOfQueue());
                    takeoff.removeAircraft();
                }

                if (takeoff.getHeadOfQueue() instanceof LightAircraft)
                {
                    System.out.println("Light aircraft is at the front of the takeoff queue");
                    takeoff.getHeadOfQueue().setTakingOff(true);
                    takeoff.getHeadOfQueue().setCount(4);
                    takeoff.getHeadOfQueue().setName(" (taking off)");
                    runway.addAircraft(takeoff.getHeadOfQueue());
                    takeoff.removeAircraft();
                }

                if (takeoff.getHeadOfQueue() instanceof Glider)
                {
                    System.out.println("Glider is at the front of the takeoff queue");
                    takeoff.getHeadOfQueue().setTakingOff(true);
                    takeoff.getHeadOfQueue().setCount(6);
                    takeoff.getHeadOfQueue().setName(" (taking off)");
                    runway.addAircraft(takeoff.getHeadOfQueue());
                    takeoff.removeAircraft();
                }
            } else
            {

                if (landing.getHeadOfQueue() instanceof Commercial)
                {
                    System.out.println("Commercial aircraft is landing");
                    landing.getHeadOfQueue().setTakingOff(true);
                    landing.getHeadOfQueue().setCount(6);
                    landing.getHeadOfQueue().setName(" (landing)");
                    runway.addAircraft(landing.getHeadOfQueue());
                    landing.removeAircraft();
                }

                if (landing.getHeadOfQueue() instanceof LightAircraft)
                {
                    System.out.println("Light aircraft is landing");
                    landing.getHeadOfQueue().setTakingOff(true);
                    landing.getHeadOfQueue().setCount(6);
                    landing.getHeadOfQueue().setName(" (landing)");
                    runway.addAircraft(landing.getHeadOfQueue());
                    landing.removeAircraft();
                }

                if (landing.getHeadOfQueue() instanceof Glider)
                {
                    System.out.println("Glider is landing");
                    landing.getHeadOfQueue().setTakingOff(true);
                    landing.getHeadOfQueue().setCount(8);
                    landing.getHeadOfQueue().setName(" (landing)");
                    runway.addAircraft(landing.getHeadOfQueue());
                    landing.removeAircraft();
                }
            }
        }
    }
}


