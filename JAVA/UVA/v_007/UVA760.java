package v_007;
import java.io.*;
import java.util.*;
public class UVA760 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		boolean first=true;
		while(sc.br.ready()){
			if(!first)
				pw.println();
			first=false;
			max=0;
			char [] s1=sc.next().toCharArray();
			char [] s2=sc.next().toCharArray();
			Trie trie=new Trie();
			for(int i=0;i<s1.length;i++)
				trie.insert(s1, i);
			for(int i=0;i<s2.length;i++)
				max=Math.max(max, trie.getMax(s2,i));
			if(max==0)
				pw.println("No common sequence.");
			else{
				ans=new TreeSet<String>();
				stack=new Stack<Character>();
				for(int i=0;i+max-1<s2.length;i++)
					trie.addWords(s2,i,0);
				for(String x : ans)
					pw.println(x);
			}
		}
		
		
		pw.flush();
		pw.close();
	}
	static Stack<Character> stack;
	static TreeSet<String> ans;
	static int max;
	static class Trie{
		Trie [] child;
		boolean isLeaf;
		Trie(){
			child=new Trie[26];
		}
		
		void insert(char [] s , int idx){
			if(idx==s.length)
				isLeaf=true;
			else{
				int c=s[idx]-'a';
				if(child[c]==null)
					child[c]=new Trie();
				child[c].insert(s, idx+1);
			}
		}
		
		int getMax(char [] s,int idx){
			if(idx==s.length)
				return 0;
			int ans=0;
			int c=s[idx]-'a';
			if(child[c]!=null)
				ans=1+child[c].getMax(s, idx+1);
			return ans;
		}
		
		void addWords(char [] s,int idx,int cnt){
			if(cnt==max || idx==s.length){
				StringBuilder sb=new StringBuilder();
				Stack<Character> tmp=new Stack<Character>();
				while(!stack.isEmpty())
					tmp.push(stack.pop());
				while(!tmp.isEmpty()){
					sb.append(tmp.peek());
					stack.push(tmp.pop());
				}
				ans.add(sb.toString());
				return;
			}
			int c=s[idx]-'a';
			if(child[c]==null)
				return;
			stack.push(s[idx]);
			child[c].addWords(s, idx+1, cnt+1);
			stack.pop();
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