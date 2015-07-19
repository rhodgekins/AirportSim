
public class LightAircraft extends FuelledCraft {

    private static final double PROBABILITY = 0.005; //probability constant for light aircraft
    private String name = "Light";
    private final int takeoffCount = 4; //number of steps to take off
    private final int landCount = 6; //number of steps to land

    public LightAircraft()
    {
        super.toCount = takeoffCount; //set takeoff count to the correct value
        super.lnCount = landCount; //set landing count to the correct value
        super.name = name;
    }

    public static double getProbability()
    {
        return PROBABILITY;
    }

}
