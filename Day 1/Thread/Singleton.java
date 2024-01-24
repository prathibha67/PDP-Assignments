package ThreadSafe;

public class Singleton {
	private static Singleton singleton;

	private int count = 1;

	private Singleton() {
	}

	public synchronized static Singleton getInstance() {
		if (singleton == null) {
			if (singleton == null) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}

	public synchronized void count() {
		System.out.println(Thread.currentThread().getName() + " " + count++);
	}
}
