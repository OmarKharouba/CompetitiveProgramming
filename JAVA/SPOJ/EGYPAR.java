import java.io.*;
import java.util.*;
public class EGYPAR {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		for(int id=1;id<=t;id++){
			int n=sc.nextInt();
			int s=sc.nextInt();
			int [] a=new int [n];
			int idx=0;
			for(int i=0;i<n;i++){
				String name=sc.next();
				if(name.equals("ACM"))
					idx=i;
				a[i]=Integer.parseInt(sc.next().replace(",",""));
			}
			PriorityQueue<pair> q=new PriorityQueue<pair>();
			for(int i=0;i<n;i++)
				q.add(new pair(a[i], i));
			int [] cnt=new int [n];
			for(int j=1;j<=s;j++){
				pair cur=q.poll();
				cnt[cur.idx]++;
				q.add(new pair(1.0*a[cur.idx]/(cnt[cur.idx]+1), cur.idx));
			}
			int cnt1=cnt[idx];
			Arrays.fill(cnt, 0);
			q=new PriorityQueue<pair>();
			for(int i=0;i<n;i++)
				q.add(new pair(a[i], i));
			for(int j=0;j<s;j++){
				pair cur=q.poll();
				cnt[cur.idx]++;
				q.add(new pair(1.0*a[cur.idx]/(2*cnt[cur.idx]+1), cur.idx));
			}
			int cnt2=cnt[idx];
			String ans="No difference";
			if(cnt1>cnt2)
				ans="D";
			else
				if(cnt2>cnt1)
					ans="S";
			pw.printf("Case %d: %s\n", id, ans);
		}
		
		pw.flush();
		pw.close();
	}
	static double eps=1e-9;
	static class pair implements Comparable<pair>{
		double per;
		int idx;
		pair(double p,int i){
			per=p;
			idx=i;
		}
		public int compareTo(pair o) {
			if(Math.abs(per-o.per)<eps)
				return idx-o.idx;
			return Double.compare(o.per, per);
		}
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