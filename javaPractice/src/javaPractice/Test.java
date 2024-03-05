package javaPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class Test {
	public static void main(String[] args)  throws Exception{
		
	/*	Sayble s= new Sayble() {
			
			@Override
			public void say1() {
				System.out.println("i m say2");
				
			}
			@Override
			public void say2() {
				System.out.println("i m say1");
				
			}
		};
		s.say1();
		s.say2();
		
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Runnable r1=()->System.out.println("i m runnable interface r1");*/
		
//		System.out.println("hello");
//		
//		String str1="nitendrakumar";
//		String str2="nitendrakumar";
//		if(str1==str2 ) {
//			System.out.println("SCT ===>> both r same");
//		}
//		
//		if(str1.equals(str2)) {
//			System.out.println("SCT2 ===>> both r same");
//		}
//		String str3=new String("Sidd");
//		String str4=new String("Sidd");
//		if(str3==str4 ) {
//			System.out.println("both r same");
//		}else {
//			System.out.println("both r not same");
//		}
//		
//		
//		if(str3.equals(str4)) {
//			System.out.println("same");
//		}
//		
//		System.out.println(10+20+"A");
//		
//		System.out.println("A"+10*20);
//		Optional
		
		
		String T="3[a]2[bc]";
		LinkedHashMap<Integer,String> decodeMap=new LinkedHashMap<>();
		int index=0;
		String result="";
		String val="";
		while(index<T.length()) {
			
			int ch=T.charAt(index);
			System.out.println("ch==>> "+ch);
			if(ch>='0' && ch<='9') {
				val+=T.charAt(index);
				System.out.println(val);
				index++;
				continue;
			}
			if(T.charAt(index)=='[' ) {
				index++;
				continue;
			}
			String temp="";
			while(index<T.length()) {
				if(T.charAt(index)==']') {
					index++;
					break;
				}
				temp+=T.charAt(index);
				index++;
			}
			
			for(int i=0;i<Integer.parseInt(val);i++) {
				result+=temp;
			}
			
			
			val="";
		}
		
		System.out.println("==>"+result);
		
		
		List<String> list = new ArrayList<>();
		list.add("abc");
		
		list.stream();
		
	}
	
}


