package v_009;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
public class UVA978 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int g=Integer.parseInt(sa[1]);
			int b=Integer.parseInt(sa[2]);
			PriorityQueue<myInt> gq=new PriorityQueue<myInt>();
			for(int i=0;i<g;i++){
				gq.add(new myInt(Integer.parseInt(bf.readLine())));
			}
			PriorityQueue<myInt> bq=new PriorityQueue<myInt>();
			for(int i=0;i<b;i++){
				bq.add(new myInt(Integer.parseInt(bf.readLine())));
			}
			PriorityQueue<myInt> tmpg=new PriorityQueue<myInt>();
			PriorityQueue<myInt> tmpb=new PriorityQueue<myInt>();
			while(true){
				for(int i=0;i<n && !gq.isEmpty() && !bq.isEmpty();i++){
					tmpg.add(gq.remove());
					tmpb.add(bq.remove());
				}
				while(!tmpb.isEmpty() && !tmpg.isEmpty()){
					int x=tmpg.remove().x;
					int y=tmpb.remove().x;
					if(x>y)
						gq.add(new myInt(x-y));
					else
						if(y>x)
							bq.add(new myInt(y-x));
				}
				if(gq.isEmpty() || bq.isEmpty())
					break;
			}
			if(gq.isEmpty() && bq.isEmpty())
				System.out.println("green and blue died");
			else
				if(gq.isEmpty()){
					System.out.println("blue wins");
					while(!bq.isEmpty())
						System.out.println(bq.remove().x);
				}else{
					System.out.println("green wins");
					while(!gq.isEmpty())
						System.out.println(gq.remove().x);
				}
			if(t>0)
				System.out.println();
		}
	}
}

class myInt implements Comparable<myInt>{
	int x;
	
	myInt(int x){
		this.x=x;
	}
	
	public int compareTo(myInt o) {
		return (o.x-this.x);
	}
	
}
