package v_100;
import java.io.*;
import java.util.*;
public class UVA10004 {
	static int n;
	static int [] c;
	static boolean [] v;
	static ArrayList<Integer> [] adj;
	public static void main(String[] args) throws Throwable{
		Scanner sc=new Scanner(System.in);
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			adj=new ArrayList [n];
			v=new boolean [n];
			c=new int [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			int m=sc.nextInt();
			while(m-->0){
				int u=sc.nextInt();
				int v=sc.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			Arrays.fill(c, -1);
			c[0]=0;
			System.out.println(dfs(0)? "BICOLORABLE." : "NOT BICOLORABLE.");
		}
	}
	public static boolean dfs(int u){
		v[u]=true;
		boolean ret=true;
		for(int i : adj[u]){
			if(c[i]==c[u])
				return false;
			if(!v[i]){
				c[i]=1-c[u];
				ret &=dfs(i);
			}
		}
		return ret;
	}
}
