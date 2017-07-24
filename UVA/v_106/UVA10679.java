package v_106;
import java.io.*;
import java.util.*;
public class UVA10679 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			str=sc.next().toCharArray();
			n=sc.nextInt();
			max=1000*n+1;
			child=new ArrayList<int[]>();
			childChars=new ArrayList<ArrayList<Character>>();
			patIdx=new ArrayList<ArrayList<Integer>>();
			addNode();
			for(int i=0;i<n;i++){
				String p=sc.next();
				insert(p.toCharArray(), i);
			}
			F=new int [max];
			buildF();
			boolean [] ans=match();
			for(int i=0;i<n;i++)
				pw.println(ans[i]? "y" : "n");
		}
		
		pw.flush();
		pw.close();
	}
	
	static int max;
	static int n;
	static char [] str;
	static ArrayList<int []> child;
	static ArrayList< ArrayList<Character> > childChars;
	static ArrayList< ArrayList<Integer> > patIdx;
	static int [] F;
	
	static boolean [] match(){
		boolean [] ret=new boolean [n];
		int f=0;
		for(char c : str){
			while(child.get(f)[c]==-1)
				f=F[f];
			f=child.get(f)[c];
			for(int j : patIdx.get(f))
				ret[j]=true;
		}
		return ret;
	}
	
	static void buildF(){
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<123;i++){
			if(child.get(0)[i]==-1)
				child.get(0)[i]=0;
			else{
				F[child.get(0)[i]]=0;
				q.add(child.get(0)[i]);
			}
		}
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int c : childChars.get(cur)){
				int nxt=child.get(cur)[c];
				q.add(nxt);
				int f=F[cur];
				while(child.get(f)[c]==-1)
					f=F[f];
				f=child.get(f)[c];
				F[nxt]=f;
				patIdx.get(nxt).addAll(patIdx.get(f));
			}
		}
	}
	
	static int addNode(){
		int [] a=new int [123];
		Arrays.fill(a, -1);
		child.add(a);
		patIdx.add(new ArrayList<Integer>());
		childChars.add(new ArrayList<Character>());
		return child.size()-1;
	}
	
	static void insert(char [] s,int idx){
		int cur=0;
		for(char c : s){
			if(child.get(cur)[c]==-1){
				child.get(cur)[c]=addNode();
				childChars.get(cur).add(c);
			}
			cur=child.get(cur)[c];
		}
		patIdx.get(cur).add(idx);
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
