import java.util.*;
import java.io.*;
public class PRHYME {
	public static void main(String[] args) throws IOException {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		Trie trie=new Trie();
		while(true){
			String s=sc.nextLine();
			if(s.equals(""))
				break;
			trie.insert(s.toCharArray(), s.length()-1);
		}
		int d=5;
		while(d-->0){
			String t=new StringBuilder(sc.next()).reverse().toString();
			System.out.println(trie.searchPrefix(t.toCharArray(), 0));
//			char [] ans=null;
//			for(int i=0;i<ans.length;i++)
//				pw.print(ans[i]);
			pw.println();
			pw.flush();
		}
		
		pw.flush();
		pw.close();
	}
	static class Trie {
		Trie [] child;
		char [] word;
		
		Trie(){
			child=new Trie[26];
		}
		
		void insert(char [] s , int idx){
			if(idx==-1)
				word=s;
			else{
				int c=s[idx]-'a';
				if(child[c]==null)
					child[c]=new Trie();
				child[c].insert(s, idx-1);
			}
		}
		
		boolean searchPrefix(char [] s,int idx){
			if(idx==s.length)
				return true;
			int c=s[idx]-'a';
			if(child[c]==null)
				return false;
			return child[c].searchPrefix(s, idx+1);
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}
