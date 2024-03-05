package algorithm.kickstart.model.model3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {
    FastScanner in;
    PrintWriter out;

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solveCase();

        out.close();
    }

    private void solveCase() {
        int t = in.nextInt();

        for (int caso = 1; caso <= t; caso++) {
            int n = in.nextInt();
            int k = in.nextInt();

            String s = in.next();

            int value = (int) IntStream.range(0, s.length() / 2).filter(idx -> s.charAt(idx) != s.charAt(s.length() - 1 - idx)).count();

            out.println("Case #" + caso + ": " + Math.abs(value - k));
        }
    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

}
