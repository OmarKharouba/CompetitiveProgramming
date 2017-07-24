package v_130;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
public class UVA13004 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		PrintWriter pw=new PrintWriter(System.out, true);
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			int[] in=new int[s.length()];
			for(int i=0;i<in.length;i++){
				in[i]=Integer.parseInt(s.charAt(i)+"");
			}
			int[] c=new int[10];
			for(int i=0;i<10;i++){
				c[i]=2;
			}
			int[]out=new int[in.length];
			boolean enter =true;
			for(int i=0;i<in.length && enter;i++){
				boolean flag=true;
				for(int j=in[i];j>=0 && flag;j--){
					if(c[j]>0){
						out[i]=j;
						c[j]--;
						flag=false;
						if(j<in[i]){
							i++;
							for(int k=9;k>=0 && i<in.length;k--){
								while(c[k]>0 && i<in.length){
									out[i]=k;
									i++;
									c[k]--;
								}
							}
							enter=false;
							break;
						}
					}
				}
				if(flag){
					for(int j=i-1;j>=0;j--){
						c[in[j]]++;
						boolean f=true;
						for(int k=in[j]-1;k>=0 && f;k--){
							if(c[k]>0){
								out[j]=k;
								c[k]--;
								f=false;
							}
						}
						if(!f){
							j++;
							for(int k=9;k>=0 && j<in.length;k--){
								while(c[k]>0 && j<in.length){
									out[j]=k;
									j++;
									c[k]--;
								}
							}
							enter=false;
							break;
						}
					}
				}
			}
			for(int i=0;i<out.length;i++){
				if(i==0 && out[i]==0){
					
				}else
					System.out.print(out[i]);
			}
			System.out.println();
		}
	}
}
