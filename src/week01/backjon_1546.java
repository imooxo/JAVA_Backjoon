package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjon_1546 {
    /*
    세준이의 모든 점수를 배열에 저장하고, 가장 큰 값을 찾은 후 배열의 모든 원소를 수식에 대입해서 값을 변경하면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //입력 개수

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int max = -1;
        double sum = 0.0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(value > max) {
                max = value;
            }

            sum += value;
        }

        System.out.println(((sum / max) * 100.0) / N);
    }
}
