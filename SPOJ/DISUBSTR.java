import java.io.*;
import java.util.*;
public class DISUBSTR {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			s=sc.next().toCharArray();
			trie=new ArrayList<int[]>();
			addNode();
			for(int i=0;i<s.length;i++)			
				addWord(i);
			pw.println(trie.size()-1);
		}
		pw.flush();
		pw.close();
	}
	static char [] s;
	static ArrayList<int []> trie;
	
	static int addNode(){
		int [] a=new int [128];
		Arrays.fill(a, -1);
		trie.add(a);
		return trie.size()-1;
	}
	
	static void addWord(int idx){
		int cur=0;
		for(int i=idx;i<s.length;i++){	
			char c=s[i];
			int nxt=trie.get(cur)[c];
			if(nxt==-1)
				nxt=trie.get(cur)[c]=addNode();
			cur=nxt;
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
