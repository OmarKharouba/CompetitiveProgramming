package v_103;

import java.util.Scanner;

public class UVA10368 {
	public static void main(String[] args) throws Throwable{
		Scanner sc=new Scanner(System.in);
		while(true){
			long x=sc.nextLong();
			long y=sc.nextLong();
			if(x==0 && y==0)
				break;
			
			int turn=0;
			
			while(true){
				if(x>y){
					long tmp=x;
					x=y;
					y=tmp;
				}
				if(x==0){
					turn=1-turn;
					break;
				}
				if(x*2<=y)
					break;
				y-=x;
				turn=1-turn;
			}
			
			
			System.out.println((turn==0)? "Stan wins" : "Ollie wins");
		}
		sc.close();
	}

}
