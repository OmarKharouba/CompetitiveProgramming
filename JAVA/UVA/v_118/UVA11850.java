package v_118;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA11850 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			ArrayList<Integer>a=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int x=Integer.parseInt(bf.readLine());
				int p=0;
				for(int j=0;j<a.size() && a.get(j)<x;j++){
					p++;
				}
				a.add(p,x);
			}
			boolean flag=true;
			if(a.get(0)>200 || a.get(n-1)<1322)
				flag=false;
			for(int i=1;i<a.size() && flag ;i++){
				if(a.get(i)-a.get(i-1)>200)
					flag=false;
			}
			System.out.println((flag)? "POSSIBLE" : "IMPOSSIBLE");
		}
	}
}