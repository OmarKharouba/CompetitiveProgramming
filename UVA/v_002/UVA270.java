package v_002;
import java.io.*;
import java.util.*;
public class UVA270 {
	public static void main(String[] args) throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(sc.nextLine());
		sc.nextLine();
		while(t-->0){
			ArrayList<Integer> a=new ArrayList<Integer>();
			ArrayList<Integer> b=new ArrayList<Integer>();
			while(sc.br.ready()){
				String s=sc.nextLine();
				if(s.length()==0)
					break;
				String [] sa=s.split(" ");
				a.add(Integer.parseInt(sa[0]));
				b.add(Integer.parseInt(sa[1]));
			}
			int max=1;
			int n=a.size();
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++){
					int cnt=2;
					long dx1=a.get(j)-a.get(i);
					long dy1=b.get(j)-b.get(i);
					for(int k=j+1;k<n;k++){
						long dx2=a.get(k)-a.get(i);
						long dy2=b.get(k)-b.get(i);
						if(dx1*dy2==dx2*dy1)
							cnt++;
					}
					max=Math.max(max, cnt);
				}
			
			pw.println(max);
			if(t>0)
				pw.println();
		}
		
		pw.flush();
		pw.close();
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
		
		String nextLine(){
			String ans="";
			try {
				ans=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ans;
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
