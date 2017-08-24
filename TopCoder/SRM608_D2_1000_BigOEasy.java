package topcoder;

import java.util.ArrayList;

public class SRM608_D2_1000_BigOEasy {
	public static void main(String[] args) {
		String [] a={"NYNYN",
				 "NNYNY",
				 "YNNNN",
				 "NNNNN",
				 "YNNNN"};
		
		System.out.println(isBounded(a));
	}
	
	public static String isBounded(String[] graph){
		int n=graph.length;
		boolean [][] reach=new boolean [n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(graph[i].charAt(j)=='Y')
					reach[i][j]=true;
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					reach[i][j] |=(reach[i][k] && reach[k][j]);
		boolean bounded=true;
		for(int i=0;i<n;i++){
			int cnt=0;
			for(int j=0;j<n;j++)
				if(reach[i][j] && reach[j][i] && graph[i].charAt(j)=='Y')
					cnt++;
			if(cnt>1)
				bounded=false;
		}
		
		return bounded? "Bounded" : "Unbounded";
	}
}
