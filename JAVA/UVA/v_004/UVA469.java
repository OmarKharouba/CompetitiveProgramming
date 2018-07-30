package v_004;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA469 {
	static int n;
	static int m;
	static ArrayList<String>a;
	static boolean[][]v;
	static int cnt;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		bf.readLine();
		while(t-->0) {
			a=new ArrayList<String>();
			String s="";
			n=0;
			while(true){
				if((s=bf.readLine())==null || (s.charAt(0)!='L' && s.charAt(0)!='W'))
					break;
				a.add(s);
				n++;
				m=s.length();
			}
			v=new boolean[n][m];
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[0])-1;
			int y=Integer.parseInt(sa[1])-1;
			cnt=0;
			floodFill(x, y);
			System.out.println(cnt);
			while((s=bf.readLine())!=null && s.length()>=3){
				cnt=0;
				v=new boolean[n][m];
				sa=s.split(" ");
				x=Integer.parseInt(sa[0])-1;
				y=Integer.parseInt(sa[1])-1;
				floodFill(x, y);
				System.out.println(cnt);
			}
			if(t>0)
				System.out.println();
		}
	}
	
	public static void floodFill(int r,int c){
		if(valid(r,c)){
			cnt++;
			v[r][c]=true;
			floodFill(r, c+1);
			floodFill(r, c-1);
			floodFill(r+1, c);
			floodFill(r-1, c);
			floodFill(r+1, c+1);
			floodFill(r+1, c-1);
			floodFill(r-1, c+1);
			floodFill(r-1, c-1);
		}
	}
	
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<m && !v[r][c] && a.get(r).charAt(c)=='W');
	}
}
