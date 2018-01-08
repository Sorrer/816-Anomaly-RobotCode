
public class ClassSharing {
	public static void main(String args[]) {
		ClassOne co = new ClassOne();
		ClassTwo ct = new ClassTwo();

		ChangeClassOne cco = new ChangeClassOne(co, ct);
		ChangeClassTwo cct = new ChangeClassTwo(co, ct);
		
		cco.run();
		
		cct.run();
		
		cct.run();
		
		cco.run();
	}
}


 class ClassOne {
	 String string = "";
	 
	 public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public ClassOne() {
		 
	 }
	 
}
 class ClassTwo {

	 String string = "";
	 
	 public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	
	public ClassTwo() {
		
	}
}
 
 class ChangeClassOne{
	 
	 ClassOne one;
	 ClassTwo two;
	 
	 public ChangeClassOne(ClassOne one, ClassTwo two) {
		 this.one = one;
		 this.two = two;
	 }
	 
	 public void run() {
		 two.setString(two.getString() + "CC1");
		 one.setString(one.getString() + "CC1");
		 System.out.println(two.getString());
		 System.out.println(one.getString());
	 }
 }
 
 class ChangeClassTwo{
	 
	 ClassOne one;
	 ClassTwo two;
	 
	 public ChangeClassTwo(ClassOne one, ClassTwo two) {
		 this.one = one;
		 this.two = two;
	 }
	 
	 public void run() {
		 two.setString(two.getString() + "CC2");
		 one.setString(one.getString() + "CC2");
		 System.out.println(two.getString());
		 System.out.println(one.getString());
	 }
	 
 }