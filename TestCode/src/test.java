import Auto.FieldState;
import conditions.FieldStateCondition;
import conditions.TestCondition;

public class test {
	public static void main(String args[]) {
		TestCondition tc = new TestCondition(false);
		TestCondition tc2 = new TestCondition(true);
		TestCondition tc3 = new TestCondition(true);
		

		System.out.println(tc.compareConditon(tc2));
		System.out.println(tc.compareConditon(tc));
		System.out.println(tc2.compareConditon(tc));
		System.out.println(tc2.compareConditon(tc2));
		System.out.println(tc2.compareConditon(tc3));
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

		System.out.println(fsc.compareConditon(fsc1));
		System.out.println(fsc.compareConditon(fsc2));
		System.out.println(fsc.compareConditon(fsc3));
		System.out.println(fsc.compareConditon(fsc));

		System.out.println(fsc1.compareConditon(fsc1));
		System.out.println(fsc1.compareConditon(fsc2));
		System.out.println(fsc1.compareConditon(fsc3));
		System.out.println(fsc1.compareConditon(fsc));

		System.out.println(fsc2.compareConditon(fsc1));
		System.out.println(fsc2.compareConditon(fsc2));
		System.out.println(fsc2.compareConditon(fsc3));
		System.out.println(fsc2.compareConditon(fsc));

		System.out.println(fsc3.compareConditon(fsc1));
		System.out.println(fsc3.compareConditon(fsc2));
		System.out.println(fsc3.compareConditon(fsc3));
		System.out.println(fsc3.compareConditon(fsc));
	}
}
