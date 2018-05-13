package Jframet;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Map;
import java.net.*;
import java.io.*;


public class loginpage 
{
	public usernamec ast1 = new usernamec(0);
	public passwordc ast2 = new passwordc(0);
	public passwordcc ast3 = new passwordcc(0);
	public emailc ast4 = new emailc(0);
	
	public int functiond(JFrame frame, Socket client, String id)
	{
		try{
			OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         InputStream inFromServer = client.getInputStream();
	         out.writeInt(5);
	         out.writeUTF(id);
	         InetAddress address = InetAddress.getLocalHost();
	         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
	         byte mac[] = nwi.getHardwareAddress();
	         StringBuilder sb = new StringBuilder(18);
	         for (byte b : mac) {
	             if (sb.length() > 0)
	                 sb.append(':');
	             sb.append(String.format("%02x", b));
	         }  
	         out.writeUTF(sb.toString());
	      

		
		}catch(Exception e)
         {
	         System.out.println(e);
	         }
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return 1;
	}
	public int functiond(JFrame frame, Socket client, String id, int k)
	{
		try{
			OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         InputStream inFromServer = client.getInputStream();
	         out.writeInt(k);
	         out.writeUTF(id);
	         InetAddress address = InetAddress.getLocalHost();
	         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
	         byte mac[] = nwi.getHardwareAddress();
	         StringBuilder sb = new StringBuilder(18);
	         for (byte b : mac) {
	             if (sb.length() > 0)
	                 sb.append(':');
	             sb.append(String.format("%02x", b));
	         }  
	         out.writeUTF(sb.toString());
	      

		
		}catch(Exception e)
         {
	         System.out.println(e);
	         }
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return 1;
	}
	public loginpage(Socket client,String id)
	{

		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(functiond(frame,client,id));
		 Container contentPane = frame.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        contentPane.setLayout(layout);
	        JLabel label = new JLabel("Username:");
	        JTextField textField = new JTextField("", 15);
	        contentPane.add(label);
	        contentPane.add(textField);
	        JLabel label2 = new JLabel("Password:");
	        JTextField textField2 = new JTextField("", 15);
	        contentPane.add(label2);
	        contentPane.add(textField2);
	        JButton enter = new JButton("Enter");
	        contentPane.add(enter);
	        
	        JLabel label3 = new JLabel("Create account");
	        JLabel label4 = new JLabel("Forgot password");
	        
	        label3.setForeground(Color.BLUE);
	        label4.setForeground(Color.BLUE);
	       
	        MouseListener enter2 = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					try{
						OutputStream outToServer = client.getOutputStream();
				         DataOutputStream out = new DataOutputStream(outToServer);
				         InputStream inFromServer = client.getInputStream();
				         DataInputStream in = new DataInputStream(inFromServer);
				         out.writeInt(2);
				         out.writeUTF(id);
				         InetAddress address = InetAddress.getLocalHost();
				         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
				         byte mac[] = nwi.getHardwareAddress();
				         StringBuilder sb = new StringBuilder(18);
				         for (byte b : mac) {
				             if (sb.length() > 0)
				                 sb.append(':');
				             sb.append(String.format("%02x", b));
				         }  
				         out.writeUTF(sb.toString());
				         out.writeUTF(textField.getText());
				         out.writeUTF(textField2.getText());
				         boolean ty = in.readBoolean();
				         boolean hack = in.readBoolean();
							if(hack)
							{
											
							}
							else if(ty)
							{
								loginpage loggedin = new loginpage(id,1,client,textField.getText());
								System.out.println("acces granted");
							}
							else
							{
								textField.setText("Invalid username/Password");
								textField2.setText("");
							}
					
			
					
					}catch(Exception e)
			         {
				         System.out.println(e);
				         }
					

				}
	};
			enter.addMouseListener(enter2);
	        MouseListener l = new MouseAdapter() 
	        {
	            Font original;

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                original = e.getComponent().getFont();
	                Map attributes = original.getAttributes();
	                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	                e.getComponent().setFont(original.deriveFont(attributes));
	            }
	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                loginpage e = new loginpage("e",client,id);
	               

	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                e.getComponent().setFont(original);
	            }


	        };
	        
	        MouseListener a = new MouseAdapter() 
	        {
	            Font original;

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                original = e.getComponent().getFont();
	                Map attributes = original.getAttributes();
	                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	                e.getComponent().setFont(original.deriveFont(attributes));
	            }

	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                loginpage b = new loginpage(1,client,id);
	               

	            }
	            
	            @Override
	            public void mouseExited(MouseEvent e) {
	                e.getComponent().setFont(original);
	            }


	        };
	      
	        label3.addMouseListener(a);
	        contentPane.add(label3);
	        
	        label4.addMouseListener(l);
	        contentPane.add(label4);
	        
	        layout.putConstraint(SpringLayout.WEST, label,5,SpringLayout.WEST, contentPane);
	        layout.putConstraint(SpringLayout.NORTH, label,5,SpringLayout.NORTH, contentPane);
	        
	        layout.putConstraint(SpringLayout.EAST, label2,0,SpringLayout.EAST, label);	        
	        layout.putConstraint(SpringLayout.NORTH, label2,10,SpringLayout.SOUTH, label);
	        
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enter,0,SpringLayout.HORIZONTAL_CENTER, textField);
	        layout.putConstraint(SpringLayout.NORTH, enter,15,SpringLayout.SOUTH, label2);
	        
	        layout.putConstraint(SpringLayout.EAST, label3,-5,SpringLayout.HORIZONTAL_CENTER, enter);	        
	        layout.putConstraint(SpringLayout.NORTH, label3,5,SpringLayout.SOUTH, enter);
	        
	        layout.putConstraint(SpringLayout.WEST, label4,5,SpringLayout.HORIZONTAL_CENTER, enter);	        
	        layout.putConstraint(SpringLayout.NORTH, label4,5,SpringLayout.SOUTH, enter);
	        

	        layout.putConstraint(SpringLayout.WEST, textField,5,SpringLayout.EAST, label); 
	        
	        layout.putConstraint(SpringLayout.NORTH, textField,0,SpringLayout.NORTH, label);
	        
	        layout.putConstraint(SpringLayout.WEST, textField2,5,SpringLayout.EAST, label2);
	        
	        layout.putConstraint(SpringLayout.NORTH, textField2,5,SpringLayout.SOUTH, textField);
	        
	        

	        layout.putConstraint(SpringLayout.EAST, contentPane,200,SpringLayout.EAST, label);
	  
	        layout.putConstraint(SpringLayout.SOUTH, contentPane,5,SpringLayout.SOUTH, label3);
	        
	
	       
	        frame.pack();
	        frame.setVisible(true);
	}
	public loginpage(int n,Socket client,String id)
	{
		createAndShowGUI(client, id);
	}

	 private void createAndShowGUI(Socket client, String id) 
 {
		JTextField a = new JTextField();
		String[] labels = { "Username: ", "Password: ", "Confirm Password: ",
				"Email: " };
		ArrayList<JTextField> textfields = new ArrayList<JTextField>();
		int numPairs = labels.length;

		// Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			textfields.add(textField);
			a = textField;
			l.setLabelFor(textField);
			p.add(textField);
		}
		JFrame frame = new JFrame("Create Account");
		frame.setDefaultCloseOperation(functiond(frame,client,id));
		SpringLayout lay = SpringUtilities.makeCompactGrid(p, numPairs, 2, 6, 6, 6, 15);
		// error asterisk

		textfields.get(0).addFocusListener(
				asterisk(textfields.get(0), lay, frame, p, ast1, textfields));
		textfields.get(1).addFocusListener(
				asterisk(textfields.get(1), lay, frame, p, ast2, textfields));
		textfields.get(2).addFocusListener(
				asterisk(textfields.get(2), lay, frame, p, ast3, textfields));
		textfields.get(3).addFocusListener(
				asterisk(textfields.get(3), lay, frame, p, ast4, textfields));
		

		JButton enterb = new JButton("enter");
		
		
		MouseListener enter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
					String s1 = textfields.get(0).getText();
					String s2 = textfields.get(1).getText();
					String s3 = textfields.get(2).getText();
					String s4 = textfields.get(3).getText();
					// 0 means draw error
					// 1 means error is drawn
					// 2 means no error

					int dto1 = ast1.errorc(ast1.checke(s1, s2));
					int dto2 = ast2.errorc(ast2.checke(s2, s2));
					int dto3 = ast3.errorc(ast3.checke(s3, s2));
					int dto4 = ast4.errorc(ast4.checke(s4, s2));
					if(dto1 == 2 && dto2 == 2 && dto3 == 2 && dto4 == 2)
					{
						try{
							OutputStream outToServer = client.getOutputStream();
					         DataOutputStream out = new DataOutputStream(outToServer);
					         InputStream inFromServer = client.getInputStream();
					         DataInputStream in = new DataInputStream(inFromServer);
					         PasswordAuthentication pa = new PasswordAuthentication(s2);
					         out.writeInt(1);
					         out.writeUTF(id);
					         InetAddress address = InetAddress.getLocalHost();
					         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
					         byte mac[] = nwi.getHardwareAddress();
					         StringBuilder sb = new StringBuilder(18);
					         for (byte b : mac) {
					             if (sb.length() > 0)
					                 sb.append(':');
					             sb.append(String.format("%02x", b));
					         }  
					         out.writeUTF(sb.toString());
					         out.writeUTF(s1);
					         out.writeUTF(pa.getHash());
					         out.writeUTF(s4);
					        
					         //boolean b = in.readBoolean();
					         int con = in.readInt();
					         if(con == 0)
					         {
					        	 loginpage loggedin = new loginpage(id,1,client,textfields.get(0).getText());
					         }
					         else if(con == 1)
					         {
					        	 ast1.errorc(12);
					        	 ast1.settsa(0);
									p.add(ast1.last);
									lay.putConstraint(SpringLayout.NORTH, ast1.last, 0,
											SpringLayout.SOUTH, textfields.get(0));
									lay.putConstraint(SpringLayout.WEST, ast1.last, 0,
											SpringLayout.WEST, textfields.get(0));
								
								if (ast1.gettsa() == 0) {
									ast1.settsa(1);
									frame.setContentPane(p);
									frame.pack();
									frame.setVisible(true);
								} 
					         }
					         else
					         {
					        	 textfields.get(0).setText("Error");
					         }
						
						//serial s = new serial(s1,,s4);
						
						/*boolean y = s.serialize("H:/classes/",s);
						if(!y)
						{
							System.out.println("test");
						}*/
						
						}catch(NoSuchAlgorithmException e){}catch(InvalidKeySpecException e){}catch(Exception e)
				         {
					         System. out. println(e);
					         }
						
						
						
					}
					else
					{
						System.out.println("fail");
					}
			

			}
		};
		enterb.addMouseListener(enter);

		p.add(enterb);
		lay.putConstraint(SpringLayout.HORIZONTAL_CENTER, enterb, 0,
				SpringLayout.HORIZONTAL_CENTER, a);
		lay.putConstraint(SpringLayout.NORTH, enterb, 20, SpringLayout.SOUTH, a);

		p.setOpaque(true);

		frame.setContentPane(p);
		frame.pack();
		frame.setVisible(true);
	};
		
          public void actionPerformed(ActionEvent e) {
              //loginpage c = new loginpage(2,client);
             
          }

	private FocusListener asterisk(JTextField tf, SpringLayout lay,
			JFrame frame, JPanel p, ast ast0, ArrayList<JTextField> textfields) {

		return new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent arg0) {

				String s = tf.getText();
				String s2 = textfields.get(1).getText();
				// 0 means draw error
				// 1 means error is drawn
				// 2 means no error

				int en = ast0.checke(s, s2);
				int dto = ast0.errorc(en);
				if (dto == 0) {
					ast0.settsa(0);
					p.add(ast0.last);
					lay.putConstraint(SpringLayout.NORTH, ast0.last, 0,
							SpringLayout.SOUTH, tf);
					lay.putConstraint(SpringLayout.WEST, ast0.last, 0,
							SpringLayout.WEST, tf);
				} else if (dto == 2) {
					ast0.reset(p);
					p.add(ast0.last);
					lay.putConstraint(SpringLayout.NORTH, ast0.last, 0,
							SpringLayout.SOUTH, tf);
					lay.putConstraint(SpringLayout.WEST, ast0.last, 0,
							SpringLayout.WEST, tf);
					ast0.settsa(2);
				} else {
					ast0.settsa(1);
				}
				if (ast0.gettsa() == 0) {
					ast0.settsa(1);
					frame.setContentPane(p);
					frame.pack();
					frame.setVisible(true);
				} else if (ast0.gettsa() == 2) {
					frame.pack();
					frame.setVisible(true);
				}

			}
		};
	}
         
	public loginpage(Socket client, String id, int n, String j)
	{
		   JFrame frame = new JFrame("Password Reset");
		   JPanel p = new JPanel();
		   frame.setDefaultCloseOperation(functiond(frame,client,id,4));
			 Container contentPane = frame.getContentPane();
		        SpringLayout layout = new SpringLayout();
		        contentPane.setLayout(layout);
		        JLabel label = new JLabel("Password");
		        JTextField textField = new JTextField("", 15);
		        contentPane.add(label);
		        contentPane.add(textField);
		        JLabel label2 = new JLabel("Confirm Password");
		        JTextField textField2 = new JTextField("", 15);
		        contentPane.add(label2);
		        contentPane.add(textField2);
		        JLabel label3 = new JLabel("Code");
		        JTextField textField3 = new JTextField("", 15);
		        contentPane.add(label3);
		        contentPane.add(textField3);
		        JButton enter = new JButton("Enter");
		        contentPane.add(enter);
		        ArrayList<JTextField> textfields = new  ArrayList<JTextField>();
		        textfields.add(textField);
		        textfields.add(textField2);
		        
		        textfields.get(0).addFocusListener(asterisk(textfields.get(0), layout, frame, p, ast1, textfields));
				textfields.get(1).addFocusListener(asterisk(textfields.get(1), layout, frame, p, ast2, textfields));
		        MouseListener enter2 = new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) 
					{
						String s2 = textfields.get(1).getText();
						String s3 = textfields.get(2).getText();
						// 0 means draw error
						// 1 means error is drawn
						// 2 means no error
						int dto2 = ast2.errorc(ast2.checke(s2, s2));
						int dto3 = ast3.errorc(ast3.checke(s3, s2));

						if(dto2 == 2 && dto3 == 2)
						{
							try{
								OutputStream outToServer = client.getOutputStream();
						         DataOutputStream out = new DataOutputStream(outToServer);
						         InputStream inFromServer = client.getInputStream();
						         DataInputStream in = new DataInputStream(inFromServer);
						         PasswordAuthentication pa = new PasswordAuthentication(s2);
						         out.writeInt(1);
						         out.writeUTF(id);
						         InetAddress address = InetAddress.getLocalHost();
						         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
						         byte mac[] = nwi.getHardwareAddress();
						         StringBuilder sb = new StringBuilder(18);
						         for (byte b : mac) {
						             if (sb.length() > 0)
						                 sb.append(':');
						             sb.append(String.format("%02x", b));
						         }  
						         
						         out.writeUTF(sb.toString());
						         out.writeUTF(textField3.getText());
						         out.writeUTF(pa.getHash());
					        
						         //boolean b = in.readBoolean();
						         int con = in.readInt();
						         if(con == 0)
						         {
						        	 loginpage loggedin = new loginpage(id,1,client,textfields.get(0).getText());
						         }
						         else if(con == 2)
						         {
						        	 ast1.errorc(12);
						        	 ast1.settsa(0);
										p.add(ast1.last);
										layout.putConstraint(SpringLayout.NORTH, ast1.last, 0,
												SpringLayout.SOUTH, textfields.get(0));
										layout.putConstraint(SpringLayout.WEST, ast1.last, 0,
												SpringLayout.WEST, textfields.get(0));
									
									if (ast1.gettsa() == 0) {
										ast1.settsa(1);
										frame.setContentPane(p);
										frame.pack();
										frame.setVisible(true);
									} 
						         }
						         else
						         {
						        	 textfields.get(0).setText("Error");
						         }						
							}catch(NoSuchAlgorithmException e){}catch(InvalidKeySpecException e){}catch(Exception e)
					         {
						         System. out. println(e);
						         }						
						}
						else
						{
							System.out.println("fail");
						}
					}
		        };
	}
   public loginpage(String s,Socket client,String id)
   {
	   JFrame frame = new JFrame("Password Reset");
	   frame.setDefaultCloseOperation(functiond(frame,client,id,5));
		 Container contentPane = frame.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        contentPane.setLayout(layout);
	        JLabel label = new JLabel("Username:");
	        JTextField textField = new JTextField("", 15);
	        contentPane.add(label);
	        contentPane.add(textField);
	        JLabel label2 = new JLabel("Email:");
	        JTextField textField2 = new JTextField("", 15);
	        contentPane.add(label2);
	        contentPane.add(textField2);
	        JButton enter = new JButton("Enter");
	        contentPane.add(enter);

	        MouseListener enter2 = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					try
					{
					OutputStream outToServer = client.getOutputStream();
			         DataOutputStream out = new DataOutputStream(outToServer);
			         InputStream inFromServer = client.getInputStream();
			         DataInputStream in = new DataInputStream(inFromServer);
			         out.writeInt(3);
			         out.writeUTF(id);
			         InetAddress address = InetAddress.getLocalHost();
			         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
			         byte mac[] = nwi.getHardwareAddress();
			         StringBuilder sb = new StringBuilder(18);
			         for (byte b : mac) {
			             if (sb.length() > 0)
			                 sb.append(':');
			             sb.append(String.format("%02x", b));
			         }  
			         out.writeUTF(sb.toString());
			         out.writeUTF(textField.getText());
			         out.writeUTF(textField2.getText());


							boolean b = in.readBoolean();
							if(b)
							{
								loginpage l = new loginpage(client, id, 1, textField.getText());	
							}
							else if(!b)
							{
								textField.setText("Invalid username");
								textField2.setText("");

							}
							else
							{
								textField.setText("Error");
								textField2.setText("");
							}
					}catch(Exception e)
			         {
				         System.out.println(e);
				         }

				}
	};
			enter.addMouseListener(enter2);
	       
	        
	        layout.putConstraint(SpringLayout.WEST, label,5,SpringLayout.WEST, contentPane);
	        layout.putConstraint(SpringLayout.NORTH, label,5,SpringLayout.NORTH, contentPane);
	        
	        layout.putConstraint(SpringLayout.EAST, label2,0,SpringLayout.EAST, label);	        
	        layout.putConstraint(SpringLayout.NORTH, label2,10,SpringLayout.SOUTH, label);
	        
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enter,0,SpringLayout.HORIZONTAL_CENTER, textField);
	        layout.putConstraint(SpringLayout.NORTH, enter,15,SpringLayout.SOUTH, label2);
	        
	        
	        layout.putConstraint(SpringLayout.WEST, textField,5,SpringLayout.EAST, label); 
	        
	        layout.putConstraint(SpringLayout.NORTH, textField,0,SpringLayout.NORTH, label);
	        
	        layout.putConstraint(SpringLayout.WEST, textField2,5,SpringLayout.EAST, label2);
	        
	        layout.putConstraint(SpringLayout.NORTH, textField2,5,SpringLayout.SOUTH, textField);
	        
	        

	        layout.putConstraint(SpringLayout.EAST, contentPane,200,SpringLayout.EAST, label);
	  
	        layout.putConstraint(SpringLayout.SOUTH, contentPane,5,SpringLayout.SOUTH, enter);
	        
	
	       
	        frame.pack();
	        frame.setVisible(true);
   }
	
   public loginpage(String s, int n)
   {
	   JFrame frame = new JFrame("Server Connect");
	   
		 Container contentPane = frame.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        contentPane.setLayout(layout);
	        JLabel label1 = new JLabel("Monster");
	        label1.setFont(new Font("Serif", Font.BOLD, 40));
	        JLabel label2 = new JLabel("Login Service By: Dominic G");
	        label2.setFont(new Font("Serif", Font.PLAIN, 25));
	        String g = "Connecting to server: ";
	        String h = g;
	        JLabel label3 = new JLabel(g);
	        contentPane.add(label1);
	        contentPane.add(label2);
	        contentPane.add(label3);
	        layout.putConstraint(SpringLayout.SOUTH,contentPane,180,SpringLayout.NORTH,contentPane);
	        layout.putConstraint(SpringLayout.EAST,contentPane,400,SpringLayout.WEST,contentPane);
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label1,0,SpringLayout.HORIZONTAL_CENTER, contentPane);
	        layout.putConstraint(SpringLayout.NORTH, label1,20,SpringLayout.NORTH, contentPane);
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label2,0,SpringLayout.HORIZONTAL_CENTER, label1);	        
	        layout.putConstraint(SpringLayout.NORTH, label2,0,SpringLayout.SOUTH, label1);
	        layout.putConstraint(SpringLayout.WEST, label3,0,SpringLayout.WEST, label2);	        
	        layout.putConstraint(SpringLayout.NORTH, label3,5,SpringLayout.SOUTH, label2); 
	        frame.pack();
	        frame.setVisible(true);
	        String serverName =  "sticky.efrog.org";//201-lb163-299/10.136.12.10";
	       
		      int port = 10133;
		      try {
		         Socket client = new Socket(serverName, port);
		         System.out.println("hello");
		         try{
		         InetAddress address = InetAddress.getLocalHost();
		         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
		         byte mac[] = nwi.getHardwareAddress();
		         StringBuilder sb = new StringBuilder(18);
		         for (byte b : mac) {
		             if (sb.length() > 0)
		                 sb.append(':');
		             sb.append(String.format("%02x", b));
		         }
		         OutputStream outToServer = client.getOutputStream();
		         DataOutputStream out = new DataOutputStream(outToServer);
		         out.writeUTF(sb.toString());
		         InputStream inFromServer = client.getInputStream();
		         DataInputStream in = new DataInputStream(inFromServer);
		         Boolean status = in.readBoolean();
		         String ident = in.readUTF();
		         frame.setDefaultCloseOperation(functiond(frame,client,ident,5));
		        
		         if(status)
		         {
		        	 String username = in.readUTF();
		        	 Boolean status2 = in.readBoolean();
		        	 if(status2)
		        	 {
		        	 loginpage loggedin = new loginpage(ident,1,client,username);
		        	 }
		        	 else
		        	 {
		        	 loginpage loggedinp = new loginpage(client,ident,username);
		        	 }
		         }
		         else
		         {
		        	 loginpage a = new loginpage(client,ident);
		         }
		         client.close();
		         }
		         catch(Exception e)
		         {
		         System. out. println(e);
		         }
		       

		         
		      }catch(IOException e) {
		         e.printStackTrace();
		      }
	        
   }
   public loginpage(String id,int j,Socket client,String username)
	{
	   JFrame frame = new JFrame("Logged in");
	   frame.setDefaultCloseOperation(functiond(frame,client,id,4));
		 Container contentPane = frame.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        contentPane.setLayout(layout);
	        
	        JLabel label = new JLabel(username);
	        contentPane.add(label);
	        
	        JLabel label2 = new JLabel("Sign out");
	        contentPane.add(label2);
	        
	        MouseListener a = new MouseAdapter() 
	        {
	            Font original;

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                original = e.getComponent().getFont();
	                Map attributes = original.getAttributes();
	                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	                e.getComponent().setFont(original.deriveFont(attributes));
	            }

	            @Override
	            public void mouseClicked(MouseEvent arg0) {

	                try
					{
					OutputStream outToServer = client.getOutputStream();
			         DataOutputStream out = new DataOutputStream(outToServer);
			         InputStream inFromServer = client.getInputStream();
			         DataInputStream in = new DataInputStream(inFromServer);
			         out.writeInt(4);
			         out.writeUTF(id);
			         InetAddress address = InetAddress.getLocalHost();
			         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
			         byte mac[] = nwi.getHardwareAddress();
			         StringBuilder sb = new StringBuilder(18);
			         for (byte b : mac) {
			             if (sb.length() > 0)
			                 sb.append(':');
			             sb.append(String.format("%02x", b));
			         }  
			         out.writeUTF(sb.toString());
			         boolean lgo = in.readBoolean();
			         if(lgo)
			         {
			        	 
			         }
			         else
			         {
			        	 
			         }


	
					}catch(Exception e)
			         {
				         System.out.println(e);
				         }

	            }
	            
	            @Override
	            public void mouseExited(MouseEvent e) {
	                e.getComponent().setFont(original);
	            }


	        };
	      
	        label2.addMouseListener(a);
	        layout.putConstraint(SpringLayout.SOUTH,contentPane,180,SpringLayout.NORTH,contentPane);
	        layout.putConstraint(SpringLayout.EAST,contentPane,400,SpringLayout.WEST,contentPane);
	        
	        layout.putConstraint(SpringLayout.EAST, label,20,SpringLayout.EAST, contentPane);
	        layout.putConstraint(SpringLayout.NORTH, label,10,SpringLayout.NORTH, contentPane);
	        layout.putConstraint(SpringLayout.WEST, label2,10,SpringLayout.EAST, label);
	        layout.putConstraint(SpringLayout.NORTH, label2,10,SpringLayout.NORTH, contentPane);
	        
	        frame.pack();
	        frame.setVisible(true);
	       
	}
   public loginpage(Socket client,String id, String username)
	{

		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(functiond(frame,client,id,4));
		 Container contentPane = frame.getContentPane();
	        SpringLayout layout = new SpringLayout();
	        contentPane.setLayout(layout);
	        JLabel label = new JLabel(username);	      
	        contentPane.add(label);
	        JLabel label2 = new JLabel("Password:");
	        JTextField textField2 = new JTextField("", 15);
	        contentPane.add(label2);
	        contentPane.add(textField2);
	        JButton enter = new JButton("Enter");
	        contentPane.add(enter);
	        
	        JLabel label3 = new JLabel("Create account");
	        JLabel label4 = new JLabel("Forgot password");
	        
	        label3.setForeground(Color.BLUE);
	        label4.setForeground(Color.BLUE);
	       
	        MouseListener enter2 = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					try{
						OutputStream outToServer = client.getOutputStream();
				         DataOutputStream out = new DataOutputStream(outToServer);
				         InputStream inFromServer = client.getInputStream();
				         DataInputStream in = new DataInputStream(inFromServer);
				         out.writeInt(2);
				         out.writeUTF(id);
				         InetAddress address = InetAddress.getLocalHost();
				         NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
				         byte mac[] = nwi.getHardwareAddress();
				         StringBuilder sb = new StringBuilder(18);
				         for (byte b : mac) {
				             if (sb.length() > 0)
				                 sb.append(':');
				             sb.append(String.format("%02x", b));
				         }  
				         out.writeUTF(sb.toString());
				         out.writeUTF(username);
				         out.writeUTF(textField2.getText());
				         boolean ty = in.readBoolean();
				         boolean hack = in.readBoolean();
							if(hack)
							{
											
							}
							else if(ty)
							{
								//insert secure site here
								loginpage loggedin = new loginpage(id,1,client,username);
							}
							else
							{
								textField2.setText("Invalid Password");
							}
					
			
					
					}catch(Exception e)
			         {
				         System.out.println(e);
				         }
					

				}
	};
			enter.addMouseListener(enter2);
	        MouseListener l = new MouseAdapter() 
	        {
	            Font original;

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                original = e.getComponent().getFont();
	                Map attributes = original.getAttributes();
	                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	                e.getComponent().setFont(original.deriveFont(attributes));
	            }
	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                loginpage e = new loginpage("e",client,id);
	               

	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                e.getComponent().setFont(original);
	            }


	        };
	        
	        MouseListener a = new MouseAdapter() 
	        {
	            Font original;

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                original = e.getComponent().getFont();
	                Map attributes = original.getAttributes();
	                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	                e.getComponent().setFont(original.deriveFont(attributes));
	            }

	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                loginpage b = new loginpage(1,client,id);
	               

	            }
	            
	            @Override
	            public void mouseExited(MouseEvent e) {
	                e.getComponent().setFont(original);
	            }


	        };
	      
	        label3.addMouseListener(a);
	        contentPane.add(label3);
	        
	        label4.addMouseListener(l);
	        contentPane.add(label4);
	        
	        layout.putConstraint(SpringLayout.WEST, label2,10,SpringLayout.WEST, contentPane);
	        layout.putConstraint(SpringLayout.NORTH, label2,30,SpringLayout.NORTH, contentPane);
	        
	        layout.putConstraint(SpringLayout.WEST, textField2,0,SpringLayout.EAST, label2);
	        layout.putConstraint(SpringLayout.NORTH, textField2,0,SpringLayout.NORTH, label2);
	        
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label,0,SpringLayout.HORIZONTAL_CENTER,textField2);	        
	        layout.putConstraint(SpringLayout.SOUTH, label,-5,SpringLayout.NORTH, label2);
	        
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enter,0,SpringLayout.HORIZONTAL_CENTER, textField2);
	        layout.putConstraint(SpringLayout.NORTH, enter,15,SpringLayout.SOUTH, label2);
	        
	        layout.putConstraint(SpringLayout.EAST, label3,-5,SpringLayout.HORIZONTAL_CENTER, enter);	        
	        layout.putConstraint(SpringLayout.NORTH, label3,5,SpringLayout.SOUTH, enter);
	        
	        layout.putConstraint(SpringLayout.WEST, label4,5,SpringLayout.HORIZONTAL_CENTER, enter);	        
	        layout.putConstraint(SpringLayout.NORTH, label4,5,SpringLayout.SOUTH, enter);
	        
	        
	     
	        
	        

	        layout.putConstraint(SpringLayout.EAST, contentPane,300,SpringLayout.EAST, label2);
	  
	        layout.putConstraint(SpringLayout.SOUTH, contentPane,5,SpringLayout.SOUTH, label3);
	        
	
	       
	        frame.pack();
	        frame.setVisible(true);
	}
	
   public static void main(String[] args)
	{
	   //Socket client = new Socket();
	   
	   //loginpage y = new loginpage(client,"s");
	  loginpage y = new loginpage("s",1);
		//loginpage a = new loginpage();
	     

	}
}