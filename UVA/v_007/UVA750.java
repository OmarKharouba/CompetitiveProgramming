package v_007;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA750 {
	static ArrayList<String> arr=new ArrayList<String>();
	static boolean[] v=new boolean[9];
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		int max=t;
		permute("", 0);
		while(t-->0){
			if(t+1<max)
				System.out.println();
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1])-1;
			System.out.println("SOLN       COLUMN\n"+" #      1 2 3 4 5 6 7 8\n");
			int cnt=1;
			for(String st:arr){
				boolean flag=Integer.parseInt(st.charAt(2*y+1)+"")==x;
				if(flag){
					System.out.println(((cnt<10)? " " : "")+cnt+"     "+st);
					cnt++;
				}
			}
		}
	}
	
	public static void permute(String s,int n){
		if(n==8){
			arr.add(s);
			return;
		}
		for(int i=1;i<=8;i++){
			if(!v[i]){
				boolean flag=true;
				for(int j=0;j*2<s.length();j++){
					int p=2*j+1;
					int x=Integer.parseInt(s.charAt(p)+"");
					if(Math.abs(x-i)==Math.abs(n-j))
						flag=false;
				}
				if(flag){
					v[i]=true;
					permute(s+" "+i, n+1);
					v[i]=false;
				}
			}
		}
	}
}
