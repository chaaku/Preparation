import java.util.*;

import javax.management.RuntimeErrorException;


/* 

https://www.geeksforgeeks.org/
design-parking-lot-using-object-oriented-principles/      

*/
public class Elevator_system {

	public interface Elevator {
	    int getMinFloor();
	    int getMaxFloor();
	    int getCurrentFloor();
	    Deque<Integer> getDestinationQueue();
	    void moveUp();
	    void moveDown();
	    void moveNext();
	    void dequueDestination(int floor);
	    void queueDestination(int floor);
	    boolean isInPath(int floor);
	    boolean isFull();
	    boolean isIdle(); 
	}
	
	//	Controller interface

	public interface ElevatorController {
	    void addFloor(int floor);
	    void removeFloor(int floor);
	    void step() throws RuntimeException;
	}
	
	public class GlobalElevatorController implements ElevatorController {
	    private List<Elevator> elevators;

	    // mainly used if no elevators are available, then need to queue into controller
	    private Queue<Integer> pickupQueue;

	    public GlobalElevatorController(List<Elevator> elevators) {
	        this.elevators = elevators;
	        pickupQueue = new LinkedList<>();
	    }

	    /**
	     * Represents pick up (origin floor).  Attempt to delegate request immediately, but if no elevators presently
	     * available, then add to controller's queue, and attempt again during step().
	     *
	     * @param floor assumption: the same pickup floor will not be requested while it's being processed.  Logic should
	     *             be handled by hypothetical button class.
	     */
	    @Override
	    public void addFloor(int floor) {
	        if (!pickupQueue.isEmpty()) {
	            pickupQueue.add(floor);
	        } else {
	            // immediately put into idle or in-path elevators
	            for (Elevator elevator : elevators) {
	                if (elevator.isIdle()) {
	                    elevator.queueDestination(floor);
	                    return;
	                } else if (elevator.isInPath(floor)) {
	                    elevator.queueDestination(floor);
	                }
	            }
	        }
	    }
	    
	    @Override
	    public void removeFloor(int floor) {
	        if (!pickupQueue.isEmpty()) {
	            	pickupQueue.remove(floor);
	        	} 
	     	}
	   
	    /**
	     * Move elevators.
	     *
	     * TODO: extend Thread, so this runs autonomously.  For now, call step() manually.
	     */
	    @Override
	    public void step() {
	        for (Elevator elevator : elevators) {
	            if (elevator.isIdle()) {
	                if (!pickupQueue.isEmpty()) {
	                    elevator.queueDestination(pickupQueue.poll());
	                }
	            } else {
	                elevator.moveNext();
	            }
	        }
	    } }
	
	public class ElevatorImpl implements Elevator {
	    private final int minFloor;
	    private final int maxFloor;
	    private final int maxCapacity;
	    private int currentFloor;
	    private Deque<Integer> destinationQueue;

	    public ElevatorImpl(int minFloor, int maxFloor, int maxCapacity) {
	        this.minFloor = minFloor;
	        this.maxFloor = maxFloor;
	        this.maxCapacity = maxCapacity;
	        currentFloor = 0;
	        destinationQueue = new LinkedList<>();
	    }

	    @Override
	    public int getMinFloor() {
	        return minFloor;
	    }

	    @Override
	    public int getMaxFloor() {
	        return maxFloor;
	    }

	    @Override
	    public int getCurrentFloor() {
	        return currentFloor;
	    }

	    @Override
	    public Deque<Integer> getDestinationQueue() {
	        return destinationQueue;
	    }

	    @Override
	    public void queueDestination(int floor) {
	        //O(N)
	        if (!destinationQueue.contains(floor)) {
	            destinationQueue.add(floor);
	        }
	    }

	    @Override
	    public void dequueDestination(int floor) {
	        destinationQueue.addFirst(floor);
	    }

	    @Override
	    public void moveNext() {
	        if (destinationQueue.isEmpty()) {
	            return;
	        }
	        int destination = destinationQueue.peek();
	        if (currentFloor < destination) {
	            moveUp();
	        } else if (currentFloor > destination) {
	            moveDown();
	        }

	        if (currentFloor == destination) {
	            destinationQueue.poll();
	        }
	    }

	    @Override
	    public void moveUp() {
	        if (currentFloor == maxFloor) {
	            throw new RuntimeErrorException(null,"cannot move above max currentFloor");
	        }

	        // if full, then takes up a tick and must check again next tick
	        if (!isFull()) {
	            currentFloor++;
	        }
	    }

	    @Override
	    public void moveDown() {
	        if (currentFloor == minFloor) {
	            throw new RuntimeErrorException(null,"cannot move below minimum currentFloor");
	        }

	        if (!isFull()) {
	            currentFloor--;
	        }
	    }

	    @Override
	    public boolean isInPath(int floor) {
	        if (destinationQueue.isEmpty()) {
	            return false;
	        }
	        int destination = destinationQueue.peek();
	        return (floor >= currentFloor && floor <= destination) || (floor <= currentFloor && floor >= destination);
	    }

	    @Override
	    public boolean isFull() {
	        //would use maxCapacity here
	        return false;
	    }

	    @Override
	    public boolean isIdle() {
	        return destinationQueue.isEmpty();
	    }
	}
	
	/*
 * 


class ElevatorSystem {

Elevator[] elevators;

int totalFloors; // total floors in the building

Queue<Elevator> availableElevators; // Queue of all available floors

boolean[] requestedFloors; // all the floors from where an elevator was requested

public Elevator getNearestAvailableElevator(floorNumber);

public void callElevator(floorNumber, elevator);

}

class FloorLobby {

Button up;

Button down;

}

class Elevator {

int id;

int currentFloor;

boolean goUp; // is elevator suppose to go up

boolean goDown;

boolean[] isAStop; // flags all floors on which elevator is suppose to stop

Button[] buttons;

public void putAsAvailable(id);

public void gotoFloor(floor);

public void start();

public int currentFloor();

}

class Button {

int buttonId;

int floorNumber;

}

 */
	
	
}
