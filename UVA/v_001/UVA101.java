package v_001;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class UVA101 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		Stack<Integer> [] a=new Stack[n];
		for(int i=0;i<n;i++){
			a[i]=new Stack<Integer>();
			a[i].push(i);
		}
		while(true){
			String s=bf.readLine();
			if(s.equals("quit"))
				break;
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[1]);
			int y=Integer.parseInt(sa[3]);
			int yp=0,xp=0;
			for(int i=0;i<n;i++){
				if(a[i].contains(x))
					xp=i;
				if(a[i].contains(y))
					yp=i;
			}
			if(x!=y && xp!=yp){
				if(sa[2].equals("onto"))
					while((int)a[yp].peek()!=y){
						int r=(int)a[yp].pop();
						a[r].push(r);
					}
				if(sa[0].equals("move"))
					while((int)a[xp].peek()!=x){
						int r=(int)a[xp].pop();
						a[r].push(r);
					}
				Stack<Integer> tmp=new Stack<Integer>();
				while((int)a[xp].peek()!=x){
					tmp.push((Integer) a[xp].pop());
				}
				tmp.push((Integer) a[xp].pop());
				while(!tmp.isEmpty()){
					a[yp].push(tmp.pop());
				}
			}
		}
		for(int i=0;i<n;i++){
			String r="";
			while(!a[i].isEmpty()){
				r=" "+a[i].pop()+r;
			}
			System.out.println(i+":"+r);
		}
	}
}