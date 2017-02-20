package com.parth.elev.user;

import java.util.ArrayList;

import com.parth.elev.soruce.ElevatorFlowImpl;
import com.parth.elev.soruce.ElevatorImpl;

public class user {
	public static void main(String[] args){
		int totalElevator = 2, totalFloor = 10, 
			destination1 = 6, destination2 = 2;
		ArrayList<ElevatorImpl> elevator;
		ElevatorFlowImpl EFI = new ElevatorFlowImpl(totalElevator, totalFloor);
//		EFI.pickUp(destination1);
//		EFI.pickUp(destination2);
		elevator = (ArrayList<ElevatorImpl>) EFI.getElevators();
		System.out.println("Elevator Start at " +  +elevator.get(0).getCurrFloor());
		EFI.destination(0, destination1);
		EFI.destination(1, destination2);
		
//		EFI.destination(1, 20);
		for(int i=0; i<totalFloor; i++){
		      EFI.movement();
		}
		elevator = (ArrayList<ElevatorImpl>) EFI.getElevators();
		System.out.println("After droping people, Elevator 1 at: " +  +elevator.get(0).getCurrFloor());
		System.out.println("After droping two people, Elevator 2 at: " +  +elevator.get(1).getCurrFloor());
		EFI.destination(0, 5);
		EFI.destination(1, 9);
		for(int i=0; i<totalFloor; i++){
		      EFI.movement();
		}
		elevator = (ArrayList<ElevatorImpl>) EFI.getElevators();
		System.out.println("After droping another people, Elevator 1 at: " + elevator.get(0).getCurrFloor());
		System.out.println("After droping another people, Elevator 2 at: " + elevator.get(1).getCurrFloor());

	}
}
