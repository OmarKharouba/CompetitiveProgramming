package v_103;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class UVA10370 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		for(int i=0;i<c;i++){
			int n=sc.nextInt();
			int[]a=new int[n];
			double sum=0;
			for(int j=0;j<n;j++){
				a[j]=sc.nextInt();
				sum+=a[j];
			}
			double av=sum/n;
			double count=0;
			for(int j=0;j<n;j++){
				if(a[j]>av)
					count++;
			}
			double p=(count/n)*100.0;
			DecimalFormat df = new DecimalFormat("#0.000");
			System.out.println(df.format(p)+"%");
		}
		sc.close();
	}
}

