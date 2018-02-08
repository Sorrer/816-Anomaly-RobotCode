package Auto;


public class FieldState { // mock fieldstate class
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
		}else if(position == 'N'){
			return PositionState.NONE;
		}else {
			return PositionState.NONE;
		}
		
	}
	
	PositionState startPosition = PositionState.NONE;
	
	public void setStartinPosition(PositionState state) {
		this.startPosition = state;
	}
	
	public PositionState getStartingPosition() {
		return this.startPosition;
	}	
	
	/**
	 * 
	 * @param fs FieldState
	 * @return If R = R L = L N = ANYTHING = true
	 */
	public boolean compare(FieldState fs) {
		if(compareAllySwitch(fs)) {
			if(compareScaleSwitch(fs)) {
				if(compareEnemySwitch(fs)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean compareAllySwitch(FieldState fs) {
		if(fs.getAllySwitch() == PositionState.NONE || this.getAllySwitch() == PositionState.NONE) {
			return true;
		}else if(fs.getAllySwitch() == this.getAllySwitch()) {
			return true;
		}
		return false;
	}

	private boolean compareScaleSwitch(FieldState fs) {
		if(fs.getScale() == PositionState.NONE || this.getScale() == PositionState.NONE) {
			return true;
		}else if(fs.getScale() == this.getScale()) {
			return true;
		}
		return false;
	}
	
	private boolean compareEnemySwitch(FieldState fs) {
		if(fs.getEnemySwitch() == PositionState.NONE || this.getEnemySwitch() == PositionState.NONE) {
			return true;
		}else if(fs.getEnemySwitch() == this.getEnemySwitch()) {
			return true;
		}
		return false;
	}
}
