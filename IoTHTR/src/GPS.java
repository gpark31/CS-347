public class GPS {
	public static double actualSpeed;
	public static boolean GPSDamage;

	public static void returnInfo() {
		//random actual speed
		actualSpeed = (220*Math.random());
		//random damage to the sensor
		int x=(int) (1000*Math.random());
		if(x==0)
			GPSDamage = true;
		else
			GPSDamage = false;
	}
}
