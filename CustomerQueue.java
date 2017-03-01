import java.util.ArrayList;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	private int queueLength;
	private Gui gui;
	private ArrayList<Customer> circBuff;
	int readPos = 0;
	int writePos = 0;
	int counter = 0;

	/**
	 * Creates a new customer queue. Make sure to save these variables in the class.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
		// Incomplete
		this.queueLength = queueLength;
		this.gui = gui;
		circBuff = new ArrayList<>();
		for (int i = 0; i < queueLength; i ++){
			circBuff.add(null);
		}
	}

	public synchronized void add(Customer customer) {
    	//If lounge is not full
		if (counter < queueLength){
			circBuff.set(writePos, customer);
			gui.fillLoungeChair(writePos, customer);
			gui.println("Doorman let in customer");
			counter += 1;
			writePos = calcPos(writePos);
			notifyAll();
		}else{
			try{
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized Customer next(String barberName) {
		if (circBuff.get(readPos) != null){
			Customer nextCust = circBuff.get(readPos);
			gui.emptyLoungeChair(readPos);
			circBuff.set(readPos, null);
			counter -= 1;
			readPos = calcPos(readPos);
			notifyAll();
			return nextCust;
		}else {
			try{
				System.out.println(barberName + " thread is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
 		return null;
	}

	// Add more methods as needed

	private int calcPos(int pos){
    	if (pos < queueLength -1) {
			pos += 1;
		} else {
			pos = 0;
		}
		return pos;
	}
}


