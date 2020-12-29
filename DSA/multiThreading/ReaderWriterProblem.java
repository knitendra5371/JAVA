package MultiThreading;

public class ReaderWriterProblem {
	private static Integer sharedData = 2;

	public static void main(String[] args) throws InterruptedException {

		Thread readerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (ReaderWriterProblem.class) {
					System.out.println("before sharedData in reader : " + sharedData);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("after sharedData in reader : " + sharedData);
				}

			}
		});

		Thread writerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (ReaderWriterProblem.class) {
					System.out.println("before inc");
					sharedData++;
					System.out.println("after inc");
				}
			}
		});

		readerThread.start();
//		readerThread.join(1000);
		writerThread.start();

	}

}
