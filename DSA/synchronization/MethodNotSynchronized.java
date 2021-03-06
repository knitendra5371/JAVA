package synchronization;

class Table {
	void printTable(int n) {// method not synchronized
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

public class MethodNotSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Table obj = new Table();// only one object
		MyThread1 mt1 = new MyThread1(obj);
		MyThread2 mt2 = new MyThread2(obj);
		mt1.start();
		mt2.start();

	}

}
