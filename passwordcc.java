package Jframet;

public class passwordcc extends ast
{


		public passwordcc(int a)
		{
			super(a);	
		}
		
		public int newe(int a)
		{
			if(a == 0)
			{
				return 0;
			}
			else if(a == 1)
			{
				return 1;
			}
			else if(a == 2)
			{
				return 4;
			}
			else
			{
				return 0;
			}	
		}
		
		public int checke(String passw,String g)
		{
			if(passw.length() == 0)
			{
				return 0;
			}
		    boolean same = false;
		   if(passw.equals(g))
		   {
			   same = true;
		   }
		   
		   if(same)
		   {
			   return -1;
		   }
		   else
		   {
			   return 11;
		   }
		}
	}



