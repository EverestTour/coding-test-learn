import java.io.*;
import java.util.*;

/*

    제목: N과 M (6)
    링크: https://www.acmicpc.net/problem/15655

    풀이:
    - 입력으로 주어진 수를 먼저 오름차순 정렬
    - 백트래킹으로 이전에 고른 위치보다 뒤에 있는 수만 선택하여 중복 없는 조합 생성
    - 정렬된 배열에서 앞에서부터 고르므로 사전 순으로 증가하는 순서로 출력 가능
 */

class Main {
    static int n;
    static int m;
    static int[] numbers;
    static int[] selected;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[n];
        selected = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        dfs(0, 0);

        System.out.print(answer);
    }

    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                if (i > 0) {
                    answer.append(' ');
                }
                answer.append(selected[i]);
            }
            answer.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = numbers[i];
            dfs(i + 1, depth + 1);
        }
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer = 0;
        private int length = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (pointer >= length) {
                length = in.read(buffer);
                pointer = 0;

                if (length <= 0) {
                    return -1;
                }
            }

            return buffer[pointer++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int value = 0;

            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value;
        }
    }
}
