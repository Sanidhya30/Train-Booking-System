package Cancellation;
import booking.*;

import java.io.IOException;
import java.util.*;


public class Train2Cancel extends Train2{

	public Train2Cancel() throws IOException
	{
		super();
	}
	
	//calling the booking method
	public void coach()
	{
		super.coach();
	}
	
	//calling the pnr status method
	public void status(int pnr , String name)
	{
		super.status(pnr, name);
	}
	
	//cancellation method
	public void cancel(int pnr , String name_1)
	{
		super.status(pnr, name_1);
		
		if(max == 1)
		{
			return;
		}
		else
		{
			System.out.println("Do you want to continue? Press:");
			
			int tem = 0;
			int choice = 0;
			
			while(tem == 0)
			{
				try
				{
					System.out.println("1: to cancel the ticket");
					System.out.println("2: to return back");
					
					choice = sc.nextInt();
					tem = 1;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter an integer");	
				}
				sc.nextLine();
			}
			
			
			if(choice == 1)
			{
				for(int j = n1 ; j<age.length-1 ; j++)
				{
					if(age[j+1] != 0)
					{
						age[j] = age[j+1];
						//mobile[j] = mobile[j+1];
						name[j] = name[j+1];
						number[j] = number[j+1];
					}
					else	
					{
						age[j] = 0;
						//mobile[j] = 0;
						name[j] = " ";
						number[j] = 0;
					}
				}
				
				int temp;
				temp = pnr;
				int p;
				
				temp %= 100;
				
				//for the confirmed seat
				if(woc == 1)
				{
					temp = pnr;
					temp %= 1000;
					
					//selecting the tier
					if(temp>=400)//sl
					{
						for( p = 0 ; p<sl.length ; p++)
						{
							if(sl[p] == pnr)
							{
								break;
							}
						}
						temp %= 10;
						
						sl[p] = 0;
						
						if(waiting_sl[0] != 0)
						{
							sl[p] = waiting_sl[0];
							for(int j = 0 ; j<waiting_sl.length-1 ; j++)
							{
								waiting_sl[j] = waiting_sl[j+1];
							}
							waiting--;
						}
						
					}
					else if(temp>=300 && temp<400)//b1
					{
						temp %= 10;
						for( p = 0 ; p<b1.length ; p++)
						{
							if(b1[p] == pnr)
							{
								break;
							}
						}
						
						b1[p] = 0;
						
						if(waiting_b1[0] != 0)
						{
							b1[p] = waiting_b1[0];
							for(int j = 0 ; j<waiting_b1.length-1 ; j++)
							{
								waiting_b1[j] = waiting_b1[j+1];
							}
							waiting--;
						}
					}
					else if(temp>=200 && temp<300)//a2
					{
						temp %= 10;
						for( p = 0 ; p<a2.length ; p++)
						{
							if(a2[p] == pnr)
							{
								break;
							}
						}
						
						a2[p] = 0;
						
						if(waiting_a2[0] != 0)
						{
							a2[p] = waiting_a2[0];
							for(int j = 0 ; j<waiting_a2.length-1 ; j++)
							{
								waiting_a2[j] = waiting_a2[j+1];
							}
							waiting--;
						}
					}
					else if(temp>=100 && temp<200)//a1
					{
						temp %= 10;
						
						for( p = 0 ; p<a1.length ; p++)
						{
							if(a1[p] == pnr)
							{
								break;
							}
						}
						
						a1[p] = 0;
						
						if(waiting_a1[0] != 0)
						{
							a1[p] = waiting_a1[0];
							for(int j = 0 ; j<waiting_a1.length-1 ; j++)
							{
								waiting_a1[j] = waiting_a1[j+1];
							}
							waiting--;
						}
					}
				}
				//for the waiting seat
				else
				{
					//System.out.println("aabb");
					temp = pnr;
					temp %= 1000;
					//selecting the tier
					if(temp>=400)//sl
					{
						temp %= 10;
						for(p = 0 ;p<waiting_sl.length ; p++)
						{
							if(waiting_sl[p] == pnr)
							{
								break;
							}
						}
						for(int j = p ; j<waiting_sl.length-1 ; j++)
						{
							waiting_sl[j] = waiting_sl[j+1];
						}
						waiting_sl[waiting_sl.length-1] = 0;
					}
					else if(temp>=300 && temp<400)//b1
					{
						temp %= 10;
						for(p = 0 ;p<waiting_b1.length ; p++)
						{
							if(waiting_b1[p] == pnr)
							{
								break;
							}
						}
						for(int j = p ; j<waiting_b1.length-1 ; j++)
						{
							waiting_b1[j] = waiting_b1[j+1];
						}
						waiting_b1[waiting_b1.length-1] = 0;
					}
					else if(temp>=200 && temp<300)//a2
					{
						temp %= 10;
						for(p = 0 ;p<waiting_a2.length ; p++)
						{
							if(waiting_a2[p] == pnr)
							{
								break;
							}
						}
						for(int j = p ; j<waiting_a2.length-1 ; j++)
						{
							waiting_a2[j] = waiting_a2[j+1];
						}
						waiting_a2[waiting_a2.length-1] = 0;
					}
					else if(temp>=100 && temp<200)//a1
					{
						temp %= 10;
						for(p = 0 ;p<waiting_a1.length ; p++)
						{
							if(waiting_a1[p] == pnr)
							{
								break;
							}
						}
						for(int j = p ; j<waiting_a1.length-1 ; j++)
						{
							waiting_a1[j] = waiting_a1[j+1];
						}
						waiting_a1[waiting_a1.length-1] = 0;
					}
					waiting--;
				}
				System.out.println("Your ticket has been successfully cancelled");
				count--;
				
				return;
			}
			else if(choice == 2)
			{
				return;
			}
			else
			{
				System.out.println("You entered the wrong choice. Please select again");
			}
			
		}
		
	}

}
