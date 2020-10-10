package IrctcInterface;
import java.io.IOException;
import java.util.*;
import booking.*;
import Cancellation.*;

public class IrctcInterface {

	public static void main(String[] args) throws IOException {
		
		Train1Cancel t1 = new Train1Cancel();
		Train2Cancel t2 = new Train2Cancel();
		Train3Cancel t3 = new Train3Cancel();
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true)
		{
			int tem = 0;
			
			while(tem == 0)
			{
				try
				{
					System.out.println("Enter 1 to book a ticket");
					System.out.println("Enter 2 to cancel a ticket");
					System.out.println("Enter 3 to check your PNR status");
					System.out.println("Enter 4 to exit");
						
					num = sc.nextInt();	
					tem = 1;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter an integer");	
				}
				sc.nextLine();
			}
				
			
			//booking a ticket
			
			
			if(num == 1)
			{
				tem = 0;
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter 1 to for Train : Ahmedabad to Surat");
						System.out.println("Enter 2 to for Train : Kota to Ahmedabad");
						System.out.println("Enter 3 to for Train : Delhi to Mumbai");
							
						num = sc.nextInt();	
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				if(num == 1)
				{
					t1.coach();
				}
				else if(num == 2)
				{
					t2.coach();
				}
				else if(num == 3)
				{
					t3.coach();
				}
				else
				{
					System.out.println("You entered the wrong choice");
				}
			}
			else if(num == 2)
			{
				tem = 0;
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter 1 to for Train : Ahmedabad to Surat");
						System.out.println("Enter 2 to for Train : Kota to Ahmedabad");
						System.out.println("Enter 3 to for Train : Delhi to Mumbai");
							
						num = sc.nextInt();	
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				if(num == 1)
				{
					int pnr = 0;
					String name = "";
					
					tem = 0;
					while(tem == 0)
					{
						try
						{
							System.out.println("Enter your PNR number and your name");
								
							pnr = sc.nextInt();
							name = sc.next();	
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					t1.cancel(pnr, name);
				}
				else if(num == 2)
				{
					int pnr = 0;
					String name = "";
					
					tem = 0;
					while(tem == 0)
					{
						try
						{
							System.out.println("Enter your PNR number and your name");
								
							pnr = sc.nextInt();
							name = sc.next();	
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					t2.cancel(pnr, name);
				}
				else if(num == 3)
				{
					int pnr = 0;
					String name = "";
					
					tem = 0;
					while(tem == 0)
					{
						try
						{
							System.out.println("Enter your PNR number and your name");
								
							pnr = sc.nextInt();
							name = sc.next();	
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					t3.cancel(pnr, name);
				}
				else
				{
					System.out.println("You entered the wrong choice");
				}
				
			}
			else if(num == 3)
			{
				tem = 0;
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter 1 to for Train : Ahmedabad to Surat");
						System.out.println("Enter 2 to for Train : Kota to Ahmedabad");
						System.out.println("Enter 3 to for Train : Delhi to Mumbai");
							
						num = sc.nextInt();	
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				if(num == 1)
				{
					int pnr = 0;
					String name = "";
					
					tem = 0;
					while(tem == 0)
					{
						try
						{
							System.out.println("Enter your PNR number and your name");
								
							pnr = sc.nextInt();
							name = sc.next();	
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					t1.status(pnr , name);
				}
				else if(num == 2)
				{
					int pnr = 0;
					String name = "";
					
					tem = 0;
					while(tem == 0)
					{
						try
						{
							System.out.println("Enter your PNR number and your name");
								
							pnr = sc.nextInt();
							name = sc.next();	
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					t2.status(pnr , name);
				}
				else if(num == 3)
				{
					int pnr = 0;
					String name = "";
					
					tem = 0;
					while(tem == 0)
					{
						try
						{
							System.out.println("Enter your PNR number and your name");
								
							pnr = sc.nextInt();
							name = sc.next();	
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					t3.status(pnr , name);
				}
				else
				{
					System.out.println("You entered the wrong choice");
				}
				
			}
			else if(num == 4)
			{
				break;
			}
			else
			{
				System.out.println("You entered the wrong choice. Please enter again");
			}

		}
		
		//System.out.println(t1.count_1 +" " +t1.count_2 +" " +t1.count_3 +" " +t1.count_4 +" " +t1.waiting_1 + " ");
		
		System.out.println("Thank you for visiting");
		
	}	

}
