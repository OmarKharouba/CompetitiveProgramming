package v_003;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA352 {
	static int [] parent;
	static int[]rank;
	static int cnt;
	static int n;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int c=1;
		while((s=bf.readLine())!=null){
			n=Integer.parseInt(s);
			parent=new int[n*n];
			for(int i=0;i<n*n;i++){
				parent[i]=i;
			}
			rank=new int[n*n];
			cnt=0;
			char[][] arr=new char[n][n];
			for(int i=0;i<n;i++){
				s=bf.readLine();
				for(int j=0;j<n;j++){
					arr[i][j]=s.charAt(j);
					if(arr[i][j]=='1')
						cnt++;
				}
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(arr[i][j]=='1'){
						if(j<n-1 && arr[i][j+1]=='1')
							union(n*i+j, n*i+j+1);
						if(j<n-1 && i<n-1 && arr[i+1][j+1]=='1')
							union(n*i+j, n*(i+1)+j+1);
						if(i<n-1 && arr[i+1][j]=='1')
							union(n*i+j, n*(i+1)+j);
						if(i<n-1 && j>0 && arr[i+1][j-1]=='1')
							union(n*i+j, n*(i+1)+j-1);
					}
				}
			}
			System.out.println("Image number "+c+" contains "+cnt+" war eagles.");
			c++;
		}
	}
	
	public static void union(int i,int j){
		int x=find(i);
		int y=find(j);
		if(x!=y){
			cnt--;
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
		else
			return parent[x]=find(parent[x]);
	}
}
