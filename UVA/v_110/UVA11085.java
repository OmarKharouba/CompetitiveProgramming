package v_110;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
public class UVA11085 {
	static ArrayList<String> arr=new ArrayList<String>();
	static boolean[] v=new boolean[9];
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		String s="";
		permute("", 0);
		int cnt=1;
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");	
			int[]b=new int[8];
			for(int i=0;i<8;i++){
				b[i]=Integer.parseInt(sa[i]);
			}
			int max=0;
			for(String st:arr){
				st=st.substring(1);
				String[] sta=st.split(" ");
				int[]a=new int[8];
				for(int i=0;i<8;i++){
					a[i]=Integer.parseInt(sta[i]);
				}
				boolean flag=true;
				for(int j=0;j<8 && flag;j++){
					for(int k=j+1;k<8 && flag;k++){
						if(a[j]==a[k] || Math.abs(j-k)==Math.abs(a[j]-a[k]))
							flag=false;
					}
				}
				if(flag){
					int c=0;
					for(int i=0;i<8;i++){
						if(b[i]==a[i])
							c++;
					}
					if(c>max)
						max=c;
				}
			}
			pw.println("Case "+cnt+": "+(8-max));
			cnt++;
		}
		pw.flush();
		pw.close();
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
