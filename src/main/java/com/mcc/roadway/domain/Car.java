package com.mcc.roadway.domain;

import java.util.List;

/**
 * Represents a vehicle within the simulation.  Since cars are either moving at a constant
 * rate or "stopped" at a traffic light, there behavior is encapsulated in the advance method, 
 * which determines for each pulse in the environment whether they are allowed to move, 
 * or stopped at a traffic light.  Current status of traffic lights is contained wihtin
 * the Environment object which informs the Car of the current state of "whats going on 
 * around it"
 *
 */
public class Car {

	public Car( int initialPosition, Environment environment ){

		this.position = initialPosition;
		this.environment = environment;
	}
	
	private final Environment environment;
	private int position;

	public void advance(){
		position++;
	}
	
	public boolean isAtRedLight(){
		List<TrafficLight> lights = environment.getLights();
		for( TrafficLight light : lights ){
			if( (this.position == light.getPosition()) && light.currentStatus.equals(TrafficLight.LightStatus.RED) ){
				return true;
			}
		}
		return false;
	}
	
	public boolean isAtLight(){
		
		List<TrafficLight> lights =  environment.getLights();

		for( TrafficLight light : lights ){
			if( this.position == light.getPosition() ){
				return true;
			}
		}
		return false;
	}
	
	public int getPosition(){
		return this.position;
	}
}
