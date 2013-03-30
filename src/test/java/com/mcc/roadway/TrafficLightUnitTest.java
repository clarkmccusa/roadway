package com.mcc.roadway;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mcc.roadway.domain.TrafficLight;

public class TrafficLightUnitTest {

	@Test
	public void lessThanDurationRemainsRed(){
		TrafficLight light = buildRedLight(10);
		assertTrue(light.getCurrentStatus().equals(TrafficLight.LightStatus.RED));
		for(int i=0; i< 9; i++){
			light.updateStatus();
		}
		assertTrue(light.getCurrentStatus().equals(TrafficLight.LightStatus.RED));
	}
	
	@Test
	public void redToGreenOnceCycle(){
		
		final int lightDuration = 10;
		TrafficLight light = new TrafficLight( 10, lightDuration, TrafficLight.LightStatus.RED);
		
		assertTrue(light.getCurrentStatus().equals(TrafficLight.LightStatus.RED));
		
		//Cycle through 
		for( int i = 0;  i <  lightDuration; i++ ){
			light.updateStatus();
		}
		
		assertTrue( light.getCurrentStatus().equals(TrafficLight.LightStatus.GREEN));
		
	}
	
	@Test
	public void redToGreenTwoCycles(){
		
		final int lightDuration = 10;
		TrafficLight light = buildRedLight(lightDuration);
		
		assertTrue(light.getCurrentStatus().equals(TrafficLight.LightStatus.RED));
		
		int twoCycles = lightDuration*2;
		
		//Cycle through two light cycles
		for( int i = 0;  i <  twoCycles; i++ ){
			light.updateStatus();
		}
		
		assertTrue( light.getCurrentStatus().equals(TrafficLight.LightStatus.RED));
		
	}
	
	private TrafficLight buildRedLight( int duration ){
		return new TrafficLight( 10, duration, TrafficLight.LightStatus.RED );
	}
	
}
