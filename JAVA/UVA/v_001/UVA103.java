package v_001;
import java.io.*;
import java.util.*;
public class UVA103 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			int n=sc.nextInt();
			int m=sc.nextInt();
			int [][] a=new int [n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++)
					a[i][j]=sc.nextInt();
				Arrays.sort(a[i]);
			}
			int [] deg=new int [n];
			ArrayList<Integer> [] adj=new ArrayList[n];
			ArrayList<Integer> [] adjRev=new ArrayList[n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<Integer>();
				adjRev[i]=new ArrayList<Integer>();				
			}
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(can(a[i], a[j])){
						adj[i].add(j);
						adjRev[j].add(i);
						deg[j]++;
					}
			int [] lis=new int [n];
			int [] p=new int [n];
			int max=0;
			int idx=0;
			Queue<Integer> q=new LinkedList<Integer>();
			for(int i=0;i<n;i++)
				if(deg[i]==0)
					q.add(i);
			while(!q.isEmpty()){
				int i=q.poll();
				p[i]=-1;
				lis[i]=1;
				for(int j : adjRev[i]){
					if(lis[j]+1>lis[i]){
						p[i]=j;
						lis[i]=lis[j]+1;
					}
				}
				if(lis[i]>=max){
					max=lis[i];
					idx=i;
				}
				for(int j : adj[i]){
					deg[j]--;
					if(deg[j]==0)
						q.add(j);
				}
			}
			
			pw.println(max);
			Stack<Integer> stack=new Stack<Integer>();
			while(idx!=-1){
				stack.push(idx+1);
				idx=p[idx];
			}
			while(!stack.isEmpty()){
				int x=stack.pop();
				if(stack.isEmpty())
					pw.println(x);
				else
					pw.print(x+" ");
			}
		}
		
		
		pw.flush();
		pw.close();
	}
	
	public static boolean can(int [] a,int [] b){
		for(int i=0;i<a.length;i++)
			if(a[i]>=b[i])
				return false;
		return true;
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
