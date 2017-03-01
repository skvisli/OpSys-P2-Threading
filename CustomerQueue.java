import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	private int queueLength;
	private Gui gui;
	public LinkedList<Customer> queue;
	public LinkedList<Customer> loungeSeating;

	/**
	 * Creates a new customer queue. Make sure to save these variables in the class.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
		// Incomplete
		this.queueLength = queueLength;
		this.gui = gui;
		queue = new LinkedList<>();
		loungeSeating = new LinkedList<>();
		for (int i = 0; i < 18; i++){
			loungeSeating.add(null);
		}
	}

	public synchronized void add(Customer customer) {
		queue.add(customer);
		for (int i = 0; i < loungeSeating.size(); i++){
			if(loungeSeating.get(i) == null){
				loungeSeating.set(i, customer);
				gui.fillLoungeChair(i, queue.peekLast());
				gui.println("Doorman let in customer");
				notifyAll();
				break;
			}
		}
	}

	public synchronized Customer next(String barberName) {
		// Inclomplete
		if (queue.isEmpty()){
			try{
				System.out.println(barberName + " thread is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			Customer nextCust = queue.poll();
			gui.emptyLoungeChair(loungeSeating.indexOf(nextCust));
			loungeSeating.set(loungeSeating.indexOf(nextCust), null);
			return nextCust;
		}
		return null;
	}

	// Add more methods as needed
}


