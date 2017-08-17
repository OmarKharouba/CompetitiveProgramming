import java.util.Random;


public class test {
	public static void main(String[] args) {
		System.out.println(1);
		int n=new Random().nextInt(50)+1;
		System.out.println(n);
		int [] a=new int [n];
		int [] b=new int [n];
		int [] c=new int [n];
		for(int i=0;i<n;i++)
			a[i]=b[i]=c[i]=i+1;
		shuffle(a);
		shuffle(b);
		shuffle(c);
		for(int i=0;i<n;i++)
			System.out.println(a[i]+" "+b[i]+" "+c[i]);
	}
	
	static void shuffle(int[] a)
	{
		int n = a.length;
		for(int i = 0; i < n; i++)
		{
			int r = i + (int)(Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}
}
