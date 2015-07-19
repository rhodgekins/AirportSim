
import java.util.Random;


public class AircraftGenerator {

	private final double LIGHTPLANE_CREATION_PROBABILITY = 0.007; //probability constant for light aircraft
	private final double GLIDER_CREATION_PROBABILITY = 0.002; //probability constant for glider (both of these may end up being adjustable)
	private double p; //commercial aircraft probability
	private TakeoffQueue to; //queue to hold aircraft taking off
	private LandingQueue ln; //queue to hold aircraft landing
	private int tcounter = 1; //counters currently used for debugging
	private int lcounter = 1;

	public AircraftGenerator(double p) {
		this.p = p; //store the value passed in for commercial aircraft probability
		to = new TakeoffQueue(); //initialise takeoff and landing queues
		ln = new LandingQueue();

	}

	public void generateTakeoff() {
		Random rand = new Random(); //new random number
		
		if(rand.nextDouble() <= GLIDER_CREATION_PROBABILITY){ //if number matches the Glider's probability
			Aircraft ac = new Glider(); //create new Glider object
			ac.setName("tk_"); //debug info
			ac.setNumber(tcounter); //debug info
			to.addAircraft(ac); //add aircraft to the queue
			tcounter++;
		}
		else if(rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY) { //if number matches the Light Aircraft's probability
			Aircraft ac = new LightAircraft(); //create new LightAircraft object
			ac.setName("tk_"); //debug info
			ac.setNumber(tcounter); //debug info
			to.addAircraft(ac); //add aircraft to the queue
			tcounter++;

		}
		else if (rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY + p) { //if number matches the Commercial Aircraft's probability
			Aircraft ac = new Commercial(); //create new Commercial object
			ac.setName("tk_"); //debug info
			ac.setNumber(tcounter); //debug info
			to.addAircraft(ac); //add aircraft to the queue
			tcounter++;
		}

	}

	public void generateLanding() {
		Random rand = new Random(); //new random number
		
		if(rand.nextDouble() <= GLIDER_CREATION_PROBABILITY){ //if number matches the Glider's probability
			Aircraft ac = new Glider(); //create new Glider object
			ac.setName("ln_"); //debug info
			ac.setNumber(lcounter); //debug info
			ln.addAircraft(ac); //add aircraft to the queue
			lcounter++;
		}
		else if(rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY) { //if number matches the Light Aircraft's probability
			Aircraft ac = new LightAircraft(); //create new LightAircraft object
			ac.setName("ln_"); //debug info
			ac.setNumber(lcounter); //debug info
			ln.addAircraft(ac); //add aircraft to the queue
			lcounter++;
		}
		else if (rand.nextDouble() <= LIGHTPLANE_CREATION_PROBABILITY + p) { //if number matches the Commercial Aircraft's probability
			Aircraft ac = new Commercial(); //create new Commercial object
			ac.setName("ln_"); //debug info
			ac.setNumber(lcounter); //debug info
			ln.addAircraft(ac); //add aircraft to the queue
			lcounter++;
		}
	}

	public TakeoffQueue getTakeoffQueue() {
		return to;
	}

	public LandingQueue getLandingQueue() {
		return ln;
	}



	//last two methods are for debugging currently. may or may not be in the final version
	public String getTakeoffList() {
		String str = "[";
		for(int i = 0; i < to.getSize(); i++) {
			str += to.getAircraft(i).toString() + to.getAircraft(i).getNumber() + ", ";
		}
		str += "]";
		return str;
	}

	public String getLandingList() {
		String str = "[";
		for(int i = 0; i < ln.getSize(); i++) {
			str += ln.getAircraft(i).toString() + ln.getAircraft(i).getNumber() + ", ";
		}
		str += "]";
		return str;
	}
}
