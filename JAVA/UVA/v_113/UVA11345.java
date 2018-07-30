package v_113;
import java.io.*;
import java.util.*;
public class UVA11345 {
	public static void main(String[] args) throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt()-1;
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			long ans=1L*(x2-x1)*(y2-y1);
			boolean ok=true;
			while(n-->0){
				int tx1=sc.nextInt();
				int ty1=sc.nextInt();
				int tx2=sc.nextInt();
				int ty2=sc.nextInt();
				int [] a=intersect(x1, y1, x2, y2, tx1, ty1, tx2, ty2);
				if(a[2]<a[0] || a[3]<a[1]){
					ok=false;
				}
				x1=a[0];
				y1=a[1];
				x2=a[2];
				y2=a[3];
				ans=1L*(x2-x1)*(y2-y1);
			}
			if(!ok)
				ans=0;
			pw.println("Case "+(id++)+": "+ans);
		}
		
		pw.flush();
		pw.close();
	}
	
	static int [] intersect(int x1,int y1,int x2,int y2,int tx1,int ty1,int tx2,int ty2){
		int [] ans=new int [4];
		ans[0]=Math.max(x1, tx1);
		ans[1]=Math.max(y1, ty1);
		ans[2]=Math.min(x2, tx2);
		ans[3]=Math.min(y2, ty2);
		return ans;
	}
	
	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		MyScanner(){
			try {
				br=new BufferedReader(new FileReader(new File("test.in")));
			} catch (FileNotFoundException e) {
				br=new BufferedReader(new InputStreamReader(System.in));
			}
		}
		
		String next(){
			while(st==null || !st.hasMoreTokens()){
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt(){
			return Integer.parseInt(next());
		}
		
		long nextLong(){
			return Long.parseLong(next());
		}
		
		double nextDouble(){
			return Double.parseDouble(next());
		}
	}
	
}
