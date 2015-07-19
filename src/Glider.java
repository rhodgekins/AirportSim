
public class Glider extends Aircraft {

    private static final double PROBABILITY = 0.002; //probability constant for glider
    private String name = "Glider";
    private final int takeoffCount = 6; //number of steps to take off
    private final int landCount = 8; //number of steps to land
    private Aircraft towPlane;

    public Glider()
    {
        super.toCount = takeoffCount; //set takeoff count to the correct value
        super.lnCount = landCount; //set landing count to the correct value
        super.name = name;
    }

    public static double getProbability()
    {
        return PROBABILITY;
    }

    public void depleteFuel()
    {
        //method empty as gliders do not deplete fuel
    }

    public int getFuel()
    {
        return 999; // return arbitrary large number
    }

    public void setFuel(int fuel)
    {
        //method unused but included to keep design generic
    }

    public boolean needsTowing()
    {
        return true; // glider needs to be towed along the runway to take off
    }

    public void setTakeoffCount()
    {
        super.setTakeoffCount();
        towPlane = new LightAircraft(); //when glider is taking off create new LightAircraft to tow it along the runway
        towPlane.setLandCount();
        towPlane.setFuel(40); //towing aircraft has 20 minutes of fuel (40 steps)
    }

    public Aircraft getTowPlane()
    {
        return towPlane; //accessor for runway to get LightAircraft to put into landing queue
    }
}
