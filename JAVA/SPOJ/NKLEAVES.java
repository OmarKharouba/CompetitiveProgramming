import java.io.*;
import java.util.*;
public class NKLEAVES {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int maxK=sc.nextInt();
		long [] cum=new long [n];
		long [] arr=new long [n];
		for(int i=0;i<n;i++)
			cum[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			arr[i]=cum[i]*i;
		for(int i=1;i<n;i++){
			cum[i]+=cum[i-1];
			arr[i]+=arr[i-1];
		}
		
		long [][] mem=new long [maxK+1][n];
		TreeSet<pair> [] active=new TreeSet [maxK+1];
		for(int i=0;i<=maxK;i++)
			active[i]=new TreeSet<pair>();
		
		for(int k=1;k<=maxK;k++){
			for(int i=0;i<n;i++){
				if(k==1)
					mem[k][i]=arr[i];
				else
					mem[k][i]=Long.MAX_VALUE;
				while(active[k-1].size()>1){
					pair l1=active[k-1].pollLast();
					pair l2=active[k-1].last();
					
					long v1=1L*l1.m*cum[i]+l1.c;
					long v2=1L*l2.m*cum[i]+l2.c;
					if(v1<=v2){
						active[k-1].add(l1);
						break;
					}
				}
				
				if(!active[k-1].isEmpty()){
//					if(i==1 && k==2)
//						pw.println(active[k-1].last().m+" "+active[k-1].last().c);
					mem[k][i]=Math.min(mem[k][i], 1L*active[k-1].last().m*cum[i]+active[k-1].last().c+arr[i]);
				}
				
				long C=mem[k][i]+(i+1)*cum[i]-arr[i];
				long M=-(i+1);
				pair p=new pair(M, C,i);
				active[k].add(p);
				
				pair before=active[k].higher(p);
				pair after=active[k].lower(p);
				
				if(before!=null && before.m==p.m)
					active[k].remove(before);
				before=active[k].higher(p);
				
				if(after!=null && after.m==p.m){
					active[k].remove(p);
					continue;
				}
				if(before!=null && after!=null){
					if(!checkValid(before, p, after)){
						active[k].remove(p);
						continue;
					}
				}
				
				while(true){
					pair p1=p,p2=p,p3=p;
					if(p.equals(active[k].last()))
						break;
					p2=active[k].higher(p);
					if(p2.equals(active[k].last()))
						break;
					p1=active[k].higher(p2);
					if(!checkValid(p1, p2, p3))
						active[k].remove(p2);
					else
						break;
				}
			}
		}
//		System.out.println(Arrays.toString(mem[1]));
//		System.out.println(Arrays.toString(mem[2]));
		pw.println(mem[maxK][n-1]);
		
		pw.flush();
		pw.close();
	}
	
	static class rectangle implements Comparable<rectangle>{
		int w,l;
		
		rectangle(int a,int b){
			w=a;
			l=b;
		}
		
		public int compareTo(rectangle o) {
			if(l!=o.l)
				return o.l-l;
			return o.w-w;
		}
	}
	
	
	static boolean checkValid(pair l1,pair l2,pair l3){
		double i1=(1.0*l1.c-l3.c)/(l3.m-l1.m);
		double i2=(1.0*l2.c-l3.c)/(l3.m-l2.m);
		if(i2>i1)
			return true;
		return false;
	}
	
	static class pair implements Comparable<pair>{
		long m,c;
		int idx;
		
		pair(long a,long b,int i){
			m=a;
			c=b;
			idx=i;
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
