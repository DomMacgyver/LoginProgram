//Sub class for displaying password error messages

package Jframet;

public class passwordc extends ast
{

	public passwordc(int a)
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

	    boolean flagUppercase = false;
	    boolean flagLowercase = false;
	    boolean flagSpecialchar = false;
	    boolean flagDigit = false;
	    int fDigit = 0;
	    boolean flag = false;

	    if(passw.length() == 0)
		{
			return 0;
		}
	    if (passw.length() >= 10) {
	        for (int i = 0; i < passw.length(); i++) {
	            if (Character.isDigit(passw.charAt(i)) && fDigit < 2) {
	            	fDigit++;
	                flagDigit = true;
	            }
	            if (Character.isUpperCase(passw.charAt(i)) && !flagUppercase) {
	                flagUppercase = true;
	            }
	            if (Character.isLowerCase(passw.charAt(i)) && !flagLowercase) {
	                flagLowercase = true;
	            }
	         
	        }
	    }
	    else
	    {
	    	return 5;
	    }
	    if (!flagUppercase)
	    {
	    	return 6;
	    } else if(!flagLowercase)
	    {
	    	return 7;
	    }
	    else if(!flagDigit)
	    {
	    	return 8;
	    }
	    else
	    {
	    	return -1;
	    }
	}
}
