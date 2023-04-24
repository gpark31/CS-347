import javax.swing.*;
import java.awt.*;
import java.util.*;
import  java.util.concurrent.TimeUnit;

public class ControlPanel {
	public static void displaySpeed() {
		System.out.println("Current speed: "+ String.format("%.2f",Wheels.currentSpeed) + " km/h");
	}
	public static void displaySpeedF(JFrame frame) {
		System.out.println("Current speed: "+ String.format("%.2f",Wheels.currentSpeed) + " km/h");
		JLabel cs = new JLabel();
		cs.setText("<html>Current speed: "+ String.format("%.2f",Wheels.currentSpeed) + " km/h<html>");
		cs.setBounds(50, 10, 300, 30);
		cs.setFont(new Font("Serif", Font.PLAIN, 20));
		cs.setBackground(Color.WHITE);
		frame.add(cs);
	}
	public static void displayObjectLocation(JFrame frame) {
		if(!Distance.DistanceDamage) {
			System.out.println("Location: [" + Distance.location + "] Distance: " +
					String.format("%.2f", Distance.distance) + " km");
			JLabel cs = new JLabel("<html>Location: ["+  Distance.location + "]<br/>" +
					"Distance: " + String.format("%.2f",Distance.distance) + " km<html>");
			cs.setFont(new Font("Serif", Font.PLAIN, 20));
			cs.setBounds(330, 60, 300, 50);
			frame.add(cs);
		}
	}

