package v_004;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class UVA497 {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br=new BufferedReader(new FileReader(new File("test.in")));
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=Integer.parseInt(br.readLine());
		br.readLine();
		while(t-->0){
			ArrayList<Integer> a=new ArrayList<Integer>();
			while(br.ready()){
				String s=br.readLine();
				if(s.length()==0)
					break;
				a.add(Integer.parseInt(s));
			}
			
			int n=a.size();
			int [] p=new int [n];
			int [] idx=new int [n];
			ArrayList<Integer> l=new ArrayList<Integer>();
			int lis=0;
			int last=-1;
			
			for(int i=0;i<n;i++){
				int pos=Collections.binarySearch(l, a.get(i));
				if(pos<0)
					pos=-(pos+1);
				if(pos>=l.size())
					l.add(a.get(i));
				else
					l.set(pos, a.get(i));
				
				if(pos+1>lis){
					lis=pos+1;
					last=i;
				}
				idx[pos]=i;
				p[i]=pos>0? idx[pos-1] : -1;
			}
			Stack<Integer> stack=new Stack<Integer>();
			while(last!=-1){
				stack.push(a.get(last));
				last=p[last];
			}
			pw.println("Max hits: "+lis);
			while (!stack.isEmpty())
				pw.println(stack.pop());
			if(t>0)
				pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	
}
