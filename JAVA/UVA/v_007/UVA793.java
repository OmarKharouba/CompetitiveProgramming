package v_007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVA793 {
	static int n;
	static int[] value,parent,rank;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		bf.readLine();
		while(t-->0){
			n=Integer.parseInt(bf.readLine());
			value=new int[n];
			parent=new int[n];
			rank=new int[n];
			for(int i=0;i<n;i++){
				parent[i]=i;
			}
			int cc=0,wc=0;
			if(t==0){
				while(bf.ready()){
					String s=bf.readLine();
					String[]sa=s.split(" ");
					int x=Integer.parseInt(sa[1])-1;
					int y=Integer.parseInt(sa[2])-1;
					if(sa[0].equals("c"))
						union(x,y);
					else{
						if(find(x)==find(y))
							cc++;
						else
							wc++;
					}
				}
				System.out.println(cc+","+wc);
			}else{
				while(true){
					String s=bf.readLine();
					if(s.length()<5)
						break;
					String[]sa=s.split(" ");
					int x=Integer.parseInt(sa[1])-1;
					int y=Integer.parseInt(sa[2])-1;
					if(sa[0].equals("c"))
						union(x,y);
					else{
						if(find(x)==find(y))
							cc++;
						else
							wc++;
					}
				}
				System.out.println(cc+","+wc);
				System.out.println();
			}
		}
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