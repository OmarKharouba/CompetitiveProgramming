import java.util.*;
import java.io.*;
public class MORSE {
	static int l;
	static char [] str;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=sc.nextInt();
		while(t-->0){
			str=sc.next().replace('.', '0').replace('-', '1').toCharArray();
			l=str.length;
			int n=sc.nextInt();
			trie=new Trie();
			while(n-->0)
				trie.insert(encode(sc.next()).toCharArray(), 0);
			mem=new int [l];
			Arrays.fill(mem, -1);
			pw.println(dp(0));
		}
		pw.flush();
		pw.close();
	}
	static Trie trie;
	static int []mem;
	public static int dp(int i){
		if(i==l)
			return 1;
		if(mem[i]!=-1)
			return mem[i];
		int ans=0;
		for(int j=i+1;j<=Math.min(i+100, l);j++){
			int x=trie.searchWord(str, i, j);
			if(x>0)
				ans+=x*dp(j);
		}
		return mem[i]=ans;
	}
	
	static class Trie {
		Trie [] child;
		int cntLeaf;
		Trie(){
			child=new Trie[2];
		}
		void insert(char [] s , int idx){
			if(idx==s.length)
				cntLeaf++;
			else{
				int c=s[idx]-'0';
				if(child[c]==null)
					child[c]=new Trie();
				child[c].insert(s, idx+1);
			}
		}
		int searchWord(char [] s,int idx,int last){
			if(idx==last)
				return cntLeaf;
			int c=s[idx]-'0';
			if(child[c]==null)
				return 0;
			return child[c].searchWord(s, idx+1,last);
		}
	}
	
	static String [] morse={"01","1000","1010","100","0","0010","110","0000","00","0111","101","0100","11","10","111","0110",
		"1101","010","000","1","001","0001","011","1001","1011","1100"};
	public static String encode(String s){
		String t="";
		for(char c : s.toCharArray()){
			t+=morse[c-'A'];
		}
		return t;
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
