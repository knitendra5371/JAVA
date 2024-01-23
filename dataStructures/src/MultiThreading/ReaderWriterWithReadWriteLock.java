package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class TestReader implements Runnable {

	Lock rlock;

	public TestReader(ReadWriteLock rwlock) {
		this.rlock = rwlock.readLock();
	}

	@Override
	public void run() {
		rlock.lock();
		System.out.println("before sharedData in reader : " + ReaderWriterWithReadWriteLock.sharedData);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rlock.unlock();
		}
		System.out.println("after sharedData in reader : " + ReaderWriterWithReadWriteLock.sharedData);
	}

}

class TestWriter implements Runnable {

	Lock wlock;

	public TestWriter(ReadWriteLock rwlock) {
		this.wlock = rwlock.writeLock();
	}

	@Override
	public void run() {
		wlock.lock();
		try {
			System.out.println("before inc");
			ReaderWriterWithReadWriteLock.sharedData++;
			System.out.println("after inc");
		} finally {
			wlock.unlock();
		}
	}

}

public class ReaderWriterWithReadWriteLock {
	public static Integer sharedData = 2;

	public static void main(String[] args) {

		ReadWriteLock rwlock = new ReentrantReadWriteLock();

		TestReader reader = new TestReader(rwlock);
		Thread readerThread1 = new Thread(reader);
		Thread readerThread2 = new Thread(reader);

		TestWriter writer = new TestWriter(rwlock);
		Thread writerThread1 = new Thread(writer);
		Thread writerThread2 = new Thread(writer);
		writerThread1.start();
		readerThread1.start();
		readerThread2.start();
		writerThread2.start();

	}

}
