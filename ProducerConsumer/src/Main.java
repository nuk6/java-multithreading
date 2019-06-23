
class Process {

	private int counter = 0;
	private final int UPPER = 5;
	private final int LOWER = 0;
	private final Object lock = new Object();

	public void producer() {
		synchronized (lock) {
			while (true) {
				if (counter > UPPER) {
					try {
						counter--;
						System.out.println("Waiting P");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Producer : " + counter++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.notify();
				}
			}
		}
	}

	public void consumer() {
		synchronized (lock) {
			while (true) {
				if (counter < LOWER) {
					try {
						counter++;
						System.out.println("Waiting C");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Consumer : " + counter--);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.notify();
				}
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Process p1 = new Process();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				p1.producer();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				p1.consumer();
			}
		});
		t1.start();
		t2.start();
	}
}
