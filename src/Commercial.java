
public class Commercial extends FuelledCraft {

    private final String name = "Commercial";
    private final int takeoffCount = 4; //number of steps to take off
    private final int landCount = 6; //number of steps to land

    public Commercial()
    {
        super.toCount = this.takeoffCount; //set takeoff count to the correct value
        super.lnCount = this.landCount; //set landing count to the correct value
        super.name = this.name;
    }

    public static double getProbability()
    {
        return Simulator.getP();
    }
}
