package com.mcc.roadway.domain;

import java.util.List;

/**
 * Represents the physical environment within with a Car is operating
 * Similar to a physical paper map, it shows the lay of the land.
 * 
 * For the simulation it represents only the status of traffic lights.
 *
 */
public class Environment {

	public Environment( List<TrafficLight> lights){
		this.lights = lights;
	}
	
	private final List<TrafficLight> lights;
	
	public List<TrafficLight> getLights(){
		return this.lights;
	}
}
