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
	int pos = -1;
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

	public void add(Customer customer) {
		// Inclomplete
		//Loops the pos around
//		if (pos >= 17){
//			pos = -1;
//		}
//		pos += 1;

		pos = 0;

		queue.add(customer);
		for (int i = 0; i < loungeSeating.size(); i++){
			if(loungeSeating.get(i) == null){
				loungeSeating.set(i, customer);
				pos = i;
				gui.fillLoungeChair(pos, queue.peekLast());
				gui.println("Doorman let in customer");
				break;
			}
//			try{
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}


	public Customer next() {
		// Inclomplete
		Customer nextCust = queue.poll();
		System.out.println(loungeSeating.indexOf(nextCust));
		gui.emptyLoungeChair(loungeSeating.indexOf(nextCust));
		loungeSeating.set(loungeSeating.indexOf(nextCust), null);
//		notifyAll();
		return nextCust;
	}

	// Add more methods as needed
	public Customer peekLast(){
		return queue.peekLast();
	}

	public int getQueueLength(){
		return queue.size();
	}

	public int getQueueMaxLength(){
		return queueLength;
	}

	public boolean isEmpty(){
		//System.out.println(queue.isEmpty());
		return queue.isEmpty();
	}
}


