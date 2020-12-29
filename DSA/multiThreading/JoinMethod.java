package MultiThreading;

class JM implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class JoinMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable r = new JM();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);

		t1.start();

		try {
			t1.join(); // we use this join method for wait till finish t1 thread
//			t1.join(5000); // we use this join method  for wait a fix time , time is in milliseconds 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("lol");
		t2.start();
		t3.start();

	}

}
