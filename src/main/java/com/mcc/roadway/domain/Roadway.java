package com.mcc.roadway.domain;

import java.util.ArrayList;
import java.util.List;

import com.mcc.roadway.domain.Car;
import com.mcc.roadway.domain.Environment;
import com.mcc.roadway.domain.TrafficLight;

public class Roadway {

	public static void main ( String[] args ){

		//Create lights with cycle time 10
		TrafficLight light1 = new TrafficLight( 50, 10, TrafficLight.LightStatus.GREEN );
		TrafficLight light2 = new TrafficLight( 65, 10, TrafficLight.LightStatus.RED );
		
		List<TrafficLight> lights = new ArrayList<TrafficLight>(2);
		lights.add(light1);
		lights.add(light2);
		
		//Set up the physical environment
		Environment env = new Environment(lights);
		
		//Create cars at specified locations
		Car car1 = new Car( 24, env );
		Car car2 = new Car( 12, env );
		Car car3 = new Car( 0, env );
		
		List<Car> cars = new ArrayList<Car>(3);
		cars.add(car1);cars.add(car2);cars.add(car3);
		
		//Print the initial status
		printEnv(0, lights, cars);
		
		for( int i=1; i<100; i++){
			updateLights( lights );
			updateCarLocations(cars);
			printEnv( i, lights, cars);
		}

	}
	
	private static void updateLights( List<TrafficLight> lights){
		for( TrafficLight light : lights ){
			light.updateStatus();
		}
	}
	
	private static void updateCarLocations( List<Car> cars ){
		for( Car car : cars ){
			if( !car.isAtRedLight() ){
				car.advance();
			}
		}
	}
	
	private static void printEnv( int position, List<TrafficLight> lights, List<Car> cars){
		StringBuffer buf = new StringBuffer();
		buf.append(position).append(" ");
		
		//Light status
		for( TrafficLight light : lights ){
			buf.append(light.getCurrentStatus().name()).append(" ");
		}
		
		//Car status
		for( Car car : cars ){
			buf.append( car.getPosition()).append(" ");
		}
		System.out.println( buf.toString());
	}
	
}
