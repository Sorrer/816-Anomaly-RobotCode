package drive;

import org.usfirst.frc.team816.robot.controlling.AccelerationCurve;

public class Main {
	public static void main(String args[]) {
		AccelerationCurve curve  = new AccelerationCurve(Config.CURVE_AMOUNT, Config.CURVE_INCREMENTS_AMOUNT, Config.CURVE_INCREMENTS_TIMING);
		double curved = curve.convertNormal(0);

		runTest(0.25, curve);
		runTest(0.5, curve);
		runTest(0.75, curve);
		runTest(1, curve);
		runTest(0.75, curve);
		runTest(0.50, curve);
		runTest(0.25, curve);
		runTest(-0.50, curve);
		runTest(0, curve);
		runTest(1, curve);
	}
	
	public static double createTarget(double targetValue, double curve) {
		double value = Math.pow(targetValue, curve);
		
		if(targetValue < 0 && value > 0) {
			return -value;
		}
		
		return value;
	}
	
	public static void runTest(double target, AccelerationCurve curve) {
		
		long start = System.currentTimeMillis();
		
		double test = curve.convertNoCurve(target);
		double targetValue = createTarget(target, Config.CURVE_AMOUNT);
		while( test != target) {
			test = curve.convertNoCurve(target);
			//System.out.println("Test input: " + target + " TargetValue: " + targetValue + " Current:" + test + " Elapsed Time: " + (((double) (System.currentTimeMillis() - start))/1000) + " seconds");
		}
		
		System.out.println("Test input: " + target + " TargetValue: " + targetValue + " Current:" + test + " Elapsed Time: " + (((double) (System.currentTimeMillis() - start))/1000) + " seconds");
	
		
		
	}
}
