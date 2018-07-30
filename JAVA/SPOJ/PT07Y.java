import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class PT07Y {
	static ArrayList<Integer> [] adj;
	static boolean [] v;
	static int n;
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		String[]sa=s.split(" ");
		n=Integer.parseInt(sa[0]);
		adj=new ArrayList[n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<Integer>();
		}
		v=new boolean[n];
		int m=Integer.parseInt(sa[1]);
		while(m-->0){
			s=bf.readLine();
			sa=s.split(" ");
			int x=Integer.parseInt(sa[0])-1;
			int y=Integer.parseInt(sa[1])-1;
			adj[x].add(y);
			adj[y].add(x);
		}
		boolean f=dfs(-1,0);
		for(int i=0;i<n && f;i++){
			f=v[i];
		}
		System.out.println(f? "YES" : "NO");
	}
	
	public static boolean dfs(int p,int i){
		v[i]=true;
		boolean r=true;
		for(int j=0;j<adj[i].size();j++){
			int x=adj[i].get(j);
			if(x!=p && v[x])
				return false;
			if(x!=p)
				r= r && dfs(i,x);
		}
		return r;
	}
}