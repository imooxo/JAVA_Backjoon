package week01;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class backjon_1120 {
    /*
    문자열 B에서 문자열 A의 길이 만큼을 연속하게 잘라서 몇 개의 문자가 다른지 확인하여 그 개수의 리스트에 저장하면,
    그 리스트의 최솟값이 그대로 정답이다.
    왜냐하면 나머지 부분은 B와 동일하게 채워준다고 생각하면 되기 때문에 고려할 필요가 없다.
    */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        String C;
        ArrayList<Integer> list = new ArrayList<>();
        int cnt;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            cnt = 0;
            C = B.substring(i, i + A.length());
            for (int j = 0; j < A.length(); j++) {
                if (C.charAt(j) != A.charAt(j)) {
                    cnt++;
                }
            }
            list.add(cnt);
        }
        bw.write(String.valueOf(Collections.min(list)));
        bw.flush();
        bw.close();
        br.close();
    }
}
