//Master class for the asteriks display

package Jframet;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class ast 
{
	private String[] emessge = {"*required", "*invalid password", "*invalid username", "*invalid email", "*passwords do not match", "*Password must be at least 10 character long",
			"Must contain an uppercase letter","Must contain a lowercase letter", "Must contain a digit", "Must contain a special character","*Must be at least 8 character long","*Passwords do not match",
			"*Username is already taken"};
	public int tsa;
	public String error;
	public JLabel last;
	public JLabel reset = new JLabel("");
	
	public ast()
	{
		tsa = 0;
		error = "*";
		last = new JLabel(error);
		last.setForeground(Color.red);
	}
	
	public ast(int a)
	{
		tsa = a;
		error = "*";
		last = new JLabel(error);
	    last.setForeground(Color.red);
	}
	
	public int gettsa()
	{
		return this.tsa;
	}
	
	public void settsa(int a)
	{
		this.tsa = a;
	}
	
	public String geterror()
	{
		return this.error;
	}
	
	public void seterror(String a)
	{
		this.error = a;
		this.last.setText(this.error);
		last.setForeground(Color.red);
	}
	
	public void reset(JPanel p)
	{
		this.seterror("");
	}

	public int eupdate(int e)
	{
		if(e < 0)
		{
			return 2;
		}
		else if(this.error == emessge[e])
		{
			return 1;
		}
		else
		{
			this.seterror(emessge[e]);
			return 0;
		}
	}
	
	public int errorc(int n)
	{
		return eupdate(n);
	}
	
	public abstract int newe(int a);
	
	public abstract int checke(String t,String g);
	


}

