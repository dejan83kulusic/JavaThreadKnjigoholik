package com.downloadKnjigaServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;


public class KnjigaServerThread extends Thread{

	public Socket sock;
	public BufferedReader in;
	public PrintWriter out;
	public  KnjigaServerThread(Socket s) {
		try {
			System.out.println("uspjesno kreirana nit");
			this.sock=s;
			in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())),true);
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
				}		
			
		
	
}
	
	
	
public void run()  {
	try {

	String zahtjev="";
	Scanner scan=new Scanner(System.in);
		zahtjev=in.readLine();
		System.out.println("Server Download");
	if(zahtjev.startsWith("DOWNL#")) {
		
		String[] uStaKovertujemo = zahtjev.split("#");
		String  urlBookFolder=uStaKovertujemo[1]; 
		String urlBookTXT=uStaKovertujemo[2];
		String url=uStaKovertujemo[3];
		URL itp100=new URL(url);
		BufferedReader br=new BufferedReader(
				new InputStreamReader(itp100.openStream()));
		new File(urlBookFolder).mkdirs();

		String line="";
		//kreiramo novi fajl
		File icblFajl=new File(urlBookFolder);
		if(!icblFajl.exists())
			icblFajl.createNewFile();
		
		PrintWriter pw=new PrintWriter(urlBookTXT);
		
		while((line=br.readLine())!=null) {
	
			pw.println(line);
			System.out.println(line);
		}
		pw.close();
		br.close();
	     out.println("OK");
		}else {
			out.println("NOT");
		}

	
	}
		 catch (Exception ex) {
			ex.printStackTrace();
		

		}

	}
}
