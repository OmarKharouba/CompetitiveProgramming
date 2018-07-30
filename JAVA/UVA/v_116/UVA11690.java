package v_116;

import java.io.IOException;
import java.util.Scanner;
public class UVA11690 {
	static int n;
	static int []parent,rank,value,sum;
	public static void main(String[]args)throws NumberFormatException,IOException{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		if(t>0)
		while(t-->0){
			n=sc.nextInt();
			value=new int[n];
			rank=new int[n];
			parent=new int[n];
			sum=new int[n];
			int m=sc.nextInt();
			for(int i=0;i<n;i++){
				parent[i]=i;
				value[i]=sc.nextInt();
			}
			while(m-->0){
				int x=sc.nextInt();
				int y=sc.nextInt();
				union(x,y);
			}
			boolean f=true;
			for(int i=0;i<n;i++){
				int x=find(i);
				sum[x]+=value[i];
			}
			for(int i=0;i<n && f;i++){
				if(sum[i]!=0)
					f=false;
			}
			System.out.println(f? "POSSIBLE" : "IMPOSSIBLE");
		}
		sc.close();
	}
	
	public static void union(int i,int j){
		int x=find(i);
		int y=find(j);
		if(x!=y){
			if(rank[x]>rank[y])
				parent[y]=x;
			else{
				parent[x]=y;
				if(rank[x]==rank[y])
					rank[y]++;
			}
		}
		}
	
	public static int find(int x){
		if(parent[x]==x)
			return x;
		return parent[x]=find(parent[x]);
	}
}