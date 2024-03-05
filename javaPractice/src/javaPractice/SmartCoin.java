package javaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class Person {
	public int id;
	public String name;
	public Date dob;
	public String state;

	public Person(int id, String name, Date dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
}



public class SmartCoin {

	public static void sort(List<Person> list) {
		Collections.sort(list, (p1,p2)-> p1.dob.compareTo(p2.dob));
		
	}
	
	public static Person findPerson(List<Person> list,Date dob,int l,int h) {
		Person person=null;
		
		int low=l;
		int high=h;
		
		while(low<=high) {
			int mid=(low+high)/2;
			Person temp=list.get(mid);
			if(temp.dob==dob) {
				person=temp;
				break;
			}
			
			if(dob.compareTo(temp.dob)<0) {
				findPerson(list,dob,low,mid-1);
			}else {
				findPerson(list,dob,mid+1,high);
			}
			
		}
		
		return person;
	}
	
	public static Person find(List<Person> list,Date dob) {
		
		return findPerson(list,dob,0,list.size()-1);
	}
	
	public static String maxState(List<Person> people) {
		
		Map<String,Integer> hmap=new HashMap<>();

		for(Person p:people) {
			String state=p.state;
			if(hmap.containsKey(state)) {
				hmap.put(state, hmap.get(state)+1);
			}else {
				hmap.put(state, 1);
			}
		}
		
		String state=null;
		int max=-1;
		
		for(Map.Entry<String, Integer> entry:hmap.entrySet()) {
			if(entry.getValue()>max) {
				max=entry.getValue();
				state=entry.getKey();
			}
		}
		return state;
	}
	
	public static Map<String,Set<String> > statemap=new HashMap<>();
	
	public static void register(String state,String course) {
		
		if(statemap.containsKey(state)) {
			Set<String> st=statemap.get(state);
			st.add(course);
			statemap.put(state, st);
		}else {
			Set<String> st=new HashSet<>();
			st.add(course);
			statemap.put(state, st);
		}
	}
	
	public static Integer StateScore(String state) {
		if(statemap.containsKey(state)) {
			Set<String> st=statemap.get(state);
			return st.size();
		}else {
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> person_list=new ArrayList<>();
		
		sort(person_list);
		Date dob=null;
		System.out.println(find(person_list, dob).toString());
		
		
		register("kerala","CS101");
		register("kerala","CS102");
		
		register("punjab","CS101");
		register("punjab","CS101");
		System.out.println(StateScore("punjab"));
		
	}

}


