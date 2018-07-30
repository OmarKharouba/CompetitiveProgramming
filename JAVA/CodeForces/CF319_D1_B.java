package codeforces;
import java.io.*;
import java.util.*;
public class CF319_D1_B {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		Stack<Integer> stack=new Stack<Integer>();
		stack.add(a[0]);
		int [] cnt=new int [n+1];
		int max=0;
		for(int i=1;i<n;i++){
			while(!stack.isEmpty() && a[i]>stack.peek())
				stack.pop();
			if(!stack.isEmpty()){
				System.out.println(a[i]+" "+stack.peek());
				cnt[stack.peek()]++;
				max=Math.max(max, cnt[stack.peek()]);
			}
			stack.add(a[i]);
		}
		pw.println(max);
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