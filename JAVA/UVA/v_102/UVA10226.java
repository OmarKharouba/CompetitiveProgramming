package v_102;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
public class UVA10226 {
	public static void main(String[]args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		br.readLine();
		for(int i=0;i<t;i++){
			TreeMap<String,Integer> map = new TreeMap<String, Integer>();
			String s="";
			double total=0;
			if(i<t-1){
				while(true){
					s=br.readLine();
					if(s.length()==0)
						break;
					total++;
					if(map.containsKey(s))
						map.put(s, map.get(s)+1);
					else
						map.put(s,1);
				}
			}else{
				while((s=br.readLine())!=null){
					total++;
					if(map.containsKey(s))
						map.put(s, map.get(s)+1);
					else
						map.put(s,1);
				}
			}
			DecimalFormat df=new DecimalFormat("#0.0000");
			for(java.util.Map.Entry<String, Integer> e:map.entrySet()){
				System.out.println(e.getKey()+" "+df.format(e.getValue()*100/total));
			}
			if(i<t-1)
				System.out.println();
		}
	}
	static class pair{
		String s;
		int f;
		pair(String s,int f){
			this.s=s;
			this.f=f;
		}
	}
}