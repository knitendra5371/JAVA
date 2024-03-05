package testing;

import apple.laf.JRSUIUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

//class P{
//	int i=10;
//}
//class C extends P{
//	int j=20;
//}

interface X{
	int x=20;
	
}
public class Testing implements X{
	int x=30;
	public static void main(String[] args) throws IOException {
		Testing t =  new Testing();
		
		// TODO Auto-generated method stub
//		System.out.println(t.x);
//		int a=12_______14;
//		System.out.println("hi  "+a);
		
//		try {
//			
//			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//			char ch=(char)br.read();
//			System.out.println("this is a character "+ch);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		//int n=0b101;
		//System.out.println(n);
		
//		Scanner scan=new Scanner(System.in);
//		String s1="akash";
//		String s2=new String("Akash");
//		String s3=s1;
//		
//		System.out.println(s1.equalsIgnoreCase(s2));
//		System.out.println(s1==s3);
		/*if(s1.equals(s2)) {
			System.out.println("Equal");
		}else {
			System.out.println("not equal");
		}*/
		
//		P p=new C();
		
//		System.out.println(p.j);
		
//		System.out.println(p.i);


//		Scanner sc = new Scanner(System.in);
//
////		String str = sc.next();
//		char ch = sc.next().charAt(0);
////		System.out.println(str);
//		System.out.println(ch);

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////		String str = br.readLine();
//		char ch = (char)br.read();
////		System.out.println(str);
//		System.out.println(ch);
		String str1= "nitendra";
		String str2="nitendra";
		String str3= new String("nitendra");
		System.out.println("********************");

		System.out.println(str1.compareTo(str2));
		System.out.println(str1.equals(str2));
		System.out.println(str1.compareTo(str3));
		System.out.println(str2.equals(str3));
		System.out.println(str1==str2);
		System.out.println(str1==str3);

//		Hashtable
//		TreeMap
//		LinkedHashMap
			/*for(Season s:Season.values()){
				System.out.println((s+" => "+s.name())+" =>  "+s.value);
			}

		System.out.println("Index of WINTER is: "+Season.valueOf("WINTER").ordinal());
		System.out.println(Season.valueOf("WINTER"));*/

		IdentityHashMap<String,Integer> ihm=new IdentityHashMap<>(); // check ref i.e address i.e use == for comparing
		ihm.put("nitendra",1);
		ihm.put(new String("nitendra"),2);
		HashMap<String,Integer> hm=new HashMap<>(); // check data i.e use equals() method for comparing
		hm.put("nitendra",1);
		hm.put(new String("nitendra"),2);
		System.out.println("IdentityHashMap"+" => "+ihm);
		System.out.println("HashMap"+" => "+hm);

		WeakHashMap<String,Integer> whm=new WeakHashMap<>();
		String neet="Nitendra";
		String jeet = new String("Jitendra");
		whm.put(neet,1);
		whm.put(jeet,2);
		jeet=null;
		System.gc();
		System.out.println("WeakHashMap ==> "+whm);


		BiFunction<Float, Float, Float> adder3 = Testing::add;

		float result3 = adder3.apply(10.0f, 20.0f);

		System.out.println("Result =>  "+result3);


		int[] ints = IntStream.range(1, 31).toArray();

		System.out.println(Arrays.toString(ints));


	}
	public static float add(float a,float b){
		return a+b;
	}
	enum Season { WINTER(5), SPRING(10), SUMMER(15), FALL(20);
		int value;
		Season(int value){
			this.value=value;
		}
	}
	public int[] m(){
		return new int[]{1, 2};
	}

}
