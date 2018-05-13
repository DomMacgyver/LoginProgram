package Jframet;

import java.util.ArrayList;
import java.util.Date;
import java.net.*;
import java.io.*;
import java.security.SecureRandom;
import java.math.BigInteger;

public class server extends Thread
{
	private SecureRandom random = new SecureRandom();
	ArrayList<InetAddress> clients = new ArrayList<InetAddress>();
	ArrayList<String> macs = new ArrayList<String>();
	ArrayList<String> ips = new ArrayList<String>();
	ArrayList<String> ids = new ArrayList<String>();
	ArrayList<Boolean> logs = new ArrayList<Boolean>();
	ArrayList<serial> se = new ArrayList<serial>();
	ArrayList<Date> d = new ArrayList<Date>();
	ArrayList<Date> df = new ArrayList<Date>();
	ArrayList<Integer> dft = new ArrayList<Integer>();
	ArrayList<String> Usernames = new ArrayList<String>();
	ArrayList<Date> failsd = new ArrayList<Date>();
	ArrayList<Integer> failst = new ArrayList<Integer>();
	


	private ServerSocket serverSocket;

	public boolean hackc(int n,String q)
	{
		boolean b = true;
		if(dft.get(n) < 5  && failst.get(n) < 5)
		{
			b = false;
		}
		else if(dft.get(n) < 5)
		{
			b = true;
			failsd.set(Usernames.lastIndexOf(q), new Date());
		}
		else if(failst.get(n) < 5)
		{
			b = true;
			df.set(n,new Date());
		}
		else
		{
			b = false;
			failsd.set(Usernames.lastIndexOf(q), new Date());
			df.set(n,new Date());
		}
		return b;
	}
	public server(int port) throws IOException {
		System.out.println("t");
		serverSocket = new ServerSocket(port);

		System.out.println(serverSocket.getInetAddress().getLocalHost());
		serverSocket.setSoTimeout(1000000);
	}

	public void run() {
		while (true) {
			try {

				Socket server = serverSocket.accept();
				DataInputStream in = new DataInputStream(server.getInputStream());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
		        String mac = in.readUTF();
		        serial sr = new serial();
		        int n = macs.lastIndexOf(mac);
				boolean daex = true;
				String id = "";
				int code = 0;
				Date da = new Date();
		        if(n == -1)
		        {
		        	macs.add(mac);
		        	n = macs.lastIndexOf(mac);
		        	logs.add(n,false);
		        	d.add(n,null);
		        	out.writeBoolean(false);
					d.add(n,null);
		        }
				if(d.get(n) == null)
				{
					daex = false;
				}
					
		        if(daex && logs.get(n))
		        {
		        	out.writeBoolean(true);
	        		id = ids.get(n);
	        		out.writeUTF(ids.get(n));
	        		out.writeUTF(Usernames.get(n));
					if(da.getTime() - 864000 < d.get(n).getTime())
					{
		        		out.writeBoolean(true);
					}
					else
					{
		        		out.writeBoolean(false);
					}
		        }
		        else
		        {
		        	
		        	id = new BigInteger(130, random).toString(32);
		        	out.writeUTF(id);
		        	ids.set(n, id);
		        	String clid;
		        	boolean ty = false;
		        	boolean hack = false;
		        	int s = 5;
		        	while(!ty && s != 0)
		        	{
		        	s = in.readInt();
		        	clid = in.readUTF();
		        	String m = in.readUTF();
		        	if(s == 0)
		        	{
		        	}
		        	else if(s == 1)
		        	{
		        		String q = in.readUTF();
		        		String w =  in.readUTF();
		        		String e =  in.readUTF();
		        		if(m != mac)
						{
							hack = true;
						}
		        		if(clid != id)
						{
							hack = true;
						}
		        		macs.add(m);
		        		serial seri = new serial(q,w,e,m);
		        		se.add(seri);
		        		int y = seri.serialize("D:/",seri);
						if(y == 0)
						{
							out.writeInt(0);
						}
						else if(y == 1)
						{
							out.writeInt(1);
						}
						else
						{
							out.writeInt(2);
						}
		        	}
		        	else if(s == 2)
		        	{
		        		String q = in.readUTF();
		        		String w =  in.readUTF();
		        		serial sre = new serial();
						ty = sre.deserial(q, w);
						if(ty)
						{
							dft.set(n,0);
							df.set(n,null);
							failst.set(Usernames.lastIndexOf(q),0);
							failsd.set(Usernames.lastIndexOf(q),null);
						}
						else
						{
							dft.set(n,dft.get(n)+1);
							failst.set(Usernames.lastIndexOf(q),failst.get(Usernames.lastIndexOf(q))+1);
							hack = hackc(n,q);
						}
						if(m != mac)
						{
							hack = true;
						}
						if(clid != id)
						{
							hack = true;
						}
						out.writeBoolean(ty);
						out.writeBoolean(hack);
		        	}
		        	else if(s == 7)
		        	{
		        		int cc = in.readInt();
		        		if(cc == code)
		        		{
		        			
				        	int i = 2;
				        	
				        	String p = in.readUTF();
				        	
				        	if(m != mac)
							{
								hack = true;
							}
			        		if(clid != id)
							{
								hack = true;
							}
			        		if(!hack)
			        		{
			        			if(sr.passwordchange(Usernames.get(n),p,1))
			        			{
			        				i = 0;
			        			}
			        		}
			        		else
			        		{
			        			i = 1;
			        		}
			        		
				        	
				        	out.writeInt(i);
		        	}
		        	else if(s == 3)
		        	{
		        		String q = in.readUTF();
		        		String w =  in.readUTF();
		        		if(m != mac)
						{
							hack = true;
						}
		        		if(clid != id)
						{
							hack = true;
						}
		        		macs.add(m);
		        		
		        		code = sr.emailtest(q, w);
		        		
		        		}
		        		else if(s == 4)
		        		{
		        			if(m != mac)
							{
								hack = true;
							}
			        		if(clid != id)
							{
								hack = true;
							}
			        		if(!hack)
			        		{
			        			d.set(n, new Date());
			        			ids.set(n, null);
			        			logs.set(n,false);
			        			out.writeBoolean(true);
			        			
			        		}
			        		else
			        		{
			        			out.writeBoolean(false);
			        		}
		        		}
		        		else if(s == 5)
		        		{
		        			if(m != mac)
							{
								hack = true;
							}
			        		if(clid != id)
							{
								hack = true;
							}
			        		if(!hack)
			        		{
			        			ids.set(n, null);
			        		}
		        		}
		        		else
		        		{
		        			out.writeBoolean(false);
		        		}
		        		
		        	}
		        	}
		        }

				out.writeUTF("Thank you for connecting to "
						+ server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		
		int port = Integer.parseInt("25");
		try {
			Thread t = new server(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}  