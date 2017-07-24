package v_109;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA10976 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			ArrayList<pair> a=new ArrayList<pair>();
			for(int x=n+1;x<=n*2;x++){
				int y=(x*n)/(x-n);
				if(n*y+n*x==x*y)
					a.add(new pair(y, x));
			}
			System.out.println(a.size());
			for(int i=0;i<a.size();i++){
				System.out.println("1/"+n+" = 1/"+a.get(i).x+" + 1/"+a.get(i).y);
			}
		}
	}
	
	static class pair{
		int x;
		int y;
		pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
}