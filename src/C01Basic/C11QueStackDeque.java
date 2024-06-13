package C01Basic;


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueStackDeque {
    public static void main(String[] args) {
        // 선입선출 구조.
        // Queue<Integer> myQue = new LinkedList<>();
        // myQue.add(10);
        // myQue.add(20);
        // myQue.add(30);
        // System.out.println(myQue.peek());	//10
        // System.out.println(myQue);	//10,20,30
        // System.out.println(myQue.poll());	//10
        // System.out.println(myQue);	//20,30

        // LinkedList와 ArrayList 비교
        // 앞뒤 요소간의 연결성을 갖고 있어서!
        //         -> 만약 중간에 데이터를 삽입하게 될 때, arraylist보다 최적화가 되어있어서.
        //         -> 단, index로 조회할 때 최적화가 굉장히 떨어져 있다.
        // LinkedList의 add
        // long startTime = System.currentTimeMillis();
        // 	LinkedList<Integer> list1 = new LinkedList<>();
        // 	for (int i = 0; i < 10000; i++) {
        // 		list1.add(0, 10);
        // 	}
        // // 	long endTime = System.currentTimeMillis();
        // // 	System.out.println("Linkedlist의 중간삽입 : " + (endTime - startTime));
        // //
        // // 	long startTime2 = System.currentTimeMillis();
        // 	ArrayList<Integer> list2 = new ArrayList<>();
        // 	for (int i = 0; i < 10000; i++) {
        // 		list2.add(0, 10);
        // 	}
        // // 	long endTime2 = System.currentTimeMillis();
        // // 	System.out.println("ArrayList의 중간삽입 : " + (endTime2 - startTime2));
        //
        // 	long startTime3 = System.currentTimeMillis();
        // 	for(int i=0; i<10000; i++){
        // 		list1.get(i);
        // 	}
        // 	long endTime3 = System.currentTimeMillis();
        // 	System.out.println("linkedList의 조회: " + (endTime3-startTime3));
        //
        // 	long startTime4 = System.currentTimeMillis();
        // 	for(int i=0; i<10000; i++){
        // 		list2.get(i);
        // 	}
        // 	long endTime4 = System.currentTimeMillis();
        // 	System.out.println("ArraayList의 조회: " + (endTime4-startTime4));

        // Queue<String> myQue = new LinkedList<>();
        // myQue.add("문서1");
        // myQue.add("문서2");
        // myQue.add("문서3");
        // while (!myQue.isEmpty()) {
        // 	System.out.println(myQue.poll());
        // }

        //	ArrayBlockingQueue : 길이 제한 큐 : 빈번하게 사용하지는 않는 것 같음
        // 	Queue<String> que = new ArrayBlockingQueue<>(3);
        //	add를 사용하면 길이제한 초과시 예외 발생
        //	offer
        // 	que.add("10");
        // 	que.add("20");
        // 	que.add("30");
        // // 	que.add("40");
        // 	que.offer("10");
        // 	que.offer("20");
        // 	que.offer("30");
        // 	que.offer("40");
        // 	System.out.println(que);

        //	우선 순위 큐 : 데이터를 꺼낼 때 정렬된 데이터 pop : 빈번하게 사용하니, 연습 많이 하기
        //  우선순위큐 (pq)는 heep 자료구조로 되어있음.
        //	  > 오름차순이 기본정렬
        //        >> PriorityQueue<>(요자리에) 아무것도 안 넎으면 오름차순이 기본 정렬
        // 	Queue<Integer> pq = new PriorityQueue<>();
        // 	pq.add(30);
        // 	pq.add(20);
        // 	pq.add(10);
        // 	pq.add(40);
        // 	pq.add(50);
        // 	System.out.println(pq);
        //
        // 	// System.out.println(pq.poll());
        // 	// System.out.println(pq.poll());
        // 	// System.out.println(pq.poll());
        // 	// System.out.println(pq.poll());
        // 	// System.out.println(pq.poll());
        //
        // 	while (!pq.isEmpty()) {
        // 		System.out.println(pq.poll());
        // 	}

        // 프로그래머스) 더 맵게
        // 핵심 : 특정 문자들을 꺼내고 재 조립해 작은 숫자들을 꺼내고 재조립
        // pq는 가장 작은숫자를 최적화해서 꺼낼 수 있음.
//        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int K = 7;
//        int answer = 0;
//
//        Queue<Integer> pq = new PriorityQueue<>();
//        for (int i : scoville) {
//            pq.add(i);
//        }
//
//        while (pq.peek() < K) {
//            if(pq.size() == 1) answer =  -1;
//            int first = pq.poll();
//            int second = pq.poll();
//
//            pq.add(first + (second * 2));
//            answer++;
//        }

//        stack // 후입선출(Last In First Out) 개념
//        Stack<Integer> st1 = new Stack<>();
//        st1.push(10);
//        st1.push(20);
//        st1.push(30);
//        System.out.println(st1);
////        pop : 스택에서 요소를 제거 후 해당 요소 반환
//        System.out.println(st1.pop());
//        System.out.println(st1.peek()); // 20
//        System.out.println(st1.size());
//        System.out.println(st1.isEmpty());

//        String 객체 5개 정도 Stack 추가 후에 while문을 통해 출력
//        Stack<String> st1 = new Stack<>();
//        st1.push("a1");
//        st1.push("a2");
//        st1.push("a3");
//        st1.push("a4");
//        st1.push("a5");
//
//        while (!st1.isEmpty()) { // 비어있을 때 스탑!
//            System.out.println(st1.pop()); // 맨 뒤에있는거 꺼내기
//        }

//        같은 숫자는 싫어 : 프로그래머스
//        int[] arr = {1,1,3,3,0,1,1};
//        Stack<Integer> st2 = new Stack<>();
//
//        for (int a : arr) {
//            if (st2.isEmpty()){
//                st2.push(a);
//            }else{
//                if(st2.peek() != a){
//                    st2.push(a);
//                }
//            }
//        }
//
//        int[] answer = new int[st2.size()];
//        for (int i = answer.length; i > 0; i--) {
//            answer[i-1] = st2.pop();
//        }


//        올바른 괄호 : 프로그래머스
//        String s = "())"; // "(())()" ")()(" "(()("
//        Stack<String> st1 = new Stack<>();
//        String[] strArr = s.split("");
////        Arrays.stream(strArr).forEach(st1 :: push);
//        boolean answer = true;
//        for (String a : strArr) {
//            if (a.equals("(")) {
//                st1.push("(");
//            } else if (a.equals(")")) {
//                if (st1.isEmpty()) {
//                    break;
//                }
//                st1.pop();
//            }
//        }
//        System.out.println(st1.isEmpty());

        Deque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(10);
        d1.addLast(20);
        System.out.println(d1);

        d1.addFirst(30);
        d1.addFirst(40);
        System.out.println(d1); // 40 30 10 20
        System.out.println(d1.peekFirst()); // 40
        System.out.println(d1.peekLast()); // 20
        System.out.println(d1.pollFirst()); // 40 >> poll
        System.out.println(d1.pollLast()); // 20 >> pop




    }
}
