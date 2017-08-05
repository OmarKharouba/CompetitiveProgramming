import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CF101047_GYM_H {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			String [] sa=br.readLine().split(" ");
			n=m=Integer.parseInt(sa[0]);
			int E=Integer.parseInt(sa[1]);
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			while(E-->0){
				sa=br.readLine().split(" ");
				int u=Integer.parseInt(sa[0])-1;
				int v=Integer.parseInt(sa[1])-1;
				adj[u].add(v);
				adj[v].add(u);
			}
			int max=maxMathing();
			pw.println(max/2+n-max);
		}
		pw.flush();
		pw.close();
	}
	static int n,m,vid;
	static int [] match,vis;
	static ArrayList<Integer> [] adj;
	static int maxMathing(){
		int ans=0;
		match=new int [m];
		vis=new int [n];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++){
			vid++;
			if(canMatch(i))
				ans++;
		}
		return ans;
	}
	
	static boolean canMatch(int u){
		vis[u]=vid;
		for(int v : adj[u])
			if(match[v]==-1 || (vis[match[v]]!=vid && canMatch(match[v]))){
				match[v]=u;
				return true;
			}
		return false;
	}
	
}