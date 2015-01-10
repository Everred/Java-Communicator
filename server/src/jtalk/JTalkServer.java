package jtalk;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import jtalk.dbc.DBC;
import jtalk.logic.Engine;
import jtalk.network.ConnectionThread;

public class JTalkServer {

	public static void main(String[] args) {
		// Starting point for JTalk Server
		System.out.println("Server starting...");
		
		//Initializing section
		if(DBC.Connect()) System.out.println("Database connected...");
		else {
			System.out.println("Can't connect to database... exiting.");
			System.exit(1);
		}
		
		if(Engine.Initialize()) System.out.println("Engine initialized...");
		else {
			System.out.println("Can't initialize server engine... exiting.");
			System.exit(1);
		}
		//End of initializing section
		
		//Main loop - traffic handling and processing
		try
	      {  
	         int i = 1;
	         @SuppressWarnings("resource")
			 ServerSocket s = new ServerSocket(9999);

	         while (true)
	         {  
	            Socket incoming = s.accept();
	            System.out.println("New connection " + i);
	            
	            Runnable r =  new ConnectionThread(incoming, i);
	            
	            Thread t = new Thread(r);
	            
	            t.start();
	            i++;
	         }
	      }
	      catch (IOException e)
	      {  
	    	 System.out.println("Server stopped working because of unknown exeption!");
	         e.printStackTrace();
	      }
		//End of main loop

	}

}
