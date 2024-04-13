package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon_1874 {
    public static void main(String[] args) throws IOException {
        // 스택 수열 (스택으로 오름차순 수열하기)
        // BufferedReader + array
        /*

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력할 결과물 저장
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];

        int idx = 0;
        int start = 0;

        //N번 반복
        while(N-->0){
            int value = Integer.parseInt(br.readLine());
            
            if (value > start) {
                // start +1 부터 입력 받은 value까지 push를 진행
                for(int i = start+1; i <= value; i++) {
                    stack[idx] = i;
                    idx++;
                    sb.append("+").append("\n");
                }
                start = value; // 다음 push 할때의 오름차순을 유지하기 위한 변수 초기화
            }
            // top에 있는 원소가 입력받은 값과 다른 경우
            else if(stack[idx-1] != value){
                System.out.println("NO");
                System.exit(0);
                // return
            }

            idx--;
            sb.append("-").append(("\n"));
        }
        System.out.println(sb);

    } // main
} // class
