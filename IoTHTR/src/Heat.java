public class Heat {
	public static boolean living;
	public static double living_speed; // negative number indicates moving away, 
	public static boolean heatDamage;								   //  positive number indicates moving forward

	public static void returnInfo() {
		//random damage
		int x = (int) (1000*Math.random());
		if(x == 0){
			heatDamage = true;}
		else{
			heatDamage = false;}
		//random object alive
		int y = (int) (10*Math.random());
		living_speed = (100*Math.random());
		if(y==0){
			living = true;
		}
		else{
			living = false;
		}
	}
}
