package LiveArchive;
import java.io.*;
import java.util.*;
public class LA_5133 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			n=sc.nextInt();
			initialMoney=sc.nextInt();
			days=sc.nextInt();
			if(n==0 && initialMoney==0 && days==0)
				break;
			machines=new machine[n+1];
			for(int i=0;i<n;i++)
				machines[i]=new machine(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			machines[n]=new machine(days+1, 0, 0, 0);
			Arrays.sort(machines);
			mem=new long [n+1];
			active=new TreeSet<pair>();
			for(int i=0;i<=n;i++){
				long ret=initialMoney;
				machine cur=machines[i];
				while(active.size()>1){
					pair l1=active.pollFirst();
					pair l2=active.first();
					
					long v1=1L*l1.m*cur.time+l1.c;
					long v2=1L*l2.m*cur.time+l2.c;
					if(v1>=v2){
						active.add(l1);
						break;
					}
				}
				if(!active.isEmpty())
					ret=Math.max(ret, active.first().m*cur.time+active.first().c);
				if(ret>=cur.buy){
					long C=ret-cur.buy+cur.sell-1L*cur.profit*(cur.time+1);
					long M=cur.profit;
					pair p=new pair(M, C);
					active.add(p);
					pair before=active.lower(p);
					pair after=active.higher(p);
					if(before!=null && before.m==p.m)
						active.remove(before);
					before=active.lower(p);
					
					if(after!=null && after.m==p.m){
						active.remove(p);
						continue;
					}
					if(before!=null && after!=null){
						if(!checkValid(before, p, after)){
							active.remove(p);
							continue;
						}
					}
					
					while(true){
						pair p1=p,p2=p,p3=p;
						if(p.equals(active.last()))
							break;
						p2=active.higher(p);
						if(p2.equals(active.last()))
							break;
						p3=active.higher(p2);
						if(!checkValid(p1, p2, p3))
							active.remove(p2);
						else
							break;
					}
					
					while(true){
						pair p1=p,p2=p,p3=p;
						if(p.equals(active.first()))
							break;
						p2=active.lower(p);
						if(p2.equals(active.first()))
							break;
						p1=active.lower(p2);
						if(!checkValid(p1, p2, p3))
							active.remove(p2);
						else
							break;
					}
				}
				mem[i]=ret;
			}
			pw.println("Case "+(id++)+": "+mem[n]);
		}
		
		pw.flush();
		pw.close();
	}
	static TreeSet<pair> active;
	static int n,initialMoney,days;
	static machine [] machines;
	static long [] mem;
	
	
	static boolean checkValid(pair l1,pair l2,pair l3){
		double i1=(1.0*l1.c-l3.c)/(l3.m-l1.m);
		double i2=(1.0*l2.c-l3.c)/(l3.m-l2.m);
		if(i2>i1)
			return true;
		return false;
	}
	
	static class pair implements Comparable<pair>{
		long m,c;
		
		pair(long a,long b){
			m=a;
			c=b;
		}
		
		public int compareTo(pair o) {
			if(m!=o.m)
				return Long.compare(m,o.m);
			return Long.compare(c,o.c);
		}
		
		public boolean equals(pair o){
			return m==o.m && c==o.c;
		}
	}
	
	static class machine implements Comparable<machine>{
		int time,buy,sell,profit;
		
		public machine(int t,int b,int s,int p) {
			time=t;
			buy=b;
			sell=s;
			profit=p;
		}
		
		public int compareTo(machine o) {
			return time-o.time;
		}
		
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	    	  try {
	    		  br=new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
}
