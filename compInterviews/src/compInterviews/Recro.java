package compInterviews;

import java.util.ArrayList;
import java.util.List;


//can we override static and private method?
//what is dirty check in hibernate?
//what is diff b/w merge and update method in hibernate


public class Recro extends Thread{
	public static List<Integer> list=new ArrayList<>();
	public static int sum=0;
	public synchronized static int sum(int start,int end) {
		
		int summ=0;
		for(int i=start;i<end;i++) {
			summ+=list.get(i);
		}
		
	
		return summ;
	}
	
	public static void reverse(char[] str,int start,int end) {
		
		if(start>=end) {
			return;
		}
		
		char temp=str[start];
		str[start]=str[end];
		str[end]=temp;
		start++;
		end--;
		 reverse(str,start,end);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
//		for(int i=1;i<=100;i++) {
//			list.add(i);
//		}
//		
//		Thread t1= new Thread() {
//			public void run() {
//				sum+=sum(0,33);
//			}
//		};
//		
//		Thread t2= new Thread() {
//			public void run() {
//				sum+=sum(33,66);
//			}
//		};
//		
//		Thread t3= new Thread() {
//			public void run() {
//				sum+=sum(66,100);
//			}
//		};
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		
//		System.out.println("sum == "+sum);
		
		String str="nitendra";
		char[] ch=str.toCharArray();
		reverse(ch,0,str.length()-1);
		
		System.out.println(ch);
		
	}

}
