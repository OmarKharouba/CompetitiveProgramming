package v_101;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA10102 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			ArrayList<Integer> x1=new ArrayList<Integer>();
			ArrayList<Integer> y1=new ArrayList<Integer>();
			ArrayList<Integer> x3=new ArrayList<Integer>();
			ArrayList<Integer> y3=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				s=bf.readLine();
				for(int j=0;j<n;j++){
					char c=s.charAt(j);
					if(c=='1'){
						x1.add(i);
						y1.add(j);
					}else
						if(c=='3'){
							x3.add(i);
							y3.add(j);
						}
				}
			}
			int max=0;
			for(int i=0;i<x1.size();i++){
				int min=n*2;
				for(int j=0;j<x3.size();j++){
					int d=Math.abs(x1.get(i)-x3.get(j))+Math.abs(y1.get(i)-y3.get(j));
					if(d<min)
						min=d;
				}
				if(min>max)
					max=min;
			}
			System.out.println(max);
		}
	} 
}
