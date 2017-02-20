package com.parth.elev.interfaces;

public interface ElevatorFlow {
	public void pickUp(int floor);
	public void destination(int id, int destinationfloor);
	public void movement();
}
