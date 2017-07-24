import java.io.*;
import java.util.*;
public class ACQUIRE {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		ArrayList<rectangle> arr=new ArrayList<rectangle>();
		rectangle [] a=new rectangle [n];
		for(int i=0;i<n;i++)
			a[i]=new rectangle(sc.nextInt(), sc.nextInt());
		Arrays.sort(a);
		for(int i=0;i<n;i++)
			if(arr.isEmpty() || arr.get(arr.size()-1).w<a[i].w)
				arr.add(a[i]);
		arr.add(new rectangle(1000001, 0));
		n=arr.size();
//		for(rectangle r : arr)
//			pw.println(r.w+" "+r.l);
		long [] mem=new long [n+1];
		TreeSet<pair> active=new TreeSet<pair>();
		
		for(int i=1;i<n;i++){
			mem[i]=1L*arr.get(0).l*arr.get(i-1).w;
			while(active.size()>1){
				pair l1=active.pollLast();
				pair l2=active.last();
				
				long v1=1L*l1.m*arr.get(i-1).w+l1.c;
				long v2=1L*l2.m*arr.get(i-1).w+l2.c;
				if(v1<=v2){
					active.add(l1);
					break;
				}
			}
			
			if(!active.isEmpty())
				mem[i]=Math.min(mem[i], 1L*active.last().m*arr.get(i-1).w+active.last().c);
			
			long C=mem[i];
			long M=arr.get(i).l;
			pair p=new pair(M, C,i);
			active.add(p);
			
			pair before=active.higher(p);
			pair after=active.lower(p);
			
			if(before!=null && before.m==p.m)
				active.remove(before);
			before=active.higher(p);
			
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
				p1=active.higher(p2);
				if(!checkValid(p1, p2, p3))
					active.remove(p2);
				else
					break;
			}
		}
//		System.out.println(Arrays.toString(mem));
		pw.println(mem[n-1]);
		
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
