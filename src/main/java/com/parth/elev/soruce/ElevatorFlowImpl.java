package com.parth.elev.soruce;
import java.util.*;

import com.parth.elev.enumeration.ElevatorDirection;
import com.parth.elev.interfaces.ElevatorFlow;

public class ElevatorFlowImpl implements ElevatorFlow {
	List<ElevatorImpl> elevators;
	public int totalElevators = 16;
	int numberOfFloor = 0;
	int numberOfElevator = 0;	
	PriorityQueue<Integer> pickUpFloor;
	
	public ElevatorFlowImpl(int noOfElevators, int noOfFloor){
		if(totalElevators < noOfElevators){
			numberOfElevator = totalElevators;
		}else{
			numberOfElevator = noOfElevators;
		}
		numberOfFloor = noOfFloor;
		elevators = new ArrayList<ElevatorImpl>();
		pickUpFloor = new PriorityQueue<Integer>();
		for(int i = 0; i<numberOfElevator; i++){
			elevators.add(new ElevatorImpl(1));			
		}
	}
	
	public void pickUp(int floor) {
		pickUpFloor.add(floor);
	}

	public void destination(int id, int destinationfloor) {
		elevators.get(id).addDestination(destinationfloor);
	}

	public void movement() {
		for(ElevatorImpl curElevator : elevators){
			switch (curElevator.status()) {
			case ElevatorStop:
				if(pickUpFloor.isEmpty() == false){
					curElevator.addDestination(pickUpFloor.poll());
				}
				break;
				case ElevatorRunning:
					switch (curElevator.direction()) {
						case ElevatorUp:
							curElevator.moveUp();
							break;
						case ElevatorDown:
							curElevator.moveDown();
							break;	
						case ElevatorHold:
							curElevator.removeDestination();
							break;					
					}					
					if(curElevator.direction() == ElevatorDirection.ElevatorUp){					
						break;
					}				
			}
			
		}
	}

	public List<ElevatorImpl> getElevators() {
		return elevators;
	}
		

}
