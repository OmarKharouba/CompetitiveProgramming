import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CF101047_GYM_H {

	/*
	It is stated in the problem statement that if we start from any node and then return back to it, the number of 
	traversed nodes is even, which means that any cycle in the graph(if any) is even, then the graph is bipartite grraph.
	what we want to do is to find the minimum number of guards to guard all the temples, meaning that need to maximize the 
	count of pairs of temples that are guarded with a single guard.
	two temples can be guard by a single guard if they have an edge between them
	so, if we managed to split the temples into pairs where each pair is guarded with a single guard, then we are done.
	but what if we managed to match some of them and couldn't some others, then every single temple that could't be matched
	needs a quard to itself
	so the final answer is (maxBipartiteMatching + number_Of_Unmatched_temples).
	*/
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			String [] sa=br.readLine().split(" ");
			n=m=Integer.parseInt(sa[0]);
			int E=Integer.parseInt(sa[1]);
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			while(E-->0){
				sa=br.readLine().split(" ");
				int u=Integer.parseInt(sa[0])-1;
				int v=Integer.parseInt(sa[1])-1;
				adj[u].add(v);
				adj[v].add(u);
			}
			// max here is the double of maxMatching because I added the edges in the two directions
			// you may split the graph first into two parts and add edges only from one to the other
			int max=maxMathing();
			pw.println(max/2+n-max);
		}
		pw.flush();
		pw.close();
	}
	static int n,m,vid;
	static int [] match,vis;
	static ArrayList<Integer> [] adj;
	static int maxMathing(){
		int ans=0;
		match=new int [m];
		vis=new int [n];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++){
			vid++;
			if(canMatch(i))
				ans++;
		}
		return ans;
	}
	
	static boolean canMatch(int u){
		vis[u]=vid;
		for(int v : adj[u])
			if(match[v]==-1 || (vis[match[v]]!=vid && canMatch(match[v]))){
				match[v]=u;
				return true;
			}
		return false;
	}
	
}