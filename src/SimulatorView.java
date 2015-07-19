
public interface SimulatorView {
	
	void showStatus(int step, String toList, String lnList, String ac);
	
	void finalStats(int crashed, int takeoffs, int landings, int waitTime);
}
