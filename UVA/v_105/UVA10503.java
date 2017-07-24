package v_105;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA10503 {
	static ArrayList<pair> pairs=new ArrayList<pair>();
	static ArrayList<Boolean> visited=new ArrayList<Boolean>();
	static boolean found=false;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			found=false;
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int m=Integer.parseInt(bf.readLine());
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int start=Integer.parseInt(sa[1]);
			s=bf.readLine();
			sa=s.split(" ");
			int end=Integer.parseInt(sa[0]);
			for(int i=0;i<m;i++){
				s=bf.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				pairs.add(new pair(x,y));
				visited.add(false);
			}
			f(start,end,n);
			System.out.println((found)? "YES" : "NO");
			pairs.clear();
			visited.clear();
		}
	}
	
	public static void f(int start,int end,int n){
		if(n==0){
			found=start==end;
			return;
		}
		for(int i=0;i<pairs.size();i++){
			if(!found && !visited.get(i) && (pairs.get(i).x==start || pairs.get(i).y==start)){
				visited.set(i, true);
				int s=((pairs.get(i).x==start)? pairs.get(i).y : pairs.get(i).x);
				f(s,end,n-1);
				visited.set(i, false);
			}
		}
	}
}

class pair{
	int x;
	int y;
	
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
