package v_101;
import java.io.*;
import java.util.*;
public class UVA10100 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int id=1;
		int t=3;
//		while(t-->0){
		while(sc.br.ready()){
			String l1=sc.nextLine();
			String l2=sc.nextLine();
			if(l1.length()==0 || l2.length()==0){
				if(id<10)
					pw.print(" ");
				pw.println((id++)+". Blank!");
			}
			else{
				a=new ArrayList<String>();
				b=new ArrayList<String>();
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<l1.length();i++){
					if(Character.isLetterOrDigit(l1.charAt(i)))
						sb.append(l1.charAt(i));
					if(i==l1.length()-1 || !Character.isLetterOrDigit(l1.charAt(i+1))){
						if(sb.length()>0)
							a.add(sb.toString());
						sb=new StringBuilder();
					}
				}
				for(int i=0;i<l2.length();i++){
					if(Character.isLetterOrDigit(l2.charAt(i)))
						sb.append(l2.charAt(i));
					if(i==l2.length()-1 || !Character.isLetterOrDigit(l2.charAt(i+1))){
						if(sb.length()>0)	
							b.add(sb.toString());
						sb=new StringBuilder();
					}
				}
				mem=new int [a.size()+1][b.size()+1];
				for(int [] x : mem)
					Arrays.fill(x, -1);
				if(id<10)
					pw.print(" ");
				pw.println((id++)+". Length of longest match: "+dp(0,0));
			}	
		}
		pw.flush();
		pw.close();
	}
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
