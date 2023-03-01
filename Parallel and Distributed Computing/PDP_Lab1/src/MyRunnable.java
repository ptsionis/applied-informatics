public class MyRunnable implements Runnable {

	@Override
	public void run() {
		//Prints running message
		System.out.println("I am " + Thread.currentThread().getName() + " running.");
		
		//Remove this if statement if you want to fill up your RAM quickly
		if (Main.threadCounter < Main.threadLimit) {
			Main.threadCounter++;
			
			//Every time a thread starts, it creates two new threads and starts them, waits for them
			//to finish and prints goodbye message
			for (int i = 0; i < 2; i++) {
				Thread t1 = new Thread(new MyRunnable());
				Thread t2 = new Thread(new MyRunnable());
				
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("I am " + Thread.currentThread().getName() + " stopping.");
	}

}
