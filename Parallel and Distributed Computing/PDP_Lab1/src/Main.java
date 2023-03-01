public class Main {
	
	public static int threadCounter = 0;
	public static int threadLimit = 12;
	private static int numThreads = 4;
	
	static Thread threadsArr[] = new Thread[numThreads];
	
	public static void main(String[] args) {
		//Create threads
		for (int i = 0; i < numThreads / 2; i++) {
			threadsArr[i] = new MyThread();
			threadsArr[i + numThreads/2] = new Thread(new MyRunnable());
			threadCounter += 2;
		}
		
		//Start threads
		for (int i = 0; i < numThreads; i++) {
			threadsArr[i].start();
		}
		
		for (int i = 0; i < numThreads; i++) {
			try {
				threadsArr[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}