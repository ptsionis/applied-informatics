import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.apache.commons.math3.special.Gamma;

//Implementation of Knuth's problem

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static final int START = 4;
	static long goal;

	public static void main(String[] args) {
		
		System.out.println("Enter a number: ");
		goal = scanner.nextLong();
		
		System.out.println("Enter search algorithm:");
		System.out.println("1 = Breadth First Search (BFS)");
		System.out.println("2 = Iterative Deepening Search (IDS)");
		int algorithm = scanner.nextInt();
		
		State state;
		
		if (algorithm == 1) {
			state = breadthFirstSearch(goal);
		} else {
			//Will be implemented later, for now it gets the same result as above in order to execute
			state = breadthFirstSearch(goal);
		}
		
		System.out.println("Operations needed:");
		System.out.println(state.getSequence());
		scanner.close();
	}
	
	public static State breadthFirstSearch(double number) {
		long startTime = System.currentTimeMillis();
		Queue<State> stateQueue = new LinkedList<>();
		stateQueue.add(new State(START, new ArrayList<>(), "start"));
		
		while (!stateQueue.isEmpty()) {
			State currentState = stateQueue.poll();
			if (currentState.getValue() == goal) {
				System.out.println("Total time: " + ((System.currentTimeMillis() - startTime) * 0.001) + "s (in ms: " + (System.currentTimeMillis() - startTime) + ")");
				return currentState;
			}
				
			
			stateQueue.add(new State(Math.sqrt(currentState.getValue()), currentState.getSequence(), "root"));
			stateQueue.add(new State(Math.floor(currentState.getValue()), currentState.getSequence(), "floor"));
			stateQueue.add(new State(Gamma.gamma(currentState.getValue() + 1), currentState.getSequence(), "factorial"));
		}
		
		System.out.println("Total time: " + ((System.currentTimeMillis() - startTime) * 0.001) + "s (in ms: " + (System.currentTimeMillis() - startTime) + ")");
		return null;
	}

}
