package v_008;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA872 {
	static ArrayList<Integer> [] adj;
	static boolean [] v;
	static boolean [] node;
	static int [] in;
	static int n;
	static int size;
	static int far;
	static int max;
	static boolean any;
	static ArrayList<Integer> list;
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		n=26;
		list=new ArrayList<Integer>();
		while(t-->0){
			adj=new ArrayList[n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<Integer>();
			}
			node=new boolean[n];
			v=new boolean[n];
			in=new int[n];
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			size=sa.length;
			for(int i=0;i<sa.length;i++){
				int x=sa[i].charAt(0)-65;
				node[x]=true;
			}
			s=bf.readLine();
			sa=s.split(" ");
			for(int i=0;i<sa.length;i++){
				int x=sa[i].charAt(0)-65;
				int y=sa[i].charAt(2)-65;
				adj[x].add(y);
				in[y]++;
			}
			any=false;
			allTopoSort();
			if(!any)
				System.out.println("NO");
			if(t>0)
				System.out.println();
		}
	}
	
	public static void allTopoSort(){
		boolean flag=false;
		for(int i=0;i<n;i++){
			if(node[i] && !v[i] && in[i]==0){
				v[i]=true;
				for(int j=0;j<adj[i].size();j++){
					in[adj[i].get(j)]--;
				}
				list.add(i);
				allTopoSort();
				v[i]=false;
				for(int j=0;j<adj[i].size();j++){
					in[adj[i].get(j)]++;
				}
				list.remove(list.indexOf(i));
				flag=true;
			}
		}
		if(!flag && list.size()==size){
			any=true;
			for(int i=0;i<list.size();i++){
				if(i<list.size()-1)
					System.out.print((char)(list.get(i)+65)+" ");
				else
					System.out.println((char)(list.get(i)+65));
			}
		}
	}
}