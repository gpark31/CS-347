public class Motion {
	public static boolean object;
	public static boolean MotionDamage;

	
	public static void returnInfo() {
		//random damage
		int x=(int) (1*Math.random());
		if(x==0) {
			MotionDamage = true;
		}
		else {
			MotionDamage = false;
		}
		//random motion
		int y=(int) (10*Math.random());
		if(y==0)
			 object = true;
		else
			object = false;
	}
}
