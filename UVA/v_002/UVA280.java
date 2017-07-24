package v_002;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA280 {
	static ArrayList<Integer> [] adj;
	static boolean [] v;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<Integer>();
			}
			while(true){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				if(sa.length==1 && sa[0].equals("0"))
					break;
				int x=Integer.parseInt(sa[0])-1;
				for(int i=1;i<sa.length-1;i++){
					int y=Integer.parseInt(sa[i])-1;
					adj[x].add(y);
				}
			}
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int c=Integer.parseInt(sa[0]);
			for(int i=0;i<c;i++){
				v=new boolean[n];
				int x=Integer.parseInt(sa[i+1])-1;
				for(int j=0;j<adj[x].size();j++){
					int y=adj[x].get(j);
					if(!v[y])
						dfs(y);
				}
				int cnt=0;
				ArrayList<Integer> a=new ArrayList<Integer>();
				for(int j=0;j<n;j++){
					if(!v[j]){
						a.add(j);
						cnt++;
					}
				}
				StringBuilder sb=new StringBuilder();
				sb.append(cnt);
				for(int j=0;j<a.size();j++){
					sb.append(" "+(a.get(j)+1));
				}
				System.out.println(sb);
			}
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
