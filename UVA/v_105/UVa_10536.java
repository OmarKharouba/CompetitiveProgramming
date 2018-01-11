import java.io.*;
import java.util.*;

public class UVa_10536 {
	/*
	 * for a state to be a winning state, there must be a move that leads to a
	 * losing state, otherwise it is a losing state, so we can use dp to know
	 * whether a state is winning or losing, with a base case when there is no
	 * more possible moves(which is a winning state), to make the implementation
	 * easier, using a mask of 16 bits to represent the grid and representing
	 * possible moves will make it easy to check the validity of a move
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		moves = new ArrayList<Integer>();
		for (int i = 0; i < 16; i++)
			moves.add(1 << i);
		for (int i = 0; i < 4; i++) {
			moves.add((1 << i) | (1 << (i + 4)));
			moves.add((1 << i) | (1 << (i + 4)) | (1 << (i + 8)));
		}
		for (int i = 12; i < 16; i++) {
			moves.add((1 << i) | (1 << (i - 4)));
			moves.add((1 << i) | (1 << (i - 4)) | (1 << (i - 8)));
		}
		for (int i = 0; i < 16; i += 4) {
			moves.add((1 << i) | (1 << (i + 1)));
			moves.add((1 << i) | (1 << (i + 1)) | (1 << (i + 2)));
		}
		for (int i = 3; i < 16; i += 4) {
			moves.add((1 << i) | (1 << (i - 1)));
			moves.add((1 << i) | (1 << (i - 1)) | (1 << (i - 2)));
		}
		win = new Boolean[1 << 16];
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = 0;
			for (int i = 0; i < 4; i++) {
				String s = sc.next();
				for (int j = 0; j < 4; j++)
					if (s.charAt(j) == 'X')
						n |= (1 << (i * 4 + j));
			}
			pw.println(dp(n) ? "WINNING" : "LOSING");
		}

		pw.flush();
		pw.close();
	}

	static ArrayList<Integer> moves;
	static Boolean[] win;

	static boolean dp(int msk) {
		if (Integer.bitCount(msk) == 16)
			return true;
		if (win[msk] != null)
			return win[msk];
		boolean winning = false;
		for (int x : moves) {
			if ((msk & x) == 0 && !dp(msk | x))
				winning = true;
		}
		return win[msk] = winning;
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}