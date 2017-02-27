import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	private int queueLength;
	private Gui gui;
	public LinkedList<Customer> queue;
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
	}

	public void add(Customer customer) {
		// Inclomplete
		queue.add(customer);
	}


	public Customer next() {
		// Inclomplete
		Customer cust = queue.peek();
		gui.emptyLoungeChair(queue.indexOf(cust));
		return queue.poll();
	}

	// Add more methods as needed
	public Customer peek(){
		return queue.peek();
	}

	public int getQueueLength(){
    	return queue.size();
	}

	public int getQueueMaxLength(){
		return queueLength;
	}
	public boolean isEmpty(){
		return queue.isEmpty();
	}
}


