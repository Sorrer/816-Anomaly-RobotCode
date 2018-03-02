import Auto.AutoPath;
import Auto.Conditions;
import Auto.FieldState;
import Auto.Goal;
import Auto.PositionState;
import Auto.routes.RouteLeftScale;
import Auto.routes.RouteLeftSwitch;
import conditions.FieldStateCondition;
import conditions.GoalCondition;
import conditions.StartingPositionCondition;
import conditions.TestCondition;

public class test {
	
	
	
	
	
	
	
	public static void main(String args[]) {
		TestCondition tc = new TestCondition(false);
		TestCondition tc2 = new TestCondition(true);
		TestCondition tc3 = new TestCondition(true);
		

		System.out.println(tc.compareCondition(tc2));
		System.out.println(tc.compareCondition(tc));
		System.out.println(tc2.compareCondition(tc));
		System.out.println(tc2.compareCondition(tc2));
		System.out.println(tc2.compareCondition(tc3));
		System.out.println("///////////////////////");
		
		FieldState fs = new FieldState();
		fs.setFieldState("RRL");
		FieldState fs1 = new FieldState();
		fs1.setFieldState("RLR");
		FieldState fs2 = new FieldState();
		fs2.setFieldState("LLR");
		FieldState fs3 = new FieldState();
		fs3.setFieldState("NNN");

		FieldStateCondition fsc = new FieldStateCondition(fs);

		FieldStateCondition fsc1 = new FieldStateCondition(fs1);

		FieldStateCondition fsc2 = new FieldStateCondition(fs2);

		FieldStateCondition fsc3 = new FieldStateCondition(fs3);

		System.out.println(fsc.compareCondition(fsc1));
		System.out.println(fsc.compareCondition(fsc2));
		System.out.println(fsc.compareCondition(fsc3));
		System.out.println(fsc.compareCondition(fsc));

		System.out.println(fsc1.compareCondition(fsc1));
		System.out.println(fsc1.compareCondition(fsc2));
		System.out.println(fsc1.compareCondition(fsc3));
		System.out.println(fsc1.compareCondition(fsc));

		System.out.println(fsc2.compareCondition(fsc1));
		System.out.println(fsc2.compareCondition(fsc2));
		System.out.println(fsc2.compareCondition(fsc3));
		System.out.println(fsc2.compareCondition(fsc));

		System.out.println(fsc3.compareCondition(fsc1));
		System.out.println(fsc3.compareCondition(fsc2));
		System.out.println(fsc3.compareCondition(fsc3));
		System.out.println(fsc3.compareCondition(fsc));
		
		System.out.println("///////////////////////");
		fs.setStartinPosition(PositionState.NONE);
		fs2.setStartinPosition(PositionState.LEFT);
		fs3.setStartinPosition(PositionState.RIGHT);
		fs1.setStartinPosition(PositionState.LEFT);

		
		
		
		StartingPositionCondition spc = new StartingPositionCondition(fs);
		StartingPositionCondition spc1 = new StartingPositionCondition(fs1);
		StartingPositionCondition spc2 = new StartingPositionCondition(fs2);
		StartingPositionCondition spc3 = new StartingPositionCondition(fs3);

		System.out.println(spc.compareCondition(spc));
		System.out.println(spc.compareCondition(spc1));
		System.out.println(spc.compareCondition(spc2));
		System.out.println(spc.compareCondition(spc3));
		
		System.out.println(spc1.compareCondition(spc));
		System.out.println(spc1.compareCondition(spc1));
		System.out.println(spc1.compareCondition(spc2));
		System.out.println(spc1.compareCondition(spc3));
		
		System.out.println(spc2.compareCondition(spc));
		System.out.println(spc2.compareCondition(spc1));
		System.out.println(spc2.compareCondition(spc2));
		System.out.println(spc2.compareCondition(spc3));
		
		System.out.println(spc3.compareCondition(spc));
		System.out.println(spc3.compareCondition(spc1));
		System.out.println(spc3.compareCondition(spc2));
		System.out.println(spc3.compareCondition(spc3));

		System.out.println("///////////////////////");

		
		Goal g = Goal.NONE;
		Goal g1 = Goal.SCALE;
		Goal g2 = Goal.SWITCH;
		Goal g3 = Goal.BOX;
		
		GoalCondition gc = new GoalCondition(g);
		GoalCondition gc1 = new GoalCondition(g1);
		GoalCondition gc2 = new GoalCondition(g2);
		GoalCondition gc3 = new GoalCondition(g3);
		
		System.out.println(gc.compareCondition(gc));
		System.out.println(gc.compareCondition(gc1));
		System.out.println(gc.compareCondition(gc2));
		System.out.println(gc.compareCondition(gc3));
		
		System.out.println(gc1.compareCondition(gc));
		System.out.println(gc1.compareCondition(gc1));
		System.out.println(gc1.compareCondition(gc2));
		System.out.println(gc1.compareCondition(gc3));
		
		System.out.println(gc2.compareCondition(gc));
		System.out.println(gc2.compareCondition(gc1));
		System.out.println(gc2.compareCondition(gc2));
		System.out.println(gc2.compareCondition(gc3));
		
		System.out.println(gc3.compareCondition(gc));
		System.out.println(gc3.compareCondition(gc1));
		System.out.println(gc3.compareCondition(gc2));
		System.out.println(gc3.compareCondition(gc3));

		gc2.setValue(fsc1.getValue());
		
		System.out.println("///////////////////////");

		AutoPath a = new AutoPath();
		Conditions c = new Conditions();
	
		
		a.init();
		a.setRouteList();
		c.initCurrent();

		c.setFieldState("LLL");
		c.setStartinPosition(PositionState.LEFT);
		c.setGoal(Goal.SWITCH);
				
		System.out.println(c.getConditionsList());

 // should return RouteLeftSwitch
		
		System.out.println(c.g);
		System.out.println(a.pathfind(c));
		System.out.println("///////////////////////");

		RouteLeftSwitch rls = new RouteLeftSwitch();
		RouteLeftScale rlsc = new RouteLeftScale();
		rls.init();
		rlsc.init();
		
		System.out.println("??????????????");
		System.out.println(c.compareConditionsList(rlsc.getConditions()));
		System.out.println(c.compareConditionsList(rls.getConditions()));

		GoalCondition gc11 = new GoalCondition(Goal.NONE);
		GoalCondition gc22 = new GoalCondition(Goal.NONE);
		
		System.out.println(gc11.compareCondition(gc22));
	}
}
