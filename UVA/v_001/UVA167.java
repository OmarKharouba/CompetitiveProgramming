package v_001;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class UVA167 {
	static ArrayList<String> arr=new ArrayList<String>();
	static boolean[] v=new boolean[9];
	public static void main(String[]args)throws NumberFormatException,IOException{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		permute("", 0);
		while(t-->0){
			int[][]b=new int[8][8];
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					b[i][j]=sc.nextInt();
				}
			}
			int max=0;
			for(String st:arr){
				st=st.substring(1);
				String[] sta=st.split(" ");
				int[]a=new int[8];
				for(int i=0;i<8;i++){
					a[i]=Integer.parseInt(sta[i]);
				}
				int cnt=0;
				for(int i=0;i<8;i++){
					cnt+=b[i][a[i]-1];
				}
				if(cnt>max)
					max=cnt;
			}
			for(int i=0;i<(5-(max+"").length());i++){
				System.out.print(" ");
			}
			System.out.println(max);
		}
		sc.close();
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
