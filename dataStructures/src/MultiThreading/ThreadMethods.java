package MultiThreading;

public class ThreadMethods extends Thread {

	public void run() {
		System.out.println("running...   " + Thread.currentThread().getName() + "     Thread priority  "
				+ Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		ThreadMethods t1 = new ThreadMethods();
		ThreadMethods t2 = new ThreadMethods();
		System.out.println("Name of t1:" + t1.getName());
		System.out.println("Name of t2:" + t2.getName());

		t1.start();
		t2.start();

		t1.setName("siddhartha thread");
		System.out.println("After changing name of t1:" + t1.getName());

	}

}
