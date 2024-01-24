package ThreadSafe;

public class SingletonRunnable implements Runnable {

	private Singleton singleton;
	
	@Override
	public void run() {
		Singleton singleton1=Singleton.getInstance();
		singleton1.count();
	} 
}
