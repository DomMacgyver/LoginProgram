//Sub class for displaying username error messages

package Jframet;

public class usernamec extends ast
{
	
	private boolean flagLength;
	public usernamec(int a)
	{
		super(a);	
		flagLength = false;
	}
	
	public int newe(int a)
	{
		if(a == 0)
		{
			return 0;
		}
		else if(a == 1)
		{
			return 2;
		}
		else
		{
			return 0;
		}	
	}
	
	public int checke(String usern,String g)
	{
		if(usern.length() == 0)
		{
			return 0;
		}
		   if(usern.length() < 8)
		   {
			   flagLength = true;
		   }
		   else
		   {
			   flagLength = false;
		   }
		    
		   if (flagLength)
		    {
		    	return 10;
		    }
		   else
		   {
			   return -1;
		   }


		}



}
