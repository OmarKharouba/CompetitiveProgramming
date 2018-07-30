package v_005;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class UVA514 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			while(true){
				String s=bf.readLine();
				if(s.equals("0"))
					break;
				String[]sa=s.split(" ");
				int[]a=new int[n];
				Stack<Integer> st1=new Stack<Integer>();
				Stack<Integer> st2=new Stack<Integer>();
				for(int i=0;i<n;i++){
					a[i]=Integer.parseInt(sa[i]);
					st1.push(n-i);
				}
				boolean flag=true;
				for(int i=0;i<n;i++){
					while(!st1.isEmpty() && st1.peek()<=a[i]){
						st2.push(st1.pop());
					}
					if(st2.isEmpty() || st2.pop()!=a[i]){
						flag=false;
					}
				}
				System.out.println((flag)? "Yes" : "No");
			}
			System.out.println();
		}
	}
}
