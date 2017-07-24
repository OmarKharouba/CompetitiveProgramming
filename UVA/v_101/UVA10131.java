package v_101;
import java.io.*;
import java.util.*;
public class UVA10131 {
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int id=1;
		ArrayList<pair> a=new ArrayList<pair>();
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1]);
			a.add(new pair(x, y, id));
			id++;
		}
		Collections.sort(a);
		int n=a.size();
		int [] dp=new int[n];
		String[] seq=new String[n];

		for(int i=0;i<n;i++)
			seq[i]=""+a.get(i).idx;
		
		dp[n-1]=1;
		int max=1;
		String maxsSeq="";
		for(int i=n-2;i>=0;i--){
			dp[i]=1;
			for(int j=i+1;j<n;j++){
				if(a.get(j).w>a.get(i).w && a.get(j).s<a.get(i).s){
					if(1+dp[j]>dp[i]){
						dp[i]=1+dp[j];
						seq[i]=a.get(i).idx+" "+seq[j];
					}
				}
			}
			if(dp[i]>max){
				max=dp[i];
				maxsSeq=seq[i];
			}
		}
		System.out.println(max);
		String[]sa=maxsSeq.split(" ");
		for(int i=0;i<sa.length;i++)
			System.out.println(sa[i]);
	}
	
	static class pair implements Comparable<pair>{
		int w;
		int s;
		int idx;
		
		pair(int w,int s,int idx){
			this.w=w;
			this.s=s;
			this.idx=idx;
		}

		
		public int compareTo(pair o) {
			return this.w-o.w;
		}
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
}
