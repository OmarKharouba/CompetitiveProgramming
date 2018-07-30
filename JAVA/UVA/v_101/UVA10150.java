package v_101;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVA10150 {
	static TreeSet<String> set;
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		set=new TreeSet<String>();
		String s="";
		while((s=bf.readLine()).length()>0){
			set.add(s);
		}
		int cnt=0;
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			if(cnt>0)
				pw.println();
			pw.println(bfs(sa[0],sa[1]));
			cnt=1;
		}
		pw.flush();
		pw.close();
	}
	
	public static String bfs(String x,String y){
		TreeSet<String> nSet=new TreeSet<String>();
		nSet.addAll(set);
		Queue<pair> q=new LinkedList<pair>();
		q.add(new pair(x,""));
		nSet.remove(x);
		while(!q.isEmpty()){
			pair cur=q.poll();
			String s=cur.value;
			String p=cur.pre;
			
			if(s.equals(y))
				return (p+y);
			for(int i=0;i<s.length();i++){
				for(char j=97;j<=122;j++){
					if(s.charAt(i)!=j){
						String n=s.substring(0, i)+j+s.substring(i+1);
						if(nSet.remove(n))
							q.add(new pair(n,p+(s+"\n")));
					}
				}
			}
		}
		return "No solution.";
	}
	
	static class pair{
		String value;
		String pre;
		pair(String value,String pre){
			this.value=value;
			this.pre=pre;
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