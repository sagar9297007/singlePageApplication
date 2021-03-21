package singlePageApplication;

import java.util.*;

class Clear
{

	void clc()
	{
		try
		{	
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
}
class Print
{
	Clear c = new Clear();
	static LinkedList<String>a = new LinkedList<String>();//title
	static LinkedList<String>b= new LinkedList<String>();//discription
	
	Scanner scan = new Scanner(System.in);
	
	int search()
	{
		
		c.clc();
		String TC;
		String DC;
		System.out.println("ENTER THE KEY WORD TO SEARCH");
		String st = scan.nextLine();
		String ct= st.toUpperCase();
		int g=0;
		try
		{
			for(int j=0;j<a.size();j++)
			{
			TC=a.get(j);
			DC=b.get(j);
			if (TC.contains(ct))
			{
				g++;
				System.out.println("POST FOUND"+"\n");
				System.out.println(TC);
				System.out.println(DC+"\n");
			}
			}
		}
		catch (Exception e)
		{
		}
		return g;
		}

	     int display()
		{
		
		c.clc();
		int q = a.size();
			try
			{
				for (int i=0;i<(a.size());i++)
				{
					System.out.println(a.get(i));
					System.out.println(b.get(i));
					System.out.println("\n"+"\n");
				}
			}
			catch (Exception e)
			{
			}
			return q;
		}

	     void post()
		{
		System.out.println("TITLE :-");
		String t = scan.nextLine();
		a.add(t.toUpperCase());
		System.out.println("\n"+"DESCRIPTION :-");
		String d = scan.nextLine();
		b.add(d);
		c.clc();
		System.out.println("SUCCESSFULLY POSTED "+"\n");
		}
}
class Application
{
	public static void main(String[] args)
	{
		Clear c = new Clear();
		Scanner scan = new Scanner(System.in);
		Print p = new Print();
		
		int i=0;
		do
		{	
			System.out.println("1.SEARCH POST"+"\n"+"2.VIEW PUBLISHED"+"\n"+"3.NEW POST"+"\n"+"4.EXIT");
			i=scan.nextInt();
			if(i==1) 
			{
				c.clc();
				int g = p.search();
				if(g==0)
				{
					System.out.println("\n"+"NO POST FOUND"+"\n");
				}
				
			}
			if(i==2) 
			{
				c.clc();
				int w = p.display();
				if(w==0)
				{
					System.out.println("\n"+"NO POST FOUND"+"\n");
				}
				
			}
			if(i==3) 
			{
				c.clc();
				p.post();

			}

			if(i!=4&&i!=3&&i!=2&&i!=1)
			{
				c.clc();
				System.out.println("invalid key  "+i+"\n");
			}
		}while(i!=4);

		c.clc();
	}
}
