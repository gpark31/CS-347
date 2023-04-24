import javax.swing.*;
import  java.util.concurrent.TimeUnit;

public class IoTHTR {
	static public boolean log_in = false;;
	static public String user = "user";
	static public String password = "password";
	
	//LOG-IN
	public static void start(){
		log_in = true;
		System.out.println("________________________________________________");
		System.out.println("____________________IoT HTR ____________________");
		System.out.println("________________Log-in Successful_______________");
		System.out.println("________________________________________________");
	}
	public static void deactivate(){
		log_in = false;
		System.out.println("________________________________________________");
		System.out.println("____________________IoT HTR ____________________");
		System.out.println("________________Log-out Successful______________");
		System.out.println("________________________________________________");
	}
	//SPEED
	public static void setSpeed(double speed, double distance, String s) throws InterruptedException{
		if(speed > 220 || speed < 0 || distance < 0){
			System.out.println("Invalid parameters");
		}
		else{
			if(Wheels.currentSpeed == speed){
				keepCurrentSpeed(speed);
			}
			else if(Wheels.currentSpeed < speed){
				increaseSpeed(speed, distance, s);
			}
			else{
				decreaseSpeed(speed, distance, s);
			}
		}
	}
	public static void keepCurrentSpeed(double speed){
		Wheels.currentSpeed = speed;
	}
	public static void increaseSpeed(double speed, double distance, String s) throws InterruptedException{
		double val = (speed - Wheels.currentSpeed)/(distance -0.5);
		while(Wheels.currentSpeed < speed && distance > 0){
			Wheels.currentSpeed+= val;
			distance++;
			Distance.distance = distance;
			System.out.println("-----------------------------------------------");
			ControlPanel.displaySpeed();
			System.out.println("Distance to " + s +": " + String.format("%.2f", Distance.distance) + " km");
			TimeUnit.SECONDS.sleep(1);
		}
	}
	public static void decreaseSpeed(double speed, double distance, String s) throws InterruptedException{
		double val = (Wheels.currentSpeed - speed)/(distance -0.5);
		while(Wheels.currentSpeed > speed && distance > 1.5){
			Wheels.currentSpeed -= val;
			distance--;
			Distance.distance = distance;
			System.out.println("-----------------------------------------------");
			if(Wheels.currentSpeed < val){
				System.out.println("Current speed: 0.00 km/h");
			}
			else{
				ControlPanel.displaySpeed();
			}
			System.out.println("Distance to " + s +": "  + String.format("%.2f", Distance.distance) + " km");
			TimeUnit.SECONDS.sleep(1);
		}
	}
	public static void slippageSpeed(int rpm) throws InterruptedException{
		//change RPM and change currentSpeed to equal to actual Speed
		System.out.println("Actual Speed: " + String.format("%.2f", GPS.actualSpeed) + " km/h");
		System.out.println("Current speed: " + String.format("%.2f", Wheels.currentSpeed) + " km/h");
		System.out.println("Current RPM: " + rpm);
		
		System.out.println("------------------------------------------------");
		System.out.println("Adjusting RPM and current speed.");
		System.out.println("------------------------------------------------");
		
		TimeUnit.SECONDS.sleep(1);

		Wheels.calRPM(GPS.actualSpeed);
		Wheels.currentSpeed = GPS.actualSpeed;
		System.out.println("Actual speed and current speed match");
		System.out.println("Current speed: " + String.format("%.2f", Wheels.currentSpeed) + " km/h");
		System.out.println("Current RPM: " + Wheels.RPM);
	}
	public static void enterEmergency() {
		System.out.println("------------------------------------------------");
		System.out.println("Entering Emergency Mode.");
		System.out.println("Coming to a complete stop.");
		Wheels.currentSpeed = 0;
	}
}