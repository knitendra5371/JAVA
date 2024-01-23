package MultiThreading;

class SM implements Runnable {
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

public class SleepMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable r = new SM();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();

	}

}