	public static void displayMoving(JFrame frame) {
		if(!Motion.MotionDamage) {
			if(Motion.object && !Heat.living && Wheels.currentSpeed > 5){
				System.out.println("Warning, object detected.");
				JLabel dm = new JLabel("<html>Warning, object detected.<html>");
				gui.addImage("warning");
				dm.setBounds(50, 60, 400, 30);
				dm.setForeground(Color.BLUE);
				dm.setFont(new Font("Serif", Font.PLAIN, 20));
				frame.add(dm);
				displayObjectLocation(frame);
			}
			else if(Heat.living && Wheels.currentSpeed > 0){
				System.out.println("Warning, living object detected.");
				JLabel dm = new JLabel("<html>Warning, living object detected.<html>");
				dm.setBounds(50, 60, 400, 30);
				dm.setForeground(Color.BLUE);
				dm.setFont(new Font("Serif", Font.PLAIN, 20));
				gui.addImage("warning");
				frame.add(dm);
				displayObjectLocation(frame);
			}
			else{
				System.out.println("No object detected.");
				JLabel dm = new JLabel("<html>No object detected.<html>");
				dm.setBounds(50, 60, 400, 30);
				dm.setFont(new Font("Serif", Font.PLAIN, 20));
				frame.add(dm);
			}
		}
		else {
			System.out.println("Motion sensor malfunction.");
			JLabel dm = new JLabel("<html>Motion sensor malfunction.<html>");
			dm.setBounds(50, 60, 400, 30);
			gui.addImage("emergency");
			dm.setFont(new Font("Serif", Font.PLAIN, 20));
			dm.setForeground(Color.RED);
			frame.add(dm);
		}
	}
	public static void displaySlipping(JFrame frame) {
		if(!Wheels.WheelsDamage) {
			if(Wheels.slippage && Wheels.currentSpeed > 10) {
				System.out.println("Warning: slippage detected.");
				JLabel dm = new JLabel("<html>Warning: slippage detected.<html>");
				dm.setBounds(50, 155, 400, 30);
				gui.addImage("warning");
				dm.setFont(new Font("Serif", Font.PLAIN, 20));
				dm.setForeground(Color.BLUE);
				frame.add(dm);
			}
			else{
				System.out.println("No slippage detected.");
				JLabel dm = new JLabel("<html>No slippage detected.<html>");
				dm.setBounds(50, 155, 400, 30);
				dm.setFont(new Font("Serif", Font.PLAIN, 20));
				frame.add(dm);
			}
		}
		else {
			System.out.println("Wheel sensor malfunction.");
			JLabel dm = new JLabel("<html>Wheel sensor malfunction.<html>");
			dm.setBounds(50, 155, 400, 30);
			dm.setFont(new Font("Serif", Font.PLAIN, 20));
			gui.addImage("emergency");
			dm.setForeground(Color.RED);
			frame.add(dm);
		}
	}
	public static void displayGate(JFrame frame){
		if(!Distance.DistanceDamage) {
			if(Distance.gate && Wheels.currentSpeed > 0){
				System.out.println("Gate malfunction detected.");
				JLabel gate = new JLabel("<html>Gate malfunction detected.<html>");
				gate.setBounds(50, 110, 400, 30);
				gui.addImage("emergency");
				gate.setFont(new Font("Serif", Font.PLAIN, 20));
				gate.setForeground(Color.RED);
				frame.add(gate);
			}
			else{
				System.out.println("No gate malfunction detected.");
				JLabel gate = new JLabel("<html>No gate malfunction detected.<html>");
				gate.setBounds(50, 110, 400, 30);
				gate.setFont(new Font("Serif", Font.PLAIN, 20));
				frame.add(gate);
			}
		}
		else{
			System.out.println("Distance sensor malfunction.");
			JLabel gate = new JLabel("<html>Distance sensor malfunction.<html>");
			gate.setBounds(50, 110, 400, 30);
			gate.setFont(new Font("Serif", Font.PLAIN, 20));
			gui.addImage("emergency");
			gate.setForeground(Color.red);
			frame.add(gate);
		}
	}
	public static void displayGPSInfo(JFrame frame) {
		if(!GPS.GPSDamage) {
			if(Wheels.currentSpeed > 0){
				System.out.println("Actual Speed is: " + String.format("%.2f", GPS.actualSpeed) + " km/h");
				JLabel cs = new JLabel("<html>Actual Speed is: " + String.format("%.2f", GPS.actualSpeed)
						+ " km/h<html>");
				cs.setBounds(50, 200, 300, 30);
				cs.setFont(new Font("Serif", Font.PLAIN, 20));
				frame.add(cs);
			}
		}
		else{
			System.out.println("GPS malfunction.");
			JLabel gate = new JLabel("<html>GPS malfunction.<html>");
			gate.setBounds(50, 200, 300, 30);
			gui.addImage("emergency");
			gate.setFont(new Font("Serif", Font.PLAIN, 20));
			gate.setForeground(Color.red);
			frame.add(gate);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// enter password
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String username = input.nextLine();
		System.out.print("Enter Password: ");
		String password = input.nextLine();

		if(username.compareTo(IoTHTR.user) == 0){
			if(password.compareTo(IoTHTR.password) == 0){
				System.out.println("Loading.....");
				TimeUnit.SECONDS.sleep(1);
				IoTHTR.start();
			}
		} 
		else{
			System.out.println("Incorrect Password or Username.");
			System.exit(1);
		}
		while(IoTHTR.log_in){
			gui.startGui();
			String log_out = input.nextLine();
			if(log_out.compareTo("exit") == 0){
				input.close();
				IoTHTR.deactivate();
				System.exit(0);
			}
			else{
				//if not testing, input random values
				if(!test.testing){
					GPS.returnInfo();
					Wheels.returnInfo();
					Heat.returnInfo();
					Motion.returnInfo();
					Distance.returnInfo();
				}
				else{
					test.testValues();
				}
				//JFrame.frame
				//set the random variables
				displaySpeedF(gui.frame);
				displayMoving(gui.frame);
				displayGate(gui.frame);
				displaySlipping(gui.frame);
				displayGPSInfo(gui.frame);
				//JFrame Display
				if(Distance.DistanceDamage || GPS.GPSDamage || Heat.heatDamage || Motion.MotionDamage ||
						Wheels.WheelsDamage){
					IoTHTR.enterEmergency();
					JLabel emergency = new JLabel("<html>EMERGENCY COMING TO A COMPLETE STOP.<html>");
					gui.addImage("emergency");
					emergency.setFont(new Font("Serif", Font.PLAIN, 20));
					emergency.setBounds(50, 300, 450, 30);
					emergency.setForeground(Color.red);
					gui.frame.add(emergency);
				}
				if(!Distance.gate && Distance.gateDistance <= 10 && !Distance.DistanceDamage){
					System.out.println("-----------------------------------------------");
					System.out.println("Distance to gate: " + String.format("%.2f", Distance.gateDistance) + " km");
					System.out.println("Conductor, honk the horn.");
					System.out.println("-----------------------------------------------");
					JLabel gateD = new JLabel("<html>Distance to gate = " +
							String.format("%.2f", Distance.gateDistance) + " km <br/> Conductor, honk the horn <html>");
					gateD.setBounds(50, 350, 400, 50);
					gateD.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.addImage("honk");
					gui.frame.add(gateD);
				}
				if(Distance.gate && (Motion.object || Heat.living)) {
					if(Distance.gateDistance > Distance.distance) {
						Distance.gate = false;
					}
					else {
						Motion.object = false;
						Heat.living = false;
					}
				}
				if(!Motion.MotionDamage && !Heat.living && Motion.object && Wheels.currentSpeed > 0 &&
						Distance.location.equals("Front")){
					System.out.println("\nReducing speed and coming to a complete stop.");
					IoTHTR.setSpeed(0, Distance.distance, "object");
					JLabel motion = new JLabel("<html>Motion Detected. Reducing speed and coming to a complete stop." +
							" <br/> " + String.format("%.2f", Distance.distance) + " km to object<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					motion.setForeground(Color.red);
					gui.frame.add(motion);
				}
				//living object detected at the front
				else if(Heat.living && Wheels.currentSpeed > 0 && Distance.location.equals("Front") && !Heat.heatDamage){
					System.out.println("\nReducing speed and coming to a complete stop.");
					IoTHTR.setSpeed(0, Distance.distance, "living object");
					JLabel motion = new JLabel("<html>Motion Detected. Reducing speed and coming to a complete stop." +
							" <br/> " + String.format("%.2f", Distance.distance) + " km to alive object<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					motion.setForeground(Color.red);
					gui.frame.add(motion);
				}
				//living object detected at the back
				else if(Heat.living && Wheels.currentSpeed > 0 && Distance.location.equals("Back") &&
						Heat.living_speed > 0 && !Heat.heatDamage){
					System.out.println("\nIncreasing speed to avoid collision. \nLiving Object Speed: " +
							String.format("%.2f", Heat.living_speed) + " km/h" );
					JLabel motion = new JLabel("<html>Increasing speed to avoid collision.<br/>" +
							"Living Object Speed: " + String.format("%.2f", Heat.living_speed) + " km/h<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.frame.add(motion);
					double newSpeed = Wheels.currentSpeed + Heat.living_speed;
					if (newSpeed > 220){
						newSpeed = 220;
					}
					IoTHTR.setSpeed(newSpeed, Distance.distance, "living object");
				}
				//living object detected right
				else if(Heat.living && Wheels.currentSpeed > 0 && Distance.location.equals("Right")
						&& Heat.living_speed > 0 && Distance.distance > 5  && !Heat.heatDamage){
					System.out.println("\nIncreasing speed to avoid collision. \nLiving Object Speed: " +
							String.format("%.2f", Heat.living_speed) + " km/h" );
					JLabel motion = new JLabel("<html>Increasing speed to avoid collision.<br/>" +
							"Living Object Speed: " + String.format("%.2f", Heat.living_speed) + " km/h<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.frame.add(motion);
					double newSpeed = Wheels.currentSpeed + Heat.living_speed;
					if (newSpeed > 220){
						newSpeed = 220;
					}
					IoTHTR.setSpeed(newSpeed, Distance.distance, "living object");
				}
				//living object detected right & close
				else if(Heat.living && Wheels.currentSpeed > 0 && Distance.location.equals("Right")
						&& Heat.living_speed > 0 && Distance.distance <= 5  && !Heat.heatDamage){
					System.out.println("\nDecreasing speed to avoid collision or reduce injury. \nLiving Object Speed: "
							+ String.format("%.2f", Heat.living_speed) + " km/h" );
					IoTHTR.setSpeed(0, Distance.distance, "living object");
					JLabel motion = new JLabel("<html>Decreasing speed to avoid collision or reduce injury.<br/>" +
							"Living Object Speed: " + String.format("%.2f", Heat.living_speed) + " km/h<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.frame.add(motion);
				}
				//living object detected left
				else if(Heat.living && Wheels.currentSpeed > 0 && Distance.location.equals("Left")
						&& Heat.living_speed > 0 && Distance.distance > 5  && !Heat.heatDamage){
					System.out.println("\nIncreasing speed to avoid collision. \nLiving Object Speed: " +
							String.format("%.2f", Heat.living_speed) + " km/h" );
					JLabel motion = new JLabel("<html>Increasing speed to avoid collision.<br/>Living Object Speed:" +
							" " + String.format("%.2f", Heat.living_speed) + " km/h<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.frame.add(motion);
					double newSpeed = Wheels.currentSpeed + Heat.living_speed;
					if (newSpeed > 220){
						newSpeed = 220;
					}
					IoTHTR.setSpeed(newSpeed, Distance.distance, "living object");
				}
				//living object detected left & close
				else if(Heat.living && Wheels.currentSpeed > 0 && Distance.location.equals("Left")
						&& Heat.living_speed > 0 && Distance.distance <= 5  && !Heat.heatDamage){
					System.out.println("\nDecreasing speed to avoid collision or reduce injury. \nLiving Object Speed: "
							+ String.format("%.2f", Heat.living_speed) + " km/h" );
					IoTHTR.setSpeed(0, Distance.distance, "living object");
					JLabel motion = new JLabel("<html>Decreasing speed to avoid collision or reduce injury.<br/>" +
							"Living Object Speed: "  + String.format("%.2f", Heat.living_speed) + " km/h<html>");
					motion.setBounds(50, 450, 600, 60);
					motion.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.frame.add(motion);
				}
				//gate malfunction detected
				else if(Distance.gate && !Distance.DistanceDamage && !GPS.GPSDamage){
					System.out.println("\nReducing speed and coming to a complete stop.");
					IoTHTR.setSpeed(0, Distance.gateDistance, "gate");
					JLabel gate = new JLabel("<html>Reducing speed and coming to a complete stop. " +
							"<br/>Distance to gate: " + String.format("%.2f", Distance.gateDistance) + " km<html>");
					gate.setBounds(50, 500, 600, 30);
					gate.setFont(new Font("Serif", Font.PLAIN, 100));
					gui.frame.add(gate);
				}
				else if(Wheels.slippage && !Wheels.WheelsDamage){
					System.out.println("Slippage occurring. Reducing Speed.");
					Wheels.calRPM(Wheels.currentSpeed);
					IoTHTR.slippageSpeed(Wheels.RPM);
					JLabel slip = new JLabel("<html>Slippage occurring. Reducing Speed. Adjusting the RPM.<html>");
					slip.setBounds(50, 550, 500, 30);
					slip.setFont(new Font("Serif", Font.PLAIN, 20));
					gui.frame.add(slip);
				}
				gui.frame.setVisible(true);
				System.out.println("________________________________________________");
				String end_gui = input.nextLine();
				if(end_gui.compareTo("exit") == 0){
					input.close();
					IoTHTR.deactivate();
					System.exit(0);
				}
				else if(end_gui.compareTo("exit") != 0){
					gui.endGui();}
			}

		}
	}
}
