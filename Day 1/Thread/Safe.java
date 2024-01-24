package ThreadSafe;

public class Safe {
	public static void main(String[] args) {
		SingletonRunnable SingletonRunnable= new SingletonRunnable();
		SingletonRunnable SingletonRunnable1= new SingletonRunnable();
		SingletonRunnable SingletonRunnable2= new SingletonRunnable();
		Thread t1= new Thread(SingletonRunnable);
		Thread t2= new Thread(SingletonRunnable1);
		Thread t3= new Thread(SingletonRunnable2);
		 t1.start();
		 t2.start();
		 t3.start();

	}
}

