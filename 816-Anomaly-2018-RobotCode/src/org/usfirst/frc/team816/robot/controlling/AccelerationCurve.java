package org.usfirst.frc.team816.robot.controlling;

import org.usfirst.frc.team816.robot.AnomalyMaths;
import org.usfirst.frc.team816.robot.AnomalyTime;

/**
 * Curves value to objective
 */

public class AccelerationCurve {
	
	float curveAmount = 0f;
	float maxIncrements = 0f;
	float timeBetween = 0f; 
	
	AnomalyTime timer;
	
	/**
	 * 
	 * @param curveExponent currentValue^curveExponent
	 * @param maxIncrementAmount How big of iterations to make to acceleration value
	 * @param timeBetween what length of time should each iteration take (MS)
	 */
	public AccelerationCurve(float curveExponent, float maxIncrementAmount, int timeBetween) {
		this.curveAmount = curveExponent;
		this.maxIncrements = maxIncrementAmount;
		this.timeBetween = timeBetween;
		
		timer = new AnomalyTime(timeBetween);
	}
	
	double lastValue = 0;
	
	
	//Gets confusing, but simply it progresses towards the value
	
	/**
	 * Curves Before 
	 * @param value
	 * @return
	 */
	public double convert(double value) {
		boolean isNegative = false;
		timer.update();
		int iterations = timer.transfer();
		
		double curvedValue = Math.pow(value, this.curveAmount);
		
		double answer = 0;
		
		if(curvedValue > 0 && value < 0) {
			isNegative = true;
		}
		
		double lastV = lastValue;
		
		for(int i = 0; i < iterations; i++) {
			if(AnomalyMaths.withIn(lastValue, curvedValue, maxIncrements)) {
				this.lastValue = curvedValue;
				break;
			}
			
			//Heading towards value (Downwards)
			if(lastV > curvedValue) {
				lastValue -= this.maxIncrements;
			}
			
			//Heading towards value (Upwards)
			if(lastV < curvedValue) {
				lastValue += this.maxIncrements;
			}
			
		}
		
		answer = lastValue;
		
		if(isNegative) {
			return answer *= -1;
		}else {
			return answer;
		}
		
		
	}
	
	/**
	 * Curves after, more exact
	 * @param value
	 * @return
	 */
	public double convertNormal(double value) {
		
		timer.update();
		int iterations = timer.transfer();
		
		double answer = 0;
		
		for(int i = 0; i < iterations; i++){
			if(AnomalyMaths.withIn(lastValue, value, this.maxIncrements)) {
				this.lastValue = value;
				break;
			}
			
			if(lastValue < value) {
				lastValue += this.maxIncrements;
			}
			
			if(lastValue > value) {
				lastValue -= this.maxIncrements;
			}
		}
		
		answer = Math.pow(lastValue, this.curveAmount);
		
		if(lastValue < 0 && answer > 0 ) {
			return -answer;	
		}else {
			return answer;
		}
	
	
	}
	
	/**
	 * JUST DELAYS THE CURVES value
	 * @param value
	 * @return
	 */
	public double convertNoCurve(double value) {
		
		timer.update();
		int iterations = timer.transfer();
		
		for(int i = 0; i < iterations; i++){
			if(AnomalyMaths.withIn(lastValue, value, this.maxIncrements)) {
				this.lastValue = value;
				break;
			}
			
			if(lastValue < value) {
				lastValue += this.maxIncrements;
			}
			
			if(lastValue > value) {
				lastValue -= this.maxIncrements;
			}
		}
		
		return lastValue;
	
	
	}
	
	
}
