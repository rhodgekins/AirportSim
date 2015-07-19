
public class Runway {

    private Aircraft[] ac; //an array of aircraft
    private int takeoffs, landings, totalWaitTime;

    public Runway()
    {
        ac = new Aircraft[2]; //initialise the field
    }

    public void addAircraft(Aircraft ac, int i)
    {
        this.ac[i] = ac; //Aircraft object is passed into the method and the field value set
    }

    public String getAircraft()
    {
        if (!isEmpty())
        { //if the runway is not empty
            return ac[0].toString() + ac[0].getNumber(); //return string values from the Aircraft
        }
        return ""; //else return an empty string
    }

    public void removeAircraft()
    {
        for (int i = 0; i < ac.length; i++)
        {
            this.ac[i] = null; //set field ac to null, making the runway empty
        }
    }

    public boolean isEmpty()
    {
        return ac[0] == null;
    }

    public void process(AircraftQueue lnq)
    {
        if (!isEmpty())
        { //if the runway is not empty
            ac[0].countdown(); //decrement the count representing takeoff or landing
            if (ac[0].getCount() == 0)
            { //if count is zero, Aircraft has taken off / landed.
                if (ac[0].isTakingOff())
                {
                    if (ac[0].needsTowing())
                    { // check to see if plane is being towed
                        ac[1].setFuel(40); // set towing aircraft to have 20 mins of fuel
                        lnq.addAircraft(ac[1]); // add towing aircraft to the landing queue
                    }
                    takeoffs++; // increment total number of takeoffs
                } else if (ac[0].isLanding())
                {
                    landings++; // increment total number of landings
                }
                totalWaitTime += ac[0].getWaitingTime();
                removeAircraft(); // remove aircraft from the runway
            }
        }
    }

    public int getTakeOffs()
    {
        return takeoffs;
    }

    public int getLandings()
    {
        return landings;
    }

    public int getTotalWait()
    {
        return totalWaitTime;
    }
}
