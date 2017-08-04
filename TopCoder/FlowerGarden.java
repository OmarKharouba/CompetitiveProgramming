import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class FlowerGarden {
	
	
	public static void main(String[] args) {
		int [] a={1,2,3};
		int [] b={1,9,1};
		int [] c={2,10,10};
		System.out.println(Arrays.toString(getOrdering(a, b, c)));
	}
	static int [] deg;
	static int n=1000;
	static ArrayList<Integer> [] adj;
	public static int[] getOrdering(int[] height, int[] bloom, int[] wilt){
		int m=height.length;
		boolean [] exist=new boolean [n];
		for(int i=0;i<m;i++)
			exist[height[i]-1]=true;
		adj=new ArrayList [n];
		deg=new int [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<m;i++)
			for(int j=i+1;j<m;j++)
				if(bloom[i]<=wilt[j] && bloom[j]<=wilt[i]){
					if(height[i]<height[j]){
						deg[height[j]-1]++;
						adj[height[i]-1].add(height[j]-1);
					}
					else{
						deg[height[i]-1]++;
						adj[height[j]-1].add(height[i]-1);
					}
				}
		int p=0;
		int [] ret=new int [m];
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<n;i++)
			if(exist[i] && deg[i]==0)
				q.add(i);
		while(!q.isEmpty()){
			int x=q.poll();
			ret[p++]=x+1;
			for(int y : adj[x]){
				deg[y]--;
				if(deg[y]==0)
					q.add(y);
			}
		}
		return ret;
	}
}
