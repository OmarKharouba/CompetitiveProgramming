import java.util.ArrayList;
import java.util.TreeSet;


public class MNS {
	
	public static void main(String[] args) {
		int [] a={1,2,3,3,2,1,2,2,2};
		System.out.println(combos(a));
	}
	
	public static int combos(int[] numbers){
		a=numbers;
		set=new TreeSet<String>();
		vis=new boolean [9];
		arr=new ArrayList<Integer>();
		solve(0);
		return set.size();
	}
	static int [] a;
	static TreeSet<String> set;
	static boolean [] vis;
	static ArrayList<Integer> arr;
	
	static void solve(int i){
		if(i==9){
			int sum=arr.get(0)+arr.get(1)+arr.get(2);
			boolean ok=true;
			if(arr.get(3)+arr.get(4)+arr.get(5)!=sum)
				ok=false;
			if(arr.get(6)+arr.get(7)+arr.get(8)!=sum)
				ok=false;
			if(arr.get(0)+arr.get(3)+arr.get(6)!=sum)
				ok=false;
			if(arr.get(1)+arr.get(4)+arr.get(7)!=sum)
				ok=false;
			if(arr.get(2)+arr.get(5)+arr.get(8)!=sum)
				ok=false;
			if(ok)
				set.add(arr.toString());
			return;
		}
		for(int j=0;j<9;j++)
			if(!vis[j]){
				vis[j]=true;
				arr.add(a[j]);
				solve(i+1);
				arr.remove(arr.size()-1);
				vis[j]=false;
			}
	}
	
}
