package v_004;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA459 {
	static ArrayList<Integer> [] adj;
	static boolean [] v;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		bf.readLine();
		while(t-->0){
			int n=bf.readLine().charAt(0)-64;
			adj=new ArrayList [n];
			v=new boolean[n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<Integer>();
			}
			while(true){
				String s="";
				if((s=bf.readLine())==null ||s.length()<2)
					break;
				int x=s.charAt(0)-65;
				int y=s.charAt(1)-65;
				adj[x].add(y);
				adj[y].add(x);
			}
			int cnt=0;
			for(int i=0;i<n;i++){
				if(!v[i]){
					dfs(i);
					cnt++;
				}
			}
			System.out.println(cnt);
			if(t>0)
				System.out.println();
		}
	}
	
	public static void dfs(int i){
		v[i]=true;
		for(int j=0;j<adj[i].size();j++){
			int x=adj[i].get(j);
			if(!v[x])
				dfs(x);
		}
	}
}
