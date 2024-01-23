package MultiThreading;

class A extends Thread {
	public void run() {
		System.out.println("thread running...");
	}
}

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.start();

	}

}
