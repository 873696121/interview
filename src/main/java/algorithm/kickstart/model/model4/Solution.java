package algorithm.kickstart.model.model4;

import java.io.*;
import java.util.*;

public class Solution {
	public static void solve(IO io) {
		int a = io.getInt();
		int b = io.getInt();
		int count = 0;
		for (int i = a; i <= b; i++) {
			if (pro(i) % sum(i) == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		IO io = new IO();
		int t = io.getInt();
		for (int testIndex = 0; testIndex < t; testIndex++) {
			System.out.print("Case #" + (testIndex + 1) + ": ");
			solve(io);
		}
		io.close();
	}
	
	public static int sum(int x) {
		int s = 0;
		while (x > 0) {
			s += x % 10;
			x /= 10;
		}
		return s;
	}
	
	public static int pro(int x) {
		int s = 1;
		while (x > 0) {
			s *= x % 10;
			x /= 10;
		}
		return s;
	}

	static class IO extends PrintWriter {

		public IO() {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(System.in));
		}

		public IO(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public IO(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}
}
