package com.parth.elev.soruce;

import java.util.PriorityQueue;

import com.parth.elev.enumeration.ElevatorDirection;
import com.parth.elev.enumeration.ElevatorStatus;
import com.parth.elev.interfaces.Elevator;

public class ElevatorImpl implements Elevator {

	private int currFloor;
	private PriorityQueue<Integer> destinationFloor;
	
	public ElevatorImpl(int currFloor){
		setCurrFloor(currFloor);
		this.destinationFloor = new PriorityQueue<Integer>();		
	}
	
	public void moveUp() {
		currFloor++;
	}

	public void moveDown() {
		currFloor--;
	}

	public void addDestination(int dest) {
		this.destinationFloor.add(dest);
	}
	
	public void nextDestination() {
		this.destinationFloor.peek();
	}
	
	public void removeDestination() {
		this.destinationFloor.poll();
	}

	public ElevatorStatus status() {
		if(destinationFloor.size() > 0){
			return ElevatorStatus.ElevatorRunning;
		}
		
		return ElevatorStatus.ElevatorStop;
	}

	public ElevatorDirection direction() {
		if(destinationFloor.size()>0){
			if(currFloor > destinationFloor.peek()){
				return ElevatorDirection.ElevatorDown;				
			}
			else if(currFloor < destinationFloor.peek()){
				return ElevatorDirection.ElevatorUp;
			}			
		}
		return ElevatorDirection.ElevatorHold;
	}

	public int getCurrFloor() {
		return currFloor;
	}

	public void setCurrFloor(int currFloor) {
		this.currFloor = currFloor;
	}

	

}
