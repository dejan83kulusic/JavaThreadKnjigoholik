package com.knjigaKlijent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class KnjigaKlijent {

	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("127.0.0.1", 9000);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);
			Scanner scan = new Scanner(System.in);
			String msg1="";
			String msg2="";
			String msg3="";
				System.out.println("Unesite folder");
				msg1 = scan.nextLine();
				System.out.println("Unesitefajl u tekstualnom formati . txt:");
				msg2 = scan.nextLine();
				System.out.print("Unesite url: ");
				msg3 = scan.nextLine();
				String msg = "DOWNL"+"#"+ msg1+"#"+msg2+"#"+msg3;
				out.println(msg);
	
				//if (!"DOWNL".equals(msg)) {
					String response = in.readLine();
					System.out.println("[Server]: " + response);
				//}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
