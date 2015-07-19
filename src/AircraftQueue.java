import java.util.LinkedList;


public class AircraftQueue {

	protected LinkedList<Aircraft> queue;

	public AircraftQueue() {
		queue = new LinkedList<>();
	}

	public void addAircraft (Aircraft a) {
		queue.add(a);
	}

	public void removeHeadOfQueue() {
		queue.remove();
	}
	
	public void removeAircraft(Aircraft ac) {
		queue.remove(ac);
	}

	public Aircraft getHeadOfQueue() {
		return queue.peek();
	}

	public Aircraft getAircraft(int i) {
		return queue.get(i);
	}

	public int getSize() {
		return queue.size();
	}

	public LinkedList<Aircraft> getList() {
		return queue;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

}


