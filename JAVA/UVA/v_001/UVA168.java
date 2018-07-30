package v_001;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVA168 {
	static PrintWriter pw;
	static ArrayList<Integer> [] adj;
	static int n,k;
	static int [] p;
	static boolean v [] ;
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		pw=new PrintWriter(System.out,true);
		
		while(true){
			String s=sc.next();
			if(s.contains("#"))
				break;
			String [] sa=s.substring(0, s.length()-1).split(";");
			int you=sc.next().charAt(0)-'A';
			int me=sc.next().charAt(0)-'A';
			k=sc.nextInt();
			
			n=26;
			adj=new ArrayList[n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			v=new boolean [n];
			p=new int [n];
			Arrays.fill(p, -1);
			p[you]=me;
			
			for(String tmp : sa){
				int from=tmp.charAt(0)-'A';
				for(int i=2;i<tmp.length();i++){
					int to=tmp.charAt(i)-'A';
					adj[from].add(to);
				}
			}
			
			
			dfs(you, 1,new StringBuilder());
			
		}
		
		pw.flush();
		pw.close();
	}
	
	public static void dfs(int u,int c,StringBuilder sb){
		boolean flag=false;
		for(Integer ch : adj[u]){
			if(ch!=p[u] && !v[ch]){
				flag=true;
				break;
			}
		}
		if(flag && c%k==0){
			v[u]=true;
			sb.append((char)('A'+u)+" ");
		}
		for(Integer ch : adj[u]){
			if(ch!=p[u] && !v[ch]){
				p[ch]=u;
				dfs(ch, c+1, sb);
				flag=true;
				break;
			}
		}
		
		if(!flag){
			sb.append("/"+(char)('A'+u));
			pw.println(sb.toString());
		}
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
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
