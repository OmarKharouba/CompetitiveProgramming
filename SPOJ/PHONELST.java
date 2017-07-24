import java.util.*;
import java.io.*;
public class PHONELST {
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Trie trie=new Trie();
			String [] a=new String [n];
			for(int i=0;i<n;i++){
				a[i]=sc.next();
				trie.insert(a[i].toCharArray(), 0);
			}
			boolean ok=true;
			for(int i=0;i<n;i++)
				ok &=!trie.searchPrefix(a[i].toCharArray(), 0);
			pw.println(ok? "YES" : "NO");
		}
		pw.flush();
		pw.close();
	}
	
	static class Trie {
		Trie [] child;
		boolean isLeaf;
		
		Trie(){
			child=new Trie[10];
		}
		
		void insert(char [] s , int idx){
			if(idx==s.length)
				isLeaf=true;
			else{
				int c=s[idx]-'0';
				if(child[c]==null)
					child[c]=new Trie();
				child[c].insert(s, idx+1);
			}
		}
		
		boolean searchPrefix(char [] s,int idx){
			if(idx==s.length){
				for(int i=0;i<10;i++)
					if(child[i]!=null)
						return true;
				return false;
			}
			int c=s[idx]-'0';
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
