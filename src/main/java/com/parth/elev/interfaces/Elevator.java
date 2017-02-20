package com.parth.elev.interfaces;

import com.parth.elev.enumeration.ElevatorDirection;
import com.parth.elev.enumeration.ElevatorStatus;

public interface Elevator {
	public void moveUp();
	public void moveDown();
	public void addDestination(int dest);
	public ElevatorStatus status();
	public ElevatorDirection direction();	
}
