package v_107;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10703 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			if(s.length()==0)
				s=bf.readLine();
			String[]sa=s.split(" ");
			int w=Integer.parseInt(sa[0]);
			int h=Integer.parseInt(sa[1]);
			int n=Integer.parseInt(sa[2]);
			if(w==0 && h==0 && n==0)
				break;
			long r=w*h;
			boolean[][]a=new boolean[w][h];
			for(int i=0;i<n;i++){
				s=bf.readLine();
				sa=s.split(" ");
				int x1=Integer.parseInt(sa[0]);
				int y1=Integer.parseInt(sa[1]);
				int x2=Integer.parseInt(sa[2]);
				int y2=Integer.parseInt(sa[3]);
				for(int j=Math.min(x1, x2);j<=Math.max(x1, x2);j++){
					for(int k=Math.min(y1, y2);k<=Math.max(y1, y2);k++){
						if(!a[j-1][k-1]){
							a[j-1][k-1]=true;
							r--;
						}
					}
				}
			}
			System.out.println((r==0)? "There is no empty spots." : (r==1)? "There is one empty spot." : "There are "+r+" empty spots.");
		}
	}
}