//class for serializing a user object and storing to a location on the server

package Jframet;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class serial implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uc;
	private String pc;
	private String ec;
	private String lstmac;
	
	public serial()
	{
		uc = "";
		pc = "";
		ec = "";
		lstmac = "";
	}
	public serial(String u, String p, String e, String m)
	{
		uc = u;
		pc = p;
		ec = e;	
		lstmac = m;
	}
	
	public boolean passwordchange(String u, String p, int n)
	{
		boolean b = true;
		serial e;
		File test = new File("H:/classes/" + u + ".ser");
		if(!test.exists())
		{
			b = false;
			return b;
		}
		else
		{
			try {
				FileInputStream fileIn = new FileInputStream(test);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				e = (serial) in.readObject();
				in.close();
				fileIn.close();

			} catch (IOException i) {
				e = null;
				i.printStackTrace();
				b = false;

			} catch (ClassNotFoundException c) {
				e = null;
				c.printStackTrace();
				b = false;

			}
			if(b)
			{
				if(test.delete())
				{
					b = false;
				}
				e.pc = p;
				serialize("H:/classes/",e);
			}
		}
		return b;
	}


	public int serialize(String s,serial e)
	{
		int b = 0;
		try {
			File test = new File("H:/classes/" + e + ".ser");
			if(test.exists())
			{
				b = 2;
			}
			else
			{
			File f = new File(s+this.uc+".ser");
			String pathname = f.getPath();
	         FileOutputStream fileOut = new FileOutputStream(pathname);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
			}
			
	      }catch(IOException i) {
	    	  i.printStackTrace();
	         b = 1;
	      }
		return b;
	}
	
	public boolean deserial(String u,String p)
	{
		boolean b = true;
		serial e;
		File test = new File("H:/classes/" + u + ".ser");
		if(!test.exists())
		{
			b = false;
			return b;
		}
		else
		{
			try {
				FileInputStream fileIn = new FileInputStream(test);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				e = (serial) in.readObject();
				in.close();
				fileIn.close();

			} catch (IOException i) {
				e = null;
				i.printStackTrace();
				b = false;

			} catch (ClassNotFoundException c) {
				e = null;
				c.printStackTrace();
				b = false;

			}
			String s1 = u;
			String s2 = e.uc;
			if(s1.compareTo(s2) == 0)
			{
				try{
					if(!PasswordAuthentication.validatePassword(p,e.pc))
					{
						b = false;
					}
					else{}
					}catch(NoSuchAlgorithmException i){  i.printStackTrace();
					b = false;}
					catch(InvalidKeySpecException i){  i.printStackTrace();
					b = false;}
			
			}
			else
			{
				b = false;
			}
		}
		
		return b;
	}
	public int emailtest(String u,String em)
	{
		Random r = new Random();
		int b = r.nextInt(999999);
		serial e;
		File test = new File("H:/classes/" + u + ".ser");
		if(!test.exists())
		{
			b = 0;
			return b;
		}
		else
		{
			try {
				FileInputStream fileIn = new FileInputStream(test);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				e = (serial) in.readObject();
				in.close();
				fileIn.close();

			} catch (IOException i) {
				e = null;
				i.printStackTrace();
				b = 0;

			} catch (ClassNotFoundException c) {
				e = null;
				c.printStackTrace();
				b = 0;

			}
			if(u.compareTo(e.uc) == 0 && em.compareTo(e.ec) == 0)
			{
				String to = em;
			    String from = "168464@mcpsmd.net";
			    String host = "smtp.mail.com";
			    String port = "587";
			    String password = "Jnjb3497";//Your email password
			    Properties properties = System.getProperties();
			    properties.put("mail.smtp.auth", "true");
			    properties.put("mail.smtp.starttls.enable", "true");
			    properties.put("mail.smtp.port", "587");

			    if (from.contains("hotmail")) {
			        properties.put("mail.smtp.host", "smtp.live.com");

			    } else if (from.contains("gmail")) {
			        properties.put("mail.smtp.host", "smtp.gmail.com");

			    } else if (from.contains("yahoo")) {
			        properties.put("mail.smtp.host", "smtp.mail.yahoo.com");

			    } else {
			        System.out.println("Please use 'Yahoo, Gmail or Hotmail");
			    }

			    Session messageSession = Session.getDefaultInstance(properties, new Authenticator(){
			        @Override
			        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

			            return new javax.mail.PasswordAuthentication(from, password);
			        }
			    });

			    try {
			        MimeMessage mimeMessage = new MimeMessage(messageSession);
			        mimeMessage.setFrom(new InternetAddress(from));
			        String subject = "Password reset";
			        String message = Integer.toString(b);
			        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			        mimeMessage.setSubject(subject);
			        mimeMessage.setText(message);

			        Transport.send(mimeMessage);

			    } catch (MessagingException me) {
			    	me.printStackTrace();
			        System.out.println(me.getMessage());
			    }
			    /*
				  String to = em;
			      String from = "168464@mcpsmd.net";
			      String host = "smtp.mail.com";
			      String port = "587";
			      Properties properties = System.getProperties();
			      properties.setProperty("mail.smtp.host", host);
			      properties.put("mail.smtp.socketFactory.port", port);
			      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			      properties.put("mail.smtp.socketFactory.fallback", "false");
			      Session session = Session.getInstance(properties, null);

			      try {
			         MimeMessage message = new MimeMessage(session);
			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));
			         // Set To: header field of the header.
			         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			         // Set Subject: header field
			         message.setSubject("Password Reset");
			         // Now set the actual message
			         message.setText(Integer.toString(b));
			         // Send message
			         Transport.send(message);
			         System.out.println("Sent message successfully....");
			      }catch (MessagingException mex) {
			         mex.printStackTrace();
			      }*/
			}
			else
			{
				if(u.compareTo(e.uc) != 0)
				{
					b = -1;
				}
				else
				{
					b = 0;
				}
			}
		}
		
		return b;
	}


}
