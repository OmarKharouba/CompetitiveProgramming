package v_004;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class UVA429 {
	static TreeSet<String> set;
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new StringBuilder();
		int t=Integer.parseInt(bf.readLine());
		bf.readLine();
		while(t-->0){
			set=new TreeSet<String>();
			while(true){
				String s=bf.readLine();
				if(s.equals("*"))
					break;
				set.add(s);
			}
			String s="";
			while((s=bf.readLine())!=null && s.length()>2){
				String[]sa=s.split(" ");
				System.out.println(sa[0]+" "+sa[1]+" "+bfs(sa[0],sa[1]));
			}
			if(t>0)
				System.out.println();
		}
		pw.flush();
		pw.close();
	}
	
	public static int bfs(String x,String y){
		TreeSet<String> nSet=new TreeSet<String>();
		nSet.addAll(set);
		Queue<pair> q=new LinkedList<pair>();
		q.add(new pair(x, 0));
		while(!q.isEmpty()){
			pair p=q.poll();
			String s=p.s;
			int c=p.cnt;
			nSet.remove(s);
			if(s.equals(y))
				return c;
			for(char i='a' ;i<='z' ;i++){
				for(int j=0;j<s.length();j++){
					String n=s.substring(0, j)+i+s.substring(j+1);
					if(nSet.contains(n))
						q.add(new pair(n, c+1));
				}
			}
			
		}
		return 0;
	}
	
	static class pair{
		String s;
		int cnt;
		
		pair(String s,int cnt){
			this.s=s;
			this.cnt=cnt;
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
