package v_130;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVA13031 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++){
			int n=Integer.parseInt(bf.readLine());
			TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
			long c=0;
			for(int j=0;j<n;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				if(map.containsKey(y))
					map.put(y, map.get(y)+x);
				else
					map.put(y, x);
				c+=x;
			}
			long max=0;
			for(Entry e : map.entrySet()){
				if(c*(Integer)e.getKey()>max)
					max=c*(Integer)e.getKey();
				c-=(Integer)e.getValue();
			}
			System.out.println("Case "+i+": "+max);
		}
	}
}