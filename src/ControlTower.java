
public class ControlTower {

    public ControlTower()
    {
    }

    public void manageQueues(AircraftQueue takeoff, AircraftQueue landing, Runway runway)
    {
        if (runway.isEmpty())
        { //if there is no aircraft currently taking off or landing
            if (landing.isEmpty())
            {  //landing queue takes priority so do nothing here if there are planes waiting to land
                if (!takeoff.isEmpty())
                {
                    Aircraft headAC = takeoff.getHeadOfQueue(); // store head of queue in local variable
                    System.out.println(headAC.getName() + " aircraft is at the front of the takeoff queue"); //debug info
                    headAC.setTakeoffCount(); //set number of steps to take off
                    runway.addAircraft(headAC, 0); //add the aircraft to the runway
                    if (headAC.needsTowing())
                    { // if aircraft needs towing
                        Aircraft ac = new LightAircraft(); // create new light aircraft
                        ac.setPrefix("tw_");
                        runway.addAircraft(ac, 1); // add light aircraft to the runway to tow the aircraft
                    }
                    takeoff.removeHeadOfQueue(); //remove aircraft from queue
                }
            } else
            { //if there are planes waiting to land
                Aircraft headAC = landing.getHeadOfQueue(); // store head of queue in local variable
                System.out.println(headAC.getName() + " aircraft is landing"); //debug info
                headAC.setLandCount(); //set number of steps to land
                runway.addAircraft(headAC, 0); //add the aircraft to the runway
                landing.removeHeadOfQueue(); //remove aircraft from queue
            }
        }
    }
}




