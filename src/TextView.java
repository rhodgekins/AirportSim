
public class TextView implements SimulatorView {

    public void showStatus(int step, String toList, String lnList, String ac)
    {
        System.out.println("Step " + step + ":");
        System.out.println("Takeoff Queue: " + toList);
        System.out.println("Landing Queue: " + lnList);
        System.out.println();
        System.out.println("Runway: " + ac);
        System.out.println();
    }

    public void finalStats(int crashed, int takeoffs, int landings, int waitTime)
    {
        System.out.println("*RESULTS*");
        System.out.println("Number of successful take offs: " + takeoffs);
        System.out.println("Number of successful landings: " + landings);
        System.out.println("Number of crashes: " + crashed);
        System.out.println("Total waiting time: " + waitTime / 2 + " minutes");
    }
}
