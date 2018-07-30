package v_104;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10483 {
	
	static class triple implements Comparable<triple>{
		double x;
		double y;
		double z;
		double sum;
		
		public triple(long x,long y,long z){
			this.x=x/100.0;
			this.y=y/100.0;
			this.z=z/100.0;
			this.sum=this.x+this.y+this.z;
		}

		
		public int compareTo(triple o) {
			if(this.sum<o.sum || (this.sum==o.sum && this.x<o.x))
				return -1;
			else
				return 1;
		}
		
		public String toString(){
			DecimalFormat df=new DecimalFormat("#0.00");
			String s=df.format(sum);
			String i=df.format(x);
			String j=df.format(y);
			String k=df.format(z);
			return (s+" = "+i+" + "+j+" + "+k+" = "+i+" * "+j+" * "+k);
		}
	}
	public static void main(String[]args)throws Throwable{
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out,true);
		long x=(int)(sc.nextDouble()*100);
		long y=(int)(sc.nextDouble()*100);
		ArrayList<triple> a=new ArrayList<triple>();
		for(long i=1;i<=y;i++)
			for(long j=i;i+j<=y;j++){
				long k=0;
				if(i*j!=10000)
					k=(10000L*(i+j))/(i*j-10000L);
				if(k>=j && i+j+k>=x && i+j+k<=y && i*j*k==10000*(i+j+k))
					a.add(new triple(i, j, k));
			}
		Collections.shuffle(a);
		Collections.sort(a);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<a.size();i++){
			sb.append(a.get(i)+"\n");
		}
		pw.print(sb);
		pw.flush();
		pw.close();
		sc.close();
	}
}
