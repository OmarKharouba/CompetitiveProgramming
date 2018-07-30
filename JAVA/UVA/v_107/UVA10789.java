package v_107;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10789 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		boolean[] p=new boolean[2001];
		p[0]=true;
		p[1]=true;
		for(int i=2;i*i<p.length;i++){
			if(!p[i]){
				for(int j=i*2;j<p.length;j+=i){
					p[j]=true;
				}
			}
		}
		char[]c=new char[62];
		for(int j=48;j<=57;j++){
			c[j-48]=(char) j;
		}
		for(int j=65;j<=90;j++){
			c[j-55]=(char) j;
		}
		for(int j=97;j<=122;j++){
			c[j-61]=(char) j;
		}
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			int[]f=new int[62];
			String s=bf.readLine();
			String r="";
			for(int j=0;j<s.length();j++){
				int ch=s.charAt(j);
				if(ch<=57)
					f[ch-48]++;
				else
					if(ch<=90)
						f[ch-55]++;
					else
						f[ch-61]++;
			}
			for(int j=0;j<f.length;j++){
				if(!p[f[j]]){
					r+=c[j];
				}
			}
			if(r.length()==0)
				r="empty";
			System.out.println("Case "+(i+1)+": "+r);
		}
		bf.close();
	}
	
	public static boolean prime(int x){
		if(x==2 || x==3)
			return true;
		if(x<1 || x%2==0 || x%3==0)
			return false;
		for(int i=5;i*i<=x;i+=6){
			if(x%(i)==0 || x%(i+2)==0)
				return false;
		}
		return true;
	}
}
