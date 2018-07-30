package atcoder;
import java.io.*;
import java.util.*;
public class practice_2 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();sc.next();
		ArrayList<Character> ans=new ArrayList<Character>();
		if(n==5){
			String s1="AB";
			pw.println("? A B");
			pw.flush();
			if(sc.next().charAt(0)=='>')
				s1="BA";
			String s2="CD";
			pw.println("? C D");
			pw.flush();
			if(sc.next().charAt(0)=='>')
				s2="DC";
			pw.println("? "+s1.charAt(0)+" "+s2.charAt(0));
			pw.flush();
			char c=s1.charAt(1);
			ans.add(s1.charAt(0));
			ans.add(s2.charAt(0));
			ans.add(s2.charAt(1));
			if(sc.next().charAt(0)=='>'){
				ans.clear();
				c=s2.charAt(1);
				ans.add(s2.charAt(0));
				ans.add(s1.charAt(0));
				ans.add(s1.charAt(1));
			}
			int start=0,end=ans.size()-1,pos=-1;
			while(start<=end){
				int mid=((start+end)>>1);
				pw.println("? "+ans.get(mid)+" E");
				pw.flush();
				char res=sc.next().charAt(0);
				if(res=='>'){
					pos=mid;
					end=mid-1;
				}else{
					pos=mid+1;
					start=mid+1;
				}
			}
			ans.add(pos,'E');
			start=1;end=ans.size()-1;pos=-1;
			while(start<=end){
				int mid=((start+end)>>1);
				pw.println("? "+ans.get(mid)+" "+c);
				pw.flush();
				char res=sc.next().charAt(0);
				if(res=='>'){
					pos=mid;
					end=mid-1;
				}else{
					pos=mid+1;
					start=mid+1;
				}
			}
			ans.add(pos,c);
		}else{			
			ans.add('A');
			for(int i=1;i<n;i++){
				char c=(char)('A'+i);
				int start=0,end=ans.size()-1,pos=-1;
				while(start<=end){
					int mid=((start+end)>>1);
					pw.println("? "+ans.get(mid)+" "+c);
					pw.flush();
					char res=sc.next().charAt(0);
					if(res=='>'){
						pos=mid;
						end=mid-1;
					}else{
						pos=mid+1;
						start=mid+1;
					}
				}
				ans.add(pos,c);
			}
		}
		String ret="! ";
		for(char c : ans)
			ret+=c;
		pw.println(ret);
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
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