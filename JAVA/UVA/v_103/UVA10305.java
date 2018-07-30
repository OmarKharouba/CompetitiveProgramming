package v_103;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA10305 {
	static boolean[]v;
	static ArrayList<Integer>[] a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			if(n==0 && m==0)
				break;
			a=new ArrayList[n+1];
			v=new boolean[n+1];
			for(int i=0;i<=n;i++){
				a[i]=new ArrayList<Integer>();
			}
			while(m-->0){
				s=bf.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				a[y].add(x);
			}
			for(int i=1;i<=n;i++){
				if(!v[i]){
					dfs(i);
				}
			}
		}
	}
	
	public static void dfs(int i){
		v[i]=true;
		for(int j=0;j<a[i].size();j++){
			int tmp=a[i].get(j);
			if(!v[tmp])
				dfs(tmp);
		}
		System.out.println(i);
	}
}
