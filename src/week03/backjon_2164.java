package week03;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjon_2164 {
    public static void main(String[] args) throws IOException {
    // 카드 게임
    /*
    N(카드의 개수) myQueue(카드 저장 자료 구조)
    for(카드의 개수만큼 반복)
    {
        큐에 카드 저장하기
    }
    while (카드가 1장 남을 때까지)
    {
        맨 위의 카드를 버림: poll()
        맨 위의 카드를 가장 아래의 카드 밑으로 이동: poll() -> add()
    }
    마지막으로 남은 카드 출력
     */
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for (int i = 0; i <= N; i++){
            myQueue.add(i);
        }

        while(myQueue.size() > 1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    } // main
} // class
