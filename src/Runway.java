
public class Runway {

    private Aircraft[] ac; //an array of aircraft (could just use one Aircraft object, still TBD)

    public Runway()
    {
        ac = new Aircraft[1]; //initialise the field
    }

    public void addAircraft(Aircraft ac)
    {
        this.ac[0] = ac; //Aircraft object is passed into the method and the field value set
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
        this.ac[0] = null; //set field ac to null, making the runway empty
    }

    public boolean isEmpty()
    {
        return ac[0] == null;
    }

    public void process()
    {
        if (!isEmpty())
        { //if the runway is not empty
            ac[0].countdown(); //decrement the count representing takeoff or landing
            if (ac[0].getCount() == 0)
            { //if count is zero, Aircraft has taken off / landed. remove it from the runway
                removeAircraft();
            }
        }
    }
}
