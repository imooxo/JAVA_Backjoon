package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjon_1253 {
    public static void main(String[] args) throws IOException {
        // 투 포인터 (배열 또는 리스트에서 두개의 포인터의 위치를 기록해가며 원하는 결과를 찾아내는 알고리즘)
        // 다른 두 수의 합으로 표현되는 수 찾기 - 정렬된 배열에서 처음 인덱스와 마지막인덱스를 두 개의 포인터가 가리키는 경우
        /*
        - N개의 입력받은 수를 배열 arr에 저장하고 오름차순으로 정렬한다. Arrays.sort(arr)
        - 좋다인 수를 셀 변수 count를 초기화한다.
        - N번 반복
            변수 left와 right를 각각 0, N-1로 초기화한다. left는 배열의 처음 인덱스, right는 배열의 마지막 인덱스로 초기화한 것이다.
            left<right인 동안 while문을 돈다. (두 포인터가 같아지는 순간 while문 종료 )
                arr[left] + arr[right]를 변수 num에 저장한다
                num>arr[i]라면 right포인터를 왼쪽으로 이동한다. (더한 두수중에서 큰값을 줄인다.)
                num<arr[i]라면 left포인터를 오른쪽으로 이동한다. (더한 두수중에서 작은 값을 늘린다.)
                num==arr[i]라면 left나 right가 i와 같다면 각각 left를 증가시키거나 right를 감소시킨다. 둘 다 아니라면 count를 증가시키고 while문을 종료한다.
       - N개의 수 탐색이 모두 끝나면 count를 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int count = 0; // 좋다에 해당하는 수 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N개의 수 입력 받아 저장
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 투포인터 사용을 위해 오름차순 정렬
        for(int i = 0; i < N; i++) {
            int left = 0; // 왼쪽포인터 - 작은값 인덱스
            int right = N - 1; // 오른쪽포인터 - 큰값 인덱스

            while (left < right) { // 양쪽 포인터가 좁혀지다가 같아지기전까지 반복
                long num = arr[left] + arr[right];

                // num이 크다면 right 포인터를 왼쪽으로 이동
                if (num > arr[i]) right--;

                    // num이 작다면 left 포인터를 오른쪽으로 이동
                else if (num < arr[i]) left++;

                else { // num == arr[i]이면
                    if (left == i) left++; // left와 같다면 오른쪽으로 이동
                    else if (right == i) right--; // right와 같다면 왼쪽으로 이동

                        // 자기 자신을 제외하고 다른 두수의 합일 때, 좋다(GOOD)인 수로 판정 - 반복문 종료
                    else {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    } // main
} //class
