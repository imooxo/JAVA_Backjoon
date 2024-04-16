package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjon_17298 {
    public static void main(String[] args) throws IOException {
    // 스택으로 오름차순 수열 만들기
    /*
    수열을 입력 받고 각 수에 해당하는 오큰수를 출력해야하는 문제
    수열 A의 크기가 범위가 매우 크기 때문에 반복문을 풀 경우 시간초과가 발생함
    즉 스택을 활용해야함
    */
    /*
    1) 스택에 다음 인덱스를 대입하기 전 A[stack.peek()]와 A[다음 인덱스]를 비교하고
        A[다음 인덱스]가 클 경우에는 A[stack.pop()] = A[다음 인덱스]이 된다. (pop하면 동시게 값 저장)
    2) 위 과정이 종료되면 push를 한다. 배열을 돌며 위 과정을 반복한다.
    3) 다 돌고 나서 스택에 남아 있는 인덱스는 모두 오큰수가 없다. -1을 가진다.
       스택에 있는 값을 pop하면서 배열에 -1을 저장
    */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt((br.readLine())); // 수열의 개수
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        // 수열 저장
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
			//스택이 비어있지 않고
			//arr[현재 스택 top에 있는 수] < arr[push할 수]라면
            while (!stack.empty() && stack.peek() < arr[i] ) { //스택에 있는 값이랑 다음 인덱스값 비교
                // 스택에 담아둔 값을 빼지 않고 peek을 활용
                // 원래있는 값에서 현재 있는 인덱스로 값을 변환
                arr[stack.pop()] = arr[i]; // 오큰수는 arr[i] //pop()하면서 배열의 오큰수 저장
            }
            stack.push(i);
        }
        // 현재 스택에 있는 수들은 모든 오큰수가 없는 수
        // 스택에 있는 배열 인덱스 값에 -1 저장
        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);

    }//main
}//class
