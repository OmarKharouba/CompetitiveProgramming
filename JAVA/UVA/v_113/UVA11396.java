package v_113;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class UVA11396 {
	static int[]color;
	static ArrayList<Integer>[] a;
	static int n;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			a=new ArrayList[n];
			color=new int[n];
			for(int i=0;i<n;i++){
				a[i]=new ArrayList<Integer>();
				color[i]=-1;
			}
			while(true){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int x=Integer.parseInt(sa[0])-1;
				int y=Integer.parseInt(sa[1])-1;
				if(x==-1 && y==-1)
					break;
				a[x].add(y);
				a[y].add(x);
			}
			color[0]=0;
			System.out.println( p2(0)? "YES" : "NO");
		}
	}
	
	public static boolean p(int i){
		boolean r=true;
		for(Integer e : a[i]){
			if(color[e]==-1){
				color[e]= 1-color[i];
				r=r && p(e);
			}else
				r=r && (color[e]!=color[i]);
		}
		return r;
	}
	
	public static boolean p2(int i){
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(i);
		while(!q.isEmpty()){
			int x=q.poll();
			for(Integer e : a[x]){
				if(color[e]==-1){
					color[e]= 1-color[x];
					q.add(e);
				}else
					 if(color[e]==color[x])
						 return false;
			}
		}
		return true;
	}
}