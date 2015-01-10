package jtalk.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import jtalk.logic.Engine;

public class Connection {
	
	public Connection(){
		
	}
	
	private static Socket socket;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	
	public static boolean Connect(){
		try {
			socket = new Socket(Engine.server_ip, 9999);//uses ip value specified in Engine global variable upon initialization
			OutputStream outStream = socket.getOutputStream();
			output = new ObjectOutputStream(outStream);
			InputStream inStream = socket.getInputStream();
			input = new ObjectInputStream(inStream);
			return true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}//Function makes new connection to server
	
	/*
	public String Send(String msg) throws Exception, IOException{
		
		output.writeObject(msg);		
		
		return (String) input.readObject();
	}
	*/

}
