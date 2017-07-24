package v_101;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10158 {
	static int[] p;
	static int[] r;
	static int n;
	static int [] e;
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		p=new int[n];
		r=new int[n];
		e=new int[n];
		for(int i=0;i<n;i++){
			p[i]=i;
			e[i]=-1;
		}
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int c=Integer.parseInt(sa[0]);
			int i=Integer.parseInt(sa[1]);
			int j=Integer.parseInt(sa[2]);
			if(c==0)
				break;
			int x=find(i);
			int y=find(j);
			if(c==1){ //setFriends
				 if(e[x]==y || e[y]==x)
					 System.out.println(-1);
				 else{
					 union(i, j);
					 if(e[x]!=-1 && e[y]!=-1){
						 union(e[x], e[y]);
						 e[find(e[x])]=x;
					 }else
						 if(e[x]!=-1){
							 e[x]=e[y]=find(e[x]);
							 e[e[x]]=find(x);
						 }else
							 if(e[y]!=-1){
							 e[x]=e[y]=find(e[y]);
							 e[e[x]]=find(x);
						 }
				 }
			}else
				if(c==2){
					if(x==y)
						System.out.println(-1);
					else{
						if(e[x]!=-1)
							union(e[x], y);
						if(e[y]!=-1)
							union(e[y], x);
						x=find(x);
						y=find(y);
						e[x]=y;
						e[y]=x;
					}
				}else
					if(c==3){
						System.out.println((x==y)? 1 : 0);
					}else{
						System.out.println((e[x]==y || e[y]==x)? 1 : 0);
					}
		}
	}
	
	public static void union(int i,int j){
		int x=find(i);
		int y=find(j);
		if(r[x]>r[y])
			p[y]=x;
		else{
			p[x]=y;
			if(r[x]==r[y])
				r[y]++;
		}
	}
	
	public static int find(int x){
		if(p[x]==x)
			return x;
		return (p[x]=find(p[x]));
	}
}