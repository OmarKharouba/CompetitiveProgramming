package v_109;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA10901 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(bf.readLine());
		for(int i=1;i<=k;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int t=Integer.parseInt(sa[1]);
			int m=Integer.parseInt(sa[2]);
			car[]right=new car[m];
			car[]left=new car[m];
			int startR=0,endR=0,startL=0,endL=0;
			for(int j=0;j<m;j++){
				s=bf.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				if(sa[1].equals("left")){
					left[endL]=new car(j,x);
					endL++;
				}else{
					right[endR]=new car(j,x);
					endR++;
				}
			}
			int time=10000;
			if(startL<endL && left[startL].t<time)
				time=left[startL].t;
			boolean l=true;
			if(startR<endR && right[startR].t<time){
				time=right[startR].t+t;
				l=false;
			}
			ArrayList<car> r=new ArrayList<car>();
			while (startL<endL || startR<endR){
				if((startL<endL && left[startL].t<=time) || (startR<endR && right[startR].t<=time)){
					if((l && startL<endL && left[startL].t>time) || (!l && startR<endR && right[startR].t>time)){
						time+=t;
						l=!l;
					}
				}else{
					boolean f=true;
					time=10000000;
					if(startL<endL && left[startL].t<=time)
						time=left[startL].t;
					if(startR<endR && right[startR].t<=time){
						time=right[startR].t;
						f=false;
					}
					if(f!=l){
						l=f;
						time+=t;
					}
				}
				if(l){
					for(int j=0;startL<endL && j<n && left[startL].t<=time;j++){
						car c=left[startL];
						c.t=time+t;
						startL++;
						int p=0;
						for(int h=0;h<r.size() && r.get(h).x<c.x;h++){
							p++;
						}
						r.add(p,c);
					}
				}else{
					for(int j=0;startR<endR && j<n && right[startR].t<=time;j++){
						car c=right[startR];
						c.t=time+t;
						startR++;
						int p=0;
						for(int h=0;h<r.size() && r.get(h).x<c.x;h++){
							p++;
						}
						r.add(p,c);
					}
				}
				time+=t;
				l=!l;
			}
			for(int j=0;j<r.size();j++){
				System.out.println(r.get(j).t);
			}
			if(i<k)
				System.out.println();
		}
	}
}

class car{
	int x;
	int t;
	car(int x,int t){
		this.x=x;
		this.t=t;
	}
}