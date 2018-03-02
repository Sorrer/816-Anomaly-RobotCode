package drive;

public class Config {

	//DRIVE
	
	//Calculate Required CurveTimings
	
		//Time to get from 0% - 100% in MilliSeconds (It's supposed to do that, but with the current values, it goes via curved values instead of normal values, so the data is off)
	private static int fullPowerTargetTiming = 500;
	
	//Curve variables
		
		//Amount of progression per increment
	public static float CURVE_INCREMENTS_AMOUNT = 0.01f;
	
		//MS Between the curve
	public static int CURVE_INCREMENTS_TIMING =  (int) ( fullPowerTargetTiming/(1 / CURVE_INCREMENTS_AMOUNT));
	
		//How the curve should be using exponents
	public static float CURVE_AMOUNT = 1.5f;
	
	
}
