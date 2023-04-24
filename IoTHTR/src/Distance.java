public class Distance {
	public static String location;
	public static double distance;
	public static boolean gate;
	public static double gateDistance;
	public static boolean DistanceDamage;

	public static void returnInfo() {
		//random damage
		int x=(int) (100*Math.random());
		if(x==0)
			DistanceDamage = true;
		else
			//location setup
			DistanceDamage = false;
		String[] locations = {"Front", "Back", "Right", "Left"};
		int index=(int) (4*Math.random());
		int ran = (int)(2*Math.random());
		int gateRan = (int) (100*Math.random());
		location = locations[index];
		//distance setup
		if(ran == 0) {
			distance = 1.5 + (10 * Math.random());//10 kilometers max
		}
		else {
			distance = (10*Math.random());
		}
		gateDistance = (30*Math.random());
		//gate setup
		if(gateRan == 0){
			gate = true;
		}
		else{
			gate = false;
		}
	}
}
