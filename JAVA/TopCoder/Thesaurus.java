import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Thesaurus {
	
	public static void main(String[] args) {
		String [] a={"ape monkey wrench", "wrench twist strain", "monkey twist frugue strain"};
		System.out.println(Arrays.toString(edit(a)));
	}
	
	public static String[] edit(String[] entry) {
		int n=entry.length;
		d=new DSU(n);
		for(int i=0;i<n;i++){
			String [] sa=entry[i].split(" ");
			for(String ss : sa)
				d.str[i].add(ss);
		}
		boolean change=true;
		while(change){
			change=false;
			for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++){
					int setI=d.findSet(i);
					int setJ=d.findSet(j);
					if(setI!=setJ && countCommon(setI, setJ)>1){
						d.union(i, j);
						change=true;
					}
				}
		}
		TreeSet<Integer> set=new TreeSet<Integer>();
		ArrayList<String> res=new ArrayList<String>();
		for(int i=0;i<n;i++){
			int s=d.findSet(i);
			if(!set.contains(s)){
				set.add(s);
				String t="";
				Collections.sort(d.str[s]);
				for(int j=0;j<d.str[s].size();j++){
					if(j>0)
						t+=" ";
					t+=d.str[s].get(j);
				}
				res.add(t);
			}
		}
		String [] ans=new String [res.size()];
		for(int i=0;i<ans.length;i++)
			ans[i]=res.get(i);
		Arrays.sort(ans);
		return ans;
	}
	static DSU d;
	
	static int countCommon(int i,int j){
		TreeSet<String> set=new TreeSet<String>();
		for(String s : d.str[i])
			set.add(s);
		int cnt=0;
		for(String s : d.str[j])
			if(set.contains(s))
				cnt++;
		return cnt;
	}

	static class DSU {
		int n, cntSets;
		int[] rank, parent, setSize;
		ArrayList<String> [] str;

		public DSU(int n) {
			cntSets = n;
			this.n = n;
			rank = new int[n];
			parent = new int[n];
			setSize = new int[n];
			str=new ArrayList [n];
			for (int i = 0; i < n; i++) {
				setSize[i] = 1;
				parent[i] = i;
				str[i]=new ArrayList<String>();
			}
		}

		public int findSet(int i) {
			return parent[i] == i ? i : (parent[i] = findSet(parent[i]));
		}

		public boolean union(int u, int v) {
			int x = findSet(u);
			int y = findSet(v);
			if (x == y)
				return false;
			if (rank[x] < rank[y]) {
				setSize[y] += setSize[x];
				parent[x] = y;
				for(String s : str[x])
					if(!str[y].contains(s))
						str[y].add(s);
			} else {
				setSize[x] += setSize[y];
				if (rank[x] == rank[y])
					rank[x]++;
				parent[y] = x;
				for(String s : str[y])
					if(!str[x].contains(s))
						str[x].add(s);
			}
			cntSets--;
			return true;
		}

	}

}
