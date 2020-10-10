package booking;
import java.util.*;
import java.io.*;


//booking in other coaches
public class Train1 extends Train{
	
	public Scanner sc = new Scanner(System.in);
	
	protected String name[] = new String[100] ;
	protected int age[] = new int[100];
	protected int mobile[] = new int[100];
	protected int number[] = new int[100];  // saving the pnr no. of count person
	protected int woc;
	
	public int amount_1 = 0;
	
	protected static int count = 0 , waiting = 0;
	
	protected int a2[] = new int[4] , b1[] = new int[10] , a1[] = new int[3] , sl[] = new int[20] ;
	protected int waiting_a2[] = new int[100] , waiting_b1[] = new int[100] , waiting_a1[] = new int[100] , waiting_sl[] = new int[100] ;
	
	public int max = 0;
	public int n1;//used at the pnr status for the nth person
	
	//public int count_1 = 0 , count_2 = 0 , count_3 = 0 , count_4 = 0;
	public int waiting_1 = 0 , waiting_2 = 0 , waiting_3 = 0 , waiting_4 = 0 ;

	public Train1() throws IOException
	{
		try {  
			
            Reader reader = new FileReader("D:/input.txt");  
  
            try(BufferedReader bufferedReader =  
                new BufferedReader(reader)){  
  
                String line = bufferedReader.readLine(); 
                while(line != null) {  
  
                      
                    //System.out.println(line);  
                    String[] split = line.split(" ");
                    
                    Integer result = Integer.valueOf(split[1]);
                    
                    name[count] = split[0];
                    age[count] = result;
                    
                    result = Integer.valueOf(split[3]);
                    number[count] = result;
                    count++;
                    
                    if(split[2].equals("a1"))
                    {
                    	for(int i = 0 ; i<a1.length ; i++)
                    	{
                    		if(a1[i] == 0)
                    		{
                    			a1[i] = result;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("a2"))
                    {
                    	for(int i = 0 ; i<a2.length ; i++)
                    	{
                    		if(a2[i] == 0)
                    		{
                    			a2[i] = result;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("b1"))
                    { 
                    	for(int i = 0 ; i<b1.length ; i++)
                    	{
                    		if(b1[i] == 0)
                    		{
                    			b1[i] = result;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("sl"))
                    {
                    	for(int i = 0 ; i<sl.length ; i++)
                    	{
                    		if(sl[i] == 0)
                    		{
                    			sl[i] = result;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("waiting_a1"))
                    {
                    	for(int i = 0 ; i<waiting_a1.length ; i++)
                    	{
                    		if(waiting_a1[i] == 0)
                    		{
                    			waiting_a1[i] = result;
                    			waiting++;
                    			waiting_1++;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("waiting_a2"))
                    {
                    	for(int i = 0 ; i<waiting_a2.length ; i++)
                    	{
                    		if(waiting_a2[i] == 0)
                    		{
                    			waiting_a2[i] = result;
                    			waiting++;
                    			waiting_2++;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("waiting_b1"))
                    {
                    	for(int i = 0 ; i<waiting_b1.length ; i++)
                    	{
                    		if(waiting_b1[i] == 0)
                    		{
                    			waiting_b1[i] = result;
                    			waiting++;
                    			waiting_3++;
                    			break;
                    		}
                    	}
                    }
                    else if(split[2].equals("waiting_sl"))
                    {
                    	for(int i = 0 ; i<waiting_sl.length ; i++)
                    	{
                    		if(waiting_sl[i] == 0)
                    		{
                    			waiting_sl[i] = result;
                    			waiting++;
                    			waiting_4++;
                    			break;
                    		}
                    	}
                    }
                    
                    line = bufferedReader.readLine();
                }  
  
            }  
        } catch (IOException e) {  
              
            System.out.println(e);  
        }    
	}

	public void coach()
	{
		int n = 0;
		
		while(true)
		{
			
			int tem = 0;
			
			while(tem == 0)
			{
				try
				{
					System.out.println("Enter 1 to book a ticket in first tier : PRICE = Rs.2000");
					System.out.println("Enter 2 to book a ticket in second tier : PRICE = Rs.1550");
					System.out.println("Enter 3 to book a ticket in third tier : PRICE = Rs.1330");
					System.out.println("Enter 4 to book a ticket in sleeper coach : PRICE = Rs.470");
					
					n = sc.nextInt();
					tem = 1;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter an integer");	
				}
				sc.nextLine();
			}
			
			
			int i;//no. of seats available
			i = 0;
			
			//booking of seats in a1
			if(n == 1)
			{
				for(int j = 0 ; j < a1.length ; j++)
				{
					if(a1[j] == 0)
					{
						i++;
					}
				}
				int t_no = 0;
				
				tem = 0;
				
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter the no. of tickets you want to book");
						t_no = sc.nextInt();
						
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				tickets(t_no , i , a1 , waiting_a1 , 100 , waiting_1);
		
				amount_1 += t_no*2000;	
				break;
			}
			//Booking of seat in a2
			else if(n == 2)
			{
				for(int j = 0 ; j < a2.length ; j++)
				{
					if(a2[j] == 0)
					{
						i++;
					}
				}
				int t_no = 0;
				
				tem = 0;
				
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter the no. of tickets you want to book");
						t_no = sc.nextInt();
						
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				tickets(t_no , i , a2 , waiting_a2 , 200 , waiting_2);
		
				amount_1 += t_no*1550;	
				break;
			}
			else if(n == 3)
			{
				for(int j = 0 ; j < b1.length ; j++)
				{
					if(b1[j] == 0)
					{
						i++;
					}
				}
				int t_no = 0;
				
				tem = 0;
				
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter the no. of tickets you want to book");
						t_no = sc.nextInt();
						
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				tickets(t_no , i , b1 , waiting_b1 , 300 , waiting_3);
		
				amount_1 += t_no*1330;	
				break;
			}
			else if(n == 4)
			{
				for(int j = 0 ; j < sl.length ; j++)
				{
					if(sl[j] == 0)
					{
						i++;
					}
				}
				int t_no = 0;
				
				tem = 0;
				
				while(tem == 0)
				{
					try
					{
						System.out.println("Enter the no. of tickets you want to book");
						t_no = sc.nextInt();
						
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				tickets(t_no , i , sl , waiting_sl , 400 , waiting_4);
		
				amount_1 += t_no*470;	
				break;
			}
			else
			{
				System.out.println("You entered the wrong choice. Please select again");
			}
		}
		
	}
		
	public void tickets(int n , int i , int a2[] , int waiting_a2[] , int tier , int waiting_2)
	{
		int j;
		if(i > 0)
		{
			System.out.println("Total no. of seats available "+i);
			//if no. of available seats is less than n
			if(n > i)
			{
				
				int num = 0;
				
				while(true)
				{
					System.out.println(i +" tickets are confirmed and " + (n- i ) +" will be in waiting");
					
					int tem = 0;
					
					while(tem == 0)
					{
						try
						{
							System.out.println("Do you want to book your tickets : PRESS");
							System.out.println("1 : Yes");
							System.out.println("2 : No");
							
							num = sc.nextInt();
							
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					//booking the train ticket
					if(num == 1)
					{
						int k;
						k = 0;
						
						//booking the confirm tickets
						for(j = 0 ; j < a2.length ; j++)
						{
							if(a2[j] == 0)
							{
								a2[j] = 1000 + tier + 10 + j;
								number[count] = 1000 + tier + 10 + j;
								k++;
								info();
								count++;
							}
							
							if(k == i)
							{
								break;
							}
						}
						
						
						k = 0 ;
						while(waiting_a2[k] != 0)
						{
							k++;
						}
						
						//booking the rest tickets in waiting list
						for(j = 0 ; j < n-i ; j++)
						{
							info();
							waiting_a2[k] = 1000 + tier + waiting_2;
							number[count] = 1000 + tier + waiting_2;
							k++;
							waiting++;
							count++;
							waiting_2++;
						}
						int counting = 0;
						//printing the booking status
						System.out.println("\t----****----");						
						for(j = 1 ; j<=i ; j++)
						{
							System.out.println(++counting +".)\t" +name[count-n+j-1]+ "\tConfirmed\t"+number[count-n+j-1]);
						}
						
						for(j = count-waiting ; j<count ; j++)
						{
							System.out.println(++counting +".)\t" +name[j]+ "\t Waiting \t"+number[j]);
						}
						System.out.println("\t----****----");
						break;
						
					}
					else if(num == 2)
					{
						break;
					}
					else
					{
						System.out.println("You entered the wrong choice please select again");
					}
				}
			}
			//if no. of available seat is greater than or equal to n
			else if(n <= i)
			{
				
				int num;
				
				while(true)
				{
					System.out.println(n +" tickets are confirmed");
					
					int tem = 0;
					
					while(tem == 0)
					{
						try
						{
							System.out.println("Do you want to book your tickets : PRESS");
							System.out.println("1 : Yes");
							System.out.println("2 : No");
							
							num = sc.nextInt();
							
							tem = 1;
						}
						catch(InputMismatchException e)
						{
							System.out.println("Please enter an integer");	
						}
						sc.nextLine();
					}
					
					num = sc.nextInt();
					//booking the train ticket
					if(num == 1)
					{
						int k;
						k = 0;
						
						//booking the confirm tickets
						for(j = 0 ; j < 10 ; j++)
						{
							if(a2[j] == 0)
							{
								a2[j] = 1000 + tier + 10 + j;
								number[count] = 1000 + tier + 10 + j;
								k++;
								info();
								count++;
							}
							
							if(k == n)
							{
								break;
							}
						}
						
						//printing the booking status
						System.out.println("\t----****----");						
						for(j = 0 ; j<n ; j++)
						{
							System.out.println(j+1 +".)\t" +name[count-n+j]+ "\tConfirmed\t"+number[count-n+j]);
						}
						
						System.out.println("\t----****----");
						break;
					}
					else if(num == 2)
					{
						break;
					}
					else
					{
						System.out.println("You entered the wrong choice please select again");
					}
				}
			}	
		}
		//if no. of empty seats is 0
		else
		{
			int num = 0;
				
			while(true)
			{
				System.out.println(i +" tickets are confirmed and " + (n- i ) +" will be in waiting");
				
				int tem = 0;
				
				while(tem == 0)
				{
					try
					{
						System.out.println("Do you want to book your tickets : PRESS");
						System.out.println("1 : Yes");
						System.out.println("2 : No");
						
						num = sc.nextInt();
						
						tem = 1;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter an integer");	
					}
					sc.nextLine();
				}
				
				//booking the train ticket
				if(num == 1)
				{
					int k;
					k = 0;
						
					while(waiting_a2[k] != 0)
					{
						k++;
					}
						
					//booking the rest tickets in waiting list
					for(j = 0 ; j < n-i ; j++)
					{
						info();
						waiting_a2[k] = 1000 + tier + waiting_2;
						number[count] = 1000 + tier + waiting_2;
						k++;
						waiting++;
						count++;
						waiting_2++;
					}
						
					//printing the booking status
					System.out.println("\t----****----");						
					for(j = 0 ; j<n ; j++)
					{
						System.out.println(j+1 +".)\t" +name[count-n+j]+ "\t Waiting \t"+number[count-n+j]);
					}
					
					System.out.println("\t----****----");
					break;
						
				}
				else if(num == 2)
				{
					break;
				}
				else
				{
					System.out.println("You entered the wrong choice please select again");
				}
			}
		}
		
		if(tier == 100)
		{
			for(int m = 0 ; m<a1.length ; m++)
			{
				a1[m] = a2[m];
			}
			for(int m = 0 ; m<waiting_a1.length ; m++)
			{
				waiting_a1[m] = waiting_a2[m];
			}
			waiting_1 = waiting_2;
		}
		else if(tier == 200)
		{
			for(int m = 0 ; m<a2.length ; m++)
			{
				this.a2[m] = a2[m];
			}
			for(int m = 0 ; m<this.waiting_a2.length ; m++)
			{
				this.waiting_a2[m] = waiting_a2[m];
			}
			this.waiting_2 = waiting_2;
		}
		else if(tier == 300)
		{
			for(int m = 0 ; m<b1.length ; m++)
			{
				b1[m] = a2[m];
			}
			for(int m = 0 ; m<waiting_b1.length ; m++)
			{
				waiting_b1[m] = waiting_a2[m];
			}
			waiting_3 = waiting_2;
		}
		else if(tier == 400)
		{
			for(int m = 0 ; m<sl.length ; m++)
			{
				sl[m] = a2[m];
			}
			for(int m = 0 ; m<waiting_sl.length ; m++)
			{
				waiting_sl[m] = waiting_a2[m];
			}
			waiting_4 = waiting_2;
		}
	}
	
	public void info()
	{
		System.out.println("Please enter your name");
		name[count] = sc.next();
		
		int tem = 0;
		
		while(tem == 0)
		{
			try
			{
				System.out.println("Please enter your age");
				age[count] = sc.nextInt();
				
				tem = 1;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter an integer");	
			}
			sc.nextLine();
		}
		
		//System.out.println("Please enter your mobile no.");
		//mobile[count] = sc.nextInt();
	}
	
	public void status(int pnr , String name_1)
	{
		int flag = 0;
		int l = 0;
		int i;
		max = 0;
		System.out.println("\t----****----");
		//System.out.println(this.name[0]);
		
		for(i = 0 ; i<this.name.length ; i++)
		{
			if(this.name[i] != null)
			{
				if(this.name[i].equals(name_1))
				{
					break;
				}
			}
			else
			{
				System.out.println("You entered the wrong PNR number or wrong name");
				max = 1;
				System.out.println("\t----****----");
				return;
			}
			
		}
		
		
		n1 = i;
		if(number[i] == pnr)
		{
			System.out.println("Train number\tCoach\tConfirmed/Waiting    \tNumber");
			if(pnr>=5000)
			{
				System.out.print("5\t\t");
			}
			else if(pnr>=4000 && pnr < 5000)
			{
				System.out.print("4\t\t");
			}
			else if(pnr>=3000 && pnr < 4000)
			{
				System.out.print("3\t\t");
			}
			else if(pnr>=2000 && pnr < 3000)
			{
				System.out.print("2\t\t");
			}
			else if(pnr>=1000 && pnr < 2000)
			{
				System.out.print("1\t\t");
			}
			
			pnr %= 1000;
			
			if(pnr>=400)
			{
				System.out.print("sleeper\t");
				
				pnr = number[i];
				
				for(l = 0 ; l<sl.length ; l++)
				{
					if(pnr == sl[l])
					{
						flag++;
						break;
					}
				}
				
				if(flag == 0)
				{
					for(l = 0 ; l<waiting_sl.length ; l++)
					{
						if(pnr == waiting_sl[l])
						{
							flag--;
							break;
						}
					}
					System.out.print("Waiting\t\t");
					System.out.println(l+1);
					woc = 0;
				}
				else
				{
					System.out.print("Confirmed\t\t");
					System.out.println(l+1);
					woc = 1;
				}
			}
			else if(pnr>=300 && pnr<400)
			{
				System.out.print("third tier\t");
				
				pnr = number[i];
				
				for(l = 0 ; l<b1.length ; l++)
				{
					if(pnr == b1[l])
					{
						flag++;
						break;
					}
				}
				
				if(flag == 0)
				{
					for(l = 0 ; l<waiting_b1.length ; l++)
					{
						if(pnr == waiting_b1[l])
						{
							flag--;
							break;
						}
					}
					System.out.print("Waiting\t\t");
					System.out.println(l+1);
					woc = 0;
				}
				else
				{
					System.out.print("Confirmed\t\t");
					System.out.println(l+1);
					woc = 1;
				}
				
			}
			else if(pnr>=200 && pnr<300)
			{
				System.out.print("second tier\t");
				
				pnr = number[i];
				
				for(l = 0 ; l<a2.length ; l++)
				{
					if(pnr == a2[l])
					{
						flag++;
						break;
					}
				}
				
				if(flag == 0)
				{
					for(l = 0 ; l<waiting_a2.length ; l++)
					{
						if(pnr == waiting_a2[l])
						{
							flag--;
							break;
						}
					}
					System.out.print("Waiting\t\t");
					System.out.println(l+1);
					woc = 0;
				}
				else
				{
					System.out.print("Confirmed\t\t");
					System.out.println(l+1);
					woc = 1;
				}
			}
			else if(pnr>=100 && pnr<200)
			{
				System.out.print("first tier\t");
				
				pnr = number[i];
				
				for(l = 0 ; l<a1.length ; l++)
				{
					if(pnr == a1[l])
					{
						flag++;
						break;
					}
				}
				
				if(flag == 0)
				{
					for(l = 0 ; l<waiting_a1.length ; l++)
					{
						if(pnr == waiting_a1[l])
						{
							flag--;
							break;
						}
					}
					System.out.print("Waiting\t\t");
					System.out.println(l+1);
					woc = 0;
				}
				else
				{
					System.out.print("Confirmed\t\t");
					System.out.println(l+1);
					woc = 1;
				}
			}
			
			/*pnr %= 100;
			
			if(pnr < 10)
			{
				System.out.print("Waiting\t\t");
			}
			else
			{
				System.out.print("Confirmed\t\t");
			}
			
			pnr %= 10;

			if(pnr == 0)
			{
				System.out.println(pnr+"\t");
			}
			else if(pnr == 1)
			{
				System.out.println(pnr+"\t");
			}
			else if(pnr == 2)
			{
				System.out.println(pnr+"\t");
			}
			else if(pnr == 3)
			{
				System.out.println(pnr+"\t");
			}
			else if(pnr == 4)
			{
				System.out.println(pnr+"\t");		
			}
			else if(pnr == 5)
			{
				System.out.println(pnr+"\t");		
			}
			else if(pnr == 6)
			{
				System.out.println(pnr+"\t");		
			}
			else if(pnr == 7)
			{
				System.out.println(pnr+"\t");			
			}
			else if(pnr == 8)
			{
				System.out.println(pnr+"\t");		
			}
			else if(pnr == 9)
			{
				System.out.println(pnr+"\t");
			}*/	
		}
		else
		{
			System.out.println("You entered the wrong PNR number or wrong name");
			max = 1;
		}
		/*System.out.println("\t----****----");
		
		for(int f = 0 ;f< a1.length ; f++)
		{
			System.out.println(a1[f]);
		}
		System.out.println("");
		for(int f = 0 ;f<6 ; f++)
		{
			System.out.println(waiting_a1[f]);
		}*/
		return;
		
	}


}
