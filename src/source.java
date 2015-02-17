import java.io.*;
import java.util.*;

public class source
{
	class Juice
	{
		TreeSet<String> x;
		Juice()
		{
			x=new TreeSet<String>();
		}
		public int compare(Juice a)
		{
			Iterator it1=x.iterator(),it2=a.x.iterator();
			while (it1.hasNext() && it2.hasNext())
			{
				String s1=(String)it1.next(),s2=(String)it2.next();
				if (s1.compareTo(s2)==0)
					continue;
				else
					return s1.compareTo(s2);
			}
			if (it1.hasNext())
				return 1;
			return -1;
		}
		public boolean equals(Juice a)
		{
			Iterator it1=x.iterator(),it2=a.x.iterator();
			while (it1.hasNext() && it2.hasNext())
			{
				String s1=(String)it1.next(),s2=(String)it2.next();
				if (s1.compareTo(s2)!=0)
					return false;
			}
			return true;
		}
		void add(String s)
		{
			x.add(s);
		}
	}
	BufferedReader in;
	PrintWriter out1,out2,out3;
	ArrayList<Juice> juices;
	TreeSet<String> components;
	public static void main(String[] args) throws IOException
	{
		new source().run();
	}
	void run() throws IOException
	{
		out3=new PrintWriter(new FileWriter("juice3.out"));
		juices=new ArrayList<Juice>();
		components=new TreeSet<String>();
		input();
		print();
		juices.sort(new Comparator<Juice>()
				{
			public int compare(Juice a,Juice b)
			{
				return a.compare(b);
			}
				});
		for (Juice ts:juices)
		{
			for (String s:ts.x)
			{
				out3.print(s+" ");
			}
			out3.println();
		}
		Iterator it1=juices.iterator(),it2=juices.iterator();
		if (it2.hasNext())
			it2.next();
		int count=1;
		while (it2.hasNext())
		{
			if (!((Juice)it1.next()).equals((Juice)it2.next()))
					count++;
		}
		out3.printf("\r\n%d", count);
		out3.close();
	}
	void input() throws IOException
	{
		in=new BufferedReader(new FileReader("juice.in"));
		out1=new PrintWriter(new FileWriter("juice1.out"));
		String tmp=in.readLine();
		StringTokenizer stmp;
		String s;
		Juice juiceTmp;
		while (tmp!=null)
		{
			juiceTmp=new Juice();
			stmp=new StringTokenizer(tmp);
			while (stmp.hasMoreTokens())
			{
				s=stmp.nextToken();
				if (s!=null)
				{
					components.add(s);
					juiceTmp.add(s);
					out1.println(s);
				}
			}
			juices.add(juiceTmp);
			tmp=in.readLine();
		}
		in.close();
		out1.close();
	}
	void print() throws IOException
	{
		out2=new PrintWriter(new FileWriter("juice2.out"));
		for (String s : components)
		{
			out2.println(s);
		}
		out2.close();
	}
}
