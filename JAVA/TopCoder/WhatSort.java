import java.util.Arrays;
import java.util.Comparator;


public class WhatSort {
	
	public static void main(String[] args) {
		
	}
	
	public static String sortType(String[] name, int[] age, int[] wt){
		String ans="NOT";
		
		Comparator<pair> naw=new Comparator<WhatSort.pair>() {
			public int compare(pair a, pair b) {
				if(a.n.compareTo(b.n)!=0)
					return a.n.compareTo(b.n);
				if(a.a!=b.a)
					return a.a-b.a;
				return b.w-a.w;
			}
		};
		Comparator<pair> nwa=new Comparator<WhatSort.pair>() {
			public int compare(pair a, pair b) {
				if(a.n.compareTo(b.n)!=0)
					return a.n.compareTo(b.n);
				if(a.w!=b.w)
					return b.w-a.w;
				return a.a-b.a;
			}
		};
		Comparator<pair> anw=new Comparator<WhatSort.pair>() {
			public int compare(pair a, pair b) {
				if(a.a!=b.a)
					return a.a-b.a;
				if(a.n.compareTo(b.n)!=0)
					return a.n.compareTo(b.n);
				return b.w-a.w;
			}
		};
		Comparator<pair> awn=new Comparator<WhatSort.pair>() {
			public int compare(pair a, pair b) {
				if(a.a!=b.a)
					return a.a-b.a;
				if(a.w!=b.w)
					return b.w-a.w;
				return a.n.compareTo(b.n);
			}
		};
		Comparator<pair> wna=new Comparator<WhatSort.pair>() {
			public int compare(pair a, pair b) {
				if(a.w!=b.w)
					return b.w-a.w;
				if(a.n.compareTo(b.n)!=0)
					return a.n.compareTo(b.n);
				return a.a-b.a;
			}
		};
		a=age;
		n=name;
		w=wt;
		Comparator<pair> wan=new Comparator<WhatSort.pair>() {
			public int compare(pair a, pair b) {
				if(a.w!=b.w)
					return b.w-a.w;
				if(a.a!=b.a)
					return a.a-b.a;
				return a.n.compareTo(b.n);
			}
		};
		pair [] A=new pair[name.length];
		for(int i=0;i<name.length;i++)
			A[i]=new pair(name[i], age[i], wt[i]);
		
		Arrays.sort(A,naw);
		if(check(A)){
			if(ans.equals("NOT"))
				ans="NAW";
			else
				ans="IND";
		}
		Arrays.sort(A,nwa);
		if(check(A)){
			if(ans.equals("NOT"))
				ans="NWA";
			else
				ans="IND";
		}
		Arrays.sort(A,awn);
		if(check(A)){
			if(ans.equals("NOT"))
				ans="AWN";
			else
				ans="IND";
		}
		Arrays.sort(A,anw);
		if(check(A)){
			if(ans.equals("NOT"))
				ans="ANW";
			else
				ans="IND";
		}
		Arrays.sort(A,wna);
		if(check(A)){
			if(ans.equals("NOT"))
				ans="WNA";
			else
				ans="IND";
		}
		Arrays.sort(A,wan);
		if(check(A)){
			if(ans.equals("NOT"))
				ans="WAN";
			else
				ans="IND";
		}
		
		return ans;
	}
	static int [] a,w;
	static String [] n;
	
	static boolean check(pair [] A){
		for(int i=0;i<A.length;i++){
			pair p=A[i];
			if(p.a!=a[i])
				return false;
			if(p.w!=w[i])
				return false;
			if(!p.n.equals(n[i]))
				return false;
		}
		return true;
	}
	
	static class pair{
		String n;int a;int w;
		
		pair(String n,int a,int w){
			this.n=n;
			this.a=a;
			this.w=w;
		}
	}
}
