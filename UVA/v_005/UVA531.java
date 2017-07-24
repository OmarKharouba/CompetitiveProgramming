package v_005;
import java.io.*;
import java.util.*;
public class UVA531 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			a=new ArrayList<String>();
			b=new ArrayList<String>();
			while(true){
				String s=sc.next();
				if(s.equals("#"))
					break;
				a.add(s);
			}
			while(true){
				String s=sc.next();
				if(s.equals("#"))
					break;
				b.add(s);
			}
			mem=new int [a.size()+1][b.size()+1];
			for(int [] x : mem)
				Arrays.fill(x, -1);
			dp(0, 0);
			ans=new ArrayList<String>();
			print(0,0);
			for(int i=0;i<ans.size();i++)
				if(i==ans.size()-1)
					pw.println(ans.get(i));
				else
					pw.print(ans.get(i)+" ");
		}
		
		pw.flush();
		pw.close();
	}
	static ArrayList<String> ans;
	static ArrayList<String> a,b;
	static int [][] mem;
	public static int dp(int i,int j){
		if(i>=a.size() || j>=b.size())
			return 0;
		if(mem[i][j]!=-1)
			return mem[i][j];
		int ans=0;
		ans=Math.max(ans, dp(i+1, j));
		ans=Math.max(ans, dp(i, j+1));
		if(a.get(i).equals(b.get(j)))
			ans=Math.max(ans, 1+dp(i+1, j+1));
		return mem[i][j]=ans;
	}
	
	public static void print(int i,int j){
		if(i>=a.size() || j>=b.size())
			return;
		int best=dp(i, j);
		if(best==dp(i+1, j))
			print(i+1, j);
		else
			if(best==dp(i, j+1))
				print(i, j+1);
			else{
				ans.add(a.get(i));
				print(i+1, j+1);
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
