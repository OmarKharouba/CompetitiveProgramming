package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class WordTrain {
	
	public static void main(String[] args) {
		String [] a={"BABCD", "BZZZZZAAB"};
		System.out.println(hookUp(a));
	}
	
	public static String hookUp(String[] cars){
		n=cars.length;
		a=cars;
		for(int i=0;i<n;i++){
			String t=new StringBuilder(cars[i]).reverse().toString();
			if(t.compareTo(cars[i])<0)
				cars[i]=t;
		}
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				String s=cars[i],t=cars[j];
				if(s.charAt(s.length()-1)==t.charAt(0) && s.charAt(0)==t.charAt(t.length()-1)){
					String st=s+"-"+t,ts=t+"-"+s;
					if(st.compareTo(ts)<=0)
						adj[i].add(j);
					else
						adj[j].add(i);
				}else
					if(s.charAt(s.length()-1)==t.charAt(0))
						adj[i].add(j);
					else
						if(t.charAt(t.length()-1)==s.charAt(0))
							adj[j].add(i);
			}
		}
		int max=0;
		mem=new int [n];
		Arrays.fill(mem, -1);
		int idx=-1;
		String word="";
		for(int i=0;i<n;i++){
			if(max<1+dp(i)){
				max=1+dp(i);
				word=cars[i]+"-";
				idx=i;
			}else
				if(max==1+dp(i)){
					String t=cars[i]+"-";
					if(t.compareTo(word)<0){
						idx=i;
						word=t;
					}
				}
		}
		ret=word;
		print(idx);
		return ret.substring(0, ret.length()-1);
	}
	static String ret;
	static int n;
	static ArrayList<Integer> [] adj;
	static int [] mem;
	static String [] a;
	
	static int dp(int u){
		if(mem[u]!=-1)
			return mem[u];
		int ans=0;
		for(int v : adj[u]){
			ans=Math.max(ans, 1+dp(v));
		}
		return mem[u]=ans;
	}
	
	static void print(int u){
		int idx=-1;
		int max=0;
		String word="";
		for(int v : adj[u]){
			if(max<1+dp(v)){
				max=1+dp(v);
				word=a[v]+"-";
				idx=v;
			}else
				if(max==1+dp(v)){
					String t=a[v]+"-";
					if(t.compareTo(word)<0){
						idx=v;
						word=t;
					}
				}
		}
		ret+=word;
		if(idx!=-1)
			print(idx);
	}
	
}