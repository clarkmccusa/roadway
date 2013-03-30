package com.mcc.roadway.domain;

/**
 * Represents a traffic light in the simulation.  A traffic light has the immutable properties
 * position and duration, which will not change once the traffic light is created.
 * Durations are assumed to be equal for Red and Green cycles of the light. A light is responsible 
 * for updating its status each time a call is made to updateStatus, a "pulse" which indicates that
 * one "second" has elapsed within the environment
 *
 */
public class TrafficLight {

	public TrafficLight( int position, int duration, LightStatus initialStatus ){
		this.position = position;
		this.duration = duration;
		this.currentStatus = initialStatus;
	}
	
	private final int position;
	private final int duration;
	private int timer = 0;//Assume lights don't start in the middle of a cycle.
	public LightStatus currentStatus;
	
	/**
	 * Updates the red/green status of this light based upon its duration (how long it stays
	 * red or green) relative to the how long it has been red or green.
	 * 
	 * Assumes that red/green cycles are equal with respect to duration.
	 */
	public void updateStatus(){
		timer++;
		if( this.timer % duration == 0 ){
			this.flipStatus();
			this.resetTimer();
		}
	}
	
	public static enum LightStatus{
		RED, GREEN
	}

	//Resets the internal sequence timer
	private void resetTimer(){
		this.timer = 0;
	}

	//Toggles the status/color of this light
	private void flipStatus(){
		if( this.currentStatus.equals( LightStatus.RED ) ){
			this.currentStatus = LightStatus.GREEN;
		}else{
			this.currentStatus = LightStatus.RED;
		}
	}
	
	/**
	 * @return position of this light
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * @return current Red/Green status of this light
	 */
	public LightStatus getCurrentStatus(){
		return this.currentStatus;
	}
	
}
