package compInterviews;
class A{
	int x;
//	A(int x){
//		this.x=x;
//	}
	public static void m() {
		System.out.println("lol");
	}
	public void m2() {
		System.out.println("m2");
	}
}
public class Demo {

	public static void main(String[] args) {
		A a=new A();
		a.m();
		a.m2();
	}

}
