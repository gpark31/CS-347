public class Wheels {
	public static double currentSpeed;
	public static boolean slippage;
	public static int RPM;
	public static boolean WheelsDamage;
	
	//return speed
	public static void returnInfo() {
		//random damate
		int x=(int) (1000*Math.random());
		if(x==0) {
			WheelsDamage = true;
		}
		else{
			WheelsDamage = false;}
		//random speed
		double diff = (10*Math.random());
		currentSpeed = GPS.actualSpeed + diff;
		if (Math.abs(Wheels.currentSpeed - GPS.actualSpeed) > 5){
			slippage = true;
		}
		else{
			slippage = false;
		}
	}
	public static void calRPM(double speed){
		RPM = (int)((speed/60 * 1000)/(2*3.14));
	}
}
	

