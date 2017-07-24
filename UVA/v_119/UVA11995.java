package v_119;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
public class UVA11995 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			Stack<Integer> st=new Stack<Integer>();
			ArrayList<Integer> pq=new ArrayList<Integer>();
			int n=Integer.parseInt(s);
			int[] q=new int[n];
			int start=0,end=0;
			boolean sf=true,pf=true,qf=true;
			for(int i=0;i<n;i++){
				s=bf.readLine();
				String[]sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				if(x==1){
					st.push(y);
					int p=0;
					for(int k=0;k<pq.size() && pq.get(k)>y;k++){
						p++;
					}
					pq.add(p,y);
					q[end]=y;
					end++;
				}
				else{
					if(st.isEmpty() ||y!=st.pop())
						sf=false;
					if(pq.isEmpty() || y!=pq.remove(0))
						pf=false;
					if(start==end || y!=q[start])
						qf=false;
					start++;
				}
			}
			int cnt=0;
			if(sf)
				cnt++;
			if(pf)
				cnt++;
			if(qf)
				cnt++;
			System.out.println((cnt==0)? "impossible" : (cnt>1)? "not sure" : (sf)? "stack" : (qf)? "queue" : "priority queue");
		}
	}
}
