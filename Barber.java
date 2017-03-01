/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 * One barber instance corresponds to one consumer in
 * the producer/consumer problem.
 */
public class Barber implements Runnable {
	public CustomerQueue queue;
	private Gui gui;
	private int pos;
	private String threadName;
	private Thread thread;
	private boolean running;
	/**
	 * Creates a new barber. Make sure to save these variables in the class.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) {
		// Incomplete
		this.queue = queue;
		this.gui = gui;
		this.pos = pos;
		threadName = "Barber " + pos;
		running = false;
	}

	/**
	 * This is the code that will run when a new thread is
	 * created for this instance.
	 */
	@Override
	public void run(){
		// Incomplete
		gui.println("Running " + threadName);
		running = true;
			while(true){
				Customer nextCust = queue.next(threadName);
				System.out.println(threadName + " is running");
				if (nextCust != null){
					try{
						gui.fillBarberChair(pos, nextCust);
						gui.println(threadName + " is cutting");
						thread.sleep(Globals.barberWork);
						gui.emptyBarberChair(pos);
						gui.barberIsSleeping(pos);
						thread.sleep(Globals.barberSleep);
						gui.barberIsAwake(pos);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
				}
			}
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		// Incomplete
		gui.println("Starting " +  threadName );
		thread = new Thread(this, threadName);
		thread.start();
	}

	/**
	 * Stops the barber thread.
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

