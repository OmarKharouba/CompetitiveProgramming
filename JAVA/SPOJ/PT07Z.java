
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class PT07Z {
	static ArrayList<Integer> [] adj;
	static boolean [] v;
	static int n;
	static int far;
	static int max;
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		adj=new ArrayList[n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<Integer>();
		}
		v=new boolean[n];
		int m=n-1;
		while(m-->0){
			String s=bf.readLine();
			String [] sa=s.split(" ");
			int x=Integer.parseInt(sa[0])-1;
			int y=Integer.parseInt(sa[1])-1;
			adj[x].add(y);
			adj[y].add(x);
		}
		dfs(-1,0,0);
		max=0;
		v=new boolean[n];
		dfs(-1,far,0);
		System.out.println(max);
	}
	
	public static void dfs(int p,int i,int c){
		if(c>max){
			max=c;
			far=i;
		}
		v[i]=true;
		for(int j=0;j<adj[i].size();j++){
			int x=adj[i].get(j);
			if(x!=p)
				dfs(i,x,c+1);
		}
	}
}