package v_004;
import java.io.*;
import java.util.*;
public class UVA481 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		
		int [] a=new int [100000];
		int n=0;
		while(sc.br.ready())
			a[n++]=sc.nextInt();
		
		int max=lis(a, n);
		
		pw.println(max);
		pw.println("-");
		while(!stack.isEmpty())
			pw.println(stack.pop());
		
		pw.flush();
		pw.close();
	}
	
	static Stack<Integer> stack;
	
	public static int lis(int [] a,int n){
		ArrayList<Integer> l=new ArrayList<Integer>();
		int [] p=new int [n];
		int [] idx=new int [n];
		int lis=0;
		int last=-1;
		for(int i=0;i<n;i++){
			int pos=l.size();
			int start=0,end=l.size()-1;
			while(start<=end){
				int mid=((start+end)>>1);
				if(l.get(mid)>=a[i]){
					pos=mid;
					end=mid-1;
				}else
					start=mid+1;
			}
			
			if(pos>=l.size())
				l.add(a[i]);
			else
				l.set(pos, a[i]);
			
			if(pos+1>=lis){
				lis=pos+1;
				last=i;
			}
			
			idx[pos]=i;
			p[i]=pos>0? idx[pos-1] : -1;		
		}
		
		stack = new Stack<Integer>();
		while(last!=-1){
			stack.push(a[last]);
			last=p[last];
		}
		return lis;
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	    	  try {
	    		  br = new BufferedReader(new FileReader(new File("test.in")));
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
	      
	      boolean ready()throws Exception{
	    	  return br.ready();
	      }

	   }
}
