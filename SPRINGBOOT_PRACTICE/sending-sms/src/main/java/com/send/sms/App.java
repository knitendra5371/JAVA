package com.send.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void sendSms(String message,String mobile) {
		
		System.out.println(message+"    "+mobile);
		
		
		try {
			message=URLEncoder.encode(message, "UTF-8");
			System.out.println(message);
			
			String apiKey="";
			
			String sendId="FSTSMS";
			String language="english";
			String route="p";
			String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="
							+sendId+"&message="+message+"&language="+language+"&route="+route+
							"&numbers="+mobile;
			
			// sending get request by java....
			System.out.println("wait..............");
			
			URL url=new URL(myUrl);
			
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent","Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			
			
			
			int code=con.getResponseCode();
			
			System.out.println("response code = "+code);
			
			StringBuffer response=new StringBuffer();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while(true) {
				String line=br.readLine();
				if(line==null) {
					break;
				}
				response.append(line);
			}
			System.out.println("response data ==> "+response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        sendSms(" How are you? "+new Date().toLocaleString(),"9087654321");
        
    }
}
