package javaIOpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOpkg {

	public static void main(String[] args) throws FileNotFoundException , IOException{
		// TODO Auto-generated method stub
//		
//		Scanner scan=new Scanner(new File("/Users/apple/java_Civictree/javaIOpkg/src/input.txt"));
////		scan.useDelimiter(",");
//		int sum=0;
//		while(scan.hasNext()) {
//			System.out.println(scan.nextLine());
////			sum+=scan.nextInt();
//			
//		}
//		System.out.println("SUM = "+sum);
//		scan.close();
		
		
		
		
		int i;
	    double d;
	    boolean b;
	    String str;

	    FileWriter fout = new FileWriter("test.txt");
	    fout.write("Testing Scanner 10 12.2 one true two false");
	    fout.close();

	    FileReader fin = new FileReader("Test.txt");

	    Scanner src = new Scanner(fin);

	    while (src.hasNext()) {
	      if (src.hasNextInt()) {
	        i = src.nextInt();
	        System.out.println("int: " + i);
	      } else if (src.hasNextDouble()) {
	        d = src.nextDouble();
	        System.out.println("double: " + d);
	      } else if (src.hasNextBoolean()) {
	        b = src.nextBoolean();
	        System.out.println("boolean: " + b);
	      } else {
	        str = src.next();
	        System.out.println("String: " + str);
	      }
	    }

	    fin.close();
	    src.close();

	}

} 
