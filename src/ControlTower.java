
public class ControlTower {

    public ControlTower()
    {
    }

    public void manageQueues(TakeoffQueue takeoff, LandingQueue landing, Runway runway)
    {
        if (runway.isEmpty())
        { //if there is no aircraft currently taking off or landing

            if (landing.isEmpty())
            {  //landing queue takes priority so do nothing here if there are planes waiting to land

                if (takeoff.getHeadOfQueue() instanceof Commercial)
                { //if the aircraft at the head of the queue is commercial
                    System.out.println("Commercial aircraft is at the front of the takeoff queue"); //debug info
                    takeoff.getHeadOfQueue().setCount(4); //set number of steps to take off
                    //takeoff.getHeadOfQueue().setName("tko_"); //debug info
                    runway.addAircraft(takeoff.getHeadOfQueue()); //add the aircraft to the runway
                    takeoff.removeAircraft(); //remove aircraft from queue
                } else if (takeoff.getHeadOfQueue() instanceof LightAircraft)
                { //if the aircraft at the head of the queue is a light aircraft
                    System.out.println("Light aircraft is at the front of the takeoff queue"); //debug info
                    takeoff.getHeadOfQueue().setCount(4); //set number of steps to take off
                    //takeoff.getHeadOfQueue().setName("tko_"); //debug info
                    runway.addAircraft(takeoff.getHeadOfQueue()); //add the aircraft to the runway
                    takeoff.removeAircraft(); //remove aircraft from queue
                } else if (takeoff.getHeadOfQueue() instanceof Glider)
                { //if the aircraft at the head of the queue is a glider
                    System.out.println("Glider is at the front of the takeoff queue"); //debug info
                    takeoff.getHeadOfQueue().setCount(6); //set number of steps to take off
                    //takeoff.getHeadOfQueue().setName("tko_"); //debug info
                    runway.addAircraft(takeoff.getHeadOfQueue()); //add the aircraft to the runway
                    takeoff.removeAircraft(); //remove aircraft from queue
                    //also need to add light aircraft to landing queue, or to runway then landing queue (not implemented yet)
                }
            } else
            { //if there are planes waiting to land
                if (landing.getHeadOfQueue() instanceof Commercial)
                { //if the aircraft at the head of the queue is commercial
                    System.out.println("Commercial aircraft is landing"); //debug info
                    landing.getHeadOfQueue().setCount(6); //set number of steps to land
                    //landing.getHeadOfQueue().setName("lnd_"); //debug info
                    runway.addAircraft(landing.getHeadOfQueue()); //add the aircraft to the runway
                    landing.removeAircraft(); //remove aircraft from queue
                } else if (landing.getHeadOfQueue() instanceof LightAircraft)
                { //if the aircraft at the head of the queue is a light aircraft
                    System.out.println("Light aircraft is landing"); //debug info
                    landing.getHeadOfQueue().setCount(6); //set number of steps to land
                    //landing.getHeadOfQueue().setName("lnd_"); //debug info
                    runway.addAircraft(landing.getHeadOfQueue()); //add the aircraft to the runway
                    landing.removeAircraft(); //remove aircraft from queue
                } else if (landing.getHeadOfQueue() instanceof Glider)
                { //if the aircraft at the head of the queue is a glider
                    System.out.println("Glider is landing"); //debug info
                    landing.getHeadOfQueue().setCount(8); //set number of steps to land
                    //landing.getHeadOfQueue().setName("lnd_"); //debug info
                    runway.addAircraft(landing.getHeadOfQueue()); //add the aircraft to the runway
                    landing.removeAircraft(); //remove aircraft from queue
                }
            }
        }
    }
}
