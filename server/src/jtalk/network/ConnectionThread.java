package jtalk.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionThread implements Runnable{
	/*
	 * Connection thread class responsible for handling incoming connections from clients 
	 */
	
	public ConnectionThread(Socket i, int id){
		socket  = i;
		thread_id = id;	
	}
	
	private Socket socket;
	private int thread_id;
	
	@Override
	public void run() {
		try
	      {  
	         try
	         {
	            InputStream inStream = socket.getInputStream();
	            OutputStream outStream = socket.getOutputStream();
	            
	            ObjectInputStream input = new ObjectInputStream(inStream);
	            ObjectOutputStream output = new ObjectOutputStream(outStream);
	           	            	            
	            boolean done = false;
	            while (!done)
	            {  
	            	
	            	String msg = null;
	            	
	            	try {
						msg = (String) input.readObject();
						
						System.out.println("W�tek po��czenia ["+thread_id+"] odebra� pakiet ["+msg+"]!");
						
						if(msg.equals("koniec")) done = true;//zako�czenie w�tku je�li flaga ko�ca jest ustawiona
						else{
							
							output.writeObject(msg);;//wywo�anie metody przetwarzaj�cej otrzymany pakiet - wys�anie pakietu do klienta
							
						}
						
					} catch (ClassNotFoundException e) {
						System.out.println("B��d konwersji kontenera! W�tek:"+thread_id);
						e.printStackTrace();
					}
	            	
	            	
	               
	            }
	         }
	         finally
	         {
	            socket.close();
	            System.out.println("W�tek po��czenia ["+thread_id+"] zako�czy� prac�!");
	         }
	      }
	      catch (IOException e)
	      {  
	    	 System.out.println("W�tek po��czenia ["+thread_id+"] zako�czony na skutek b��du!");
	         e.printStackTrace();
	      }
		
	}
}
