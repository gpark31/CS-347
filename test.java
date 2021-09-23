package IoTHTR;

public class test {
	public static boolean testing = true;
	//values can be altered for testing purposes
	public static void testValues(){
		//Sensor Damages
		Distance.DistanceDamage = false;
		GPS.GPSDamage = false;
		Heat.heatDamage = false;
		Motion.MotionDamage = false;
		Wheels.WheelsDamage = false;
	
		//Where the object is found; Values:Front, Back, Left, Right
		Distance.location = "Front";
		//Distance of object from train; Value from 1 - 10 in km
		Distance.distance = 8;
		//gate malfunctioning is occurring or not; values: true & false
		Distance.gate = false;
		//distance of the train from the gate, value from 1 - 30 (km)
		Distance.gateDistance = 10;
		//GPS detected speed in km/h; values between 0 - 220 (km/hr), 
		//similar to the current speed
		GPS.actualSpeed = 100;
		//whether the object detected is alive; values: true or false
		Heat.living = false;
		//the speed of the live object, values between 0 - 90 km/hr
		Heat.living_speed = 10;
		//detects object around train; values: true and false
		Motion.object = false;
		//gives current speed of the train; 0 - 220 km/hr
		Wheels.currentSpeed = 110;
		//whether slippage occurs
		Wheels.slippage = true;
	}
}
