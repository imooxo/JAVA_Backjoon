package week03;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class backjon_12891 {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;
    public static void main(String[] args) throws IOException {
    // 슬라이딩 윈도우(문자열) - 2개의 포인터로 "범위"를 지정한 다음 범위를 유지한채로 이동하며 문제를 해결
    /* 예제입력1
     98 //DNA 문자열의 길이, 부분 문자열의 길이
     CCTGGATTG //DNA 문자열
     2 0 1 1 //부분 문자열에 포함돼야 함 {A,C,G,T}의 최소개수
     0 // 예제출력
     */

    /*
    // 데이터 저장
    S(문자열 크기) P(부분 문자열의 크기)
    A(문자열 데이터)
    checkArr(비밀번호 체크 배열)

    // 변수 선언
    myArr(현재 상태 배열)
    checkSecret(몇개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
    P 범위(0 ~ P - 1)만큼 5배열에 적용하고, 유효한 비밀번호 인지 판단하기
    for (i를 P에서 5까지 반복)
    {
        j 선언 (i - P)
        // 이부분은 함수로 별도 구현하기
    */

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); //데이터 문자열의 크기
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
        int Result = 0; //정답 값
        //int checkArr[] = new int[4]; // 비밀번호 체크 배열 //문제의 조건
        checkArr = new int[4];
        //int myArr[] = new int[4]; // 현재 상태의 배열
        myArr = new int[4];
        char A[] = new char[S]; // 들어오는 전체 DNA 문자열
        //int checkSecret = 0; //현재 4개중 비밀번호의 요건을 요구하는 변수 //정답인 4가 될 시 count++
        checkSecret = 0;

        A = bf.readLine().toCharArray(); // A에 전체 문자열 받기
        st = new StringTokenizer(bf.readLine()); // 부분 문자열 받기 / {A,C,G,T}의 최소개수 받기
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken()); // 4개의 숫자 차례대로 가져옴
            if(checkArr[i] == 0) {  //만약에 0으로 들어온다면?
                checkSecret++; // 비밀번호를 체크하는 변수를 하나 올려주면됨
            }
        }
        // 초기 P부분 문자 처리
        for(int i =0; i < P; i++){ // 부분문자열 처음 받을때 세팅
            Add(A[i]); // Add변수에 주어진 전체배열에서의 첫번째 값을 현재상태배열에 넣어줌
        }
        if(checkSecret == 4) Result++;
        // 슬라이딩 윈도우
        for(int i = P; i < S; i++){
           int j = i - P; //i는 부분문자열에서의 가장 오른쪽 j는 부분 문자열에서 가장 왼쪽 /범위를 유지하면서 움직이기
            Add(A[i]); // 들어가기 /G
            Remove(A[j]);
            if(checkSecret == 4) Result++; // 부분문자열 이동할 때 마다 맞는지 확인하는 과정
        }

        System.out.println(Result);
        bf.close();

    } //main

    private static void Remove(char c) { //Remove 메소드
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--; //값이 충족이 되지 않으면 checkSecret 빼기
                myArr[0]--; // 배열에서도 빼기
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) { //Add 메소드
        switch (c) {
            case 'A':
                myArr[0]++; // 첫번째 인댁스 늘려주기
                if(myArr[0] == checkArr[0]) checkSecret++; //값이 같아 충족한다면 checkSecret 추가
                // >= 안쓰는 이유? 이미 만족했는데 크기가 크다고해서 또 하나 늘려주는것은 무의미하기 때문
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
} //class
