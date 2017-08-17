import java.io.*;
import java.util.*;
public class WPUZZLES {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		long time = System.currentTimeMillis();
		int t=sc.nextInt();
		while(t-->0){
			curIdx=0;
			int l=sc.nextInt();
			int w=sc.nextInt();
			int p=sc.nextInt();
			StringBuilder txt=new StringBuilder();
			char [][] a=new char [l][w];
			for(int i=0;i<l;i++){
				String line=sc.next();
				a[i]=line.toCharArray();
				txt.append(line);
			}
			int [] patLen=new int [p];
			init(txt.toString(), p, Math.max(l, w));
			for(int i=0;i<p;i++){
				String pat=sc.next();
				patLen[i]=pat.length();
				insert(pat.toCharArray(), i);
			}
			buildF();
			int [] x=new int [p];
			int [] y=new int [p];
			int [] d=new int [p];
			
			//left -> right
			ArrayList<Integer> [] d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					int matchY=j%w;
					if(matchY-patLen[i]+1>=0){						
						int pos=j-patLen[i]+1;
						x[i]=pos/w;
						y[i]=pos%w;
						d[i]=2;
					}
				}
			}
			//right -> left
			txt=new StringBuilder();
			for(int i=0;i<l;i++)
				for(int j=w-1;j>=0;j--)
					txt.append(a[i][j]);
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					int matchY=j%w;
					if(matchY-patLen[i]+1>=0){			
						int pos=j-patLen[i]+1;
						x[i]=pos/w;
						y[i]=w-1-pos%w;
						d[i]=6;
					}
				}
			}
			//bottom -> up
			txt=new StringBuilder();
			for(int i=0;i<w;i++)
				for(int j=l-1;j>=0;j--)
					txt.append(a[j][i]);
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					int matchY=j%l;
					if(matchY-patLen[i]+1>=0){			
						int pos=j-patLen[i]+1;
						y[i]=pos/l;
						x[i]=l-1-pos%l;
						d[i]=0;
					}
				}
			}
			//up -> bottom
			txt=new StringBuilder();
			for(int i=0;i<w;i++)
				for(int j=0;j<l;j++)
					txt.append(a[j][i]);
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					int matchY=j%l;
					if(matchY-patLen[i]+1>=0){			
						int pos=j-patLen[i]+1;
						y[i]=pos/l;
						x[i]=pos%l;
						d[i]=4;
					}
				}
			}
			// diagonal 1
			txt=new StringBuilder();
			ArrayList<Integer> xpos=new ArrayList<Integer>();
			ArrayList<Integer> ypos=new ArrayList<Integer>();
			for(int dia=0;dia<w+l-1;dia++){
				for(int i=l-1;i>=0;i--){
					int j=dia-i;
					if(j<0 || j>=w)
						continue;
					xpos.add(i);
					ypos.add(j);
					txt.append(a[i][j]);
				}
				txt.append('$');
				xpos.add(0);
				ypos.add(0);
			}
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					j-=patLen[i]-1;
					x[i]=xpos.get(j);
					y[i]=ypos.get(j);
					d[i]=1;
				}
			}
			// diagonal 2
			txt=new StringBuilder();
			xpos.clear();
			ypos.clear();
			for(int dia=0;dia<w+l-1;dia++){
				for(int i=l-1;i>=0;i--){
					int j=w-1-(dia-i);
					if(j<0 || j>=w)
						continue;
					xpos.add(i);
					ypos.add(j);
					txt.append(a[i][j]);
				}
				txt.append('$');
				xpos.add(0);
				ypos.add(0);
			}
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					j-=patLen[i]-1;
					x[i]=xpos.get(j);
					y[i]=ypos.get(j);
					d[i]=7;
				}
			}
			// diagonal 3
			txt=new StringBuilder();
			xpos.clear();
			ypos.clear();
			for(int dia=0;dia<w+l-1;dia++){
				for(int i=0;i<l;i++){
					int j=w-1-(dia-i);
					if(j<0 || j>=w)
						continue;
					xpos.add(i);
					ypos.add(j);
					txt.append(a[i][j]);
				}
				txt.append('$');
				xpos.add(0);
				ypos.add(0);
			}
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					j-=patLen[i]-1;
					x[i]=xpos.get(j);
					y[i]=ypos.get(j);
					d[i]=3;
				}
			}
			// diagonal 4
			txt=new StringBuilder();
			xpos.clear();
			ypos.clear();
			for(int dia=0;dia<w+l-1;dia++){
				for(int i=0;i<l;i++){
					int j=dia-i;
					if(j<0 || j>=w)
						continue;
					xpos.add(i);
					ypos.add(j);
					txt.append(a[i][j]);
				}
				txt.append('$');
				xpos.add(0);
				ypos.add(0);
			}
			str=txt.toString().toCharArray();
			d1=match();
			for(int i=0;i<p;i++){
				for(int j : d1[i]){
					j-=patLen[i]-1;
					x[i]=xpos.get(j);
					y[i]=ypos.get(j);
					d[i]=5;
				}
			}
			for(int i=0;i<p;i++)
				pw.println(x[i]+" "+y[i]+" "+(char)('A'+d[i]));
			if(t>0)
				pw.println();
		}
		pw.flush();
		pw.close();
		System.err.println(System.currentTimeMillis()-time+" ms");
	}
	
	static int max,n,curIdx;
	static char [] str;
	static ArrayList<int []> child;
	static ArrayList<ArrayList<Character>> childChars;
	static ArrayList<ArrayList<Integer>> patIdx;
	static int [] F;
	
	static void init(String txt, int cntP, int maxL){
		str=txt.toCharArray();
		n=cntP;
		max=n*maxL+1;
		child=new ArrayList<int[]>();
		childChars=new ArrayList<ArrayList<Character>>();
		patIdx=new ArrayList<ArrayList<Integer>>();
		F=new int [max];
		addNode();
	}
	
	static ArrayList<Integer> [] match(){
		ArrayList<Integer> [] ret=new ArrayList[n];
		for(int i=0;i<n;i++)
			ret[i]=new ArrayList<Integer>();
		int f=0;
		int idx=0;
		for(char c : str){
			while(child.get(f)[c]==-1)
				f=F[f];
			f=child.get(f)[c];
			for(int j : patIdx.get(f))
				ret[j].add(idx);
			// last position of every occurence of the pattern
			idx++;
		}
		return ret;
	}
	
	static void buildF(){
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<91;i++){
			if(child.get(0)[i]==-1)
				child.get(0)[i]=0;
			else{
				F[child.get(0)[i]]=0;
				q.add(child.get(0)[i]);
			}
		}
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int c : childChars.get(cur)){
				int nxt=child.get(cur)[c];
				q.add(nxt);
				int f=F[cur];
				while(child.get(f)[c]==-1)
					f=F[f];
				f=child.get(f)[c];
				F[nxt]=f;
				patIdx.get(nxt).addAll(patIdx.get(f));
			}
		}
	}
	
	static int addNode(){
		int [] a=new int [91];
		Arrays.fill(a, -1);
		child.add(a);
		patIdx.add(new ArrayList<Integer>());
		childChars.add(new ArrayList<Character>());
		return curIdx++;
	}
	
	static void insert(char [] s,int idx){
		int cur=0;
		for(char c : s){
			if(child.get(cur)[c]==-1){
				child.get(cur)[c]=addNode();
				childChars.get(cur).add(c);
			}
			cur=child.get(cur)[c];
		}
		patIdx.get(cur).add(idx);
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("in6")));
			} catch (FileNotFoundException e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}