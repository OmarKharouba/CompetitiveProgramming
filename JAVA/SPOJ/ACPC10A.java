
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ACPC10A {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		while(true){
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1]);
			int z=Integer.parseInt(sa[2]);
			if(x==0 && y==0 && z==0)
				break;
			int dif=y-x;
			if(z-y==dif)
				System.out.println("AP "+(z+dif));
			else
				System.out.println("GP "+((z*z)/y));
			s=bf.readLine();
		}
		bf.close();
	}

}