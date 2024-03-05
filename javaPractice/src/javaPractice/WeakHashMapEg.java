package javaPractice;

import java.util.HashMap;
import java.util.WeakHashMap;


public class WeakHashMapEg {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String key1 = new String("key1");
		
		WeakHashMap<String,String> weakhashmap=new WeakHashMap<>();
		
		weakhashmap.put(key1, "value1");
		System.out.println("before weak hash map => "+weakhashmap);
		key1=null;
		System.gc(); // call garbage collector
		Thread.sleep(3000);
		System.out.println("after weak hash map => "+weakhashmap);
		
		
        String key2 = new String("key2");
		
		HashMap<String,String> hashmap=new HashMap<>();
		
		hashmap.put(key2, "value2");
		System.out.println("before hash map => "+hashmap);
		key2=null;
		System.gc(); // call garbage collector
		Thread.sleep(3000);
		System.out.println("after hash map => "+hashmap);
		
Object obj=new String("ab");
	}

}
