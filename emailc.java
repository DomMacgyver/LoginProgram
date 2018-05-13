package Jframet;

public class emailc extends ast
{
	private boolean flagLength;
	public emailc(int a)
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
			return 3;
		}
		else
		{
			return 0;
		}	
	}
	
	public int checke(String email,String g)
	{
		if(email.length() == 0)
		{
			return 0;
		}
		   if(email.length() < 8)
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
