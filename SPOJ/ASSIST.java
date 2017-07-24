import java.util.*;
import java.io.*;
public class ASSIST {
	static int N;
	static int [] st;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		ArrayList<Integer> lucky=new ArrayList<Integer>();
		
		N=1;
		while(N<33000)
			N<<=1;
		st=new int [N<<1];
		build();
		boolean [] del=new boolean [N+1];
		int j=2;
		while(true){
			int p=getKth(1, N, 1, j);
			boolean f=false;
			int deleted=0;
			for(int i=j+p;i-deleted<=N;i+=p){
				f=true;
				int x=deleteKth(1, N, 1, i-deleted);
				deleted++;
				del[x]=true;
			}
			j++;
			if(!f)
				break;
		}
		for(int i=2;i<=N;i++)
			if(!del[i])
				lucky.add(i);
		while(true){
			int n=sc.nextInt();			
			if(n==0)
				break;
			pw.println(lucky.get(n-1));
		}
		pw.flush();
		pw.close();
	}
	
	static void build(){
		build(1,N,1);
	}
	
	static int build(int s,int e,int p){
		if(s==e)
			return st[p]=1;
		else
			return st[p]=build(s, (s+e)/2, 2*p)+build((s+e)/2+1, e, 2*p+1);
	}
	
	static int deleteKth(int s,int e,int p,int k){
		st[p]--;
		if(s==e)
			return s;
		if(k<=st[2*p])
			return deleteKth(s, (s+e)/2, 2*p, k);
		return deleteKth((s+e)/2+1, e, 2*p+1, k-st[2*p]);
	}
	
	static int getKth(int s,int e,int p,int k){
		if(s==e)
			return s;
		if(k<=st[2*p])
			return getKth(s, (s+e)/2, 2*p, k);
		return getKth((s+e)/2+1, e, 2*p+1, k-st[2*p]);
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
