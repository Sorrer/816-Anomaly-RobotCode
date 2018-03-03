

public class AnomalyTime {
	
	int target;
	long current = 0;
	long goal = 0;
	
	int goalspast = 0;
	
	boolean started = false;
	
	public AnomalyTime(int target) {
		this.target = target;
	}
	
	/**
	 * Transfers the amount of times the goal was surpassed with the timeframe
	 */
	public int transfer() {
		int returnGoals = this.goalspast;
		this.goalspast = 0;
		return returnGoals;
	}
	
	public void start() {
		this.goalspast = 0;
		this.current = System.currentTimeMillis();
		this.goal = this.current + this.target;
		this.started = true;
	}
	
	public void setTiming(int timing) {
		if(started) {
			this.goal += (timing - this.target);
			this.target = timing;
		}else {
			this.target = timing;
		}
	}
	
	public void update() {
		if(!started) {
			System.out.println("Automatically starting because update was called before start");
			this.start();
		}
		
		int i = 0;
		
		long tempGoal = this.goal;
		current = System.currentTimeMillis();
		while(current > tempGoal) {
			tempGoal += this.target;
			i++;
		}
		
		if(i > 0) {
			this.goalspast += i;
			this.current = (tempGoal - current) + System.currentTimeMillis();
			this.goal = this.current + this.target;
		}
	}
}
