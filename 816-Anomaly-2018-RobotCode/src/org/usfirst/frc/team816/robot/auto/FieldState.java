package org.usfirst.frc.team816.robot.auto;

public class FieldState {

	private PositionState AllySwitch = PositionState.NONE;
	private PositionState EnemySwitch = PositionState.NONE;
	private PositionState Scale = PositionState.NONE;
	
	/**
	 * Positions of the switchs and scale.
	 * MAKE SURE setFieldState() is called before using this class.
	 */
	public FieldState() {}
	
	/**
	 *  Sets the field state (Left or Right) of the enemy switch, ally switch, and the scale
	 * 
	 * 
	 * @param positions
	 * @return If successful
	 */
	
	public boolean setFieldState(String positions) {
		if(positions.length() != 3) return false;
		
		AllySwitch = this.convertCharToPosition(positions.charAt(0));
		Scale = this.convertCharToPosition(positions.charAt(1));
		EnemySwitch = this.convertCharToPosition(positions.charAt(2));

		if(AllySwitch == PositionState.NONE) { return false; }
		if(Scale == PositionState.NONE) { return false; }
		if(EnemySwitch == PositionState.NONE) { return false; }
		
		return true;
	}
	
	public PositionState getAllySwitch() {
		return this.AllySwitch;
	}
	
	public PositionState getScale() {
		return this.Scale;
	}
	
	public PositionState getEnemySwitch() {
		return this.EnemySwitch;
	}
	
	/**
	 *  L = Left | R = Right | ? = NONE
	 * @param position
	 * @return
	 */
	private PositionState convertCharToPosition(char position) {
		
		if(position == 'L') {
			return PositionState.LEFT;
		}else if(position == 'R') {
			return PositionState.RIGHT;
		}else {
			return PositionState.NONE;
		}
		
	}
}
