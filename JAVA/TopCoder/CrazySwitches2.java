import java.util.LinkedList;
import java.util.Queue;


public class CrazySwitches2 {
	
	public static void main(String[] args) {
		int [] a={4, 4, 3, 0, 5, 2};
		System.out.println(minimumActions(a));
	}
	
	public static int minimumActions(int[] switches){
		a=switches;
		n=a.length;
		vis=new boolean [n][1<<n];
		dis=new int [n][1<<n];
		vis[0][1]=true;
		q=new LinkedList<node>();
		node src=new node(0, 1);
		q.add(src);
		go(src,0);
		while(!q.isEmpty()){
			node u=q.poll();
			for(int i=0;i<n;i++)
				if((u.msk & (1<<i))!=0 && !vis[i][u.msk]){
					vis[i][u.msk]=true;
					dis[i][u.msk]=dis[u.idx][u.msk]+1;
					node v=new node(i, u.msk);
					q.add(v);
					go(v,dis[i][u.msk]);
				}
		}
		int ans=vis[n-1][1<<(n-1)]? dis[n-1][1<<(n-1)] : -1;
		return ans;
	}
	static int [] a;
	static int n;
	static boolean [][] vis;
	static int [][] dis;
	static Queue<node> q;
	
	static void go(node src,int c){
		Queue<node> tmp=new LinkedList<node>();
		tmp.add(src);
		while(!tmp.isEmpty()){
			node u=tmp.poll();
			for(int i=0;i<n;i++){
				int newMsk= u.msk ^ (1<<i);
				if(i!=u.idx && u.idx==a[i] && !vis[u.idx][newMsk]){
					vis[u.idx][newMsk]=true;
					dis[u.idx][newMsk]=c;
					node v=new node(u.idx, newMsk);
					q.add(v);
					tmp.add(v);
				}
			}
		}
	}
	
	static class node{
		int idx,msk;
		node(int i,int m){
			idx=i;
			msk=m;
		}
	}
}
