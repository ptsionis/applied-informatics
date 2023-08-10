import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.math3.special.Gamma;

//Implementation of Knuth's problem

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static final int START = 4;

	public static void main(String[] args) {
		
		System.out.println("Enter a number: ");
		int goal = scanner.nextInt();
		
		System.out.println("Enter search algorithm:");
		System.out.println("1 = Breadth First Search (BFS)");
		System.out.println("2 = Iterative Deepening Search (IDS)");
		int algorithm = scanner.nextInt();
		
		State goalState;
		
		if (algorithm == 1) {
			goalState = breadthFirstSearch(goal);
		} else {
			goalState = iterativeDeepeningSearch(goal);
		}
		
		System.out.println("Operations needed:");
		System.out.println(goalState.getSequence());
		scanner.close();
	}
	
	public static State breadthFirstSearch(int goal) {
		long startTime = System.currentTimeMillis();
		Queue<State> stateQueue = new LinkedList<>();
		stateQueue.add(new State(START, new ArrayList<>(), "start"));
		
		while (!stateQueue.isEmpty()) {
			State currentState = stateQueue.poll();
			
			if (currentState.getValue() == goal) {
				System.out.println("Total time for BFS: " + ((System.currentTimeMillis() - startTime) * 0.001) + "s (in ms: " + (System.currentTimeMillis() - startTime) + ")");
				return currentState;
			}
			
			stateQueue.add(new State(Math.sqrt(currentState.getValue()), currentState.getSequence(), "root"));
			stateQueue.add(new State(Math.floor(currentState.getValue()), currentState.getSequence(), "floor"));
			stateQueue.add(new State(Gamma.gamma(currentState.getValue() + 1), currentState.getSequence(), "factorial"));
		}
		
		System.out.println("Total time for BFS: " + ((System.currentTimeMillis() - startTime) * 0.001) + "s (in ms: " + (System.currentTimeMillis() - startTime) + ")");
		return null;
	}
	
	public static State iterativeDeepeningSearch(int goal) {
		long startTime = System.currentTimeMillis();
		
		State resultState = null;
		
		for (int depth = 0; depth < Integer.MAX_VALUE - 1; depth++) {
			resultState = depthLimitedSearch(goal, depth);
			if (resultState != null) {
				System.out.println("Total time for IDS: " + ((System.currentTimeMillis() - startTime) * 0.001) + "s (in ms: " + (System.currentTimeMillis() - startTime) + ")");
				return resultState;
			}
		}
		
		System.out.println("Total time for IDS: " + ((System.currentTimeMillis() - startTime) * 0.001) + "s (in ms: " + (System.currentTimeMillis() - startTime) + ")");
		return resultState;
	}
	
	public static State depthLimitedSearch(int goal, int depth) {
		Stack<State> stateStack = new Stack<>();
		stateStack.push(new State(START, new ArrayList<>(), "start"));
    	
    	Set<Double> visitedStates = new HashSet<>();
    	
    	while (!stateStack.isEmpty()) {
    		State currentState = stateStack.pop();
    		
    		if (currentState.getValue() == goal)
    			return currentState;
    		
    		if (!visitedStates.contains(currentState.getValue())) {
    			visitedStates.add(currentState.getValue());
    			
    			if (currentState.getSequence().size() - 1 <= depth) {
    				stateStack.push(new State(Math.sqrt(currentState.getValue()), currentState.getSequence(), "root"));
    				stateStack.push(new State(Math.floor(currentState.getValue()), currentState.getSequence(), "floor"));
    				stateStack.push(new State(Gamma.gamma(currentState.getValue() + 1), currentState.getSequence(), "factorial"));
    			}
    		}
    	}
    	
    	return null;
    }

}
