/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 * One doorman instance corresponds to one producer in
 * the producer/consumer problem.
 */
public class Doorman implements Runnable {
	public CustomerQueue queue;
	private Gui gui;
	private String threadName = "Doorman";
	private Thread thread;
	/**
	 * Creates a new doorman. Make sure to save these variables in the class.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) {
		// Incomplete
		this.queue = queue;
		this.gui = gui;
	}

	/**
	 * This is the code that will run when a new thread is
	 * created for this instance.
	 */
	@Override
	public void run(){
		// Incomplete
		gui.println("Running " + threadName);
		try{
			while(true){
				queue.add(new Customer());
				//notifyAll();
				thread.sleep(Globals.doormanSleep);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Starts the doorman running as a separate thread. Make
	 * sure to create the thread and start it.
	 */
	public void startThread() {
		// Incomplete
		gui.println("Starting " +  threadName );
		thread = new Thread(this, threadName);
		thread.start();
	}

	/**
	 * Stops the doorman thread. Use Thread.join() for stopping
	 * a thread.
	 */
	public void stopThread() {
		// Incomplete
		try{
			thread.join();
		}catch( Exception e) {
			gui.println("Interrupted");
		}
	}

	// Add more methods as needed
}
