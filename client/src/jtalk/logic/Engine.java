package jtalk.logic;

public class Engine {
	
	public Engine(){
		
	}
	
	public static boolean Initialize(){
		server_ip = "127.0.0.1";
		
		return true;
	}//Function for internal initialization of client components upon startup

	
	public static boolean LoginUser(String u_name, String u_pass){
		
		return true;
	}//Function for authenticating active program user
	
	
	public static boolean Sync(){
		
		return true;
	}//Functions responsible for initial synchronization after user has been authenticated 
	
	
	
	
	
	
	
	
	
	
	public static String server_ip;
}
