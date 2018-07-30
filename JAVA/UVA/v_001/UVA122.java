package v_001;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
public class UVA122 {
	public static void main(String[]args)throws IOException{
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			PriorityQueue<pair> q=new PriorityQueue<pair>();
			String s="";
			while(sc.hasNext() && !(s= sc.next()).equals("()")){
				String[]sa=s.split(",");
				int n=Integer.parseInt(sa[0].substring(1));
				String x=sa[1].substring(0,sa[1].length()-1);
				q.add(new pair(n, x));
			}
			pair[] r=new pair[q.size()];
			boolean f=false;
			for(int i=0;i<r.length;i++){
				r[i]=q.remove();
				if(r[i].s.length()==0)
					f=true;
			}
			if(f){
				for(int i=1;i<r.length && f;i++){
					boolean c=false;
					for(int j=0;j<r.length;j++){
						if(i!=j && r[i].s.equals(r[j].s)){
							c=false;
							f=false;
							break;
						}
						if(r[j].s.equals(r[i].s.substring(0, r[i].s.length()-1))){
							c=true;
						}
					}
					f=c;
				}
			}
			if(f){
				for(int i=0;i<r.length;i++){
					if(i<r.length-1)
						System.out.print(r[i].n+" ");
					else
						System.out.println(r[i].n);
				}
			}
			else
				System.out.println("not complete");
		}
		sc.close();
	}
}

class pair implements Comparable{
	
	int n;
	String s;
	
	pair(int n,String s){
		this.n=n;
		this.s=s;
	}

	public int compareTo(Object o) {
		pair p=(pair) o;
		int l1=this.s.length();
		int l2=p.s.length();
		if(l1<l2)
			return -1;
		if(l2<l1)
			return 1;
		for(int i=0;i<l1;i++){
			if(this.s.charAt(i)<p.s.charAt(i))
				return -1;
			if(this.s.charAt(i)>p.s.charAt(i))
				return 1;
		}
		return 0;
	}
	
}
