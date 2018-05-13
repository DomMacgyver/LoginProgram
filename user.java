package Jframet;

import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
import javax.activation.*;
import java.*;

public class user 
{
	private String username;
	private ArrayList<String> usernames = new ArrayList<String>();
	
	public user(String username, String password, String password2, String email)
	{
		if (usernames.indexOf(username) == -1)
		{
			
		}
	}
	
	public int usercheck(String uname)
	{
		if (usernames.indexOf(uname) != -1)
		{
			return 0;
		}
		return 1;
	}

}

