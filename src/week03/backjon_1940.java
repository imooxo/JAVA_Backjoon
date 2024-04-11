package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjon_1940 {
    public static void main(String[] args) throws IOException {
        // 구간 합 구하기
        /* 투포인터 이동 원칙
        A[i] + A[j] > M : j--; // 번호의 합이 M보다 크므로 큰번호 index를 내린다.
        A[i] + A[j] < M : i++; // 번호의 합이 M보다 작으므로 번호 index를 올린다.
        A[i] + A[j] == M : i++; i--; count++; // 양쪽 포인터를 모두 이동시키고 count를 증가시킨다.
        */
        /*
        재료들의 고유번호가 저장된 배열 arr을 오름차순으로 정렬한다.  // Arrays.sort(arr)
        변수 start, end, count를 각각 0, N-1, 0으로 초기화한다. start와 end는 각각 배열의 처음 인덱스와 마지막 인덱스로 초기화한다.
        start < end 동안 while문을 돈다. (두 포인터가 좁혀지다가 같아지는 순간에 반목문 종료)
            arr [start] + arr [end]를 변수 (sum)에 저장한다.
            sum > M 종로포인터(end)를 왼쪽으로 이동한다. (= 더한 두수 중에 큰 수의 값을 줄인다.)
            sum < M 시작포인터(start)를 오른쪽으로 이동한다. (= 더한 두수 중에서 작은 수의 값을 늘린다.)
            sum == M이면 count를 증가시키고 start는 증가시키고, end는 감소시킨다.
        count를 출력한다.
        */
        /*
        N(재료의 개수 (6)), M(갑옷이 되는 번호)
        for (N만큼 반복)
        {
            재료 배열 정렬하기
        } 재료 배열 정렬하기
        while (i < j) {  // 투포인터 실행
            if(재료 합 < M) 작은 번호 재료를 한칸 위로 변경하기
            else if(재료 합 > M) 큰 번호 재료를 한칸 아래로 변경하기
            else 경우의 수 증가, 양쪽 index 각각 변경하기
            }
            count 출력
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        // 재료들 고유 번호 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 배열 오름차순 정렬
        int start = 0; // 시작 포인터 - 작은값 인덱스 //arr[0] -> Min
        int end = N - 1; // 종료 포인터 - 큰 값 인덱스 //arr[N-1]
        int count = 0;

        while (start < end) { //양쪽 포인터가 좁혀지다가 같아지기 전까지 반복
            int sum = arr[start] + arr[end];
            if (sum > M) { // sum이 크다면 종료 포인터를 왼쪽으로 이동
                end--;
            } else if (sum < M) { // sum이 작다면 시작포인터를 오른쪽으로 이동
                start++;
            } else { // sum == M이면 count증가 시작포인터와 종료포인터 모두 이동
                count++; // 경우의 수
                end--;
                start++;
            }
        }
        System.out.println(count);
    } // main
} // class
