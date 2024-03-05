package MultiThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) throws InterruptedException {

		Thread producerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				producer();
			}
		});

		Thread consumerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				consumer();
			}
		});

		producerThread.start();
		consumerThread.start();
	}

	private static void producer() {
		while (true) {
			try {
				Thread.sleep(2000);
				if (queue.remainingCapacity() != 0) {
					Random random = new Random();
					Integer item = random.nextInt(100);
					queue.add(item);
					System.out.println("produced item : " + item);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void consumer() {
		while (true) {
			try {
				Thread.sleep(2000);
				if (queue.size() > 0) {
					Integer item = queue.take();
					System.out.println("consumed item: " + item);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
