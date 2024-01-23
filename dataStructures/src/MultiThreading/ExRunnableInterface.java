package MultiThreading;

class ExRunnable implements Runnable {
	public void run() {
		System.out.println("Thread running.... ");
	}
}

public class ExRunnableInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExRunnable er = new ExRunnable();

		Thread t = new Thread(er);
		t.start();

	}

}
