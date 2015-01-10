package jtalk;

import jtalk.logic.Engine;
import jtalk.network.Connection;

public class JTalk {

	public static void main(String[] args) {
		// Starting point for JTalk Client
		
		if(Engine.Initialize()){
			if(Connection.Connect()){
			//All variables have been initialized at this point and server connection has been established	
								
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
				    public void run() {
				    	//Initialize main frame here
				    	
				    	
				    	//Login user here
						
						
						//Synchronization
						if(Engine.Sync()){
							//Start normal operation here - main loop
							
						}else{
							//Display synchronization error
							
						}
				    	
						
						//--------------------------------------------------------------------
				    }
				});			
				
				
			}else{
				//Display connection error
				
			}
		}else{
			//Display initialization error
			
		}
		
		
		System.exit(1);		

	}
}
