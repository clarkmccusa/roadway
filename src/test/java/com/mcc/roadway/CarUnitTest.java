package com.mcc.roadway;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mcc.roadway.domain.Car;
import com.mcc.roadway.domain.Environment;
import com.mcc.roadway.domain.TrafficLight;

public class CarUnitTest {

	@Test
	public void carNotAtLight(){
		Environment env = envWithOneLight(10);
		Car car = new Car( 9, env);
		assertFalse( car.isAtLight() );
	}
	
	@Test 
	public void carAtLight(){
		Environment env = envWithOneLight(10);
		Car car = new Car( 10, env);
		assertTrue( car.isAtLight() );
	}
	
	@Test
	public void carIsAtRedLight(){
		Environment env = envWithOneLight(10);
		Car car = new Car( 10, env);
		assertTrue( car.isAtRedLight() );
	}
	
	@Test
	public void carAtSecondLight(){
		Environment env = envWithTwoLights(11, 22);
		Car c1 = new Car( 10, env );
		assertFalse( c1.isAtLight() );
		Car c2 = new Car( 22, env );
		assertTrue( c2.isAtLight() );
	}
	
	//Create Environment with one light, initially Red
	private Environment envWithOneLight( int position ){
		TrafficLight light = new TrafficLight( position, 10, TrafficLight.LightStatus.RED );
		List<TrafficLight> lights = new ArrayList<TrafficLight>(1);
		lights.add(light);
		Environment env = new Environment( lights );
		return env;
	}
	
	//Create environment with two lights, initially Red.
	private Environment envWithTwoLights( int pos1, int pos2 ){
		TrafficLight l1 = new TrafficLight( pos1, 10, TrafficLight.LightStatus.RED );
		TrafficLight l2 = new TrafficLight( pos2, 10, TrafficLight.LightStatus.RED );
		List<TrafficLight> lights = new ArrayList<TrafficLight>(2);
		lights.add(l1);lights.add(l2);
		return new Environment(lights);
	}
	
}
