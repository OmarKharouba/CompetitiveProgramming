package v_012;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class UVA1203 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		PrintWriter pw=new PrintWriter(System.out,true);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<p> a=new ArrayList<p>();
		while(true){
			String s=bf.readLine();
			if(s.equals("#"))
				break;
			String[]sa=s.split(" ");
			int v=Integer.parseInt(sa[1]);
			int t=Integer.parseInt(sa[2]);
			a.add(new p(v,t));
		}
		int x=Integer.parseInt(bf.readLine());
		PriorityQueue<p> q=new PriorityQueue<p>();
		for(int i=0;i<a.size();i++){
			int v=a.get(i).v;
			int t=a.get(i).t;
			int start=t;
			for(int j=0;j<x;j++){
				q.add(new p(v, start));
				start+=t;
			}
		}
		for(int i=0;i<x;i++){
			System.out.println(q.remove().v);
		}
	}
}

class p implements Comparable<p>{
	int v;
	int t;
	p(int v,int t){
		this.v=v;
		this.t=t;
	}
	
	public int compareTo(p o) {
		return((this.t<o.t || (this.t==o.t && this.v<o.v))? -1 : 1);
	}
}