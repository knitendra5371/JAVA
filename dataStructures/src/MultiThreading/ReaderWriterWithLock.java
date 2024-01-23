package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriterWithLock {
	private static Integer sharedData = 2;

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread readerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				System.out.println("before sharedData in reader : " + sharedData);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
				System.out.println("after sharedData in reader : " + sharedData);
			}
		});

		Thread writerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					System.out.println("before inc");
					sharedData++;
					System.out.println("after inc");
				} finally {
					lock.unlock();
				}
			}
		});

		readerThread.start();
		readerThread.join(1000);
		writerThread.start();

	}

}
