package booking;

import java.util.Scanner;

//import java.util.Scanner;

public abstract class Train {
	
	public abstract void coach();
		
	public abstract void tickets(int n , int i , int a2[] , int waiting_a2[] , int tier , int waiting);
	
	public abstract void info();
	
	public abstract void status(int pnr , String name);
	
}
